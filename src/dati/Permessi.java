/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dati;

/**
 *
 * @author Marco
 */
public class Permessi {
    private String tessera,giorno, orai, oraf;

    public String getTessera() {
        return tessera;
    }

    public String getGiorno() {
        return giorno;
    }

    public String getOrai() {
        return orai;
    }

    public String getOraf() {
        return oraf;
    }
    

    public Permessi(String tessera,String giorno,String orai,String oraf){
        this.tessera= tessera;
        this.giorno=giorno;
        this.orai=orai;
        this.oraf=oraf;
  
    }
    
    
    
    
    
}
