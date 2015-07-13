/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;

import dati.posto;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marco
 */
public class TableModelOccupazione extends AbstractTableModel{
    private int r;
    private ArrayList<posto> p;
    private posto temp;
   
    
    public TableModelOccupazione(String lab,Date data,Database db,Frame parent) {
        try {
            String q="SELECT n from postidilavoro where cod='"+lab+"' order by n";
            ResultSet rs=null;
            rs=db.queryOUT(q);
            p = new ArrayList();
            while(rs.next()){
                temp = new posto(rs.getString(1));
                p.add(temp);
            }
            
            q="SELECT n from assegnati where cod='"+lab+"' and mese= "+(data.getMonth()+1)+" order by n";
            rs=db.queryOUT(q);
            int i =0;
            int j=0;
            while (rs.next()){
                while(!p.get(i).getN().equals(rs.getString(1)) && i<=p.size()) i++;
                for(j=0;j<12;j++){
                    p.get(i).setStato(j, "A");
                }
            }
            String sData=""+data.getDate()+"/"+(1+data.getMonth())+"/"+(1900+data.getYear());
            
            for (i=0;i<12;i++){
                q="SELECT n from prenotazione where cod='"+lab+"' and data = '"+sData+"' and orai <='"+(8+i)+":00' and oraf >= '"+(9+i)+":00' order by n";
                rs=db.queryOUT(q);
                j=0;
                while (rs.next()){
                    while(!p.get(j).getN().equals(rs.getString(1)) && j<=p.size()) j++;
                    p.get(j).setStato(i, "P");
                }
                }
                  
            
        } catch (SQLException ex) {
            ErroreDialog erro = new ErroreDialog(parent, true, ex.toString());
            r = 0;
        }
        
    }

    @Override
    public int getRowCount() {
        return 12;
    }

    @Override
    public int getColumnCount() {
        return p.size()+1;
    }

    @Override
    public Object getValueAt(int i, int j) {
        if (j==0)
            return (i+8)+":00-"+(i+9)+":00";
        else{
        return p.get(j-1).getStato(i);
        }
    }
    
    /**
     *
     * @param i
     * @return 
     */
    @Override
    public String getColumnName(int i){
        if (i==0)
            return "Ora";
        else
            return "P "+p.get(i-1).getN();
    }
}
