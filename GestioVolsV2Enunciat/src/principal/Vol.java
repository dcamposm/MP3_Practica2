/*
 * Un vol es defineix pel seu codi, ruta, avio, un vector amb els seus tripulants 
 * (tripulació), data de sortida, data d’arribada, hora de sortida, hora d’arribada
 * i durada.
 */
package principal;

import components.Avio;
import components.Component;
import components.Ruta;
import components.RutaIntercontinental;
import components.RutaInternacional;
import components.RutaNacional;
import components.RutaTransoceanica;
import components.Tripulant;
import components.TCP;
import components.TripulantCabina;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Vol implements Component{

    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private Object ruta;
    private Avio avio;
    private Tripulant[] tripulacio;
    private int posicioTripulacio;
    private Date dataSortida;
    private Date dataArribada;
    private LocalTime horaSortida;
    private LocalTime horaArribada;
    private String durada;
    private TCP cap;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys ruta, avio,
     tripulacioCabina, posicioTripulacioCabina, tcp i posicioTCP.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     - Inicialitzar ruta i avio a null, ja que quan es crea un vol, encara no s'han
     assignat ni la ruta ni el vol.
     - Inicialitzarem l'atribut tipusRuta a 0, ja que com no s'ha assignat encara una ruta,
     no podem saber de quin tipus és.
     - Inicialitzar el vector tripulacioCabina com a buit i una longitud de 7.
     - Inicialitzar el vector tcps com a buit i una longitud de 25.
     - Inicialitzar els atributs posicioTripulacioCabina i posicioTcps a 0.
     - Inicialitzar l'atribut durada amb el mètode pertinent d'aquesta classe.
     */
    public Vol(String codi, Date dataSortida, Date dataArribada, LocalTime horaSortida, LocalTime horaArribada) {
        this.codi = codi;
        ruta = null;
        avio = null;
        this.dataSortida = dataSortida;
        this.dataArribada = dataArribada;
        this.horaSortida = horaSortida;
        this.horaArribada = horaArribada;
        tripulacio = new Tripulant[32];
        posicioTripulacio = 0; 
        calcularDurada();
        cap = null;
    }

    /*
    Mètodes accessors
     */
    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public Object getRuta() {
        return ruta;
    }

    public void setRuta(Object ruta) {
        this.ruta = ruta;
    }

    public TCP getCap() {
        return cap;
    }

    public void setCap(TCP cap) {
        this.cap = cap;
    }

    public Avio getAvio() {
        return avio;
    }

    public void setAvio(Avio avio) {
        this.avio = avio;
    }

    public Tripulant[] getTripulacio() {
        return tripulacio;
    }

    public void setTripulacio(Tripulant[] tripulacio) {
        this.tripulacio = tripulacio;
    }

    public int getPosicioTripulacio() {
        return posicioTripulacio;
    }

    public void setPosicioTripulacio(int posicioTripulacio) {
        this.posicioTripulacio = posicioTripulacio;
    }

    public Date getDataSortida() {
        return dataSortida;
    }

    public void setDataSortida(Date dataSortida) {
        this.dataSortida = dataSortida;
    }

    public Date getDataArribada() {
        return dataArribada;
    }

    public void setDataArribada(Date dataArribada) {
        this.dataArribada = dataArribada;
    }

    public LocalTime getHoraSortida() {
        return horaSortida;
    }

    public void setHoraSortida(LocalTime horaSortida) {
        this.horaSortida = horaSortida;
    }

    public LocalTime getHoraArribada() {
        return horaArribada;
    }

    public void setHoraArribada(LocalTime horaArribada) {
        this.horaArribada = horaArribada;
    }

    public String getDurada() {
        return durada;
    }

    public void setDurada(String durada) {
        this.durada = durada;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou vol.
    Les dades a demanar són les que necessita el constructor.
    - En el cas de les dates, li hem de demanar a l'usuari que les introdueixi
    amb el format dd-mm-yyyy. Penseu que la data introduïda per l'usuari serà
    de tipus String i nosaltres l'hem de convertir a data.
    - En el cas de les hores només haurem de demanar l'hora i minuts, els segons
    i nanosegons no els tindrem en compte.
    Retorn: El nou vol.
     */
    public static Vol nouVol() throws ParseException {
        String codi;
        Date dataSortida, dataArribada;
        LocalTime horaSortida, horaArribada;
        int hora, minuts;

        System.out.println("\nCodi del vol?");
        codi = DADES.next();

        System.out.println("\nData de sortida del vol?: (dd-mm-yyyy)");
        dataSortida = new SimpleDateFormat("dd-MM-yyyy").parse(DADES.next());
        System.out.println("\nData d'arribada del vol?: (dd-mm-yyyy)");
        dataArribada = new SimpleDateFormat("dd-MM-yyyy").parse(DADES.next());

        System.out.println("\nA quina hora surt el vol?");
        hora = DADES.nextInt();
        System.out.println("\nA quins minuts de la hora surt el vol?");
        minuts = DADES.nextInt();
        horaSortida = LocalTime.of(hora, minuts, 0, 0);

        System.out.println("\nA quina hora arriba el vol?");
        hora = DADES.nextInt();
        System.out.println("\nA quins minuts de la hora arriba el vol?");
        minuts = DADES.nextInt();
        horaArribada = LocalTime.of(hora, minuts, 0, 0);

        return new Vol(codi, dataSortida, dataArribada, horaSortida, horaArribada);
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte, excepte ruta, avio,
     tripulacioCabina, tcps, posicioTripulacioCabina i posicioTcps.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los. Les dates les heu de mostrar amb el format
     dd-mm-yyyy, i les hores amb el format hh:mm.
     - Per demanar els nous valors de les dates i les hores, farem el mateix que
     en el mètode anterior nouVol().
     - Si es modifiquen els atributs de data o d'hora, també s'haurà de modificar
     el valor de durada mitjançant el mètode adient d'aquesta classe.
     Retorn: cap
     */
    public void modificarComponent() throws ParseException {
        int hora, minuts;

        System.out.println("\nEl codi del vol és: " + codi);
        codi = (String)demanarDades("Quin és el nou Codi de l'avió? ",2);
        
        System.out.println("\nLa data de sortida del vol és: " + new SimpleDateFormat("dd-MM-yyyy").format(dataSortida));
        dataSortida = new SimpleDateFormat("dd-MM-yyyy").parse((String)demanarDades("Quina és la nova data de sortida del vol?: (dd-mm-yyyy) ",2));
        System.out.println("\nLa data d'arribada del vol és: " + new SimpleDateFormat("dd-MM-yyyy").format(dataArribada));
        dataArribada = new SimpleDateFormat("dd-MM-yyyy").parse((String)demanarDades("Quina és la nova data d'arribada del vol?: (dd-mm-yyyy) ",2));
        
        System.out.println("\nL'hora de sortida del vol és: " + horaSortida.getHour() + ":" + horaSortida.getMinute());
        hora = (int)demanarDades("Quina és la nova hora de sortida del vol? ",1);
        minuts = (int)demanarDades("Quins són els nous minuts de la hora de sortida del vol? ",1);
        horaSortida = LocalTime.of(hora, minuts);

        System.out.println("\nL'hora d'arribada del vol és: " + horaArribada.getHour() + ":" + horaArribada.getMinute());
        hora = (int)demanarDades("Quina és la nova hora de arribada del vol? ",1);
        minuts = (int)demanarDades("Quins són els nous minuts de l'hora d'arribada del vol? ",1);
        horaSortida = LocalTime.of(hora, minuts);
    }

    /*
     Paràmetres: cap
     Accions:
     - Se li assignarà a l'atribut durada el valor tenint en compte que la durada
     és la diferència de temps entre la data i hora de sortida, i la data i hora
     d'arribada.
     - La durada ha de tenir el format "X h - Y m", on X seran les hores de durada i Y els minuts
     Retorn: cap
     */
    private void calcularDurada() {

        long segonsDurada = (dataArribada.getTime() + (horaArribada.getHour() * 3600 + horaArribada.getMinute() * 60)) - (dataSortida.getTime() + (horaSortida.getHour() * 3600 + horaSortida.getMinute() * 60));

        durada = (segonsDurada / 3600000) + " h - " + ((segonsDurada - (3600 * (segonsDurada / 3600))) / 60) + " m";
    }

    /*
     Paràmetres: tripulant de cabina
     Accions:
     - afegeix el tripulant de cabina passat per paràmetre al vector tripulacioCabina    
     en la primera posició buida del vector i actualitza la posició del vector tripulacioCabina.
     Retorn: cap
     */
    public void afegirTripulant(Tripulant tripulant) {
        String i;        
        
        if (tripulant instanceof TCP){
            i = (String)demanarDades("Vols que aquet tripulant sigui cap de cabina? (si/no)",2);
            if (i.equals("si")){
                tripulant.setRang("cap");
                cap=(TCP)tripulant;
                tripulacio[posicioTripulacio-1].setRang(null); 
            }
        }
        
        tripulacio[posicioTripulacio] = tripulant;
        posicioTripulacio++;
    }

    public void mostrarComponent() {
        System.out.println("\nLes dades del vol amb codi " + codi + " són:");

        System.out.println("\nAvio: ");
        if (avio != null) {
            avio.mostrarComponent();
        }

        System.out.println("\nData de sortida: " + new SimpleDateFormat("dd-MM-yyyy").format(dataSortida));
        System.out.println("\nData d'arribada: " + new SimpleDateFormat("dd-MM-yyyy").format(dataArribada));
        System.out.println("\nHores de sortida: " + horaSortida.getHour() + ":" + horaSortida.getMinute());
        System.out.println("\nHores d'arribada: " + horaArribada.getHour() + ":" + horaArribada.getMinute());
        
        System.out.println("\nCap: " + cap);
        
        System.out.println("\nLa tripulació és:");
        for (int i = 0; i < posicioTripulacio; i++) {
            if (tripulacio[i] != null) {
                tripulacio[i].mostrarComponent();
            }
        }

        System.out.println("\nDurada: " + durada);
    }
}
