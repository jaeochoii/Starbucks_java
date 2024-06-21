package ordering;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage extends JFrame {
    public SignUpPage() {
        setTitle("회원가입");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(null);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/mini_logo.png"));
        Image logoImage = logoIcon.getImage();
        Image scaledLogoImage = logoImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(50, 50, 100, 100);
        panel.add(logoLabel);

        JLabel welcomeLabel = new JLabel("<html>고객님<br>환영합니다!</html>");
        welcomeLabel.setFont(new Font("pretendard", Font.BOLD, 34));
        welcomeLabel.setBounds(50, 170, 300, 100);
        panel.add(welcomeLabel);

        JLabel idLabel = new JLabel("아이디:");
        JTextField idField = new JTextField();
        JButton checkButton = new JButton("중복확인");
        idLabel.setBounds(300, 150, 100, 30);
        idField.setBounds(400, 150, 200, 30);
        checkButton.setBounds(610, 150, 100, 30);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(checkButton);

        JLabel pwLabel = new JLabel("비밀번호:");
        JPasswordField pwField = new JPasswordField();
        pwLabel.setBounds(300, 200, 100, 30);
        pwField.setBounds(400, 200, 200, 30);
        panel.add(pwLabel);
        panel.add(pwField);

        JLabel pwConfirmLabel = new JLabel("비밀번호 확인:");
        JPasswordField pwConfirmField = new JPasswordField();
        pwConfirmLabel.setBounds(300, 250, 100, 30);
        pwConfirmField.setBounds(400, 250, 200, 30);
        panel.add(pwConfirmLabel);
        panel.add(pwConfirmField);

        JLabel nameLabel = new JLabel("이름:");
        JTextField nameField = new JTextField();
        nameLabel.setBounds(300, 300, 100, 30);
        nameField.setBounds(400, 300, 200, 30);
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel dobLabel = new JLabel("생년월일:");
        JTextField yearField = new JTextField();
        JTextField monthField = new JTextField();
        JTextField dayField = new JTextField();
        JLabel yearLabel = new JLabel("년");
        JLabel monthLabel = new JLabel("월");
        JLabel dayLabel = new JLabel("일");
        dobLabel.setBounds(300, 350, 100, 30);
        yearField.setBounds(400, 350, 60, 30);
        yearLabel.setBounds(460, 350, 20, 30);
        monthField.setBounds(480, 350, 40, 30);
        monthLabel.setBounds(520, 350, 20, 30);
        dayField.setBounds(540, 350, 40, 30);
        dayLabel.setBounds(580, 350, 20, 30);
        panel.add(dobLabel);
        panel.add(yearField);
        panel.add(yearLabel);
        panel.add(monthField);
        panel.add(monthLabel);
        panel.add(dayField);
        panel.add(dayLabel);

        JLabel phoneLabel = new JLabel("핸드폰 번호:");
        JTextField phoneField1 = new JTextField("010");
        JTextField phoneField2 = new JTextField();
        JTextField phoneField3 = new JTextField();
        JLabel dashLabel1 = new JLabel("-");
        JLabel dashLabel2 = new JLabel("-");

        phoneLabel.setBounds(300, 400, 100, 30);
        phoneField1.setBounds(400, 400, 40, 30);
        dashLabel1.setBounds(445, 400, 10, 30);
        phoneField2.setBounds(460, 400, 60, 30);
        dashLabel2.setBounds(525, 400, 10, 30);
        phoneField3.setBounds(540, 400, 60, 30);

        panel.add(phoneLabel);
        panel.add(phoneField1);
        panel.add(dashLabel1);
        panel.add(phoneField2);
        panel.add(dashLabel2);
        panel.add(phoneField3);

        JButton registerButton = new JButton("회원가입 완료");
        registerButton.setBounds(400, 500, 160, 35);
        registerButton.setFont(new Font("pretendard", Font.BOLD, 16));
        registerButton.setBackground(new Color(1, 168, 98));
        registerButton.setForeground(Color.WHITE);
        registerButton.setOpaque(true);
        registerButton.setBorderPainted(false);
        panel.add(registerButton);

        // MainPage로 이동
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainPage().setVisible(true);
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SignUpPage signUpFrame = new SignUpPage();
            signUpFrame.setVisible(true);
        });
    }
}
