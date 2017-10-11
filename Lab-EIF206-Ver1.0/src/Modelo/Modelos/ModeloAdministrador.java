/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Modelos;

import LogicaDeNegocio.Administrador;
import Vista.AlertDispatcher;
import java.util.ArrayList;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;


/**
 *
 * @author edva5
 */
public class ModeloAdministrador {    
    public ModeloAdministrador() {
    }
    public boolean validateTableSelection(TableView<Administrador> table){
        if (table.getSelectionModel().isEmpty())
            return false;       
        if (table.getSelectionModel().selectedItemProperty().getValue()==null)
            return false;      
        else   return true;
    }
    public String getValidateTableSelectionMessage(TableView<Administrador> table){
        if (table.getSelectionModel().isEmpty())
            return "Tabla Vacia";
        if (table.getSelectionModel().getSelectedItem()==null)
            return "Ningun Administrador Seleccionado";
        else return "Something Went Wrong" ;
    }
    public boolean AlertResponse(AlertDispatcher alertDispatcher){
        if (alertDispatcher.getResult().equals(ButtonType.YES))
            return true;
        else
            return false;
    }
    public boolean eliminar(Administrador a){
        if (a==null)
            return false;        
        else if (AccesoDatos.AccesoDatosAdministrador.getInstance().get(a.getCedulaOPassaporte())==null) 
            return false;
        else
        {
            AccesoDatos.AccesoDatosAdministrador.getInstance().eliminar(a.getCedulaOPassaporte());
            return true;
        }
    }
    public boolean agregar(Administrador a){
        if (a==null)
            return false;        
        else if (AccesoDatos.AccesoDatosAdministrador.getInstance().get(a.getCedulaOPassaporte())!=null) 
            return false;
        else if (!validateAdministrador(a)) 
            return false;            
        else
        {
            AccesoDatos.AccesoDatosAdministrador.getInstance().insertar(a);
            return true;
        }
    }
    public boolean modificar(Administrador a){
        if (a==null)
            return false;        
        else if (AccesoDatos.AccesoDatosAdministrador.getInstance().get(a.getCedulaOPassaporte())==null) 
            return false;
        else if (!validateAdministrador(a)) 
            return false;            
        else
        {
            AccesoDatos.AccesoDatosAdministrador.getInstance().modificar(a);
            return true;
        }
    }
    public String eliminarResponse(Administrador a){
        if (a==null)
            return "Objeto a Eliminar esta Vacio";        
        else if (AccesoDatos.AccesoDatosAdministrador.getInstance().get(a.getCedulaOPassaporte())==null) 
            return "Objeto a Eliminar no esta en base de Datos";        
        else
            return "No hay Problema";
    }
    public String agregarResponse(Administrador a){
        if (a==null)
            return "Se esta Intentando Ingresar un dato vacio";
        else if (AccesoDatos.AccesoDatosAdministrador.getInstance().get(a.getCedulaOPassaporte())!=null) 
            return "Existe un Usuario en base de datos con la misma identificacion";
        else if (a.getApellido1().length()==0||a.getCedulaOPassaporte().length()==0||a.getClave().length()==0||a.getNombre().length()==0) 
        {
            String aux="Los espacios: ";
            if (a.getApellido1().equals(""))
                aux=aux+"Apellido1, ";
            if (a.getCedulaOPassaporte().equals(""))
                aux=aux+"Cedula, ";
            if (a.getApellido1().equals(""))
                aux=aux+"Apellido1, ";
            if (a.getClave().equals(""))
                aux=aux+"Nombre, ";
            aux=aux+"NO pueden quedar vacios";
            return aux;
        }        
        else
            return "No hay Problema";
    }
    public String modificarResponse(Administrador a){
        if (a==null)
            return "Se esta Intentando Ingresar un dato vacio";        
        else if (a.getApellido1().length()==0||a.getCedulaOPassaporte().length()==0||a.getClave().length()==0||a.getNombre().length()==0) 
        {
            String aux="Los espacios: ";
            if (a.getApellido1().equals(""))
                aux=aux+"Apellido1, ";
            if (a.getCedulaOPassaporte().equals(""))
                aux=aux+"Cedula, ";
            if (a.getApellido1().equals(""))
                aux=aux+"Apellido1, ";
            if (a.getClave().equals(""))
                aux=aux+"Nombre, ";
            aux=aux+"NO pueden quedar vacios";
            return aux;
        }        
        else
            return "No hay Problema";
    }
    public void setTableColumnsNames(ArrayList<TableColumn<Administrador,String>> columns){
        for (int i = 0; i < Administrador.getClassNames().length; i++) {
            columns.add(new TableColumn<Administrador, String>(Administrador.getClassNames()[i]));   //Add names to Columns' headers
            OrderTableViewInfo(columns.get(i),Administrador.getClassNames()[i]);            
        }
    }
    private void OrderTableViewInfo(TableColumn<Administrador, String> tablecolumn,String columnName){
        switch(columnName){//Depending on the Header's Name, it assings a specific value of the object to a specific column
                case Administrador.ATRIBUTO_APELLIDO1:                        
                tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Administrador, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Administrador, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(p.getValue().getApellido1());
                    }
                });            
                    break;
                case Administrador.ATRIBUTO_APELLIDO2:
                tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Administrador, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Administrador, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(p.getValue().getApellido2());
                    }
                });
                    break;
                case Administrador.ATRIBUTO_CEDULAPASAPORTE:
                    tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Administrador, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Administrador, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(p.getValue().getCedulaOPassaporte());
                    }
                });
                    break;            
                case Administrador.ATRIBUTO_EMAIL:
                    tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Administrador, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Administrador, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(p.getValue().getEmail());
                    }
                });
                    break;
                case Administrador.ATRIBUTO_NOMBRE:
                    tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Administrador, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Administrador, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(p.getValue().getNombre());
                    }
                });
                    break;
                case Administrador.ATRIBUTO_TELEFONO:
                    tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Administrador, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Administrador, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(p.getValue().getTelefono());
                    }
                });
                    break;
                case Administrador.ATRIBUTO_FECHA_DE_NACIMMIENTO:
                    tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Administrador, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Administrador, String> p) {
                        if (p.getValue().getFechaNacimiento()!=null) {
                            return new ReadOnlyObjectWrapper<>(p.getValue().getFechaNacimiento().toString());
                        }    
                        else return null;
                    }
                });
                    break;
            }
    }
    private boolean validateAdministrador(Administrador a){
        if (a==null)
            return false;
        else if (a.getFechaNacimiento()==null)
            return false;
        else if (a.getApellido1().equals(""))
            return false;
        else if (a.getApellido2().equals(""))
            return false;
        else if (a.getCedulaOPassaporte().equals(""))
            return false;
        else if (a.getClave().equals(""))
            return false;
        else if (a.getEmail().equals(""))
            return false;
        else if (a.getNombre().equals(""))
            return false;
        else if (a.getTelefono().equals(""))
            return false;
        else return true;
    }
    
}
