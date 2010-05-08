/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql;
import Zql.ZFromItem;
import Zql.ZQuery;
import Zql.ZSelectItem;
import Zql.ZStatement;
import Zql.ZqlParser;
import greatsql.expertos.CodigosError;
import greatsql.expertos.GreatSQLException;
import greatsql.sentencias.ColumnaSentencia;
import greatsql.sentencias.TablaSentencia;
import greatsql.sentencias.select.SentenciaSelect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
/**
 *
 * @author Ismael
 */
public class Main {
public static void main(String[] args) {


        try {
            System.out.println("Leyendo SQL desde la entrada estandar:");
            ZqlParser parser = new ZqlParser(System.in);

            ZStatement statement;

            while ((statement = parser.readStatement()) != null) {
                if (statement instanceof ZQuery) {
                    executeQuery((ZQuery) statement);
                }
            }

        } catch (Exception e) {
            GreatSQLException g = new GreatSQLException(CodigosError.SINTAXIS_INVALIDA);
            System.out.println(g.getSentencia() + "\n");
            System.out.println(g.getMessage());
            System.out.println(e.getMessage());

            //////////////////////////////////////////////////////////////
            // Falta tratar bien las Excepciones                        //
            //                                                          //
            //                                                          //
            //////////////////////////////////////////////////////////////

        }
    }

    private static void executeQuery(ZQuery query) throws Exception {


        Vector select = query.getSelect();
        Vector from = query.getFrom();
        ZFromItem table = (ZFromItem) from.elementAt(0);


////////////////Convertimos los objetos ZQL a Objetos GSQL//////////////////////
//
//
//
//
        SentenciaSelect sentenciaSelect = new SentenciaSelect();
        ColumnaSentencia columnaSentencia = new ColumnaSentencia();
        ArrayList<ColumnaSentencia> arregloColumnas = new ArrayList();
        TablaSentencia tablaSentencia = new TablaSentencia();


        ZSelectItem selectItem = (ZSelectItem) select.elementAt(0);

        columnaSentencia.setIdentificador(selectItem.getColumn());
        columnaSentencia.setAlias(selectItem.getAlias());
        arregloColumnas.add(columnaSentencia);



        tablaSentencia.setIdentificador(table.getTable());
        tablaSentencia.setAlias(table.getAlias());


        sentenciaSelect.setColumnas(arregloColumnas);
        sentenciaSelect.setTabla(tablaSentencia);
//
//
////////////////////////////////////////////////////////////////////////////////


        ArrayList<ColumnaSentencia> columnasGSQL = sentenciaSelect.getColumnas();
        Iterator iterador = columnasGSQL.listIterator();


        System.out.println("\nSentencia Valida: \n");
        int contador = 1;
        while (iterador.hasNext()) {
            ColumnaSentencia columna = (ColumnaSentencia) iterador.next();
            System.out.println(contador + "er " + "Columna: " + columna.getIdentificador() + "\t Alias: " + columna.getAlias());
            contador++;
        }

        TablaSentencia tablaGSQL = sentenciaSelect.getTabla();
        System.out.println("\nNombre de la Tabla: " + tablaGSQL.getIdentificador() + "\t Alias de la Tabla: " + tablaGSQL.getAlias());
        System.exit(0);
    }

}
