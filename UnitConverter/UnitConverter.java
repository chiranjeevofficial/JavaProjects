package UnitConverter;
import javax.swing.*;
import java.awt.*;

public class UnitConverter extends JFrame{
    private JPanel mainPanel;
    private JTextField inputTestField;
    private JComboBox<String> fromComboBox;
    private JComboBox<String> toComboBox;
    private JButton convertButton;
    private JLabel convertLabel;
    private JLabel toLabel;
    private JLabel convertedLabel;
    private JLabel resultLabel;

    public void initComponents(){ //component position
        mainPanel.setLayout(null);
        convertLabel.setBounds(78,10,50,25);
        toLabel.setBounds(100,43,30,25);
        convertedLabel.setBounds(30,73,150,25);
        inputTestField.setBounds(143,10,150,25);
        toComboBox.setBounds(143,43,150,25);
        resultLabel.setBounds(143,73,250,25);
        fromComboBox.setBounds(300,10,150,25);
        convertButton.setBounds(250,100,100,30);
        {
            mainPanel.add(inputTestField);
            mainPanel.add(fromComboBox);
            mainPanel.add(toComboBox);
            mainPanel.add(convertButton);
            mainPanel.add(convertedLabel);
            mainPanel.add(convertLabel);
            mainPanel.add(toLabel);
            mainPanel.add(resultLabel);
        } //components added to mainPanel
    }

    public UnitConverter(){ //default constructor
        setSize(500,200);
        setVisible(true);
        setContentPane(mainPanel);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        fromComboBox.addItem("Kilometer");
        fromComboBox.addItem("Kilogram");
        fromComboBox.addItem("Centimeter");
        fromComboBox.addItem("Liter");
        toComboBox.addItem("Meter");
        toComboBox.addItem("Gram");
        toComboBox.addItem("Milli meter");
        toComboBox.addItem("Milli liter");

        convertButton.addActionListener(e -> {
            int fromSelect = fromComboBox.getSelectedIndex();
            int toSelect = toComboBox.getSelectedIndex();
            if (fromSelect != toSelect) {
                resultLabel.setForeground(Color.RED);
                resultLabel.setText("Incompatible Conversion");
            }
            else {
                resultLabel.setForeground(Color.BLACK);
                resultLabel.setText("");
                int input = Integer.parseInt(inputTestField.getText());
                switch (toSelect) {
                    case 0 -> resultLabel.setText(input * 1000 + " Meter");
                    case 1 -> resultLabel.setText(input * 1000 + " Gram");
                    case 2 -> resultLabel.setText(input * 10 + " Milli meter");
                    case 3 -> resultLabel.setText(input * 10 + " Milli liter");
                }
            }
        });
    }

    public static void main(String[] args) {
        new UnitConverter();
    }
}
