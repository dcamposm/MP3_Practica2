/*
 * Classe que defineix una companyia. Una companyia es defineix per un codi i un 
 * nom. A més, contindrà vectors amb avions, rutes nacionals, rutes internacionals,
 * rutes intercontinentals, rutes transocèaniques, tripulants de cabina, TCPs i vols.
 */
package principal;

import components.Avio;
import components.Component;
import components.RutaIntercontinental;
import components.RutaInternacional;
import components.RutaNacional;
import components.RutaTransoceanica;
import components.TCP;
import components.Tripulant;
import components.Ruta;
import components.TripulantCabina;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Companyia implements Component{

    private final static Scanner DADES = new Scanner(System.in);

    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nom;
    private Component[] components;
    private int posicioComponents; 

    /*
     CONSTRUCTOR
     Paràmetres: valor per l'atribut nom
     Accions:
     - Assignar a l'atribut corresponent el valor passat com a paràmetre
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     - avions s'ha d'inicialtizar buit i amb una capacitat per 200 avions.
     - rutesNacionals s'ha d'inicialtizar buit i amb una capacitat per 100 rutes nacionals.
     - rutesInternacionals s'ha d'inicialtizar buit i amb una capacitat per 200 rutes internacionals.
     - rutesIntercontinentals s'ha d'inicialtizar buit i amb una capacitat per 100 rutes intercontinentals.
     - rutesTransoceaniques s'ha d'inicialtizar buit i amb una capacitat per 45 rutes transoceàniques.
     - tripulantsCabina s'ha d'inicialtizar buit i amb una capacitat per 600 tripulants de cabina.
     - tcps s'ha d'inicialtizar buit i amb una capacitat per 1000 TCPs.
     - vols s'ha d'inicialtizar buit i amb una capacitat per 700 vols.
     - posicioRutesNacionals, posicioRutesInternacionals, posicioRutesIntercontinentals, posicioRutesTransoceaniques, 
       posicioTripulantsCabina, posicioTcps i posicioVols, s'han d'inicialitzar a 0, què serà la primera posició
       buida dels vectors inicilitzats.
     */
    public Companyia(String nom) {
        codi = properCodi;
        properCodi++;
        this.nom = nom;
        this.components = new Component[2945];
        this.posicioComponents = 0;
    }

    /*
     Mètodes accessors    
     */
    public int getCodi() {
        return codi;
    }

    public void setCodi() {
        codi = properCodi;
    }

    public static int getProperCodi() {
        return properCodi;
    }

    public static void setProperCodi() {
        properCodi++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Component[] getComponents() {
        return components;
    }

    public void setComponents(Component[] components) {
        this.components = components;
    }

    public int getPosicioComponents() {
        return posicioComponents;
    }

    public void setPosicioComponents(int posicioComponents) {
        this.posicioComponents = posicioComponents;
    }


    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova Companyia. Les dades
     a demanar són les que necessita el constructor.
     - Heu de tenir en compte que el nom de la companyia, poden ser frases, per exemple,
     Singapore Airlines.
     Retorn: La nova companyia.
     */
    public static Companyia novaCompanyia() {

        System.out.println("\nNom de la companyia:");
        return new Companyia(DADES.nextLine());

    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas
     no es pot modificar el contingut dels vectors, només el de l'atribut nom. 
     Evidentment, tampoc podeu modificar el codi.
     - Li heu de mostrar a l'usuari els valor actual del nom de l'objecte
     actual, abans de modificar-lo.
     Retorn: cap
     */
    public void modificarComponent() throws ParseException {

        System.out.println("\nCodi de la companyia: " + codi);
        codi = (int)demanarDades("\nQuin és el nou codi de la companyia?", 1);
        System.out.println("\nNom de la companyia: " + nom);
        nom = (String)demanarDades("\nQuin és el nou nom de la companyia?", 4);

    }

    public void mostrarComponent() {
        System.out.println("\nLes dades de la companyia amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
    }
    
    public int seleccionarComponent(int tipus, String id) {
        
        boolean trobat = false;
        int pos = -1;
        
        switch (tipus) {
            case 1: {
                
                if (id == null) {
                    id = (String)demanarDades("\nCodi de l'avió?:",2);
                }

                    for (int i = 0; i < posicioComponents && !trobat; i++) {
                        if (components[i] instanceof Avio) {
                            if (((Avio)components[i]).getCodi().equals(id)) {
                                pos = i;
                                trobat = true;
                            }
                        }
                    }
                
            } break;
            case 2: {
                
                if (id == null) {
                    id = (String)demanarDades("\nCodi de la ruta?:",2);
                }

                    for (int i = 0; i < posicioComponents && !trobat; i++) {
                        if (components[i] instanceof Ruta) {
                            if (((Ruta)components[i]).getCodi().equals(id)) {
                                pos = i;
                                trobat = true;
                            }
                        }
                    }
                
            } break;
            case 3: {
                
                if (id == null) {
                    id = (String)demanarDades("\nPassaport del tripulant?:",2);
                }

                    for (int i = 0; i < posicioComponents && !trobat; i++) {
                        if (components[i] instanceof Tripulant) {
                            if (((Tripulant)components[i]).getPassaport().equals(id)) {
                                pos = i;
                                trobat = true;
                            }
                        }
                    }
                
            } break;  
            case 4: {
                
                if (id == null) {
                    id = (String)demanarDades("\nCodi de la vol?:",2);
                }
                   
                    for (int i = 0; i < posicioComponents && !trobat; i++) {
                        if (components[i] instanceof Vol) {
                            if (((Vol)components[i]).getCodi().equals(id)) {
                                pos = i;
                                trobat = true;
                            }
                        }
                    }
                
            } break; 
        }
        return pos;
    }
    
    public void afegirAvio() {
        Avio newAvio = Avio.nouAvio();
        if (seleccionarComponent(1, newAvio.getCodi()) == -1) {
            components[posicioComponents] = newAvio;
            posicioComponents++;
        } else {
            System.out.println("\nAquest avió ja existeix");
        }
    }
    
    public void afegirRutaNacional() {
        RutaNacional newRutaNacional = RutaNacional.novaRutaNacional();
        if (seleccionarComponent(2, newRutaNacional.getCodi()) == -1) {
            components[posicioComponents] = newRutaNacional;
            posicioComponents++;
        } else {
            System.out.println("\nAquesta ruta ja existeix");
        }
    }
    
    public void afegirRutaInternacional() {
        RutaInternacional newRutaInternacional = RutaInternacional.novaRutaInternacional();
        if (seleccionarComponent(2, newRutaInternacional.getCodi()) == -1) {
            components[posicioComponents] = newRutaInternacional;
            posicioComponents++;
        } else {
            System.out.println("\nAquesta ruta ja existeix");
        }
    }
    
    public void afegirRutaIntercontinental() {
        RutaIntercontinental newRutaIntercontinental = RutaIntercontinental.novaRutaIntercontinental();
        if (seleccionarComponent(2, newRutaIntercontinental.getCodi()) == -1) {
            components[posicioComponents] = newRutaIntercontinental;
            posicioComponents++;
        } else {
            System.out.println("\nAquesta ruta ja existeix");
        }
    }
    
    public void afegirRutaTransoceanica() {
        RutaTransoceanica newRutaTransoceanica = RutaTransoceanica.novaRutaTransoceanica();
        if (seleccionarComponent(2, newRutaTransoceanica.getCodi()) == -1) {
            components[posicioComponents] = newRutaTransoceanica;
            posicioComponents++;
        } else {
            System.out.println("\nAquesta ruta ja existeix");
        }
    }
    
    public void afegirTripulantCabina() {
        TripulantCabina newTripulantCabina = TripulantCabina.nouTripulantCabina();
        if (seleccionarComponent(3, newTripulantCabina.getPassaport()) == -1) {
            components[posicioComponents] = newTripulantCabina;
            posicioComponents++;
        } else {
            System.out.println("\nAquest tripulant de cabina ja existeix");
        }
    }
    
    public void afegirTCP() {
        TCP newTCP = TCP.nouTCP();
        if (seleccionarComponent(3, newTCP.getPassaport()) == -1) {
            components[posicioComponents] = newTCP;
            posicioComponents++;
        } else {
            System.out.println("\nAquest TCP ja existeix");
        }
    }
    
    public void afegirVol() throws ParseException {
        Vol newVol = Vol.nouVol();
        if (seleccionarComponent(4, newVol.getCodi()) == -1) {
            components[posicioComponents] = newVol;
            posicioComponents++;
        } else {
            System.out.println("\nAquest vol ja existeix");
        }
    }
    
    public void afegirAvioVol() {
        Vol volSel;
        int pos = seleccionarComponent(4, null);

        if (pos >= 0) {

            volSel = (Vol)getComponents()[pos];

            pos = seleccionarComponent(1, null);

            if (pos >= 0) {
                volSel.setAvio((Avio)getComponents()[pos]);
            } else {
                System.out.println("\nNo existeix aquest avió");
            }

        } else {
            System.out.println("\nNo existeix aquest vol");
        }
    }
    
    public void afegirTripulantVol (int tipus) {
        
            Vol volSel;
            
            int pos = seleccionarComponent(4, null);
            
            if (pos >= 0) {
            
            volSel = (Vol)getComponents()[pos];
            
            pos = seleccionarComponent(3, null);
            
                switch (tipus) {

                    case 6: {

                            if (pos >= 0) {
                                volSel.afegirTripulant((TripulantCabina)getComponents()[pos]);
                            } else {
                                System.out.println("\nNo existeix aquest tripulant de cabina");
                            }


                    } break;

                    case 7: {

                            if (pos >= 0) {
                                volSel.afegirTripulant((TCP)getComponents()[pos]);
                            } else {
                                System.out.println("\nNo existeix aquest tripulant de cabina de passatgers");
                            }


                    } break;

                }
                
            } else {
                System.out.println("\nNo existeix aquest vol");
            }
    }

    public void afegirRutaVol(int tipus) {
        Vol volSel;
        int pos = seleccionarComponent(4, null);

        if (pos >= 0) {

            volSel = (Vol)getComponents()[pos];
            
            pos = seleccionarComponent(2, null);

            switch (tipus) {
                case 2:
                    if (pos >= 0) {
                        volSel.setRuta((RutaNacional)getComponents()[pos]);
                    }
                    break;
                case 3:
                    if (pos >= 0) {
                        volSel.setRuta((RutaInternacional)getComponents()[pos]);
                    }
                    break;
                case 4:
                    if (pos >= 0) {
                        volSel.setRuta((RutaIntercontinental)getComponents()[pos]);
                    }
                    break;
                case 5:
                    if (pos >= 0) {
                        volSel.setRuta((RutaTransoceanica)getComponents()[pos]);
                    }
                    break;
                default: System.out.println("\nNo existeix aquesta ruta");
                    
            }
            
        } else {
            System.out.println("\nNo existeix aquest vol");
        }
    }

}
