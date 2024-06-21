package ordering;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ResultPage extends JFrame {

    public ResultPage() {
        setTitle("주문 내역 상황");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel statusLabel = new JLabel("관리자가 주문을 확인하고 있습니다...");
        statusLabel.setFont(new Font("pretendard", Font.BOLD, 30));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalStrut(200));
        mainPanel.add(statusLabel);
        mainPanel.add(Box.createVerticalStrut(20));

        // 진행 바 패널
        JPanel progressPanel = new JPanel(new BorderLayout());
        progressPanel.setBackground(Color.WHITE);
        progressPanel.setPreferredSize(new Dimension(800, 50));


        // 진행 바
        JProgressBar progressBar = new JProgressBar();
        progressBar.setForeground(new Color(30, 185, 102));
        progressBar.setPreferredSize(new Dimension(600, 30));
        progressBar.setMaximum(50);

        // 무한으로 0부터 50까지 왔다 갔다 움직이는 효과 설정
        Timer timer = new Timer(50, e -> {
            int value = progressBar.getValue();
            if (value >= 50) {
                progressBar.setValue(0);
            } else {
                progressBar.setValue(value + 1);
            }
        });
        timer.start();

        JPanel barPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        barPanel.setBackground(Color.WHITE);
        barPanel.add(progressBar);

        progressPanel.add(barPanel, BorderLayout.CENTER);
        mainPanel.add(progressPanel);

        add(mainPanel);

        // 5초 후에 이동
        Timer delayTimer = new Timer(5000, e -> {
            timer.stop();
            dispose();
            SwingUtilities.invokeLater(() -> {
                SuccessPage successPage = new SuccessPage();
                successPage.setVisible(true);
            });
        });
        delayTimer.setRepeats(false);
        delayTimer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ResultPage resultPage = new ResultPage();
            resultPage.setVisible(true);
        });
    }
}

class SuccessPage extends JFrame {

    public SuccessPage() {
        setTitle("주문 완료");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel successLabel = new JLabel("고객님의 주문이 완료되었습니다. 🤗");
        successLabel.setFont(new Font("pretendard", Font.BOLD, 30));
        successLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createVerticalStrut(200));
        mainPanel.add(successLabel);
        mainPanel.add(Box.createVerticalStrut(20));


        // 랜덤 주문 번호
        Random random = new Random();
        int orderNumber = random.nextInt(100) + 1;
        JLabel orderNumberLabel = new JLabel("주문번호 : A - " + orderNumber);
        orderNumberLabel.setFont(new Font("pretendard", Font.BOLD, 42));
        orderNumberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(orderNumberLabel);

        add(mainPanel);
    }
}
