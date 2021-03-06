/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package Dto;

import LogicaDeNegocio.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author edva5
 */
public class CicloDto implements Serializable{

    private String codigo,fechaIni,fechaFin;    
    private int numero;    
    private ArrayList<GrupoDto> grupos;
    public CicloDto() {
        grupos= new ArrayList<GrupoDto>();
    }
    public CicloDto(Ciclo c) {
        codigo=c.getCodigo();
        fechaIni=c.getFechaIni().toString();
        fechaFin=c.getFechaFin().toString();        
        numero=c.getNumero();
        grupos= new ArrayList<GrupoDto>();
        c.getGrupos().stream().forEach(x->grupos.add(new GrupoDto(x)));
    }


    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the fechaIni
     */
    public String getFechaIni() {
        return fechaIni;
    }

    /**
     * @param fechaIni the fechaIni to set
     */
    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    /**
     * @return the fechaFin
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    /**
     * @return the grupos
     */
    public ArrayList<GrupoDto> getGrupos() {
        return grupos;
    }

    /**
     * @param grupos the grupos to set
     */
    public void setGrupos(ArrayList<GrupoDto> grupos) {
        this.grupos = grupos;
    }
}
