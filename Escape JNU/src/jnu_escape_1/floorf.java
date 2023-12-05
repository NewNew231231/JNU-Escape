package jnu_escape_1;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class floorf extends JPanel{
	/**
     * 비밀 복도 패널
     */
	public static JPanel room1;
	/**
     * 연구실 패널
     */
    public static JPanel room2;
    /**
     * 백신 제작실 패널
     */
    public static JPanel room3;
    /**
     * 가방 ui를 출력해주는 패널이다.
     */
    public static JPanel bagPanel;
    /**
     * 도어락이 올바른 순서대로 입력되고 있는지 저장하는 문자열
     */
    private String doorlock = "";
    
    ImageIcon bagkeyicon = new ImageIcon(GameMap.class.getResource("../source/key3.png"));
    JButton bagkey = new JButton(bagkeyicon);
    ImageIcon bagcuttericon = new ImageIcon(GameMap.class.getResource("../source/cutter3.png"));
    JButton bagcutter = new JButton(bagcuttericon);
    ImageIcon baglettericon = new ImageIcon(GameMap.class.getResource("../source/letter3.png"));
    JButton bagletter = new JButton(baglettericon);
    ImageIcon bagarmicon = new ImageIcon(GameMap.class.getResource("../source/arm3.png"));
    JButton bagarm = new JButton(bagarmicon);
    ImageIcon bagsyringeicon = new ImageIcon(GameMap.class.getResource("../source/syringe2.png"));
    JButton bagsyringe = new JButton(bagsyringeicon);
    ImageIcon baghiddenkeyicon = new ImageIcon(GameMap.class.getResource("../source/hiddenkey2.png"));
    JButton baghiddenkey = new JButton(baghiddenkeyicon);
    ImageIcon bagvirusicon = new ImageIcon(GameMap.class.getResource("../source/virusbag.png"));
    JButton bagvirus = new JButton(bagvirusicon);
    ImageIcon bagbloodicon = new ImageIcon(GameMap.class.getResource("../source/bloodbag.png"));
    JButton bagblood = new JButton(bagbloodicon);
    
    ImageIcon room1to3puzzleicon = new ImageIcon(GameMap.class.getResource("../source/fdoor1.png"));
    JButton room1to3puzzle = new JButton(room1to3puzzleicon);
    ImageIcon animalicon = new ImageIcon(GameMap.class.getResource("../source/animal.png"));
    JButton animal = new JButton(animalicon);
    ImageIcon fishicon = new ImageIcon(GameMap.class.getResource("../source/fish.png"));
    JButton fish = new JButton(fishicon);
    ImageIcon sheepicon = new ImageIcon(GameMap.class.getResource("../source/sheep.png"));
    JButton sheep = new JButton(sheepicon);
    ImageIcon birdicon = new ImageIcon(GameMap.class.getResource("../source/bird.png"));
    JButton bird = new JButton(birdicon);
    ImageIcon snakeicon = new ImageIcon(GameMap.class.getResource("../source/snake.png"));
    JButton snake = new JButton(snakeicon);
    
    ImageIcon hiddenkeybagicon = new ImageIcon(GameMap.class.getResource("../source/hiddenkey2.png"));
    JButton hiddenkeybag = new JButton(hiddenkeybagicon);
    ImageIcon syringebagicon = new ImageIcon(GameMap.class.getResource("../source/syringe2.png"));
    JButton syringebag = new JButton(syringebagicon);
    ImageIcon virusbagicon = new ImageIcon(GameMap.class.getResource("../source/virusbag.png"));
    JButton virusbag = new JButton(virusbagicon);
    ImageIcon bloodbagicon = new ImageIcon(GameMap.class.getResource("../source/bloodbag.png"));
    JButton bloodbag = new JButton(bloodbagicon);
    /**
     * 커서의 이미지를 돋보기로 하는 커서
     */
    private Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(
            new ImageIcon(getClass().getResource("../source/mouse.png")).getImage(), new Point(0, 0), "customCursor");
    
    public floorf() {
    	// Room1 Panel
        room1 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/roomf-1.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        ImageIcon room1to3icon = new ImageIcon(GameMap.class.getResource("../source/fdoor1.png"));
        JButton room1to3 = new JButton(room1to3icon);
        room1to3.setBounds(440, 230, room1to3icon.getIconWidth(), room1to3icon.getIconHeight());
        room1to3.setBorderPainted(false);
        room1to3.setContentAreaFilled(false);
        room1to3.setFocusPainted(false);
        room1to3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	room1to3();
            }
        });
        ImageIcon room1to2icon = new ImageIcon(GameMap.class.getResource("../source/fdoor2.png"));
        JButton room1to2 = new JButton(room1to2icon);
        room1to2.setBounds(630, 220, room1to2icon.getIconWidth(), room1to2icon.getIconHeight());
        room1to2.setBorderPainted(false);
        room1to2.setContentAreaFilled(false);
        room1to2.setFocusPainted(false);
        room1to2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	room1to2();
            }
        });
        ImageIcon floorfto1icon = new ImageIcon(GameMap.class.getResource("../source/down.png"));
        JButton floorfto1 = new JButton(floorfto1icon);
        floorfto1.setBounds(420, 490, floorfto1icon.getIconWidth(), floorfto1icon.getIconHeight());
        floorfto1.setBorderPainted(false);
        floorfto1.setContentAreaFilled(false);
        floorfto1.setFocusPainted(false);
        floorfto1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	floorfto1();
            }
        });
        ImageIcon room1bagicon = new ImageIcon(GameMap.class.getResource("../source/bagButton.png"));
        JButton room1bag = new JButton(room1bagicon);
        room1bag.setBounds(750, 430, room1bagicon.getIconWidth(), room1bagicon.getIconHeight());
        room1bag.setBorderPainted(false);
        room1bag.setContentAreaFilled(false);
        room1bag.setFocusPainted(false);
        room1bag.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	room1bag.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	room1bag.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	room1tobag();
            }
        });
        /**
         * 좀비에게서 열쇠를 얻는 버튼
         */
        ImageIcon hiddenkeydetailicon = new ImageIcon(GameMap.class.getResource("../source/hiddenkey1.png"));
        JButton hiddenkeydetail = new JButton(hiddenkeydetailicon);
        hiddenkeydetail.setVisible(false);
        hiddenkeydetail.setBounds(0, 0, hiddenkeydetailicon.getIconWidth(), hiddenkeydetailicon.getIconHeight());
        hiddenkeydetail.setBorderPainted(false);
        hiddenkeydetail.setContentAreaFilled(false);
        hiddenkeydetail.setFocusPainted(false);
        hiddenkeydetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	hiddenkeydetail.setVisible(false);
            }
        });
        ImageIcon hiddenkeyicon = new ImageIcon(GameMap.class.getResource("../source/hiddenkey.png"));
        JButton hiddenkey = new JButton(hiddenkeyicon);
        hiddenkey.setVisible(false);
        hiddenkey.setBounds(170, 375, hiddenkeyicon.getIconWidth(), hiddenkeyicon.getIconHeight());
        hiddenkey.setBorderPainted(false);
        hiddenkey.setContentAreaFilled(false);
        hiddenkey.setFocusPainted(false);
        hiddenkey.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	hiddenkey.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	hiddenkey.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	hiddenkeydetail.setVisible(true);
            	Item itemhiddenkey = new Item("hiddenkey");
                Bag.getInstance().addItem(itemhiddenkey);
                hiddenkey.setVisible(false);
            }
        });
        ImageIcon uzombiedetailicon = new ImageIcon(GameMap.class.getResource("../source/uzombiedetail.png"));
        JButton uzombiedetail = new JButton(uzombiedetailicon);
        uzombiedetail.setVisible(false);
        uzombiedetail.setBounds(0, 0, uzombiedetailicon.getIconWidth(), uzombiedetailicon.getIconHeight());
        uzombiedetail.setBorderPainted(false);
        uzombiedetail.setContentAreaFilled(false);
        uzombiedetail.setFocusPainted(false);
        uzombiedetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	uzombiedetail.setVisible(false);
            	hiddenkey.setVisible(false);
            }
        });
        
        ImageIcon uzombieicon = new ImageIcon(GameMap.class.getResource("../source/uzombie.png"));
        JButton uzombie = new JButton(uzombieicon);
        uzombie.setBounds(130, 330, uzombieicon.getIconWidth(), uzombieicon.getIconHeight());
        uzombie.setBorderPainted(false);
        uzombie.setContentAreaFilled(false);
        uzombie.setFocusPainted(false);
        uzombie.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	uzombie.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	uzombie.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	uzombiedetail.setVisible(true);
            	hiddenkey.setVisible(true);
            }
        });
        /**
         * 열쇠를 통해 연구실로 들어가는 버튼
         */
        ImageIcon bagpuzzleicon = new ImageIcon(GameMap.class.getResource("../source/bagpuzzle.png"));
        JButton bagpuzzle1 = new JButton(bagpuzzleicon);
        bagpuzzle1.setVisible(false);
        bagpuzzle1.setBounds(150, 440, bagpuzzleicon.getIconWidth(), bagpuzzleicon.getIconHeight());
        bagpuzzle1.setBorderPainted(false);
        bagpuzzle1.setContentAreaFilled(false);
        bagpuzzle1.setFocusPainted(false);
        
        ImageIcon room1to2detailicon = new ImageIcon(GameMap.class.getResource("../source/labdoor.png"));
        JButton room1to2detail = new JButton(room1to2detailicon);
        room1to2detail.setVisible(false);
        room1to2detail.setBounds(0, 0, room1to2detailicon.getIconWidth(), room1to2detailicon.getIconHeight());
        room1to2detail.setBorderPainted(false);
        room1to2detail.setContentAreaFilled(false);
        room1to2detail.setFocusPainted(false);
        room1to2detail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	room1to2detail.setVisible(false);
            	bagpuzzle1.setVisible(false);
            	if (Bag.getInstance().containsItem("hiddenkey")) {
            		hiddenkeybag.setVisible(false);
            	}
            }
        });
        ImageIcon room1to2puzzleicon = new ImageIcon(GameMap.class.getResource("../source/fdoor2.png"));
        JButton room1to2puzzle = new JButton(room1to2puzzleicon);
        room1to2puzzle.setBounds(630, 220, room1to2puzzleicon.getIconWidth(), room1to2puzzleicon.getIconHeight());
        room1to2puzzle.setBorderPainted(false);
        room1to2puzzle.setContentAreaFilled(false);
        room1to2puzzle.setFocusPainted(false);
        room1to2puzzle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	bagpuzzle1.setVisible(true);
            	room1to2detail.setVisible(true);
            	if (Bag.getInstance().containsItem("hiddenkey")) {
            		hiddenkeybag.setVisible(true);
            	}
            }
        });

        hiddenkeybag.setVisible(false);
        hiddenkeybag.setBounds(180, 470, hiddenkeybagicon.getIconWidth(), hiddenkeybagicon.getIconHeight());
        hiddenkeybag.setBorderPainted(false);
        hiddenkeybag.setContentAreaFilled(false);
        hiddenkeybag.setFocusPainted(false);
        hiddenkeybag.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	room1to2puzzle.setVisible(false);
            	bagpuzzle1.setVisible(false);
            	room1to2detail.setVisible(false);
            	hiddenkeybag.setVisible(false);
            	room1to2();
            }
        });
        
        /**
         * 퍼즐을 통해 백신 제작실로 들어가는 버튼
         */
        sheep.setVisible(false);
        sheep.setBounds(96, 63, sheepicon.getIconWidth(), sheepicon.getIconHeight());
        sheep.setBorderPainted(false);
        sheep.setContentAreaFilled(false);
        sheep.setFocusPainted(false);
        sheep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	doorlock += "1";
                checkLocker();
            }
        });
        
        bird.setVisible(false);
        bird.setBounds(450, 63, birdicon.getIconWidth(), birdicon.getIconHeight());
        bird.setBorderPainted(false);
        bird.setContentAreaFilled(false);
        bird.setFocusPainted(false);
        bird.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	doorlock += "2";
                checkLocker();
            }
        });
        
        snake.setVisible(false);
        snake.setBounds(96, 303, snakeicon.getIconWidth(), snakeicon.getIconHeight());
        snake.setBorderPainted(false);
        snake.setContentAreaFilled(false);
        snake.setFocusPainted(false);
        snake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	doorlock += "3";
                checkLocker();
            }
        });
        
        fish.setVisible(false);
        fish.setBounds(450, 305, fishicon.getIconWidth(), fishicon.getIconHeight());
        fish.setBorderPainted(false);
        fish.setContentAreaFilled(false);
        fish.setFocusPainted(false);
        fish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	doorlock += "4";
                checkLocker();
            }
        });
        
        animal.setVisible(false);
        animal.setBounds(0, 0, animalicon.getIconWidth(), animalicon.getIconHeight());
        animal.setBorderPainted(false);
        animal.setContentAreaFilled(false);
        animal.setFocusPainted(false);
        animal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	animal.setVisible(false);
            	sheep.setVisible(false);
            	bird.setVisible(false);
            	snake.setVisible(false);
            	fish.setVisible(false);
            }
        });
        
        room1to3puzzle.setBounds(440, 230, room1to3puzzleicon.getIconWidth(), room1to3puzzleicon.getIconHeight());
        room1to3puzzle.setBorderPainted(false);
        room1to3puzzle.setContentAreaFilled(false);
        room1to3puzzle.setFocusPainted(false);
        room1to3puzzle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	animal.setVisible(true);
            	sheep.setVisible(true);
            	bird.setVisible(true);
            	snake.setVisible(true);
            	fish.setVisible(true);
            }
        });
        
        room1.setLayout(null);
        room1.add(hiddenkeybag);
        room1.add(bagpuzzle1);
        room1.add(room1to2detail);
        room1.add(room1to2puzzle);
        room1.add(sheep);
        room1.add(bird);
        room1.add(snake);
        room1.add(fish);
        room1.add(animal);
        room1.add(room1to3puzzle);
        room1.add(hiddenkeydetail);
        room1.add(hiddenkey);
        room1.add(uzombiedetail);
        room1.add(uzombie);
        room1.add(room1bag);
        room1.add(room1to3);
        room1.add(room1to2);
        room1.add(floorfto1);
        
     // Room2 Panel
        room2 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/roomf-2-3.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        ImageIcon room2to1icon = new ImageIcon(GameMap.class.getResource("../source/down.png"));
        JButton room2to1 = new JButton(room2to1icon);
        room2to1.setBounds(420, 490, room2to1icon.getIconWidth(), room2to1icon.getIconHeight());
        room2to1.setBorderPainted(false);
        room2to1.setContentAreaFilled(false);
        room2to1.setFocusPainted(false);
        room2to1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	room2to1();
            }
        });
        ImageIcon room2bagicon = new ImageIcon(GameMap.class.getResource("../source/bagButton.png"));
        JButton room2bag = new JButton(room2bagicon);
        room2bag.setBounds(750, 430, room2bagicon.getIconWidth(), room2bagicon.getIconHeight());
        room2bag.setBorderPainted(false);
        room2bag.setContentAreaFilled(false);
        room2bag.setFocusPainted(false);
        room2bag.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	room2bag.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	room2bag.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	room2tobag();
            }
        });
        ImageIcon wolficon = new ImageIcon(GameMap.class.getResource("../source/wolf.png"));
        JButton wolf = new JButton(wolficon);
        wolf.setBounds(548, 240, wolficon.getIconWidth(), wolficon.getIconHeight());
        wolf.setBorderPainted(false);
        wolf.setContentAreaFilled(false);
        wolf.setFocusPainted(false);
        wolf.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	wolf.setVisible(false);
            }
        });
        ImageIcon virusdetailicon = new ImageIcon(GameMap.class.getResource("../source/virusdetail.png"));
        JButton virusdetail = new JButton(virusdetailicon);
        virusdetail.setVisible(false);
        virusdetail.setBounds(0, 0, virusdetailicon.getIconWidth(), virusdetailicon.getIconHeight());
        virusdetail.setBorderPainted(false);
        virusdetail.setContentAreaFilled(false);
        virusdetail.setFocusPainted(false);
        virusdetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	virusdetail.setVisible(false);
            }
        });
        ImageIcon virusicon = new ImageIcon(GameMap.class.getResource("../source/virus.png"));
        JButton virus = new JButton(virusicon);
        virus.setBounds(563, 267, virusicon.getIconWidth(), virusicon.getIconHeight());
        virus.setBorderPainted(false);
        virus.setContentAreaFilled(false);
        virus.setFocusPainted(false);
        virus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	virus.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	virus.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	virusdetail.setVisible(true);
            	Item itemvirus = new Item("virus");
                Bag.getInstance().addItem(itemvirus);
                virus.setVisible(false);
            }
        });
        ImageIcon bagpuzzle2icon = new ImageIcon(GameMap.class.getResource("../source/bagpuzzle.png"));
        JButton bagpuzzle2 = new JButton(bagpuzzle2icon);
        bagpuzzle2.setVisible(false);
        bagpuzzle2.setBounds(150, 440, bagpuzzle2icon.getIconWidth(), bagpuzzle2icon.getIconHeight());
        bagpuzzle2.setBorderPainted(false);
        bagpuzzle2.setContentAreaFilled(false);
        bagpuzzle2.setFocusPainted(false);
        
        ImageIcon blooddetailicon = new ImageIcon(GameMap.class.getResource("../source/blooddetail.png"));
        JButton blooddetail = new JButton(blooddetailicon);
        blooddetail.setVisible(false);
        blooddetail.setBounds(0, 0, blooddetailicon.getIconWidth(), blooddetailicon.getIconHeight());
        blooddetail.setBorderPainted(false);
        blooddetail.setContentAreaFilled(false);
        blooddetail.setFocusPainted(false);
        blooddetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	blooddetail.setVisible(false);
            }
        });
        ImageIcon bloodpuzzleicon = new ImageIcon(GameMap.class.getResource("../source/bloodpuzzle.png"));
        JButton bloodpuzzle = new JButton(bloodpuzzleicon);
        bloodpuzzle.setVisible(false);
        bloodpuzzle.setBounds(350, 100, bloodpuzzleicon.getIconWidth(), bloodpuzzleicon.getIconHeight());
        bloodpuzzle.setBorderPainted(false);
        bloodpuzzle.setContentAreaFilled(false);
        bloodpuzzle.setFocusPainted(false);
        bloodpuzzle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	bagpuzzle2.setVisible(false);
            	bloodpuzzle.setVisible(false);
            	if (Bag.getInstance().containsItem("syringe")) {
            		syringebag.setVisible(false);
            	}
            }
        });
        
        
        syringebag.setVisible(false);
        syringebag.setBounds(180, 470, syringebagicon.getIconWidth(), syringebagicon.getIconHeight());
        syringebag.setBorderPainted(false);
        syringebag.setContentAreaFilled(false);
        syringebag.setFocusPainted(false);
        syringebag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Item itemblood = new Item("blood");
                Bag.getInstance().addItem(itemblood);
                syringebag.setVisible(false);
                bloodpuzzle.setVisible(false);
                bagpuzzle2.setVisible(false);
                blooddetail.setVisible(true);
            }
        });
        ImageIcon bloodicon = new ImageIcon(GameMap.class.getResource("../source/blood.png"));
        JButton blood = new JButton(bloodicon);
        blood.setBounds(220, 196, bloodicon.getIconWidth(), bloodicon.getIconHeight());
        blood.setBorderPainted(false);
        blood.setContentAreaFilled(false);
        blood.setFocusPainted(false);
        blood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	bagpuzzle2.setVisible(true);
            	bloodpuzzle.setVisible(true);
            	if (Bag.getInstance().containsItem("syringe")) {
            		syringebag.setVisible(true);
            	}
            }
        });
        room2.setLayout(null);
        room2.add(room2bag);
        room2.add(blooddetail);
        room2.add(syringebag);
        room2.add(bagpuzzle2);
        room2.add(bloodpuzzle);
        room2.add(blood);
        room2.add(wolf);
        room2.add(virusdetail);
        room2.add(virus);
        room2.add(room2to1);
        
     // Room3 Panel
        room3 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/roomf-3.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        ImageIcon room3to1icon = new ImageIcon(GameMap.class.getResource("../source/down.png"));
        JButton room3to1 = new JButton(room3to1icon);
        room3to1.setBounds(420, 490, room3to1icon.getIconWidth(), room3to1icon.getIconHeight());
        room3to1.setBorderPainted(false);
        room3to1.setContentAreaFilled(false);
        room3to1.setFocusPainted(false);
        room3to1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	room3to1();
            }
        });
        ImageIcon room3bagicon = new ImageIcon(GameMap.class.getResource("../source/bagButton.png"));
        JButton room3bag = new JButton(room3bagicon);
        room3bag.setBounds(750, 430, room3bagicon.getIconWidth(), room3bagicon.getIconHeight());
        room3bag.setBorderPainted(false);
        room3bag.setContentAreaFilled(false);
        room3bag.setFocusPainted(false);
        room3bag.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	room3bag.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	room3bag.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	room3tobag();
            }
        });
        /**
         * 백신을 조합하는 버튼
         */
        ImageIcon ifvacicon = new ImageIcon(GameMap.class.getResource("../source/completebutton.png"));
        JButton ifvac = new JButton(ifvacicon);
        ifvac.setVisible(false);
        ifvac.setBounds(260, 130, ifvacicon.getIconWidth(), ifvacicon.getIconHeight());
        ifvac.setBorderPainted(false);
        ifvac.setContentAreaFilled(false);
        ifvac.setFocusPainted(false);
        ifvac.addMouseListener(new MouseAdapter() {
        	@Override
            public void mouseEntered(MouseEvent e) {
        		ifvac.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	ifvac.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
            	tohiddenend();
            }
        });
        ImageIcon ifvaciconbefore = new ImageIcon(GameMap.class.getResource("../source/makebutton.png"));
        JButton ifvacbefore = new JButton(ifvaciconbefore);
        ifvacbefore.setVisible(false);
        ifvacbefore.setBounds(260, 130, ifvaciconbefore.getIconWidth(), ifvaciconbefore.getIconHeight());
        ifvacbefore.setBorderPainted(false);
        ifvacbefore.setContentAreaFilled(false);
        ifvacbefore.setFocusPainted(false);

        ImageIcon bagpuzzle3icon = new ImageIcon(GameMap.class.getResource("../source/bagpuzzle.png"));
        JButton bagpuzzle3 = new JButton(bagpuzzle3icon);
        bagpuzzle3.setVisible(false);
        bagpuzzle3.setBounds(150, 440, bagpuzzle3icon.getIconWidth(), bagpuzzle3icon.getIconHeight());
        bagpuzzle3.setBorderPainted(false);
        bagpuzzle3.setContentAreaFilled(false);
        bagpuzzle3.setFocusPainted(false);
        
        ImageIcon moniterdetailicon = new ImageIcon(GameMap.class.getResource("../source/moniterdetail.png"));
        JButton moniterdetail = new JButton(moniterdetailicon);
        moniterdetail.setVisible(false);
        moniterdetail.setBounds(0, 0, moniterdetailicon.getIconWidth(), moniterdetailicon.getIconHeight());
        moniterdetail.setBorderPainted(false);
        moniterdetail.setContentAreaFilled(false);
        moniterdetail.setFocusPainted(false);
        moniterdetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	moniterdetail.setVisible(false);
            	bagpuzzle3.setVisible(false);
            	ifvacbefore.setVisible(false);
            	if (Bag.getInstance().containsItem("virus")) {
            		virusbag.setVisible(true);
            	}
            	if (Bag.getInstance().containsItem("blood")) {
                	bloodbag.setVisible(true);
            	}
            }
        });
        
        bloodbag.setVisible(false);
        bloodbag.setBounds(320, 470, bloodbagicon.getIconWidth(), bloodbagicon.getIconHeight());
        bloodbag.setBorderPainted(false);
        bloodbag.setContentAreaFilled(false);
        bloodbag.setFocusPainted(false);
        bloodbag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	bloodbag.setVisible(false);
            	ifvac.setVisible(true);
            }
        });
        
        virusbag.setVisible(false);
        virusbag.setBounds(190, 470, virusbagicon.getIconWidth(), virusbagicon.getIconHeight());
        virusbag.setBorderPainted(false);
        virusbag.setContentAreaFilled(false);
        virusbag.setFocusPainted(false);
        virusbag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                virusbag.setVisible(false);
                ifvacbefore.setVisible(true);
                if (Bag.getInstance().containsItem("blood")) {
                	bloodbag.setVisible(true);
            	}
            }
        });
        ImageIcon monitericon = new ImageIcon(GameMap.class.getResource("../source/moniter.png"));
        JButton moniter = new JButton(monitericon);
        moniter.setBounds(423, 247, monitericon.getIconWidth(), monitericon.getIconHeight());
        moniter.setBorderPainted(false);
        moniter.setContentAreaFilled(false);
        moniter.setFocusPainted(false);
        moniter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	moniter.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	moniter.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	moniterdetail.setVisible(true);
            	bagpuzzle3.setVisible(true);
            	if (Bag.getInstance().containsItem("virus")) {
            		virusbag.setVisible(true);
            	}
            }
        });
        
        room3.setLayout(null);
        room3.add(room3bag);
        room3.add(room3to1);
        room3.add(bloodbag);
        room3.add(virusbag);
        room3.add(bagpuzzle3);
        room3.add(ifvac);
        room3.add(ifvacbefore);
        room3.add(moniterdetail);
        room3.add(moniter);
        /**
         * 가방 ui 패널
         */
        bagPanel = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/bagtool.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        ImageIcon bagexitbuttonicon = new ImageIcon(GameMap.class.getResource("../source/bagexit.png"));
        JButton bagexitbutton = new JButton(bagexitbuttonicon);
        bagexitbutton.setVisible(true);
        bagexitbutton.setBounds(800, 50, bagexitbuttonicon.getIconWidth(), bagexitbuttonicon.getIconHeight());
        bagexitbutton.setBorderPainted(false);
        bagexitbutton.setContentAreaFilled(false);
        bagexitbutton.setFocusPainted(false);
        bagexitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	bagtoroom1();
            }
        });
        
        ImageIcon bagkeydetailicon = new ImageIcon(GameMap.class.getResource("../source/key2.png"));
        JButton bagkeydetail = new JButton(bagkeydetailicon);
        bagkeydetail.setVisible(false);
        bagkeydetail.setBounds(0, 0, bagkeydetailicon.getIconWidth(), bagkeydetailicon.getIconHeight());
        bagkeydetail.setBorderPainted(false);
        bagkeydetail.setContentAreaFilled(false);
        bagkeydetail.setFocusPainted(false);
        bagkeydetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	bagkeydetail.setVisible(false);
            }
        });
        ImageIcon bagcutterdetailicon = new ImageIcon(GameMap.class.getResource("../source/cutter2.png"));
        JButton bagcutterdetail = new JButton(bagcutterdetailicon);
        bagcutterdetail.setVisible(false);
        bagcutterdetail.setBounds(0, 0, bagcutterdetailicon.getIconWidth(), bagcutterdetailicon.getIconHeight());
        bagcutterdetail.setBorderPainted(false);
        bagcutterdetail.setContentAreaFilled(false);
        bagcutterdetail.setFocusPainted(false);
        bagcutterdetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	bagcutterdetail.setVisible(false);
            }
        });
        ImageIcon bagletterdetailicon = new ImageIcon(GameMap.class.getResource("../source/letter2.png"));
        JButton bagletterdetail = new JButton(bagletterdetailicon);
        bagletterdetail.setVisible(false);
        bagletterdetail.setBounds(0, 0, bagletterdetailicon.getIconWidth(), bagletterdetailicon.getIconHeight());
        bagletterdetail.setBorderPainted(false);
        bagletterdetail.setContentAreaFilled(false);
        bagletterdetail.setFocusPainted(false);
        bagletterdetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	bagletterdetail.setVisible(false);
            }
        });
        ImageIcon bagarmdetailicon = new ImageIcon(GameMap.class.getResource("../source/arm2.png"));
        JButton bagarmdetail = new JButton(bagarmdetailicon);
        bagarmdetail.setVisible(false);
        bagarmdetail.setBounds(0, 0, bagarmdetailicon.getIconWidth(), bagarmdetailicon.getIconHeight());
        bagarmdetail.setBorderPainted(false);
        bagarmdetail.setContentAreaFilled(false);
        bagarmdetail.setFocusPainted(false);
        bagarmdetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	bagarmdetail.setVisible(false);
            }
        });
        ImageIcon bagsyringedetailicon = new ImageIcon(GameMap.class.getResource("../source/syringe1.png"));
        JButton bagsyringedetail = new JButton(bagsyringedetailicon);
        bagsyringedetail.setVisible(false);
        bagsyringedetail.setBounds(0, 0, bagsyringedetailicon.getIconWidth(), bagsyringedetailicon.getIconHeight());
        bagsyringedetail.setBorderPainted(false);
        bagsyringedetail.setContentAreaFilled(false);
        bagsyringedetail.setFocusPainted(false);
        bagsyringedetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	bagsyringedetail.setVisible(false);
            }
        });
        ImageIcon baghiddenkeydetailicon = new ImageIcon(GameMap.class.getResource("../source/hiddenkey1.png"));
        JButton baghiddenkeydetail = new JButton(baghiddenkeydetailicon);
        baghiddenkeydetail.setVisible(false);
        baghiddenkeydetail.setBounds(0, 0, baghiddenkeydetailicon.getIconWidth(), baghiddenkeydetailicon.getIconHeight());
        baghiddenkeydetail.setBorderPainted(false);
        baghiddenkeydetail.setContentAreaFilled(false);
        baghiddenkeydetail.setFocusPainted(false);
        baghiddenkeydetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	baghiddenkeydetail.setVisible(false);
            }
        });
        ImageIcon bagvirusdetailicon = new ImageIcon(GameMap.class.getResource("../source/virusdetail.png"));
        JButton bagvirusdetail = new JButton(bagvirusdetailicon);
        bagvirusdetail.setVisible(false);
        bagvirusdetail.setBounds(0, 0, bagvirusdetailicon.getIconWidth(), bagvirusdetailicon.getIconHeight());
        bagvirusdetail.setBorderPainted(false);
        bagvirusdetail.setContentAreaFilled(false);
        bagvirusdetail.setFocusPainted(false);
        bagvirusdetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	bagvirusdetail.setVisible(false);
            }
        });
        ImageIcon bagblooddetailicon = new ImageIcon(GameMap.class.getResource("../source/blooddetail.png"));
        JButton bagblooddetail = new JButton(bagblooddetailicon);
        bagblooddetail.setVisible(false);
        bagblooddetail.setBounds(0, 0, bagblooddetailicon.getIconWidth(), bagblooddetailicon.getIconHeight());
        bagblooddetail.setBorderPainted(false);
        bagblooddetail.setContentAreaFilled(false);
        bagblooddetail.setFocusPainted(false);
        bagblooddetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	bagblooddetail.setVisible(false);
            }
        });
        

        bagkey.setVisible(false);
        bagkey.setBounds(520, 170, bagkeyicon.getIconWidth(), bagkeyicon.getIconHeight());
        bagkey.setBorderPainted(false);
        bagkey.setContentAreaFilled(false);
        bagkey.setFocusPainted(false);
        bagkey.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	bagkeydetail.setVisible(true);
            }
        });
        bagcutter.setVisible(false);
        bagcutter.setBounds(400, 170, bagcuttericon.getIconWidth(), bagcuttericon.getIconHeight());
        bagcutter.setBorderPainted(false);
        bagcutter.setContentAreaFilled(false);
        bagcutter.setFocusPainted(false);
        bagcutter.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	bagcutterdetail.setVisible(true);
            }
        });
        bagletter.setVisible(false);
        bagletter.setBounds(290, 170, baglettericon.getIconWidth(), baglettericon.getIconHeight());
        bagletter.setBorderPainted(false);
        bagletter.setContentAreaFilled(false);
        bagletter.setFocusPainted(false);
        bagletter.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	bagletterdetail.setVisible(true);
            }
        });
        bagarm.setVisible(false);
        bagarm.setBounds(290, 270, bagarmicon.getIconWidth(), bagarmicon.getIconHeight());
        bagarm.setBorderPainted(false);
        bagarm.setContentAreaFilled(false);
        bagarm.setFocusPainted(false);
        bagarm.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	bagarmdetail.setVisible(true);
            }
        });
        bagsyringe.setVisible(false);
        bagsyringe.setBounds(400, 270, bagsyringeicon.getIconWidth(), bagsyringeicon.getIconHeight());
        bagsyringe.setBorderPainted(false);
        bagsyringe.setContentAreaFilled(false);
        bagsyringe.setFocusPainted(false);
        bagsyringe.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	bagsyringedetail.setVisible(true);
            }
        });
        baghiddenkey.setVisible(false);
        baghiddenkey.setBounds(520, 270, baghiddenkeyicon.getIconWidth(), baghiddenkeyicon.getIconHeight());
        baghiddenkey.setBorderPainted(false);
        baghiddenkey.setContentAreaFilled(false);
        baghiddenkey.setFocusPainted(false);
        baghiddenkey.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	baghiddenkeydetail.setVisible(true);
            }
        });
        bagvirus.setVisible(false);
        bagvirus.setBounds(290, 370, bagvirusicon.getIconWidth(), bagvirusicon.getIconHeight());
        bagvirus.setBorderPainted(false);
        bagvirus.setContentAreaFilled(false);
        bagvirus.setFocusPainted(false);
        bagvirus.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	bagvirusdetail.setVisible(true);
            }
        });
        bagblood.setVisible(false);
        bagblood.setBounds(400, 370, bagbloodicon.getIconWidth(), bagbloodicon.getIconHeight());
        bagblood.setBorderPainted(false);
        bagblood.setContentAreaFilled(false);
        bagblood.setFocusPainted(false);
        bagblood.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	bagblooddetail.setVisible(true);
            }
        });
        bagPanel.setLayout(null);
        bagPanel.add(bagvirusdetail);
        bagPanel.add(bagblooddetail);
        bagPanel.add(bagkeydetail);
        bagPanel.add(bagcutterdetail);
        bagPanel.add(bagletterdetail);
        bagPanel.add(bagarmdetail);
        bagPanel.add(bagsyringedetail);
        bagPanel.add(baghiddenkeydetail);
        bagPanel.add(bagexitbutton);
        bagPanel.add(bagkey);
        bagPanel.add(bagcutter);
        bagPanel.add(bagletter);
        bagPanel.add(bagarm);
        bagPanel.add(bagsyringe);
        bagPanel.add(baghiddenkey);
        bagPanel.add(bagvirus);
        bagPanel.add(bagblood);
    }
    
    //room1 전환
    private void room1to3() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room1);
    	frame.getContentPane().remove(room1);
    	frame.getContentPane().add(room3);
    	frame.revalidate();
		frame.repaint();
    }
    
    private void room1to2() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room1);
    	frame.getContentPane().remove(room1);
    	frame.getContentPane().add(room2);
    	frame.revalidate();
		frame.repaint();
    }
    
    private void floorfto1() {
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room1);
        frame.getContentPane().remove(room1);

        // Create floor2 object
        floor1 floor1 = new floor1();

        // Add room1 panel to the frame
        frame.getContentPane().add(floor1.room2);
        
        if(SetSound.nowmp3%2==0) {
            SetSound.playBlackMagicBGM();}

        frame.revalidate();
        frame.repaint();
    }
    
    //room2 전환
    private void room2to1() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room2);
    	frame.getContentPane().remove(room2);
    	frame.getContentPane().add(room1);
    	frame.revalidate();
		frame.repaint();
    }
    
    //room3 전환
    private void room3to1() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room3);
    	frame.getContentPane().remove(room3);
    	frame.getContentPane().add(room1);
    	frame.revalidate();
		frame.repaint();
    }
    /**
     * 히든 엔딩으로 가는 기능
     */
    private void tohiddenend() {
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room3);
        frame.getContentPane().remove(room3);

        
        hiddenend hiddenend = new hiddenend();

        
        frame.getContentPane().add(hiddenend.hiddenend1);
        /**
         * nowmp3가 짝수이면(배경음 버튼을 누른 적 없거나, 배경음을 껐다 켰을 때) 배경음악이 바뀜
         * 홀수라면 그대로 배경음악이 나오지 않음
         */
        if(SetSound.nowmp3%2==0) {
            SetSound.playhappyendBGM();}


        frame.revalidate();
        frame.repaint();
    }
    /**
     * 버튼을 순서대로 눌렀는지 확인하는 로직
     */
    private void checkLocker() {
        if (doorlock.length() == 4) {
            if (doorlock.equals("1432")) {
            	animal.setVisible(false);
            	sheep.setVisible(false);
            	bird.setVisible(false);
            	snake.setVisible(false);
            	fish.setVisible(false);
            	room1to3puzzle.setVisible(false);
            	
            	room1to3();
            } else {
            	if(SetSound.noweffect%2==0) {
                	SetSound.playNoSoundOnce();}
            	doorlock = ""; // Reset the locker if not the correct combination
            }
        }
    }
    /**
     * 방1에서 가방 ui를 출력해주는 패널이
     */
    private void room1tobag() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room1);
    	frame.getContentPane().remove(room1);
    	frame.getContentPane().add(bagPanel);
    	frame.revalidate();
		frame.repaint();
		
		if (Bag.getInstance().containsItem("key")) {
    		bagkey.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("cutter")) {
			bagcutter.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("letter")) {
			bagletter.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("arm")) {
			bagarm.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("syringe")) {
			bagsyringe.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("hiddenkey")) {
			baghiddenkey.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("virus")) {
			bagvirus.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("blood")) {
    		bagblood.setVisible(true);
		}
    }
    /**
     * 방2에서 가방 ui를 출력해주는 패널
     */
    private void room2tobag() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room2);
    	frame.getContentPane().remove(room2);
    	frame.getContentPane().add(bagPanel);
    	frame.revalidate();
		frame.repaint();
		
		if (Bag.getInstance().containsItem("key")) {
    		bagkey.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("cutter")) {
			bagcutter.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("letter")) {
			bagletter.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("arm")) {
			bagarm.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("syringe")) {
			bagsyringe.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("hiddenkey")) {
			baghiddenkey.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("virus")) {
			bagvirus.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("blood")) {
    		bagblood.setVisible(true);
		}
    }
    /**
     * 방3에서 가방 ui를 출력해주는 패널
     */
    private void room3tobag() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room3);
    	frame.getContentPane().remove(room3);
    	frame.getContentPane().add(bagPanel);
    	frame.revalidate();
		frame.repaint();
		
		if (Bag.getInstance().containsItem("key")) {
    		bagkey.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("cutter")) {
			bagcutter.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("letter")) {
			bagletter.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("arm")) {
			bagarm.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("syringe")) {
			bagsyringe.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("hiddenkey")) {
			baghiddenkey.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("virus")) {
			bagvirus.setVisible(true);
    	}
		if (Bag.getInstance().containsItem("blood")) {
    		bagblood.setVisible(true);
		}
    }
    /**
     * 가방 ui를 종료해주는 패널
     */
    private void bagtoroom1() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(bagPanel);
    	frame.getContentPane().remove(bagPanel);
    	frame.getContentPane().add(room1);
    	frame.revalidate();
		frame.repaint();
    }
}
