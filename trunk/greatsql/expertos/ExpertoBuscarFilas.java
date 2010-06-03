/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package greatsql.expertos;

import greatsql.expertos.resultados.TuplaAlmacenamiento;
import greatsql.expertos.resultados.TuplasAlmacenamiento;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rustu
 */
public class ExpertoBuscarFilas {
    
    final int longTamanio = 4;
    final int cantdidadDeColumnas = 3;

    public TuplasAlmacenamiento read() throws GreatSQLException{



        RandomAccessFile tabla; //abro el archivo
        try {
            tabla = new RandomAccessFile("/home/rustu/Escritorio/GreatSQL/tabla.great", "r");
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(ExpertoBuscarFilas.class.getName()).log(Level.SEVERE, null, ex);
            GreatSQLException exGreat=new GreatSQLException("hola",1,"hola",1,1);
            
            throw exGreat;
        }


        TuplasAlmacenamiento tuplas = new TuplasAlmacenamiento();
        tuplas.setTuplas(new ArrayList<TuplaAlmacenamiento>());
        byte registryState;
        int registryLengthInt=0;
        byte[] registryLength = new byte[longTamanio]; //no se si es registry o register
        String registryLengthString = new String();
        String registry = new String();
        TuplaAlmacenamiento tupla;
        int contadorvueltas =0;
        try {
            /*mientas que lea informacion de achivo hacer, si llega al final de
            archivo sale.
            lo que lee es el tamaño del archivo, que esta guardado como byte
             */
            while (tabla.read(registryLength, 0, longTamanio) != -1) {
                System.out.println("vuelta princ " + contadorvueltas);
                //trasnformo el tamaño del archivo a String para poder pasarlo luego a int
                for (int i = 0; i < longTamanio; i++) {
                    registryLengthString = registryLengthString + (char) registryLength[i];
                }
                System.out.println(registryLengthString);
                //paso el tamaño del archivo de String a int
                //System.out.println(registryLengthString);
                registryLengthInt = Integer.parseInt(registryLengthString);
                System.out.println("-----");
                System.out.println(registryLengthInt);
                System.out.println("-----");
                //variables auxiliares
                //en resultado se guarda el registro separado en culumnas
                //char[][] resultado = new char[cantdidadDeColumnas][];
                //en aux se guarda el registro cuando lo leo del disco
                byte[] aux = new byte[registryLengthInt];
                //a auxChar la uso para separar una columnas de la siguiente
                //char[] auxChar;
                //contadorColumnas se usa para saber cuantas columas se han separado (dentro de cada registro)
                //int contadorColumnas = 0;
                //verifico si el registro esta marcado como eliminado o como activo
                registryState = tabla.readByte();
                System.out.println((char) registryState);
                //si el registro esta activo lo muestro
                if ((char) registryState == 'y') {
                    tabla.read(aux, 0, registryLengthInt);
                    //transformo el arreglo de byte en un string
                    for(int i=0;i<registryLengthInt;i++){

                        registry = registry + (char) aux[i];

                    }
                    
                tupla= new TuplaAlmacenamiento();
                tupla.setFilaCompleta(registry);
                tuplas.getTuplas().add(tupla);

                } else {
                    /*si el registro ha sido marcado como eliminado entonces tengo
                    que saltarlo y seguir por el siguiente*/
                    /*
                    como seek() mueve a partir del principio del archivo, entonces
                    debemos pedir la posicion actual y sumarle el tamaño del registro
                    que queremos saltar. Este total seria el desplazamiento desde
                    el princiopio del archivo
                     */
                    tabla.seek(tabla.getFilePointer() + (long) registryLengthInt);
                }
                System.out.println("\n--------------------\n");
                //registryLength = new byte[longTamanio];
                registryLengthString = new String();
                contadorvueltas++;
                registry = new String();
                System.out.println("vuelta fin " + contadorvueltas);

            }


            return tuplas;

        } catch (IOException ex) {
            Logger.getLogger(ExpertoBuscarFilas.class.getName()).log(Level.SEVERE, null, ex);
            GreatSQLException exGreat=new GreatSQLException("hola",1,"hola",1,1);
           
            throw exGreat;

        }
    }










}
