package BankManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class chgatmpinno {
    JFrame frame;
    JLabel heading;
    JMenuBar mb;
    JMenu accountsmry, accountstmt, profile, services, logout;
    JMenuItem profilesct, chglogindtl, deleteacc, accsmry, accstmt, logOut;
    JMenuItem chgatmpin, applynewservices, removeservices;
    JLabel prevpin, newpinw, renter;
    JPasswordField prepin, newpin, reenter;
    JButton show1, show2, show3, submit, cancel, reset;
    chgatmpinno(int formno){
        frame = new JFrame("Change Login Details");

        heading = new JLabel("Change Login Details");
        heading.setBounds(190, 60, 450, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 35));
        frame.add(heading);

        profilesct = new JMenuItem("Profile Section");
        chglogindtl = new JMenuItem("Change Login Details");
        deleteacc = new JMenuItem("Delete Account");

        chgatmpin = new JMenuItem("Change ATM pin");
        applynewservices = new JMenuItem("Apply new services");
        removeservices = new JMenuItem("Remove services");
        accsmry = new JMenuItem("Account Summary");
        accstmt = new JMenuItem("Account Statement");
        logOut = new JMenuItem("Logout");

        mb = new JMenuBar();
        accountsmry = new JMenu("Account Summary");
        accountstmt = new JMenu("Account Statement");
        profile = new JMenu("Profile");
        services = new JMenu("Services");
        logout = new JMenu("Logout");

        accountsmry.setForeground(Color.white);
        accountstmt.setForeground(Color.white);
        profile.setForeground(Color.white);
        services.setForeground(Color.white);
        logout.setForeground(Color.white);

        accountsmry.add(accsmry);

        accountstmt.add(accstmt);

        profile.add(profilesct);
        profile.add(chglogindtl);
        profile.add(deleteacc);

        services.add(chgatmpin);
        services.add(applynewservices);
        services.add(removeservices);

        logout.add(logOut);

        mb.add(accountsmry);
        mb.add(accountstmt);
        mb.add(profile);
        mb.add(services);
        mb.add(Box.createHorizontalGlue());
        mb.add(logout);

        mb.setSize(800, 50);
        mb.setBackground(Color.BLACK);
        mb.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 30));

        frame.add(mb);

        prevpin = new JLabel("Old Pin");
        prevpin.setBounds(165, 130, 200, 40);
        prevpin.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(prevpin);

        prepin = new JPasswordField();
        prepin.setBounds(350, 130, 250, 30);
        prepin.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(prepin);

        newpinw = new JLabel("New Pin");
        newpinw.setBounds(160, 180, 200, 40);
        newpinw.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(newpinw);

        newpin = new JPasswordField();
        newpin.setBounds(350, 180, 250, 30);
        newpin.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(newpin);

        renter = new JLabel("Re-enter Pin");
        renter.setBounds(120, 230, 200, 40);
        renter.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(renter);

        reenter = new JPasswordField();
        reenter.setBounds(350, 230, 250, 30);
        reenter.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(reenter);

        show1 = new JButton("Show");
        show1.setBounds(610, 130, 100, 30);
        show1.setFont(new Font("Arial", Font.BOLD, 20));
        show1.setBackground(Color.green);
        frame.add(show1);

        show2 = new JButton("Show");
        show2.setBounds(610, 180, 100, 30);
        show2.setFont(new Font("Arial", Font.BOLD, 20));
        show2.setBackground(Color.green);
        frame.add(show2);

        show3 = new JButton("Show");
        show3.setBounds(610, 230, 100, 30);
        show3.setFont(new Font("Arial", Font.BOLD, 20));
        show3.setBackground(Color.green);
        frame.add(show3);

        submit = new JButton("Submit");
        submit.setBounds(350, 280, 250, 30);
        submit.setFont(new Font("Arial", Font.BOLD, 20));
        submit.setBackground(Color.green);
        frame.add(submit);

        reset = new JButton("Reset");
        reset.setBounds(350, 330, 100, 30);
        reset.setFont(new Font("Arial", Font.BOLD, 20));
        reset.setBackground(Color.green);
        frame.add(reset);

        cancel = new JButton("Cancel");
        cancel.setBounds(500, 330, 100, 30);
        cancel.setFont(new Font("Arial", Font.BOLD, 20));
        cancel.setBackground(Color.green);
        frame.add(cancel);

        accsmry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new homePage(formno);
            }
        });

        accstmt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new accountstatement(formno);
            }
        });

        profilesct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new profilesection(formno);
            }
        });

        chglogindtl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new changelogindtl(formno);
            }
        });

        deleteacc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new deleteaccount(formno);
            }
        });

        chgatmpin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new chgatmpinno(formno);
            }
        });

        applynewservices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new aplynewservices(formno);
            }
        });

        removeservices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new rmvservices(formno);
            }
        });

        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Main();
            }
        });

        show1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(show1.getText().equals("Show")){
                    prepin.setEchoChar((char) 0);
                    show1.setText("Hide");
                } else if (show1.getText().equals("Hide")) {
                    prepin.setEchoChar('●');
                    show1.setText("Show");
                }
            }
        });

        show2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(show2.getText().equals("Show")){
                    newpin.setEchoChar((char) 0);
                    show2.setText("Hide");
                } else if (show2.getText().equals("Hide")) {
                    newpin.setEchoChar('●');
                    show2.setText("Show");
                }
            }
        });

        show3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(show3.getText().equals("Show")){
                    reenter.setEchoChar((char) 0);
                    show3.setText("Hide");
                } else if (show3.getText().equals("Hide")) {
                    reenter.setEchoChar('●');
                    show3.setText("Show");
                }
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int oldpin = Integer.parseInt(prepin.getText());
                int Newpin = Integer.parseInt(newpin.getText());
                int Repin = Integer.parseInt(reenter.getText());
                if(String.valueOf(Newpin).length()!=4){
                    JOptionPane.showMessageDialog(null, "ATM Pin length must be of 4");
                    return;
                }
                if(String.valueOf(Repin).length()!=4){
                    JOptionPane.showMessageDialog(null, "ATM Pin length must be of 4");
                    return;
                }
                if(!(Newpin==Repin)){
                    JOptionPane.showMessageDialog(null, "New Pin and Reenter Pin not same.");
                    return;
                }
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("Select * from bankdetails where formno = " + formno);
                    while(rs.next()){
                        if(rs.getInt("pin")==oldpin){
                            c.s.execute("UPDATE `bankdetails` SET `pin`= '" + Newpin + "' WHERE formno = " + formno);
                            JOptionPane.showMessageDialog(null, "ATM Pin updated successfully");
                            return;
                        }
                    }
                    frame.dispose();
                    new profilesection(formno);
                } catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prepin.setText("");
                newpin.setText("");
                reenter.setText("");
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new profilesection(formno);
            }
        });

        prepin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isISOControl(c)){
                    if(prepin.getText().length()<4){
                        prepin.setEditable(true);
                    } else {
                        prepin.setEditable(false);
                        if(Character.isISOControl(c)){
                            prepin.setEditable(true);
                            prepin.setText(prepin.getText().substring(0, 3));
                        }
                    }
                } else {
                    prepin.setEditable(false);
                }
            }
        });

        newpin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isISOControl(c)){
                    if(newpin.getText().length()<4){
                        newpin.setEditable(true);
                    } else {
                        newpin.setEditable(false);
                        if(Character.isISOControl(c)){
                            newpin.setEditable(true);
                            newpin.setText(newpin.getText().substring(0, 3));
                        }
                    }
                } else {
                    newpin.setEditable(false);
                }
            }
        });

        reenter.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isISOControl(c)){
                    if(reenter.getText().length()<4){
                        reenter.setEditable(true);
                    } else {
                        reenter.setEditable(false);
                        if(Character.isISOControl(c)){
                            reenter.setEditable(true);
                            reenter.setText(reenter.getText().substring(0, 3));
                        }
                    }
                } else {
                    reenter.setEditable(false);
                }
            }
        });

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                new profilesection(formno);
            }
        });
    }
}