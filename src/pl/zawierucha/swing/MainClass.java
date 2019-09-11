package pl.zawierucha.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass extends JFrame {

    private JButton clearAll, butPlus, butMinus;
    private JButton[] numButtons;// = {but1, but2, but3, but4, but5, but6, but7, but8, but9, but0, butPlus, butMinus}
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
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 50;
        gridBagConstraints.weighty = 100;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
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

//        but1 = new JButton("1");
//        ListenForButton listenForButtonBut1 = new ListenForButton();
//        but1.addActionListener(listenForButtonBut1);
//
//        but2 = new JButton("2");
//        ListenForButton listenForButtonBut2 = new ListenForButton();
//        but2.addActionListener(listenForButtonBut1);
//
//        but3 = new JButton("3");
//        ListenForButton listenForButtonBut3 = new ListenForButton();
//        but3.addActionListener(listenForButtonBut3);
//
//        but4 = new JButton("4");
//        ListenForButton listenForButtonBut4 = new ListenForButton();
//        but4.addActionListener(listenForButtonBut4);
//
//        but5 = new JButton("5");
//        ListenForButton listenForButtonBut5 = new ListenForButton();
//        but5.addActionListener(listenForButtonBut5);
//
//        but6 = new JButton("6");
//        ListenForButton listenForButtonBut6 = new ListenForButton();
//        but6.addActionListener(listenForButtonBut6);
//
//        but7 = new JButton("7");
//        ListenForButton listenForButtonBut7 = new ListenForButton();
//        but7.addActionListener(listenForButtonBut7);
//
//        but8 = new JButton("8");
//        ListenForButton listenForButtonBut8 = new ListenForButton();
//        but8.addActionListener(listenForButtonBut8);
//
//        but9 = new JButton("9");
//        ListenForButton listenForButtonBut9 = new ListenForButton();
//        but9.addActionListener(listenForButtonBut9);

        butPlus = new JButton("+");
        ListenForButton listenForButtonPlus = new ListenForButton();
        butPlus.addActionListener(listenForButtonPlus);

//        but0 = new JButton("0");
//        ListenForButton listenForButtonBut0 = new ListenForButton();
//        but0.addActionListener(listenForButtonBut0);

        butMinus = new JButton("-");
        ListenForButton listenForButtonMinus = new ListenForButton();
        butMinus.addActionListener(listenForButtonMinus);

        clearAll = new JButton("C");
        ListenForButton listenForButtonClearAll = new ListenForButton();
        clearAll.addActionListener(listenForButtonClearAll);

        thePanel.add(clearAll, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(calcTextField, gridBagConstraints);

        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.gridx = 9;
        thePanel.add(resultTextField, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        thePanel.add(numButtons[1], gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(numButtons[2], gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(numButtons[3], gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        thePanel.add(numButtons[4], gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(numButtons[5], gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(numButtons[6], gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        thePanel.add(numButtons[7], gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(numButtons[8], gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(numButtons[9], gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        thePanel.add(butPlus, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(numButtons[0], gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(butMinus, gridBagConstraints);

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener {

        public int calculate() {
            if (sign == Sign.MINUS) {
                return Integer.parseInt(num1.toString()) - Integer.parseInt(num2.toString());
            } else {
                return Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
            }
        }

        // TODO: 11.09.2019
        // Too many digits possibility!

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearAll) {
                resetText(calcText);
                resetText(num1);
                resetText(num2);
                numOfClicks = 0;
                sign = null;
                resultTextField.setText("");
                for (JButton button: numButtons) {
                    button.setEnabled(true);
                }
                butPlus.setEnabled(true);
                butMinus.setEnabled(true);

            } else if (e.getSource() == numButtons[1]) {
                if (numOfClicks == 0) {
                    calcText.setLength(0);
                    calcText.append("1");
                    num1.append("1");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    calcText.append("1");
                    num1.append("1");
                } else {
                    calcText.append("1");
                    num2.append("1");
                    numOfClicks = 3;
                    result = calculate();
                }

            } else if (e.getSource() == numButtons[2]) {
                if (numOfClicks == 0) {
                    calcText.setLength(0);
                    calcText.append("2");
                    num1.append("2");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    calcText.append("2");
                    num1.append("2");
                } else {
                    calcText.append("2");
                    num2.append("2");
                    numOfClicks = 3;
                    result = calculate();
                }

            } else if (e.getSource() == numButtons[3]) {
                if (numOfClicks == 0) {
                    calcText.setLength(0);
                    calcText.append("3");
                    num1.append("3");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    calcText.append("3");
                    num1.append("3");
                } else {
                    calcText.append("3");
                    num2.append("3");
                    numOfClicks = 3;
                    result = calculate();
                }

            } else if (e.getSource() == numButtons[4]) {
                if (numOfClicks == 0) {
                    calcText.setLength(0);
                    calcText.append("4");
                    num1.append("4");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    calcText.append("4");
                    num1.append("4");
                } else {
                    calcText.append("4");
                    num2.append("4");
                    numOfClicks = 3;
                    result = calculate();
                }

            } else if (e.getSource() == numButtons[5]) {
                if (numOfClicks == 0) {
                    calcText.setLength(0);
                    calcText.append("5");
                    num1.append("5");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    calcText.append("5");
                    num1.append("5");
                } else {
                    calcText.append("5");
                    num2.append("5");
                    numOfClicks = 3;
                    result = calculate();
                }

            } else if (e.getSource() == numButtons[6]) {
                if (numOfClicks == 0) {
                    calcText.setLength(0);
                    calcText.append("6");
                    num1.append("6");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    calcText.append("6");
                    num1.append("6");
                } else {
                    calcText.append("6");
                    num2.append("6");
                    numOfClicks = 3;
                    result = calculate();
                }

            } else if (e.getSource() == numButtons[7]) {
                if (numOfClicks == 0) {
                    calcText.setLength(0);
                    calcText.append("7");
                    num1.append("7");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    calcText.append("7");
                    num1.append("7");
                } else {
                    calcText.append("7");
                    num2.append("7");
                    numOfClicks = 3;
                    result = calculate();
                }

            } else if (e.getSource() == numButtons[8]) {
                if (numOfClicks == 0) {
                    calcText.setLength(0);
                    calcText.append("8");
                    num1.append("8");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    calcText.append("8");
                    num1.append("8");
                } else {
                    calcText.append("8");
                    num2.append("8");
                    numOfClicks = 3;
                    result = calculate();
                }

            } else if (e.getSource() == numButtons[9]) {
                if (numOfClicks == 0) {
                    calcText.setLength(0);
                    calcText.append("9");
                    num1.append("9");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    calcText.append("9");
                    num1.append("9");
                } else {
                    calcText.append("9");
                    num2.append("9");
                    numOfClicks = 3;
                    result = calculate();
                }

            } else if (e.getSource() == numButtons[0]) {
                if (numOfClicks == 0) {
                    calcText.setLength(0);
                    calcText.append("0");
                    num1.append("0");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    calcText.append("0");
                    num1.append("0");
                } else {
                    calcText.append("0");
                    num2.append("0");
                    numOfClicks = 3;
                    result = calculate();
                }

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

            if (num1.length() >= 5) {
                for (JButton button: numButtons) {
                    button.setEnabled(false);
                }
            }

            if (numOfClicks > 1) {
                for (JButton button: numButtons) {
                    button.setEnabled(true);
                }
            }

            if (num2.length() >= 5) {
                for (JButton button: numButtons) {
                    button.setEnabled(false);
                }
                butMinus.setEnabled(false);
                butPlus.setEnabled(false);
            }

            System.out.println(num1.length());
        }

        private void resetText(StringBuilder text) {
            text.setLength(0);
            text.append("0");
        }
    }
}
