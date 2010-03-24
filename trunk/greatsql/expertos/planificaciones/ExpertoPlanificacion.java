/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.expertos.planificaciones;

import greatsql.sentencias.select.SentenciaSelect;
import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author Rustu
 */
public class ExpertoPlanificacion {


    public Collection<Planificacion> planificar(SentenciaSelect sentencia){

        //se me ocurre que el metodo planifica puede estar sobrecargado y
        //dependiendo del tipo de sentencia que reciba es lo que se va a ejecutar
        //o sea, siempre llamo a planificar y le mando un tipo de sentencia
        //eso es lo determina que a que planificar entro
        Collection<Planificacion> planificaciones = new TreeSet<Planificacion>();

        Planificacion planificacion = new Planificacion();
        boolean bandera= true; //esta se usa para salir del do cuando ya no se quiere o puede crear mas planificaciones
        do{
            planificacion.setSentenciaSelect(sentencia);
            if(planificacion.getSentenciaSelect().getWhere().getColumnaSentencia().getColumnaObjetos().getIndice()==true){
                //si tiene indice

            }else{
                planificacion.getMetodoAcceso().setTipoAcceso(TipoAcceso.COMPLETO);
            }

            planificacion.setPuntaje(10);

            planificaciones.add(planificacion);

            //hay que determinar la logica de como se va a dar cuenta que no se pueden generar mas planificaciones
            bandera=false;


        }while(bandera);


    return planificaciones;
    }

}
