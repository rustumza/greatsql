/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greatsql.analisisSintactico;

import greatsql.expertos.CodigosError;
import greatsql.expertos.GreatSQLException;
import greatsql.visitantes.SelectStatementVisitor;
import java.util.ArrayList;
import java.util.Iterator;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;

/**
 *
 * @author Ismael
 */
public class AnalizadorSelect implements AnalisisSintactico {

    public void analizar(Statement statement) throws GreatSQLException  {

        //Obtenemos los datos---------------------------------------------------
        Select selectStatement = (Select) statement;
        SelectStatementVisitor selectStatementVisitor = new SelectStatementVisitor();
        selectStatement.getSelectBody().accept(selectStatementVisitor);
        ArrayList<String> columnsList = selectStatementVisitor.getColumnsName();
        String tableAlias = selectStatementVisitor.getFromTableAlias();
        ArrayList columnsAliasList = selectStatementVisitor.getSelectTableAlias();
        if(!tableAlias.equalsIgnoreCase((String) columnsAliasList.get(0))){
            throw new GreatSQLException(CodigosError.SINTAXIS_INVALIDA);
        }else{
        String tableName = selectStatementVisitor.getTableName();
        System.out.println("Tabla: " + tableName);
        System.out.println("Alias tabla: " + tableAlias);
        System.out.println("Columnas: ");
        Iterator it = columnsList.listIterator();
        while (it.hasNext()) {
            String nombreTabla = (String) it.next();
            System.out.println(nombreTabla);
        }
        }
    }
}
