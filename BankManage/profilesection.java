package BankManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;

public class profilesection {
    JFrame frame;
    JLabel heading;
    JMenuBar mb;
    JMenu accountsmry, accountstmt, profile, services, logout;
    JMenuItem profilesct, chglogindtl, deleteacc, accsmry, accstmt, logOut;
    JMenuItem chgatmpin, applynewservices, removeservices;
    JLabel greet;
    JLabel chngpin, chngpass, chngacctype, withdraw, deposit, card, balance, eml;
    JFrame f1;
    JLabel heading1;
    JButton submit1, cancel1;
    profilesection(int formno){
        frame = new JFrame("Profile Section");

        heading = new JLabel("Profile Section");
        heading.setBounds(280, 60, 450, 40);
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

        greet = new JLabel("Greeting");
        greet.setBounds(300, 100, 200, 30);
        greet.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(greet);

        chngpin = new JLabel("Change ATM Pin");
        chngpin.setBounds(100, 150, 300, 30);
        chngpin.setFont(new Font("Arial", Font.BOLD, 20));
        chngpin.setForeground(Color.blue);
        chngpin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(chngpin);

        chngacctype = new JLabel("Change Account Type");
        chngacctype.setBounds(100, 200, 300, 30);
        chngacctype.setFont(new Font("Arial", Font.BOLD, 20));
        chngacctype.setForeground(Color.blue);
        chngacctype.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(chngacctype);

        chngpass = new JLabel("Change Password");
        chngpass.setBounds(100, 250, 300, 30);
        chngpass.setFont(new Font("Arial", Font.BOLD, 20));
        chngpass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        chngpass.setForeground(Color.blue);
        frame.add(chngpass);

        withdraw = new JLabel("WithDraw");
        withdraw.setBounds(100, 300, 300, 30);
        withdraw.setFont(new Font("Arial", Font.BOLD, 20));
        withdraw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        withdraw.setForeground(Color.blue);
        frame.add(withdraw);

        deposit = new JLabel("Deposit");
        deposit.setBounds(100, 350, 400, 30);
        deposit.setFont(new Font("Arial", Font.BOLD, 20));
        deposit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deposit.setForeground(Color.blue);
        frame.add(deposit);

        card = new JLabel("Card no. : ");
        card.setBounds(400, 200, 400, 30);
        card.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(card);

        balance = new JLabel("Balance: ");
        balance.setBounds(400, 250, 400, 30);
        balance.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(balance);

        eml = new JLabel("Email id: ");
        eml.setBounds(400, 300, 400, 30);
        eml.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(eml);

        try{
            conn c = new conn();
            String query1 = "Select * from userpersonaldetails where formno = " + formno;
            String query2 = "Select * from bankdetails where formno = " + formno;

            ResultSet rs = c.s.executeQuery(query1);
            while(rs.next()){
                String email = eml.getText();
                email += rs.getString("email");
                eml.setText(email);
            }

            rs = c.s.executeQuery(query2);
            while(rs.next()){
                String cardno = card.getText();
                cardno += rs.getString("cardno");
                card.setText(cardno);
                String blnc = balance.getText();
                blnc += rs.getString("balance");
                balance.setText(blnc);
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

        chngpin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new chgatmpinno(formno);
            }
        });

