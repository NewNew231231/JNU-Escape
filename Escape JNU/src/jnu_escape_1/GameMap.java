package jnu_escape_1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameMap {
	/**
     * 게임화면이 나올 수 있게 해주는 인자
     */
	public JPanel mapPanel;

    private SetSound setSound;
    
    static JPanel page1 = new JPanel() {
        
        Image background = new ImageIcon(GameMap.class.getResource("../image/1.png")).getImage();

        public void paint(Graphics g) {// 그리는 함수
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);// background를 그려줌
        }
    };
    
    /**
     * 게임 시작 시 메인화면
     */
    public GameMap() {
    	/**
         * 설정 화면에서 배경음을 끄지 않았다면 노래 재생
         * 2회차를 해도 유지됨
         */
    	setSound = new SetSound();
    	if(SetSound.nowmp3%2==0) {
    	SetSound.playBlackMagicBGM();}
    	
    	
        mapPanel = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/mainscreen.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        
        
        
        /**
         * 세팅화면 패널
         */
        page1 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/settingscreen.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };

        /**
         * 효과음 키고 끄는 버튼
         */
        JButton mp3Button = setSound.createMP3Button();
        mp3Button.setBounds(200, 500, SetSound.mp3Icon.getIconWidth(), SetSound.mp3Icon.getIconHeight());
        page1.setLayout(null);
        page1.add(mp3Button);
        
        /**
         * 배경음 키고 끄는 버튼
         */
        JButton effectButton = setSound.createeffectButton();
        mp3Button.setBounds(150, 220, SetSound.mp3Icon.getIconWidth(), SetSound.mp3Icon.getIconHeight());
        page1.setLayout(null);
        page1.add(effectButton);
        /**
         * 세팅 화면으로 가는 버튼
         */
        ImageIcon switchIcon = new ImageIcon(GameMap.class.getResource("../source/setting.png"));
        JButton setting = new JButton(switchIcon);
        setting.setBorderPainted(false);
        setting.setContentAreaFilled(false);
        setting.setFocusPainted(false);
        setting.setOpaque(false);
        setting.setBounds(350, 360, switchIcon.getIconWidth(), switchIcon.getIconHeight());
        setting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToPage1();
            }
        });
        mapPanel.setLayout(null);
        mapPanel.add(setting);


        /**
         * mapPanel로 돌아가는 버튼
         */
        ImageIcon newButtonIcon = new ImageIcon(GameMap.class.getResource("../source/return.png"));
        JButton newButton = new JButton(newButtonIcon);
        newButton.setBorderPainted(false);
        newButton.setContentAreaFilled(false);
        newButton.setFocusPainted(false);
        newButton.setOpaque(false);
        newButton.setBounds(700, 500, newButtonIcon.getIconWidth(), newButtonIcon.getIconHeight());
        
        
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToMapPanel();
            }
        });
        page1.setLayout(null);
        page1.add(newButton);
        
        
        
        //start 버튼
        ImageIcon startIcon = new ImageIcon(GameMap.class.getResource("../source/start.png"));

        // JButton 생성 및 설정
        JButton startButton = new JButton(startIcon);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.setOpaque(false);

        // 버튼 위치 및 크기 설정
        startButton.setBounds(350, 330, startIcon.getIconWidth(), startIcon.getIconHeight());

        // 버튼에 ActionListener 추가
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	switchTo1_1();
            }
        });

        // mapPanel에 버튼 추가
        mapPanel.setLayout(null);
        mapPanel.add(startButton);
        
        /**
         * 종료버튼
         */
        ImageIcon exitIcon = new ImageIcon(GameMap.class.getResource("../source/exit.png"));
        JButton exitButton = new JButton(exitIcon);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.setOpaque(false);
        exitButton.setBounds(350, 400, exitIcon.getIconWidth(), exitIcon.getIconHeight());

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // 프로그램 종료
            }
        });

        // mapPanel에 종료 버튼 추가
        mapPanel.setLayout(null);
        mapPanel.add(exitButton);
    
        
    }

    private void switchToPage1() {
        // 패널 전환 로직
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(mapPanel);
        frame.getContentPane().remove(mapPanel);
        frame.getContentPane().add(page1);
        frame.revalidate();
        frame.repaint();
    }
    /**
     * 패널 전환 로직 (page1에서 mapPanel로 돌아가는 로직)
     */ 
    private void switchToMapPanel() {
    	
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(page1);
        frame.getContentPane().remove(page1);
        frame.getContentPane().add(mapPanel);
        frame.revalidate();
        frame.repaint();
    }
    /**
     * 패널 전환 로직 (mapPanel에서 인트로로)
     */
    private void switchTo1_1() {
    	 
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(mapPanel);
        frame.getContentPane().remove(mapPanel);

        /**
         * StartGame 클래스를 패널로 생성
         */ 
        StartGame startGame = new StartGame();
        frame.getContentPane().add(startGame.intro1);

        frame.revalidate();
        frame.repaint();
    }
    
    public JPanel getMapPanel() {
        return mapPanel;
    }
    /**
     * 맵을 생성해주는 인자
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameMap();
            }
        });
    }
}
