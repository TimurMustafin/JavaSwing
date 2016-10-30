
package swingcalculator;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import javax.swing.border.*;

public class SwingCalculator extends JFrame {
    JButton button1;
    JLabel label1, label2, label3;
    JTextField textField1, textField2;
    JCheckBox dollatSign, commaSeparation;
    JRadioButton addNums, subtractNums, multNums, divideNums;
    JSlider howManyTimes;
    double num1, num2, totalCalc;

   
    public static void main(String[] args) {
       
    }
    public SwingCalculator(){
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Calc");
        
        JPanel thePanel = new JPanel();
        
        button1 = new JButton("Calculate");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        
        label1 = new JLabel("Number1");
        thePanel.add(label1);
        
        textField1 = new JTextField("", 5);
        thePanel.add(textField1);
        
        label2 = new JLabel("Number2");
        thePanel.add(label2);
        
        textField2 = new JTextField("", 5);
        thePanel.add(textField2);
        
        dollatSign = new JCheckBox("Dollars");
        commaSeparation = new JCheckBox("Commas");
        thePanel.add(dollatSign);
        thePanel.add(commaSeparation, true);
        
        addNums = new JRadioButton("Add");
        subtractNums = new JRadioButton("Sub");
        multNums = new JRadioButton("Mult");
        divideNums = new JRadioButton("Div");
        
        ButtonGroup operation = new ButtonGroup();
        operation.add(addNums);
        operation.add(subtractNums);
        operation.add(multNums);
        operation.add(divideNums);
        
        JPanel operPanel = new JPanel();
        Border operBorder = BorderFactory.createTitledBorder("Operation");
        operPanel.setBorder(operBorder);
        
        operPanel.add(addNums);
        operPanel.add(subtractNums);
        operPanel.add(multNums);
        operPanel.add(divideNums);
        
        addNums.setSelected(true);
        
        thePanel.add(operPanel);
        
        label3 = new JLabel("How many times?");
        thePanel.add(label3);
        
        howManyTimes = new JSlider(0, 99, 1);
        howManyTimes.setMinorTickSpacing(1);
        howManyTimes.setMajorTickSpacing(10);
        howManyTimes.setPaintTicks(true);
        howManyTimes.setPaintLabels(true);
        ListenForSlider lForSlider = new ListenForSlider();
        howManyTimes.addChangeListener(lForSlider);
        thePanel.add(howManyTimes);
        
        this.add(thePanel);
        
        this.setVisible(true);
         
        textField1.requestFocus();
         
        
        
        
    }
    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             if(e.getSource() == button1){
                 try{
                     num1 = Double.parseDouble(textField1.getText());
                     num2 = Double.parseDouble(textField1.getText());
                 }catch(NumberFormatException excep){
                   JOptionPane.showMessageDialog(SwingCalculator.this, "Please, enter right info",
                           "Error",JOptionPane.ERROR_MESSAGE);
                   System.exit(0);
                 
                 };                 
             }
        }
        
    
    
    }
    
}
