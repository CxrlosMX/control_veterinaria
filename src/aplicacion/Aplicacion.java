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
        int op = 0, op1 = 0;
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
                        + "4.-Salir\n¿Qué desea realizar?", "Veterinaria Rosy", 1));
                
                switch (op) {
                    case 1: {
                        perro = control.rellenar();
                        control.registrarPerro(perro);
                        break;
                    }
                    case 2: {
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
