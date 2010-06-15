/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.expertos;

import greatsql.catalogo.ExpertoLeerCatalogo;
import greatsql.catalogo.jaxb.BaseDatosType;
import greatsql.catalogo.jaxb.ColumnaType;
import greatsql.expertos.resultados.TuplaAlmacenamiento;
import greatsql.expertos.resultados.TuplaObjetos;
import greatsql.expertos.resultados.TuplasAlmacenamiento;
import greatsql.expertos.resultados.TuplasObjetos;
import greatsql.expertos.resultados.ValorTuplaObjetos;
import greatsql.sentencias.ColumnaObjetos;
import greatsql.sentencias.TipoDato;
import java.util.ArrayList;

/**
 *
 * @author rustu
 */
public class ConvertirFilasAObjetos {


    public TuplasObjetos convertirFilas(TuplasAlmacenamiento tuplas) {

        TuplasObjetos tuplasObjetos= new TuplasObjetos();

        //Agrego los nombres y tipos de columnas del catalogo en el arraylist columnas
        ExpertoLeerCatalogo expertoLeerCatalogo= new ExpertoLeerCatalogo();

        BaseDatosType baseDeDatos=expertoLeerCatalogo.leer("/home/rustu/Escritorio","GreatSQL");
        ArrayList<ColumnaObjetos> columnas = new ArrayList<ColumnaObjetos>();
        ColumnaObjetos aux;

        for(ColumnaType colType : baseDeDatos.getTabla().getColumna()){

            aux = new ColumnaObjetos();
            aux.setNombre(colType.getNombre());

             //aca va lo de elegir el tipo de la columna
            if(colType.getTipo().equalsIgnoreCase(TipoDato.STRING.name())) {
                aux.setTipoDato(TipoDato.STRING);
            }else if(colType.getTipo().equalsIgnoreCase(TipoDato.BOOLEAN.name())) {
                aux.setTipoDato(TipoDato.BOOLEAN);               
            }else if(colType.getTipo().equalsIgnoreCase(TipoDato.DATE.name())) {
                aux.setTipoDato(TipoDato.DATE);
            }else if(colType.getTipo().equalsIgnoreCase(TipoDato.DOUBLE.name())) {
                aux.setTipoDato(TipoDato.DOUBLE);
            }else if(colType.getTipo().equalsIgnoreCase(TipoDato.INTEGER.name())) {
                aux.setTipoDato(TipoDato.INTEGER);
            }

            columnas.add(aux);

        }
        tuplasObjetos.setColumnas(columnas);


        //Agrego la lista con todos los registros (cada uno separado por columnas en un arraylist)

        int contadorColumnas = 0;
        int cantidadDeColumnas = tuplasObjetos.getColumnas().size();
        int bandera = 0;
        char[] auxChar;
        tuplasObjetos.setTuplas(new ArrayList<TuplaObjetos>());
        int contadorFilas=0;
        for(TuplaAlmacenamiento tuplAlm : tuplas.getTuplas()){

            TuplaObjetos tuplaObjeto =new TuplaObjetos();
            tuplaObjeto.setNumero(contadorFilas);
            tuplaObjeto.setValores(new ArrayList<ValorTuplaObjetos>());

            //banderaTotal se usa para saber cauntos caracteres se han recorrido dentro del registro
            int banderaTotal = 0;
            char[] filaCompletaChar = tuplAlm.getFilaCompleta().toCharArray();
            int registryLengthInt = tuplAlm.getFilaCompleta().length();
            while (contadorColumnas < cantidadDeColumnas) {
                auxChar = new char[50];
                //con este while separo las columnas buscando los separadores '|'
                //s
                while (banderaTotal < registryLengthInt && filaCompletaChar[banderaTotal] != '|') {
                    //Esto es por si hay un '|' en el texto que no es separador de registros, la forma de indicarlo es poner un '%' antes del '|'
                    if(filaCompletaChar[banderaTotal]== '%'){
                        if(filaCompletaChar[banderaTotal+1] == '|'){
                            auxChar[bandera]=filaCompletaChar[banderaTotal+1];
                            bandera++;
                            banderaTotal++;
                        }
                    }else{
                        auxChar[bandera] = filaCompletaChar[banderaTotal];
                        bandera++;
                        banderaTotal++;
                
                    }
                }
                System.out.println(auxChar);
                bandera = 0;
                banderaTotal++;

                ValorTuplaObjetos valorTuplaObj = new ValorTuplaObjetos();
                valorTuplaObj.setValor(String.copyValueOf(auxChar));
                valorTuplaObj.setColumna(tuplasObjetos.getColumnas().get(contadorColumnas));
                tuplaObjeto.getValores().add(valorTuplaObj);
                
                contadorColumnas++;
            }
            contadorColumnas=0;
            contadorFilas++;
            
            tuplasObjetos.getTuplas().add(tuplaObjeto);

        }



        tuplasObjetos.setTiempoEjecucion(tuplas.getTiempoEjecucion());
        tuplasObjetos.setPlanificacion(tuplas.getPlanificacion());
        
        
        return tuplasObjetos;
    }


}
