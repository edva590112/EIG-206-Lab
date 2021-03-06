/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Datos;
import Dto.AdministradorDto;
import LogicaDeNegocio.Administrador;
import Modelo.Modelos.ModeloAdministrador;
import Vista.Forms.PersonaFormVista;
import Vista.Principals.AdministradorPrincipalVista;
import Vista.VistaAdministrador;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import javax.swing.JOptionPane;




//import javax.swing.admiTable.TableColumn;

/**
 *
 * @author edva5
 */
public class ControlAdministrador extends ControlPadre{
    private Control superControl;
    private Datos datos;
    private ModeloAdministrador modelo;    
    private VistaAdministrador vista;  
    private ChangeListener<Administrador> changeListener;
    /**
     *
     * @param stage
     */
    public ControlAdministrador(ModeloAdministrador modelo,VistaAdministrador vista){
        
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControl(this);        
        modelo.setTableColumnsNames(vista.getPrincipal().getAdmiTableColumns());
        vista.getPrincipal().getAdmiTableColumns().stream().forEach(x->this.vista.getPrincipal().getTable().getColumns().add(x));                                                                 
        this.vista.getPrincipal().getTable().setItems(AccesoDatos.AccesoDatosAdministrador.getInstance().getAll());        
        this.vista.getPrincipal().getStage().show();                                
        
    } 
    
    /**
     * @return the superControl
     */
    public Control getSuperControl() {
        return superControl;
    }

    /**
     * @param superControl the superControl to set
     */
    public void setSuperControl(Control superControl) {
        this.superControl = superControl;
    }
    /**
     * @return the datos
     */
    public Datos getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    /**
     * @return the modelo
     */
    public ModeloAdministrador getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ModeloAdministrador modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the vista
     */
    public VistaAdministrador getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(VistaAdministrador vista) {
        this.vista = vista;
    }            
    @Override
    public void handle(Event event) {
        if (event instanceof ActionEvent) {
            if (event.getSource() instanceof Button) {
                switch(((Button)event.getSource()).getText()){                    
                    case "Agregar":                        
                        this.getVista().getPrincipal().getStage().hide();
                        this.getVista().getForm().getEliminarBtn().setVisible(false);
                        this.getVista().getForm().getYesBtn().setText("Guardar");
                        this.getVista().getForm().clearForm();
                        this.getVista().getForm().getStage().show();
                        break;                                        
                    case "Guardar":           
                        if (!modelo.agregar(getAdministradorForm()))
                            this.getVista().getAlertDispatcher().setAlert(Alert.AlertType.ERROR, getModelo().agregarResponse(getAdministradorForm()), ButtonType.OK);                                                
                        else{
                            getVista().getForm().getStage().close();
                            getVista().getPrincipal().getStage().show();                            
                            }
                        break;
                    case "Modificar":                        
                        if (!modelo.modificar(getAdministradorForm()))
                            this.getVista().getAlertDispatcher().setAlert(Alert.AlertType.ERROR, getModelo().modificarResponse(getAdministradorForm()), ButtonType.OK);                        
                        else
                        {
                            getVista().getForm().getStage().close();
                            getVista().getPrincipal().getStage().show();
                        }                        
                        break;
                    case "Eliminar":                        
                        if (!modelo.eliminar(getAdministradorForm()))
                            this.getVista().getAlertDispatcher().setAlert(Alert.AlertType.ERROR, getModelo().eliminarResponse(getAdministradorForm()), ButtonType.OK);                        
                        else
                        {
                            getVista().getForm().getStage().close();
                            getVista().getPrincipal().getStage().show();
                        }                        
                        break;
                    case "Cancelar":  
                        getVista().getForm().getStage().close();
                        getVista().getPrincipal().getStage().show();
                        break;
                }
            }
        }
        else if (event instanceof MouseEvent) {
            if (vista.getPrincipal().getTable().getSelectionModel().getSelectedItem()!=null&&((MouseEvent)event).getClickCount()==1) {                
                            this.getVista().getPrincipal().getStage().close();
                            this.getVista().getForm().getYesBtn().setText("Modificar");
                            this.getVista().getForm().getEliminarBtn().setVisible(true);
                            this.getVista().getForm().clearForm();
                            this.getVista().getForm().fillForm(this.getVista().getPrincipal().getTable().getSelectionModel().getSelectedItem());
                            this.getVista().getForm().getStage().show();
                            vista.getPrincipal().getTable().getSelectionModel().clearSelection();                            
                        }                                                       
        }
        else if (event instanceof WindowEvent) {                           
                        
            if (((WindowEvent)event).getEventType().equals(WindowEvent.WINDOW_CLOSE_REQUEST)) {                        
            ArrayList<AdministradorDto> administradorDtos = new ArrayList<AdministradorDto>();
            AccesoDatos.AccesoDatosAdministrador.getInstance().getAll().stream().forEach(x->administradorDtos.add(new AdministradorDto(x)));
            datos.guardarDatos(administradorDtos,Datos.FICHERO_ADMINISTRADOR);
            vista.getPrincipal().getStage().hide();
            superControl.vista.getPrincipal().getStage().show();
            }
                        
                         
        }       
    }
              
    public Administrador getAdministradorForm(){
        Administrador aux = new Administrador();
        aux.setCedulaOPassaporte(this.vista.getForm().getIdTxtFld().getText());
        aux.setClave(this.vista.getForm().getClaveTxtFld().getText());
        aux.setEmail(this.vista.getForm().getEmailTxtFld().getText());
        aux.setTelefono(this.vista.getForm().getTelefonoTxtFld().getText());
        aux.setApellido1(this.vista.getForm().getApellido1TxtFld().getText());
        aux.setApellido2(this.vista.getForm().getApellido2TxtFld().getText());
        aux.setNombre(this.vista.getForm().getNombreTxtFld().getText());
        aux.setFechaNacimiento(this.vista.getForm().getDatePicker().getValue());
        return aux;
    }
    public void fillForm(Administrador a){    
        this.vista.getForm().getIdTxtFld().setEditable(false);
        this.vista.getForm().getIdTxtFld().setText(a.getCedulaOPassaporte());
        this.vista.getForm().getClaveTxtFld().setText(a.getClave());
        this.vista.getForm().getEmailTxtFld().setText(a.getEmail());         
        this.vista.getForm().getTelefonoTxtFld().setText(a.getTelefono());
        this.vista.getForm().getApellido1TxtFld().setText(a.getApellido1());
        this.vista.getForm().getApellido2TxtFld().setText(a.getApellido2());         
        this.vista.getForm().getNombreTxtFld().setText(a.getNombre());
        this.vista.getForm().getDatePicker().setValue(a.getFechaNacimiento());
    }
    
    
}
