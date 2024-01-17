
package com.joseangel.automovil.persistencia;

import com.joseangel.automovil.logica.Automovil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    AutomovilJpaController autoJpa = new AutomovilJpaController();

    public void agregarAutomovil(Automovil auto) {
       autoJpa.create(auto);
    }

    public List<Automovil> traerAutos() {
       return autoJpa.findAutomovilEntities();
        
    }

  public void borrarAuto(int idAuto) {
    try {
        autoJpa.destroy(idAuto);
    
    } catch (Exception ex) {
        // Si ocurre alguna excepción, registra el error
        Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
     
    }

}

    public Automovil traerAutos(int idAuto) {
       return autoJpa.findAutomovil(idAuto);
    }

    public void modificarAuto(Automovil auto) {
        try {
        autoJpa.edit(auto);
    
    } catch (Exception ex) {
        // Si ocurre alguna excepción, registra el error
        Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
     
    }
       
    }
    
}
