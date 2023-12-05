package jnu_escape_1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class hiddenend extends JPanel{
	/**
     * 숨겨진 엔딩의 화면이 1~5순으로 출력되며 게임 클리어 표시
     */
	public static JPanel hiddenend1;
	/**
     * 숨겨진 엔딩의 화면이 1~5순으로 출력되며 게임 클리어 표시
     */
    public static JPanel hiddenend2;
    /**
     * 숨겨진 엔딩의 화면이 1~5순으로 출력되며 게임 클리어 표시
     */
    public static JPanel hiddenend3;
    /**
     * 숨겨진 엔딩의 화면이 1~5순으로 출력되며 게임 클리어 표시
     */
    public static JPanel hiddenend4;
    /**
     * 숨겨진 엔딩의 화면이 1~5순으로 출력되며 게임 클리어 표시
     */
    public static JPanel hiddenend5;
    
    /**
     * 현재 표시 중인 introtxt 번호를 나타내는 변수
     */
    private int currentendingtxt = 1;
    /**
     * 클릭 여부를 나타내는 변수
     */// 현재 표시 중인 introtxt 번호를 나타내는 변수
    private boolean clicked = false; // 클릭 여부를 나타내는 변수
    /**
     * ending 클래스와 같이 게임 클리어 화면 출력
     */
    public hiddenend() {


    	/**
         * end1 패널
         */
    	hiddenend1 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/hiddenend1.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        /**
         * 다음 엔딩 패널로 가는 버튼
         */
        ImageIcon toend2icon = new ImageIcon(GameMap.class.getResource("../source/skip.png"));
        JButton toend2 = new JButton(toend2icon);
        toend2.setBounds(770, 20, toend2icon.getIconWidth(), toend2icon.getIconHeight());
        toend2.setBorderPainted(false);
        toend2.setContentAreaFilled(false);
        toend2.setFocusPainted(false);
        toend2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toend2();
            }
        });
        hiddenend1.setLayout(null);
        hiddenend1.add(toend2);
        
        /**
         * end2 Panel
         */
    	hiddenend2 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/hiddenend2.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        ImageIcon toend3icon = new ImageIcon(GameMap.class.getResource("../source/skip.png"));
        JButton toend3 = new JButton(toend3icon);
        toend3.setBounds(770, 20, toend3icon.getIconWidth(), toend3icon.getIconHeight());
        toend3.setBorderPainted(false);
        toend3.setContentAreaFilled(false);
        toend3.setFocusPainted(false);
        toend3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	toend3();
            }
        });
        hiddenend2.setLayout(null);
        hiddenend2.add(toend3);
        
        /**
         * end3 Panel
         */
    	hiddenend3 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/hiddenend3.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        ImageIcon toend4icon = new ImageIcon(GameMap.class.getResource("../source/skip.png"));
        JButton toend4 = new JButton(toend4icon);
        toend4.setBounds(770, 20, toend4icon.getIconWidth(), toend4icon.getIconHeight());
        toend4.setBorderPainted(false);
        toend4.setContentAreaFilled(false);
        toend4.setFocusPainted(false);
        toend4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	toend4();
            }
        });
        hiddenend3.setLayout(null);
        hiddenend3.add(toend4);
        
        /**
         * end4 Panel
         */
    	hiddenend4 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/hiddenend4.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        ImageIcon toend5icon = new ImageIcon(GameMap.class.getResource("../source/skip.png"));
        JButton toend5 = new JButton(toend5icon);
        toend5.setBounds(770, 20, toend5icon.getIconWidth(), toend5icon.getIconHeight());
        toend5.setBorderPainted(false);
        toend5.setContentAreaFilled(false);
        toend5.setFocusPainted(false);
        toend5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	toend5();
            }
        });
        hiddenend4.setLayout(null);
        hiddenend4.add(toend5);
        
        /**
         * end5 Panel
         */
    	hiddenend5 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/hiddenend5.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

                /**
                 * endingtxt가 증가하면 hdendtxt도 증가함(다음 텍스트로 넘어감)
                 */
                if (currentendingtxt <= 5) {
                    ImageIcon endingtxtIcon = new ImageIcon(GameMap.class.getResource("../source/hdendtxt" + currentendingtxt + ".png"));
                    g.drawImage(endingtxtIcon.getImage(), 0, 0, endingtxtIcon.getIconWidth(), endingtxtIcon.getIconHeight(), this);
                }
            }
        };

        hiddenend5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	/**
                 * 화면 클릭 시 currentendingtxt 가 1씩 증가
                 */
                if (currentendingtxt < 5) {
                    currentendingtxt++;
                    hiddenend5.repaint();
                } else {
                    // Handle the case when all introtxt are displayed, and you want to go to the next screen or perform some action.
                    // You can add your logic here.
                }
            }
        });
        /**
         * 타이틀로 가는 버튼
         */
        ImageIcon totitleicon = new ImageIcon(GameMap.class.getResource("../source/skip.png"));
        JButton totitle = new JButton(totitleicon);
        totitle.setBounds(770, 20, totitleicon.getIconWidth(), totitleicon.getIconHeight());
        totitle.setBorderPainted(false);
        totitle.setContentAreaFilled(false);
        totitle.setFocusPainted(false);
        totitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	totitle();
            }
        });
        hiddenend5.setLayout(null);
        hiddenend5.add(totitle);
        
    }

    /**
     * 
     */
    private void toend2() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(hiddenend1);
    	frame.getContentPane().remove(hiddenend1);
    	frame.getContentPane().add(hiddenend2);
    	frame.revalidate();
		frame.repaint();
    }
    
    private void toend3() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(hiddenend2);
    	frame.getContentPane().remove(hiddenend2);
    	frame.getContentPane().add(hiddenend3);
    	frame.revalidate();
		frame.repaint();
    }
    
    private void toend4() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(hiddenend3);
    	frame.getContentPane().remove(hiddenend3);
    	frame.getContentPane().add(hiddenend4);
    	frame.revalidate();
		frame.repaint();
    }
    
    private void toend5() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(hiddenend4);
    	frame.getContentPane().remove(hiddenend4);
    	frame.getContentPane().add(hiddenend5);
    	frame.revalidate();
		frame.repaint();
    }
    /**
     * 타이틀로 돌아가는 버튼
     */
    private void totitle() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(hiddenend5);
        frame.getContentPane().remove(hiddenend5);

        GameMap GameMap = new GameMap();

        frame.getContentPane().add(GameMap.mapPanel);

        frame.revalidate();
        frame.repaint();
    }
    }
