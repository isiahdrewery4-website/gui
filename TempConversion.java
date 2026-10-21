import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConversion extends JFrame
{
    private JLabel tempLabel, resultLabel;
    private JTextField tempField;
    private JButton celsiusButton, fahrenheitButton;

    public TempConversion()
    {
        setTitle("Temperature Conversion");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 2));

        tempLabel = new JLabel("Enter Temperature:");
        tempField = new JTextField(10);

        celsiusButton = new JButton("To Celsius");
        fahrenheitButton = new JButton("To Fahrenheit");

        resultLabel = new JLabel("Result: ");

        pane.add(tempLabel);
        pane.add(tempField);
        pane.add(celsiusButton);
        pane.add(fahrenheitButton);
        pane.add(resultLabel);

        celsiusButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    double fahrenheit, celsius;

                    fahrenheit = Double.parseDouble(
                        tempField.getText());

                    celsius = (fahrenheit - 32) * 5.0 / 9.0;

                    resultLabel.setText(
                        String.format("Celsius: %.2f", celsius));
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(
                        null, "Enter a valid temperature.");
                }
            }
        });

        fahrenheitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    double celsius, fahrenheit;

                    celsius = Double.parseDouble(
                        tempField.getText());

                    fahrenheit = (celsius * 9.0 / 5.0) + 32;

                    resultLabel.setText(
                        String.format("Fahrenheit: %.2f", fahrenheit));
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(
                        null, "Enter a valid temperature.");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args)
    {
        TempConversion temp = new TempConversion();
    }
}
