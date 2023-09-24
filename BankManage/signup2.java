package BankManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signup2 {
    JFrame frame;
    JLabel logo, heading, religion, category, income, martialstatus, aadhaarcard, pancard, senior;
    JComboBox<String> religioncb, categorycb, incomecb;
    JTextField aadhaarcardtf, pancardtf;
    JRadioButton married, unmarried, senioryes, seniorno;
    ButtonGroup b1, b2;
    JButton next, reset, back;
    String[] religions = {"Select religion", "Hindu", "Muslim", "Sikh", "Christian"};
    String[] categories = {"Select category", "General", "OBC", "SC", "ST"};
    String[] incomes = {"Select income", "Less than < 1,00,000", "Between 1,00,000 to 5,00,000", "Between 5,00,000 to 10,00,000",
    "Above > 10,00,000"};
    signup2(String[] arr){
        frame = new JFrame("Document Information");

        logo = new JLabel(new ImageIcon("C:\\Users\\punee.LAPTOP-9R1CSDR\\IdeaProjects\\OnlineBankManagement\\src\\BankManage\\assest\\Bank_logo.png"));
        logo.setBounds(100, 25, 100, 70);
        frame.add(logo);

        heading = new JLabel("Personal Information");
        heading.setBounds(300, 48, 450, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(heading);

        religion = new JLabel("Religion");
        religion.setBounds(175, 125, 200, 40);
        religion.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(religion);

        category = new JLabel("Category");
        category.setBounds(175, 175, 200, 40);
        category.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(category);

        income = new JLabel("Income");
        income.setBounds(175, 225, 200, 40);
        income.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(income);

        martialstatus = new JLabel("Marital Status");
        martialstatus.setBounds(175, 275, 200, 40);
        martialstatus.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(martialstatus);

        aadhaarcard = new JLabel("Aadhaar Card No.");
        aadhaarcard.setBounds(175, 325, 200, 40);
        aadhaarcard.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(aadhaarcard);

        pancard = new JLabel("Pan Card No.");
        pancard.setBounds(175, 375, 200, 40);
        pancard.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(pancard);

        senior = new JLabel("Senior Citizen");
        senior.setBounds(175, 425, 200, 40);
        senior.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(senior);

        religioncb = new JComboBox<String>(religions);
        religioncb.setBounds(375, 125, 275, 30);
        religioncb.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(religioncb);

        categorycb = new JComboBox<String>(categories);
        categorycb.setBounds(375, 175, 275, 30);
        categorycb.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(categorycb);

        incomecb = new JComboBox<String>(incomes);
        incomecb.setBounds(375, 225, 275, 30);
        incomecb.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(incomecb);

        married = new JRadioButton("Married");
        married.setBounds(375, 275, 100, 30);
        married.setFont(new Font("Arial", Font.PLAIN, 16));
        married.setOpaque(false);
        frame.add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(520, 275, 150, 30);
        unmarried.setFont(new Font("Arial", Font.PLAIN, 16));
        unmarried.setOpaque(false);
        frame.add(unmarried);

        aadhaarcardtf = new JTextField();
        aadhaarcardtf.setBounds(375, 325, 275, 30);
        aadhaarcardtf.setFont(new Font("Arial", Font.PLAIN, 16));
        aadhaarcardtf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(aadhaarcardtf);

        pancardtf = new JTextField();
        pancardtf.setBounds(375, 375, 275, 30);
        pancardtf.setFont(new Font("Arial", Font.PLAIN, 16));
        pancardtf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(pancardtf);

        senioryes = new JRadioButton("Yes");
        senioryes.setBounds(375, 425, 150, 30);
        senioryes.setFont(new Font("Arial", Font.PLAIN, 16));
        senioryes.setOpaque(false);
        frame.add(senioryes);

        seniorno = new JRadioButton("No");
        seniorno.setBounds(520, 425, 150, 30);
        seniorno.setFont(new Font("Arial", Font.PLAIN, 16));
        seniorno.setOpaque(false);
        frame.add(seniorno);

        next = new JButton("Next");
        next.setBounds(265, 500, 300, 30);
        next.setFont(new Font("Arial", Font.PLAIN, 16));
        next.setBackground(Color.green);
        frame.add(next);

        reset = new JButton("Reset");
        reset.setBounds(220, 550, 150, 30);
        reset.setFont(new Font("Arial", Font.PLAIN, 16));
        reset.setBackground(Color.green);
        frame.add(reset);

        back = new JButton("Back");
        back.setBounds(460, 550, 150, 30);
        back.setFont(new Font("Arial", Font.PLAIN, 16));
        back.setBackground(Color.green);
        frame.add(back);

        pancardtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int position = pancardtf.getCaretPosition();
                pancardtf.setText(pancardtf.getText().toUpperCase());
                pancardtf.setCaretPosition(position);
            }
        });

        aadhaarcardtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isISOControl(c)){
                    if(aadhaarcardtf.getText().length()<12){
                        aadhaarcardtf.setEditable(true);
                    } else {
                        aadhaarcardtf.setEditable(false);
                        if(Character.isISOControl(c)){
                            aadhaarcardtf.setEditable(true);
                            aadhaarcardtf.setText(aadhaarcardtf.getText().substring(0, 11));
                        }
                    }
                } else {
                    aadhaarcardtf.setEditable(false);
                }
            }
        });

        b1 = new ButtonGroup();
        b1.add(married);
        b1.add(unmarried);

        b2 = new ButtonGroup();
        b2.add(senioryes);
        b2.add(seniorno);

        religioncb.setSelectedItem(arr[10]);
        categorycb.setSelectedItem(arr[11]);
        incomecb.setSelectedItem(arr[12]);
        if(arr[13].equals("Married"))
            b1.setSelected(married.getModel(), true);
        else if (arr[13].equals("Unmarried"))
            b1.setSelected(unmarried.getModel(), true);
        aadhaarcardtf.setText(arr[14]);
        pancardtf.setText(arr[15]);
        if(arr[16].equals("Yes"))
            b2.setSelected(senioryes.getModel(), true);
        else if(arr[16].equals("No"))
            b2.setSelected(seniorno.getModel(), true);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arr[10] = (String) religioncb.getSelectedItem();
                arr[11] = (String) categorycb.getSelectedItem();
                arr[12] = (String) incomecb.getSelectedItem();
                if(married.isSelected())
                    arr[13] = "Married";
                else if (unmarried.isSelected())
                    arr[13] = "Unmarried";
                arr[14] = aadhaarcardtf.getText();
                arr[15] = pancardtf.getText();
                if(senioryes.isSelected())
                    arr[16] = "Yes";
                else if(seniorno.isSelected())
                    arr[16] = "No";
                frame.dispose();
                new signup3(arr);
                return;
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                religioncb.setSelectedIndex(0);
                categorycb.setSelectedIndex(0);
                incomecb.setSelectedIndex(0);
                b1.clearSelection();
                aadhaarcardtf.setText("");
                pancardtf.setText("");
                b2.clearSelection();
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new signup(arr);
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
                System.gc();
                System.exit(0);
            }
        });
    }
}