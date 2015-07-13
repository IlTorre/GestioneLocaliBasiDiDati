/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;

import dati.Permessi;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marco
 */
public class TableModelPermesso extends AbstractTableModel{
    private final String q;
    private ResultSet rs;
    private ErroreDialog err;
    private ArrayList<Permessi> l;
    private Permessi temp;
    private int r;
    private final String titolo[]={"Tessera","LUN","MAR","MER","GIO","VEN","SAB","DOM"};
            

    public TableModelPermesso(Frame parent, Database db, String cod) {
        q="SELECT p.ntessera, pr.giorno, pr.orai, pr.oraf  from permesso p, tipo t, per pr where p.cod= '"+cod+"' and p.tipo=t.tipo and pr.tipo=t.tipo order by p.ntessera";
        l = new ArrayList<Permessi>();
        try {
            rs= db.queryOUT(q);
            while (rs.next()){
                temp = new Permessi(rs.getString(1), rs.getString(2),rs.getString(3).substring(0, 5), rs.getString(4).substring(0,5));  
                l.add(temp);
            }
            
        } catch (SQLException ex) {
            err = new ErroreDialog(parent, true, ex.toString());
            r=0;
        }
        r=l.size();
                
        
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
        temp=l.get(i);
        switch(j){
            case 0: return temp.getTessera();
            default: if (temp.getGiorno().equals(""+j)) return temp.getOrai()+"-"+temp.getOraf();
            else return ""; 
                    
        }
    }
    @Override
    public String getColumnName(int i){
        return (titolo[i]);
    }
}
