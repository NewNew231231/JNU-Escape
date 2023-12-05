package jnu_escape_1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            JFrame frame = new JFrame("Main Window");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // GameMap 클래스를 생성하여 패널을 얻어옴
            GameMap gameMap = new GameMap();
            JPanel mapPanel = gameMap.getMapPanel();

            frame.getContentPane().add(mapPanel);

            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
