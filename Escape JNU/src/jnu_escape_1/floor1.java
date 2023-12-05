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

public class floor1 extends JPanel{
	/**
     * 로비 패널
     */
	public static JPanel room1;
	/**
     * 복도 패널
     */
    public static JPanel room2;
    /**
     * 도서실 패널
     */
    public static JPanel room3;
    /**
     * 과학실 패널
     */
    public static JPanel room4;
    /**
     * 가방 ui를 출력해주는 패널
     */
    public static JPanel bagPanel;
    
    /**
     * 가방 아이템 이미지들
     */
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
    
    ImageIcon arm3icon = new ImageIcon(GameMap.class.getResource("../source/arm3.png"));
    JButton arm3 = new JButton(arm3icon);
    
    /**
     * 방향 이미지와 버튼을 선언하여 여러 함수에서 쓸 수 있도록 함
     */
    private JButton directionButton1;
    private ImageIcon[] directionimages1;
    private int currentImageIndex1;
    
    private JButton directionButton2;
    private ImageIcon[] directionimages2;
    private int currentImageIndex2;
    
    private JButton directionButton3;
    private ImageIcon[] directionimages3;
    private int currentImageIndex3;
    
    private JButton directionButton4;
    private ImageIcon[] directionimages4;
    private int currentImageIndex4;
    
    /**
     * 게임 클리어 정보 저장(초기에는 false)
     */
    private static gameclear gameClearStatus = new gameclear(false);
    
