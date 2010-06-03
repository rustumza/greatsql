/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.catalogo;

import greatsql.catalogo.jaxb.BaseDatosType;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author rustu
 */
public class TestLectura {

    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance("greatsql.catalogo.jaxb");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        BaseDatosType bd =
                (BaseDatosType)
                    ((JAXBElement)
                    unmarshaller.unmarshal(
                        new FileReader("/home/rustu/Escritorio/GreatSQL/catalogo.xml"))).getValue();

        System.out.println(bd.getTabla().getColumna().get(0).getNombre());
        System.out.println(bd.getTabla().getColumna().get(0).getTipo());
        System.out.println(bd.getTabla().getColumna().get(1).getNombre());
        System.out.println(bd.getTabla().getColumna().get(1).getTipo());
        System.out.println(bd.getTabla().getColumna().get(2).getNombre());
        System.out.println(bd.getTabla().getColumna().get(2).getTipo());
    }

}
