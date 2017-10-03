/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Forms;

import Control.IDImputVerifier;
import LogicaDeNegocio.Administrador;
import java.time.LocalDate;
import java.util.Date;
import org.freixas.jcalendar.JCalendar;
import org.freixas.jcalendar.JCalendarCombo;

/**
 *
 * @author edva5
 */
public class FormAdministrador extends javax.swing.JPanel {    
    /**
     * Creates new form FormAdministrador
     */
    public FormAdministrador() {
        initComponents();        
        this.idTxtFld.setInputVerifier(new IDImputVerifier());
    }    
    public void fillForm(Administrador a){
        this.idTxtFld.setText(a.getCedulaOPassaporte());
        this.nombreTxtFld.setText(a.getNombre());
        this.apellido1TxtFld.setText(a.getApellido1());
        this.apellido2TxtFld.setText(a.getApellido2());
        this.telefonoTxtFld.setText(a.getTelefono());
        this.emailTxtFld.setText(a.getEmail());
        claveTxtFld.setText(a.getClave());
        this.jCalendarCombo1.setDate(new Date(a.getFechaNacimiento().getYear(), a.getFechaNacimiento().getMonthValue(), a.getFechaNacimiento().getDayOfMonth()));        
    }
    public void clearForm(){
        claveTxtFld.setText("");
        this.idTxtFld.setText("");
        this.nombreTxtFld.setText("");
        this.apellido1TxtFld.setText("");
        this.apellido2TxtFld.setText("");
        this.telefonoTxtFld.setText("");
        this.emailTxtFld.setText("");
        this.jCalendarCombo1.setDate(new Date(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()));        
    }
    public void setEditable(boolean p){
        claveTxtFld.setEditable(p);
        this.idTxtFld.setEditable(p);
        this.nombreTxtFld.setEditable(p);
        this.apellido1TxtFld.setEditable(p);
        this.apellido2TxtFld.setEditable(p);
        this.telefonoTxtFld.setEditable(p);
        this.emailTxtFld.setEditable(p);
        this.jCalendarCombo1.setEditable(p);
    }
    public Administrador getAdministador(){
        Administrador auxAdmi= new Administrador();
        auxAdmi.setCedulaOPassaporte(idTxtFld.getText());
        auxAdmi.setNombre(nombreTxtFld.getText());
        auxAdmi.setApellido1(apellido1TxtFld.getText());
        auxAdmi.setApellido2(apellido2TxtFld.getText());
        auxAdmi.setEmail(emailTxtFld.getText());
        auxAdmi.setClave(claveTxtFld.getText());
        auxAdmi.setTelefono(telefonoTxtFld.getText());
        auxAdmi.setFechaNacimiento(LocalDate.of(2017, 5, 5));
        return auxAdmi;                
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idTxtFld = new javax.swing.JTextField(9);
        nombreTxtFld = new javax.swing.JTextField();
        apellido1TxtFld = new javax.swing.JTextField();
        apellido2TxtFld = new javax.swing.JTextField();
        telefonoTxtFld = new javax.swing.JTextField();
        emailTxtFld = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCalendarCombo1 = new org.freixas.jcalendar.JCalendarCombo();
        jLabel7 = new javax.swing.JLabel();
        claveTxtFld = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();

        apellido2TxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellido2TxtFldActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido1");

        jLabel4.setText("Apellido2");

        jLabel5.setText("Telefono");

        jLabel6.setText("Email");

        jLabel7.setText("Fecha de Nacimiento");

        jLabel8.setText("Clave");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendarCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefonoTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido2TxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido1TxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(claveTxtFld, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(emailTxtFld, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellido1TxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellido2TxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(claveTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jCalendarCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void apellido2TxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellido2TxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellido2TxtFldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido1TxtFld;
    private javax.swing.JTextField apellido2TxtFld;
    private javax.swing.JPasswordField claveTxtFld;
    private javax.swing.JTextField emailTxtFld;
    private javax.swing.JTextField idTxtFld;
    private org.freixas.jcalendar.JCalendarCombo jCalendarCombo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField nombreTxtFld;
    private javax.swing.JTextField telefonoTxtFld;
    // End of variables declaration//GEN-END:variables
}
