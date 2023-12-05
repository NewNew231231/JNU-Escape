package jnu_escape_1;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Bag extends JPanel{
	
    
    private static Bag instance;

    private List<Item> items;
    /**
     * 가방안에 아이템을 리스트 형태로 저장하는 객체이다
     */
    public Bag() {
        this.items = new ArrayList<>();
}

/**
 * 다른 클래스에서 가방 클래스를 호출 할 수 있도록 해주는 함수
 */
public static Bag getInstance() {
    if (instance == null) {
        instance = new Bag();
    }
    return instance;
}

/**
 * 가방에 아이템을 넣는 함수
 */
public void addItem(Item item) {
    items.add(item);
}
/**
 * 가방에 아이템이 들었는지 확인하는 함수
 */
public boolean containsItem(String itemName) {
    for (Item item : items) {
        if (item.getName().equalsIgnoreCase(itemName)) {
            return true;
        }
    }
    return false;
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
}}
