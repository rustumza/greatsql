/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greatsql;

import greatsql.visitantes.SelectStatementVisitor;
import greatsql.sentencias.ColumnaSentencia;
import greatsql.sentencias.TablaSentencia;

import greatsql.sentencias.select.SentenciaSelect;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;

/**
 *
 * @author Ismael
 */
public class Main {

    public static void main(String[] args) {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            System.out.println("Ingrese sentencia: ");
            String sql = br.readLine();
            CCJSqlParserManager pm = new CCJSqlParserManager();
            Statement statement;
            try {
                statement = pm.parse(new StringReader(sql));
                if (statement instanceof Select) {
                    execSelect(statement);
                } else {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            } catch (JSQLParserException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Sintaxis invalida", ex);
            }

        } catch (IOException ex) {
            System.out.println("Error al leer buffered reader\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void execSelect(Statement statement) {
        SentenciaSelect sentenciaSelect = translateSelect((Select) statement);
        // Buscar datos en el archivo...
    }

    private static SentenciaSelect translateSelect(Select statement) {

        //Obtenemos los datos---------------------------------------------------
        Select selectStatement = (Select) statement;
        SelectStatementVisitor selectStatementVisitor = new SelectStatementVisitor();
        selectStatement.getSelectBody().accept(selectStatementVisitor);
        String tableName = selectStatementVisitor.getTableName();
        ArrayList columnsList = selectStatementVisitor.getColumnsName();

        // Traduccion a Objetos GreatSql----------------------------------------
        SentenciaSelect sentenciaSelect = new SentenciaSelect();

                    // Tablas de la sentencia
             TablaSentencia tablaSentencia = new TablaSentencia();
             tablaSentencia.setIdentificador(tableName);
             sentenciaSelect.setTabla(tablaSentencia);

                    // Columnas de la sentencia
             Iterator itColumn = columnsList.listIterator();
             ArrayList<ColumnaSentencia> columnas = new ArrayList<ColumnaSentencia>();
             while (itColumn.hasNext()) {
                   ColumnaSentencia columnaSentencia = new ColumnaSentencia();
                   columnaSentencia.setIdentificador((String) itColumn.next());
                   columnas.add(columnaSentencia);
                    }
             sentenciaSelect.setColumnas(columnas);
         //---------------------------------------------------------------------


      return sentenciaSelect;
    }
}


