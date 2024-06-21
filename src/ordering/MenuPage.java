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
        MenuItem[] items;
        switch (category) {
            case "COFFEE":
                items = new MenuItem[]{
                        new MenuItem("아이스 카페 아메리카노", "Iced Caffe Americano", "진한 에스프레소에 시원한 정수물과 얼음을 더하여 스타벅스의 깔끔하고 강렬한 에스프레소를 가장 부드럽고 시원하게 즐길 수 있는 커피", 4500, "/images/coffee1.jpg", category),
                        new MenuItem("아이스 카페라떼", "Iced Caffe Latte", "풍부한 에스프레소와 시원한 우유가 조화롭게 어우러진 아이스 라떼", 5000, "/images/coffee2.jpg", category),
                        new MenuItem("아이스 스타벅스 돌체 라떼", "Iced Starbucks Dolce Latte", "부드러운 우유에 달콤한 돌체 시럽과 에스프레소가 어우러진 아이스 라떼", 5900, "/images/coffee3.jpg", category),
                        new MenuItem("아이스 카푸치노", "Iced Cappuccino", "신선한 우유 거품 위에 진한 에스프레소가 어우러진 아이스 카푸치노", 5000, "/images/coffee4.jpg", category),
                        new MenuItem("아이스 카라멜 마끼아또", "Iced Caramel Macchiato", "향긋한 바닐라 시럽과 시원한 우유와 얼음을 넣고 점을 찍듯이 에스프레소를 부은 후 벌집 모양으로 카라멜 드리즐을 올린 달콤한 커피 음료", 5900, "/images/coffee5.jpg", category),
                        new MenuItem("아이스 카페 모카", "Iced Caffe Mocha", "진한 초콜릿 모카 시럽과 풍부한 에스프레소를 신선한 우유 그리고 얼음과 섞어 휘핑크림으로 마무리한 음료로 진한 에스프레소와 초콜릿 맛이 어우러진 커피", 5500, "/images/coffee6.jpg", category),
                        new MenuItem("아이스 화이트 초콜릿 모카", "Iced White Chocolate Mocha", "달콤하고 부드러운 화이트 초콜릿 시럽과 에스프레소를 신선한 우유 그리고 얼음과 섞어 휘핑크림으로 마무리한 음료로 달콤함과 강렬한 에스프레소가 부드럽게 어우러진 커피", 5900, "/images/coffee7.jpg", category),
                        new MenuItem("에스프레소 마끼아또", "Espresso Macchiato", "신선한 에스프레소 샷에 우유 거품을 살짝 얹은 커피 음료로써, 강렬한 에스프레소의 맛과 우유의 부드러움을 같이 즐길 수 있는 커피 음료", 4000, "/images/coffee8.jpg", category),
                        new MenuItem("바닐라 크림 콜드브루", "Vanilla Cream Cold Brew", "콜드 브루에 더해진 바닐라 크림으로 깔끔하면서 달콤한 콜드브루를 새롭게 즐길 수 있는 음료입니다.", 5800, "/images/coffee9.jpeg", category),
                        new MenuItem("오트 콜드브루", "Oat Cold Brew", "콜드 브루의 풍미와 깔끔한 오트음료(식물성 대체유)가 어우러진 달콤 고소한 라떼", 5800, "/images/coffee10.jpeg", category),
                        new MenuItem("윤슬 헤이즐넛 콜드브루", "Shining Hazelnut Cold Brew", "햇빛이나 달빛에 비치어 반짝이는 잔물결이라는 윤슬을 형상화한 헤이즐넛 콜드브루", 6300, "/images/coffee11.jpeg", category),
                        new MenuItem("화이트 타이거 프라푸치노", "Iced Cappuccino", "신선한 우유 거품 위에 진한 에스프레소가 어우러진 아이스 카푸치노", 6500, "/images/coffee12.jpeg", category)
                };
                break;
            case "NON-COFFEE":
                items = new MenuItem[]{
                        new MenuItem("쿨라임 피지오", "Cool Lime Starbucks Fizzio", "그린 빈 추출액이 들어간 라임 베이스에 건조된 라임 슬라이스를 넣고 스파클링한 시원하고 청량감 있는 음료입니다. (카페인이 함유된 탄산음료입니다)", 5900, "/images/non-coffee1.jpeg", category),
                        new MenuItem("피치딸기 피지오", "Peach Strawberry Starbucks Fizzio", "상큼한 과일과 청량한 탄산의 조화. 피치 특유의 감각적인 색상과 무드를 탄산과 함께 즐길 수 있는 피지오", 5700, "/images/non-coffee2.jpeg", category),
                        new MenuItem("바다 자몽 피지오", "Sea Grapefruit Fizzio", "여수 돌산대교의 밤바다 풍경을 형상화한 음료", 5900, "/images/non-coffee3.jpeg", category),
                        new MenuItem("리버 피치 피지오", "River Peach Fizzio", "길고 깊은 강의 모습과 달콤한 복숭아가 만나 강의 뷰를 즐기며 힐링할 수 있는 상큼한 피지오", 6300, "/images/non-coffee4.jpeg", category),
                        new MenuItem("망고 패션 블렌디드", "Mango Passion Tea Blended", "망고 패션 프루트 주스와 패션 탱고 티가 상큼하게 어우러진 과일 블렌디드", 6500, "/images/non-coffee5.jpeg", category),
                        new MenuItem("바다 유자 블렌디드", "Sea Yuja Blended", "맑고 깨끗한 여수 경도의 낮 바다 풍경을 형상화한 음료로 상큼하게 즐길 수 있는 유자 블렌디드 음료", 6300, "/images/non-coffee6.jpeg", category),
                        new MenuItem("딸기 요거트 블렌디드", "Strawberry Delight Yogurt Blended", "유산균이 살아있는 리얼 요거트와 풍성한 딸기 과육이 더욱 상큼하게 어우러진 과일 요거트 블렌디드", 6500, "/images/non-coffee7.jpeg", category),
                        new MenuItem("망고 바나나 블렌디드", "Mango Banana Blended", "달콤한 망고 패션 프루트 주스에 바나나 1개가 통째로 들어간 신선한 블렌디드", 6300, "/images/non-coffee8.jpeg", category),
                        new MenuItem("아이스 얼그레이 티", "Iced Earl Grey Brewed Tea", "꽃향 가득한 라벤더와 베르가못 향이 진한 홍차와 블렌딩된 향긋한 블랙 티", 4500, "/images/non-coffee9.jpeg", category),
                        new MenuItem("아이스 유스베리 티", "Iced Youthberry Brewed Tea", "제주산 찻잎으로 만든 황차에 사과, 망고, 파인애플, 히비스커스, 로즈힙 등이 블렌딩되어 핑크빛 컬러가 감도는 수색과 베리류의 새콤함을 느낄 수 있는 옐로우 티", 4500, "/images/non-coffee10.jpeg", category),
                        new MenuItem("제주 녹차로 만든 티", "Iced Jeju Green Tea", "유기농 녹차 티백만을 100%(물 제외) 사용한 티로 맑은 수색과 고유의 풍미가 뛰어난 녹차", 4800, "/images/non-coffee11.jpeg", category),
                        new MenuItem("아이스 캐모마일 티", "Iced Chamomile Blend Brewed Tea", "캐모마일과 레몬 그라스, 레몬밤, 히비스커스 등 블렌딩되어 은은하고 차분한 향이 기분을 좋게하는 허브 티", 4500, "/images/non-coffee12.jpeg", category)
                };
                break;
            case "FOOD":
                items = new MenuItem[]{
                        new MenuItem("탕종 플레인 베이글", "Plain Bagel", "탕종법으로 반죽한 후 고온에서 데치고, 짧게 구워 내 쫄깃하고 촉촉한 식감이 특징인 플레인 베이글입니다.", 3300, "/images/food1.jpeg", category),
                        new MenuItem("클래식 스콘", "Classic Scone", "프랑스산 고급 버터로 만든 담백한 스콘입니다.", 5700, "/images/food2.jpeg", category),
                        new MenuItem("하트 파이", "Heart Pie", "하트 모양의 바삭한 파이입니다.", 3200, "/images/food3.jpeg", category),
                        new MenuItem("7 레이어 가나슈 케이크", "7 Layer Ganache Cake", "초콜릿, 가나슈, 모카로 만든 시트와 크림이 7개의 층을 이루어 모양부터 매력적인 케이크입니다.", 5700, "/images/food4.jpeg", category),
                        new MenuItem("촉촉 초콜릿 생크림 케이크", "The Chocolate Fresh Cream Cake", "달콤한 초콜릿 케이크 시트에 진한 가나슈 생크림을 넣고 측면에 다크 초콜릿을 듬뿍 토핑한 달콤하고 촉촉한 초콜릿 케이크입니다", 5900, "/images/food5.jpeg", category),
                        new MenuItem("레드벨벳 크림치즈 케이크", "Red Velvet Cream Cheese Cake", "레드벨벳 시트 사이에 크림치즈 무스를 샌드한 케이크입니다.", 5500, "/images/food6.jpeg", category),
                        new MenuItem("부드러운 생크림 카스텔라", "Fresh Cream Castella", "부드러운 생크림이 듬뿍 들어있는 촉촉한 카스텔라입니다.", 4500, "/images/food7.jpeg", category),
                        new MenuItem("슈크림 바움쿠헨", "Choux Cream Baumkuchen", "바닐라 빈이 들어간 부드러운 슈크림과 바움쿠헨이 조화로운 바닐라 풍미의 케이크입니다.", 6900, "/images/food8.jpeg", category),
                        new MenuItem("클래식 블루베리 치즈 케이크", "Classic Blueberry Cheese Cake", "크림치즈를 넣은 진한 풍미의 치즈 케이크 위에 달콤, 상큼한 블루베리가 올라간 클래식한 치즈 케이크입니다", 7900, "/images/food9.jpeg", category),
                        new MenuItem("돔 피칸 타르트", "Dome Pecan Tart", "타르트 시트에 달콤한 필링과 고소한 피칸을 돔 형태로 듬뿍 올려 구워낸 피칸 타르트 입니다.", 6500, "/images/food10.jpeg", category),
                        new MenuItem("B.E.L.T 샌드위치", "B.E.L.T. Sandwich", "주 재료인 베이컨(Bacon), 계란(Egg), 로메인 상추(Lettuce-Romane), 토마토(Tomato)의 각각의 머리 글자를 따온 이름의 샌드위치 입니다.", 5900, "/images/food11.jpeg", category),
                        new MenuItem("베이컨 치즈 토스트", "Bacon Cheese Toast", "계란과 우유를 적신 빵에 베이컨과 치즈, 에그 스프레드를 넣어 구운 프렌치 토스트 타입 샌드위치입니다.", 4900, "/images/food12.jpeg", category)
                };
                break;
            case "PRODUCT":
                items = new MenuItem[]{
                        new MenuItem("호작도 머그", "Hojakdo Mug 355ml", "한국의 전통 민화 호작도를 담은 355ml 용량의 머그입니다.", 35000, "/images/product1.jpeg", category),
                        new MenuItem("그린 사이렌 도트 머그", "Green siren dot mug 355ml", "법랑 머그의 쉐입을 한 세라믹 머그로서, 트렌디한 감성의 디자인이 결합된 355ml 상품입니다.", 13000, "/images/product2.jpeg", category),
                        new MenuItem("그레이 리저브 머그", "Gray reserve mug 355ml", "그레이 컬러로 세련된 355ml 머그입니다.", 18000, "/images/product3.jpeg", category),
                        new MenuItem("리저브 핸들 글라스", "Reserve handle glass 473ml", "골드 컬러의 리저브 로고가 매치된 473ml 글라스입니다.", 27000, "/images/product4.jpeg", category),
                        new MenuItem("프렌티 서머 라인 글라스", "French summer line glass 444ml", "블루 컬러의 그러데이션으로 청량함이 느껴지는 찬 음료 전용 444ml 용량의 글라스입니다.", 25000, "/images/product5.jpeg", category),
                        new MenuItem("제주 리유저블 세트", "Jeju reusable cup set 473ml (3p)", "제주의 감귤과 돌담집을 473ml 컵에 담은 3종 세트 상품입니다.", 21000, "/images/product6.jpeg", category),
                        new MenuItem("SS 서머 데비 텀블러", "SS french summer debbie tumbler 473ml", "프렌치 정원의 여유로운 여름 날 무드를 담은 473ml 용량 스테인리스 스틸 텀블러입니다.", 32000, "/images/product7.jpeg", category),
                        new MenuItem("SS 스탠리 크림 텀블러", "SS Stanley cream quencher coldcup 591ml", "591ml 용량의 스테인리스 스틸 텀블러입니다.", 39000, "/images/product8.jpeg", category),
                        new MenuItem("SS 크림 데비 텀블러", "SS Cream debbie tumbler 414ml", "크림 컬러 배색과 심플한 디자인으로 클래식한 분위기가 돋보이는 414ml 용량의 스테인리스 스틸 텀블러입니다.", 24000, "/images/product9.jpeg", category),
                        new MenuItem("레이니 베어리스타 인형", "Rainy Bearista Plush Doll", "헌터x스타벅스 콜라보레이션 제품입니다. 비 오는 날 우산을 들고, 장화를 신고, 우비를 입고있는 베어리스타 인형입니다.", 47000, "/images/product10.jpeg", category),
                        new MenuItem("사이렌 글라스볼 우드스푼", "Siren glass bowl wood spoon set", "시즌에 구애받지 않고 사용 가능한 로고 중심 디자인 상품으로 실용성이 높은 상품입니다.", 19000, "/images/product11.jpeg", category),
                        new MenuItem("스타벅스 장우산", "Starbucks house umbrella", "스타벅스의 클래식한 컬러에 화이트 라인으로 포인트를 준 자동 장우산입니다.", 23000, "/images/product12.jpeg", category)
                };
                break;
            default:
                items = new MenuItem[0];
                break;
        }

        for (MenuItem item : items) {
            JPanel itemPanel = createMenuItem(item);
            menuPanel.add(itemPanel);
        }

        menuPanel.revalidate();
        menuPanel.repaint();
    }

    private JPanel createMenuItem(MenuItem item) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBackground(Color.WHITE);

        // 이미지 라벨
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(item.getImagePath()));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemPanel.add(imageLabel, BorderLayout.CENTER);

        // 이름과 가격 라벨
        JLabel nameLabel = new JLabel(item.getName());
        nameLabel.setFont(new Font("pretendard", Font.BOLD, 20));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel priceLabel = new JLabel(item.getPrice() + "원");
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
                showItemDetail(item);
            }
        });

        return itemPanel;
    }

    private void showItemDetail(MenuItem item) {
        JDialog detailDialog = new JDialog(this, "상세 설명", true);
        detailDialog.setSize(600, 400);
        detailDialog.setLocationRelativeTo(this);

        JPanel detailPanel = new JPanel(new BorderLayout());
        detailPanel.setBackground(Color.WHITE);

        // 이미지 패널
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setPreferredSize(new Dimension(300, 400));
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(item.getImagePath()));
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
        JLabel nameLabel = new JLabel(item.getName());
        nameLabel.setFont(new Font("pretendard", Font.BOLD, 20));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(nameLabel);

        // 영어 이름 라벨
        JLabel englishNameLabel = new JLabel(item.getEnglishName());
        englishNameLabel.setFont(new Font("pretendard", Font.ITALIC, 14));
        englishNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(englishNameLabel);
        infoPanel.add(Box.createVerticalStrut(10));

        // 설명 라벨
        JLabel descriptionLabel = new JLabel("<html>" + item.getDescription().replace("\n", "<br>") + "</html>");
        descriptionLabel.setFont(new Font("pretendard", Font.PLAIN, 14));
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(descriptionLabel);
        infoPanel.add(Box.createVerticalStrut(10));

        // 가격 라벨
        JLabel priceLabel = new JLabel(item.getPrice() + "원");
        priceLabel.setFont(new Font("pretendard", Font.BOLD, 18));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.add(priceLabel);
        infoPanel.add(Box.createVerticalStrut(10));

        // COFFEE와 NON-COFFEE 카테고리만 사이즈 선택 추가
        if (item.getCategory().equals("COFFEE") || item.getCategory().equals("NON-COFFEE")) {
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
            tallButton.setSelected(true);
            sizePanel.add(tallButton);
            sizePanel.add(grandeButton);
            sizePanel.add(ventiButton);
            infoPanel.add(sizePanel);

            // 사이즈 선택 이벤트 추가
            tallButton.addActionListener(e -> {
                int basePrice = item.getPrice();
                priceLabel.setText(basePrice + "원");
            });
            grandeButton.addActionListener(e -> {
                int basePrice = item.getPrice();
                priceLabel.setText((basePrice + 500) + "원");
            });
            ventiButton.addActionListener(e -> {
                int basePrice = item.getPrice();
                priceLabel.setText((basePrice + 1000) + "원");
            });
        }

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
                quantity--;
                quantityLabel.setText(String.valueOf(quantity));
                updatePrice(item.getPrice(), quantity, priceLabel);
            }
        });
        plusButton.addActionListener(e -> {
            int quantity = Integer.parseInt(quantityLabel.getText());
            quantity++;
            quantityLabel.setText(String.valueOf(quantity));
            updatePrice(item.getPrice(), quantity, priceLabel);
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

    private void updatePrice(int basePrice, int quantity, JLabel priceLabel) {
        int totalPrice = basePrice * quantity;
        priceLabel.setText(totalPrice + "원");
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

class MenuItem {
    private String name;
    private String englishName;
    private String description;
    private int price;
    private String imagePath;
    private String category;

    public MenuItem(String name, String englishName, String description, int price, String imagePath, String category) {
        this.name = name;
        this.englishName = englishName;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getCategory() {
        return category;
    }
}
