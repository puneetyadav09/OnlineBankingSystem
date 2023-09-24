package BankManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class accountstatement {
    JFrame frame;
    JLabel heading;
    JMenuBar mb;
    JMenu accountsmry, accountstmt, profile, services, logout;
    JMenuItem profilesct, chglogindtl, deleteacc, accsmry, accstmt, logOut;
    JMenuItem chgatmpin, applynewservices, removeservices;
    JLabel account, card;
    JTextField accountno, cardno;
    JButton submit, cancel;
    accountstatement(int formno){
        frame = new JFrame("Account Statement");

        heading = new JLabel("Account Statement");
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

        account = new JLabel("Account no");
        account.setBounds(120, 120, 200, 30);
        account.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(account);

        card = new JLabel("Card");
        card.setBounds(120, 180, 200, 30);
        card.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(card);

        accountno = new JTextField();
        accountno.setBounds(350, 120, 200, 30);
        accountno.setFont(new Font("Arial", Font.PLAIN, 20));
        accountno.setEditable(false);
        frame.add(accountno);

        cardno = new JTextField();
        cardno.setBounds(350, 180, 200, 30);
        cardno.setFont(new Font("Arial", Font.PLAIN, 20));
        cardno.setEditable(false);
        frame.add(cardno);

        submit = new JButton("Print");
        submit.setBounds(270, 250, 300, 30);
        submit.setFont(new Font("Arial", Font.PLAIN, 20));
        submit.setBackground(Color.green);
        frame.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(350, 320, 130, 30);
        cancel.setFont(new Font("Arial", Font.PLAIN, 20));
        cancel.setBackground(Color.green);
        frame.add(cancel);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM `bankdetails` where formno = " + formno);
            while(rs.next()){
                accountno.setText(rs.getString("accountno"));
                cardno.setText(rs.getString("cardno"));
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
                Document document = new Document();
                try
                {
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("Select * from transactions where formno = " + formno);
                    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Acccount statement.pdf"));
                    document.open();
                    document.add(new Paragraph("Date                                                     " + "   cardno     " + "              deposittype            " + " amount"));
                    while (rs.next()){
                        String a;
                        if(rs.getString("deposittype").equals("deposit"))
                            a = "Deposited";
                        else
                            a = "Withdrawl";
                        document.add(new Paragraph(rs.getString("date") + "           " + rs.getInt("cardno") + "             " + a + "                  " + rs.getInt("amount")));
                    }
                    document.close();
                    writer.close();
                } catch (DocumentException | FileNotFoundException ae) {
                    ae.printStackTrace();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Pdf saved.");
                frame.dispose();
                new profilesection(formno);
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
        frame.setSize(900, 450);
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