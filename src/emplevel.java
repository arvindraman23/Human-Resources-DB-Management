
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
public class emplevel extends javax.swing.JFrame {

    /**
     * Creates new form emplevel
     */
    public emplevel() {
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

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(166, 81, 156, 20);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(166, 159, 156, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("INSERT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(241, 238, 101, 31);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(130, 238, 101, 31);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EMPLOYEE LEVEL");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 20, 220, 29);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Level Number:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(47, 80, 101, 18);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lowest salary:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(46, 158, 102, 18);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Highest salary:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(43, 197, 105, 18);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(166, 198, 156, 20);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(166, 120, 156, 20);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Employee ID:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(47, 119, 94, 18);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\SQL\\dbms project\\Screenshots\\2.png")); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 410, 300);

        setBounds(0, 0, 423, 333);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String lvlno=jTextField1.getText();
        String lowsal=jTextField2.getText();
        int ls=Integer.parseInt(lowsal);
        String highsal=jTextField3.getText();
        String empid=jTextField4.getText();
        int empty=0,existing=0,existing2=0,xcount=1;
        if(lvlno.length()==0&&lowsal.length()==0&&highsal.length()==0&&empid.length()==0)
        {
            empty++;
        }
        
        try
        {
            Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
            Statement myStat=myConn.createStatement();
            java.sql.ResultSet myRs=myStat.executeQuery("Select * from emplevel");
            while(myRs.next())
            {
                if(myRs.getString("LevelNo").equals(lvlno))
                existing++;
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        try
        {
            Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
            Statement myStat=myConn.createStatement();
            java.sql.ResultSet myRs=myStat.executeQuery("Select * from employee");
            while(myRs.next())
            {
                if(myRs.getString("EmployeeID").equals(empid))
                existing2++;
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        if(empty==0){
            if(existing==0){
                if(existing2!=0){
                try{

                    Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
                    PreparedStatement myStat=myConn.prepareStatement("insert into emplevel values('"+lvlno+"','"+empid+"','"+lowsal+"','"+highsal+"')");

                    myStat.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Inserted Successfully");
                    JOptionPane.showMessageDialog(null,"Trigger will be activated if the entered LowSalary is less than 10000 and this trigger will set it to 10000 by default.");
                    jTextField1.setText("");
                    jTextField2.setText("");

                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
                else{
                    JOptionPane.showMessageDialog(null,"Enter valid Employee ID");
                }
            }

            else{
                JOptionPane.showMessageDialog(null,"INVALID! Employee Level Already Exists!");
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
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
            java.util.logging.Logger.getLogger(emplevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(emplevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(emplevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(emplevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new emplevel().setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}