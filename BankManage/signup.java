package BankManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

public class signup {
    JFrame frame;
    JLabel logo, heading, name, fathername, mobile, email, dob, state, district, pincode, gender, address;
    JTextField uname, fname, mobiletf, emailtf, districttf, pincodetf, addresstf;
    JComboBox statetf;
    JButton next, reset, login;
    JRadioButton male, female;
    ButtonGroup b1;
    String[] states = {"Select state", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana",
            "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra",
            "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu",
            "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh",
            "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Lakshadweep", "Puducherry"};
    JDateChooser dobtf = new JDateChooser();
    signup(String[] arr){
        frame = new JFrame("Personal Information");

        logo = new JLabel(new ImageIcon("C:\\Users\\punee.LAPTOP-9R1CSDR\\IdeaProjects\\OnlineBankManagement\\src\\BankManage\\assest\\Bank_logo.png"));
        logo.setBounds(100, 25, 100, 70);
        frame.add(logo);

        heading = new JLabel("Personal Information");
        heading.setBounds(300, 48, 450, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(heading);

        name = new JLabel("Name");
        name.setBounds(175, 125, 200, 40);
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(name);

        fathername = new JLabel("Father's Name");
        fathername.setBounds(175, 175, 200, 40);
        fathername.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(fathername);

        dob = new JLabel("Date of Birth");
        dob.setBounds(175, 225, 200, 40);
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(dob);

        email = new JLabel("Email");
        email.setBounds(175, 275, 200, 40);
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(email);

        mobile = new JLabel("Mobile Number");
        mobile.setBounds(175, 325, 200, 40);
        mobile.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(mobile);

        state = new JLabel("State");
        state.setBounds(175, 375, 200, 40);
        state.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(state);

        district = new JLabel("District");
        district.setBounds(175, 425, 200, 40);
        district.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(district);

        address = new JLabel("Address");
        address.setBounds(175, 475, 200, 40);
        address.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(address);

        pincode = new JLabel("Pincode");
        pincode.setBounds(175, 525, 200, 40);
        pincode.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(pincode);

        gender = new JLabel("Gender");
        gender.setBounds(175, 575, 200, 40);
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(gender);

        uname = new JTextField();
        uname.setText(arr[0]);
        uname.setBounds(375, 125, 275, 30);
        uname.setFont(new Font("Arial", Font.PLAIN, 16));
        uname.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(uname);

        fname = new JTextField();
        fname.setText(arr[1]);
        fname.setBounds(375, 175, 275, 30);
        fname.setFont(new Font("Arial", Font.PLAIN, 16));
        fname.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(fname);

        dobtf = new JDateChooser();
        dobtf.setBounds(375, 225, 275, 30);
        dobtf.setFont(new Font("Arial", Font.PLAIN, 16));
        dobtf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(dobtf);

        emailtf = new JTextField();
        emailtf.setText(arr[3]);
        emailtf.setBounds(375, 275, 275, 30);
        emailtf.setFont(new Font("Arial", Font.PLAIN, 16));
        emailtf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(emailtf);

        mobiletf = new JTextField();
        mobiletf.setText(arr[4]);
        mobiletf.setBounds(375, 325, 275, 30);
        mobiletf.setFont(new Font("Arial", Font.PLAIN, 16));
        mobiletf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(mobiletf);

        statetf = new JComboBox(states);
        statetf.setSelectedItem(arr[5]);
        statetf.setBounds(375, 375, 275, 30);
        statetf.setFont(new Font("Arial", Font.BOLD, 15));
        frame.add(statetf);

        districttf = new JTextField();
        districttf.setText(arr[6]);
        districttf.setBounds(375, 425, 275, 30);
        districttf.setFont(new Font("Arial", Font.PLAIN, 16));
        districttf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(districttf);

        addresstf = new JTextField();
        addresstf.setText(arr[7]);
        addresstf.setBounds(375, 475, 275, 30);
        addresstf.setFont(new Font("Arial", Font.PLAIN, 16));
        addresstf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(addresstf);

        pincodetf = new JTextField();
        pincodetf.setText(arr[8]);
        pincodetf.setBounds(375, 525, 275, 30);
        pincodetf.setFont(new Font("Arial", Font.PLAIN, 16));
        pincodetf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(pincodetf);

        male = new JRadioButton("Male");
        male.setBounds(375, 575, 100, 30);
        male.setFont(new Font("Arial", Font.PLAIN, 16));
        male.setOpaque(false);
        frame.add(male);

        female = new JRadioButton("Female");
        female.setBounds(550, 575, 100, 30);
        female.setFont(new Font("Arial", Font.PLAIN, 16));
        female.setOpaque(false);
        frame.add(female);

        b1 = new ButtonGroup();
        b1.add(male);
        b1.add(female);

        if(arr[9].equals("Male")){
            b1.setSelected(male.getModel(), true);
        } else if(arr[9].equals("Female")) {
            b1.setSelected(female.getModel(), true);
        }

        next = new JButton("Next");
        next.setBounds(250, 625, 250, 30);
        next.setFont(new Font("Arial", Font.PLAIN, 20));
        next.setBackground(Color.green);
        frame.add(next);

        reset = new JButton("Reset");
        reset.setBounds(200, 675, 150, 30);
        reset.setFont(new Font("Arial", Font.PLAIN, 20));
        reset.setBackground(Color.green);
        frame.add(reset);

        login = new JButton("Login");
        login.setBounds(400, 675, 150, 30);
        login.setFont(new Font("Arial", Font.PLAIN, 20));
        login.setBackground(Color.green);
        frame.add(login);

        uname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
                    uname.setEditable(true);
                } else {
                    uname.setEditable(false);
                }
            }
        });

        fname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
                    fname.setEditable(true);
                } else {
                    fname.setEditable(false);
                }
            }
        });

        mobiletf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isISOControl(c)){
                    if(mobiletf.getText().length()<10){
                        mobiletf.setEditable(true);
                    } else {
                        mobiletf.setEditable(false);
                        if(Character.isISOControl(c)){
                            mobiletf.setEditable(true);
                            mobiletf.setText(mobiletf.getText().substring(0, 9));
                        }
                    }
                } else {
                    mobiletf.setEditable(false);
                }
            }
        });

        pincodetf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isISOControl(c)){
                    if(pincodetf.getText().length()<6){
                        pincodetf.setEditable(true);
                    } else {
                        pincodetf.setEditable(false);
                        if(Character.isISOControl(c)){
                            pincodetf.setEditable(true);
                            pincodetf.setText(pincodetf.getText().substring(0, 5));
                        }
                    }
                } else {
                    pincodetf.setEditable(false);
                }
            }
        });

        districttf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isISOControl(c) || Character.isWhitespace(c) || Character.isLetter(c))
                    districttf.setEditable(true);
                else
                    districttf.setEditable(false);
            }
        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(uname.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Name is required");
                    return;
                } else if (fname.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Father's Name is required");
                    return;
                } else if (dobtf.getDate().equals("")) {
                    JOptionPane.showMessageDialog(null, "Date of Birth is required");
                    return;
                } else if (emailtf.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Email is required");
                    return;
                } else if (mobiletf.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Mobile Number is required");
                    return;
                } else if (statetf.getSelectedItem().equals("Select state")) {
                    JOptionPane.showMessageDialog(null, "State is required");
                    return;
                } else if (districttf.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "District is required");
                    return;
                } else if (pincodetf.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Pincode is required");
                    return;
                } else if (!b1.isSelected(male.getModel()) && !b1.isSelected(female.getModel())) {
                    JOptionPane.showMessageDialog(null, "Gender is required");
                    return;
                } else if (!emailtf.getText().contains("@")){
                    JOptionPane.showMessageDialog(null, "Email id not valid");
                    return;
                }  else if (!emailtf.getText().contains(".com")){
                    JOptionPane.showMessageDialog(null, "Email id not valid");
                    return;
                } else if (mobiletf.getText().length() != 10){
                    JOptionPane.showMessageDialog(null, "Mobile number must be 10 digit");
                    return;
                } else if (pincodetf.getText().length() != 6){
                    JOptionPane.showMessageDialog(null, "Pincode must be 6 digit");
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                arr[0] = uname.getText();
                arr[1] = fname.getText();
                arr[2] = sdf.format(dobtf.getDate());
                arr[3] = emailtf.getText();
                arr[4] = mobiletf.getText();
                arr[5] = (String) statetf.getSelectedItem();
                arr[6] = districttf.getText();
                arr[7] = addresstf.getText();
                arr[8] = pincodetf.getText();
                if (male.isSelected())
                    arr[9] = "Male";
                else if (female.isSelected())
                    arr[9] = "Female";
                frame.dispose();
                new signup2(arr);
                return;
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uname.setText("");
                fname.setText("");
                dobtf.setDate(new Date(""));
                emailtf.setText("");
                mobiletf.setText("");
                statetf.setSelectedIndex(0);
                districttf.setText("");
                pincodetf.setText("");
                b1.clearSelection();
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Main();
            }
        });

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(800, 800);
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
}