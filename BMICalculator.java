import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMICalculator extends JFrame
{
    private JLabel weightLabel, heightLabel;
    private JLabel bmiLabel, categoryLabel;
    private JTextField weightField, heightField;
    private JButton calculateButton;

    public BMICalculator()
    {
        setTitle("BMI Calculator");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(5, 2));

        weightLabel = new JLabel("Weight (kg):");
        weightField = new JTextField(10);

        heightLabel = new JLabel("Height (m):");
        heightField = new JTextField(10);

        calculateButton = new JButton("Calculate");

        bmiLabel = new JLabel("BMI: ");
        categoryLabel = new JLabel("Category: ");

        pane.add(weightLabel);
        pane.add(weightField);
        pane.add(heightLabel);
        pane.add(heightField);
        pane.add(calculateButton);
        pane.add(new JLabel(""));
        pane.add(bmiLabel);
        pane.add(categoryLabel);

        calculateButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                double weight, height, bmi;
                String category;

                try
                {
                    weight = Double.parseDouble(
                        weightField.getText());

                    height = Double.parseDouble(
                        heightField.getText());

                    if (weight <= 0 || height <= 0)
                    {
                        JOptionPane.showMessageDialog(
                            null, "Enter positive numbers.");
                        return;
                    }

                    bmi = weight / (height * height);

                    if (bmi < 18.5)
                        category = "Underweight";
                    else if (bmi < 25)
                        category = "Healthy weight";
                    else if (bmi < 30)
                        category = "Overweight";
                    else
                        category = "Obesity range";

                    bmiLabel.setText(
                        String.format("BMI: %.2f", bmi));

                    categoryLabel.setText(
                        "Category: " + category);
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(
                        null, "Enter valid numbers.");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args)
    {
        BMICalculator bmi = new BMICalculator();
    }
}
