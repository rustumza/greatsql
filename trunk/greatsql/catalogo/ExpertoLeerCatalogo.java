/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.catalogo;

import greatsql.catalogo.jaxb.BaseDatosType;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author rustu
 */
public class ExpertoLeerCatalogo {

    public BaseDatosType leer(){

        try{
        JAXBContext context = JAXBContext.newInstance("greatsql.catalogo.jaxb");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        BaseDatosType bd =
                (BaseDatosType)
                    ((JAXBElement)
                    unmarshaller.unmarshal(
                        new FileReader("/home/rustu/Escritorio/GreatSQL/catalogo.xml"))).getValue();

        return bd;
        }catch(Exception e){        
        System.out.println("error al leer el catalogo");
        System.out.println(e.getMessage());
        return null;
        }

    }



}
