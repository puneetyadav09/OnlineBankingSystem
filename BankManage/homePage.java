package BankManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class homePage {
    JFrame frame;
    JLabel heading, srno, accno, bankname, balance, last10trnsc;
    JLabel srnu, accnu, bnkname, blnc, lsttrnsc;
    JMenuBar mb;
    JMenu accountsmry, accountstmt, profile, services, logout;
    JMenuItem profilesct, chglogindtl, deleteacc, accsmry, accstmt, logOut;
    JMenuItem chgatmpin, applynewservices, removeservices;
    homePage(int formno){
        frame = new JFrame("Home Page");

        heading = new JLabel("Account Summary");
        heading.setBounds(235, 60, 450, 40);
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

        mb.setSize(900, 50);
        mb.setBackground(Color.BLACK);
        mb.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 30));

        frame.add(mb);

        srno = new JLabel("Sr. No.");
        srno.setBounds(10, 120, 100, 40);
        srno.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(srno);

        accno = new JLabel("Account No.");
        accno.setBounds(100, 120, 150, 40);
        accno.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(accno);

        bankname = new JLabel("Bank Name");
        bankname.setBounds(250, 120, 150, 40);
        bankname.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(bankname);

        balance = new JLabel("Balance");
        balance.setBounds(400, 120, 150, 40);
        balance.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(balance);

        last10trnsc = new JLabel("Last Transaction");
        last10trnsc.setBounds(550, 120, 150, 40);
        last10trnsc.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(last10trnsc);

        srnu = new JLabel("1");
        srnu.setBounds(10, 170, 80, 40);
        srnu.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(srnu);

        accnu = new JLabel();
        accnu.setBounds(80, 170, 180, 40);
        accnu.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(accnu);

        bnkname = new JLabel("PY Bank");
        bnkname.setBounds(250, 170, 150, 40);
        bnkname.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(bnkname);

        blnc = new JLabel();
        blnc.setBounds(400, 170, 150, 40);
        blnc.setFont(new Font("Arial", Font.BOLD, 16));
        blnc.setForeground(Color.blue);
        frame.add(blnc);

        lsttrnsc = new JLabel();
        lsttrnsc.setBounds(550, 170, 300, 40);
        lsttrnsc.setFont(new Font("Arial", Font.BOLD, 16));
        lsttrnsc.setForeground(Color.blue);
        frame.add(lsttrnsc);

        blnc.setText("Check Balance");
        lsttrnsc.setText("Click here to see last transaction");

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from bankdetails where formno = " + formno);
            while (rs.next()){
                accnu.setText(String.valueOf(rs.getString("cardno")));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        blnc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from bankdetails where formno = " + formno);
                    while (rs.next()){
                        blnc.setText(String.valueOf(rs.getInt("balance")));
                        blnc.setForeground(Color.black);
                    }
                } catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        lsttrnsc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    conn c = new conn();
                    ResultSet rs1 = c.s.executeQuery("select * from transactions where formno = " + formno);
                    if(!rs1.next()){
                        lsttrnsc.setText("No transaction yet");
                        lsttrnsc.setForeground(Color.black);
                        return;
                    }
                    while (rs1.next()){
                        String s = rs1.getString("deposittype") + " Rs. " + rs1.getInt("amount");
                        lsttrnsc.setText(s);
                        lsttrnsc.setForeground(Color.black);
                    }
                } catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

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

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(900, 300);
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

    public static void main(String[] args) {
        new homePage(123);
    }
}