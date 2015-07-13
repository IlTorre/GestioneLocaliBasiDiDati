/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;

import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marco
 */
public class AggiungiDialog extends javax.swing.JDialog {
    private Frame parent=null;
    private Database db=null;

    /**
     * Creates new form AggiungiDialog
     */
    public AggiungiDialog(Frame parent, boolean modal,Database db) {
        
        super(parent, modal);
        this.parent=parent;
        this.db=db;
        initComponents();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        buttonGroup12 = new javax.swing.ButtonGroup();
        buttonGroup13 = new javax.swing.ButtonGroup();
        buttonGroup14 = new javax.swing.ButtonGroup();
        buttonGroup15 = new javax.swing.ButtonGroup();
        buttonGroup16 = new javax.swing.ButtonGroup();
        buttonGroup17 = new javax.swing.ButtonGroup();
        buttonGroup18 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        text_cf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        text_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        text_cognome = new javax.swing.JTextField();
        radio_doc = new javax.swing.JRadioButton();
        radio_stud = new javax.swing.JRadioButton();
        radio_tec = new javax.swing.JRadioButton();
        label_matr = new javax.swing.JLabel();
        text_matr = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("CF");

        text_cf.setColumns(21);
        text_cf.setName(""); // NOI18N
        text_cf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_cfActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel3.setText("Cognome");

        buttonGroup1.add(radio_doc);
        radio_doc.setText("Docente");
        radio_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_docActionPerformed(evt);
            }
        });

        buttonGroup1.add(radio_stud);
        radio_stud.setSelected(true);
        radio_stud.setText("Studente");
        radio_stud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_studActionPerformed(evt);
            }
        });

        buttonGroup1.add(radio_tec);
        radio_tec.setText("Tecnico");
        radio_tec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_tecActionPerformed(evt);
            }
        });

        label_matr.setText("Matricola");

        jButton1.setText("Inserisci");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(radio_stud)
                        .addGap(18, 18, 18)
                        .addComponent(radio_doc)
                        .addGap(18, 18, 18)
                        .addComponent(radio_tec))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(text_cf)
                                    .addComponent(text_nome)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(label_matr))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text_cognome)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(text_matr, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(jButton1)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(text_cf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(text_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(text_cognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_doc)
                    .addComponent(radio_tec)
                    .addComponent(radio_stud))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_matr)
                    .addComponent(text_matr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_cfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_cfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_cfActionPerformed

    private void radio_studActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_studActionPerformed
        // TODO add your handling code here:
        text_matr.setEnabled(true);
        label_matr.setEnabled(true);
    }//GEN-LAST:event_radio_studActionPerformed

    private void radio_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_docActionPerformed
        // TODO add your handling code here:
        text_matr.setEnabled(false);
        label_matr.setEnabled(false);
    }//GEN-LAST:event_radio_docActionPerformed

    private void radio_tecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_tecActionPerformed
        // TODO add your handling code here:
        text_matr.setEnabled(false);
        label_matr.setEnabled(false);
    }//GEN-LAST:event_radio_tecActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean err = false;
        ErroreDialog erro=null;
        String q, cf,cogn,nome;
        cf=text_cf.getText();
        cogn= text_cognome.getText();
        nome=text_nome.getText();
       
        if (cf.length()!= 16) err=true;
        if (cogn.isEmpty()) err=true;
        if (nome.isEmpty()) err=true;
        if (radio_stud.isSelected()&& text_matr.getText().isEmpty()) err=true;
        
        if (err) erro = new ErroreDialog(parent,true,"Devi compilare tutti i campi");
        else
        {
            q="INSERT INTO \"utente\" (CF, nome, cognome) VALUES (UPPER('"+cf+"'),'"+nome+"','"+cogn+"')";
            try {
               db.queryIN(q);
               q="SELECT ntessera from utente where cf=UPPER('"+cf+"')";
                ResultSet rs=null;
                rs = db.queryOUT(q);
                rs.next();
                String tess=rs.getString(1);
                
                
               
                if (radio_stud.isSelected()) {
                        q="INSERT INTO \"studente\" (ntessera, matr) VALUES ("+tess+",'"+text_matr.getText()+"')";
                        
                        db.queryIN(q);
                       CreaAccount acc= new CreaAccount(parent, true, db, text_matr.getText());
                }
                if (radio_doc.isSelected()) {
                    
                        q="INSERT INTO \"docente\" VALUES ("+tess+")";
                       
                        db.queryIN(q);
                }
                if (radio_tec.isSelected()) {
                        q="INSERT INTO \"tecnico\" VALUES ("+tess+")";
                        
                        db.queryIN(q);
                }
                
                this.dispose();
            } catch (SQLException ex) {
              erro = new ErroreDialog(parent, true, ex.toString());
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup12;
    private javax.swing.ButtonGroup buttonGroup13;
    private javax.swing.ButtonGroup buttonGroup14;
    private javax.swing.ButtonGroup buttonGroup15;
    private javax.swing.ButtonGroup buttonGroup16;
    private javax.swing.ButtonGroup buttonGroup17;
    private javax.swing.ButtonGroup buttonGroup18;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel label_matr;
    private javax.swing.JRadioButton radio_doc;
    private javax.swing.JRadioButton radio_stud;
    private javax.swing.JRadioButton radio_tec;
    private javax.swing.JTextField text_cf;
    private javax.swing.JTextField text_cognome;
    private javax.swing.JTextField text_matr;
    private javax.swing.JTextField text_nome;
    // End of variables declaration//GEN-END:variables
}