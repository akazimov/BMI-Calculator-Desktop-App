import exceptions.EmptyFieldException;
import exceptions.NonPositiveValueException;
import exceptions.NonRealisticValueException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame app = new JFrame("BMI Calculator");
        JButton calculate = new JButton("Calculate");
        JButton reset = new JButton("Reset");
        JLabel heightText = new JLabel("Height (in centimeters): ");
        JLabel weightText = new JLabel("Weight (in kilograms): ");
        JTextField height = new JTextField();
        JTextField weight = new JTextField();
        JLabel rate = new JLabel();
        /* Rate Label Settings*/
        rate.setSize(500,500);
        /* Height Field Settings */
        height.setBounds(270,80,100,30);
        app.add(height);
        /* Weight Field Settings */
        weight.setBounds(270,120,100,30);
        app.add(weight);
        /* Height Label Settings*/
        heightText.setBounds(60, 80, 200, 30);
        app.add(heightText);
        /* Weight Label Settings */
        weightText.setBounds(60,120,200,30);
        app.add(weightText);
        /* Calculate Button Settings */
        calculate.setBounds(270,160,100,30);
        app.add(calculate);
        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if(height.getText().isEmpty() || weight.getText().isEmpty())
                        throw new EmptyFieldException("Please fill the blanks.");
                    double heightValue = Double.valueOf(height.getText());
                    double weightValue = Double.valueOf(weight.getText());
                    if(heightValue <= 0 || weightValue <= 0)
                        throw new NonPositiveValueException("Please enter positive values.");
                    double BMIScore = weightValue * 100 * 100 / (heightValue*heightValue);
                    if(BMIScore<=16 || BMIScore>=50)
                        throw new NonRealisticValueException("Please enter real height/weight values.");
                    String res = ("Your BMI Score is " + String.format("%.2f", BMIScore));
                    Category category = Category.categoryOfUser(BMIScore);
                    rate.setText(res+ " | " + "Category: " + category.toString());
                } catch (EmptyFieldException ex) {
                    rate.setText(ex.getMessage());
                } catch (NonPositiveValueException ex) {
                    rate.setText(ex.getMessage());
                } catch (NonRealisticValueException ex) {
                    rate.setText(ex.getMessage());
                }
                catch(Exception ex) {
                    rate.setText("Please write real values.");
                }
            }
        });
        /* Reset Button Settings */
        reset.setBounds(170, 160, 100, 30);
        app.add(reset);
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                height.setText("");
                weight.setText("");
                rate.setText("");
            }
        });
        rate.setHorizontalAlignment(JLabel.CENTER);
        rate.setVerticalAlignment(JLabel.CENTER);
        /* Frame Settings */
        app.setSize(500,500);
        app.add(rate);
        app.setLayout(null);
        app.setResizable(false);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}