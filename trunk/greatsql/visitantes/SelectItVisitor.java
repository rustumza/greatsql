/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greatsql.visitantes;

import java.util.ArrayList;
import net.sf.jsqlparser.statement.select.AllColumns;
import net.sf.jsqlparser.statement.select.AllTableColumns;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectItemVisitor;

/**
 *
 * @author Ismael
 */
public class SelectItVisitor implements SelectItemVisitor {

    public String allColumns;
    public ExpressionInVisitor expressionVisitor = new ExpressionInVisitor();
    ArrayList<String> columnsName = new ArrayList<String>();
    ArrayList<String> columnsAlias;

    public String getAllColumns() {
        return allColumns;
    }

    public ArrayList<String> getColumnAlias() {
        columnsAlias = expressionVisitor.getColumnAlias();
        return columnsAlias;
    }

    public ArrayList<String> getColumnName() {
        columnsName = expressionVisitor.getColumnName();
        if (!columnsName.isEmpty()) {
            return columnsName;
        } else {
            columnsName.add(getAllColumns());
            return columnsName;
        }
    }

    //--------------------------------------------------------------------------
    public void visit(AllColumns arg0) {
        allColumns = arg0.toString();
    }

    public void visit(AllTableColumns arg0) {
        System.out.println("Esto que es?:" + arg0.toString());
    }

    public void visit(SelectExpressionItem arg0) {

        arg0.getExpression().accept(expressionVisitor);

    }
}
