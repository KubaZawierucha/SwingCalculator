package pl.zawierucha.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass extends JFrame {

    private JButton clearAll, butPlus, butMinus;
    private JButton[] numButtons;
    private JTextField calcTextField, resultTextField;
    private StringBuilder num1, num2;
    private StringBuilder calcText;
    private int result;
    private int numOfClicks = 0;
    private Sign sign;

    public static void main(String[] args) {
        new MainClass();
    }

    public MainClass() {
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Calculator");

        resultTextField = new JTextField();
        calcText = new StringBuilder();
        num1 = new StringBuilder();
        num1.append("0");
        num2 = new StringBuilder();
        num2.append("0");

        JPanel thePanel = new JPanel();
        thePanel.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.weightx = 50;
        gridBagConstraints.weighty = 100;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        calcTextField = new JTextField("0");
        Font font = new Font("Helvatica", Font.PLAIN, 18);
        calcTextField.setFont(font);
        resultTextField.setFont(font);

        numButtons = new JButton[]{
                new JButton("0"),
                new JButton("1"),
                new JButton("2"),
                new JButton("3"),
                new JButton("4"),
                new JButton("5"),
                new JButton("6"),
                new JButton("7"),
                new JButton("8"),
                new JButton("9")
        };

        ListenForButton buttonsListener = new ListenForButton();
        for (JButton button: numButtons) {
            button.addActionListener(buttonsListener);
        }

        butPlus = new JButton("+");
        butPlus.addActionListener(buttonsListener);

        butMinus = new JButton("-");
        butMinus.addActionListener(buttonsListener);

        clearAll = new JButton("C");
        clearAll.addActionListener(buttonsListener);

        thePanel.add(clearAll, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(calcTextField, gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(resultTextField, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        thePanel.add(numButtons[1], gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(numButtons[2], gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(numButtons[3], gridBagConstraints);

        gridBagConstraints.gridx = 1;
        thePanel.add(numButtons[4], gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(numButtons[5], gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(numButtons[6], gridBagConstraints);

        gridBagConstraints.gridx = 1;
        thePanel.add(numButtons[7], gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(numButtons[8], gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(numButtons[9], gridBagConstraints);

        gridBagConstraints.gridx = 1;
        thePanel.add(butPlus, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(numButtons[0], gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(butMinus, gridBagConstraints);

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearAll) {
                resetText(calcText);
                resetText(num1);
                resetText(num2);
                numOfClicks = 0;
                sign = null;
                resultTextField.setText("");
                setAllButtonsDisabledOrEnabled(true);
                butPlus.setEnabled(true);
                butMinus.setEnabled(true);

            } else if (e.getSource() == numButtons[1]) {
                buttonClickOperations(1);

            } else if (e.getSource() == numButtons[2]) {
                buttonClickOperations(2);

            } else if (e.getSource() == numButtons[3]) {
                buttonClickOperations(3);

            } else if (e.getSource() == numButtons[4]) {
                buttonClickOperations(4);

            } else if (e.getSource() == numButtons[5]) {
                buttonClickOperations(5);

            } else if (e.getSource() == numButtons[6]) {
                buttonClickOperations(6);

            } else if (e.getSource() == numButtons[7]) {
                buttonClickOperations(7);

            } else if (e.getSource() == numButtons[8]) {
                buttonClickOperations(8);

            } else if (e.getSource() == numButtons[9]) {
                buttonClickOperations(9);

            } else if (e.getSource() == numButtons[0]) {
                buttonClickOperations(0);

            } else if (e.getSource() == butPlus) {
                if (numOfClicks == 1) {
                    sign = Sign.PLUS;
                    calcText.append(" + ");
                    numOfClicks++;
                }

            } else if (e.getSource() == butMinus) {
                if (numOfClicks == 1) {
                    sign = Sign.MINUS;
                    calcText.append(" - ");
                    numOfClicks++;
                }
            }

            calcTextField.setText(calcText.toString());
            if (numOfClicks > 2) {
                resultTextField.setText(" = " + result);
            }

            numberInsertingControlling();
        }

        private void numberInsertingControlling() {
            if (num1.length() >= 5) {
                setAllButtonsDisabledOrEnabled(false);
            }

            if (numOfClicks > 1) {
                setAllButtonsDisabledOrEnabled(true);
            }

            if (num2.length() >= 5) {
                setAllButtonsDisabledOrEnabled(false);
                butMinus.setEnabled(false);
                butPlus.setEnabled(false);
            }
        }

        private void setAllButtonsDisabledOrEnabled(boolean value) {
            for (JButton button: numButtons) {
                button.setEnabled(value);
            }
        }

        private void buttonClickOperations(int num) {
            if (numOfClicks == 0) {
                calcText.setLength(0);
                calcText.append(num);
                num1.append(num);
                numOfClicks++;
            } else if (numOfClicks == 1) {
                calcText.append(num);
                num1.append(num);
            } else {
                calcText.append(num);
                num2.append(num);
                numOfClicks = 3;
                result = calculate();
            }
        }

        private void resetText(StringBuilder text) {
            text.setLength(0);
            text.append("0");
        }

        private int calculate() {
            if (sign == Sign.MINUS) {
                return Integer.parseInt(num1.toString()) - Integer.parseInt(num2.toString());
            } else {
                return Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
            }
        }
    }
}
