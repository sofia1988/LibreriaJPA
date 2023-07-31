package libreria;

import libreria.servicios.ServiciosLibro;

public class Libreria {

    public static void main(String[] args) {
        ServiciosLibro serviciosLibro = new ServiciosLibro();

//        try {
//            serviciosLibro.ingresarLibro();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("EXCEPCION AL INGRESAR LIBRO");
//
//        }
        try {
            serviciosLibro.buscarporNombredeAutor();
        } catch (Exception e) {
            System.err.println("error" + e.getMessage());
           
        }
    }

}
