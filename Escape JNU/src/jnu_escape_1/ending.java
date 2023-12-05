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

public class ending extends JPanel{
	/**
     * 엔딩 출력 패널
     */
	public static JPanel ending;
	/**
     * 현재 표시 중인 endingtxt 번호를 나타내는 변수
     */
    private int currentendingtxt = 1; // 현재 표시 중인 introtxt 번호를 나타내는 변수
    /**
     * 클릭 여부를 나타내는 변수
     */
    private boolean clicked = false; // 클릭 여부를 나타내는 변수
    /**
     * 엔딩 화면
     */
    public ending() {
    	/**
         * 엔딩 패널
         */
        ending = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/ending.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

                /**
                 * currentendingtxt 가 늘어날 때 마다 endtxt가 넘어가짐
                 */
                if (currentendingtxt <= 4) {
                    ImageIcon endingtxtIcon = new ImageIcon(GameMap.class.getResource("../source/endtxt" + currentendingtxt + ".png"));
                    g.drawImage(endingtxtIcon.getImage(), 320, 500, endingtxtIcon.getIconWidth(), endingtxtIcon.getIconHeight(), this);
                }
            }
        };
        /**
         * 화면 1번 클릭시 currentendingtxt이 1씩 증가
         */
        ending.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (currentendingtxt < 4) {
                    currentendingtxt++;
                    ending.repaint();
                } else {
                    
                }
            }
        });
        /**
         * title로 가는 skip 버튼
         */
        ImageIcon totitleicon = new ImageIcon(GameMap.class.getResource("../source/skip.png"));
        JButton totitle = new JButton(totitleicon);
        totitle.setBounds(770, 20, totitleicon.getIconWidth(), totitleicon.getIconHeight());
        /**
         * 버튼 이미지 배경 투명화, 클릭 한 티 안나도록 함
         */
        totitle.setBorderPainted(false);
        totitle.setContentAreaFilled(false);
        totitle.setFocusPainted(false);
        totitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totitle();
            }
        });
        ending.setLayout(null);
        ending.add(totitle);

        add(ending);
    }
    /**
     * title로 가는 기능
     */
    private void totitle() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ending);
        frame.getContentPane().remove(ending);

        /**
         * GameMap 오브젝트 만듦
         */
        GameMap GameMap = new GameMap();

        /**
         * GameMap의 mapPanel 얻어옴
         */
        frame.getContentPane().add(GameMap.mapPanel);
        

        frame.revalidate();
        frame.repaint();
    }
}
