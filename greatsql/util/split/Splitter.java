/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.util.split;

import greatsql.expertos.GreatSQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aranzuglia
 */
public final class Splitter {

    private Map<String, Splits> cache;

    private static Splitter instance;

    private Splitter() {
        cache = new HashMap<String, Splits>();
    }

    public static Splitter getInstance() {
        if (instance == null) {
            instance = new Splitter();
        }

        return instance;
    }

    public Splits split(String sentence) throws GreatSQLException {
        try {
            if (cache.containsKey(sentence)) {
                Splits splits = cache.get(sentence);
                splits.setInCache(true);

                return splits;
            }

            Splits splits = new Splits();
            splits.setSplitParts(new ArrayList<Split>());

            BufferedReader reader = new BufferedReader(new StringReader(sentence));

            String sentenceLine;
            int lineNumber = 1;
            Integer splitNumber = 1;
            while ((sentenceLine = reader.readLine()) != null) {
                splits.getSplitParts().addAll(splitLine(sentenceLine, lineNumber, splitNumber));

                lineNumber++;
            }

            cache.put(sentence, splits);

            return splits;
        } catch (IOException ex) {
            throw new GreatSQLException(ex);
        }
    }

    private Collection<Split> splitLine(String sentenceLine, int lineNumber, Integer splitNumber) {
        Collection<Split> splits = new ArrayList<Split>();

        int index;
        int offset = 0;

        while ((index = sentenceLine.indexOf(" ", offset)) != -1) {
            String text = sentenceLine.substring(offset, index);

            if (text.trim().length() == 0) {
                offset = index + 1;

                continue;
            }

            splits.add(new Split(splitNumber++, text, lineNumber, offset + 1));

            offset = index + 1;

            if (offset == sentenceLine.length()) {
                break;
            }
        }

        if (offset < sentenceLine.length()) {
            String text = sentenceLine.substring(offset);

            if (text.trim().length() > 0) {
                splits.add(new Split(splitNumber++, text, lineNumber, offset + 1));
            }
        }

        return splits;
    }

    public static void main(String[] args) throws GreatSQLException {
        for (Split s : getInstance().split("          sel   * from tabla  " ).getSplitParts()) {
            System.out.println(s.getText());
            System.out.println(s.getOffset());
        }

        System.out.println(getInstance().split("s * f t").isInCache());
        System.out.println(getInstance().split("s * f t").isInCache());
    }

}
