/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.catalogo;

import greatsql.catalogo.jaxb.BaseDatosType;
import greatsql.catalogo.jaxb.ObjectFactory;
import greatsql.catalogo.jaxb.TablaType;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author aranzuglia
 */
public class Test {

    public static void main(String[] args) throws IOException, JAXBException {
        ObjectFactory factory = new ObjectFactory();

        BaseDatosType baseDatos = factory.createBaseDatosType();
        TablaType tabla = factory.createTablaType();
        baseDatos.setTabla(tabla);

        JAXBContext context = JAXBContext.newInstance("greatsql.catalogo.jaxb");

        Marshaller marshaller = context.createMarshaller();

        marshaller.marshal(
            factory.createBaseDatos(baseDatos),
            new FileWriter("/home/aranzuglia/Desktop/test.xml"));
    }

}
