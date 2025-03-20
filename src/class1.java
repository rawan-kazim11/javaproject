import javax.swing.JOptionPane;

public class class1 extends javax.swing.JFrame {

    public class1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        username1 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        passW = new javax.swing.JPasswordField();
        jButtonlogin = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        password = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setForeground(new java.awt.Color(0, 102, 102));

        username1.setFont(new java.awt.Font("Tahoma", 1, 18));
        username1.setForeground(new java.awt.Color(0, 153, 153));
        username1.setText("Hospital Management System");

        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });

        jButtonlogin.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButtonlogin.setForeground(new java.awt.Color(0, 153, 153));
        jButtonlogin.setText("Log in");
        jButtonlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonloginActionPerformed(evt);
            }
        });

        jButtonReset.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButtonReset.setForeground(new java.awt.Color(0, 153, 153));
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Tahoma", 1, 14));
        username.setForeground(new java.awt.Color(0, 153, 153));
        username.setText("Username :");

        password.setFont(new java.awt.Font("Tahoma", 1, 14));
        password.setForeground(new java.awt.Color(0, 153, 153));
        password.setText("Password :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(username)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passW, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jButtonlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(username1)
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username)
                    .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(passW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReset)
                    .addComponent(jButtonlogin))
                .addGap(65, 65, 65))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButtonloginActionPerformed(java.awt.event.ActionEvent evt) {
        String user = uname.getText();
        String pass = passW.getText();
        if (!user.equals("") && !pass.equals("")) {
            if (user.equals("admin") && pass.equals("2010")) {
                // Open the main menu or dashboard (replace with your logic)
                JOptionPane.showMessageDialog(null, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Username and password cannot be empty");
        }
    }

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {
        uname.setText("");
        passW.setText("");
    }

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {
        // Do nothing
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new class1().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonlogin;
    private javax.swing.JPasswordField passW;
    private javax.swing.JLabel password;
    private javax.swing.JTextField uname;
    private javax.swing.JLabel username;
    private javax.swing.JLabel username1;
}