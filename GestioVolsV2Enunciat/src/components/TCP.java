/*
 * Un tripulant de cabina de passatgers (TCP) es defineix pel seu passaport, nom
 * , edat, data d’alta en la companyia, hores que porta de vol i rang
 */
package components;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class TCP extends Tripulant {

    private final static Scanner DADES = new Scanner(System.in);

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys dataAlta rang.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     - Inicialitzar l'atribut dataAlta amb l'hora actual del sistema.
     - Inicialitzar l'atribut rang a null, ja que quan es crea un TCP, mai té rang.
     */
    public TCP(String passaport, String nom, int edat, int horesVol) {
        
        super (passaport, nom, edat, horesVol);
        
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou tripulant de cabina.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que el nom no té per què estar format per una única 
    paraula, per exemple, Pep Gómez.
    - També heu de tenir en compte que les hores de vol són de tipus LocalTime, per
    tant heu de demanar a l'usuari les hores i minuts per crear el LocalTime. En aquest
    cas es considerarà que els segons i nanosegons, sempre són  0.
     */
    public static TCP nouTCP() {
        String passaport, nom;
        int edat, hores, minuts;

        System.out.println("\nPassaport del tripulant:");
        passaport = DADES.next();
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nNom del tripulant:");
        nom = DADES.nextLine();
        System.out.println("\nEdat del tripulant:");
        edat = DADES.nextInt();

        System.out.println("\nHores de vol del tripulant:");
        hores = DADES.nextInt();

        return new TCP(passaport, nom, edat, hores);
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte menys data d'alta i
     rang.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los. En el cas de les hores de vol, només se li han
     de mostrar les hores i minuts.
    
     Retorn: cap
     */
    public void modificarComponent() throws ParseException {
        
        super.modificarComponent();
        
    }

    public void mostrarComponent() {
        
        super.mostrarComponent();
        
    }

}