    /**
     * 마우스 커서 이미지 설정
     */
    private Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(
            new ImageIcon(getClass().getResource("../source/mouse.png")).getImage(), new Point(0, 0), "customCursor");

    
    public floor1() {
    	/**
         * Room1 패널
         */
        room1 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/room1-1-2.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        /**
         * 오른쪽 버튼
         */
        ImageIcon righticon = new ImageIcon(GameMap.class.getResource("../source/right.png"));
        JButton toroom2 = new JButton(righticon);
        toroom2.setBounds(820, 250, righticon.getIconWidth(), righticon.getIconHeight());
        toroom2.setBorderPainted(false);
        toroom2.setContentAreaFilled(false);
        toroom2.setFocusPainted(false);
        toroom2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	room1to2();
            }
        });
        /**
         * 가방 ui
         */
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
         * 좀비가 문 앞을 막고 있음
         */
        ImageIcon zombesicon = new ImageIcon(GameMap.class.getResource("../source/zombes.png"));
        JButton zombes = new JButton(zombesicon);
        zombes.setBounds(0, 0, zombesicon.getIconWidth(), zombesicon.getIconHeight());
        zombes.setBorderPainted(false);
        zombes.setContentAreaFilled(false);
        zombes.setFocusPainted(false);
        /**
         * 좀비가 구멍에 빠진 화면 출력
         */
        ImageIcon zombieholeicon = new ImageIcon(GameMap.class.getResource("../source/zombiehole.png"));
        JButton zombiehole = new JButton(zombieholeicon);
        zombiehole.setVisible(false);
        zombiehole.setBounds(540, 180, zombieholeicon.getIconWidth(), zombieholeicon.getIconHeight());
        zombiehole.setBorderPainted(false);
        zombiehole.setContentAreaFilled(false);
        zombiehole.setFocusPainted(false);
        
        /**
         * 가방 아이템 ui
         */
        ImageIcon holebagicon = new ImageIcon(GameMap.class.getResource("../source/bagpuzzle.png"));
        JButton holebag = new JButton(holebagicon);
        holebag.setVisible(false);
        holebag.setBounds(150, 440, holebagicon.getIconWidth(), holebagicon.getIconHeight());
        holebag.setBorderPainted(false);
        holebag.setContentAreaFilled(false);
        holebag.setFocusPainted(false);
        
        /**
         * 구멍을 자세히 보는 버튼
         */
        ImageIcon holedetailicon = new ImageIcon(GameMap.class.getResource("../source/holedetail.png"));
        JButton holedetail = new JButton(holedetailicon);
        holedetail.setVisible(false);
        holedetail.setBounds(200, 50, holedetailicon.getIconWidth(), holedetailicon.getIconHeight());
        holedetail.setBorderPainted(false);
        holedetail.setContentAreaFilled(false);
        holedetail.setFocusPainted(false);
        holedetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	holedetail.setVisible(false);
            	holebag.setVisible(false);
            	if (Bag.getInstance().containsItem("arm")) {
            		arm3.setVisible(false);
            	}
            }
        });
        /**
         * 키 아이템 사용하는 버튼 
         */
        ImageIcon key3icon = new ImageIcon(GameMap.class.getResource("../source/key3.png"));
        JButton key3 = new JButton(key3icon);
        key3.setVisible(false);
        key3.setBounds(180, 470, key3icon.getIconWidth(), key3icon.getIconHeight());
        key3.setBorderPainted(false);
        key3.setContentAreaFilled(false);
        key3.setFocusPainted(false);
        key3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	toend();
            }
        });
        /**
         * 탈출 문 화면
         */
        ImageIcon doordetailicon = new ImageIcon(GameMap.class.getResource("../source/lobbydoor.png"));
        JButton doordetail = new JButton(doordetailicon);
        doordetail.setVisible(false);
        doordetail.setBounds(0, 0, doordetailicon.getIconWidth(), doordetailicon.getIconHeight());
        doordetail.setBorderPainted(false);
        doordetail.setContentAreaFilled(false);
        doordetail.setFocusPainted(false);
        doordetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	holebag.setVisible(false);
            	doordetail.setVisible(false);
            	if (Bag.getInstance().containsItem("key")) {
            		key3.setVisible(false);
            	}
            }
        });
        /**
         * 탈출 문 화면 출력
         */
        ImageIcon door1icon = new ImageIcon(GameMap.class.getResource("../source/endingdoor.png"));
        JButton door1 = new JButton(door1icon);
        door1.setVisible(false);
        door1.setBounds(120, 0, door1icon.getIconWidth(), door1icon.getIconHeight());
        door1.setBorderPainted(false);
        door1.setContentAreaFilled(false);
        door1.setFocusPainted(false);
        door1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	door1.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	door1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	doordetail.setVisible(true);
            	key3.setVisible(true);
            	holebag.setVisible(true);
            	if (Bag.getInstance().containsItem("key")) {
            		key3.setVisible(true);
            	}
            }
        });
        /**
         * 팔 아이템을 사용하는 버튼
         */
        arm3.setVisible(false);
        arm3.setBounds(180, 470, arm3icon.getIconWidth(), arm3icon.getIconHeight());
        arm3.setBorderPainted(false);
        arm3.setContentAreaFilled(false);
        arm3.setFocusPainted(false);
        arm3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	zombes.setVisible(false);
            	zombiehole.setVisible(true);
            	holebag.setVisible(false);
            	holedetail.setVisible(false);
            	arm3.setVisible(false);
            	door1.setVisible(true);
            }
        });
        /**
         * 구멍 퍼즐을 출력하는 버튼
         */
        ImageIcon holeicon = new ImageIcon(GameMap.class.getResource("../source/hole.png"));
        JButton hole = new JButton(holeicon);
        hole.setBounds(530, 182, holeicon.getIconWidth(), holeicon.getIconHeight());
        hole.setBorderPainted(false);
        hole.setContentAreaFilled(false);
        hole.setFocusPainted(false);
        hole.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	hole.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	hole.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	holedetail.setVisible(true);
            	holebag.setVisible(true);
            	if (Bag.getInstance().containsItem("arm")) {
            		arm3.setVisible(true);
            	}
            }
        });
        
        
        room1.setLayout(null);
        room1.add(arm3);
        room1.add(key3);
        room1.add(holebag);
        room1.add(holedetail);
        room1.add(doordetail);
        room1.add(door1);
        room1.add(zombes);
        room1.add(zombiehole);
        room1.add(room1bag);
        room1.add(toroom2);
        room1.add(hole);
        
        
        
        /**
         * Room2 패널
         */
        room2 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/room1-2.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        /**
         * 2번 방에서 4번 방으로 가는 버튼
         */
        ImageIcon room2to4icon = new ImageIcon(GameMap.class.getResource("../source/left.png"));
        JButton room2to4 = new JButton(room2to4icon);
        room2to4.setBounds(20, 250, room2to4icon.getIconWidth(), room2to4icon.getIconHeight());
        room2to4.setBorderPainted(false);
        room2to4.setContentAreaFilled(false);
        room2to4.setFocusPainted(false);
        room2to4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	room2to1();
            }
        });
        /**
         * 2번 방에서 1번 방으로 가는 버튼
         */
        ImageIcon room2to1icon = new ImageIcon(GameMap.class.getResource("../source/right.png"));
        JButton room2to1 = new JButton(room2to1icon);
        room2to1.setBounds(820, 250, room2to1icon.getIconWidth(), room2to1icon.getIconHeight());
        room2to1.setBorderPainted(false);
        room2to1.setContentAreaFilled(false);
        room2to1.setFocusPainted(false);
        room2to1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	room2to4();
            }
        });
        /**
         * 3번 방 가는 문 버튼
         */
        ImageIcon room3dooricon = new ImageIcon(GameMap.class.getResource("../source/1door.png"));
        JButton room3door = new JButton(room3dooricon);
        room3door.setBounds(630, 100, room3dooricon.getIconWidth(), room3dooricon.getIconHeight());
        room3door.setBorderPainted(false);
        room3door.setContentAreaFilled(false);
        room3door.setFocusPainted(false);
        room3door.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	room2to3();
            }
        });
        /**
         * 2층으로 가는 계단 버튼
         */
        ImageIcon room3stricon = new ImageIcon(GameMap.class.getResource("../source/1st.png"));
        JButton room3str = new JButton(room3stricon);
        room3str.setBounds(260, 0, room3stricon.getIconWidth(), room3stricon.getIconHeight());
        room3str.setBorderPainted(false);
        room3str.setContentAreaFilled(false);
        room3str.setFocusPainted(false);
        room3str.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	tofloor2();
            }
        });
        /**
         * 가방 ui 버튼
         */
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
        /**
         * 이미지를 리스트 형태로 저장하여 순환
         */
        directionimages1 = new ImageIcon[4];
        directionimages1[0] = new ImageIcon(GameMap.class.getResource("../source/directionup.png"));
        directionimages1[1] = new ImageIcon(GameMap.class.getResource("../source/directionright.png"));
        directionimages1[2] = new ImageIcon(GameMap.class.getResource("../source/directiondown.png"));
        directionimages1[3] = new ImageIcon(GameMap.class.getResource("../source/directionleft.png"));
        
        directionimages2 = new ImageIcon[4];
        directionimages2[0] = new ImageIcon(GameMap.class.getResource("../source/directionup.png"));
        directionimages2[1] = new ImageIcon(GameMap.class.getResource("../source/directionright.png"));
        directionimages2[2] = new ImageIcon(GameMap.class.getResource("../source/directiondown.png"));
        directionimages2[3] = new ImageIcon(GameMap.class.getResource("../source/directionleft.png"));
        
        directionimages3 = new ImageIcon[4];
        directionimages3[0] = new ImageIcon(GameMap.class.getResource("../source/directionup.png"));
        directionimages3[1] = new ImageIcon(GameMap.class.getResource("../source/directionright.png"));
        directionimages3[2] = new ImageIcon(GameMap.class.getResource("../source/directiondown.png"));
        directionimages3[3] = new ImageIcon(GameMap.class.getResource("../source/directionleft.png"));
        
        directionimages4 = new ImageIcon[4];
        directionimages4[0] = new ImageIcon(GameMap.class.getResource("../source/directionup.png"));
        directionimages4[1] = new ImageIcon(GameMap.class.getResource("../source/directionright.png"));
        directionimages4[2] = new ImageIcon(GameMap.class.getResource("../source/directiondown.png"));
        directionimages4[3] = new ImageIcon(GameMap.class.getResource("../source/directionleft.png"));
        /**
         * 방향 퍼즐 배경
         */
        ImageIcon directionPuzzleicon = new ImageIcon(GameMap.class.getResource("../source/directionpuzzle.png"));
        JButton directionPuzzle = new JButton(directionPuzzleicon);
        directionPuzzle.setVisible(false);
        directionPuzzle.setBounds(150, 50, directionPuzzleicon.getIconWidth(), directionPuzzleicon.getIconHeight());
        directionPuzzle.setBorderPainted(false);
        directionPuzzle.setContentAreaFilled(false);
        directionPuzzle.setFocusPainted(false);
        directionPuzzle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	directionPuzzle.setVisible(false);
            	directionButton1.setVisible(false);
            	directionButton2.setVisible(false);
            	directionButton3.setVisible(false);
            	directionButton4.setVisible(false);
            }
        });
        /**
         * 방향 퍼즐을 출력하는 버튼
         */
        ImageIcon tofloorfPuzzleicon = new ImageIcon(GameMap.class.getResource("../source/1door2.png"));
        JButton tofloorfPuzzle = new JButton(tofloorfPuzzleicon);
        tofloorfPuzzle.setBounds(40, 100, tofloorfPuzzleicon.getIconWidth(), tofloorfPuzzleicon.getIconHeight());
        tofloorfPuzzle.setBorderPainted(false);
        tofloorfPuzzle.setContentAreaFilled(false);
        tofloorfPuzzle.setFocusPainted(false);
        tofloorfPuzzle.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	if (gameClearStatus.isGameCleared()) {
            		directionPuzzle.setVisible(true);
                	directionButton1.setVisible(true);
                	directionButton2.setVisible(true);
                	directionButton3.setVisible(true);
                	directionButton4.setVisible(true);
            	}
            }
        });
        /**
         * 방향을 조절하는 버튼
         */
        directionButton1 = new JButton(directionimages1[currentImageIndex1]);
        directionButton1.setVisible(false);
        directionButton1.setBounds(205, 185, 120, 120);
        directionButton1.setBorderPainted(false);
        directionButton1.setContentAreaFilled(false);
        directionButton1.setFocusPainted(false);
        directionButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage1();
                if (currentImageIndex1 == 3 && currentImageIndex2 == 0 && currentImageIndex3 == 2 && currentImageIndex4 == 3) {
                    tofloorfPuzzle.setVisible(false);
                    directionPuzzle.setVisible(false);
                    directionButton1.setVisible(false);
                    directionButton2.setVisible(false);
                    directionButton3.setVisible(false);
                    directionButton4.setVisible(false);
                    tofloorfPuzzle.setEnabled(false);
                    tofloorf();
                }
            }
        });
        
        directionButton2 = new JButton(directionimages2[currentImageIndex2]);
        directionButton2.setVisible(false);
        directionButton2.setBounds(340, 185, 120, 120);
        directionButton2.setBorderPainted(false);
        directionButton2.setContentAreaFilled(false);
        directionButton2.setFocusPainted(false);
        directionButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage2();
                if (currentImageIndex1 == 3 && currentImageIndex2 == 0 && currentImageIndex3 == 2 && currentImageIndex4 == 3) {
                    tofloorfPuzzle.setVisible(false);
                    directionPuzzle.setVisible(false);
                    directionButton1.setVisible(false);
                    directionButton2.setVisible(false);
                    directionButton3.setVisible(false);
                    directionButton4.setVisible(false);
                    tofloorfPuzzle.setEnabled(false);
                    tofloorf();
                }
            }
        });
        
        directionButton3 = new JButton(directionimages3[currentImageIndex3]);
        directionButton3.setVisible(false);
        directionButton3.setBounds(475, 185, 120, 120);
        directionButton3.setBorderPainted(false);
        directionButton3.setContentAreaFilled(false);
        directionButton3.setFocusPainted(false);
        directionButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage3();
                if (currentImageIndex1 == 3 && currentImageIndex2 == 0 && currentImageIndex3 == 2 && currentImageIndex4 == 3) {
                    tofloorfPuzzle.setVisible(false);
                    directionPuzzle.setVisible(false);
                    directionButton1.setVisible(false);
                    directionButton2.setVisible(false);
                    directionButton3.setVisible(false);
                    directionButton4.setVisible(false);
                    tofloorfPuzzle.setEnabled(false);
                    tofloorf();
                }
            }
        });
        
        directionButton4 = new JButton(directionimages4[currentImageIndex4]);
        directionButton4.setVisible(false);
        directionButton4.setBounds(610, 185, 120, 120);
        directionButton4.setBorderPainted(false);
        directionButton4.setContentAreaFilled(false);
        directionButton4.setFocusPainted(false);
        directionButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage4();
                if (currentImageIndex1 == 3 && currentImageIndex2 == 0 && currentImageIndex3 == 2 && currentImageIndex4 == 3) {
                    tofloorfPuzzle.setVisible(false);
                    directionPuzzle.setVisible(false);
                    directionButton1.setVisible(false);
                    directionButton2.setVisible(false);
                    directionButton3.setVisible(false);
                    directionButton4.setVisible(false);
                    tofloorfPuzzle.setEnabled(false);
                    /**
                     * 
                     */
                    tofloorf();
                }
            }
        });
        
        /**
         * 지하로 가는 버튼
         */
        ImageIcon tofloorficon = new ImageIcon(GameMap.class.getResource("../source/1door2.png"));
        JButton tofloorf = new JButton(tofloorficon);
        tofloorf.setBounds(40, 100, tofloorficon.getIconWidth(), tofloorficon.getIconHeight());
        tofloorf.setBorderPainted(false);
        tofloorf.setContentAreaFilled(false);
        tofloorf.setFocusPainted(false);
        tofloorf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	tofloorf();
            }
        });
        room2.setLayout(null);
        room2.add(directionButton1);
        room2.add(directionButton2);
        room2.add(directionButton3);
        room2.add(directionButton4);
        room2.add(directionPuzzle);
        room2.add(room2to1);
        room2.add(room2to4);
        room2.add(room3str);
        room2.add(room3door);
        room2.add(tofloorfPuzzle);
        room2.add(tofloorf);
        room2.add(room2bag);
        
        /**
         * 
         */
        room3 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/room1-3.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        /**
         * 가방 ui 버튼
         */
        ImageIcon room3to2icon = new ImageIcon(GameMap.class.getResource("../source/down.png"));
        JButton room3to2 = new JButton(room3to2icon);
        room3to2.setBounds(420, 490, room3to2icon.getIconWidth(), room3to2icon.getIconHeight());
        room3to2.setBorderPainted(false);
        room3to2.setContentAreaFilled(false);
        room3to2.setFocusPainted(false);
        room3to2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	room3to2();
            }
        });
        /**
         * 가방 ui 버튼
         */
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
        room3.setLayout(null);
        room3.add(room3bag);
        room3.add(room3to2);
        
        /**
         * Room4 패널
         */
        room4 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/room1-4-2.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        /**
         * 4번 방에서 2번 방으로 가는 버튼
         */
        ImageIcon room4to2icon = new ImageIcon(GameMap.class.getResource("../source/down.png"));
        JButton room4to2 = new JButton(room4to2icon);
        room4to2.setBounds(420, 490, room4to2icon.getIconWidth(), room4to2icon.getIconHeight());
        room4to2.setBorderPainted(false);
        room4to2.setContentAreaFilled(false);
        room4to2.setFocusPainted(false);
        room4to2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	room4to2();
            }
        });
        /**
         * 가방 ui 버튼
         */
        ImageIcon room4bagicon = new ImageIcon(GameMap.class.getResource("../source/bagButton.png"));
        JButton room4bag = new JButton(room4bagicon);
        room4bag.setBounds(750, 430, room4bagicon.getIconWidth(), room4bagicon.getIconHeight());
        room4bag.setBorderPainted(false);
        room4bag.setContentAreaFilled(false);
        room4bag.setFocusPainted(false);
        room4bag.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	room4bag.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	room4bag.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	room4tobag();
            }
        });
        /**
         * 팔 아이템 획득 버튼
         */
        ImageIcon armobjecticon = new ImageIcon(GameMap.class.getResource("../source/armobject.png"));
        JButton armobject = new JButton(armobjecticon);
        armobject.setBounds(670, 135, armobjecticon.getIconWidth(), armobjecticon.getIconHeight());
        armobject.setBorderPainted(false);
        armobject.setContentAreaFilled(false);
        armobject.setFocusPainted(false);
        armobject.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	armobject.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	armobject.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	Item itemArm = new Item("arm");
                Bag.getInstance().addItem(itemArm);
            	armobject.setVisible(false);
            }
        });
        /**
         * 키패드 퍼즐로 가는 버튼
         */
        ImageIcon tokeypadicon = new ImageIcon(GameMap.class.getResource("../source/keypad1.png"));
        JButton tokeypad = new JButton(tokeypadicon);
        tokeypad.setBounds(100, 180, tokeypadicon.getIconWidth(), tokeypadicon.getIconHeight());
        tokeypad.setBorderPainted(false);
        tokeypad.setContentAreaFilled(false);
        tokeypad.setFocusPainted(false);
        tokeypad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	tokeypad.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	tokeypad.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	tokeypad();
            }
        });

        room4.setLayout(null);
        room4.add(room4bag);
        room4.add(armobject);
        room4.add(room4to2);
        room4.add(tokeypad);
        
        bagPanel = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/bagtool.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        /**
         * 가방 물건 자세히보기 이미지
         */
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
            	bagtoroom2();
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
        
        /**
         * 가방 물건 이미지
         */
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
    
    
    /**
     * room2 전환
     */
    private void room1to2() {
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room1);
    	frame.getContentPane().remove(room1);
    	frame.getContentPane().add(room2);
    	frame.revalidate();
		frame.repaint();
    }
    /**
     * 가방 ui를 열면서 아이템이 있는지 확인하는 기능
     */
    private void room1tobag() {
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
     * 엔딩으로 가는 기능
     */
    private void toend() {
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room1);
        frame.getContentPane().remove(room1);

        /**
         * 엔딩 오브젝트 만듦
         */
        ending ending = new ending();

        /**
         * 엔딩 클래스의 엔딩 패널 얻어옴
         */
        frame.getContentPane().add(ending.ending);
        
        gameClearStatus = new gameclear(true);

        frame.revalidate();
        frame.repaint();
    }
    
    /**
     * room1 전환
     */
    private void room2to1() {
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room2);
    	frame.getContentPane().remove(room2);
    	frame.getContentPane().add(room1);
    	frame.revalidate();
		frame.repaint();
    }
    /**
     * room3 전환
     */
    private void room2to3() {
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room2);
    	frame.getContentPane().remove(room2);
    	frame.getContentPane().add(room3);
    	frame.revalidate();
		frame.repaint();
    }
    /**
     * room4 전환
     */
    private void room2to4() {
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room2);
    	frame.getContentPane().remove(room2);
    	frame.getContentPane().add(room4);
    	frame.revalidate();
		frame.repaint();
    }
    /**
     * 가방 ui를 열면서 아이템이 있는지 확인하는 기능
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
     * room2 전환
     */
    private void tofloor2() {
        
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room2);
        frame.getContentPane().remove(room2);

        /**
         * 2층 오브젝트 만듦
         */
        floor2 floor2 = new floor2();

        /**
         * floor2 클래스의 room2 패널 받아옴
         */
        frame.getContentPane().add(floor2.room2);

        frame.revalidate();
        frame.repaint();
    }
    /**
     * 지하로 가는 기능
     */
    private void tofloorf() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room2);
        frame.getContentPane().remove(room2);

        /**
         * 지하 오브젝트 생성
         */
        floorf floorf = new floorf();

        /**
         * floorf 클래스의 room1 패널 얻어옴
         */
        frame.getContentPane().add(floorf.room1);
        
        if(SetSound.nowmp3%2==0) {
            SetSound.stopMP3();
         SetSound.playMainBGM();}

        frame.revalidate();
        frame.repaint();
    }

    /**
     * room2 전환
     */
    private void room3to2() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room3);
    	frame.getContentPane().remove(room3);
    	frame.getContentPane().add(room2);
    	frame.revalidate();
		frame.repaint();
    }
    /**
     * 가방 ui를 열면서 아이템이 있는지 확인하는 기능
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
     * room2 전환
     */
    private void room4to2() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room4);
    	frame.getContentPane().remove(room4);
    	frame.getContentPane().add(room2);
    	frame.revalidate();
		frame.repaint();
		
		if (Bag.getInstance().containsItem("arm")) {
            room2.getComponentAt(670, 135).setVisible(false);
        }
    }
    /**
     * 가방 ui를 열면서 아이템이 있는지 확인하는 기능
     */
    private void room4tobag() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room4);
    	frame.getContentPane().remove(room4);
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
     * 가방 ui에서 나가는 기능
     */
    private void bagtoroom2() {
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(bagPanel);
    	frame.getContentPane().remove(bagPanel);
    	frame.getContentPane().add(room2);
    	frame.revalidate();
		frame.repaint();
    }
    /**
     * 키패드 퍼즐 불러오는 기능
     */
    private void tokeypad() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room4);
        frame.getContentPane().remove(room4);

        /**
         * 퍼즐패널 오브젝트 생성
         */
        puzzlepanel puzzlepanel = new puzzlepanel();

        /**
         * 퍼즐패널 클래스의 키패드 패널 불러옴
         */
        frame.getContentPane().add(puzzlepanel.keypad);

        frame.revalidate();
        frame.repaint();
    }
    
    /**
     * 이미지를 순환시키는 기능
     */
    private void showNextImage1() {
        currentImageIndex1 = (currentImageIndex1 + 1) % directionimages1.length;
        directionButton1.setIcon(directionimages1[currentImageIndex1]);
    }
    
    private void showNextImage2() {
        currentImageIndex2 = (currentImageIndex2 + 1) % directionimages2.length;
        directionButton2.setIcon(directionimages2[currentImageIndex2]);
    }
    
    private void showNextImage3() {
        currentImageIndex3 = (currentImageIndex3 + 1) % directionimages3.length;
        directionButton3.setIcon(directionimages3[currentImageIndex3]);
    }
    
    private void showNextImage4() {
        currentImageIndex4 = (currentImageIndex4 + 1) % directionimages4.length;
        directionButton4.setIcon(directionimages4[currentImageIndex4]);
    }
}
