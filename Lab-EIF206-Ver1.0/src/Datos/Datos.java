/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dto.AdministradorDto;
import Dto.CarreraDto;
import Dto.CicloDto;
import Dto.CursoDto;
import Dto.EstudianteDto;
import Dto.GrupoDto;
import Dto.MatriculadorDto;
import Dto.NotaDto;
import Dto.ProfesorDto;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Datos {
    public static final String FICHERO_ADMINISTRADOR="TABLE_ADMINISTRADOR.tmp",
        FICHERO_CARRERA="TABLE_CARRERA.tmp",
        FICHERO_CICLO="TABLE_CICLO.tmp",
        FICHERO_CURSO="TABLE_CURSO.tmp",
        FICHERO_ESTUDIANTE="TABLE_ESTUDIANTE.tmp",
        FICHERO_GRUPO="TABLE_GRUPO.tmp",
        FICHERO_MATRICULADOR="TABLE_MATRICULADOR.tmp",
        FICHERO_NOTA="TABLE_NOTA.tmp",
        FICHERO_PROFESOR="TABLE_PROFESOR.tmp";
    FileOutputStream ficheroSalida;
    ObjectOutputStream objetoSalida;
    FileInputStream ficheroEntrada;
    ObjectInputStream objetoEntrada;
    public Datos() {            
            ArrayList<File> files= new ArrayList<>();
            files.add(new File(FICHERO_ADMINISTRADOR));
            files.add(new File(FICHERO_CARRERA));
            files.add(new File(FICHERO_CICLO));
            files.add(new File(FICHERO_CURSO));
            files.add(new File(FICHERO_ESTUDIANTE));
            files.add(new File(FICHERO_GRUPO));
            files.add(new File(FICHERO_MATRICULADOR));
            files.add(new File(FICHERO_NOTA));
            files.add(new File(FICHERO_PROFESOR));            
            files.stream().forEach(x->{
                try {
                    x.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        //yourFile.createNewFile(); // if file already exists will do nothing 
        //FileOutputStream oFile = new FileOutputStream(yourFile, false); 
    }
    public ArrayList getLista(String fichero) throws IOException, ClassNotFoundException{
        ArrayList aux= new ArrayList<>();
        try{
            loadArchivesToRead(fichero);
            while(true){
                aux.add(objetoEntrada.readObject());
            }
        }
        catch(EOFException ex){
            if (objetoEntrada==null)            
                return aux;
            else
            {
                objetoEntrada.close();
                return aux;
            }
        }        
        
    }
                
    public void guardarDatos(ArrayList list,String Fichero){
        try{
            switch(Fichero){
            case FICHERO_ADMINISTRADOR:
                ArrayList<AdministradorDto> admiList = list;
                loadArchivesToWrite(FICHERO_ADMINISTRADOR);
                for (AdministradorDto a:admiList)
                    objetoSalida.writeObject(a);        
                objetoSalida.close();
                break;
            case FICHERO_CARRERA:
                ArrayList<CarreraDto> listaCarrera = list;
                loadArchivesToWrite(FICHERO_CARRERA);
                for (CarreraDto a:listaCarrera)
                    objetoSalida.writeObject(a);                
                objetoSalida.close();        
                break;
            case FICHERO_CICLO:
                ArrayList<CicloDto> listaCiclo = list;
                loadArchivesToWrite(FICHERO_CICLO);
                for (CicloDto c:listaCiclo)
                    objetoSalida.writeObject(c);                
                objetoSalida.close();        
                break;
            case FICHERO_CURSO:
                ArrayList<CursoDto> listaCurso = list;
                loadArchivesToWrite(FICHERO_CURSO);
                for (CursoDto c:listaCurso)
                    objetoSalida.writeObject(c);                
                objetoSalida.close();        
                break;
            case FICHERO_ESTUDIANTE:
                ArrayList<EstudianteDto> listaEstudiante = list;
                loadArchivesToWrite(FICHERO_ESTUDIANTE);
                for (EstudianteDto e:listaEstudiante)
                    objetoSalida.writeObject(e);                
                objetoSalida.close();     
                break;
            case FICHERO_GRUPO:
                ArrayList<GrupoDto> listaGrupo = list;
                loadArchivesToWrite(FICHERO_GRUPO);
                for (GrupoDto g:listaGrupo)
                    objetoSalida.writeObject(g);                
                objetoSalida.close();  
                break;
            case FICHERO_MATRICULADOR:
                ArrayList<MatriculadorDto> listaMatriculador = list;
                loadArchivesToWrite(FICHERO_MATRICULADOR);
                for (MatriculadorDto m:listaMatriculador)
                    objetoSalida.writeObject(m);                
                objetoSalida.close(); 
                break;
            case FICHERO_NOTA:
                ArrayList<NotaDto> listaNota = list;
                loadArchivesToWrite(FICHERO_NOTA);
                for (NotaDto n:listaNota)
                    objetoSalida.writeObject(n);                
                objetoSalida.close();                 
                break;
            case FICHERO_PROFESOR:
                ArrayList<ProfesorDto> listaProfesor = list;
                loadArchivesToWrite(FICHERO_PROFESOR);
                for (ProfesorDto p:listaProfesor)
                    objetoSalida.writeObject(p);                
                objetoSalida.close();                 
                break;                
            }
        }catch(Exception ex){
            
        }        
    }
    private void loadArchivesToWrite(String fichero) throws IOException{
        try {   
            ficheroSalida= new FileOutputStream(fichero);
            objetoSalida = new ObjectOutputStream(ficheroSalida);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadArchivesToRead(String fichero) throws IOException{
        try {   
         ficheroEntrada = new FileInputStream(fichero);
         objetoEntrada = new ObjectInputStream(ficheroEntrada);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

}
