package ordering;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginPage extends JFrame {
    private JLabel errorLabel;

    public LoginPage() {
        setTitle("로그인");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/mini_logo.png"));
        Image logoImage = logoIcon.getImage();
        Image scaledLogoImage = logoImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(50, 50, 100, 100);
        panel.add(logoLabel);

        JLabel welcomeLabel = new JLabel("<html>안녕하세요.<br>스타벅스입니다.</html>");
        welcomeLabel.setFont(new Font("pretendard", Font.BOLD, 34));
        welcomeLabel.setBounds(50, 170, 400, 100);
        panel.add(welcomeLabel);

        JLabel instructionLabel = new JLabel("회원 서비스 이용을 위해 로그인 해주세요.");
        instructionLabel.setFont(new Font("pretendard", Font.PLAIN, 20));
        instructionLabel.setBounds(50, 270, 400, 30);
        panel.add(instructionLabel);

        PlaceholderTextField idField = new PlaceholderTextField("아이디");
        idField.setBounds(450, 250, 400, 50);
        idField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        panel.add(idField);

        PlaceholderPasswordField pwField = new PlaceholderPasswordField("비밀번호");
        pwField.setBounds(450, 350, 400, 50);
        pwField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        panel.add(pwField);

        errorLabel = new JLabel("");
        errorLabel.setFont(new Font("pretendard", Font.PLAIN, 14));
        errorLabel.setForeground(Color.RED);
        errorLabel.setBounds(450, 420, 400, 30);
        panel.add(errorLabel);

        JButton loginButton = new JButton("로그인하기");
        loginButton.setBounds(450, 500, 150, 40);
        loginButton.setFont(new Font("pretendard", Font.BOLD, 16));
        loginButton.setBackground(new Color(30, 185, 102));
        loginButton.setForeground(Color.WHITE);
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        panel.add(loginButton);

        // 로그인 버튼 클릭 이벤트
        loginButton.addActionListener(e -> {
            String id = idField.getText();
            String password = new String(pwField.getPassword());

            if (id.equals("admin") && password.equals("1234")) {
                dispose();
                new MenuPage().setVisible(true);
            } else {
                errorLabel.setText("아이디는 admin 비밀번호는 1234 입니다.");
            }
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

class PlaceholderTextField extends JTextField {
    private final String placeholder;

    public PlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;
        setForeground(Color.GRAY);
        setText(placeholder);

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder)) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setForeground(Color.GRAY);
                    setText(placeholder);
                }
            }
        });
    }
}

class PlaceholderPasswordField extends JPasswordField {
    private final String placeholder;

    public PlaceholderPasswordField(String placeholder) {
        this.placeholder = placeholder;
        setForeground(Color.GRAY);
        setEchoChar((char) 0);
        setText(placeholder);

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(getPassword()).equals(placeholder)) {
                    setText("");
                    setForeground(Color.BLACK);
                    setEchoChar('•');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getPassword().length == 0) {
                    setForeground(Color.GRAY);
                    setEchoChar((char) 0);
                    setText(placeholder);
                }
            }
        });
    }
}
