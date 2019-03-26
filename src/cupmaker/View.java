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
    
    private JLabel LabelTopWidth, LabelBottomWidth, LabelHeight, LabelCalculation, LabelVolume;
    private JTextField TextFieldTopWidth, TextFieldBottomWidth, TextFieldHeight, TextFieldVolume;
    private JButton ButtonCalculate, ButtonReset, ButtonInfo;
    
    public View(){
        setTitle("Cupmaker");
        setSize(275,500);
        setLayout(new FlowLayout());
        setResizable(true);
        
        LabelTopWidth = new JLabel("Breedte bovenkant in mm:");
        LabelBottomWidth = new JLabel("Breedte onderkant in mm:");
        LabelHeight = new JLabel("Hoogte in mm:");
        LabelVolume = new JLabel("Inhoud in cc:");
        
        TextFieldTopWidth = new JTextField(5);
        TextFieldBottomWidth = new JTextField(5);
        TextFieldHeight = new JTextField(5);
        TextFieldVolume = new JTextField(5);
        
        ButtonCalculate = new JButton("Toevoegen");
        ButtonCalculate.addActionListener(this);
        
        ButtonReset = new JButton("Reset");
        ButtonReset.addActionListener(this);
        
        ButtonInfo = new JButton("Statestieken");
        ButtonInfo.addActionListener(this);
                
        add(LabelTopWidth);
        add(TextFieldTopWidth);
        add(LabelBottomWidth);
        add(TextFieldBottomWidth);
        add(LabelHeight);
        add(TextFieldHeight);
        add(LabelVolume);
        add(TextFieldVolume);
        
        add(ButtonCalculate);
        add(ButtonReset);
        add(ButtonInfo);
        
        cupPanel = new Cup(300, 400);
        add(cupPanel, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ButtonCalculate){
            int wt = 0;
            int wb = 0;
            int h = 0;
            int v = 0;
            
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
                if(!TextFieldHeight.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "De hoogte moet een cijfer zijn.");
                    return;
                } 
            }
            
            try {
                v = parseInt(TextFieldVolume.getText());
            } catch (NumberFormatException ex) {
                if(!TextFieldVolume.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "Het volume moet een cijfer zijn.");
                    return;
                } 
            }
            
            if(h > 0) {
                cupPanel.addToCup(wt, wb, h);
            } else if(v > 0){
                cupPanel.addToCupByVolume(wt, wb, v);
            } else {
                JOptionPane.showMessageDialog(this, "Stel of het volume of de hoogte in als cijfer.");
                return;
            }
            
            TextFieldTopWidth.setText("");
            TextFieldBottomWidth.setText("");
            TextFieldHeight.setText("");
            TextFieldVolume.setText("");
        }
        if (e.getSource() == ButtonReset){
            cupPanel.reset();
            TextFieldTopWidth.setText("");
            TextFieldBottomWidth.setText("");
            TextFieldHeight.setText("");
            TextFieldVolume.setText("");
        }
        if (e.getSource() == ButtonInfo){
            JOptionPane.showMessageDialog(this, "Onderdelen van boven naar beneden:\n" + cupPanel.toString());
        }
        repaint();
    }
    
}
