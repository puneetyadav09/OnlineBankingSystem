package BankManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class aplynewservices {
    JFrame frame;
    JLabel heading, accno, emailsms, passbook, online, atmcard, done, notdone;
    JMenuBar mb;
    JRadioButton pass, onln, atm, emlsms;
    JMenu accountsmry, accountstmt, profile, services, logout;
    JMenuItem profilesct, chglogindtl, deleteacc, accsmry, accstmt, logOut;
    JMenuItem chgatmpin, applynewservices, removeservices;
    JButton submit;
    aplynewservices(int formno){
        frame = new JFrame("Apply New Services");

        heading = new JLabel("Apply New Services");
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

        mb.setSize(700, 50);
        mb.setBackground(Color.BLACK);
        mb.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 30));

        frame.add(mb);

        int already = 210, notalrdy = 210;
        boolean isemail = false, ispassbook = false, isatm = false, isonline = false;
        String accnu = "";

        done = new JLabel("Applied before");
        done.setBounds(150, 160, 200, 30);
        done.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(done);

        notdone = new JLabel("Add services");
        notdone.setBounds(400, 160, 200, 30);
        notdone.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(notdone);

        passbook = new JLabel("Passbook");
        atmcard = new JLabel("ATM Card");
        online = new JLabel("Internet Banking");
        emailsms = new JLabel("Email & SMS");

        pass = new JRadioButton("Passbook");
        atm = new JRadioButton("ATM Card");
        onln = new JRadioButton("Internet Banking");
        emlsms = new JRadioButton("Email & SMS");

        try{
            conn c = new conn();
            String query2 = "Select * from userbankdetails where formno = " + formno;
            ResultSet rs = c.s.executeQuery(query2);
            while (rs.next()){
                if(String.valueOf(rs.getString("passbook")).equals("yes"))
                    ispassbook = true;
                if(String.valueOf(rs.getString("emailsms")).equals("yes"))
                    isemail = true;
                if(String.valueOf(rs.getString("atmcard")).equals("yes"))
                    isatm = true;
                if(String.valueOf(rs.getString("onlineinternet")).equals("yes"))
                    isonline = true;
            }
            String query3 = "Select * from bankdetails where formno = " + formno;
            ResultSet rs1 = c.s.executeQuery(query3);
            while (rs1.next()){
                accnu = String.valueOf(rs1.getString("accountno"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        accno = new JLabel();
        accno.setText("Account number: " + accnu);
        accno.setBounds(100, 110, 400, 30);
        accno.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(accno);

        if (ispassbook){
            passbook.setBounds(150, already, 200, 30);
            passbook.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(passbook);
            already += 50;
        } else {
            pass.setBounds(400, notalrdy, 200, 30);
            pass.setFont(new Font("Arial", Font.BOLD, 20));
            pass.setBackground(Color.white);
            frame.add(pass);
            notalrdy += 50;
        }
        if (isatm){
            atmcard.setBounds(150, already, 200, 30);
            atmcard.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(atmcard);
            already += 50;
        } else {
            atm.setBounds(400, notalrdy, 200, 30);
            atm.setFont(new Font("Arial", Font.BOLD, 20));
            atm.setBackground(Color.white);
            frame.add(atm);
            notalrdy += 50;
        }
        if (isemail){
            emailsms.setBounds(150, already, 200, 30);
            emailsms.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(emailsms);
            already += 50;
        } else {
            emlsms.setBounds(400, notalrdy, 200, 30);
            emlsms.setFont(new Font("Arial", Font.BOLD, 20));
            emlsms.setBackground(Color.white);
            frame.add(emlsms);
            notalrdy += 50;
        }
        if (isonline){
            online.setBounds(150, already, 200, 30);
            online.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(online);
        } else {
            onln.setBounds(400, notalrdy, 200, 30);
            onln.setFont(new Font("Arial", Font.BOLD, 20));
            onln.setBackground(Color.white);
            frame.add(onln);
            notalrdy += 50;
        }

        submit = new JButton("Submit");
        submit.setBounds(400, notalrdy, 150, 30);
        submit.setFont(new Font("Arial", Font.BOLD, 20));
        submit.setBackground(Color.green);
        frame.add(submit);

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

        boolean finalIspassbook = ispassbook;
        boolean finalIsonline = isonline;
        boolean finalIsatm = isatm;
        boolean finalIsemail = isemail;
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c = new conn();
                    if(!finalIspassbook && pass.isSelected()){
                        c.s.execute("UPDATE `userbankdetails` SET `passbook`='yes' WHERE formno = " + formno);
                    }
                    if(!finalIsonline && onln.isSelected()){
                        c.s.execute("UPDATE `userbankdetails` SET `onlineinternet`='yes' WHERE formno = " + formno);
                    }
                    if(!finalIsatm && atm.isSelected()){
                        c.s.execute("UPDATE `userbankdetails` SET `atmcard`='yes' WHERE formno = " + formno);
                    }
                    if(!finalIsemail && emlsms.isSelected()){
                        c.s.execute("UPDATE `userbankdetails` SET `emailsms`='yes' WHERE formno = " + formno);
                    }
                    JOptionPane.showMessageDialog(null, "Services removed successfully");
                    frame.dispose();
                    new profilesection(formno);
                } catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(700, 600);
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