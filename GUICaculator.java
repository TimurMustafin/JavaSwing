
package guicaculator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.text.NumberFormat;
import javax.swing.border.*;


public class GUICaculator extends JFrame {

    JButton button1;
    JLabel label1, label2, label3;
    JTextField textField1, textField2;
    JCheckBox dollarSign, commaSeparator;
    JRadioButton addNums, subtractNums, multNums, divideNums;
    JSlider howManyTimes;
    
    public static void main(String[] args) {
        new Calc();
    }
    
    public GUICaculator() {
        this.setTitle("Calculator");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel thePanel = new JPanel();
        
        button1 = new JButton("Calculate");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        
        thePanel.add(button1);
        
        label1 = new JLabel("Number1");
        thePanel.add(label1);
        textField1 = new JTextField("", 5);
        thePanel.add(textField1);
        
             
        label2 = new JLabel("Number2");
        thePanel.add(label2);
        textField2 = new JTextField("", 5);
        thePanel.add(textField2);
        
        dollarSign = new JCheckBox("Dollar");
        commaSeparator = new JCheckBox("Comma");
        thePanel.add(dollarSign);
        thePanel.add(commaSeparator, true);
        
        addNums = new JRadioButton("Add");
        subtractNums = new JRadioButton("Subtract"); 
        multNums = new JRadioButton("Mult");
        divideNums = new JRadioButton("Divide");
        
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
        
        label3 = new JLabel("How many times");
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
        this.add(operPanel);
                       
        this.setVisible(true);
        
        textField1.requestFocus();
    }
    private class ListenForButton implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    
    }
    
    private class  ListenForSlider implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            
        }
    
    }
    
}
class Calc extends JFrame {
    JButton addNums, subtractNums, multNums, divideNums;
    JTextField textField1;
    int checkNumber=0;
    int a, b;
    char checkOperation;
    Calc() {
        this.setTitle("Calculator");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridLayout());
                
        textField1 = new JTextField("", 5);
        ListenTextField lTextField = new ListenTextField();
        textField1.addActionListener(lTextField);
        
        addNums = new JButton("Add");
        ListenAdd lAdd = new ListenAdd();
        addNums.addActionListener(lAdd);
        
        subtractNums = new JButton("Subtract"); 
        multNums = new JButton("Mult");
        divideNums = new JButton("Divide");
        
        
        thePanel.add(textField1);
        thePanel.add(addNums);
        thePanel.add(subtractNums);
        thePanel.add(multNums);
        thePanel.add(divideNums);
        
        this.add(thePanel);
                               
        this.setVisible(true);
    
    }
    private class ListenTextField implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(checkNumber == 0){
                a = Integer.parseInt(textField1.getText());
                checkNumber = 1;
                textField1.setText("");
            }else if(checkNumber == 1){
                b = Integer.parseInt(textField1.getText());
                checkNumber = 0;
                textField1.setText("");
            }
            
        }
    
    }
    private class ListenAdd implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println(a+b);
            textField1.setText(Integer.toString(a+b));
        }
        
    
    }

}