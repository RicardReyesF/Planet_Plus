package control;

import modelo.Productos;
import control.util.JsfUtil;
import control.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("productosController")
@SessionScoped
public class ProductosController implements Serializable {

    @EJB
    private control.ProductosFacade ejbFacade;
    private List<Productos> items = null;
    private List<Productos> itemseliminados = null;

    public List<Productos> getItemseliminados() {
        if (itemseliminados == null) {
            itemseliminados = ejbFacade.Consulta_inactivos();
        }
        return itemseliminados;
    }

    public void setItemseliminados(List<Productos> itemseliminados) {
        this.itemseliminados = itemseliminados;
    }
    private Productos selected;

    public ProductosController() {
    }

    public Productos getSelected() {
        return selected;
    }

    public void setSelected(Productos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProductosFacade getFacade() {
        return ejbFacade;
    }

    public Productos prepareCreate() {
        selected = new Productos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setStatus(1);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProductosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProductosUpdated"));
    }

    public void destroy() {
        selected.setStatus(0);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProductosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null;
            itemseliminados=null;// Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
     public void restaurar() {
        selected.setStatus(1);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PaisesDeleted"));
        //persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PaisesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null;
            itemseliminados = null;// Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Productos> getItems() {
        if (items == null) {
            items = ejbFacade.Consulta_activos();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Productos getProductos(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Productos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Productos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Productos.class)
    public static class ProductosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductosController controller = (ProductosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productosController");
            return controller.getProductos(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Productos) {
                Productos o = (Productos) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Productos.class.getName()});
                return null;
            }
        }

    }

}
