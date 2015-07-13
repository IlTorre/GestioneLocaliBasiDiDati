/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;

import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Marco
 */
public class PrenotaDialog extends javax.swing.JDialog {
    private String q;
    private ResultSet rs;
    private final Database db;
    private final Frame parent;
    private String cod;
    private DefaultListModel listModel;
 
    /**
     * Creates new form PrenotaDialog
     * @param parent
     * @param modal
     * @param db
     */
    public PrenotaDialog(Frame parent, boolean modal,Database db) {
        super(parent, modal);
        initComponents();
        this.db=db;
        this.parent = parent;
        q="SELECT DISTINCT cod FROM prenotabili";
       
        try {
            rs=db.queryOUT(q);
            while(rs.next()){
                Combo_locale.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            ErroreDialog err = new ErroreDialog(parent, true, ex.toString());
            this.dispose();
        }
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        buttonok = new javax.swing.JButton();
        ngiorni = new com.toedter.components.JSpinField();
        tessera = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listModel = new DefaultListModel();
        posti_list = new JList(listModel);
        Combo_locale = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        orafspin = new com.toedter.components.JSpinField();
        oraispin = new com.toedter.components.JSpinField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Numero di giorni da riservare");

        buttonok.setText("OK");
        buttonok.setEnabled(false);
        buttonok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonokActionPerformed(evt);
            }
        });

        ngiorni.setMaximum(52);
        ngiorni.setMinimum(1);
        ngiorni.setValue(1);

        tessera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tesseraKeyReleased(evt);
            }
        });

        jLabel2.setText("Tessera n:");

        posti_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                posti_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(posti_list);

        Combo_locale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_localeActionPerformed(evt);
            }
        });

        jLabel3.setText("orai");

        jLabel4.setText("oraf");

        orafspin.setMaximum(20);
        orafspin.setMinimum(9);
        orafspin.setValue(9);

        oraispin.setMaximum(19);
        oraispin.setMinimum(8);
        oraispin.setValue(8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Combo_locale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(buttonok)
                                        .addComponent(ngiorni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(oraispin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(orafspin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tessera, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orafspin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oraispin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tessera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ngiorni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Combo_locale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(buttonok)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonokActionPerformed
        // TODO add your handling code here:
         int lun;
        lun=posti_list.getSelectedValuesList().size();
        int i;
        Date data;
        data=jCalendar1.getDate();
       
        for (int k=0;k<ngiorni.getValue();k++){
        for(i =0; i<lun; i++){
            
            String sData=""+(data.getDate())+"/"+(1+data.getMonth())+"/"+(1900+data.getYear());
            q="INSERT INTO \"prenotazione\" (n, cod, data, orai, oraf, ntessera) VALUES ("+posti_list.getSelectedValuesList().get(i)+", '"+Combo_locale.getSelectedItem().toString()+"', '"+sData+"', '"+oraispin.getValue()+":00', '"+orafspin.getValue()+":00' ,"+tessera.getText()+")";
           
            try {
                 db.queryIN(q);
             } catch (SQLException ex) {
                 ErroreDialog err = new ErroreDialog(parent, true, ex.toString());
        }   
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DATE, 7);
        data = calendar.getTime();
        }
        this.dispose();
    }//GEN-LAST:event_buttonokActionPerformed

    private void Combo_localeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_localeActionPerformed
        // TODO add your handling code here:
        cod=Combo_locale.getSelectedItem().toString();
        q="SELECT n FROM prenotabili where cod='"+cod+"'";
       listModel.removeAllElements();
        try {
            rs=db.queryOUT(q);
            while(rs.next()){
               listModel.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            ErroreDialog err = new ErroreDialog(parent, true, ex.toString());
            this.dispose();
        }
    }//GEN-LAST:event_Combo_localeActionPerformed

    private void posti_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posti_listMouseClicked
        // TODO add your handling code here:
        if(tessera.getText().length()!=0 && !posti_list.isSelectionEmpty() )
            buttonok.setEnabled(true);
        else
            buttonok.setEnabled(false);
    }//GEN-LAST:event_posti_listMouseClicked

    private void tesseraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tesseraKeyReleased
        // TODO add your handling code here:
        if(tessera.getText().length()!=0 && !posti_list.isSelectionEmpty() )
            buttonok.setEnabled(true);
        else
            buttonok.setEnabled(false);
    }//GEN-LAST:event_tesseraKeyReleased

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Combo_locale;
    private javax.swing.JButton buttonok;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.components.JSpinField ngiorni;
    private com.toedter.components.JSpinField orafspin;
    private com.toedter.components.JSpinField oraispin;
    private javax.swing.JList posti_list;
    private javax.swing.JTextField tessera;
    // End of variables declaration//GEN-END:variables
}
