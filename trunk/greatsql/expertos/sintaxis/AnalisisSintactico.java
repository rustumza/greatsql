/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.expertos.sintaxis;

import greatsql.expertos.GreatSQLException;

/**
 *
 * @author aranzuglia
 */
public interface AnalisisSintactico {

    void analizar(String sentencia) throws GreatSQLException;

}
