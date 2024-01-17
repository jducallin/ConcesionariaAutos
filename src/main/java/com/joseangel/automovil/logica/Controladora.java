
package com.joseangel.automovil.logica;

import com.joseangel.automovil.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void agregarAutomovil(String modelo, String marca, String motor, String color, String patente, int cantPuertas) {
     
        Automovil auto = new Automovil ();
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantPuertas(cantPuertas);
        
     controlPersis.agregarAutomovil (auto);
             
    }

    public List<Automovil> traerAutos() {
        
        return controlPersis.traerAutos();
        
    }

    public void borrarAuto(int idAuto) {
       controlPersis.borrarAuto(idAuto);
        
        
    }

    public Automovil traerAuto(int idAuto) {
        return controlPersis.traerAutos(idAuto);
    }

    public void modificarAuto(Automovil auto, String modelo, String marca, String motor, String color, String patente, int cantPuertas) {
        
        
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantPuertas(cantPuertas);
        
        //le pido a la persis que modifique
        controlPersis.modificarAuto(auto);
        
    }

    public boolean patenteDuplicada(String patente) {
        
     // Consultar la base de datos para verificar si la patente ya existe
        List<Automovil> autos = controlPersis.traerAutos();

        for (Automovil auto : autos) {
            if (auto.getPatente().equalsIgnoreCase(patente)) {
                return true; // La patente ya existe
            }
        }

        return false; // La patente no existe
    }   



   
    
}
