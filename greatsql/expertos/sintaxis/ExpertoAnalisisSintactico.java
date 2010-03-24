/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.expertos.sintaxis;

import greatsql.expertos.CodigosError;
import greatsql.expertos.GreatSQLException;
import greatsql.util.split.Splits;
import greatsql.util.split.Splitter;

/**
 *
 * @author aranzuglia
 */
public class ExpertoAnalisisSintactico {

    public void analizarSintaxis(String sentencia) throws GreatSQLException {
        if (sentencia == null || sentencia.trim().length() == 0) {
            throw new GreatSQLException(CodigosError.SENTENCIA_NO_INDICADA);
        }

        Splits splits = Splitter.getInstance().split(sentencia);

        TipoSentencia tipoSentencia;
        try {
            tipoSentencia = TipoSentencia.valueOf(splits.getFirst().getText().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new GreatSQLException(CodigosError.SENTENCIA_INEXISTENTE);
        }

        AnalisisSintactico analisisSintactico = FabricaAnalisisSintactico.crear(tipoSentencia);

        analisisSintactico.analizar(sentencia);
    }

    public static void main(String[] args) {
        ExpertoAnalisisSintactico e = new ExpertoAnalisisSintactico();

        try {
            e.analizarSintaxis("select * from tabla");
        } catch (GreatSQLException ex) {
            System.out.println(ex);
        }
    }

}
