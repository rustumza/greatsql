/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.expertos.sintaxis;

import greatsql.expertos.CodigosError;
import greatsql.expertos.GreatSQLException;
import greatsql.util.split.Split;
import greatsql.util.split.Splits;
import greatsql.util.split.Splitter;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author aranzuglia
 */
public class AnalisisSintacticoSelect implements AnalisisSintactico {

    public void analizar(String sentencia) throws GreatSQLException {
        Splits splits = Splitter.getInstance().split(sentencia);

        Split splitSelect = splits.getFirst();
        Split splitFrom = null;
        Split splitWhere = null;

        // Buscar from y where

        for (Split split : splits.getSplitParts()) {
            if (split.getText().equalsIgnoreCase("from")) {
                // Verificar si ya se ha encontrado

                if (splitFrom != null) {
                    throw new GreatSQLException(CodigosError.SINTAXIS_INVALIDA, sentencia, split.getLine(), split.getOffset());
                }

                splitFrom = split;
            } else if (split.getText().equalsIgnoreCase("where")) {
                // Verificar si ya se ha encontrado

                if (splitWhere != null) {
                    throw new GreatSQLException(CodigosError.SINTAXIS_INVALIDA, sentencia, split.getLine(), split.getOffset());
                }

                splitWhere = split;
            }
        }
        
        if (splitFrom == null) {
            throw new GreatSQLException(CodigosError.SINTAXIS_INVALIDA, sentencia, 1, 1);
        }
        
        if (splitWhere != null) {
            if (splitWhere.getNumber() < splitFrom.getNumber()) {
                throw new GreatSQLException(CodigosError.SINTAXIS_INVALIDA, sentencia, splitWhere.getLine(), splitWhere.getOffset());
            }
        }

        // Entre select y from determinar columnas separadas con coma (cuidado con alias)

        Collection<Split> splitsColumnas =
            splits.getSplitParts(splitSelect.getNumber(), splitFrom.getNumber());

        // Luego de from determinar tablas separadas con coma (cuidado con alias)
    }

}
