package ordering;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage extends JFrame {
    private JButton selectedButton;
    private JPanel menuPanel;
    private JScrollPane scrollPane;

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
            tabButton.setForeground(Color.WHITE);
            tabButton.setFont(new Font("pretendard", Font.BOLD, 16));
            tabButton.setPreferredSize(new Dimension(200, 50)); // 버튼 크기 조절
            tabButton.addActionListener(new TabButtonListener(tab));
            tabPanel.add(tabButton, gbc);
        }
        mainPanel.add(tabPanel, BorderLayout.NORTH);

        // 메뉴 패널
        menuPanel = new JPanel(new GridLayout(0, 4, 20, 20)); // 한 줄에 4개씩 배치
        menuPanel.setBackground(Color.WHITE);
        scrollPane = new JScrollPane(menuPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // 기본 메뉴 항목 추가 (COFFEE)
        updateMenuItems("COFFEE");

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

    private void updateMenuItems(String category) {
        menuPanel.removeAll();
        String[] itemNames, itemPrices, itemImages;
        switch (category) {
            case "COFFEE":
                itemNames = new String[]{
                        "아이스 카페 아메리카노", "아이스 카페라떼", "아이스 스타벅스 돌체 라떼", "아이스 카푸치노",
                        "아이스 카라멜 마끼아또", "아이스 카페 모카", "아이스 화이트 초콜릿 모카", "에스프레소 마끼아또",
                        "바닐라 크림 콜드브루", "오트 콜드브루", "여수 윤슬 헤이즐넛 콜드브루", "화이트 타이거 프라푸치노"
                };
                itemPrices = new String[]{
                        "4,500원", "5,000원", "5,900원", "5,000원",
                        "5,900원", "5,500원", "5,900원", "4,000원",
                        "5,800원", "5,800원", "6,300원", "6,500원"
                };
                itemImages = new String[]{
                        "/images/coffee1.jpg", "/images/coffee2.jpg", "/images/coffee3.jpg", "/images/coffee4.jpg",
                        "/images/coffee5.jpg", "/images/coffee6.jpg", "/images/coffee7.jpg", "/images/coffee8.jpg",
                        "/images/coffee9.jpeg", "/images/coffee10.jpeg", "/images/coffee11.jpeg", "/images/coffee12.jpeg"
                };
                break;
            case "NON-COFFEE":
                itemNames = new String[]{
                        "쿨라임 피지오", "피치딸기 피지오", "바다 자몽 피지오", "리버 피치 피지오",
                        "망고 패션 블렌디드", "바다 유자 블렌디드", "딸기 요거트 블렌디드", "망고 바나나 블렌디드",
                        "아이스 얼 그레이 티", "아이스 유스베리 티", "제주 녹차로 만든 티", "아이스 캐모마일 티"
                };
                itemPrices = new String[]{
                        "5,900원", "5,700원", "5,900원", "5,900원",
                        "6,300원", "6,500원", "6,300원", "6,300원",
                        "4,500원", "4,500원", "4,800원", "4,500원"
                };
                itemImages = new String[]{
                        "/images/non-coffee1.jpeg", "/images/non-coffee2.jpeg", "/images/non-coffee3.jpeg", "/images/non-coffee4.jpeg",
                        "/images/non-coffee5.jpeg", "/images/non-coffee6.jpeg", "/images/non-coffee7.jpeg", "/images/non-coffee8.jpeg",
                        "/images/non-coffee9.jpeg", "/images/non-coffee10.jpeg", "/images/non-coffee11.jpeg", "/images/non-coffee12.jpeg"
                };
                break;
            case "FOOD":
                itemNames = new String[]{
                        "탕종 플레인 베이글", "클래식 스콘", "하트 파이", "7 레이어 가나슈 케이크",
                        "촉촉 초콜릿 생크림 케이크", "레드벨벳 크림치즈 케이크", "부드러운 생크림 카스텔라", "슈크림 바움쿠헨",
                        "클래식 블루베리 치즈 케이크", "돔 피칸 타르트", "B.E.L.T. 샌드위치", "베이컨 치즈 토스트",
                };
                itemPrices = new String[]{
                        "3,300원", "5,700원", "3,200원", "5,700원",
                        "5,900원", "5,500원", "4,500원", "6,900원",
                        "7,900원", "6,500원", "5,900원", "4,900원"
                };
                itemImages = new String[]{
                        "/images/food1.jpeg", "/images/food2.jpeg", "/images/food3.jpeg", "/images/food4.jpeg",
                        "/images/food5.jpeg", "/images/food6.jpeg", "/images/food7.jpeg", "/images/food8.jpeg",
                        "/images/food9.jpeg", "/images/food10.jpeg", "/images/food11.jpeg", "/images/food12.jpeg"
                };
                break;
            case "PRODUCT":
                itemNames = new String[]{
                        "호작도 머그", "그린 사이렌 도트 머그", "그레이 리저브 머그", "리저브 핸들 글라스",
                        "프렌치 서머 라인 글라스", "제주 리유저블 세트", "SS 서머 데비 텀블러", "SS 스탠리 크림 텀블러",
                        "SS 크림 데비 텀블러", "레이니 베어리스타 인형", "사이렌 글라스볼 우드스푼세트", "스타벅스 장우산",
                };
                itemPrices = new String[]{
                        "35,000원", "13,000원", "18,000원", "27,000원",
                        "25,000원", "21,000원", "32,000원", "39,000원",
                        "24,000원", "47,000원", "19,000원", "23,000원"
                };
                itemImages = new String[]{
                        "/images/product1.jpeg", "/images/product2.jpeg", "/images/product3.jpeg", "/images/product4.jpeg",
                        "/images/product5.jpeg", "/images/product6.jpeg", "/images/product7.jpeg", "/images/product8.jpeg",
                        "/images/product9.jpeg", "/images/product10.jpeg", "/images/product11.jpeg", "/images/product12.jpeg"
                };
                break;
            case "MY-SHOP":
                itemNames = new String[]{
                        "장바구니에 담긴 상품1", "장바구니에 담긴 상품2", "장바구니에 담긴 상품3", "장바구니에 담긴 상품4",
                        "장바구니에 담긴 상품5", "장바구니에 담긴 상품6", "장바구니에 담긴 상품7", "장바구니에 담긴 상품8"
                };
                itemPrices = new String[]{
                        "가격1", "가격2", "가격3", "가격4",
                        "가격5", "가격6", "가격7", "가격8"
                };
                itemImages = new String[]{
                        "/images/coffee1.jpg", "/images/coffee2.jpg", "/images/coffee3.jpg", "/images/coffee4.jpg",
                        "/images/coffee5.jpg", "/images/coffee6.jpg", "/images/coffee7.jpg", "/images/coffee8.jpg"
                };
                break;
            default:
                itemNames = new String[0];
                itemPrices = new String[0];
                itemImages = new String[0];
                break;
        }

        for (int i = 0; i < itemNames.length; i++) {
            JPanel itemPanel = createMenuItem(itemNames[i], itemPrices[i], itemImages[i]);
            menuPanel.add(itemPanel);
        }

        menuPanel.revalidate();
        menuPanel.repaint();
    }

    private JPanel createMenuItem(String name, String price, String imagePath) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBackground(Color.WHITE);

        // 이미지 라벨
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemPanel.add(imageLabel, BorderLayout.CENTER);

        // 이름과 가격 라벨
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("pretendard", Font.BOLD, 20));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(new Font("pretendard", Font.PLAIN, 16));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.setBackground(Color.WHITE);
        textPanel.add(nameLabel);
        textPanel.add(priceLabel);

        itemPanel.add(textPanel, BorderLayout.SOUTH);

        // 아이템 클릭 이벤트 추가
        itemPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showItemDetail(name, price, imagePath);
            }
        });

        return itemPanel;
    }

    private void showItemDetail(String name, String price, String imagePath) {
        JDialog detailDialog = new JDialog(this, "상세 설명", true);
        detailDialog.setSize(600, 400);
        detailDialog.setLocationRelativeTo(this);

        JPanel detailPanel = new JPanel(new BorderLayout());
        detailPanel.setBackground(Color.WHITE);

        // 이미지 패널
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setPreferredSize(new Dimension(detailDialog.getWidth() / 3, detailDialog.getHeight()));
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
        Image image = imageIcon.getImage().getScaledInstance(imagePanel.getPreferredSize().width, imagePanel.getPreferredSize().height, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(imageLabel);
        detailPanel.add(imagePanel, BorderLayout.WEST);

        // 상세 정보 패널
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        // 이름 라벨
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("pretendard", Font.BOLD, 20));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(nameLabel);

        // 영어 이름 라벨
        JLabel englishNameLabel = new JLabel("Iced Caffe Americano");
        englishNameLabel.setFont(new Font("pretendard", Font.ITALIC, 14));
        englishNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(englishNameLabel);

        // 설명 라벨
        JLabel descriptionLabel = new JLabel("<html>진한 에스프레소에 시원한 정수물과 얼음을 더하여<br>스타벅스의 깔끔하고 강렬한 에스프레소를<br>가장 부드럽고 시원하게 즐길 수 있는 커피</html>");
        descriptionLabel.setFont(new Font("pretendard", Font.PLAIN, 14));
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(descriptionLabel);

        // 가격 라벨
        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(new Font("pretendard", Font.BOLD, 18));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(priceLabel);

        // 사이즈 선택 패널
        JPanel sizePanel = new JPanel();
        sizePanel.setBackground(Color.WHITE);
        sizePanel.setLayout(new FlowLayout());
        JToggleButton tallButton = new JToggleButton("Tall");
        JToggleButton grandeButton = new JToggleButton("Grande");
        JToggleButton ventiButton = new JToggleButton("Venti");
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(tallButton);
        sizeGroup.add(grandeButton);
        sizeGroup.add(ventiButton);
        grandeButton.setSelected(true);
        sizePanel.add(tallButton);
        sizePanel.add(grandeButton);
        sizePanel.add(ventiButton);
        infoPanel.add(sizePanel);

        // 수량 조절 패널
        JPanel quantityPanel = new JPanel();
        quantityPanel.setBackground(Color.WHITE);
        quantityPanel.setLayout(new FlowLayout());
        JButton minusButton = new JButton("-");
        JLabel quantityLabel = new JLabel("1");
        JButton plusButton = new JButton("+");
        quantityPanel.add(minusButton);
        quantityPanel.add(quantityLabel);
        quantityPanel.add(plusButton);
        infoPanel.add(quantityPanel);

        // 수량 조절 이벤트
        minusButton.addActionListener(e -> {
            int quantity = Integer.parseInt(quantityLabel.getText());
            if (quantity > 1) {
                quantityLabel.setText(String.valueOf(quantity - 1));
            }
        });
        plusButton.addActionListener(e -> {
            int quantity = Integer.parseInt(quantityLabel.getText());
            quantityLabel.setText(String.valueOf(quantity + 1));
        });

        // 담기 버튼
        JButton addButton = new JButton("담기");
        addButton.setBackground(new Color(30, 185, 102));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("pretendard", Font.BOLD, 16));
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(addButton);

        detailPanel.add(infoPanel, BorderLayout.CENTER);

        detailDialog.add(detailPanel);
        detailDialog.setVisible(true);
    }

    private class TabButtonListener implements ActionListener {
        private String category;

        public TabButtonListener(String category) {
            this.category = category;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            if (selectedButton != null) {
                selectedButton.setBackground(new Color(30, 185, 102));
                selectedButton.setForeground(Color.WHITE);
            }
            clickedButton.setBackground(Color.WHITE);
            clickedButton.setForeground(Color.BLACK);
            selectedButton = clickedButton;

            updateMenuItems(category);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuPage menuPage = new MenuPage();
            menuPage.setVisible(true);
        });
    }
}
