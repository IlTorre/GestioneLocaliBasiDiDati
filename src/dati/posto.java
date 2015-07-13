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
public class posto {
    private String n;
    private String[] stato;
   
    
    public String getN() {
        return n;
    }

   
    public String getStato(int i) {
        return stato[i];
    }

    public void setStato(int i, String stato) {
        this.stato[i] = stato;
    }
    
    public posto(String n){
        this.n= n;
        stato = new String[12];
        for (int i=0;i<12;i++)
            stato[i]="L";
    }
    
    
}
