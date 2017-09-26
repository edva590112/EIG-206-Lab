/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Interfaz.Dispatcher;
import Interfaz.InterfazAdministrador;
import Interfaz.InterfazLogIn;
import Interfaz.InterfazMenu;
import Modelo.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.stream.Collectors;
import javax.swing.JButton;


/**
 *
 * @author edva5
 */
public class Control implements ActionListener,MouseListener{
    private Modelo modelo;
    private Dispatcher dispatcher;  

    

    public Control(Modelo modelo, Dispatcher dispatcher) {
        this.modelo = modelo;
        this.dispatcher = dispatcher;
        this.dispatcher.dispatcherRequest(InterfazLogIn.LOGIN, modelo, this);
        
    }        

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (e.getActionCommand().equals("LogIn"))
                dispatcher.dispatcherRequest(InterfazMenu.INTERFAZ_MENU, modelo, this);
            else
                dispatcher.dispatcherRequest(e.getActionCommand(), modelo, this);
                
            /*this.modelo.addHistorial(e.getActionCommand());
            switch(e.getActionCommand()){
                
                case "LogIn":
                    if (!dispatcher.getInterfazLogIn().getjCheckBoxs().isEmpty()) {                                                                
                        dispatcher.getInterfazLogIn().dispose();
                            dispatcher.dispatcherRequest(e.getActionCommand(), modelo, this);
                     }
                    break;
                case InterfazAdministrador.MANTENIMIENTO_ADMINISTRADOR:
                    this.dispatcher.dispatcherRequest(Dispatcher.ADMINISTRADOR, modelo, this);
                    this.dispatcher.getInterfazAdministrador().getDefaultTableModel().setColumnIdentifiers(LogicaDeNegocio.Administrador.getClassNames());
                    this.dispatcher.getInterfazAdministrador().setTitle(InterfazAdministrador.MANTENIMIENTO_ADMINISTRADOR);
                    this.dispatcher.getInterfazAdministrador().addButtonsToTable();
                    modelo.getAllAdministradores().forEach(x->this.dispatcher.getInterfazAdministrador().getDefaultTableModel().addRow(x.toVectorOfString()));
                    break;
                case Interfaz.InterfazCarrera.MANTENIMIENTO_CARRERA:
                    this.dispatcher.dispatcherRequest(Dispatcher.CARRERA, modelo, this);
                    break;
                case Interfaz.InterfazCiclo.MANTENIMIENTO_CICLO:
                    this.dispatcher.dispatcherRequest(Dispatcher.CICLO, modelo, this);
                    break;
                case Interfaz.InterfazCurso.MANTENIMIENTO_CURSO:
                    this.dispatcher.dispatcherRequest(Dispatcher.CURSO, modelo, this);
                    break;
                case Interfaz.InterfazGrupo.MANTENIMIENTO_GRUPO:
                    this.dispatcher.dispatcherRequest(Dispatcher.GRUPO, modelo, this);
                    break;                
                case Interfaz.InterfazMatriculador.MANTENIMIENTO_MATRICULADOR:
                    this.dispatcher.dispatcherRequest(Dispatcher.MATRICULADOR, modelo, this);
                    this.dispatcher.getInterfazMatriculador().getDefaultTableModel().setColumnIdentifiers(LogicaDeNegocio.Matriculador.getClassNames());
                    this.dispatcher.getInterfazMatriculador().setTitle(Interfaz.InterfazMatriculador.MANTENIMIENTO_MATRICULADOR);
                    this.dispatcher.getInterfazMatriculador().addButtonsToTable();                                        
                    break;
                case Interfaz.InterfazNota.MANTENIMIENTO_NOTA:
                    this.dispatcher.dispatcherRequest(Dispatcher.NOTA, modelo, this);
                    break;
                case Interfaz.InterfazProfesor.MANTENIMIENTO_PROFESOR:
                    this.dispatcher.dispatcherRequest(Dispatcher.PROFESOR, modelo, this);
                    this.dispatcher.getInterfazProfesor().getDefaultTableModel().setColumnIdentifiers(LogicaDeNegocio.Profesor.getClassNames());
                    this.dispatcher.getInterfazProfesor().setTitle(Interfaz.InterfazProfesor.MANTENIMIENTO_PROFESOR);
                    this.dispatcher.getInterfazProfesor().addButtonsToTable();
                    break;
                case Interfaz.InterfazEstudiante.MANTENIMIENTO_ESTUDIANTE:
                    this.dispatcher.dispatcherRequest(Dispatcher.ESTUDIANTE, modelo, this);
                    this.dispatcher.getInterfazEstudiante().getDefaultTableModel().setColumnIdentifiers(LogicaDeNegocio.Estudiante.getClassNames());
                    this.dispatcher.getInterfazEstudiante().setTitle(Interfaz.InterfazEstudiante.MANTENIMIENTO_ESTUDIANTE);
                    this.dispatcher.getInterfazEstudiante().addButtonsToTable();
                    break;
                case Interfaz.InterfazLogIn.LOGIN:
                    this.dispatcher.dispatcherRequest(Dispatcher.LOGIN, modelo, this);
                    break;                 
                default:
                    break;
            }*/
        }
        else if (e.getSource() instanceof String) {
            switch(((String)e.getSource())){
                case "Atras":
                    //dispatcher.
                break;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
