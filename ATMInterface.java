import javax.swing.*;
import java.awt.*;

public class ATMInterface {

    private double balance = 100000.00; // Sample initial balance

    public ATMInterface() {
        JFrame frame = new JFrame("ATM Interface");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));

        JLabel balanceLabel = new JLabel("Balance: $" + balance);
        frame.add(balanceLabel);

        JButton checkBalanceButton = new JButton("Check Balance");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton exitButton = new JButton("Exit");

        frame.add(checkBalanceButton);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(exitButton);

        // Check Balance Action
        checkBalanceButton.addActionListener(_ -> JOptionPane.showMessageDialog(frame, "Your balance is: $" + balance));

        // Deposit Action
        depositButton.addActionListener(_ -> {
            String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to deposit:");
            if (amountStr != null) {
                double amount = Double.parseDouble(amountStr);
                balance += amount;
                JOptionPane.showMessageDialog(frame, "Deposited: $" + amount);
            }
        });

        // Withdraw Action
        withdrawButton.addActionListener(_ -> {
            String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to withdraw:");
            if (amountStr != null) {
                double amount = Double.parseDouble(amountStr);
                if (amount <= balance) {
                    balance -= amount;
                    JOptionPane.showMessageDialog(frame, "Withdrew: $" + amount);
                } else {
                    JOptionPane.showMessageDialog(frame, "Insufficient funds!");
                }
            }
        });

        // Exit Action
        exitButton.addActionListener(_ -> {
            JOptionPane.showMessageDialog(frame, "Thank you for using the ATM!");
            System.exit(0);
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ATMInterface();
    }
}
