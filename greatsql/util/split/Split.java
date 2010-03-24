/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.util.split;

/**
 *
 * @author aranzuglia
 */
public class Split {

    private int number;
    private String text;
    private int line;
    private int offset;

    public Split(int number, String text, int line, int offset) {
        this.number = number;
        this.text = text;
        this.line = line;
        this.offset = offset;
    }

    public String getText() {
        return text;
    }

    public int getOffset() {
        return offset;
    }

    public int getLine() {
        return line;
    }

    public int getNumber() {
        return number;
    }

}
