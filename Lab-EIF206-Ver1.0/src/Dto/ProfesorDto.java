/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 14/08/17 19:00;
 */
package Dto;

import LogicaDeNegocio.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author edva5
 */
public class ProfesorDto extends PersonaDto implements Serializable{
    private ArrayList<GrupoDto> grupos;
    public ProfesorDto() {        
        super();        
        grupos= new ArrayList<GrupoDto>();
    }

    public ProfesorDto(Profesor p) {
        super(p);
        grupos = new ArrayList<GrupoDto>();
        p.getGrupos().forEach(x->grupos.add(new GrupoDto(x)));
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
