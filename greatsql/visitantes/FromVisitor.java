/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greatsql.visitantes;

import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.FromItemVisitor;
import net.sf.jsqlparser.statement.select.SubJoin;
import net.sf.jsqlparser.statement.select.SubSelect;

/**
 *
 * @author Ismael
 */
public class FromVisitor implements FromItemVisitor {

    InTableVisitor intoTableVisitor = new InTableVisitor();

    public String getTableAliasList() {
        return intoTableVisitor.getTableAlias();
    }

    public String getTableNameList() {
        return intoTableVisitor.getTableName();
    }

    //--------------------------------------------------------------------------
    public void visit(Table arg0) {
        arg0.accept(intoTableVisitor);

    }

    public void visit(SubSelect arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void visit(SubJoin arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
