/*
 * Una classe Aplicacio per interactuar amb l'usuari, que contengui les companyies 
 * i cridar a la resta de classes i mètodes mitjançant uns menús.
 */
package principal;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Aplicacio {

    private final static Scanner DADES = new Scanner(System.in);
    private static Companyia[] companyies = new Companyia[5];
    private static int posicioCompanyies = 0; //La propera posició buida del vector companyies
    private static Companyia companyiaActual = null; //Companyia seleccionada

    public static void main(String[] args) throws ParseException {
        menuPrincipal();
    }

    private static void menuPrincipal() throws ParseException {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió de companyies");
            System.out.println("\n2. Gestió d'avions");
            System.out.println("\n3. Gestió de rutes nacionals");
            System.out.println("\n4. Gestió de rutes internacionals");
            System.out.println("\n5. Gestió de rutes intercontinentals");
            System.out.println("\n6. Gestió de rutes transoceàniques");
            System.out.println("\n7. Gestió de tripulants de cabina");
            System.out.println("\n8. Gestió de tripulants de cabina de passatgers");
            System.out.println("\n9. Gestió de vols");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuCompanyes();
                    break;
                case 2:
                    if (companyiaActual != null) {
                        menuComponents(1);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 3:
                    if (companyiaActual != null) {
                        menuComponents(2);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 4:
                    if (companyiaActual != null) {
                        menuComponents(3);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 5:
                    if (companyiaActual != null) {
                        menuComponents(4);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 6:
                    if (companyiaActual != null) {
                        menuComponents(5);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 7:
                    if (companyiaActual != null) {
                        menuComponents(6);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 8:
                    if (companyiaActual != null) {
                        menuComponents(7);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                case 9:
                    if (companyiaActual != null) {
                        menuComponents(8);
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la companyia en el menú de companyes");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuCompanyes() throws ParseException {
        int opcio = 0;

        do {
            int pos = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. LListar companyes");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    companyies[posicioCompanyies] = Companyia.novaCompanyia();
                    posicioCompanyies++;
                    break;
                case 2:
                    pos = selectCompanyia();
                    if (pos >= 0) {
                        companyiaActual = companyies[pos];
                    } else {
                        System.out.println("\nNo existeix aquesta companyia");
                    }
                    break;
                case 3:
                    pos = selectCompanyia();
                    if (pos >= 0) {
                        companyies[pos].modificarComponent();
                    } else {
                        System.out.println("\nNo existeix aquesta companyia");
                    }
                    break;
                case 4:
                    for (int i = 0; i < posicioCompanyies; i++) {
                        companyies[i].mostrarComponent();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }
    
    public static void menuComponents(int tipus) throws ParseException {
        int opcio = 0;
        
        if (tipus<8){
            do {
                System.out.println("\nSelecciona una opció");
                System.out.println("\n0. Sortir");
                System.out.println("\n1. Alta");
                System.out.println("\n2. Modificar");
                System.out.println("\n3. Llistar component");

                opcio = DADES.nextInt();

                switch (opcio) {
                    case 0:
                        break;
                    case 1:
                        switch (tipus) {
                            case 1:
                                companyiaActual.afegirAvio();
                                break;
                            case 2:
                                companyiaActual.afegirRutaNacional();
                                break;
                            case 3:
                                companyiaActual.afegirRutaInternacional();
                                break;
                            case 4:
                                companyiaActual.afegirRutaIntercontinental();
                                break;
                            case 5:
                                companyiaActual.afegirRutaTransoceanica();
                                break;
                            case 6:
                                companyiaActual.afegirTripulantCabina();
                                break;
                            case 7:
                                companyiaActual.afegirTCP();
                                break;
                        }
                        break;
                    case 2:
                        int pos;
                        if (tipus==1){
                            pos = companyiaActual.seleccionarComponent(1, null);
                        }
                        if (tipus<6){
                            pos = companyiaActual.seleccionarComponent(2, null);
                        }
                        else {
                            pos = companyiaActual.seleccionarComponent(3, null);
                        }
                        
                        if (pos >= 0) {
                            companyiaActual.getComponents()[pos].modificarComponent();
                        } else {
                            System.out.println("\nNo existeix aquest component");
                        }
                        break;
                    case 3:
                        for (int i = 0; i < companyiaActual.getPosicioComponents(); i++) {
                            companyiaActual.getComponents()[i].mostrarComponent();
                        }
                        break;
                    default:
                        System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                        break;
                }
            } while (opcio != 0);
        }
        else {
            do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Afegir avió");
            System.out.println("\n4. Afegir ruta");
            System.out.println("\n5. Afegir tripulant");
            System.out.println("\n6. Llistar vols");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    companyiaActual.afegirVol();
                    break;
                case 2:
                    int pos = companyiaActual.seleccionarComponent(4, null);
                    if (pos >= 0) {
                        companyiaActual.getComponents()[pos].modificarComponent();
                    } else {
                        System.out.println("\nNo existeix aquest vol");
                    }
                    break;
                case 3:
                    companyiaActual.afegirAvioVol();
                    break;
                case 4:
                    int tipusRuta;
                    System.out.println("\nQuin tipus de ruta vols afegir? (2:nacional, 3:internacional, 4:intercontinental, 5:transoceànica)");
                    tipusRuta = DADES.nextInt();
                    if (tipusRuta >= 2 && tipusRuta <= 5) {
                        companyiaActual.afegirRutaVol(tipusRuta);
                    } else {
                        System.out.println("\nEl tipus de ruta no és correcte");
                    }
                    break;
                case 5:
                    int tipusTri;
                    System.out.println("\nQuin tipus de tripulants vols afegir? (6:Cabina, 7:TCP)");
                    tipusTri = DADES.nextInt();
                    if (tipusTri >= 6 && tipusTri <= 7) {
                        companyiaActual.afegirTripulantVol(tipusTri);
                    } else {
                        System.out.println("\nEl tipus de tripulant no és correcte");
                    }
                    break;
                case 6:
                    for (int i = 0; i < companyiaActual.getPosicioComponents(); i++) {
                        companyiaActual.getComponents()[i].mostrarComponent();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }

        } while (opcio!= 0);
        }
    }
    
    public static Integer selectCompanyia() {

        System.out.println("\nCodi de la companyia?:");
        int codi = DADES.nextInt();

        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioCompanyies && !trobat; i++) {
            if (companyies[i].getCodi() == codi) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

}
