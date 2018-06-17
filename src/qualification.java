
import java.sql.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class qualification extends javax.swing.JFrame {

    /**
     * Creates new form qualification
     */
    public qualification() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUALIFICATION");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 24, 200, 29);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Qualificaton ID:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(55, 117, 151, 18);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Qualification Designation:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 171, 221, 18);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(249, 118, 156, 20);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(249, 172, 156, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("INSERT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(271, 247, 101, 31);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(164, 247, 101, 31);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\SQL\\dbms project\\Screenshots\\2.png")); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 430, 310);

        setBounds(0, 0, 441, 345);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String qualid=jTextField1.getText();
        String qualdes=jTextField2.getText();
        int empty=0,existing=0;
        if(qualid.length()==0&&qualdes.length()==0)
        {
            empty++;
        }
        try
        {
            Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
            Statement myStat=myConn.createStatement();
            java.sql.ResultSet myRs=myStat.executeQuery("Select * from qualification");
            while(myRs.next())
            {
                if(myRs.getString("QualID").equals(qualid))
                existing++;
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        if(empty==0){
            if(existing==0){

                try{

                    Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
                    PreparedStatement myStat=myConn.prepareStatement("insert into qualification values('"+qualid+"','"+qualdes+"')");

                    myStat.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Inserted Successfully");
                    jTextField1.setText("");
                    jTextField2.setText("");

                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }

            else{
                JOptionPane.showMessageDialog(null,"INVALID! Qualification Already Exists!");
                jTextField1.setText("");
                jTextField2.setText("");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Enter all the credentials");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        hrinsertmain obj=new hrinsertmain();
        obj.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(qualification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(qualification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(qualification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(qualification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new qualification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
