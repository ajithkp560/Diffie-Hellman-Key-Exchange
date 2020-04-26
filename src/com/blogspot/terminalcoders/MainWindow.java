package com.blogspot.terminalcoders;
// (c) Coded By AJITH K P [ @ajithkp560 ]
// Diffie - Hellman Key Exchange Algorithm implementation in Java [TM] [Swing GUI]
// Blog: http://www.terminalcoders.blogspot.com
// ASE @ TCS Ltd.
import javax.swing.*;

public class MainWindow {
    public static void main(String[] args) {
        MainWindowGUI gui = new MainWindowGUI("Diffie - Hellman Key Exchange Algorithm");
        gui.setSize(600, 550);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setResizable(false);
        gui.setLocationRelativeTo(null);
    }
}
