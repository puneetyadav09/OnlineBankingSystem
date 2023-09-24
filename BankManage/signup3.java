package BankManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.Arrays;
import org.passay.*;

public class signup3 {
    JFrame frame;
    JLabel logo, heading, accounttype, existingacc, services;
    JRadioButton savingacc, currentacc, yes, no;
    JCheckBox emailsms, onlineinternet, atmcard, passbook, tnc;
    JButton submit, reset, back;
    ButtonGroup b1, b2;
    signup3(String[] arr){
        frame = new JFrame("Bank Information");

        logo = new JLabel(new ImageIcon("C:\\Users\\punee.LAPTOP-9R1CSDR\\IdeaProjects\\OnlineBankManagement\\src\\BankManage\\assest\\Bank_logo.png"));
        logo.setBounds(100, 25, 100, 70);
        frame.add(logo);

        heading = new JLabel("Bank Information");
        heading.setBounds(300, 48, 450, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(heading);

        accounttype = new JLabel("Account Type");
        accounttype.setBounds(150, 125, 150, 30);
        accounttype.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(accounttype);

        services = new JLabel("Services");
        services.setBounds(150, 175, 150, 30);
        services.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(services);

        existingacc = new JLabel("Existing Account");
        existingacc.setBounds(150, 275, 150, 30);
        existingacc.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(existingacc);

        savingacc = new JRadioButton("Saving Account");
        savingacc.setBounds(350, 125, 150, 30);
        savingacc.setFont(new Font("Arial", Font.PLAIN, 16));
        savingacc.setOpaque(false);
        frame.add(savingacc);

        currentacc = new JRadioButton("Current Account");
        currentacc.setBounds(515, 125, 150, 30);
        currentacc.setFont(new Font("Arial", Font.PLAIN, 16));
        currentacc.setOpaque(false);
        frame.add(currentacc);

        passbook = new JCheckBox("Pass Book");
        passbook.setBounds(350, 175, 150, 30);
        passbook.setFont(new Font("Arial", Font.PLAIN, 16));
        passbook.setOpaque(false);
        frame.add(passbook);

        emailsms = new JCheckBox("Email and SMS");
        emailsms.setBounds(515, 175, 150, 30);
        emailsms.setFont(new Font("Arial", Font.PLAIN, 16));
        emailsms.setOpaque(false);
        frame.add(emailsms);

        atmcard = new JCheckBox("ATM card");
        atmcard.setBounds(350, 225, 150, 30);
        atmcard.setFont(new Font("Arial", Font.PLAIN, 16));
        atmcard.setOpaque(false);
        frame.add(atmcard);

        onlineinternet = new JCheckBox("Internet Banking");
        onlineinternet.setBounds(515, 225, 150, 30);
        onlineinternet.setFont(new Font("Arial", Font.PLAIN, 16));
        onlineinternet.setOpaque(false);
        frame.add(onlineinternet);

        yes = new JRadioButton("Yes");
        yes.setBounds(350, 275, 150, 30);
        yes.setFont(new Font("Arial", Font.PLAIN, 16));
        yes.setOpaque(false);
        frame.add(yes);

        no = new JRadioButton("No");
        no.setBounds(515, 275, 150, 30);
        no.setFont(new Font("Arial", Font.PLAIN, 16));
        no.setOpaque(false);
        frame.add(no);

        b1 = new ButtonGroup();
        b1.add(savingacc);
        b1.add(currentacc);

        b2 = new ButtonGroup();
        b2.add(yes);
        b2.add(no);

        tnc = new JCheckBox("I hereby agree for all terms and conditions");
        tnc.setBounds(150, 330, 500, 30);
        tnc.setFont(new Font("Arial", Font.PLAIN, 16));
        tnc.setOpaque(false);
        frame.add(tnc);

        submit = new JButton("Submit");
        submit.setBounds(225, 390, 350, 30);
        submit.setFont(new Font("Arial", Font.PLAIN, 20));
        submit.setBackground(Color.green);
        frame.add(submit);

        reset = new JButton("Reset");
        reset.setBounds(225, 440, 150, 30);
        reset.setFont(new Font("Arial", Font.PLAIN, 20));
        reset.setBackground(Color.green);
        frame.add(reset);

        back = new JButton("Back");
        back.setBounds(425, 440, 150, 30);
        back.setFont(new Font("Arial", Font.PLAIN, 20));
        back.setBackground(Color.green);
        frame.add(back);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!savingacc.isSelected() && !currentacc.isSelected()){
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                    return;
                } else if (!passbook.isSelected() && !emailsms.isSelected() && !atmcard.isSelected() && !onlineinternet.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Services is required");
                    return;
                } else if (!yes.isSelected() && !no.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Existing account option is required");
                    return;
                } else if (!tnc.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please accept our terms and conditions");
                    return;
                } else {
                    if (yes.isSelected()){
                        JOptionPane.showMessageDialog(null, "You have an existing account in our bank");
                        frame.dispose();
                        new Main();
                        return;
                    }
                    if (savingacc.isSelected())
                        arr[17] = "Saving Account";
                    else if (currentacc.isSelected())
                        arr[17] = "Current Account";
                    arr[18] = passbook.isSelected()?"yes":"no";
                    arr[19] = emailsms.isSelected()?"yes":"no";
                    arr[20] = atmcard.isSelected()?"yes":"no";
                    arr[21] = onlineinternet.isSelected()?"yes":"no";
                    try{
                        conn c = new conn();
                        ResultSet rs = c.s.executeQuery("select * from login");
                        int formno, pin;
                        String username, cardno, accno;
                        int getit = 0;
                        do {
                            formno = (int) (Math.random() * 100000);
                            String regex = String.format("^((?:\\W*\\w+){%s}).*$", 1);
                            username = arr[0].replaceAll(regex, "$1");
                            username += (int) (Math.random() * 10000);
                            cardno = String.valueOf((int)(Math.random() * 10000000000000000L));
                            accno = String.valueOf((int)(Math.random() * 100000000000000L));
                            while (rs.next()) {
                                if ((rs.getInt(1) == formno) && rs.getString(2).equals(username) && String.valueOf(rs.getString("cardno")).equals(cardno) && String.valueOf(rs.getString("accountno")).equals(accno)) {
                                    getit = 1;
                                    break;
                                }
                            }
                        } while (getit == 1);
                        pin = (int) (Math.random()*10000);
                        if(String.valueOf(pin).length()!=4){
                            pin = Integer.parseInt(String.valueOf(pin).substring(0, 3));
                        }
                        String password = generateSecurePassword();
                        String query2 = "insert into userpersonaldetails values(" + formno + ", '" + arr[0] + "', '" + arr[1]
                                + "', '" + arr[2] + "', '" + arr[3] + "', " + arr[4] + ", '" + arr[5] + "', '" + arr[6]
                                + "', '" + arr[7] + "', " + arr[8] + ", '" + arr[9] + "', '" + arr[10] + "', '" + arr[11] + "')";
                        String query3 = "insert into usersdocumentdetails values(" + formno + ", '" + arr[12] + "', '" + arr[13]
                                + "', " + arr[14] + ", '" + arr[15] + "', '" + arr[16] + "')";
                        String query4 = "insert into userbankdetails values(" + formno + ", '" + arr[17] + "', '" + arr[18]
                                + "', '" + arr[19] + "', '" + arr[20] + "', '" + arr[21] + "')";
                        String query5 = "insert into login values(" + formno + ", '" + username + "', '" + password + "', '" + cardno + "', '" + accno + "')";
                        String query6 = "insert into bankdetails values(" + formno + ", '" + accno + "', '" + cardno + "', " + pin + ", 0)";
                        c.s.execute(query2);
                        c.s.execute(query3);
                        c.s.execute(query4);
                        c.s.execute(query5);
                        c.s.execute(query6);
                        JOptionPane.showMessageDialog(null, "Signup Successfully");
                        JOptionPane.showMessageDialog(null, "Username : " + username + "\nPassword : " + password);
                        frame.dispose();
                        new profilesection(formno);
                        return;
                    } catch (Exception ae){
                        ae.printStackTrace();
                    }
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b1.clearSelection();
                b2.clearSelection();
                tnc.setSelected(false);
                passbook.setSelected(false);
                atmcard.setSelected(false);
                onlineinternet.setSelected(false);
                emailsms.setSelected(false);
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new signup2(arr);
            }
        });

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(800, 700);
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.gc();System.exit(0);
            }
        });
    }
    public static String generateSecurePassword(){
        PasswordGenerator gen = new PasswordGenerator();
        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(3);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(3);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(3);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                String Error = null;
                return Error;
            }

            public String getCharacters() {
                return "~`!@#$%^&*()_-+={}|[]\\:\";'<>?,./'";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(3);

        String password = gen.generatePassword(12, splCharRule, lowerCaseRule,
                upperCaseRule, digitRule);
        return password;
    }
}














