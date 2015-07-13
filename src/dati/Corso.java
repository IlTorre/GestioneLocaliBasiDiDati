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
public class Corso {
    private String cod,nome;

    public String getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }
    
    public Corso (String cod, String nome){
    
        this.nome=nome;
        this.cod=cod;
    }
    
 
    @Override
    public String toString(){
        
        return getNome()+" - "+getCod();
    
    }
    
}
