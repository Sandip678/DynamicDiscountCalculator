import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DynamicDiscountCalculator extends JFrame {

    public DynamicDiscountCalculator() {

        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 100);
        setTitle("Dynamic Discount Calculator");
        setLayout(null);
        getContentPane().setBackground(new Color(227, 225, 225));

        JLabel textTitle = new JLabel("Dynamic Discount Calculator");
        textTitle.setBounds(40, 20, 360, 25);
        textTitle.setFont(new Font("Arials", Font.BOLD, 22));
        textTitle.setForeground(new Color(0, 73, 9, 187));
        add(textTitle);

        JPanel line = new JPanel();
        line.setBounds(40, 50, 300, 2);
        line.setBackground(new Color(0, 73, 9, 187));
        add(line);

        JLabel originalPrice = new JLabel("Original Price :");
        originalPrice.setBounds(35, 70, 200, 18);
        originalPrice.setFont(new Font("Arials", Font.PLAIN, 16));
        add(originalPrice);

        JTextField priceField = new JTextField();
        priceField.setBounds(35, 90, 305, 25);
        priceField.setFont(new Font("Arials", Font.BOLD, 16));
        add(priceField);

        JLabel discountPercentage = new JLabel("Discount Percentage :");
        discountPercentage.setBounds(35, 140, 200, 18);
        discountPercentage.setFont(new Font("Arials", Font.PLAIN, 16));
        add(discountPercentage);

        JTextField percentField = new JTextField();
        percentField.setBounds(35, 160, 305, 25);
        percentField.setFont(new Font("Arials", Font.BOLD, 16));
        add(percentField);

        JLabel taxPercentage = new JLabel("Tax Percentage :");
        taxPercentage.setBounds(35, 210, 200, 18);
        taxPercentage.setFont(new Font("Arials", Font.PLAIN, 16));
        add(taxPercentage);

        JTextField taxField = new JTextField();
        taxField.setBounds(35, 230, 305, 25);
        taxField.setFont(new Font("Arials", Font.BOLD, 16));
        add(taxField);

        JLabel currency = new JLabel("Currency :");
        currency.setBounds(35, 280, 200, 18);
        currency.setFont(new Font("Arials", Font.PLAIN, 16));
        add(currency);

        String[] currencies = {"USD", "EUR", "INR", "GBP", "JPY"};
        JComboBox<String> currencyChooser = new JComboBox<>(currencies);
        currencyChooser.setBounds(35, 300, 305, 25);
        currencyChooser.setFont(new Font("Arials", Font.BOLD, 16));
        add(currencyChooser);

        JLabel finalPrice = new JLabel("Final Price");
        finalPrice.setBounds(150, 350, 100, 18);
        finalPrice.setFont(new Font("Arials", Font.PLAIN, 16));
        add(finalPrice);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(120, 375, 160, 30);
        resultLabel.setFont(new Font("Arials", Font.BOLD, 25));
        resultLabel.setForeground(new Color(0, 73, 9, 187));
        add(resultLabel);

        // New JLabel for Saved Amount
        JLabel savedLabel = new JLabel("");
        savedLabel.setBounds(130, 405, 200, 20);
        savedLabel.setFont(new Font("Arials", Font.PLAIN, 14));
        //savedLabel.setForeground(new Color(0, 102, 204));
        add(savedLabel);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(0, 450, 400, 30);
        calculateButton.setFont(new Font("Arials", Font.BOLD, 16));
        calculateButton.setBackground(new Color(0, 73, 9, 187));
        calculateButton.setForeground(Color.WHITE);
        add(calculateButton);

        // Action Listener for Calculate Button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double originalPrice = Double.parseDouble(priceField.getText());
                    double discountPercentage = Double.parseDouble(percentField.getText());
                    double taxPercentage = Double.parseDouble(taxField.getText());

                    // Calculate Discounted Price
                    double discountAmount = (discountPercentage / 100) * originalPrice;
                    double priceAfterDiscount = originalPrice - discountAmount;

                    // Calculate Tax
                    double taxAmount = (taxPercentage / 100) * priceAfterDiscount;

                    // Final Price
                    double finalPrice = priceAfterDiscount + taxAmount;

                    // Get selected currency
                    String selectedCurrency = (String) currencyChooser.getSelectedItem();

                    // Display final price with currency
                    resultLabel.setText(String.format("%.2f %s", finalPrice, selectedCurrency));

                    // Display Saved Amount
                    savedLabel.setText(String.format("%.2f %s saved", discountAmount, selectedCurrency));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(DynamicDiscountCalculator.this,
                            "Please enter valid numeric values!",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new DynamicDiscountCalculator();
    }
}
