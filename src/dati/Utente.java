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
public class Utente {
    private String nome, cognome, cf, tessera;

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCf() {
        return cf;
    }

    public String getTessera() {
        return tessera;
    }
    public Utente(String nome,String cognome, String cf, String tessera){
        this.nome=nome;
        this.cognome=cognome;
        this.cf=cf;
        this.tessera=tessera;
    }
    
}
