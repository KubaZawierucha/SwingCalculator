package pl.zawierucha.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass extends JFrame {

    private JButton but1, but2, but3, but4, but5, but6, but7, but8, but9, but0, butPlus, butMinus, clearAll;
    private JTextField textResult;
    private StringBuilder num1, num2;
    private StringBuilder result;
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

        result = new StringBuilder();
        num1 = new StringBuilder();
        num2 = new StringBuilder();

        JPanel thePanel = new JPanel();
        //thePanel.setLayout(new GridLayout(0, 3, 2, 2));
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

        textResult = new JTextField("0");
        Font font = new Font("Helvatica", Font.PLAIN, 18);
        textResult.setFont(font);

        but1 = new JButton("1");
        ListenForButton listenForButtonBut1 = new ListenForButton();
        but1.addActionListener(listenForButtonBut1);

        but2 = new JButton("2");
        ListenForButton listenForButtonBut2 = new ListenForButton();
        but2.addActionListener(listenForButtonBut2);

        but3 = new JButton("3");
        ListenForButton listenForButtonBut3 = new ListenForButton();
        but3.addActionListener(listenForButtonBut3);

        but4 = new JButton("4");
        ListenForButton listenForButtonBut4 = new ListenForButton();
        but4.addActionListener(listenForButtonBut4);

        but5 = new JButton("5");
        ListenForButton listenForButtonBut5 = new ListenForButton();
        but5.addActionListener(listenForButtonBut5);

        but6 = new JButton("6");
        ListenForButton listenForButtonBut6 = new ListenForButton();
        but6.addActionListener(listenForButtonBut6);

        but7 = new JButton("7");
        ListenForButton listenForButtonBut7 = new ListenForButton();
        but7.addActionListener(listenForButtonBut7);

        but8 = new JButton("8");
        ListenForButton listenForButtonBut8 = new ListenForButton();
        but8.addActionListener(listenForButtonBut8);

        but9 = new JButton("9");
        ListenForButton listenForButtonBut9 = new ListenForButton();
        but9.addActionListener(listenForButtonBut9);

        butPlus = new JButton("+");
        ListenForButton listenForButtonPlus = new ListenForButton();
        butPlus.addActionListener(listenForButtonPlus);

        but0 = new JButton("0");
        ListenForButton listenForButtonBut0 = new ListenForButton();
        but0.addActionListener(listenForButtonBut0);

        butMinus = new JButton("-");
        ListenForButton listenForButtonMinus = new ListenForButton();
        butMinus.addActionListener(listenForButtonMinus);

        clearAll = new JButton("C");
        ListenForButton listenForButtonClearAll = new ListenForButton();
        clearAll.addActionListener(listenForButtonClearAll);

        thePanel.add(clearAll, gridBagConstraints);

        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridx = 5;
        thePanel.add(textResult, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        thePanel.add(but1, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(but2, gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(but3, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        thePanel.add(but4, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(but5, gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(but6, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        thePanel.add(but7, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(but8, gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(but9, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        thePanel.add(butPlus, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        thePanel.add(but0, gridBagConstraints);

        gridBagConstraints.gridx = 9;
        thePanel.add(butMinus, gridBagConstraints);

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener {

        // TODO: 11.09.2019
        // Too many digits possibility!

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearAll) {
                result.setLength(0);
                result.append("0");
                num1.setLength(0);
                num2.setLength(0);
                numOfClicks = 0;
                sign = null;
            } else if (e.getSource() == but1) {
                if (numOfClicks == 0) {
                    result.setLength(0);
                    result.append("1");
                    num1.append("1");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    result.append("1");
                    num1.append("1");
                } else if (numOfClicks == 2) {

                    // TODO: 11.09.2019
                    // Result printing.

                    if (sign == Sign.PLUS) {
                        result.append("1");
                    }
                    num2.append("1");
                }
            } else if (e.getSource() == but2) {
                if (numOfClicks == 0) {
                    result.setLength(0);
                    result.append("2");
                    num1.append("2");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    result.append("2");
                    num1.append("2");
                }
            } else if (e.getSource() == but3) {
                if (numOfClicks == 0) {
                    result.setLength(0);
                    result.append("3");
                    num1.append("3");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    result.append("3");
                    num1.append("3");
                }
            } else if (e.getSource() == but4) {
                if (numOfClicks == 0) {
                    result.setLength(0);
                    result.append("4");
                    num1.append("4");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    result.append("4");
                    num1.append("4");
                }
            } else if (e.getSource() == but5) {
                if (numOfClicks == 0) {
                    result.setLength(0);
                    result.append("5");
                    num1.append("5");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    result.append("5");
                    num1.append("5");
                }
            } else if (e.getSource() == but6) {
                if (numOfClicks == 0) {
                    result.setLength(0);
                    result.append("6");
                    num1.append("6");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    result.append("6");
                    num1.append("6");
                }
            } else if (e.getSource() == but7) {
                if (numOfClicks == 0) {
                    result.setLength(0);
                    result.append("7");
                    num1.append("7");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    result.append("7");
                    num1.append("7");
                }
            } else if (e.getSource() == but8) {
                if (numOfClicks == 0) {
                    result.setLength(0);
                    result.append("8");
                    num1.append("8");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    result.append("8");
                    num1.append("8");
                }
            } else if (e.getSource() == but9) {
                if (numOfClicks == 0) {
                    result.setLength(0);
                    result.append("9");
                    num1.append("9");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    result.append("9");
                    num1.append("9");
                }
            } else if (e.getSource() == but0) {
                if (numOfClicks == 0) {
                    result.setLength(0);
                    result.append("0");
                    num1.append("0");
                    numOfClicks++;
                } else if (numOfClicks == 1) {
                    result.append("0");
                    num1.append("0");
                }
            } else if (e.getSource() == butPlus) {
                if (numOfClicks == 1) {
                    sign = Sign.PLUS;
                    result.append(" + ");
                    numOfClicks++;
                }
            } else if (e.getSource() == butMinus) {
                if (numOfClicks == 1) {
                    sign = Sign.MINUS;
                    result.append(" - ");
                    numOfClicks++;
                }
            }

            textResult.setText(result.toString());
            System.out.println(Integer.parseInt(num1.toString()));
            System.out.println(Integer.parseInt(num2.toString()));
        }
    }
}
