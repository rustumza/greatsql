/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greatsql.visitantes;

import java.util.ArrayList;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.ColumnIndex;
import net.sf.jsqlparser.statement.select.ColumnReferenceVisitor;

/**
 *
 * @author Ismael
 */
public class ColumnVisitor implements ColumnReferenceVisitor {

    public ArrayList<String> columnName = new ArrayList();
    public ArrayList<String> aliasColumnaTabla = new ArrayList();



    public ArrayList<String> getColumnName() {
        return columnName;
    }

    public ArrayList<String> getColumnTableAlias() {
        return aliasColumnaTabla;
    }
    //--------------------------------------------------------------------------

    public void visit(ColumnIndex arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void visit(Column arg0) {
        columnName.add(arg0.getColumnName());
        String wholeColumnName = arg0.getWholeColumnName();
        String[] alias = wholeColumnName.split("[.]");
        aliasColumnaTabla.add(alias[0]);
    }
}
