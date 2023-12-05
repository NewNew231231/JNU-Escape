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

public class StartGame extends JPanel{
	/**
     * 인트로가 시작하도록 진입하는 기능
     */
	public JPanel getIntro1Panel() {
        return intro1;
    }
	/**
     * 인트로가 1~3순서로 재생
     */
	public static JPanel intro1;
	/**
     * 인트로가 1~3순서로 재생
     */
	public static JPanel intro2;
	/**
     * 인트로가 1~3순서로 재생
     */
	public static JPanel intro3;

	private int currentIntrotxt = 1; // 현재 표시 중인 introtxt 번호를 나타내는 변수
    private boolean clicked = false; // 클릭 여부를 나타내는 변수
    /**
     * 게임을 시작하며 인트로를 출력
     */
    public StartGame() {
        // 인트로1
        intro1 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/intro1.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

                /**
                 * currentIntrotxt 가 1 증가하면 txt가 다음 텍스트로 넘어감
                 */
                if (currentIntrotxt <= 3) {
                    ImageIcon introtxtIcon = new ImageIcon(GameMap.class.getResource("../source/introtxt" + currentIntrotxt + ".png"));
                    g.drawImage(introtxtIcon.getImage(), 0, -30, introtxtIcon.getIconWidth(), introtxtIcon.getIconHeight(), this);
                }
            }
        };
        
        intro1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!clicked) {
                    clicked = true;
                    switchIntrotxt();
                    intro1.repaint();
                    clicked = false;
                }
            }
        });
        /**
         * 다음 인트로로 넘어가는 기능
         */
        ImageIcon tointro2Icon = new ImageIcon(GameMap.class.getResource("../source/skip.png"));
        JButton tointro2 = new JButton(tointro2Icon);
        tointro2.setBounds(770, 20, tointro2Icon.getIconWidth(), tointro2Icon.getIconHeight());
        tointro2.setBorderPainted(false);
        tointro2.setContentAreaFilled(false);
        tointro2.setFocusPainted(false);
        tointro2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toIntro2();
            }
        });
        intro1.setLayout(null);
        intro1.add(tointro2);

        add(intro1);

        
        //인트로2
        intro2 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/intro2.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

                /**
                 * 
                 */
                if (currentIntrotxt >= 4 && currentIntrotxt <= 7) {
                    ImageIcon introtxtIcon = new ImageIcon(GameMap.class.getResource("../source/introtxt" + currentIntrotxt + ".png"));
                    g.drawImage(introtxtIcon.getImage(), 0, -30, introtxtIcon.getIconWidth(), introtxtIcon.getIconHeight(), this);
                }
            }
        };

        intro2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!clicked) {
                    clicked = true;
                    switchIntrotxt();
                    intro2.repaint();
                    clicked = false; // 클릭 상태를 다시 false로 설정
                }
            }
        });
        /**
         * 게임 화면으로 넘어가는 버튼
         */
        ImageIcon tointro3Icon = new ImageIcon(GameMap.class.getResource("../source/skip.png"));
        JButton tointro3 = new JButton(tointro3Icon);
        tointro3.setBounds(770, 20, tointro3Icon.getIconWidth(), tointro3Icon.getIconHeight());
        tointro3.setBorderPainted(false);
        tointro3.setContentAreaFilled(false);
        tointro3.setFocusPainted(false);
        tointro3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	tofloor1_1();
            }
        });
        intro2.setLayout(null);
        intro2.add(tointro3);

        
    }

    private void toIntro2() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(intro1);
    	frame.getContentPane().remove(intro1);
    	frame.getContentPane().add(intro2);
    	frame.revalidate();
		frame.repaint();
    }
    
    private void tofloor1_1() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(intro2);
        frame.getContentPane().remove(intro2);

        // Create floor2 object
        floor2 floor2 = new floor2();

        // Add room1 panel to the frame
        frame.getContentPane().add(floor2.room1);

        frame.revalidate();
        frame.repaint();
    }

    private void switchIntrotxt() {
        currentIntrotxt++; // 다음 introtxt로 전환
        if (currentIntrotxt > 7) {
            currentIntrotxt = 7; // introtxt가 3까지이므로 3으로 제한
        }
    }
    /**
     * 인트로가 원활하게 작동하도록 스레드 생성
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StartGame();
            }
        });
    }
}
