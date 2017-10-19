/*
This code is a Graphics implemented User Interface calculator that functions assuming legal mathematical input.

EXTRA FEATURES (Bonus for this assignment):
1) input from keyboard enabled (assuming the input has whitespace between each token, input by click takes care of all whitespace)
2) negative numbers being entered (+/- button) (again if inputting by keyboard, whitespace between each token is required, but not negative numbers:
eg: -5 is a negative number therefore no white space before the 5. This is very useful and enables the user to edit the input.
3)
Notes:
One JtextField for this code that displays the answer after the press of the = button, asked Prof Ferrie, said its ok to have one text field as long as example doc have both output and input.
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class calc extends JFrame {

    private JButton jbtNum1;
    private JButton jbtNum2;
    private JButton jbtNum3;
    private JButton jbtNum4;
    private JButton jbtNum5;
    private JButton jbtNum6;
    private JButton jbtNum7;
    private JButton jbtNum8;
    private JButton jbtNum9;
    private JButton jbtNum0;
    private JButton jbtdot;
    private JButton jbtAdd;
    private JButton jbtSubtract;
    private JButton jbtMultiply;
    private JButton jbtDivide;
    private JButton jbtSolve;
    private JButton jbtClear;
    private JButton jbtMinus;
    private String SolveTEMP;
    private JTextField jtfResult;


    public calc() {
        JPanel numpan = new JPanel();
        numpan.setLayout(new GridLayout(4, 3));
        numpan.add(jbtNum1 = new JButton("1"));
        numpan.add(jbtNum2 = new JButton("2"));
        numpan.add(jbtNum3 = new JButton("3"));
        numpan.add(jbtNum4 = new JButton("4"));
        numpan.add(jbtNum5 = new JButton("5"));
        numpan.add(jbtNum6 = new JButton("6"));
        numpan.add(jbtNum7 = new JButton("7"));
        numpan.add(jbtNum8 = new JButton("8"));
        numpan.add(jbtNum9 = new JButton("9"));
        numpan.add(jbtNum0 = new JButton("0"));
        numpan.add(jbtClear = new JButton("C"));
        numpan.add(jbtdot = new JButton("."));




        JPanel text = new JPanel();
        text.setLayout(new FlowLayout());
        text.add(jtfResult = new JTextField(20));
        jtfResult.setHorizontalAlignment(JTextField.RIGHT);
        //This allows input from keyboard
        jtfResult.setEditable(true);
        JPanel ops = new JPanel();
        ops.setLayout(new GridLayout(4, 3));
        ops.add(jbtAdd = new JButton("+"));
        ops.add(jbtSubtract = new JButton("-"));
        ops.add(jbtMultiply = new JButton("x"));
        ops.add(jbtDivide = new JButton("/"));
        ops.add(jbtSolve = new JButton("="));
        ops.add(jbtMinus = new JButton("+/-"));

        JPanel p = new JPanel();
        p.setLayout(new GridLayout());
        p.add(text, BorderLayout.NORTH);
        p.add(numpan, BorderLayout.WEST);
        p.add(ops, BorderLayout.CENTER);


        add(p);
//number panel
        jbtNum1.addActionListener(new ListenToOne());
        jbtNum2.addActionListener(new ListenToTwo());
        jbtNum3.addActionListener(new ListenToThree());
        jbtNum4.addActionListener(new ListenToFour());
        jbtNum5.addActionListener(new ListenToFive());
        jbtNum6.addActionListener(new ListenToSix());
        jbtNum7.addActionListener(new ListenToSeven());
        jbtNum8.addActionListener(new ListenToEight());
        jbtNum9.addActionListener(new ListenToNine());
        jbtNum0.addActionListener(new ListenToZero());
        jbtdot.addActionListener(new ListenToDot());

        // operator panel listeners
        jbtAdd.addActionListener(new ListenToAdd());
        jbtSubtract.addActionListener(new ListenToSubtract());
        jbtMultiply.addActionListener(new ListenToMultiply());
        jbtDivide.addActionListener(new ListenToDivide());
        jbtMinus.addActionListener(new ListenToMinus());
        jbtSolve.addActionListener(new ListenToSolve());
        jbtClear.addActionListener(new ListenToClear());


    }
//Action Listeners for operators and all non numerical buttons:
    // This part of the codes surrounds every operator with whitespace so that the string can be taken in by my in2p function.
    // This part also displays the input on the screen.
    class ListenToClear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            jtfResult.setText("");
            jbtMinus.setEnabled(true);
            jbtdot.setEnabled(true);
            SolveTEMP = null;
        }
    }

    class ListenToDot implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jtfResult.setText(display+".");
            jbtClear.setEnabled(true);

        }
    }

    class ListenToOne implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jtfResult.setText(display + "1");
        }
    }

    class ListenToTwo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jtfResult.setText(display + "2");
        }
    }

    class ListenToThree implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jtfResult.setText(display + "3");
        }
    }



    class ListenToFour implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jtfResult.setText(display + "4");
        }
    }

    class ListenToFive implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jtfResult.setText(display + "5");
        }
    }

    class ListenToSix implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jtfResult.setText(display + "6");
        }
    }

    class ListenToSeven implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jtfResult.setText(display + "7");
        }
    }

    class ListenToEight implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jtfResult.setText(display + "8");
        }
    }

    class ListenToNine implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jtfResult.setText(display + "9");
        }
    }

    class ListenToZero implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jtfResult.setText(display+ "0");
        }
    }

    class ListenToAdd implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jbtMinus.setEnabled(true);
            jtfResult.setText(display+ " "+ "+" + " ");

        }
    }

    class ListenToSubtract implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jbtMinus.setEnabled(true);
            jtfResult.setText(display+" "+ "-"+ " ");
        }
    }

    class ListenToMultiply implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jbtMinus.setEnabled(true);
            jtfResult.setText(display+ " " + "x"+ " ");

        }
    }

    class ListenToDivide implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jbtMinus.setEnabled(true);
            jtfResult.setText(display + " " + "/"+ " ");
        }
    }
//Bonus part:
    //disable the button once the button is already pressed, so that the "-" can't be pressed consecutive times, and generate an error.
    class ListenToMinus implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String display = jtfResult.getText();
            jtfResult.setText(display + "-");
            int l= display.length();
            if (display.charAt(l-1)=='-'||display.charAt(0)=='-');
            jbtMinus.setEnabled(false);

        }

    }
//My in2p function that evaluates the expression must take in an array of strings and not only one string, therefore I have implemented a split statement that splits my string every time it encounters whitespace
    class ListenToSolve implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            SolveTEMP = (jtfResult.getText());
            String[] result = SolveTEMP.split(" ");
            String solved = in2p.eval(result);
            jtfResult.setText(solved);


        }
    }

    public static void main(String[] args) {
        calc calc = new calc();
        calc.pack();
        calc.setLocationRelativeTo(null);
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
    }

}
//end