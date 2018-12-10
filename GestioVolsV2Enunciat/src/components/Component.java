/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Albert
 */
public interface Component {
    
    Scanner DADES = new Scanner(System.in);
    
    void mostrarComponent();
    
    public void modificarComponent() throws ParseException;
    
    default Object demanarDades(String peticio, int tipus) {
        
        Object item = new Object();
        
        System.out.print(peticio);
        
        switch (tipus) {
            case 1: item = DADES.nextInt();
            break;
            case 2: item = DADES.next();
            break;
            case 3: item = DADES.nextDouble();
            break;
            case 4: item = DADES.nextLine();
            break;
        }
        
        return item;
        
    }
        
        
}
