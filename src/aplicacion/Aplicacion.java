/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import clase.Perro;
import control.Control;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 30/07/2021
 *
 */
public class Aplicacion {

    public static void main(String[] args) {
        //Variables para controlar el flujo del programa
        int op = 0, op2 = 0;
        //Instancia Control
        Control control = new Control();
        Perro perro;
        JOptionPane.showMessageDialog(null, "BIENVENIDO A VETERINARIA ROSY", "Bienvenido", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/icono1.jpg"));
        do {
            try {

                op = Integer.parseInt(JOptionPane.showInputDialog(null, "VETERINARIA\n"
                        + "1.-Registrar Perro\n"
                        + "2.-Vacunar\n"
                        + "3.-Mostrar Registro\n"
                        + "4.-Salir\n¿Qué desea realizar?", "Veterinaria Rosy", 3));

                switch (op) {
                    case 1: {
                        perro = control.rellenar();
                        control.registrarPerro(perro);
                        break;
                    }
                    case 2: {
                        do {
                            try {
                                op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "VACUNACIÓN\n1.-Vacunar\n2.-Mostrar Registro Vacunados\n3.-Salir al Menu principal", "Vacunación", 3));
                                switch (op2) {
                                    case 1: {
                                        if (control.noEstaVacia()) {
                                            String curp = JOptionPane.showInputDialog(null, "Introduce la curp del perro", "Vacunando", 1);
                                            control.vacunarPerro(curp);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Registro de la veterinaria vacio", "Registro Vacio", 0);
                                        }
                                        break;
                                    }
                                    case 2: {
                                        control.mostrarVacunados();
                                        break;
                                    }
                                    case 3: {
                                        JOptionPane.showMessageDialog(null, "Saliendo al menu principal", "Saliendo", 1);
                                        break;
                                    }
                                    default: {
                                        JOptionPane.showMessageDialog(null, "Introduce una opción valida", "Error de Opción", 2);
                                        break;
                                    }
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Error", 0);
                            }

                        } while (op2 != 3);
                        break;
                    }
                    case 3: {
                        control.mostrarVeterinaria();
                        break;
                    }
                    case 4: {
                        JOptionPane.showMessageDialog(null, "Cerrando Programa", "Saliendo", 1);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Introduce una opción valida", "Error de Opción", 2);
                        break;
                    }

                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Error", 0);
            }
        } while (op != 4);

    }

}
