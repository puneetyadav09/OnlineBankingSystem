package BankManage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Main {
    JFrame frame;
    JLabel heading, logo, username, password;
    JTextField uname;
    JPasswordField pass;
    JButton login, signup, cancel, show;
    Main(){
        frame = new JFrame("Online Banking System");

        logo = new JLabel(new ImageIcon("C:\\Users\\punee.LAPTOP-9R1CSDR\\IdeaProjects\\OnlineBankManagement\\src\\BankManage\\assest\\Bank_logo.png"));
        logo.setBounds(100, 50, 100, 70);
        frame.add(logo);

        heading = new JLabel("Welcome to Online Banking System");
        heading.setBounds(230, 73, 450, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(heading);

        username = new JLabel("Username");
        username.setBounds(175, 150, 100, 30);
        username.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(username);

        password = new JLabel("Password");
        password.setBounds(175, 200, 100, 30);
        password.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(password);

        uname = new JTextField();
        uname.setBounds(300, 150, 250, 30);
        uname.setFont(new Font("Arial", Font.PLAIN, 16));
        Border border = BorderFactory.createCompoundBorder(uname.getBorder(), BorderFactory.createEmptyBorder(1, 2, 1, 0));
        uname.setBorder(border);
        frame.add(uname);

        pass = new JPasswordField();
        pass.setBounds(300, 200, 250, 30);
        pass.setFont(new Font("Arial", Font.PLAIN, 16));
        pass.setBorder(border);
        frame.add(pass);

        login = new JButton("Login");
        login.setBounds(300, 250, 250, 30);
        login.setFont(new Font("Arial", Font.BOLD, 20));
        login.setBackground(Color.green);
        frame.add(login);

        signup = new JButton("Open new Account");
        signup.setBounds(300, 310, 250, 30);
        signup.setFont(new Font("Arial", Font.BOLD, 20));
        signup.setBackground(Color.green);
        frame.add(signup);

        cancel = new JButton("Exit");
        cancel.setBounds(375, 350, 100, 30);
        cancel.setFont(new Font("Arial", Font.BOLD, 20));
        cancel.setBackground(Color.green);
        frame.add(cancel);

        show = new JButton("Show");
        show.setBounds(580, 200, 100, 30);
        show.setFont(new Font("Arial", Font.BOLD, 20));
        show.setBackground(Color.green);
        frame.add(show);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(uname.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Username is required");
                    return;
                } else if (pass.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Password is required");
                    return;
                } else {
                    try{
                        conn c = new conn();
                        String query2 = "Select * from login where username = '" + uname.getText() + "'";
                        ResultSet rs = c.s.executeQuery(query2);
                        while (rs.next()){
                            if(rs.getString(3).equals(pass.getText())){
                                JOptionPane.showMessageDialog(null, "Login Successfully");
                                frame.dispose();
                                new homePage(rs.getInt(1));
                                return;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Invalid Credential");
                    } catch (Exception ae){
                        ae.printStackTrace();
                    }
                }
            }
        });

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                String[] arr;
                arr = new String[]{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
                new signup(arr);
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(show.getText().equals("Show")){
                    pass.setEchoChar((char) 0);
                    show.setText("Hide");
                } else if (show.getText().equals("Hide")) {
                    pass.setEchoChar('●');
                    show.setText("Show");
                }
            }
        });

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(800, 450);
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}