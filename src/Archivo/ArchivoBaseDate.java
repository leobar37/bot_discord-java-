package Archivo;

import ListasAux.ListaEnlazada;
import java.io.BufferedReader;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArchivoBaseDate {

    public static void GuardarLita(ListasAux.ListaEnlazada lista, String nameLista) {
        try {
            FileOutputStream flujoSalida = new FileOutputStream(nameLista + ".bin");
            ObjectOutputStream flujo = new ObjectOutputStream(flujoSalida);
            for (int i = 0; i < lista.tamaño(); i++) {
                Object objeto = lista.Buscar(i);
                flujo.writeObject(objeto);
            }
            flujo.close();
            flujoSalida.close();

        } catch (FileNotFoundException ex) {
            System.err.println("Error" + ex);
        } catch (IOException ex) {
            System.err.println("Error" + ex);
        }
    }

    public static ListasAux.ListaEnlazada ObtenerLista(String nameLista) {
        ListasAux.ListaEnlazada obj = new ListaEnlazada();
        try {
            FileInputStream flujoEntrada = new FileInputStream(nameLista + ".bin");
            ObjectInputStream flujo = new ObjectInputStream(flujoEntrada);
            while (true) {
                Object objProyecto = flujo.readObject();
                obj.agregar(objProyecto);

            }

        } catch (EOFException ex) {

            return obj;

        } catch (FileNotFoundException ex) {
            System.err.println("Error" + ex);
        } catch (IOException ex) {
            System.err.println("Error" + ex);
        } catch (ClassNotFoundException ex) {
            System.err.println("Error" + ex);
        }
        return obj;
    }

    //***********************archivo texto********************//
    /* 
   private void EscribirTexto(String texto){
      try {
           //cuando le ponemos por parametro true este va activar el metodo append
           //cuando no se lo ponemos opta por solo chancar el texto que se encuentra en el archivo
           FileWriter escribir = new FileWriter(archivo,true);
           escribir.write(texto);
           escribir.close();
       } catch (IOException ex) {
           System.err.println("no se pudo escribir el archivo");
       }
       
       
   }*/
    public static ListaEnlazada leerTexto(String direc) {
        ListaEnlazada texto = new ListaEnlazada();
        String cadena;
        try {
            FileReader lectura = new FileReader(direc + ".txt");
            BufferedReader lector = new BufferedReader(lectura);

            cadena = lector.readLine();
            while (cadena != null) {
                System.out.println(cadena);
                cadena = lector.readLine();
                texto.agregar(cadena);
                System.out.println("c" + cadena);
            }

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
        return texto;
    }
      public static ListaEnlazada leerTexGrande(String direc) {
        ListaEnlazada texto = new ListaEnlazada();
        String cadena;
        try {
            FileReader lectura = new FileReader(direc + ".txt");
            BufferedReader lector = new BufferedReader(lectura);

            cadena = lector.readLine();
            while (cadena != null) {
                cadena = lector.readLine();
                cadena+="\n";
                texto.agregar(cadena);
                System.out.println("c" + cadena);
            }

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
        return texto;
    }
         public static ListaEnlazada abrirArchivoGrande(String name){
         ListaEnlazada listChistes = new ListaEnlazada();
        String contenido= "";
        try {
             File direccion = new File(name+".txt");
           FileInputStream entrada = new FileInputStream(direccion);
            int car;
            while ((car = entrada.read()) != -1){
                char  caracter = (char)car;
                 if(caracter != '%'){
                  contenido = contenido + caracter;  
                }else{
                     listChistes.agregar(contenido);
                     contenido = "";
                 }             
            }
        } catch (Exception e) {           
        }
        return  listChistes;
        
    }
  
}
