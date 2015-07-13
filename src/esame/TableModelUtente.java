/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;

import dati.Utente;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marco
 */
public class TableModelUtente extends AbstractTableModel {

    private Database db=null;
    private Frame parent=null;
    private final String[] titolo ={"Tessera","Cognome","Nome","CF"};
    private int r;
  
    private ArrayList<Utente> tabella;

    public TableModelUtente (Database db, Frame parent){
    this.db=db;
    this.parent=parent;
    tabella= new ArrayList<Utente>();
    String q;
    Utente temp =null;
        q="select count(*) from utente";
        try {
            ResultSet rs= null;
            rs = db.queryOUT(q);
            rs.next();
            r = rs.getInt(1);
            q="select ntessera,cognome,nome,cf from utente order by cognome, nome";
            rs=db.queryOUT(q);
            while(rs.next()){

                temp=new Utente(rs.getString(3), rs.getString(2),rs.getString(4),rs.getString(1));
                tabella.add(temp);
                
            }
        } catch (SQLException ex) {
            ErroreDialog erro = new ErroreDialog(parent, true, ex.toString());
            r = 0;
        }
    
    }
    @Override
    public int getRowCount() {
        return r;
    }

    @Override
    public int getColumnCount() {
     return titolo.length;
    }

    @Override
    public Object getValueAt(int i, int j) {
        switch(j){
            case 0: return tabella.get(i).getTessera();
            case 1: return tabella.get(i).getCognome();
            case 2: return tabella.get(i).getNome();
            case 3: return tabella.get(i).getCf();
            default: return"Errore";
                    
        }
            
    }
    @Override
        public String getColumnName(int i){
        return (titolo[i]);
    }
}
