package ordering;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage extends JFrame {
    private JButton selectedButton;

    public MenuPage() {
        setTitle("Starbucks 메뉴");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(30, 185, 102));

        // 상단 탭 패널
        JPanel tabPanel = new JPanel(new GridBagLayout());
        tabPanel.setBackground(new Color(30, 185, 102));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        String[] tabs = {"COFFEE", "NON-COFFEE", "FOOD", "PRODUCT", "MY-SHOP"};
        for (String tab : tabs) {
            JButton tabButton = new JButton(tab);
            tabButton.setBackground(new Color(30, 185, 102));
            tabButton.setForeground(new Color(30, 185, 102));
            tabButton.setFont(new Font("pretendard", Font.BOLD, 16));
            tabButton.setPreferredSize(new Dimension(200, 50)); // 버튼 크기 조절
            tabButton.addActionListener(new TabButtonListener());
            tabPanel.add(tabButton, gbc);
        }
        mainPanel.add(tabPanel, BorderLayout.NORTH);

        // 메뉴 패널
        JPanel menuPanel = new JPanel(new GridLayout(2, 4, 20, 20));
        menuPanel.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(menuPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 메뉴 항목 추가
        String[] itemNames = {
                "아이스 카페 아메리카노", "아이스 카페라떼", "아이스 스타벅스 돌체 라떼", "아이스 카푸치노",
                "아이스 카라멜 마끼아또", "아이스 카페 모카", "아이스 화이트 초콜릿 모카", "에스프레소 마끼아또"
        };
        String[] itemPrices = {
                "4,500원", "5,000원", "5,900원", "5,000원",
                "5,900원", "5,500원", "5,900원", "4,000원"
        };
        String[] itemImages = {
                "/images/coffee1.jpg", "/images/coffee2.jpg", "/images/coffee3.jpg", "/images/coffee4.jpg",
                "/images/coffee5.jpg", "/images/coffee6.jpg", "/images/coffee7.jpg", "/images/coffee8.jpg"
        };

        for (int i = 0; i < itemNames.length; i++) {
            JPanel itemPanel = createMenuItem(itemNames[i], itemPrices[i], itemImages[i]);
            menuPanel.add(itemPanel);
        }

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // 주문 버튼
        JButton orderButton = new JButton("ORDER");
        orderButton.setBackground(new Color(30, 185, 102));
        orderButton.setForeground(Color.WHITE);
        orderButton.setFont(new Font("pretendard", Font.BOLD, 16));
        orderButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel orderPanel = new JPanel();
        orderPanel.setBackground(Color.WHITE);
        orderPanel.add(orderButton);
        mainPanel.add(orderPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JPanel createMenuItem(String name, String price, String imagePath) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBackground(Color.WHITE);

        // 이미지 라벨
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
        Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemPanel.add(imageLabel, BorderLayout.CENTER);

        // 이름과 가격 라벨
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("pretendard", Font.BOLD, 14));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(new Font("pretendard", Font.PLAIN, 14));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.setBackground(Color.WHITE);
        textPanel.add(nameLabel);
        textPanel.add(priceLabel);

        itemPanel.add(textPanel, BorderLayout.SOUTH);

        return itemPanel;
    }

    private class TabButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            if (selectedButton != null) {
                selectedButton.setBackground(Color.BLACK);
                selectedButton.setForeground(new Color(30, 185, 102));
            }
            clickedButton.setBackground(new Color(30, 185, 102));
            clickedButton.setForeground(Color.BLACK);
            selectedButton = clickedButton;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuPage menuPage = new MenuPage();
            menuPage.setVisible(true);
        });
    }
}
