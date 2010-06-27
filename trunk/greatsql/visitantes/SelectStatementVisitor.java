/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greatsql.visitantes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectItem;
import net.sf.jsqlparser.statement.select.SelectVisitor;
import net.sf.jsqlparser.statement.select.Union;

/**
 *
 * @author Ismael
 */
public class SelectStatementVisitor implements SelectVisitor {

    SelectItVisitor selectItemVisitor = new SelectItVisitor();
    FromVisitor fromVisitor = new FromVisitor();

    public ArrayList getColumnsName() {
        return selectItemVisitor.getColumnName();
    }

    public String getTableName() {
        return fromVisitor.getTableNameList();
    }

    public ArrayList getSelectTableAlias() {
        return selectItemVisitor.getColumnAlias();
    }

    public String getFromTableAlias() {
        return fromVisitor.getTableAliasList();
    }

    //--------------------------------------------------------------------------
    public void visit(PlainSelect arg0) {
        List selectItemsList = arg0.getSelectItems();
        Iterator it = selectItemsList.listIterator();
        while (it.hasNext()) {
            SelectItem selectItem = (SelectItem) it.next();
            selectItem.accept(selectItemVisitor);
        }
        arg0.getFromItem().accept(fromVisitor);
    }

    public void visit(Union arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
