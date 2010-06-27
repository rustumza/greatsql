/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greatsql.analisisSintactico;

import greatsql.expertos.GreatSQLException;
import net.sf.jsqlparser.statement.Statement;

/**
 *
 * @author Ismael
 */
public interface AnalisisSintactico {

    void analizar(Statement sentencia) throws GreatSQLException;
}