        chngpass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new changelogindtl(formno);
            }
        });

        chngacctype.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changetype(formno);
            }
        });

        withdraw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                withDraw(formno);
            }
        });

        deposit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Deposit(formno);
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

    public void changetype(int formno){
        f1 = new JFrame("Change account type");

        heading1 = new JLabel("Change Account Type");
        heading1.setBounds(100, 60, 400, 40);
        heading1.setFont(new Font("Arial", Font.BOLD, 30));
        f1.add(heading1);

        JLabel current, changeto, curr;
        JRadioButton tochange;

        current = new JLabel("Current type: ");
        current.setBounds(100, 120, 150, 30);
        current.setFont(new Font("Arial", Font.BOLD, 20));
        f1.add(current);

        changeto = new JLabel("Change to: ");
        changeto.setBounds(100, 180, 150, 30);
        changeto.setFont(new Font("Arial", Font.BOLD, 20));
        f1.add(changeto);

        curr = new JLabel();
        curr.setBounds(270, 120, 200, 30);
        curr.setFont(new Font("Arial", Font.BOLD, 20));
        f1.add(curr);

        tochange = new JRadioButton();
        tochange.setBounds(270, 180, 200, 30);
        tochange.setFont(new Font("Arial", Font.BOLD, 20));
        tochange.setBackground(Color.white);
        f1.add(tochange);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("Select * from userbankdetails where formno = " + formno);
            while (rs.next()){
                String type = rs.getString("accounttype");
                curr.setText(type);
                if(type.contains("Saving")){
                    tochange.setText("Current Account");
                } else {
                    tochange.setText("Saving Account");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        submit1 = new JButton("Submit");
        submit1.setBounds(170, 240, 250, 30);
        submit1.setFont(new Font("Arial", Font.BOLD, 20));
        submit1.setBackground(Color.green);
        f1.add(submit1);

        cancel1 = new JButton("Cancel");
        cancel1.setBounds(240, 280, 100, 30);
        cancel1.setFont(new Font("Arial", Font.BOLD, 20));
        cancel1.setBackground(Color.green);
        f1.add(cancel1);

        submit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(!tochange.isSelected()){
                        JOptionPane.showMessageDialog(null, "Either select option or cancel operation.");
                        return;
                    }
                    conn c = new conn();
                    c.s.execute("UPDATE `userbankdetails` SET `accounttype`='" + tochange.getText() + "' WHERE formno = " + formno);
                    JOptionPane.showMessageDialog(null, "Account type changed");
                    f1.dispose();
                } catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        cancel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.dispose();
            }
        });

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setSize(600, 400);
        f1.setLocation(dim.width/2-f1.getSize().width/2, dim.height/2-f1.getSize().height/2);
        f1.setResizable(false);
        f1.getContentPane().setBackground(Color.WHITE);
        f1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void withDraw(int formno){
        f1 = new JFrame("Withdraw");

        heading1 = new JLabel("Withdraw");
        heading1.setBounds(150, 60, 400, 40);
        heading1.setFont(new Font("Arial", Font.BOLD, 30));
        f1.add(heading1);

        JLabel amm;
        JTextField amount;

        amm = new JLabel("Amount ");
        amm.setBounds(100, 120, 200, 40);
        amm.setFont(new Font("Arial", Font.BOLD, 20));
        f1.add(amm);

        amount = new JTextField();
        amount.setBounds(350, 120, 200, 40);
        amount.setFont(new Font("Arial", Font.BOLD, 20));
        f1.add(amount);

        submit1 = new JButton("Submit");
        submit1.setBounds(170, 240, 250, 30);
        submit1.setFont(new Font("Arial", Font.BOLD, 20));
        submit1.setBackground(Color.green);
        f1.add(submit1);

        cancel1 = new JButton("Cancel");
        cancel1.setBounds(240, 280, 100, 30);
        cancel1.setFont(new Font("Arial", Font.BOLD, 20));
        cancel1.setBackground(Color.green);
        f1.add(cancel1);

        amount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isISOControl(c) || Character.isDigit(c))
                    amount.setEditable(true);
                else
                    amount.setEditable(false);
            }
        });

        submit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(amount.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter some amount");
                        return;
                    }
                    String card;
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("SELECT * FROM `bankdetails`");
                    while(rs.next()){
                        if(rs.getInt("balance") < Integer.parseInt(amount.getText())){
                            JOptionPane.showMessageDialog(null, "Insufficient Balance");
                            return;
                        }
                        card = rs.getString("cardno");
                        DateFormat dform = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                        Date dt = new Date();
                        String m1 = "UPDATE bankdetails set balance = " + (rs.getInt("balance")-Integer.parseInt(amount.getText())) + " where formno = " + formno;
                        String m2 = "INSERT INTO `transactions`(`formno`, `date`, `cardno`, `deposittype`, `amount`) VALUES (" + formno + ", '" + dform.format(dt) + "', '" + card + "', 'withdraw', " + Integer.parseInt(amount.getText()) + ")";
                        c.s.execute(m1);
                        c.s.execute(m2);
                        JOptionPane.showMessageDialog(null, "Rs. " + amount.getText() + " is withdraw");
                        f1.dispose();
                        return;
                    }
                } catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        cancel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.dispose();
            }
        });

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setSize(600, 400);
        f1.setLocation(dim.width/2-f1.getSize().width/2, dim.height/2-f1.getSize().height/2);
        f1.setResizable(false);
        f1.getContentPane().setBackground(Color.WHITE);
        f1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void Deposit(int formno){
        f1 = new JFrame("Deposit");

        heading1 = new JLabel("Deposit");
        heading1.setBounds(150, 60, 400, 40);
        heading1.setFont(new Font("Arial", Font.BOLD, 30));
        f1.add(heading1);

        JLabel amm;
        JTextField amount;

        amm = new JLabel("Amount ");
        amm.setBounds(100, 120, 200, 40);
        amm.setFont(new Font("Arial", Font.BOLD, 20));
        f1.add(amm);

        amount = new JTextField();
        amount.setBounds(350, 120, 200, 40);
        amount.setFont(new Font("Arial", Font.BOLD, 20));
        f1.add(amount);

        submit1 = new JButton("Submit");
        submit1.setBounds(170, 240, 250, 30);
        submit1.setFont(new Font("Arial", Font.BOLD, 20));
        submit1.setBackground(Color.green);
        f1.add(submit1);

        cancel1 = new JButton("Cancel");
        cancel1.setBounds(240, 280, 100, 30);
        cancel1.setFont(new Font("Arial", Font.BOLD, 20));
        cancel1.setBackground(Color.green);
        f1.add(cancel1);

        amount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isISOControl(c) || Character.isDigit(c))
                    amount.setEditable(true);
                else
                    amount.setEditable(false);
            }
        });

        submit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(amount.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter some amount");
                        return;
                    }
                    String card;
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("SELECT * FROM `bankdetails`");
                    while(rs.next()){
                        card = rs.getString("cardno");
                        DateFormat dform = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                        Date dt = new Date();
                        String m1 = "UPDATE bankdetails set balance = " + (rs.getInt("balance")+Integer.parseInt(amount.getText())) + " where formno = " + formno;
                        String m2 = "INSERT INTO `transactions`(`formno`, `date`, `cardno`, `deposittype`, `amount`) VALUES (" + formno + ", '" + dform.format(dt) + "', '" + card + "', 'deposit', " + Integer.parseInt(amount.getText()) + ")";
                        c.s.execute(m1);
                        c.s.execute(m2);
                        JOptionPane.showMessageDialog(null, "Rs. " + amount.getText() + " is deposited");
                        f1.dispose();
                        return;
                    }
                } catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        cancel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.dispose();
            }
        });

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setSize(600, 400);
        f1.setLocation(dim.width/2-f1.getSize().width/2, dim.height/2-f1.getSize().height/2);
        f1.setResizable(false);
        f1.getContentPane().setBackground(Color.WHITE);
        f1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new profilesection(7535);
    }
}