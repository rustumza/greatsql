/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greatsql.analisisSintactico;

import greatsql.Main;
import greatsql.expertos.GreatSQLException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;

/**
 *
 * @author Ismael
 */
public class ExpertoAnalisisSintatico {

    public void analizarSentencia(String sentencia) {
        CCJSqlParserManager pm = new CCJSqlParserManager();
        FabricaAnalizarores fabricaAnalizarores;
        try {
            Statement statement = pm.parse(new StringReader(sentencia));
            fabricaAnalizarores = FabricaAnalizarores.getInstance();
            AnalisisSintactico analisisSintactico = fabricaAnalizarores.getAnalizadorSentencia(statement);
            try {
                analisisSintactico.analizar(statement);
            } catch (GreatSQLException gsqle) {
                gsqle.printStackTrace();
            }
        } catch (JSQLParserException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Sintaxis Invalida", ex);
        }
    }
}
