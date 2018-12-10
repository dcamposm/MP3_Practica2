/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author DieCM
 */
public abstract class Ruta implements Component {
    
    public String codi;
    public String aeroportOri;
    public String aeroportDes;
    public double distancia;
    
    public Ruta(String codi, String aeroportOri, String aeroportDes, double distancia) {
        this.codi = codi;
        this.aeroportOri = aeroportOri;
        this.aeroportDes = aeroportDes;
        this.distancia = distancia;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getAeroportOri() {
        return aeroportOri;
    }

    public void setAeroportOri(String aeroportOri) {
        this.aeroportOri = aeroportOri;
    }

    public String getAeroportDes() {
        return aeroportDes;
    }

    public void setAeroportDes(String aeroportDes) {
        this.aeroportDes = aeroportDes;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    public void modificarComponent() {

        System.out.println("\nEl codi de la ruta és:" + codi);
        codi = (String)demanarDades("Quin és el nou codi de la ruta? ",2);
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nL'aeroport d'origen de la ruta és:" + aeroportOri);
        aeroportOri = (String)demanarDades("Quin és el nou l'aeroport d'origen de la ruta? ",4);
        System.out.println("\nL'aeroport de destí de la ruta és:" + aeroportDes);
        aeroportDes = (String)demanarDades("Quin és el nou l'aeroport de destí de la ruta? ",4);
        System.out.println("\nLa distància de la ruta és:"+distancia);
        distancia = (double)demanarDades("Quina és la nova distància de la ruta? ",3);
    }
    
    public void mostrarComponent() {
        System.out.println("\nLes dades de la ruta nacional amb codi " + codi + " són:");
        System.out.println("\nAeroport d'origen: " + aeroportOri);
        System.out.println("\nAeroport de destí: " + aeroportDes);
        System.out.println("\nDistància: " + distancia);
    }
    
    
}
