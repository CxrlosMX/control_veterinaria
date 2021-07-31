/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase;

import javax.swing.JOptionPane;
import metodos.Metodos;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 29/07/2021
 *
 */
public class Perro {

    //Atributos propios
    private String nombre;
    private String raza;
    private String curp;
    private int edad;
    private char sexo;

    public Perro(String nombre, String raza, int edad, char sexo) {
        this.nombre = nombre;
        this.raza = raza;
        verificarSexo(sexo);
        this.curp = generarCurp();
        comprobarEdad(edad); //Método que comprueba si la edad del perro es correcta

    }

    private void verificarSexo(char sex) {
        char[] arreglo = {'M', 'F'};
        boolean encontrado = false;
        for (int i = 0; i < arreglo.length && !encontrado; i++) {
            if (arreglo[i] == sex) {
                this.sexo = sex;
                encontrado=true;
            }
        }
        if (!encontrado) {
            this.sexo = 'U';
        }

    }

    //Método para verificar la edad del perro
    private void comprobarEdad(int e) {
        if (e > 0) {
            this.edad = e;
        } else {
            this.edad = 1;
        }
    }

    private String generarCurp() {
        String cadena = "";
        char a;
        int n;
        for (int i = 0; i < 4; i++) {
            //Generamos un numero aleatorio del 1 al 2
            n = Metodos.numeroAletatorio(2, 1);
            if (n == 1) {//Si el numero generado es 1, agregaremos un valor numerico a la cadena
                n = Metodos.numeroAletatorio(57, 48);
                a = (char) n; //Le decimos al programa que el valor del char sera el valor numerico que nos arroje
                cadena += a;//Le sumamos ese caracter a nuestra cadena
            } else {//Si nos arroja un numero diferente de 1 nos generara una Letra
                n = Metodos.numeroAletatorio(90, 65);
                a = (char) n; //Hacemos un casteo para el valor de tipo char
                cadena += a;
            }
        }
        return cadena;
    }

    //Métodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    //Método para vacunar
    public String vacunar() {
        String c = "";
        if (this.edad <= 2) {
            //  JOptionPane.showMessageDialog(null, "Vacuna Aplicada " + nombre + "\n" + "Dosis: " + Metodos.V1, nombre, 1);
            c = Metodos.V1;
        } else if (edad > 2 && edad <= 4) {
            // JOptionPane.showMessageDialog(null, "Vacuna Aplicada " + nombre + "\n" + "Dosis: " + Metodos.V2, nombre, 1);
            c = Metodos.V2;

        } else {
            //JOptionPane.showMessageDialog(null, "Vacuna Aplicada " + nombre + "\n" + "Dosis: " + Metodos.V3, nombre, 1);
            c = Metodos.V3;

        }
        return c;
    }

    //Método para imprimir datos del perro
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nRaza: " + raza + "\nSexo: " + sexo + "\nCurp: " + curp + "\nEdad: " + edad + "años\n";
    }

}
