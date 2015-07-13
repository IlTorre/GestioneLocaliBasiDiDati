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
public class Gruppo {

    @Override
    public String toString() {
        return codl+" - "+anno;
    }
    
    private String codl,anno;

    public String getCodl() {
        return codl;
    }

    public String getAnno() {
        return anno;
    }
    
    public Gruppo(String codl, String anno){
        
        this.anno=anno;
        this.codl=codl;
    
    }
    
}
