package BankManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class deleteaccount {
    JFrame frame;
    JLabel heading;
    JMenuBar mb;
    JMenu accountsmry, accountstmt, profile, services, logout;
    JMenuItem profilesct, chglogindtl, deleteacc, accsmry, accstmt, logOut;
    JMenuItem chgatmpin, applynewservices, removeservices;
    JLabel msg, accountno;
    JRadioButton yes, no;
    ButtonGroup g1;
    JButton submit, cancel, reset;
    deleteaccount(int formno){
        frame = new JFrame("Delete Account");

        heading = new JLabel("Delete Account");
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

        accountno = new JLabel("acc");
        accountno.setBounds(500, 100, 300, 30);
        accountno.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(accountno);

        msg = new JLabel("Msg");
        msg.setBounds(80, 180, 630, 30);
        msg.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(msg);

        g1 = new ButtonGroup();

        yes = new JRadioButton("Yes");
        yes.setBounds(270, 250, 100, 30);
        yes.setFont(new Font("Arial", Font.BOLD, 20));
        yes.setBackground(Color.white);
        frame.add(yes);

        no = new JRadioButton("No");
        no.setBounds(390, 250, 100, 30);
        no.setFont(new Font("Arial", Font.BOLD, 20));
        no.setBackground(Color.white);
        frame.add(no);

        g1.add(yes);
        g1.add(no);

        submit = new JButton("Submit");
        submit.setBounds(250, 320, 250, 30);
        submit.setFont(new Font("Arial", Font.BOLD, 20));
        submit.setBackground(Color.green);
        frame.add(submit);

        reset = new JButton("Reset");
        reset.setBounds(250, 370, 100, 30);
        reset.setFont(new Font("Arial", Font.BOLD, 20));
        reset.setBackground(Color.green);
        frame.add(reset);

        cancel = new JButton("Cancel");
        cancel.setBounds(400, 370, 100, 30);
        cancel.setFont(new Font("Arial", Font.BOLD, 20));
        cancel.setBackground(Color.green);
        frame.add(cancel);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("Select * from bankdetails where formno = " + formno);
            while(rs.next()){
                String acc = rs.getString("accountno");
                String message = "Are you sure to delete account having account no. = " + acc;
                accountno.setText("Account no. " + acc);
                msg.setText(message);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

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

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(g1.getSelection()== no.getModel()){
                    frame.dispose();
                    new profilesection(formno);
                }
                try{
                    conn c = new conn();
                    String m1 = "DELETE FROM `bankdetails` WHERE formno = " + formno;
                    String m2 = "DELETE FROM `login` WHERE formno = " + formno;
                    String m3 = "DELETE FROM `transactions` WHERE formno = " + formno;
                    String m4 = "DELETE FROM `userbankdetails` WHERE formno = " + formno;
                    String m5 = "DELETE FROM `userpersonaldetails` WHERE formno = " + formno;
                    String m6 = "DELETE FROM `usersdocumentdetails` WHERE formno = " + formno;
                    c.s.execute(m1);
                    c.s.execute(m2);
                    c.s.execute(m3);
                    c.s.execute(m4);
                    c.s.execute(m5);
                    c.s.execute(m6);
                    JOptionPane.showMessageDialog(null, "Your Account deleted permanently.");
                    frame.dispose();
                    new Main();
                } catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g1.clearSelection();
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new profilesection(formno);
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
                System.exit(0);
            }
        });
    }
}