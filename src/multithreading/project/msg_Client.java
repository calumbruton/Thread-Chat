
package multithreading.project;

import java.io.*;
import java.net.*;
import java.util.Scanner;


/**
 * A simple client/server application in java 
 * Used TCP/IP protocol to program sockets
 * 
 * Created by: Calum Bruton
 * Version 1: June 11 2017
 */

public class msg_Client extends javax.swing.JFrame {

    /**
     * Creates new form msg_Client
     */

    Socket MyClient;
    static int total_cli_num = 0;
    
    int cli_num;
    
    //Constructor
    public msg_Client() {
        initComponents();
        total_cli_num++;
        cli_num = total_cli_num;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        msg_field = new javax.swing.JTextField();
        msg_send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msg_area.setColumns(20);
        msg_area.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);

        msg_field.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        msg_field.setToolTipText("");

        msg_send.setText("jButton1");
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(msg_field, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msg_send, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msg_field)
                    .addComponent(msg_send, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //BUTTON ACTION
    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_sendActionPerformed
        try{
            //When the button is pressed get the text in the text field
            String msg = msg_field.getText();

             //Now pass the msg to the server
             PrintStream p = new PrintStream(MyClient.getOutputStream());
             p.println(msg);
        }
        catch (IOException e) {
            System.out.println(e);
        } 

    }//GEN-LAST:event_msg_sendActionPerformed

    /**
     * Run the client from this method with the parameters of the client
     * and the port number on which you would like the client to run
     */
    public void run_client(msg_Client msg_cli) {
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
            java.util.logging.Logger.getLogger(msg_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(msg_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(msg_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(msg_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            msg_cli.MyClient = new Socket("localhost", 9999);
             }          
        catch (IOException e) {
            System.out.println(e);
        } 
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                msg_cli.setVisible(true);
                msg_cli.setTitle("Client " + msg_cli.cli_num);
            }
        });
    
        //Show reply's from the server until the reply is exit
        try {
            Scanner sc = new Scanner(msg_cli.MyClient.getInputStream());
            String reply = "";
            while(!reply.equals("exit")){

                //To accept the answer from the server use sc Scanner
                reply = sc.nextLine();
                msg_cli.msg_area.setText(msg_cli.msg_area.getText()+reply+"\n");
                System.out.println("Reply to thread: " + msg_cli.cli_num);
            } 
        }
                 
        catch (IOException e) {
            System.out.println(e);
        } 
        
        
    } //End of run_client

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea msg_area;
    private javax.swing.JTextField msg_field;
    private javax.swing.JButton msg_send;
    // End of variables declaration//GEN-END:variables
}
