/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package application.ui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author akles
 */
public class Register extends javax.swing.JFrame {

    /** Creates new form Login */
    public Register() {
        initComponents();
        addPlaceHolderStyle(nameField);
        addPlaceHolderStyle(dateField);
        addPlaceHolderStyle(telephoneField);
        addPlaceHolderStyle(emailField);
        addPlaceHolderStyle(passwordField);
        addPlaceHolderStyle(confirmField);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
     public void addPlaceHolderStyle(JTextField textField){
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.gray);
    }
    public void removePlaceHolderStyle(JTextField textField){
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN);
        textField.setFont(font);
        textField.setForeground(Color.white);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        backgroundPanel = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        registerLabel = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        dateField = new javax.swing.JTextField();
        telephoneField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        accountLabel = new javax.swing.JLabel();
        entryButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        confirmField = new javax.swing.JPasswordField();
        imagePanel = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

        jScrollPane1.setViewportView(jTextPane1);

        jScrollPane2.setViewportView(jTextPane2);

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 91, 162));

        backgroundPanel.setBackground(new java.awt.Color(0, 91, 162));

        nameField.setBackground(new java.awt.Color(0, 91, 162));
        nameField.setForeground(new java.awt.Color(255, 255, 255));
        nameField.setText("Nome");
        nameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameFieldFocusLost(evt);
            }
        });
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        registerLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        registerLabel.setForeground(new java.awt.Color(255, 255, 255));
        registerLabel.setText("Cadastro");

        registerButton.setForeground(new java.awt.Color(0, 91, 162));
        registerButton.setText("Cadatrar-se");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        dateField.setBackground(new java.awt.Color(0, 91, 162));
        dateField.setForeground(new java.awt.Color(255, 255, 255));
        dateField.setText("Data Nascimento");
        dateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dateFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateFieldFocusLost(evt);
            }
        });
        dateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFieldActionPerformed(evt);
            }
        });

        telephoneField.setBackground(new java.awt.Color(0, 91, 162));
        telephoneField.setForeground(new java.awt.Color(255, 255, 255));
        telephoneField.setText("Telefone");
        telephoneField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telephoneFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                telephoneFieldFocusLost(evt);
            }
        });
        telephoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneFieldActionPerformed(evt);
            }
        });

        emailField.setBackground(new java.awt.Color(0, 91, 162));
        emailField.setForeground(new java.awt.Color(255, 255, 255));
        emailField.setText("Email");
        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        accountLabel.setForeground(new java.awt.Color(255, 255, 255));
        accountLabel.setText("Já possuí conta?");

        entryButton.setBackground(new java.awt.Color(0, 91, 162));
        entryButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        entryButton.setForeground(new java.awt.Color(255, 255, 255));
        entryButton.setText("Entrar");
        entryButton.setBorder(null);
        entryButton.setContentAreaFilled(false);

        passwordField.setBackground(new java.awt.Color(0, 91, 162));
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setText("Senha");
        passwordField.setEchoChar('\u0000');
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });

        confirmField.setBackground(new java.awt.Color(0, 91, 162));
        confirmField.setForeground(new java.awt.Color(255, 255, 255));
        confirmField.setText("Confirmar");
        confirmField.setEchoChar('\u0000');
        confirmField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirmFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirmFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmField)
                    .addComponent(passwordField)
                    .addComponent(telephoneField)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registerLabel)
                            .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(accountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryButton)
                        .addGap(58, 58, 58)))
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(registerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telephoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountLabel)
                    .addComponent(entryButton))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        imagePanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/torcida.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imagePanel)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerButtonActionPerformed

    private void dateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFieldActionPerformed

    private void telephoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void nameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFieldFocusGained
        if(nameField.getText().equals("Nome")){
            nameField.setText(null);
            nameField.requestFocus();
            removePlaceHolderStyle(nameField);
        }
    }//GEN-LAST:event_nameFieldFocusGained

    private void dateFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFieldFocusGained
        if(dateField.getText().equals("Data Nascimento")){
            dateField.setText(null);
            dateField.requestFocus();
            removePlaceHolderStyle(dateField);
        }
    }//GEN-LAST:event_dateFieldFocusGained

    private void telephoneFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telephoneFieldFocusGained
        if(telephoneField.getText().equals("Telefone")){
            telephoneField.setText(null);
            telephoneField.requestFocus();
            removePlaceHolderStyle(telephoneField);
        }
    }//GEN-LAST:event_telephoneFieldFocusGained

    private void emailFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusGained
        if(emailField.getText().equals("Email")){
            emailField.setText(null);
            emailField.requestFocus();
            removePlaceHolderStyle(emailField);
        }
    }//GEN-LAST:event_emailFieldFocusGained

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        if(passwordField.getText().equals("Senha")){
           passwordField.setText(null);
           passwordField.requestFocus();
           passwordField.setEchoChar('●');
           removePlaceHolderStyle(passwordField);
       }        
    }//GEN-LAST:event_passwordFieldFocusGained

    private void confirmFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmFieldFocusGained
        if(confirmField.getText().equals("Confirmar")){
           confirmField.setText(null);
           confirmField.requestFocus();
           confirmField.setEchoChar('●');
           removePlaceHolderStyle(confirmField);
       }        
    }//GEN-LAST:event_confirmFieldFocusGained

    private void nameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFieldFocusLost
        if(nameField.getText().length()==0){
            addPlaceHolderStyle(nameField);
            nameField.setText("Nome");
        }
    }//GEN-LAST:event_nameFieldFocusLost

    private void dateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateFieldFocusLost
       if(dateField.getText().length()==0){
            addPlaceHolderStyle(dateField);
            dateField.setText("Data Nascimento");
        }
    }//GEN-LAST:event_dateFieldFocusLost

    private void telephoneFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telephoneFieldFocusLost
        if(telephoneField.getText().length()==0){
            addPlaceHolderStyle(telephoneField);
            telephoneField.setText("Telefone");
        }
    }//GEN-LAST:event_telephoneFieldFocusLost

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
    if(emailField.getText().length()==0){
            addPlaceHolderStyle(emailField);
            emailField.setText("Email");
        }
    }//GEN-LAST:event_emailFieldFocusLost

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
         if(passwordField.getText().length()==0){
            addPlaceHolderStyle(passwordField);
            passwordField.setText("Senha");
            passwordField.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_passwordFieldFocusLost

    private void confirmFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmFieldFocusLost
         if(confirmField.getText().length()==0){
            addPlaceHolderStyle(confirmField);
            confirmField.setText("Confirmar");
            confirmField.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_confirmFieldFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountLabel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPasswordField confirmField;
    private javax.swing.JTextField dateField;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton entryButton;
    private javax.swing.JLabel imagePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField nameField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JTextField telephoneField;
    // End of variables declaration//GEN-END:variables

}
