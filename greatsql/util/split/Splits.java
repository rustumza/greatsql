/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.util.split;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author aranzuglia
 */
public class Splits {

    private Collection<Split> splitParts;
    private boolean inCache;

    public Collection<Split> getSplitParts() {
        return splitParts;
    }

    public Collection<Split> getSplitParts(int beginNumber, int endNumber) {
        Collection<Split> splits = new ArrayList<Split>();

        for (Split split : splitParts) {
            if (split.getNumber() >= beginNumber && split.getNumber() <= endNumber) {
                splits.add(split);
            }
        }

        return splits;
    }

    public void setSplitParts(Collection<Split> splitParts) {
        this.splitParts = splitParts;
    }

    public boolean isInCache() {
        return inCache;
    }

    public void setInCache(boolean inCache) {
        this.inCache = inCache;
    }

    public Split getFirst() {
        return splitParts.iterator().next();
    }

}
