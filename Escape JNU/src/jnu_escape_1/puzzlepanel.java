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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class puzzlepanel extends JPanel{
	/**
     * 컴퓨터의 화면을 출력하여 비밀번호를 입력하게 만드는 패널
     */
	public static JPanel screen1;
	/**
     * 키패드를 입력하여 퍼즐을 풀게 해주는 패널
     */
    public static JPanel screen2;
    /**
     * 키패드 화면
     */
    public static JPanel keypad;
    private JTextField numberTextField;
    private JButton checkButton;
    private boolean isKeypad2Clicked = false;
    private boolean isKeypad5Clicked = false;
    private boolean isKeypad6Clicked = false;
    private boolean isKeypad7Clicked = false;
    /**
     * 키패드가 눌린 횟수
     */
    private int keypadclick = 0;
    /**
     * 아이템 주사기를 획득하며 주사기를 자세히 보여주는 이미지
     */
    public ImageIcon syringedetailicon = new ImageIcon(GameMap.class.getResource("../source/syringe1.png"));
    private JButton syringedetailButton= new JButton(syringedetailicon);;
    /**
     * 퍼즐을 배치 밑 구현하는 패널
     */
    public puzzlepanel() {
    	
        // screen1 Panel
        screen1 = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/computer1.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        /**
         * 퍼즐을 배치 밑 구현하는 패널
         */
        ImageIcon computerquiticon = new ImageIcon(GameMap.class.getResource("../source/computerquit.png"));
        JButton computerquit = new JButton(computerquiticon);
        computerquit.setBounds(750, 30, computerquiticon.getIconWidth(), computerquiticon.getIconHeight());
        computerquit.setBorderPainted(false);
        computerquit.setContentAreaFilled(false);
        computerquit.setFocusPainted(false);
        computerquit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	screen1tofloor2();
            }
        });
        screen1.setLayout(null);
        screen1.add(computerquit);

     // screen2 Panel
       	screen2 = new JPanel() {
               Image background = new ImageIcon(GameMap.class.getResource("../source/computer2.png")).getImage();

               @Override
               protected void paintComponent(Graphics g) {
                   super.paintComponent(g);
                   g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
               }
           };
           ImageIcon computerquiticon2 = new ImageIcon(GameMap.class.getResource("../source/computerquit.png"));
           JButton computerquit2 = new JButton(computerquiticon2);
           computerquit2.setBounds(750, 30, computerquiticon2.getIconWidth(), computerquiticon2.getIconHeight());
           computerquit2.setBorderPainted(false);
           computerquit2.setContentAreaFilled(false);
           computerquit2.setFocusPainted(false);
           computerquit2.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
            	   screen2tofloor2();
               }
           });
           screen2.setLayout(null);
           screen2.add(computerquit2);
           
        /**
         * 숫자(비밀번호) 입력
         */
        numberTextField = new JTextField();
        numberTextField.setBounds(295, 270, 300, 60);
        screen1.add(numberTextField);
        /**
         * 입력한 것 확인하는 버튼
         */
        ImageIcon checkButtonicon = new ImageIcon(GameMap.class.getResource("../source/check.png"));
        JButton checkButton = new JButton(checkButtonicon);
        checkButton.setBounds(610, 290, checkButtonicon.getIconWidth(), checkButtonicon.getIconHeight());
        checkButton.setBorderPainted(false);
        checkButton.setContentAreaFilled(false);
        checkButton.setFocusPainted(false);
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkNumberAndSwitchPanel();
            }
        });
        screen1.add(checkButton);
        /**
         * 키패드 퍼즐 패널
         */
        keypad = new JPanel() {
            Image background = new ImageIcon(GameMap.class.getResource("../source/keypad.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        /**
         * 키패드 1번~9번 버튼들
         */
        ImageIcon keypad1icon = new ImageIcon(GameMap.class.getResource("../source/keypad1.png"));
        JButton keypad1 = new JButton(keypad1icon);
        keypad1.setBounds(245, 160, keypad1icon.getIconWidth(), keypad1icon.getIconHeight());
        keypad1.setBorderPainted(false);
        keypad1.setContentAreaFilled(false);
        keypad1.setFocusPainted(false);
        keypad1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	/**
                 * 키패드가 한 번 눌리면 keypadclick이 1씩 증가
                 */
            	keypadclick++;
            }
        });
        ImageIcon keypad2icon = new ImageIcon(GameMap.class.getResource("../source/keypad2.png"));
        JButton keypad2 = new JButton(keypad2icon);
        keypad2.setBounds(380, 160, keypad2icon.getIconWidth(), keypad2icon.getIconHeight());
        keypad2.setBorderPainted(false);
        keypad2.setContentAreaFilled(false);
        keypad2.setFocusPainted(false);
        keypad2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isKeypad2Clicked = true;
                keypadclick++;
                checkAndPrintItemMessage();
            }
        });
        ImageIcon keypad3icon = new ImageIcon(GameMap.class.getResource("../source/keypad3.png"));
        JButton keypad3 = new JButton(keypad3icon);
        keypad3.setBounds(515, 160, keypad3icon.getIconWidth(), keypad3icon.getIconHeight());
        keypad3.setBorderPainted(false);
        keypad3.setContentAreaFilled(false);
        keypad3.setFocusPainted(false);
        keypad3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	keypadclick++;
            }
        });
        ImageIcon keypad4icon = new ImageIcon(GameMap.class.getResource("../source/keypad4.png"));
        JButton keypad4 = new JButton(keypad4icon);
        keypad4.setBounds(245, 290, keypad4icon.getIconWidth(), keypad4icon.getIconHeight());
        keypad4.setBorderPainted(false);
        keypad4.setContentAreaFilled(false);
        keypad4.setFocusPainted(false);
        keypad4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	keypadclick++;
            }
        });
        ImageIcon keypad5icon = new ImageIcon(GameMap.class.getResource("../source/keypad5.png"));
        JButton keypad5 = new JButton(keypad5icon);
        keypad5.setBounds(380, 290, keypad5icon.getIconWidth(), keypad5icon.getIconHeight());
        keypad5.setBorderPainted(false);
        keypad5.setContentAreaFilled(false);
        keypad5.setFocusPainted(false);
        keypad5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isKeypad5Clicked = true;
                keypadclick++;
                checkAndPrintItemMessage();
            }
        });
        ImageIcon keypad6icon = new ImageIcon(GameMap.class.getResource("../source/keypad6.png"));
        JButton keypad6 = new JButton(keypad6icon);
        keypad6.setBounds(515, 290, keypad6icon.getIconWidth(), keypad6icon.getIconHeight());
        keypad6.setBorderPainted(false);
        keypad6.setContentAreaFilled(false);
        keypad6.setFocusPainted(false);
        keypad6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isKeypad6Clicked = true;
                keypadclick++;
                checkAndPrintItemMessage();
            }
        });
        ImageIcon keypad7icon = new ImageIcon(GameMap.class.getResource("../source/keypad7.png"));
        JButton keypad7 = new JButton(keypad7icon);
        keypad7.setBounds(245, 420, keypad7icon.getIconWidth(), keypad7icon.getIconHeight());
        keypad7.setBorderPainted(false);
        keypad7.setContentAreaFilled(false);
        keypad7.setFocusPainted(false);
        keypad7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isKeypad7Clicked = true;
                keypadclick++;
                checkAndPrintItemMessage();
            }
        });
        ImageIcon keypad8icon = new ImageIcon(GameMap.class.getResource("../source/keypad8.png"));
        JButton keypad8 = new JButton(keypad8icon);
        keypad8.setBounds(380, 420, keypad8icon.getIconWidth(), keypad8icon.getIconHeight());
        keypad8.setBorderPainted(false);
        keypad8.setContentAreaFilled(false);
        keypad8.setFocusPainted(false);
        keypad8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	keypadclick++;
            }
        });
        ImageIcon keypad9icon = new ImageIcon(GameMap.class.getResource("../source/keypad9.png"));
        JButton keypad9 = new JButton(keypad9icon);
        keypad9.setBounds(515, 420, keypad9icon.getIconWidth(), keypad9icon.getIconHeight());
        keypad9.setBorderPainted(false);
        keypad9.setContentAreaFilled(false);
        keypad9.setFocusPainted(false);
        keypad9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	keypadclick++;
            }
        });
        ImageIcon keypadquiticon = new ImageIcon(GameMap.class.getResource("../source/computerquit.png"));
        JButton keypadquit = new JButton(keypadquiticon);
        keypadquit.setBounds(750, 30, keypadquiticon.getIconWidth(), keypadquiticon.getIconHeight());
        keypadquit.setBorderPainted(false);
        keypadquit.setContentAreaFilled(false);
        keypadquit.setFocusPainted(false);
        keypadquit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	keypadtofloor1_4();
            }
        });

        syringedetailButton.setVisible(false);
        syringedetailButton.setBounds(10, -150, syringedetailicon.getIconWidth(), syringedetailicon.getIconWidth());
        syringedetailButton.setBorderPainted(false);
        syringedetailButton.setContentAreaFilled(false);
        syringedetailButton.setFocusPainted(false);
        syringedetailButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	syringedetailButton.setVisible(false);
            }
        });
        
        keypad.setLayout(null);
        keypad.add(syringedetailButton);
        keypad.add(keypad1);
        keypad.add(keypad2);
        keypad.add(keypad3);
        keypad.add(keypad4);
        keypad.add(keypad5);
        keypad.add(keypad6);
        keypad.add(keypad7);
        keypad.add(keypad8);
        keypad.add(keypad9);
        keypad.add(keypadquit);
    }
    /**
     * 비밀번호 확인 기능
     */
    private void checkNumberAndSwitchPanel() {
        String inputText = numberTextField.getText();

        try {
            int inputNumber = Integer.parseInt(inputText);
            /**
             * 5611이 입력됐으면 다음 화면으로 넘어감
             */

            if (inputNumber == 5611) {
            	screen2();
            } else {
            	/**
                 * 비밀번호가 틀렸고 효과음을 끄지 않았을 시 틀렸다는 효과음 출력
                 */
            	if(SetSound.noweffect%2==0) {
            	SetSound.playNoSoundOnce();}
            }
        } catch (NumberFormatException ex) {
            //JOptionPane.showMessageDialog(null, "Please enter a valid number.");
        }
    }

    private void screen1tofloor2() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(screen1);
        frame.getContentPane().remove(screen1);

        // Create floor2 object
        floor2 floor2 = new floor2();

        // Assuming floor2.room3 is the correct panel to switch to
        frame.getContentPane().add(floor2.room3);

        frame.revalidate();
        frame.repaint();
    }
    /**
     * 방으로 돌아가는 기능
     */
    private void screen2tofloor2() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(screen2);
        frame.getContentPane().remove(screen2);

        // Create floor2 object
        floor2 floor2 = new floor2();

        // Assuming floor2.room3 is the correct panel to switch to
        frame.getContentPane().add(floor2.room3);

        frame.revalidate();
        frame.repaint();
    }
    private void screen2() {
        // 패널 전환 로직
    	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(screen1);
    	frame.getContentPane().remove(screen1);
    	frame.getContentPane().add(screen2);
    	frame.revalidate();
		frame.repaint();
    }
    /**
     * 방으로 돌아가는 기능
     */
    private void keypadtofloor1_4() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(keypad);
        frame.getContentPane().remove(keypad);

        floor1 floor1 = new floor1();

        frame.getContentPane().add(floor1.room4);

        frame.revalidate();
        frame.repaint();
    }
    
    private void checkAndPrintItemMessage() {
        if (keypadclick >= 4) {
        	/**
             * 모든 버튼이 클릭되었을 때만 아이템 획득
             */
            if (isKeypad2Clicked && isKeypad5Clicked && isKeypad6Clicked && isKeypad7Clicked) {
            	Item itemsyringe = new Item("syringe");
                Bag.getInstance().addItem(itemsyringe);
                syringedetailButton.setVisible(true);
            } else {
            	/**
                 * 버튼 중 하나라도 클릭되지 않은 경우 keypadclick 리셋
                 */
                keypadclick = 0;
                /**
                 * 버튼 클릭 여부 변수들 리셋
                 */
                isKeypad2Clicked = false;
                isKeypad5Clicked = false;
                isKeypad6Clicked = false;
                isKeypad7Clicked = false;
            }

            
        }
    }

}
