/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.catalogo;

import greatsql.catalogo.jaxb.BaseDatosType;
import greatsql.catalogo.jaxb.ColumnaType;
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
public class TestEscritura {

    public static void main(String[] args) throws IOException, JAXBException {
        int cantColumnas = 3;
        String[] nombresColumnas = {"Nombre","DNI","Apellido"};
        
        ObjectFactory factory = new ObjectFactory();

        BaseDatosType baseDatos = factory.createBaseDatosType();
        TablaType tabla = factory.createTablaType();

        for (int i=0; i<cantColumnas;i++){
            ColumnaType columna = factory.createColumnaType();
            columna.setNombre(nombresColumnas[i]);
            columna.setTipo("String");
            tabla.getColumna().add(columna);
        }

        baseDatos.setTabla(tabla);

        JAXBContext context = JAXBContext.newInstance("greatsql.catalogo.jaxb");

        Marshaller marshaller = context.createMarshaller();

        marshaller.marshal(
            factory.createBaseDatos(baseDatos),
            new FileWriter("/home/rustu/Escritorio/GreatSQL/catalogo.xml"));
    }

}
