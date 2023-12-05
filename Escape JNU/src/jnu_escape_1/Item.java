package jnu_escape_1;

public class Item {
	private String name;
	/**
     * 아이템을 다른 클래스에서 선언할 수 있다. 추가된 아이템은 가방 클래스에 저장할 수 있다.
     */
    public Item(String name) {
        this.name = name;
    }
    /**
     * 선언한 아이템의 이름을 읽어오는 함수
     */
    public String getName() {
        return name;
    }
}
