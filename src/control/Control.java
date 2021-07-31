/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clase.Perro;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 29/07/2021
 *
 */
public class Control {

    //Clase que se encargara del control de registro y vacunación
    private ArrayList<Perro> listaVeterinaria;
    private ArrayList<Perro> listaVacunados;
    private int contadorRegistro, contadorVacunados;

    //Creamos un contructor para inicializar nuestras listas
    public Control() {
        listaVeterinaria = new ArrayList<Perro>();
        listaVacunados = new ArrayList<Perro>();
        contadorVacunados = contadorRegistro = -1; //En esta linea indicammos que los dos valores valdran -1
    }

    //Método que me devuelve un objeto de la clase padre
    public Perro rellenar() {
        //Object[] options = {"M", "F"};
        Perro p = null;
        String nombre = JOptionPane.showInputDialog(null, "Introduce el nombre", "Introduciendo Nombre", 1);
        String raza = JOptionPane.showInputDialog(null, "Introduce la raza", "Introduciendo raza", 1);
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la edad", "Introduciendo edad", 1));
        String sex = JOptionPane.showInputDialog(null, "Introduce el sexo\nM: Masculino\nF: Femenino", "Sexo", 1);
        char sexo = sex.charAt(0);
        /*if(JOptionPane.showOptionDialog(null, "Sexo", "Elija el Sexo", JOptionPane.DEFAULT_OPTION, 3, null, options, options[0])==JOptionPane.YES_OPTION){
        
         }*/
        p = new Perro(nombre, raza, edad, sexo);
        return p;
    }

    //Método para realizar un registro de un perro
    public void registrarPerro(Perro perro) {
        listaVeterinaria.add(perro);
        JOptionPane.showMessageDialog(null, "El perro " + perro.getNombre() + " fue registrado correctamente", "Registro", 1);
        contadorRegistro++;
    }

    //Método para mostrar los perros en la veterinaria
    public void mostrarVeterinaria() {
        if (this.noEstaVacia()) {
            String cadena = "";
            for (Perro listaV : listaVeterinaria) {
                cadena = cadena + "\n" + listaV + "\n";
            }
            JOptionPane.showMessageDialog(null, cadena, "Veterinaria Registro", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Registro Vacio", "Registro Vacio", 2);
        }
    }

    //Método para vacunar a un perro
    public void vacunarPerro(String curp) {
        Perro perro;
        boolean encontrado = false;
        for (int i = 0; i < listaVeterinaria.size() && !encontrado; i++) {
            if (listaVeterinaria.get(i).getCurp().equalsIgnoreCase(curp)) {
                if (this.noEstaVaciaVacunados()) {
                    boolean bandera = false;
                    for (int j = 0; j < listaVacunados.size() && !bandera; j++) {
                        if (listaVacunados.get(j).getCurp().equalsIgnoreCase(curp)) {
                            JOptionPane.showMessageDialog(null, "Perro ya vacunado", "Vacunado ", 2);
                            bandera = true;
                        }
                        if (j == listaVacunados.size() - 1 && !bandera) {
                            JOptionPane.showMessageDialog(null, "Vacuna Aplicada " + "\nPerrro: " + listaVeterinaria.get(i).getNombre() + "\n" + "Dosis: " + listaVeterinaria.get(i).vacunar(), "Vacunación", 1);
                            perro = listaVeterinaria.get(i);
                            listaVacunados.add(perro);
                            contadorVacunados++;
                            bandera = true;
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Vacuna Aplicada " + "\nPerrro: " + listaVeterinaria.get(i).getNombre() + "\n" + "Dosis: " + listaVeterinaria.get(i).vacunar(), "Vacunación", 1);
                    perro = listaVeterinaria.get(i);
                    listaVacunados.add(perro);
                    contadorVacunados++;
                }

                encontrado = true;
            }
        }
        if (!encontrado) {
            JOptionPane.showConfirmDialog(null, "Curp no encontrara", "Error de busqueda", 0);
        }
    }

    //Método para mostrar el registro de los perros vacunados
    public void mostrarVacunados() {
        if (this.noEstaVaciaVacunados()) {
            String cadena = "";
            for (Perro i : listaVacunados) {
                cadena = cadena + "\n" + i.toString() + "Dosis: " + i.vacunar() + "\n";
            }
            JOptionPane.showMessageDialog(null, cadena, "Registro Vacunados", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Registro Vacunados Vacio", "Ningun Vacunado", 2);
        }
    }

    //Método para comprobar si las listas estan llenar o vacias
    public boolean noEstaVacia() {
        return contadorRegistro != -1;
    }

    public boolean noEstaVaciaVacunados() {
        return contadorVacunados != -1;
    }

}
