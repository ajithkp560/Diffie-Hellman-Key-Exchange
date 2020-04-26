package com.blogspot.terminalcoders;
// (c) Coded By AJITH K P [ @ajithkp560 ]
// Diffie - Hellman Key Exchange Algorithm implementation in Java [TM] [Swing GUI]
// Blog: http://www.terminalcoders.blogspot.com
// ASE @ TCS Ltd.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class MainWindowGUI extends JFrame {
    JLabel pubValsLbl, privValsLbl, keyValsLbl, pLbl, gLbl, aliceSecLbl, bobSecLbl, msgValsLbl, aliceMsgLbl, bobMsgLbl, aliceKeyLbl, bobKeyLbl;
    JTextField pTxt, gTxt, aliceSecTxt, bobSecTxt, aliceMsgTxt, bobMsgTxt, aliceKeyTxt, bobKeyTxt;
    JPanel mainPanel;
    GridBagConstraints gbc;
    JButton genPubVals, getPriVals, genMsgs, genKeys;
    DiffieHellman dh = new DiffieHellman();
    BigInteger aliceSecVal, bobSecVal, aliceMsgVal, bobMsgVal;

    public MainWindowGUI(String title){
        super(title);
        this.setLayout(new BorderLayout());

        //Init. Labels, Text fields, Panels, GridBagConstraints and Buttons, etc.
        this.pubValsLbl = new JLabel("--- Public Values ---", SwingConstants.CENTER);
        this.privValsLbl = new JLabel("--- Private Values ---", SwingConstants.CENTER);
        this.msgValsLbl = new JLabel("--- Message Values ---", SwingConstants.CENTER);
        this.keyValsLbl = new JLabel("--- Calculated Keys ---", SwingConstants.CENTER);

        this.pLbl = new JLabel("Value of \"p\": ", SwingConstants.RIGHT);
        this.gLbl = new JLabel("Value of \"g\": ", SwingConstants.RIGHT);
        this.pTxt = new JTextField();
        this.gTxt = new JTextField();
        this.pTxt.setEditable(false);
        this.gTxt.setEditable(false);

        this.aliceSecLbl = new JLabel("Alice's Secret Number: ", SwingConstants.RIGHT);
        this.bobSecLbl = new JLabel("Bob's Secret Number: ", SwingConstants.RIGHT);
        this.aliceSecTxt = new JTextField();
        this.bobSecTxt = new JTextField();

        this.aliceMsgLbl = new JLabel("Alice's Message: ", SwingConstants.RIGHT);
        this.bobMsgLbl = new JLabel("Bob's Message: ", SwingConstants.RIGHT);
        this.aliceMsgTxt  =new JTextField();
        this.bobMsgTxt = new JTextField();
        this.aliceMsgTxt.setEditable(false);
        this.bobMsgTxt.setEditable(false);

        this.aliceKeyLbl = new JLabel("Key Calculated by Alice: ", SwingConstants.RIGHT);
        this.bobKeyLbl = new JLabel("Key Calculated by Bob", SwingConstants.RIGHT);
        this.aliceKeyTxt = new JTextField();
        this.bobKeyTxt = new JTextField();
        this.aliceKeyTxt.setEditable(false);
        this.bobKeyTxt.setEditable(false);

        this.mainPanel = new JPanel(new GridBagLayout());

        this.gbc = new GridBagConstraints();

        this.genPubVals = new JButton("Gen. Pub. Vals");
        this.getPriVals = new JButton("Sub. Priv. Vals");
        this.genMsgs = new JButton("Gen. Msg.s");
        this.genKeys = new JButton("Gen. Keys");

        this.gbc.insets = new Insets(5, 5, 5, 5);
        this.gbc.fill = GridBagConstraints.HORIZONTAL;
        this.gbc.anchor = GridBagConstraints.CENTER;

        this.gbc.gridwidth = 2;
        this.gbc.gridx = 0;
        this.gbc.gridy = 0;
        this.mainPanel.add(this.pubValsLbl, this.gbc);

        this.gbc.gridwidth = 1;

        this.gbc.gridx = 0;
        this.gbc.gridy = 1;
        this.gbc.ipadx = 5;
        this.mainPanel.add(this.pLbl, this.gbc);

        this.gbc.gridx = 1;
        this.gbc.gridy = 1;
        this.gbc.ipadx = 200;
        this.mainPanel.add(this.pTxt, this.gbc);

        this.gbc.gridx = 0;
        this.gbc.gridy = 2;
        this.gbc.ipadx = 5;
        this.mainPanel.add(this.gLbl, this.gbc);

        this.gbc.gridx = 1;
        this.gbc.gridy = 2;
        this.gbc.ipadx = 200;
        this.mainPanel.add(this.gTxt, this.gbc);

        this.gbc.gridx = 1;
        this.gbc.gridy = 3;
        this.gbc.ipadx = 200;
        this.mainPanel.add(this.genPubVals, this.gbc);

        this.gbc.gridwidth = 2;
        this.gbc.gridx = 0;
        this.gbc.gridy = 4;
        this.mainPanel.add(this.privValsLbl, gbc);

        this.gbc.gridwidth = 1;
        this.gbc.gridx = 0;
        this.gbc.gridy = 5;
        this.gbc.ipadx = 5;
        this.mainPanel.add(this.aliceSecLbl, this.gbc);

        this.gbc.gridx = 1;
        this.gbc.gridy = 5;
        this.gbc.ipadx = 200;
        this.mainPanel.add(this.aliceSecTxt, this.gbc);

        this.gbc.gridx = 0;
        this.gbc.gridy = 6;
        this.gbc.ipadx = 5;
        this.mainPanel.add(this.bobSecLbl, this.gbc);

        this.gbc.gridx = 1;
        this.gbc.gridy = 6;
        this.gbc.ipadx = 200;
        this.mainPanel.add(this.bobSecTxt, this.gbc);

        this.gbc.gridx = 1;
        this.gbc.gridy = 7;
        this.gbc.ipadx = 5;
        this.mainPanel.add(this.getPriVals, this.gbc);

        this.gbc.gridwidth = 2;
        this.gbc.gridx = 0;
        this.gbc.gridy = 8;
        this.mainPanel.add(this.msgValsLbl, this.gbc);

        this.gbc.gridwidth = 1;
        this.gbc.gridx = 0;
        this.gbc.gridy = 9;
        this.gbc.ipadx = 5;
        this.mainPanel.add(this.aliceMsgLbl, this.gbc);

        this.gbc.gridx = 1;
        this.gbc.gridy = 9;
        this.gbc.ipadx = 200;
        this.mainPanel.add(this.aliceMsgTxt, this.gbc);

        this.gbc.gridx = 0;
        this.gbc.gridy = 10;
        this.gbc.ipadx = 5;
        this.mainPanel.add(this.bobMsgLbl, this.gbc);

        this.gbc.gridx = 1;
        this.gbc.gridy = 10;
        this.gbc.ipadx = 200;
        this.mainPanel.add(this.bobMsgTxt, this.gbc);

        this.gbc.gridx = 1;
        this.gbc.gridy = 11;
        this.gbc.ipadx = 200;
        this.mainPanel.add(this.genMsgs, this.gbc);

        this.gbc.gridwidth= 2;
        this.gbc.gridx = 0;
        this.gbc.gridy = 12;
        this.mainPanel.add(this.keyValsLbl, this.gbc);

        this.gbc.gridwidth = 1;
        this.gbc.gridx = 0;
        this.gbc.gridy = 13;
        this.gbc.ipadx = 5;
        this.mainPanel.add(this.aliceKeyLbl, this.gbc);

        this.gbc.gridx = 1;
        this.gbc.gridy = 13;
        this.gbc.ipadx = 200;
        this.mainPanel.add(this.aliceKeyTxt, this.gbc);

        this.gbc.gridx = 0;
        this.gbc.gridy = 14;
        this.gbc.ipadx = 5;
        this.mainPanel.add(this.bobKeyLbl, this.gbc);

        this.gbc.gridx = 1;
        this.gbc.gridy = 14;
        this.gbc.ipadx = 200;
        this.mainPanel.add(this.bobKeyTxt, this.gbc);

        this.gbc.gridx = 1;
        this.gbc.gridy = 15;
        this.gbc.ipadx = 200;
        this.mainPanel.add(this.genKeys, this.gbc);

        this.add(mainPanel, BorderLayout.CENTER);

        this.genPubVals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePublicValues();
                JOptionPane.showMessageDialog(MainWindowGUI.this, "Fill the Secret Values of Alice and Bob and Submit", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        this.getPriVals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getPrivateValues();
            }
        });

        this.genMsgs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateMessages();
                JOptionPane.showMessageDialog(MainWindowGUI.this, "Click the \"Gen. Keys\" Button to Calculate the Keys on Both ends", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        this.genKeys.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateKeys();
                JOptionPane.showMessageDialog(MainWindowGUI.this, "The key is generated at both ends", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private void generatePublicValues(){
        dh.genPrimeAndPrimitiveRoot();
        pTxt.setText(dh.getP().toString());
        gTxt.setText(dh.getG().toString());
    }

    private void getPrivateValues(){
        try {
            aliceSecVal = BigInteger.valueOf(Long.parseLong(aliceSecTxt.getText()));
            bobSecVal = BigInteger.valueOf(Long.parseLong(bobSecTxt.getText()));
            JOptionPane.showMessageDialog(MainWindowGUI.this, "Click the \"Gen.Msg.s \" Button for generate Messages of Alice and Bob", "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Enter Valid Number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generateMessages(){
        aliceMsgVal = dh.getAliceMessage(aliceSecVal);
        bobMsgVal = dh.getBobMessage(bobSecVal);
        aliceMsgTxt.setText(aliceMsgVal.toString());
        bobMsgTxt.setText(bobMsgVal.toString());
    }

    private void generateKeys(){
        BigInteger aliceCalcKey = dh.aliceCalculationOfKey(bobMsgVal, aliceSecVal);
        BigInteger bobCalcKey = dh.bobCalculationOfKey(aliceMsgVal, bobSecVal);
        aliceKeyTxt.setText(aliceCalcKey.toString());
        bobKeyTxt.setText(bobCalcKey.toString());
    }
}
