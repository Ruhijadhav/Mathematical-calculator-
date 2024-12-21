import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.math.BigInteger;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class AllInOneCalculator2 extends JFrame {

  public AllInOneCalculator2() {
    setLayout(new BorderLayout());

    setTitle("MAKE CALCULATIONS EASY");
    setSize(1000, 700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    // Set a colorful background
    getContentPane().setBackground(new Color(135, 206, 235));

    // Initialize Menu Bar
    JMenuBar menuBar = new JMenuBar();
    menuBar.setBackground(new Color(70, 130, 180));
    menuBar.setFont(new Font("Verdana", Font.BOLD, 30));
    menuBar.setPreferredSize(new Dimension(1000, 40));

    // Create Menus (Grouping similar operations)
    JMenu basicMenu = new JMenu("Basic");
    basicMenu.setForeground(Color.WHITE);
    JMenu matrixMenu = new JMenu("Matrix Operations");
    matrixMenu.setForeground(Color.WHITE);
    JMenu geometryMenu = new JMenu("Geometry");
    geometryMenu.setForeground(Color.WHITE);

    JMenu conversionMenu = new JMenu("Conversions");
    conversionMenu.setForeground(Color.WHITE);

    JMenu sumMenu = new JMenu("Summations");
    sumMenu.setForeground(Color.WHITE);

    JMenu mathMenu = new JMenu("Math");
    mathMenu.setForeground(Color.WHITE);

    JMenu numberMenu = new JMenu("Number Operations");
    numberMenu.setForeground(Color.WHITE);

    JMenu seriesMenu = new JMenu("Series");
    seriesMenu.setForeground(Color.WHITE);

    JMenu complexMenu = new JMenu("Complex number");
    complexMenu.setForeground(Color.WHITE);

    // Add menu items to respective menus
    basicMenu.add(createMenuItem("Basic Calculations"));
    basicMenu.add(createMenuItem("Statistical Calculations"));
    basicMenu.add(createMenuItem("Age Calculator"));
    basicMenu.add(createMenuItem("Angle Between clockHands"));

    matrixMenu.add(createMenuItem("Matrix Addition"));
    matrixMenu.add(createMenuItem("Matrix Subtraction"));
    matrixMenu.add(createMenuItem("Matrix Multiplication"));

    geometryMenu.add(createMenuItem("Circle"));
    geometryMenu.add(createMenuItem("Rectangle"));
    geometryMenu.add(createMenuItem("Cylinder"));

    conversionMenu.add(createMenuItem("Binary to Decimal"));
    conversionMenu.add(createMenuItem("Decimal to Binary"));
    conversionMenu.add(createMenuItem("Angle Conversion"));

    sumMenu.add(createMenuItem("Sum of Digits in Number"));
    sumMenu.add(createMenuItem("Sum of Natural"));
    sumMenu.add(createMenuItem("Sum Odd Natural"));
    sumMenu.add(createMenuItem("Sum of Even Natural"));

    mathMenu.add(createMenuItem("GCD&LCM of Two Numbers"));

    numberMenu.add(createMenuItem("Prime Numbers"));
    numberMenu.add(createMenuItem("Armstrong Numbers"));
    numberMenu.add(createMenuItem("checkForPrimeOrArmstrong"));
    numberMenu.add(createMenuItem("Palindrome"));

    seriesMenu.add(createMenuItem("Fibonacci Series"));
    seriesMenu.add(createMenuItem("is in Fibonacci?"));

    seriesMenu.add(createMenuItem("Table of a Number"));

    complexMenu.add(createMenuItem("Complex Numbers Calculations"));

    // Add all menus to the menu bar
    menuBar.add(basicMenu);
    menuBar.add(Box.createHorizontalStrut(20)); // Adds space

    menuBar.add(matrixMenu);
    menuBar.add(Box.createHorizontalStrut(20));

    menuBar.add(geometryMenu);
    menuBar.add(Box.createHorizontalStrut(20));

    menuBar.add(conversionMenu);
    menuBar.add(Box.createHorizontalStrut(20));

    menuBar.add(sumMenu);
    menuBar.add(Box.createHorizontalStrut(20));

    menuBar.add(mathMenu);
    menuBar.add(Box.createHorizontalStrut(20));

    menuBar.add(numberMenu);
    menuBar.add(Box.createHorizontalStrut(20));

    menuBar.add(seriesMenu);
    menuBar.add(Box.createHorizontalStrut(20));

    menuBar.add(complexMenu);

    setJMenuBar(menuBar);
    setLayout(new BorderLayout());

    // Welcome Label
    JLabel welcomeLabel = new JLabel("WELCOME TO MAKE CALCULATIONS EASY", SwingConstants.CENTER);
    welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 26));
    welcomeLabel.setForeground(new Color(0, 102, 204));
    welcomeLabel.setBorder(new EmptyBorder(20, 10, 20, 10));

    setBackground(new Color(240, 248, 255)); // Light background for entire window
    welcomeLabel.setOpaque(true);
    welcomeLabel.setBackground(new Color(240, 248, 255));

    add(welcomeLabel, BorderLayout.CENTER);

  }

  // Helper method to create menu items and add action listeners
  private JMenuItem createMenuItem(String name) {
    JMenuItem item = new JMenuItem(name);
    item.setForeground(Color.WHITE);
    item.setBackground(new Color(70, 130, 180));
    item.setFont(new Font("Verdana", Font.PLAIN, 14));

    // Action Listener for menu items
    item.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        switch (name) {
          case "Basic Calculations":
            openScientificCalculator();
            break;
          case "Age Calculator":
            openCalculateAge();
            break;
          case "Angle Between clockHands":
            openClockAngleCalculator();
            break;
          case "Matrix Addition":
            openMatrixAddition();
            break;
          case "Matrix Subtraction":
            openMatrixSubtraction();
            break;
          case "Matrix Multiplication":
            openMatrixMultiplication();
            break;
          case "Circle":
            openCircleCalculator();
            break;
          case "Rectangle":
            openRectangleCalculator();
            break;
          case "Cylinder":
            openCylinderCalculator();
            break;
          case "Binary to Decimal":
            openBinaryToDecimal();
            break;
          case "Decimal to Binary":
            openDecimalToBinary();
            break;
          case "Sum of Digits in Number":
            openSumOfDigits();
            break;
          case "Sum Odd Natural":
            openSumOddNatural();
            break;
          case "Sum of Natural":
            openSumNatural();
            break;
          case "Sum of Even Natural":
            openSumEvenNatural();
            break;
          case "GCD&LCM of Two Numbers":
            openGCDLCMCalculator();
            break;
          case "Angle Conversion":
            openAngleConversion();
            break;
          case "Statistical Calculations":
            openStatisticalCalculations();
            break;
          case "Table of a Number":
            openTableOfNumber();
            break;
          case "Complex Numbers Calculations":
            openComplexNumbersCalculator();
            break;
          case "Prime Numbers":
            openPrimeNumbers();
            break;
          case "checkForPrimeOrArmstrong":
            checkNumberProperties();
            break;
          case "Armstrong Numbers":
            openArmstrongNumbers();
            break;
          case "Palindrome":
            openPalindromeChecker();
            break;
          case "Fibonacci Series":
            openFibonacciSeries();
            break;
          case "is in Fibonacci?":
            openFibonacciChecker();
            break;
          default:
            JOptionPane.showMessageDialog(null, name + " is not yet implemented.", "Info",
                JOptionPane.INFORMATION_MESSAGE);
        }
      }
    });

    return item;
  }

  private void openScientificCalculator() {
    final double[] first = { 0 };
    final double[] second = { 0 };
    final double[] result = { 0 };
    final String[] operator = { "" };

    final boolean[] isFunctionPressed = { false };
    final String[] pendingFunction = { "" };

    JDialog dialog = new JDialog(this, "Scientific Calculator", true);
    dialog.setSize(500, 600);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(135, 206, 235));

    JPanel mainPanel = new JPanel(new GridLayout(2, 1));
    mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

    JTextField display = new JTextField();
    display.setEditable(false);
    display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

    display.setBackground(new Color(230, 230, 250));
    display.setFont(new Font("Verdana", Font.BOLD, 32));
    display.setHorizontalAlignment(SwingConstants.RIGHT);
    display.setPreferredSize(new Dimension(500, 70));

    JTextField resultDisplay = new JTextField();
    resultDisplay.setEditable(false);
    resultDisplay.setBackground(new Color(230, 230, 250));
    resultDisplay.setFont(new Font("Verdana", Font.BOLD, 32));
    resultDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
    resultDisplay.setPreferredSize(new Dimension(500, 70));

    JPanel inOutPanel = new JPanel(new BorderLayout(10, 10));
    inOutPanel.setPreferredSize(new Dimension(500, 120));

    // Adding scroll pane for resultDisplay
    JScrollPane resultScrollPane = new JScrollPane(resultDisplay);
    resultScrollPane.setPreferredSize(new Dimension(500, 60));
    resultScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    inOutPanel.add(display, BorderLayout.NORTH);
    inOutPanel.add(resultScrollPane, BorderLayout.CENTER);

    JPanel buttonsPanel = new JPanel(new GridLayout(6, 5, 5, 5));
    buttonsPanel.setBackground(new Color(240, 248, 255));

    String[] buttons = {
        "7", "8", "9", "bsck", "C",
        "4", "5", "6", "*", "/",
        "1", "2", "3", "+", "-",
        "0", ".", "=", "!", "√",
        "sin", "cos", "tan",
        "sinh", "cosh", "tanh",
        "ln", "e^", "x^y", "log"
    };

    for (String buttonText : buttons) {
      JButton button = new JButton(buttonText);
      button.setBackground(new Color(145, 224, 255));
      button.setFont(new Font("Verdana", Font.PLAIN, 18));

      button.addActionListener(e -> {
        String cmd = e.getActionCommand();

        switch (cmd) {
          case "C":
            display.setText("");
            resultDisplay.setText("");
            first[0] = second[0] = result[0] = 0;
            operator[0] = "";
            isFunctionPressed[0] = false;
            pendingFunction[0] = "";
            break;
          case "bsck":
            String currentText = display.getText();
            if (!currentText.isEmpty()) {
              display.setText(currentText.substring(0, currentText.length() - 1));
            }
            break;
          case "√":
          case "sin":
          case "cos":
          case "tan":
          case "sinh":
          case "cosh":
          case "tanh":
          case "ln":
          case "log":
          case "e^":
            isFunctionPressed[0] = true;
            pendingFunction[0] = cmd;
            display.setText(cmd);
            break;
          case "/":
          case "*":
          case "-":
          case "+":
          case "x^y":
            try {
              first[0] = Double.parseDouble(display.getText());
              operator[0] = cmd;
              display.setText("");
            } catch (NumberFormatException ex) {
              display.setText("Error");
            }
            break;
          case "=":
            try {
              if (isFunctionPressed[0] && !pendingFunction[0].isEmpty()) {
                double value = Double.parseDouble(display.getText().replaceAll("[^0-9.]", ""));
                result[0] = switch (pendingFunction[0]) {
                  case "√" -> Math.sqrt(value);
                  case "sin" -> Math.sin(Math.toRadians(value));
                  case "cos" -> Math.cos(Math.toRadians(value));
                  case "tan" -> Math.tan(Math.toRadians(value));
                  case "sinh" -> Math.sinh(value);
                  case "cosh" -> Math.cosh(value);
                  case "tanh" -> Math.tanh(value);
                  case "ln" -> Math.log(value);
                  case "log" -> Math.log10(value);
                  case "e^" -> Math.exp(value);
                  default -> 0;
                };
                resultDisplay.setText("" + result[0]);
                isFunctionPressed[0] = false;
                pendingFunction[0] = "";
              } else {
                second[0] = Double.parseDouble(display.getText());
                result[0] = switch (operator[0]) {
                  case "/" -> first[0] / second[0];
                  case "*" -> first[0] * second[0];
                  case "-" -> first[0] - second[0];
                  case "+" -> first[0] + second[0];
                  case "x^y" -> Math.pow(first[0], second[0]);
                  default -> 0;
                };
                resultDisplay.setText(String.valueOf(result[0]));
                operator[0] = "";
              }
            } catch (NumberFormatException ex) {
              display.setText("Error");
            }
            break;
          case ".":
            if (!display.getText().contains(".")) {
              display.setText(display.getText() + ".");
            }
            break;
          case "!":
            try {
              int num = Integer.parseInt(display.getText());
              double fact = 1;
              for (int i = 1; i <= num; i++) {
                fact *= i;
              }
              resultDisplay.setText(String.valueOf(fact));
            } catch (NumberFormatException | ArithmeticException ex) {
              display.setText("Error");
            }
            break;
          default:
            if (isFunctionPressed[0]) {
              display.setText(display.getText() + cmd);
            } else {
              display.setText(display.getText() + cmd);
            }
            break;
        }
      });
      buttonsPanel.add(button);
    }
    mainPanel.add(inOutPanel);
    mainPanel.add(buttonsPanel);
    dialog.add(mainPanel);
    dialog.setVisible(true);
  }

  // Matrix Addition
  private void openMatrixAddition() {
    openMatrixOperation("Addition");
  }

  // Matrix Subtraction
  private void openMatrixSubtraction() {
    openMatrixOperation("Subtraction");
  }

  // Matrix Multiplication
  private void openMatrixMultiplication() {
    openMatrixOperation("Multiplication");
  }

  // Helper method for Matrix Operations
  private void openMatrixOperation(String operation) {
    JDialog dialog = new JDialog(this, "Matrix " + operation, true);
    dialog.setSize(900, 700);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout(10, 10));
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));
    panel.setBackground(new Color(173, 216, 230));

    // Input Panel for Matrix Dimensions
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new GridLayout(2, 1, 10, 10));
    inputPanel.setBackground(new Color(173, 216, 230));

    // Panel for Matrix A Dimensions
    JPanel matrixADimPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel matrixARowsLabel = new JLabel("Matrix A Rows:");
    matrixADimPanel.setBackground(new Color(135, 206, 235));
    matrixARowsLabel.setForeground(Color.BLACK); // Text color for better contrast
    matrixARowsLabel.setBackground(new Color(46, 64, 83));

    JTextField matrixARowsField = new JTextField(5);
    matrixARowsField.setBackground(new Color(213, 219, 219));// Alice Blue
    matrixARowsField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JLabel matrixAColsLabel = new JLabel("Matrix A Columns:");
    matrixAColsLabel.setForeground(Color.BLACK); // Text color for better contrast
    matrixAColsLabel.setBackground(new Color(46, 64, 83));

    JTextField matrixAColsField = new JTextField(5);
    matrixAColsField.setBackground(new Color(213, 219, 219));// Alice Blue
    matrixAColsField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    matrixADimPanel.add(matrixARowsLabel);
    matrixADimPanel.add(matrixARowsField);
    matrixADimPanel.add(matrixAColsLabel);
    matrixADimPanel.add(matrixAColsField);

    // Panel for Matrix B Dimensions
    JPanel matrixBDimPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    matrixBDimPanel.setBackground(new Color(135, 206, 235));
    JLabel matrixBRowsLabel = new JLabel("Matrix B Rows:");
    matrixBRowsLabel.setForeground(Color.BLACK); // Text color for better contrast
    matrixBRowsLabel.setBackground(new Color(46, 64, 83));

    JTextField matrixBRowsField = new JTextField(5);
    matrixBRowsField.setBackground(new Color(213, 219, 219));// Alice Blue
    matrixBRowsField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JLabel matrixBColsLabel = new JLabel("Matrix B Columns:");
    matrixBColsLabel.setForeground(Color.BLACK); // Text color for better contrast
    matrixBColsLabel.setBackground(new Color(46, 64, 83));

    JTextField matrixBColsField = new JTextField(5);
    matrixBColsField.setBackground(new Color(213, 219, 219));// Alice Blue
    matrixBColsField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    matrixBDimPanel.add(matrixBRowsLabel);
    matrixBDimPanel.add(matrixBRowsField);
    matrixBDimPanel.add(matrixBColsLabel);
    matrixBDimPanel.add(matrixBColsField);
    inputPanel.setBackground(new Color(135, 206, 235));
    inputPanel.add(matrixADimPanel);
    inputPanel.add(matrixBDimPanel);

    panel.add(inputPanel, BorderLayout.NORTH);

    // Panel to input matrices
    JPanel matricesPanel = new JPanel();
    matricesPanel.setLayout(new GridLayout(1, 2, 10, 7));
    matricesPanel.setBackground(new Color(173, 216, 230));

    // Panel for Matrix A Input
    JPanel matrixAPanel = new JPanel();
    matrixAPanel.setLayout(new BorderLayout());
    // matrixAPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
    dialog.getContentPane().setBackground(new Color(234, 237, 237));
    matrixAPanel.setBackground(new Color(135, 206, 235));

    JLabel matrixALabel = new JLabel("Matrix A (Rows separated by new lines, elements by spaces):");
    matrixALabel.setForeground(Color.BLACK);
    matrixALabel.setBackground(new Color(46, 64, 83));

    JTextArea matrixAText = new JTextArea(10, 50);
    matrixAText.setBackground(new Color(213, 219, 219));// Alice Blue
    matrixAText.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    matrixAText.setFont(new Font("Monospaced", Font.PLAIN, 14));
    JScrollPane scrollA = new JScrollPane(matrixAText);
    matrixAPanel.add(matrixALabel, BorderLayout.NORTH);
    matrixAPanel.add(scrollA, BorderLayout.CENTER);

    // Panel for Matrix B Input
    JPanel matrixBPanel = new JPanel();
    matrixBPanel.setBackground(new Color(135, 206, 235));
    matrixBPanel.setLayout(new BorderLayout());
    JLabel matrixBLabel = new JLabel("Matrix B (Rows separated by new lines, elements by spaces):");
    matrixBLabel.setForeground(Color.BLACK); // Text color for better contrast
    matrixBLabel.setBackground(new Color(46, 64, 83));

    JTextArea matrixBText = new JTextArea(10, 50);
    matrixBText.setBackground(new Color(213, 219, 219));// Alice Blue
    matrixBText.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    matrixBText.setFont(new Font("Monospaced", Font.PLAIN, 14));
    JScrollPane scrollB = new JScrollPane(matrixBText);
    matrixBPanel.add(matrixBLabel, BorderLayout.NORTH);
    matrixBPanel.add(scrollB, BorderLayout.CENTER);

    matricesPanel.add(matrixAPanel);
    matricesPanel.add(matrixBPanel);
    matricesPanel.setBackground(new Color(135, 206, 235));

    panel.add(matricesPanel, BorderLayout.CENTER);

    // Result Area
    JPanel resultPanel = new JPanel();
    resultPanel.setLayout(new BorderLayout());
    JLabel resultLabel = new JLabel("Result (" + operation + "):");
    JTextArea resultArea = new JTextArea(13, 10);
    resultPanel.setBackground(new Color(135, 206, 235));// Alice Blue
    resultArea.setBackground(new Color(213, 219, 219));
    resultArea.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
    resultArea.setEditable(false);
    JScrollPane scrollResult = new JScrollPane(resultArea);
    resultPanel.add(resultLabel, BorderLayout.NORTH);
    resultPanel.add(scrollResult, BorderLayout.CENTER);

    panel.add(resultPanel, BorderLayout.SOUTH);

    // create button
    JPanel mainButtonPanel = new JPanel(new BorderLayout());
    JPanel btnpanel = new JPanel();
    btnpanel.setLayout(new FlowLayout()); // Use BorderLayout for bottom alignment
    btnpanel.setBackground(new Color(135, 206, 235));
    JButton createButton = new JButton(operation);
    createButton.setBackground(new Color(194, 91, 60));
    createButton.setForeground(Color.WHITE);

    Dimension buttonSize = new Dimension(100, 100); // Small size for the button
    createButton.setPreferredSize(buttonSize);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 100));

    btnpanel.add(createButton);
    btnpanel.add(backButton);

    mainButtonPanel.setBackground(new Color(135, 206, 235));
    mainButtonPanel.add(btnpanel, BorderLayout.SOUTH);
    resultPanel.add(mainButtonPanel, BorderLayout.EAST);
    panel.setBackground(new Color(135, 206, 235));
    resultPanel.setVisible(true);

    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Action Listener for Create Button
    createButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int aRows, aCols, bRows, bCols;
        try {
          aRows = Integer.parseInt(matrixARowsField.getText().trim());
          aCols = Integer.parseInt(matrixAColsField.getText().trim());
          bRows = Integer.parseInt(matrixBRowsField.getText().trim());
          bCols = Integer.parseInt(matrixBColsField.getText().trim());

          if (aRows <= 0 || aCols <= 0 || bRows <= 0 || bCols <= 0)
            throw new NumberFormatException();
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter valid positive integers for all dimensions.",
              "Error", JOptionPane.ERROR_MESSAGE);
          return;
        }

        // Validate dimensions for the selected operation
        if (operation.equals("Multiplication") && aCols != bRows) {
          JOptionPane.showMessageDialog(dialog,
              "For multiplication, the number of columns in Matrix A must equal the number of rows in Matrix B.",
              "Dimension Mismatch", JOptionPane.ERROR_MESSAGE);
          return;
        }

        // Get matrix inputs from JTextAreas
        String matrixAInput = matrixAText.getText();
        String matrixBInput = matrixBText.getText();

        // Parse matrices
        double[][] matrixA = parseMatrixInput(matrixAInput, aRows, aCols);
        double[][] matrixB = parseMatrixInput(matrixBInput, bRows, bCols);

        if (matrixA == null || matrixB == null) {
          JOptionPane.showMessageDialog(dialog, "Invalid matrix input. Please ensure correct format.",
              "Error", JOptionPane.ERROR_MESSAGE);
          return;
        }

        // Perform Operation
        double[][] result = null;
        switch (operation) {
          case "Addition":
            if (aRows != bRows || aCols != bCols) {
              JOptionPane.showMessageDialog(dialog,
                  "For addition, both matrices must have the same dimensions.", "Dimension Mismatch",
                  JOptionPane.ERROR_MESSAGE);
              return;
            }
            result = addMatrices(matrixA, matrixB);
            break;
          case "Subtraction":
            if (aRows != bRows || aCols != bCols) {
              JOptionPane.showMessageDialog(dialog,
                  "For subtraction, both matrices must have the same dimensions.",
                  "Dimension Mismatch", JOptionPane.ERROR_MESSAGE);
              return;
            }
            result = subtractMatrices(matrixA, matrixB);
            break;
          case "Multiplication":
            result = multiplyMatrices(matrixA, matrixB);
            break;
        }

        if (result != null) {
          resultArea.setText(formatMatrix(result));
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // Helper methods for Matrix Operations
  private double[][] parseMatrixInput(String input, int rows, int cols) {
    if (input == null || input.trim().isEmpty())
      return null;
    String[] lines = input.trim().split("\\r?\\n");
    if (lines.length != rows)
      return null;
    double[][] matrix = new double[rows][cols];
    for (int i = 0; i < rows; i++) {
      String[] elements = lines[i].trim().split("\\s+");
      if (elements.length != cols)
        return null;
      for (int j = 0; j < cols; j++) {
        try {
          matrix[i][j] = Double.parseDouble(elements[j]);
        } catch (NumberFormatException ex) {
          return null;
        }
      }
    }
    return matrix;
  }

  private String formatMatrix(double[][] matrix) {
    StringBuilder sb = new StringBuilder();
    for (double[] row : matrix) {
      for (double val : row) {
        sb.append(String.format("%.2f ", val));
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  private double[][] addMatrices(double[][] a, double[][] b) {
    int rows = a.length;
    int cols = a[0].length;
    double[][] result = new double[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        result[i][j] = a[i][j] + b[i][j];
      }
    }
    return result;
  }

  private double[][] subtractMatrices(double[][] a, double[][] b) {
    int rows = a.length;
    int cols = a[0].length;
    double[][] result = new double[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        result[i][j] = a[i][j] - b[i][j];
      }
    }
    return result;
  }

  private double[][] multiplyMatrices(double[][] a, double[][] b) {
    int rows = a.length;
    int cols = b[0].length;
    int common = a[0].length;
    double[][] result = new double[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        for (int k = 0; k < common; k++) {
          result[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return result;
  }

  // 5. Circle Calculator
  private void openCircleCalculator() {
    JDialog dialog = new JDialog(this, "Circle Calculator", true);
    dialog.setSize(400, 300);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JLabel radiusLabel = new JLabel("Radius:");
    radiusLabel.setForeground(Color.BLACK); // Text color for better contrast
    radiusLabel.setBackground(new Color(46, 64, 83));

    JTextField radiusField = new JTextField();
    radiusField.setBackground(new Color(213, 219, 219));// Alice Blue
    radiusField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    radiusField.setForeground(Color.BLACK); // Text color

    JButton areaButton = new JButton("Calculate Area");
    areaButton.setBackground(new Color(194, 91, 60));
    areaButton.setForeground(Color.WHITE); // Text color for better contrast

    JButton circumferenceButton = new JButton("Calculate Circumference");
    circumferenceButton.setBackground(new Color(194, 91, 60));
    circumferenceButton.setForeground(Color.WHITE); // Text color for better contrast

    radiusField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JLabel areaLabel = new JLabel("Area:");
    JTextField areaField = new JTextField();
    areaLabel.setForeground(Color.WHITE);
    areaLabel.setBackground(new Color(46, 64, 83));// Text color for better contrast

    areaField.setBackground(new Color(213, 219, 219));
    areaField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    areaField.setEditable(false);

    JLabel circumferenceLabel = new JLabel("Circumference:");
    circumferenceLabel.setBackground(new Color(46, 64, 83));
    JTextField circumferenceField = new JTextField();
    circumferenceField.setBackground(new Color(213, 219, 219));
    circumferenceField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    circumferenceField.setEditable(false);

    panel.add(radiusLabel);
    panel.add(radiusField);
    panel.add(areaButton);
    panel.add(areaField);
    panel.add(circumferenceButton);
    panel.add(circumferenceField);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Action Listeners
    areaButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String radiusText = radiusField.getText().trim();
        try {
          double radius = Double.parseDouble(radiusText);
          if (radius < 0)
            throw new NumberFormatException();
          double area = Math.PI * radius * radius;
          areaField.setText(String.format("%.2f", area));
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter a valid positive number for radius.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    circumferenceButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String radiusText = radiusField.getText().trim();
        try {
          double radius = Double.parseDouble(radiusText);
          if (radius < 0)
            throw new NumberFormatException();
          double circumference = 2 * Math.PI * radius;
          circumferenceField.setText(String.format("%.2f", circumference));
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter a valid positive number for radius.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // 6. Rectangle Calculator
  private void openRectangleCalculator() {
    JDialog dialog = new JDialog(this, "Rectangle Calculator", true);
    dialog.setSize(400, 300);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(5, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JLabel lengthLabel = new JLabel("Length:");
    lengthLabel.setForeground(Color.BLACK); // Text color for better contrast
    lengthLabel.setBackground(new Color(194, 91, 60));

    JTextField lengthField = new JTextField();
    lengthField.setBackground(new Color(213, 219, 219));// Alice Blue
    lengthField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JLabel widthLabel = new JLabel("Width:");
    widthLabel.setForeground(Color.BLACK); // Text color for better contrast
    widthLabel.setBackground(new Color(46, 64, 83));

    JTextField widthField = new JTextField();
    widthField.setBackground(new Color(213, 219, 219));// Alice Blue
    widthField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton areaButton = new JButton("Calculate Area");
    areaButton.setBackground(new Color(194, 91, 60));
    areaButton.setForeground(Color.WHITE);

    JButton perimeterButton = new JButton("Calculate Perimeter");
    perimeterButton.setBackground(new Color(194, 91, 60));
    perimeterButton.setForeground(Color.WHITE);

    JLabel areaLabel = new JLabel("Area:");
    areaLabel.setForeground(Color.BLACK); // Text color for better contrast
    areaLabel.setBackground(new Color(46, 64, 83));
    JTextField areaField = new JTextField();
    areaField.setBackground(new Color(213, 219, 219));// Alice Blue
    areaField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color
    areaField.setEditable(false);

    JLabel perimeterLabel = new JLabel("Perimeter:");
    perimeterLabel.setForeground(Color.BLACK); // Text color for better contrast
    perimeterLabel.setBackground(new Color(46, 64, 83));
    JTextField perimeterField = new JTextField();
    perimeterField.setBackground(new Color(213, 219, 219));// Alice Blue
    perimeterField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color
    perimeterField.setEditable(false);

    panel.add(lengthLabel);
    panel.add(lengthField);
    panel.add(widthLabel);
    panel.add(widthField);
    panel.add(areaButton);
    panel.add(areaField);
    panel.add(perimeterButton);
    panel.add(perimeterField);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Action Listeners
    areaButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String lengthText = lengthField.getText().trim();
        String widthText = widthField.getText().trim();
        try {
          double length = Double.parseDouble(lengthText);
          double width = Double.parseDouble(widthText);
          if (length < 0 || width < 0)
            throw new NumberFormatException();
          double area = length * width;
          areaField.setText(String.format("%.2f", area));
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter valid positive numbers for length and width.",
              "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    perimeterButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String lengthText = lengthField.getText().trim();
        String widthText = widthField.getText().trim();
        try {
          double length = Double.parseDouble(lengthText);
          double width = Double.parseDouble(widthText);
          if (length < 0 || width < 0)
            throw new NumberFormatException();
          double perimeter = 2 * (length + width);
          perimeterField.setText(String.format("%.2f", perimeter));
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter valid positive numbers for length and width.",
              "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // 7. Cylinder Calculator
  private void openCylinderCalculator() {
    JDialog dialog = new JDialog(this, "Cylinder Calculator", true);
    dialog.setSize(400, 350);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(5, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JLabel radiusLabel = new JLabel("Radius:");
    radiusLabel.setForeground(Color.BLACK); // Text color for better contrast
    radiusLabel.setBackground(new Color(46, 64, 83));

    JTextField radiusField = new JTextField();
    radiusField.setBackground(new Color(213, 219, 219));// Alice Blue
    radiusField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JLabel heightLabel = new JLabel("Height:");
    heightLabel.setForeground(Color.BLACK); // Text color for better contrast
    heightLabel.setBackground(new Color(46, 64, 83));

    JTextField heightField = new JTextField();
    heightField.setBackground(new Color(213, 219, 219));// Alice Blue
    heightField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton volumeButton = new JButton("Calculate Volume");
    volumeButton.setBackground(new Color(194, 91, 60));
    volumeButton.setForeground(Color.WHITE); // Text color for better contrast

    JButton surfaceAreaButton = new JButton("Calculate Surface Area");
    surfaceAreaButton.setBackground(new Color(194, 91, 60));
    surfaceAreaButton.setForeground(Color.WHITE); // Text color for better contrast

    JLabel volumeLabel = new JLabel("Volume:");
    volumeLabel.setForeground(Color.BLACK); // Text color for better contrast
    volumeLabel.setBackground(new Color(46, 64, 83));

    JTextField volumeField = new JTextField();
    volumeField.setBackground(new Color(213, 219, 219));// Alice Blue
    volumeField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color
    volumeField.setEditable(false);

    JLabel surfaceAreaLabel = new JLabel("Surface Area:");
    surfaceAreaLabel.setForeground(Color.BLACK); // Text color for better contrast
    surfaceAreaLabel.setBackground(new Color(46, 64, 83));

    JTextField surfaceAreaField = new JTextField();
    surfaceAreaField.setBackground(new Color(213, 219, 219));// Alice Blue
    surfaceAreaField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    surfaceAreaField.setEditable(false);

    panel.add(radiusLabel);
    panel.add(radiusField);
    panel.add(heightLabel);
    panel.add(heightField);
    panel.add(volumeButton);
    panel.add(volumeField);
    panel.add(surfaceAreaButton);
    panel.add(surfaceAreaField);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Action Listeners
    volumeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String radiusText = radiusField.getText().trim();
        String heightText = heightField.getText().trim();
        try {
          double radius = Double.parseDouble(radiusText);
          double height = Double.parseDouble(heightText);
          if (radius < 0 || height < 0)
            throw new NumberFormatException();
          double volume = Math.PI * radius * radius * height;
          volumeField.setText(String.format("%.2f", volume));
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter valid positive numbers for radius and height.",
              "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    surfaceAreaButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String radiusText = radiusField.getText().trim();
        String heightText = heightField.getText().trim();
        try {
          double radius = Double.parseDouble(radiusText);
          double height = Double.parseDouble(heightText);
          if (radius < 0 || height < 0)
            throw new NumberFormatException();
          double surfaceArea = 2 * Math.PI * radius * (radius + height);
          surfaceAreaField.setText(String.format("%.2f", surfaceArea));
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter valid positive numbers for radius and height.",
              "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // 8. Binary to Decimal Conversion
  private void openBinaryToDecimal() {
    JDialog dialog = new JDialog(this, "Binary to Decimal Conversion", true);
    dialog.setSize(400, 250);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JLabel binaryLabel = new JLabel("Enter Binary Number:");
    binaryLabel.setForeground(Color.BLACK); // Text color for better contrast
    binaryLabel.setBackground(new Color(46, 64, 83));

    JTextField binaryField = new JTextField();
    binaryField.setBackground(new Color(213, 219, 219));// Alice Blue
    binaryField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton convertButton = new JButton("Convert to Decimal");
    convertButton.setBackground(new Color(194, 91, 60));
    convertButton.setForeground(Color.WHITE); // Text color for better contrast

    JLabel decimalLabel = new JLabel("Decimal Number:");
    decimalLabel.setForeground(Color.BLACK); // Text color for better contrast
    decimalLabel.setBackground(new Color(46, 64, 83));

    JTextField decimalField = new JTextField();
    decimalField.setBackground(new Color(213, 219, 219));// Alice Blue
    decimalField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    decimalField.setEditable(false);

    panel.add(binaryLabel);
    panel.add(binaryField);
    panel.add(decimalLabel);
    panel.add(decimalField);
    panel.add(convertButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Action Listener
    convertButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String binary = binaryField.getText().trim();
        if (!binary.matches("[01]+")) {
          JOptionPane.showMessageDialog(dialog, "Please enter a valid binary number.", "Error",
              JOptionPane.ERROR_MESSAGE);
          return;
        }
        try {
          long decimal = Long.parseLong(binary, 2);
          decimalField.setText(String.valueOf(decimal));
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Binary number is too large.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // 9. Decimal to Binary Conversion
  private void openDecimalToBinary() {
    JDialog dialog = new JDialog(this, "Decimal to Binary Conversion", true);
    dialog.setSize(400, 250);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JLabel decimalLabel = new JLabel("Enter Decimal Number:");
    decimalLabel.setForeground(Color.BLACK); // Text color for better contrast
    decimalLabel.setBackground(new Color(46, 64, 83));

    JTextField decimalFieldInput = new JTextField();
    decimalFieldInput.setBackground(new Color(213, 219, 219));// Alice Blue
    decimalFieldInput.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton convertButton = new JButton("Convert to Binary");
    convertButton.setBackground(new Color(194, 91, 60));
    convertButton.setForeground(Color.WHITE); // Text color for better contrast

    JLabel binaryLabel = new JLabel("Binary Number:");
    binaryLabel.setForeground(Color.BLACK); // Text color for better contrast
    binaryLabel.setBackground(new Color(46, 64, 83));

    JTextField binaryField = new JTextField();
    binaryField.setBackground(new Color(213, 219, 219));// Alice Blue
    binaryField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    binaryField.setEditable(false);

    panel.add(decimalLabel);
    panel.add(decimalFieldInput);
    panel.add(binaryLabel);
    panel.add(binaryField);
    panel.add(convertButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Action Listener
    convertButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String decimalText = decimalFieldInput.getText().trim();
        try {
          long decimal = Long.parseLong(decimalText);
          if (decimal < 0)
            throw new NumberFormatException();
          String binary = Long.toBinaryString(decimal);
          binaryField.setText(binary);
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter a valid non-negative integer.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // 10. Sum of Digits in Number
  private void openSumOfDigits() {
    JDialog dialog = new JDialog(this, "Sum of Digits in Number", true);
    dialog.setSize(400, 200);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JLabel numberLabel = new JLabel("Enter Number:");
    numberLabel.setForeground(Color.BLACK); // Text color for better contrast
    numberLabel.setBackground(new Color(46, 64, 83));

    JTextField numberField = new JTextField();
    numberField.setBackground(new Color(213, 219, 219));// Alice Blue
    numberField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton sumButton = new JButton("Calculate Sum");
    sumButton.setBackground(new Color(194, 91, 60));
    sumButton.setForeground(Color.WHITE); // Text color for better contrast

    JLabel sumLabel = new JLabel("Sum of Digits:");
    sumLabel.setForeground(Color.BLACK); // Text color for better contrast
    sumLabel.setBackground(new Color(46, 64, 83));

    JTextField sumField = new JTextField();
    sumField.setBackground(new Color(213, 219, 219));// Alice Blue
    sumField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color
    sumField.setEditable(false);

    panel.add(numberLabel);
    panel.add(numberField);
    panel.add(sumLabel);
    panel.add(sumField);
    panel.add(sumButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Action Listener
    sumButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String numberText = numberField.getText().trim();
        if (!numberText.matches("\\d+")) {
          JOptionPane.showMessageDialog(dialog, "Please enter a valid positive integer.", "Error",
              JOptionPane.ERROR_MESSAGE);
          return;
        }
        int sum = 0;
        for (char c : numberText.toCharArray()) {
          sum += Character.getNumericValue(c);
        }
        sumField.setText(String.valueOf(sum));
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // 11. Sum of Odd Natural Numbers
  private void openSumOddNatural() {
    JDialog dialog = new JDialog(this, "Sum of Odd Natural Numbers", true);
    dialog.setSize(400, 200);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JLabel nLabel = new JLabel("Enter N:");
    nLabel.setForeground(Color.BLACK); // Text color for better contrast
    nLabel.setBackground(new Color(46, 64, 83));

    JTextField nField = new JTextField();
    nField.setBackground(new Color(213, 219, 219));// Alice Blue
    nField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton sumButton = new JButton("Calculate Sum");
    sumButton.setBackground(new Color(194, 91, 60));
    sumButton.setForeground(Color.WHITE); // Text color for better contrast

    JLabel sumLabel = new JLabel("Sum of Odd Numbers:");
    sumLabel.setForeground(Color.BLACK); // Text color for better contrast
    sumLabel.setBackground(new Color(46, 64, 83));

    JTextField sumField = new JTextField();
    sumField.setBackground(new Color(213, 219, 219));// Alice Blue
    sumField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    sumField.setEditable(false);

    panel.add(nLabel);
    panel.add(nField);
    panel.add(sumLabel);
    panel.add(sumField);
    panel.add(sumButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Action Listener
    sumButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String nText = nField.getText().trim();
        try {
          int n = Integer.parseInt(nText);
          if (n <= 0)
            throw new NumberFormatException();
          int sum = 0;
          for (int i = 1; i <= n; i += 2) {
            sum += i;
          }
          sumField.setText(String.valueOf(sum));
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter a valid positive integer for N.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // 12. Sum of Natural Numbers
  private void openSumNatural() {
    JDialog dialog = new JDialog(this, "Sum of Natural Numbers", true);
    dialog.setSize(400, 200);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JLabel nLabel = new JLabel("Enter N:");
    nLabel.setForeground(Color.BLACK); // Text color for better contrast
    nLabel.setBackground(new Color(46, 64, 83));

    JTextField nField = new JTextField();
    nField.setBackground(new Color(213, 219, 219));// Alice Blue
    nField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton sumButton = new JButton("Calculate Sum");
    sumButton.setBackground(new Color(194, 91, 60));
    sumButton.setForeground(Color.WHITE); // Text color for better contrast

    JLabel sumLabel = new JLabel("Sum of Natural Numbers:");
    sumLabel.setForeground(Color.BLACK); // Text color for better contrast
    sumLabel.setBackground(new Color(46, 64, 83));

    JTextField sumField = new JTextField();
    sumField.setBackground(new Color(213, 219, 219));// Alice Blue
    sumField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color
    sumField.setEditable(false);

    panel.add(nLabel);
    panel.add(nField);
    panel.add(sumLabel);
    panel.add(sumField);
    panel.add(sumButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Action Listener
    sumButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String nText = nField.getText().trim();
        try {
          int n = Integer.parseInt(nText);
          if (n <= 0)
            throw new NumberFormatException();
          int sum = n * (n + 1) / 2;
          sumField.setText(String.valueOf(sum));
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter a valid positive integer for N.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // 13. Sum of Even Natural Numbers
  private void openSumEvenNatural() {
    JDialog dialog = new JDialog(this, "Sum of Even Natural Numbers", true);
    dialog.setSize(400, 200);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JLabel nLabel = new JLabel("Enter N:");
    nLabel.setForeground(Color.BLACK); // Text color for better contrast
    nLabel.setBackground(new Color(46, 64, 83));

    JTextField nField = new JTextField();
    nField.setBackground(new Color(213, 219, 219));// Alice Blue
    nField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton sumButton = new JButton("Calculate Sum");
    sumButton.setBackground(new Color(194, 91, 60));
    sumButton.setForeground(Color.WHITE); // Text color for better contrast

    JLabel sumLabel = new JLabel("Sum of Even Numbers:");
    sumLabel.setForeground(Color.BLACK); // Text color for better contrast
    sumLabel.setBackground(new Color(46, 64, 83));

    JTextField sumField = new JTextField();
    sumField.setBackground(new Color(213, 219, 219));// Alice Blue
    sumField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    sumField.setBackground(new Color(213, 219, 219));// Alice Blue
    sumField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color
    sumField.setEditable(false);

    panel.add(nLabel);
    panel.add(nField);
    panel.add(sumLabel);
    panel.add(sumField);
    panel.add(sumButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Action Listener
    sumButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String nText = nField.getText().trim();
        try {
          int n = Integer.parseInt(nText);
          if (n <= 0)
            throw new NumberFormatException();

          BigInteger sum = BigInteger.ZERO;
          for (int i = 2; i <= n; i += 2) {
            sum = sum.add(BigInteger.valueOf(i));
          }
          sumField.setText(sum.toString());
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter a valid positive integer for N.", "Error",
              JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
          JOptionPane.showMessageDialog(dialog, "The number entered is too large to calculate.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // 14. GCD of Two Numbers
  private void openGCDLCMCalculator() {
    JDialog dialog = new JDialog(this, "GCD & LCM Calculator", true);
    dialog.setSize(400, 250);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JTextField aField = new JTextField(), bField = new JTextField();
    JTextField gcdField = new JTextField(), lcmField = new JTextField();
    gcdField.setEditable(false);
    lcmField.setEditable(false);

    panel.add(new JLabel("Enter First Number:"));
    panel.add(aField);
    panel.add(new JLabel("Enter Second Number:"));
    panel.add(bField);
    panel.add(new JLabel("GCD:"));
    panel.add(gcdField);
    panel.add(new JLabel("LCM:"));
    panel.add(lcmField);

    JButton calculateButton = new JButton("Calculate GCD & LCM");
    calculateButton.setBackground(new Color(194, 91, 60));
    calculateButton.setForeground(Color.WHITE);
    calculateButton.addActionListener(e -> {
      try {
        int a = Integer.parseInt(aField.getText().trim());
        int b = Integer.parseInt(bField.getText().trim());
        if (a < 0 || b < 0)
          throw new NumberFormatException();
        gcdField.setText(String.valueOf(calculateGCD(a, b)));
        lcmField.setText(String.valueOf(calculateLCM(a, b)));
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(dialog, "Enter valid non-negative integers.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    });
    panel.add(calculateButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE);
    backButton.addActionListener(e -> dialog.setVisible(false));
    panel.add(backButton);

    dialog.add(panel);
    dialog.setVisible(true);
  }

  private int calculateGCD(int a, int b) {
    return (b == 0) ? a : calculateGCD(b, a % b);
  }

  private int calculateLCM(int a, int b) {
    return (a * b) / calculateGCD(a, b);
  }

  // 15. Angle Conversion
  private void openAngleConversion() {
    JDialog dialog = new JDialog(this, "Angle Conversion", true);
    dialog.setSize(400, 250);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JLabel angleLabel = new JLabel("Enter Angle:");
    angleLabel.setForeground(Color.BLACK); // Text color for better contrast
    angleLabel.setBackground(new Color(46, 64, 83));

    JTextField angleField = new JTextField();
    angleField.setBackground(new Color(213, 219, 219));// Alice Blue
    angleField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton convertButton = new JButton("Convert");
    convertButton.setBackground(new Color(194, 91, 60));
    convertButton.setForeground(Color.WHITE); // Text color for better contrast

    JLabel radiansLabel = new JLabel("Radians:");
    radiansLabel.setForeground(Color.BLACK); // Text color for better contrast
    radiansLabel.setBackground(new Color(46, 64, 83));

    JTextField radiansField = new JTextField();
    radiansField.setBackground(new Color(213, 219, 219));// Alice Blue
    radiansField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color
    radiansField.setEditable(false);

    JLabel degreesLabel = new JLabel("Degrees:");
    degreesLabel.setForeground(Color.BLACK); // Text color for better contrast
    degreesLabel.setBackground(new Color(46, 64, 83));

    JTextField degreesField = new JTextField();
    degreesField.setBackground(new Color(213, 219, 219));// Alice Blue
    degreesField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    degreesField.setBackground(new Color(213, 219, 219));// Alice Blue
    degreesField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color
    degreesField.setEditable(false);

    panel.add(angleLabel);
    panel.add(angleField);
    panel.add(radiansLabel);
    panel.add(radiansField);
    panel.add(degreesLabel);
    panel.add(degreesField);
    panel.add(convertButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Action Listener for Conversion
    convertButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String angleText = angleField.getText().trim();
        try {
          double angle = Double.parseDouble(angleText);

          // If the angle is greater than 6.28 (2π), it's likely in degrees.
          if (angle > 6.28) {
            // Convert degrees to radians
            double radians = Math.toRadians(angle);
            radiansField.setText(String.format("%.4f", radians));
            degreesField.setText(String.format("%.4f", angle)); // Original input is degrees
          } else {
            // Convert radians to degrees
            double degrees = Math.toDegrees(angle);
            degreesField.setText(String.format("%.4f", degrees));
            radiansField.setText(String.format("%.4f", angle)); // Original input is radians
          }

        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter a valid number for angle.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // statistical Calculations
  private void openStatisticalCalculations() {
    JDialog dialog = new JDialog(this, "Statistical Calculations", true);
    dialog.setSize(600, 500);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout(5, 5));
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));
    panel.setBackground(new Color(173, 216, 230));

    JPanel panel1 = new JPanel();
    panel1.setPreferredSize(new Dimension(dialog.getContentPane().getWidth(), 150));
    panel1.setLayout(new GridLayout(3, 1, 5, 5));
    panel1.setBackground(new Color(173, 216, 230));

    JPanel panel2 = new JPanel();
    panel2.setLayout(new BorderLayout(10, 10));
    panel2.setBackground(new Color(173, 216, 230));

    JPanel panel3 = new JPanel();
    panel3.setLayout(new GridLayout(1, 2, 5, 5));
    panel3.setBackground(new Color(173, 216, 230));

    JLabel instructionLabel = new JLabel("Enter numbers separated by commas or upload a CSV file:");
    instructionLabel.setForeground(Color.BLACK);

    JTextField numbersField = new JTextField();
    numbersField.setBackground(new Color(213, 219, 219));
    numbersField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180)));

    JButton uploadButton = new JButton("Upload CSV");
    uploadButton.setBackground(new Color(194, 91, 60));
    uploadButton.setForeground(Color.WHITE);
    uploadButton.setPreferredSize(new Dimension(panel.getWidth() / 2, 50));

    JButton calculateButton = new JButton("Calculate Statistics");
    calculateButton.setBackground(new Color(194, 91, 60));
    calculateButton.setForeground(Color.WHITE);

    JTextArea resultArea = new JTextArea();
    resultArea.setBackground(new Color(213, 219, 219));
    resultArea.setForeground(Color.BLACK);
    resultArea.setEditable(false);
    resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
    JScrollPane scrollPane = new JScrollPane(resultArea);

    panel1.add(instructionLabel);
    panel1.add(numbersField);
    panel1.add(uploadButton);
    panel2.add(scrollPane, BorderLayout.CENTER);
    panel3.add(calculateButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE);
    backButton.setPreferredSize(new Dimension(100, 50));
    panel3.add(backButton);

    panel.add(panel1, BorderLayout.NORTH);
    panel.add(panel2, BorderLayout.CENTER);
    panel.add(panel3, BorderLayout.SOUTH);

    backButton.addActionListener(e -> dialog.setVisible(false));

    List<Double> numbers = new ArrayList<>();

    // Action Listener for CSV Upload
    uploadButton.addActionListener(e -> {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setDialogTitle("Select a CSV File");
      int result = fileChooser.showOpenDialog(dialog);
      if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        numbers.clear(); // Clear any previous numbers

        try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
          String line;
          while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            for (String value : values) {
              try {
                numbers.add(Double.parseDouble(value.trim()));
              } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Invalid number found in CSV file: " + value, "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
              }
            }
          }
          numbersField.setText(""); // Clear the manual input field to avoid confusion
          JOptionPane.showMessageDialog(dialog, "CSV file loaded successfully.", "Info",
              JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(dialog, "Error reading CSV file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    // Action Listener for Calculate Button
    calculateButton.addActionListener(e -> {
      // If numbersField is not empty, take input from it, else use CSV data
      if (!numbersField.getText().trim().isEmpty()) {
        String input = numbersField.getText().trim();
        numbers.clear(); // Clear any previous numbers

        String[] parts = input.split(",");
        try {
          for (String part : parts) {
            numbers.add(Double.parseDouble(part.trim()));
          }
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter valid numbers separated by commas.", "Error",
              JOptionPane.ERROR_MESSAGE);
          return;
        }
      }

      if (numbers.isEmpty()) {
        JOptionPane.showMessageDialog(dialog, "Please enter numbers or upload a CSV file.", "Error",
            JOptionPane.ERROR_MESSAGE);
        return;
      }

      // Calculate Statistics
      double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
      double mean = sum / numbers.size();
      List<Double> sorted = numbers.stream().sorted().collect(Collectors.toList());
      double median = numbers.size() % 2 == 0
          ? (sorted.get(numbers.size() / 2 - 1) + sorted.get(numbers.size() / 2)) / 2.0
          : sorted.get(numbers.size() / 2);

      // Mode
      double mode = numbers.get(0);
      long maxCount = 1;
      for (double num : numbers) {
        long count = numbers.stream().filter(n -> n == num).count();
        if (count > maxCount) {
          maxCount = count;
          mode = num;
        }
      }

      // Variance and Standard Deviation
      double variance = numbers.stream().mapToDouble(n -> Math.pow(n - mean, 2)).sum() / numbers.size();
      double stdDev = Math.sqrt(variance);

      // Display Results
      StringBuilder sb = new StringBuilder();
      sb.append("Count: ").append(numbers.size()).append("\n");
      sb.append("Sum: ").append(String.format("%.2f", sum)).append("\n");
      sb.append("Mean: ").append(String.format("%.2f", mean)).append("\n");
      sb.append("Median: ").append(String.format("%.2f", median)).append("\n");
      sb.append("Mode: ").append(String.format("%.2f", mode)).append("\n");
      sb.append("Variance: ").append(String.format("%.2f", variance)).append("\n");
      sb.append("Standard Deviation: ").append(String.format("%.2f", stdDev)).append("\n");

      resultArea.setText(sb.toString());
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // 17. Table of a Number
  private void openTableOfNumber() {
    JDialog dialog = new JDialog(this, "Table of a Number", true);
    dialog.setSize(400, 400);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout(10, 10));
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));
    panel.setBackground(new Color(173, 216, 230));

    JPanel panel1 = new JPanel();
    panel1.setLayout(new GridLayout(2, 2, 5, 5));
    panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
    panel1.setBackground(new Color(173, 216, 230));

    JPanel panel2 = new JPanel();
    panel2.setLayout(new BorderLayout(10, 10));
    panel2.setBackground(new Color(173, 216, 230));

    JPanel panel3 = new JPanel();
    panel3.setLayout(new GridLayout(1, 2, 10, 10));
    panel3.setBackground(new Color(173, 216, 230));

    JLabel instructionLabel = new JLabel("Enter the Number :");
    instructionLabel.setForeground(Color.BLACK); // Text color for better contrast
    instructionLabel.setBackground(new Color(46, 64, 83));

    JTextField numberField = new JTextField();
    numberField.setPreferredSize(new Dimension(50, 50));
    numberField.setBackground(new Color(213, 219, 219));// Alice Blue
    numberField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JLabel rangeLabel = new JLabel("Enter the terms you want :");
    rangeLabel.setForeground(Color.BLACK); // Text color for better contrast
    rangeLabel.setBackground(new Color(46, 64, 83));

    JTextField rangeField = new JTextField();
    rangeField.setPreferredSize(new Dimension(50, 50));
    rangeField.setBackground(new Color(213, 219, 219));// Alice Blue
    rangeField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton generateButton = new JButton("Generate Table");
    generateButton.setBackground(new Color(194, 91, 60));
    generateButton.setForeground(Color.WHITE); // Text color for better contrast

    JLabel armstrongLabel = new JLabel("Table is :");
    armstrongLabel.setForeground(Color.BLACK); // Text color for better contrast
    armstrongLabel.setBackground(new Color(46, 64, 83));

    JTextArea tableArea = new JTextArea();
    tableArea.setBackground(new Color(213, 219, 219));// Alice Blue
    tableArea.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    tableArea.setEditable(false);
    tableArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
    JScrollPane scrollPane = new JScrollPane(tableArea);

    panel1.add(instructionLabel);
    panel1.add(numberField);
    panel1.add(rangeLabel);
    panel1.add(rangeField);
    panel2.add(armstrongLabel, BorderLayout.NORTH);
    panel2.add(scrollPane, BorderLayout.CENTER);
    panel3.add(generateButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel3.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Adjust Layout
    panel.add(panel1, BorderLayout.NORTH);
    panel.add(panel2, BorderLayout.CENTER);
    panel.add(panel3, BorderLayout.SOUTH);

    // Action Listener
    generateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String numberText = numberField.getText().trim();
        String rangeText = rangeField.getText().trim();
        try {
          int number = Integer.parseInt(numberText);
          int range = Integer.parseInt(rangeText);
          if (range <= 0)
            throw new NumberFormatException();

          StringBuilder sb = new StringBuilder();
          for (int i = 1; i <= range; i++) {
            sb.append(number).append(" x ").append(i).append(" = ").append(number * i).append("\n");
          }
          tableArea.setText(sb.toString());
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter valid integers for number and range.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // 18. Complex Numbers Calculations
  private void openComplexNumbersCalculator() {
    JDialog dialog = new JDialog(this, "Complex Numbers Calculations", true);
    dialog.setSize(600, 500);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(8, 2, 10, 10));
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));
    panel.setBackground(new Color(173, 216, 230));

    JLabel aRealLabel = new JLabel("Complex A Real:");
    aRealLabel.setForeground(Color.BLACK); // Text color for better contrast
    aRealLabel.setBackground(new Color(46, 64, 83));

    JTextField aRealField = new JTextField();
    aRealField.setBackground(new Color(213, 219, 219));// Alice Blue
    aRealField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JLabel aImagLabel = new JLabel("Complex A Imaginary:");
    aImagLabel.setForeground(Color.BLACK); // Text color for better contrast
    aImagLabel.setBackground(new Color(46, 64, 83));

    JTextField aImagField = new JTextField();
    aImagField.setBackground(new Color(213, 219, 219));// Alice Blue
    aImagField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JLabel bRealLabel = new JLabel("Complex B Real:");
    bRealLabel.setForeground(Color.BLACK); // Text color for better contrast
    bRealLabel.setBackground(new Color(46, 64, 83));

    JTextField bRealField = new JTextField();
    bRealField.setBackground(new Color(213, 219, 219));// Alice Blue
    bRealField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JLabel bImagLabel = new JLabel("Complex B Imaginary:");
    bImagLabel.setForeground(Color.BLACK); // Text color for better contrast
    bImagLabel.setBackground(new Color(46, 64, 83));

    JTextField bImagField = new JTextField();
    bImagField.setBackground(new Color(213, 219, 219));// Alice Blue
    bImagField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton addButton = new JButton("Add");
    addButton.setBackground(new Color(194, 91, 60));
    addButton.setForeground(Color.WHITE); // Text color for better contrast

    JButton subtractButton = new JButton("Subtract");
    subtractButton.setBackground(new Color(194, 91, 60));
    subtractButton.setForeground(Color.WHITE); // Text color for better contrast

    JButton multiplyButton = new JButton("Multiply");
    multiplyButton.setBackground(new Color(194, 91, 60));
    multiplyButton.setForeground(Color.WHITE); // Text color for better contrast

    JButton divideButton = new JButton("Divide");
    divideButton.setBackground(new Color(194, 91, 60));
    divideButton.setForeground(Color.WHITE); // Text color for better contrast

    JLabel resultLabel = new JLabel("Result:");
    resultLabel.setBackground(new Color(194, 91, 60));
    resultLabel.setForeground(Color.BLACK); // Text color for better contrast

    JTextField resultField = new JTextField();
    resultField.setBackground(new Color(213, 219, 219));// Alice Blue
    resultField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    resultField.setEditable(false);

    panel.add(aRealLabel);
    panel.add(aRealField);
    panel.add(aImagLabel);
    panel.add(aImagField);
    panel.add(bRealLabel);
    panel.add(bRealField);
    panel.add(bImagLabel);
    panel.add(bImagField);
    panel.add(addButton);
    panel.add(subtractButton);
    panel.add(multiplyButton);
    panel.add(divideButton);
    panel.add(resultLabel);
    panel.add(resultField);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 100));
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });
    panel.add(new JLabel(""));
    panel.add(backButton);

    // Action Listeners
    addButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ComplexNumber a = getComplexNumber(aRealField, aImagField, "A");
        ComplexNumber b = getComplexNumber(bRealField, bImagField, "B");
        if (a != null && b != null) {
          ComplexNumber result = a.add(b);
          resultField.setText(result.toString());
        }
      }
    });

    subtractButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ComplexNumber a = getComplexNumber(aRealField, aImagField, "A");
        ComplexNumber b = getComplexNumber(bRealField, bImagField, "B");
        if (a != null && b != null) {
          ComplexNumber result = a.subtract(b);
          resultField.setText(result.toString());
        }
      }
    });

    multiplyButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ComplexNumber a = getComplexNumber(aRealField, aImagField, "A");
        ComplexNumber b = getComplexNumber(bRealField, bImagField, "B");
        if (a != null && b != null) {
          ComplexNumber result = a.multiply(b);
          resultField.setText(result.toString());
        }
      }
    });

    divideButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ComplexNumber a = getComplexNumber(aRealField, aImagField, "A");
        ComplexNumber b = getComplexNumber(bRealField, bImagField, "B");
        if (a != null && b != null) {
          try {
            ComplexNumber result = a.divide(b);
            resultField.setText(result.toString());
          } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(dialog, "Cannot divide by zero complex number.", "Error",
                JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // Helper method to get complex number from fields
  private ComplexNumber getComplexNumber(JTextField realField, JTextField imagField, String label) {
    try {
      double real = Double.parseDouble(realField.getText().trim());
      double imag = Double.parseDouble(imagField.getText().trim());
      return new ComplexNumber(real, imag);
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(this, "Please enter valid numbers for Complex " + label + ".", "Error",
          JOptionPane.ERROR_MESSAGE);
      return null;
    }
  }

  // ComplexNumber class
  class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
      this.real = real;
      this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber b) {
      return new ComplexNumber(this.real + b.real, this.imaginary + b.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber b) {
      return new ComplexNumber(this.real - b.real, this.imaginary - b.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber b) {
      double realPart = this.real * b.real - this.imaginary * b.imaginary;
      double imagPart = this.real * b.imaginary + this.imaginary * b.real;
      return new ComplexNumber(realPart, imagPart);
    }

    public ComplexNumber divide(ComplexNumber b) {
      double denominator = b.real * b.real + b.imaginary * b.imaginary;
      if (denominator == 0) {
        throw new ArithmeticException("Division by zero");
      }
      double realPart = (this.real * b.real + this.imaginary * b.imaginary) / denominator;
      double imagPart = (this.imaginary * b.real - this.real * b.imaginary) / denominator;
      return new ComplexNumber(realPart, imagPart);
    }

    @Override
    public String toString() {
      if (imaginary >= 0) {
        return real + " + " + imaginary + "i";
      } else {
        return real + " - " + (-imaginary) + "i";
      }
    }
  }

  // 19. Prime Numbers
  private void openPrimeNumbers() {
    JDialog dialog = new JDialog(this, "Prime Numbers", true);
    dialog.setSize(400, 400);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout(10, 10));
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));
    panel.setBackground(new Color(173, 216, 230));

    JPanel panel1 = new JPanel();
    panel1.setPreferredSize(new Dimension(100, 100));

    panel1.setLayout(new BorderLayout(10, 10));
    panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
    panel1.setBackground(new Color(173, 216, 230));

    JPanel panel2 = new JPanel();
    panel2.setLayout(new BorderLayout(10, 10));
    panel2.setBackground(new Color(173, 216, 230));

    JPanel panel3 = new JPanel();
    panel3.setLayout(new GridLayout(1, 2, 10, 10));
    panel3.setBackground(new Color(173, 216, 230));

    JLabel instructionLabel = new JLabel("Enter the range (N) from 1 :");
    instructionLabel.setForeground(Color.BLACK); // Text color for better contrast
    instructionLabel.setBackground(new Color(46, 64, 83));

    JTextField rangeField = new JTextField();
    rangeField.setPreferredSize(new Dimension(50, 50));
    rangeField.setBackground(new Color(213, 219, 219));// Alice Blue
    rangeField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton generateButton = new JButton("Generate Primes");
    generateButton.setBackground(new Color(194, 91, 60));
    generateButton.setForeground(Color.WHITE); // Text color for better contrast

    JLabel primesLabel = new JLabel("Prime numbers are :");
    primesLabel.setForeground(Color.BLACK); // Text color for better contrast
    primesLabel.setBackground(new Color(46, 64, 83));

    JTextArea primesArea = new JTextArea();
    primesArea.setBackground(new Color(213, 219, 219));// Alice Blue
    primesArea.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    primesArea.setEditable(false);
    primesArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
    JScrollPane scrollPane = new JScrollPane(primesArea);

    panel1.add(instructionLabel, BorderLayout.NORTH);
    panel1.add(rangeField, BorderLayout.SOUTH);
    panel2.add(primesLabel, BorderLayout.NORTH);
    panel2.add(scrollPane, BorderLayout.CENTER);
    panel3.add(generateButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel3.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Adjust Layout
    panel.add(panel1, BorderLayout.NORTH);
    panel.add(panel2, BorderLayout.CENTER);
    panel.add(panel3, BorderLayout.SOUTH);

    // Action Listener
    generateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String rangeText = rangeField.getText().trim();
        try {
          int n = Integer.parseInt(rangeText);
          if (n < 2) {
            JOptionPane.showMessageDialog(dialog, "Please enter an integer greater than or equal to 2.",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
          }
          List<Integer> primes = sieveOfEratosthenes(n);
          StringBuilder sb = new StringBuilder();
          for (int prime : primes) {
            sb.append(prime).append("\n");
          }
          primesArea.setText(sb.toString());
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter a valid integer.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // Helper method to generate primes using Sieve of Eratosthenes
  private List<Integer> sieveOfEratosthenes(int n) {
    boolean[] isPrime = new boolean[n + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;
    for (int i = 2; i * i <= n; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= n; j += i) {
          isPrime[j] = false;
        }
      }
    }
    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
      if (isPrime[i])
        primes.add(i);
    }
    return primes;
  }

  // 20. Armstrong Numbers
  private void openArmstrongNumbers() {
    JDialog dialog = new JDialog(this, "Armstrong Numbers", true);
    dialog.setSize(400, 400);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout(10, 10));
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));
    panel.setBackground(new Color(173, 216, 230));

    JPanel panel1 = new JPanel();
    panel1.setLayout(new BorderLayout(10, 10));
    panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
    panel1.setBackground(new Color(173, 216, 230));

    JPanel panel2 = new JPanel();
    panel2.setLayout(new BorderLayout(10, 10));
    panel2.setBackground(new Color(173, 216, 230));

    JPanel panel3 = new JPanel();
    panel3.setLayout(new GridLayout(1, 2, 10, 10));
    panel3.setBackground(new Color(173, 216, 230));

    JLabel instructionLabel = new JLabel("Enter the range (N) from 1 :");
    instructionLabel.setForeground(Color.BLACK); // Text color for better contrast
    instructionLabel.setBackground(new Color(46, 64, 83));

    JTextField rangeField = new JTextField();
    rangeField.setPreferredSize(new Dimension(50, 50));
    rangeField.setBackground(new Color(213, 219, 219));// Alice Blue
    rangeField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton generateButton = new JButton("Generate Armstrong");
    generateButton.setBackground(new Color(194, 91, 60));
    generateButton.setForeground(Color.WHITE); // Text color for better contrast

    JLabel armstrongLabel = new JLabel("Armstrongs numbers are :");
    armstrongLabel.setForeground(Color.BLACK); // Text color for better contrast
    armstrongLabel.setBackground(new Color(46, 64, 83));

    JTextArea armstrongArea = new JTextArea();
    armstrongArea.setBackground(new Color(213, 219, 219));// Alice Blue
    armstrongArea.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    armstrongArea.setEditable(false);
    armstrongArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
    JScrollPane scrollPane = new JScrollPane(armstrongArea);

    panel1.add(instructionLabel, BorderLayout.NORTH);
    panel1.add(rangeField, BorderLayout.SOUTH);
    panel2.add(armstrongLabel, BorderLayout.NORTH);
    panel2.add(scrollPane, BorderLayout.CENTER);
    panel3.add(generateButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel3.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Adjust Layout
    panel.add(panel1, BorderLayout.NORTH);
    panel.add(panel2, BorderLayout.CENTER);
    panel.add(panel3, BorderLayout.SOUTH);

    // Action Listener
    generateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String rangeText = rangeField.getText().trim();
        try {
          int n = Integer.parseInt(rangeText);
          if (n < 0) {
            JOptionPane.showMessageDialog(dialog, "Please enter a non-negative integer.", "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
          }
          List<Integer> armstrongNumbers = findArmstrongNumbers(n);
          StringBuilder sb = new StringBuilder();
          for (int num : armstrongNumbers) {
            sb.append(num).append("\n");
          }
          armstrongArea.setText(sb.toString());
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter a valid integer.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // Helper method to find Armstrong numbers up to n
  private List<Integer> findArmstrongNumbers(int n) {
    List<Integer> armstrong = new ArrayList<>();
    for (int num = 0; num <= n; num++) {
      if (isArmstrong(num)) {
        armstrong.add(num);
      }
    }
    return armstrong;
  }

  // Helper method to check if a number is an Armstrong number
  private boolean isArmstrong(int num) {
    String str = String.valueOf(num);
    int len = str.length();
    int sum = 0;
    for (char c : str.toCharArray()) {
      sum += Math.pow(Character.getNumericValue(c), len);
    }
    return sum == num;
  }

  // 21. Palindrome Checker
  private void openPalindromeChecker() {
    JDialog dialog = new JDialog(this, "Palindrome Checker", true);
    dialog.setSize(400, 250);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JLabel numberLabel = new JLabel("Enter Number or Text:");
    numberLabel.setForeground(Color.BLACK); // Text color for better contrast
    numberLabel.setBackground(new Color(46, 64, 83));

    JTextField inputField = new JTextField();
    inputField.setBackground(new Color(213, 219, 219));// Alice Blue
    inputField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton checkButton = new JButton("Check Palindrome");
    checkButton.setBackground(new Color(194, 91, 60));
    checkButton.setForeground(Color.WHITE); // Text color for better contrast

    JLabel resultLabel = new JLabel("Result:");
    resultLabel.setForeground(Color.BLACK); // Text color for better contrast
    resultLabel.setBackground(new Color(46, 64, 83));

    JTextField resultField = new JTextField();
    resultField.setBackground(new Color(213, 219, 219));// Alice Blue
    resultField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color
    resultField.setEditable(false);

    panel.add(numberLabel);
    panel.add(inputField);
    panel.add(resultLabel);
    panel.add(resultField);
    panel.add(checkButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Action Listener
    checkButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String input = inputField.getText().trim();
        if (input.isEmpty()) {
          JOptionPane.showMessageDialog(dialog, "Please enter a number or text.", "Error",
              JOptionPane.ERROR_MESSAGE);
          return;
        }
        String reversed = new StringBuilder(input).reverse().toString();
        if (input.equalsIgnoreCase(reversed)) {
          resultField.setText("Palindrome");
        } else {
          resultField.setText("Not a Palindrome");
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // method to calculate age
  private void openCalculateAge() {
    JDialog dialog = new JDialog(this, "Calculate Age", true);
    dialog.setSize(500, 300);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JLabel dobLabel = new JLabel("Enter Date of Birth (yyyy-mm-dd):");
    dobLabel.setForeground(Color.BLACK);

    JTextField dobField = new JTextField();
    dobField.setBackground(new Color(213, 219, 219));
    dobField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180)));

    JButton calculateButton = new JButton("Calculate Age");
    calculateButton.setBackground(new Color(194, 91, 60));
    calculateButton.setForeground(Color.WHITE);

    JLabel ageLabel = new JLabel("Age:");
    ageLabel.setForeground(Color.BLACK);

    JTextField ageField = new JTextField();
    ageField.setBackground(new Color(213, 219, 219));
    ageField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180)));
    ageField.setEditable(false);

    panel.add(dobLabel);
    panel.add(dobField);
    panel.add(ageLabel);
    panel.add(ageField);
    panel.add(calculateButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE);
    backButton.setPreferredSize(new Dimension(100, 50));

    panel.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    calculateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String dobText = dobField.getText().trim();
        try {
          LocalDate dob = LocalDate.parse(dobText);
          LocalDate currentDate = LocalDate.now();

          if (dob.isAfter(currentDate)) {
            JOptionPane.showMessageDialog(dialog, "Date of birth cannot be in the future.", "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
          }

          Period period = Period.between(dob, currentDate);
          long days = ChronoUnit.DAYS.between(dob.plusYears(period.getYears()), currentDate);

          String ageText = period.getYears() + " years and " + days + " days";
          ageField.setText(ageText);
        } catch (DateTimeParseException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter a valid date in yyyy-mm-dd format.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // 17. Angle Between Hour and Minute Hand
  private void openClockAngleCalculator() {
    JDialog dialog = new JDialog(this, "Angle Between Hour and Minute Hand", true);
    dialog.setSize(400, 400);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JLabel hourLabel = new JLabel("Enter Hours (1-12):");
    hourLabel.setForeground(Color.BLACK);

    JTextField hourField = new JTextField();
    hourField.setBackground(new Color(213, 219, 219));
    hourField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180)));

    JLabel minuteLabel = new JLabel("Enter Minutes (0-59):");
    minuteLabel.setForeground(Color.BLACK);

    JTextField minuteField = new JTextField();
    minuteField.setBackground(new Color(213, 219, 219));
    minuteField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180)));

    JButton calculateButton = new JButton("Calculate Angle");
    calculateButton.setBackground(new Color(194, 91, 60));
    calculateButton.setForeground(Color.WHITE);

    JLabel resultLabel = new JLabel("Angle:");
    resultLabel.setForeground(Color.BLACK);

    JTextField resultField = new JTextField();
    resultField.setBackground(new Color(213, 219, 219));
    resultField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180)));
    resultField.setEditable(false);

    panel.add(hourLabel);
    panel.add(hourField);
    panel.add(minuteLabel);
    panel.add(minuteField);
    panel.add(resultLabel);
    panel.add(resultField);
    panel.add(calculateButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    calculateButton.addActionListener(e -> {
      try {
        int hours = Integer.parseInt(hourField.getText().trim());
        int minutes = Integer.parseInt(minuteField.getText().trim());

        if (hours < 1 || hours > 12 || minutes < 0 || minutes > 59) {
          JOptionPane.showMessageDialog(dialog, "Please enter valid hours (1-12) and minutes (0-59).", "Error",
              JOptionPane.ERROR_MESSAGE);
          return;
        }

        // Calculate the angle between hour and minute hands
        double hourAngle = (hours % 12 + minutes / 60.0) * 30;
        double minuteAngle = minutes * 6;
        double angle = Math.abs(hourAngle - minuteAngle);
        angle = Math.min(angle, 360 - angle); // Choose the smaller angle

        resultField.setText(String.format("%.2f degrees", angle));

      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(dialog, "Please enter valid numeric values for hours and minutes.", "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  private void checkNumberProperties() {
    JDialog dialog = new JDialog(this, "Number Properties", true);
    dialog.setSize(400, 400);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JLabel numberLabel = new JLabel("Enter Number:");
    JTextField numberField = new JTextField();
    numberField.setBackground(new Color(213, 219, 219));
    numberField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180)));

    JLabel primeLabel = new JLabel("Is Prime:");
    JTextField primeField = new JTextField();
    primeField.setEditable(false);
    primeField.setBackground(new Color(213, 219, 219));

    JLabel armstrongLabel = new JLabel("Is Armstrong:");
    JTextField armstrongField = new JTextField();
    armstrongField.setEditable(false);
    armstrongField.setBackground(new Color(213, 219, 219));

    JButton checkButton = new JButton("Check");
    checkButton.setBackground(new Color(194, 91, 60));
    checkButton.setForeground(Color.WHITE);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE);

    panel.add(numberLabel);
    panel.add(numberField);
    panel.add(primeLabel);
    panel.add(primeField);
    panel.add(armstrongLabel);
    panel.add(armstrongField);
    panel.add(checkButton);
    panel.add(backButton);

    checkButton.addActionListener(e -> {
      String numberText = numberField.getText().trim();
      if (!numberText.matches("\\d+")) {
        JOptionPane.showMessageDialog(dialog, "Please enter a valid positive integer.", "Error",
            JOptionPane.ERROR_MESSAGE);
        return;
      }

      int number = Integer.parseInt(numberText);
      primeField.setText(isPrime(number) ? "Yes" : "No");
      armstrongField.setText(isArmstrong(number) ? "Yes" : "No");
    });

    backButton.addActionListener(e -> dialog.setVisible(false));

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // Method to check if a number is prime
  private boolean isPrime(int num) {
    if (num <= 1)
      return false;
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0)
        return false;
    }
    return true;
  }

  // check number present in fibonacci series
  private void openFibonacciChecker() {
    JDialog dialog = new JDialog(this, "Checks whether the number is present in fibonacci series", true);
    dialog.setSize(400, 200);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    panel.setBackground(new Color(173, 216, 230));

    JTextField numberField = new JTextField();
    JTextField resultField = new JTextField();
    resultField.setEditable(false);

    panel.add(new JLabel("Enter Number:"));
    panel.add(numberField);
    panel.add(new JLabel("Result:"));
    panel.add(resultField);

    JButton checkButton = new JButton("Check Fibonacci");
    checkButton.setBackground(new Color(194, 91, 60));
    checkButton.setForeground(Color.WHITE);
    checkButton.addActionListener(e -> {
      try {
        int number = Integer.parseInt(numberField.getText().trim());
        if (number < 0) {
          resultField.setText("Negative numbers not valid");
        } else {
          boolean isFibonacci = checkFibonacci(number);
          resultField.setText(isFibonacci ? "Yes" : "No");
        }
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(dialog, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    });

    panel.add(checkButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE);
    backButton.addActionListener(e -> dialog.setVisible(false));
    panel.add(backButton);

    dialog.add(panel);
    dialog.setVisible(true);
  }

  private boolean checkFibonacci(int number) {
    int a = 0, b = 1;
    while (a < number) {
      int temp = a;
      a = b;
      b = temp + b;
    }
    return a == number;
  }

  // 22. Fibonacci Series
  private void openFibonacciSeries() {
    JDialog dialog = new JDialog(this, "Fibonacci Series", true);
    dialog.setSize(400, 400);
    dialog.setLocationRelativeTo(this);
    dialog.getContentPane().setBackground(new Color(234, 237, 237));

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout(10, 10));
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));
    panel.setBackground(new Color(173, 216, 230));

    JPanel panel1 = new JPanel();
    panel1.setLayout(new GridLayout(1, 2, 5, 5));
    panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
    panel1.setBackground(new Color(173, 216, 230));

    JPanel panel2 = new JPanel();
    panel2.setLayout(new BorderLayout(10, 10));
    panel2.setBackground(new Color(173, 216, 230));

    JPanel panel3 = new JPanel();
    panel3.setLayout(new GridLayout(1, 2, 10, 10));
    panel3.setBackground(new Color(173, 216, 230));

    JLabel instructionLabel = new JLabel("Enter the number of terms :");
    instructionLabel.setForeground(Color.BLACK); // Text color for better contrast
    instructionLabel.setBackground(new Color(46, 64, 83));

    JTextField termsField = new JTextField();
    termsField.setPreferredSize(new Dimension(50, 50));
    termsField.setBackground(new Color(213, 219, 219));// Alice Blue
    termsField.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    JButton generateButton = new JButton("Generate Fibonacci");
    generateButton.setBackground(new Color(194, 91, 60));
    generateButton.setForeground(Color.WHITE); // Text color for better contrast

    JLabel primesLabel = new JLabel("Fibonacci numbers are :");
    primesLabel.setForeground(Color.BLACK); // Text color for better contrast
    primesLabel.setBackground(new Color(46, 64, 83));

    JTextArea fibonacciArea = new JTextArea();
    fibonacciArea.setBackground(new Color(213, 219, 219));// Alice Blue
    fibonacciArea.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Border color

    fibonacciArea.setEditable(false);
    fibonacciArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
    JScrollPane scrollPane = new JScrollPane(fibonacciArea);

    panel1.add(instructionLabel, BorderLayout.NORTH);
    panel1.add(termsField, BorderLayout.SOUTH);
    panel2.add(primesLabel, BorderLayout.NORTH);
    panel2.add(scrollPane, BorderLayout.CENTER);
    panel3.add(generateButton);

    JButton backButton = new JButton("Back");
    backButton.setBackground(new Color(194, 91, 60));
    backButton.setForeground(Color.WHITE); // Text color for better contrast
    backButton.setPreferredSize(new Dimension(100, 50));

    panel3.add(backButton);
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    // Adjust Layout
    panel.add(panel1, BorderLayout.NORTH);
    panel.add(panel2, BorderLayout.CENTER);
    panel.add(panel3, BorderLayout.SOUTH);

    // Action Listener
    generateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String termsText = termsField.getText().trim();
        try {
          int n = Integer.parseInt(termsText);
          if (n <= 0) {
            JOptionPane.showMessageDialog(dialog, "Please enter a positive integer.", "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
          }
          List<Long> fibonacci = generateFibonacci(n);
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < fibonacci.size(); i++) {
            sb.append("Term ").append(i + 1).append(": ").append(fibonacci.get(i)).append("\n");
          }
          fibonacciArea.setText(sb.toString());
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "Please enter a valid integer.", "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    dialog.add(panel);
    dialog.setVisible(true);
  }

  // Helper method to generate Fibonacci series
  private List<Long> generateFibonacci(int n) {
    List<Long> fib = new ArrayList<>();
    if (n >= 1)
      fib.add(0L);
    if (n >= 2)
      fib.add(1L);
    for (int i = 3; i <= n; i++) {
      long next = fib.get(i - 3) + fib.get(i - 2);
      fib.add(next);
    }
    return fib;
  }

  // Main method
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new AllInOneCalculator2().setVisible(true);
      }
    });
  }
}
