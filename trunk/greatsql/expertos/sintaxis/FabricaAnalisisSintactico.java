/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.expertos.sintaxis;

import greatsql.expertos.CodigosError;
import greatsql.expertos.GreatSQLException;

/**
 *
 * @author aranzuglia
 */
public final class FabricaAnalisisSintactico {

    private FabricaAnalisisSintactico() {
    }

    public static AnalisisSintactico crear(TipoSentencia tipoSentencia) throws GreatSQLException {
        switch (tipoSentencia) {
            case SELECT:
                return new AnalisisSintacticoSelect();
        }

        throw new GreatSQLException(CodigosError.SENTENCIA_DESCONOCIDA);
    }

}
