package ordering;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {
    public LoginPage() {
        setTitle("로그인");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(null);

        // 로고 이미지 설정
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/mini_logo.png"));
        Image logoImage = logoIcon.getImage();
        Image scaledLogoImage = logoImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(50, 50, 100, 100);
        panel.add(logoLabel);

        // 텍스트 라벨 설정
        JLabel welcomeLabel = new JLabel("<html>안녕하세요.<br>스타벅스입니다.</html>");
        welcomeLabel.setFont(new Font("pretendard", Font.BOLD, 34));
        welcomeLabel.setBounds(50, 170, 300, 100);
        panel.add(welcomeLabel);

        JLabel instructionLabel = new JLabel("회원 서비스 이용을 위해 로그인 해주세요.");
        instructionLabel.setFont(new Font("pretendard", Font.PLAIN, 20));
        instructionLabel.setBounds(50, 270, 400, 30);
        panel.add(instructionLabel);

        // 입력 필드 라벨과 텍스트 필드 설정
        JLabel idLabel = new JLabel("아이디:");
        JTextField idField = new JTextField();
        idLabel.setBounds(450, 270, 100, 30);
        idField.setBounds(500, 270, 200, 30);
        panel.add(idLabel);
        panel.add(idField);

        JLabel pwLabel = new JLabel("비밀번호:");
        JPasswordField pwField = new JPasswordField();
        pwLabel.setBounds(450, 320, 100, 30);
        pwField.setBounds(500, 320, 200, 30);
        panel.add(pwLabel);
        panel.add(pwField);

        // 로그인 버튼
        JButton loginButton = new JButton("로그인하기");
        loginButton.setBounds(500, 370, 200, 40);
        loginButton.setFont(new Font("pretendard", Font.BOLD, 16));
        loginButton.setBackground(new Color(30, 185, 102));
        loginButton.setForeground(Color.WHITE);
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        panel.add(loginButton);

        // 로그인 버튼 클릭 시 메인 페이지로 이동
        loginButton.addActionListener(e -> {
            dispose();
            new MainPage().setVisible(true);
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true);
        });
    }
}

