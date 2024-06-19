package ordering;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {
    public MainPage() {
        setTitle("Starbucks 주문 시스템");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(1, 113, 67));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(null);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/logo.png"));
        Image logoImage = logoIcon.getImage();
        Image scaledLogoImage = logoImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(30, 100, 500, 500);
        panel.add(logoLabel);

        JLabel textLabel = new JLabel("<html>커피 이상의<br>특별한 경험을 소개합니다.</html>", SwingConstants.CENTER);
        textLabel.setFont(new Font("standard", Font.BOLD, 40));
        textLabel.setForeground(Color.WHITE);
        textLabel.setBounds(400, 130, 600, 300);
        panel.add(textLabel);

        JButton loginButton = new JButton("로그인");
        loginButton.setBounds(480, 390, 120, 35);
        loginButton.setFont(new Font("standard", Font.BOLD, 16));
        loginButton.setBackground(new Color(242, 241, 240));
        loginButton.setForeground(new Color(2, 161, 96));
        panel.add(loginButton);

        JButton registerButton = new JButton("회원가입");
        registerButton.setBounds(650, 390, 120, 35);
        registerButton.setFont(new Font("standard", Font.BOLD, 16));
        registerButton.setBackground(new Color(242, 241, 240));
        registerButton.setForeground(new Color(18, 63, 41));
        panel.add(registerButton);

        JButton adminButton = new JButton("관리자");
        adminButton.setBounds(820, 390, 120, 35);
        adminButton.setFont(new Font("standard", Font.BOLD, 16));
        adminButton.setBackground(new Color(242, 241, 240));
        adminButton.setForeground(new Color(18, 63, 41));
        panel.add(adminButton);

        loginButton.addActionListener(e -> new LoginPage().setVisible(true));
        registerButton.addActionListener(e -> new SignUpPage().setVisible(true));
        // adminButton.addActionListener(e -> new AdminLoginFrame().setVisible(true));

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainPage().setVisible(true));
    }
}

