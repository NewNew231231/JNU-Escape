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

public class floor2 {
	/**
     * 교실 패널
     */
	public static JPanel room1;
	/**
     * 복도 패널
     */
    public static JPanel room2;
    /**
     * 전산실 패널
     */
    public static JPanel room3;
    /**
     * 교무실 패널
     */
    public static JPanel room4;
    /**
     * 배경이 바뀐 후 교무실 패널
     */
    public static JPanel room4_1;
    /**
     * 가방 ui를 출력해주는 패널
     */
    public static JPanel bagPanel;
    /**
     * 로커 비밀번호를 옳게 눌렀는지 확인하는 문자열
     */
    private String locker = "";
    
    ImageIcon cutterbagicon = new ImageIcon(GameMap.class.getResource("../source/cutter3.png"));
    JButton cutterbag = new JButton(cutterbagicon);
   
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
    
    /**
     * 
     */
    private Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(
            new ImageIcon(getClass().getResource("../source/mouse.png")).getImage(), new Point(0, 0), "customCursor");
    
    /**
     * 
     */
    public floor2() {
        // Room1 Panel
        room1 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/room2-1.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        /**
         * 
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
         * 
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
         * 
         */
        ImageIcon bagpuzzleicon = new ImageIcon(GameMap.class.getResource("../source/bagpuzzle.png"));
        JButton bagpuzzle = new JButton(bagpuzzleicon);
        bagpuzzle.setVisible(false);
        bagpuzzle.setBounds(150, 440, bagpuzzleicon.getIconWidth(), bagpuzzleicon.getIconHeight());
        bagpuzzle.setBorderPainted(false);
        bagpuzzle.setContentAreaFilled(false);
        bagpuzzle.setFocusPainted(false);
        
        ImageIcon letterdetailicon = new ImageIcon(GameMap.class.getResource("../source/letterdetail.png"));
        JButton letterdetail = new JButton(letterdetailicon);
        letterdetail.setVisible(false);
        letterdetail.setBounds(200, 50, letterdetailicon.getIconWidth(), letterdetailicon.getIconHeight());
        letterdetail.setBorderPainted(false);
        letterdetail.setContentAreaFilled(false);
        letterdetail.setFocusPainted(false);
        letterdetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	bagpuzzle.setVisible(false);
            	letterdetail.setVisible(false);
            	if (Bag.getInstance().containsItem("cutter")) {
            		cutterbag.setVisible(false);
            	}
            }
        });
        ImageIcon letteritemicon = new ImageIcon(GameMap.class.getResource("../source/letter2.png"));
        JButton letteritem = new JButton(letteritemicon);
        letteritem.setVisible(false);
        letteritem.setBounds(0, 0, letteritemicon.getIconWidth(), letteritemicon.getIconHeight());
        letteritem.setBorderPainted(false);
        letteritem.setContentAreaFilled(false);
        letteritem.setFocusPainted(false);
        letteritem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	letteritem.setVisible(false);
            }
        });
        
        ImageIcon lettericon = new ImageIcon(GameMap.class.getResource("../source/letter.png"));
        JButton letter = new JButton(lettericon);
        letter.setBounds(580, 415, lettericon.getIconWidth(), lettericon.getIconHeight());
        letter.setBorderPainted(false);
        letter.setContentAreaFilled(false);
        letter.setFocusPainted(false);
        letter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	letter.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	letter.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	letterdetail.setVisible(true);
            	bagpuzzle.setVisible(true);
            	if (Bag.getInstance().containsItem("cutter")) {
            		cutterbag.setVisible(true);
            	}
            }
        });
        
        cutterbag.setVisible(false);
        cutterbag.setBounds(180, 470, cutterbagicon.getIconWidth(), cutterbagicon.getIconHeight());
        cutterbag.setBorderPainted(false);
        cutterbag.setContentAreaFilled(false);
        cutterbag.setFocusPainted(false);
        cutterbag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Item itemletter = new Item("letter");
                Bag.getInstance().addItem(itemletter);
                letter.setVisible(false);
                letterdetail.setVisible(false);
                bagpuzzle.setVisible(false);
                cutterbag.setVisible(false);
                letteritem.setVisible(true);
            }
        });
        room1.setLayout(null);
        room1.add(cutterbag);
        room1.add(bagpuzzle);
        room1.add(letteritem);
        room1.add(letterdetail);
        room1.add(room1bag);
        room1.add(letter);
        room1.add(toroom2);
        
        
        /**
         * 
         */
        room2 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/room2-2.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        /**
         * 
         */
        ImageIcon toroom1icon = new ImageIcon(GameMap.class.getResource("../source/left.png"));
        JButton toroom1 = new JButton(toroom1icon);
        toroom1.setBounds(20, 250, toroom1icon.getIconWidth(), toroom1icon.getIconHeight());
        toroom1.setBorderPainted(false);
        toroom1.setContentAreaFilled(false);
        toroom1.setFocusPainted(false);
        toroom1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	room2to1();
            }
        });
        /**
         * 
         */
        ImageIcon toroom3icon = new ImageIcon(GameMap.class.getResource("../source/right.png"));
        JButton toroom3 = new JButton(toroom3icon);
        toroom3.setBounds(820, 250, toroom3icon.getIconWidth(), toroom3icon.getIconHeight());
        toroom3.setBorderPainted(false);
        toroom3.setContentAreaFilled(false);
        toroom3.setFocusPainted(false);
        toroom3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	room2to3();
            }
        });
        /**
         * 
         */
        ImageIcon room3stricon = new ImageIcon(GameMap.class.getResource("../source/2st.png"));
        JButton room3str = new JButton(room3stricon);
        room3str.setBounds(40, 0, room3stricon.getIconWidth(), room3stricon.getIconHeight());
        room3str.setBorderPainted(false);
        room3str.setContentAreaFilled(false);
        room3str.setFocusPainted(false);
        room3str.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	tofloor1();
            }
        });
        /**
         * 
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
         * 
         */
        ImageIcon cutterdetailicon = new ImageIcon(GameMap.class.getResource("../source/cutter2.png"));
        JButton cutterdetail = new JButton(cutterdetailicon);
        cutterdetail.setVisible(false);
        cutterdetail.setBounds(0, 0, cutterdetailicon.getIconWidth(), cutterdetailicon.getIconHeight());
        cutterdetail.setBorderPainted(false);
        cutterdetail.setContentAreaFilled(false);
        cutterdetail.setFocusPainted(false);
        cutterdetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	cutterdetail.setVisible(false);
            }
        });
        
        ImageIcon cuttericon = new ImageIcon(GameMap.class.getResource("../source/cutter1.png"));
        JButton cutter = new JButton(cuttericon);
        cutter.setBounds(350, 230, cuttericon.getIconWidth(), cuttericon.getIconHeight());
        cutter.setBorderPainted(false);
        cutter.setContentAreaFilled(false);
        cutter.setFocusPainted(false);
        cutter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	cutter.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	cutter.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	Item itemcutter = new Item("cutter");
                Bag.getInstance().addItem(itemcutter);
                cutter.setVisible(false);
                cutterdetail.setVisible(true);
            }
        });
        /**
         * 
         */
        ImageIcon room3dooricon = new ImageIcon(GameMap.class.getResource("../source/2door.png"));
        JButton room3door = new JButton(room3dooricon);
        room3door.setBounds(620, 70, room3dooricon.getIconWidth(), room3dooricon.getIconHeight());
        room3door.setBorderPainted(false);
        room3door.setContentAreaFilled(false);
        room3door.setFocusPainted(false);
        room3door.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	toroom4();
            }
        });
        room2.setLayout(null);
        
        room2.add(cutterdetail);
        room2.add(cutter);
        room2.add(toroom1);
        room2.add(toroom3);
        room2.add(room2bag);
        room2.add(room3str);
        room2.add(room3door);
        
        
     // Room3 Panel
        room3 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/room2-3.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        /**
         * 
         */
        ImageIcon room3to2icon = new ImageIcon(GameMap.class.getResource("../source/left.png"));
        JButton room3to2 = new JButton(room3to2icon);
        room3to2.setBounds(20, 250, room3to2icon.getIconWidth(), room3to2icon.getIconHeight());
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
         * 
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
        /**
         * 
         */
        ImageIcon screenicon = new ImageIcon(GameMap.class.getResource("../source/screen.png"));
        JButton screen = new JButton(screenicon);
        screen.setBounds(370, 100, screenicon.getIconWidth(), screenicon.getIconHeight());
        screen.setBorderPainted(false);
        screen.setContentAreaFilled(false);
        screen.setFocusPainted(false);
        screen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	screen.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	screen.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	toscreen();
            }
        });
        
        room3.setLayout(null);
        room3.add(room3bag);
        room3.add(room3to2);
        room3.add(screen);
        
        
        /**
         * 
         */
        room4 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/room2-4.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        /**
         * 
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
         * 
         */
        ImageIcon redicon = new ImageIcon(GameMap.class.getResource("../source/red.png"));
        JButton red = new JButton(redicon);
        red.setBounds(655, 175, redicon.getIconWidth(), redicon.getIconHeight());
        red.setBorderPainted(false);
        red.setContentAreaFilled(false);
        red.setFocusPainted(false);
        red.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	red.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	red.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	locker += "1";
                checkLocker();
            	}
            });

        ImageIcon yellowicon = new ImageIcon(GameMap.class.getResource("../source/yellow.png"));
        JButton yellow = new JButton(yellowicon);
        yellow.setBounds(720, 175, yellowicon.getIconWidth(), yellowicon.getIconHeight());
        yellow.setBorderPainted(false);
        yellow.setContentAreaFilled(false);
        yellow.setFocusPainted(false);
        yellow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	yellow.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	yellow.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	locker += "2";
                checkLocker();
            	}
            });
        ImageIcon greenicon = new ImageIcon(GameMap.class.getResource("../source/green.png"));
        JButton green = new JButton(greenicon);
        green.setBounds(785, 175, greenicon.getIconWidth(), greenicon.getIconHeight());
        green.setBorderPainted(false);
        green.setContentAreaFilled(false);
        green.setFocusPainted(false);
        green.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	green.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	green.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	locker += "3";
                checkLocker();
            	}
            });
        room4.setLayout(null);
        room4.add(room4bag);
        room4.add(room4to2);
        room4.add(red);
        room4.add(green);
        room4.add(yellow);
        
        
        room4_1 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/room2-4-1.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        ImageIcon room4_1to2icon = new ImageIcon(GameMap.class.getResource("../source/down.png"));
        JButton room4_1to2 = new JButton(room4_1to2icon);
        room4_1to2.setBounds(420, 490, room4_1to2icon.getIconWidth(), room4_1to2icon.getIconHeight());
        room4_1to2.setBorderPainted(false);
        room4_1to2.setContentAreaFilled(false);
        room4_1to2.setFocusPainted(false);
        room4_1to2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	room4_1to2();
            }
        });
        ImageIcon room4_1bagicon = new ImageIcon(GameMap.class.getResource("../source/bagButton.png"));
        JButton room4_1bag = new JButton(room4_1bagicon);
        room4_1bag.setBounds(750, 430, room4_1bagicon.getIconWidth(), room4_1bagicon.getIconHeight());
        room4_1bag.setBorderPainted(false);
        room4_1bag.setContentAreaFilled(false);
        room4_1bag.setFocusPainted(false);
        room4_1bag.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	room4_1bag.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	room4_1bag.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	room4_1tobag();
            }
        });

        ImageIcon keydetailicon = new ImageIcon(GameMap.class.getResource("../source/key2.png"));
        JButton keydetail = new JButton(keydetailicon);
        keydetail.setVisible(false);
        keydetail.setBounds(10, 10, keydetailicon.getIconWidth(), keydetailicon.getIconHeight());
        keydetail.setBorderPainted(false);
        keydetail.setContentAreaFilled(false);
        keydetail.setFocusPainted(false);
        keydetail.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	keydetail.setVisible(false);
            }
        });
        
        ImageIcon keyicon = new ImageIcon(GameMap.class.getResource("../source/key1.png"));
        JButton key = new JButton(keyicon);
        key.setBounds(670, 320, keyicon.getIconWidth(), keyicon.getIconHeight());
        key.setBorderPainted(false);
        key.setContentAreaFilled(false);
        key.setFocusPainted(false);
        key.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	key.setCursor(customCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	key.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            	Item itemkey = new Item("key");
                Bag.getInstance().addItem(itemkey);
                key.setVisible(false);
                keydetail.setVisible(true);
            }
        });
        
        room4_1.setLayout(null);
        room4_1.add(room4_1to2);
        room4_1.add(keydetail);
        room4_1.add(room4_1bag);
        room4_1.add(key);
        
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
    private void room1to2() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room1);
    	frame.getContentPane().remove(room1);
    	frame.getContentPane().add(room2);
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
    
    private void room2to3() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room2);
    	frame.getContentPane().remove(room2);
    	frame.getContentPane().add(room3);
    	frame.revalidate();
		frame.repaint();
    }
    
    private void tofloor1() {
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room2);
        frame.getContentPane().remove(room2);

        // Create floor2 object
        floor1 floor1 = new floor1();

        // Add room1 panel to the frame
        frame.getContentPane().add(floor1.room2);

        frame.revalidate();
        frame.repaint();
    }
    
    private void toroom4() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room2);
    	frame.getContentPane().remove(room2);
    	frame.getContentPane().add(room4);
    	frame.revalidate();
		frame.repaint();
    }
    
    private void toroom4_1() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room2);
    	frame.getContentPane().remove(room2);
    	frame.getContentPane().add(room4_1);
    	frame.revalidate();
		frame.repaint();
    }
    
    //room3 전환
    private void room3to2() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room3);
    	frame.getContentPane().remove(room3);
    	frame.getContentPane().add(room2);
    	frame.revalidate();
		frame.repaint();
    }
    /**
     * 퍼즐 클래스의 스크린 패널로 가능 기능
     */
    private void toscreen() {
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room3);
        frame.getContentPane().remove(room3);

        // Create floor2 object
        puzzlepanel puzzlepanel = new puzzlepanel();

        // Add room1 panel to the frame
        frame.getContentPane().add(puzzlepanel.screen1);

        frame.revalidate();
        frame.repaint();
    }
    
  //room4 전환
    private void room4to2() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room4);
    	frame.getContentPane().remove(room4);
    	frame.getContentPane().add(room2);
    	frame.revalidate();
		frame.repaint();
    }
    /**
     * 로커 색을 알맞은 순서로 눌렀는지 확인하는 기능
     */
    private void checkLocker() {
    	/**
         * 3번 눌렀을 때 올바른 순서로 눌렀을 시 로커가 열림
         * 빨강을 누르면 1, 노랑을 누르면 2, 초록을 누르면 3이 문자열에 추가됨
         * 문자열이 312가 되어야 올바르게 눌러진 것
         */
        if (locker.length() == 3) {
            if (locker.equals("312")) {
                switchToRoom4_1();
            } else {
            	/**
                 * 틀렸을 시 틀렸다는 효과음이 출력되고 locker 문자열이 초기화됨
                 */
            	if(SetSound.noweffect%2==0) {
                	SetSound.playNoSoundOnce();}
                locker = ""; // Reset the locker if not the correct combination
            }
        }
    }
    
    private void switchToRoom4_1() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room4);
        frame.getContentPane().remove(room4);
        frame.getContentPane().add(room4_1);
        frame.revalidate();
        frame.repaint();
    }
    
    
    private void room4_1to2() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room4_1);
        frame.getContentPane().remove(room4_1);
        frame.getContentPane().add(room2);
        frame.revalidate();
        frame.repaint();
    }
    /**
     * 가방 ui 출력 로직
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
    private void room4_1tobag() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(room4_1);
    	frame.getContentPane().remove(room4_1);
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
    private void bagtoroom2() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(bagPanel);
    	frame.getContentPane().remove(bagPanel);
    	frame.getContentPane().add(room2);
    	frame.revalidate();
		frame.repaint();
    }
}
