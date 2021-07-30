/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

/**
 *
 * @author CxrlosMX
 */
public interface Metodos {
       //Método que nos genera un numero aleatorio
    public static int numeroAletatorio(int max, int min) {
        int n = (int) Math.floor(Math.random() * (max - min + 1)) + min;
        return n;
    }
    
    //Arreglo de Vacunas
    public final static String V1="Parvovirosis";
    public final static String V2="Bordetelosis";
    public final static String V3="Leptospirosis";
}
