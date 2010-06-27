/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greatsql.analisisSintactico;

import greatsql.analisisSintactico.AnalizadorSelect;

import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;

/**
 *
 * @author Ismael
 */
public class FabricaAnalizarores {

    private static FabricaAnalizarores INSTANCIA = null;

    private FabricaAnalizarores() {
    }

    private synchronized static void createInstance() {
        if (INSTANCIA == null) {
            INSTANCIA = new FabricaAnalizarores();
        }
    }

    public static FabricaAnalizarores getInstance() {
        if (INSTANCIA == null) {
            createInstance();
        }
        return INSTANCIA;
    }

    public AnalisisSintactico getAnalizadorSentencia(Statement sentencia) {
        AnalisisSintactico analizador;
        if (sentencia instanceof Select) {
            analizador = new AnalizadorSelect();
            return analizador;
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
