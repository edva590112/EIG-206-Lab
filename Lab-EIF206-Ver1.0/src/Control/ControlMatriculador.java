/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Datos;
import Dto.MatriculadorDto;
import LogicaDeNegocio.Matriculador;
import Modelo.Modelos.ModeloMatriculador;
import Vista.VistaMatriculador;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;

/**
 *
 * @author edva5
 */
public class ControlMatriculador extends ControlPadre{
    private Control superControl;
    private Datos datos;
    private Modelo.Modelos.ModeloMatriculador modelo;    
    private Vista.VistaMatriculador vista;      
    /**
     *
     * @param stage
     */
    public ControlMatriculador(ModeloMatriculador modelo,VistaMatriculador vista)  {
        
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControl(this);        
        modelo.setTableColumnsNames(vista.getPrincipal().getAdmiTableColumns());
        vista.getPrincipal().getAdmiTableColumns().stream().forEach(x->this.vista.getPrincipal().getTable().getColumns().add(x));                                                                 
        this.vista.getPrincipal().getTable().setItems(AccesoDatos.AccesoDatosMatriculador.getInstance().getAll());        
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
    public ModeloMatriculador getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ModeloMatriculador modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the vista
     */
    public VistaMatriculador getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(VistaMatriculador vista) {
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
                        if (!modelo.agregar(getMatriculadorForm()))
                            this.getVista().getAlertDispatcher().setAlert(Alert.AlertType.ERROR, getModelo().agregarResponse(getMatriculadorForm()), ButtonType.OK);                                                
                        else{
                            getVista().getForm().getStage().close();
                            getVista().getPrincipal().getStage().show();                            
                            }
                        break;
                    case "Modificar":                        
                        if (!modelo.modificar(getMatriculadorForm()))
                            this.getVista().getAlertDispatcher().setAlert(Alert.AlertType.ERROR, getModelo().modificarResponse(getMatriculadorForm()), ButtonType.OK);                        
                        else
                        {
                            getVista().getForm().getStage().close();
                            getVista().getPrincipal().getStage().show();
                        }                        
                        break;
                    case "Eliminar":                        
                        if (!modelo.eliminar(getMatriculadorForm()))
                            this.getVista().getAlertDispatcher().setAlert(Alert.AlertType.ERROR, getModelo().eliminarResponse(getMatriculadorForm()), ButtonType.OK);                        
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
                            fillForm(this.getVista().getPrincipal().getTable().getSelectionModel().getSelectedItem());
                            this.getVista().getForm().getStage().show();
                            vista.getPrincipal().getTable().getSelectionModel().clearSelection();
                            
                        }                                            
           
        }
        else if (event instanceof WindowEvent) {                           
                        
            if (((WindowEvent)event).getEventType().equals(WindowEvent.WINDOW_CLOSE_REQUEST)) {                        
            ArrayList<MatriculadorDto> administradorDtos = new ArrayList<MatriculadorDto>();
            AccesoDatos.AccesoDatosMatriculador.getInstance().getAll().stream().forEach(x->administradorDtos.add(new MatriculadorDto(x)));
            datos.guardarDatos(administradorDtos,Datos.FICHERO_MATRICULADOR);
            vista.getPrincipal().getStage().hide();
            superControl.vista.getPrincipal().getStage().show();
            }                                                 
        }       
    }
    public Matriculador getMatriculadorForm(){
        Matriculador aux = new Matriculador();
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
    public void fillForm(Matriculador p){    
        this.vista.getForm().getIdTxtFld().setEditable(false);
        this.vista.getForm().getIdTxtFld().setText(p.getCedulaOPassaporte());
        this.vista.getForm().getClaveTxtFld().setText(p.getClave());
        this.vista.getForm().getEmailTxtFld().setText(p.getEmail());         
        this.vista.getForm().getTelefonoTxtFld().setText(p.getTelefono());
        this.vista.getForm().getApellido1TxtFld().setText(p.getApellido1());
        this.vista.getForm().getApellido2TxtFld().setText(p.getApellido2());         
        this.vista.getForm().getNombreTxtFld().setText(p.getNombre());
        this.vista.getForm().getDatePicker().setValue(p.getFechaNacimiento());
    }
}
