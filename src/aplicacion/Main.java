/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import clase.Perro;
import control.Control;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 29/07/2021
 * 
 */
public class Main {
    public static void main(String[] args) {
        Control control=new Control();
        
        Perro p=control.rellenar();
        
        control.registrarPerro(p);
        
        control.mostrarVeterinaria();
        control.vacunarPerro(p.getCurp());
        control.mostrarVacunados();
        //Parvorirosis
    }

}
