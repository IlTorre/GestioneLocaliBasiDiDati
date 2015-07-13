/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marco
 */
public class Database {
    
    /*
     * Settare i parametri per la connessione ad DBMS.
    */
    private  String utente="utente";

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public void setNomedb(String nomedb) {
        this.nomedb = nomedb;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }
    private  String password="pass";

    public void setPassword(String password) {
        this.password = password;
    }
    private  String nomedb="ESAME";
    private  String porta ="5432";
    
    
    private Connection con = null;
    private Statement sta = null;
    
    public Database(){
         
    }
    public void open() throws SQLException{
        con = DriverManager.getConnection("jdbc:postgresql://localhost:"+porta+"/"+nomedb,utente,password);
        sta = con.createStatement();
    }
    public void close() throws SQLException{
        sta.close();
        con.close();
    }
    
    public void renewState () throws SQLException{
    
        close();
        open();
        
    }
    public ResultSet queryOUT(String q) throws SQLException{
        ResultSet Rs = sta.executeQuery(q);    
        return Rs;
    }
    public void queryIN(String q) throws SQLException{
        sta.executeUpdate(q);
    }
}
