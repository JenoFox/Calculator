
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
        "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
        "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };
    private Button[] buttons = new Button[bText.length];
    // ****GLOBAL VARIABLE CREATED****
    // used a global string to keep track of the expression
    private String expr = "";

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());

        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        for (int i = 0; i < 20; i++) {
            buttons[i] = new Button(bText[i]);
        }

        //add buttons to button panel
        for (int i = 0; i < 20; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < 20; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent arg0) {
        // ****Realization****
        // you do not need 20 if else chains....
        // you could simply check the symbols that do something
        // other than printing an operand or operator...
        // which would be only a few lines...
        // will not implement though because it was not originally my idea.
        if (arg0.getActionCommand() == bText[0]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[1]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[2]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[3]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[4]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[5]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[6]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[7]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[8]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[9]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[10]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[11]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[12]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[13]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[14]) {
            Evaluator evaluator = new Evaluator();
            expr = expr + "";
            txField.setText(Integer.toString(evaluator.eval(expr)));
            expr = "";
        } else if (arg0.getActionCommand() == bText[15]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[16]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[17]) {
            expr = expr + arg0.getActionCommand();
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[18]) {
            expr = "";
            txField.setText(expr);
        } else if (arg0.getActionCommand() == bText[19]) {
            expr = "";
            txField.setText(expr);
        }
    }
}
