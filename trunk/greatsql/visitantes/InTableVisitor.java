/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greatsql.visitantes;

import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.IntoTableVisitor;

/**
 *
 * @author Ismael
 */
public class InTableVisitor implements IntoTableVisitor {

    String tableName;
    String tableAlias;

    public void visit(Table arg0) {
        tableName = arg0.getName();
        tableAlias = arg0.getAlias();
    }

    //----------------------------------------------------------------------
    public String getTableAlias() {
        return tableAlias;
    }

    public String getTableName() {
        return tableName;
    }
}
