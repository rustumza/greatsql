/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.expertos.sintaxis;

/**
 *
 * @author rustu
 */
public class pruebastring {

    public static void main(String[] args) {
        String x = "a|b%||c";

        //x = x.replaceAll("[%|]", "|");

        //System.out.println(x);

        for (String s : x.split("[[|]&&[^%[|]]]")) {
            System.out.println(s);
        }
    }

}
