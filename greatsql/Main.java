/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greatsql;

import greatsql.analisisSintactico.ExpertoAnalisisSintatico;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Ismael
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        ExpertoAnalisisSintatico analisisSintatico;
        try {
            System.out.println("Ingrese sentencia: ");
            String sql = br.readLine();
            analisisSintatico = new ExpertoAnalisisSintatico();
            analisisSintatico.analizarSentencia(sql);
            System.out.println("------------------------------------------------");
            System.out.println("Sentencia Valida");
            //---------------------------------------------------------------------
            //Falta comparar en el catalogo

        } catch (IOException ex) {
            System.out.println("Error al leer buffered reader\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

