/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.expertos;

import greatsql.expertos.resultados.TuplaAlmacenamiento;
import greatsql.expertos.resultados.TuplaObjetos;
import greatsql.expertos.resultados.TuplasAlmacenamiento;
import greatsql.expertos.resultados.TuplasObjetos;
import greatsql.expertos.resultados.ValorTuplaObjetos;
import greatsql.sentencias.ColumnaObjetos;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rustu
 */
public class prueba {

    public static void main(String[] Args){
        try {
            ExpertoBuscarFilas ecfo = new ExpertoBuscarFilas();
            TuplasAlmacenamiento tuplAlm;
            tuplAlm = ecfo.read();
            
            System.out.println("-------------------------FILAS ENTERAS----------------------");
            
            System.out.println("\n");
            for(TuplaAlmacenamiento tup : tuplAlm.getTuplas()){
                System.out.println(tup.getFilaCompleta());
            
            }
            ConvertirFilasAObjetos conFilasObj = new ConvertirFilasAObjetos();



            TuplasObjetos tuplObj = conFilasObj.convertirFilas(tuplAlm);

            System.out.println("------------------COLUMNAS----------------");

            for(ColumnaObjetos colObj: tuplObj.getColumnas()){

                System.out.println(colObj.getNombre());


            }

            System.out.println("\n\n\n");

            System.out.println("-----------------TUPLAS--------------");

            for(TuplaObjetos tuplaObj : tuplObj.getTuplas()){

                System.out.println(tuplaObj.getNumero());
                System.out.println("\n\n");
                for(ValorTuplaObjetos valTupla : tuplaObj.getValores()){

                    System.out.println("Col: " + valTupla.getColumna().getNombre());
                    System.out.println("Val: " + (String)valTupla.getValor());
                    System.out.println("\n");
                    
                }


            }







        } catch (GreatSQLException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }





    }


}
