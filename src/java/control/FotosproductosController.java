package control;

import modelo.Fotosproductos;
import control.util.JsfUtil;
import control.util.JsfUtil.PersistAction;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.model.UploadedFile;

@Named("fotosproductosController")
@SessionScoped
public class FotosproductosController implements Serializable {

    @EJB
    private control.FotosproductosFacade ejbFacade;
    private List<Fotosproductos> items = null;
    private Fotosproductos selected;
    private UploadedFile foto;
    private String aux;

    public FotosproductosController() {
    }

    public Fotosproductos getSelected() {
        return selected;
    }

    public void setSelected(Fotosproductos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FotosproductosFacade getFacade() {
        return ejbFacade;
    }

    public Fotosproductos prepareCreate() {
        selected = new Fotosproductos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setStatus(1);
        selected.setRuta(aux);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FotosproductosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FotosproductosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FotosproductosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Fotosproductos> getItems() {
        if (items == null) {
            items = getFacade().findAll();
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

    public Fotosproductos getFotosproductos(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Fotosproductos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Fotosproductos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Fotosproductos.class)
    public static class FotosproductosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FotosproductosController controller = (FotosproductosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "fotosproductosController");
            return controller.getFotosproductos(getKey(value));
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
            if (object instanceof Fotosproductos) {
                Fotosproductos o = (Fotosproductos) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Fotosproductos.class.getName()});
                return null;
            }
        }

    }

    /**
     * @return the foto
     */
    public UploadedFile getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }

    /**
     * @return the aux
     */
    public String getAux() {
        return aux;
    }

    /**
     * @param aux the aux to set
     */
    public void setAux(String aux) {
        this.aux = aux;
    }

    public void Almacenafoto() {
        System.out.println("MIME TIPE: " + getFoto().getContentType());
        System.out.println("Tamaño: " + getFoto().getSize());
        System.out.println("Extensión PNG " + getFoto().getFileName().endsWith(".png"));
        System.out.println("Extensión JPG " + getFoto().getFileName().endsWith(".jpg"));
        System.out.println("Extensión JPEG " + getFoto().getFileName().endsWith(".jpeg"));
        System.out.println("Extensión GIF " + getFoto().getFileName().endsWith(".gif"));

//        if (getFoto().getFileName().endsWith(".png")
//                || getFoto().getFileName().endsWith(".jpg")
//                || getFoto().getFileName().endsWith(".jpeg")
//                || getFoto().getFileName().endsWith(".gif")) 
//        {
//            //insertar
//            if (SubirArchivo()) {
//                create();
//                aux = "";
//            }
//        } else {
//            FacesMessage mensaje = new FacesMessage("El archivo no es una imagen");
//            FacesContext.getCurrentInstance().addMessage(null, mensaje);
//            selected = null;
//        }
        if (SubirArchivo()) {
            create();
            aux = "";
        }

    }

    public Boolean SubirArchivo() {
        try {
            aux = "resources/fotosproductos";
            File archivo = new File(JsfUtil.getPath() + aux);
            if (!archivo.exists()) {
                archivo.mkdirs();
            }
            copiar_archivo(getFoto().getFileName(), getFoto().getInputstream());
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void copiar_archivo(String nombre, InputStream in) throws FileNotFoundException {
        aux = aux + "/" + nombre;
        OutputStream out = new FileOutputStream(new File(JsfUtil.getPath() + aux));
        int read = 0;
        byte[] bytes = new byte[1024];
        try {
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            aux = aux.substring(9);
            in.close();
            out.flush();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(FotosproductosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
