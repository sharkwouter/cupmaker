/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupmaker;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author wouter
 */
public class View extends JFrame implements ActionListener {

    private Cup cupPanel;
    
    private JLabel LabelTopWidth, LabelBottomWidth, LabelHeight, LabelCalculation;
    private JTextField TextFieldTopWidth, TextFieldBottomWidth, TextFieldHeight;
    private JButton ButtonCalculate, ButtonReset;
    
    public View(){
        setTitle("Cupmaker");
        setSize(275,500);
        setLayout(new FlowLayout());
        setResizable(false);
        
        LabelTopWidth = new JLabel("Breedte bovenkant in mm:");
        LabelBottomWidth = new JLabel("Breedte onderkant in mm:");
        LabelHeight = new JLabel("Hoogte in mm:");
        
        TextFieldTopWidth = new JTextField(5);
        TextFieldBottomWidth = new JTextField(5);
        TextFieldHeight = new JTextField(5);
        
        ButtonCalculate = new JButton("Bereken");
        ButtonCalculate.addActionListener(this);
        
        ButtonReset = new JButton("Reset");
        ButtonReset.addActionListener(this);
        
        LabelCalculation = new JLabel("0 cc");
        
        add(LabelTopWidth);
        add(TextFieldTopWidth);
        add(LabelBottomWidth);
        add(TextFieldBottomWidth);
        add(LabelHeight);
        add(TextFieldHeight);
        
        add(ButtonCalculate);
        add(ButtonReset);
        add(LabelCalculation);
        
        cupPanel = new Cup(300, 400);
        add(cupPanel, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ButtonCalculate){
            int wt, wb, h = 0;
            
            try {
                wt = parseInt(TextFieldTopWidth.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "De breedte boven moet een cijfer zijn.");
                return;
            }
            
            try {
                wb = parseInt(TextFieldBottomWidth.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "De breedte onder moet een cijfer zijn.");
                return;
            }
            
            try {
                h = parseInt(TextFieldHeight.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "De hoogte moet een cijfer zijn.");
                return;
            }
            
            cupPanel.addToCup(wt, wb, h);
            TextFieldTopWidth.setText("");
            TextFieldBottomWidth.setText("");
            TextFieldHeight.setText("");
            
            LabelCalculation.setText(Math.round(cupPanel.getVolume()) + " cc");
        }
        if (e.getSource() == ButtonReset){
            cupPanel.reset();
            TextFieldTopWidth.setText("");
            TextFieldBottomWidth.setText("");
            TextFieldHeight.setText("");
            LabelCalculation.setText("0 cc");
        }
        repaint();
    }
    
}
