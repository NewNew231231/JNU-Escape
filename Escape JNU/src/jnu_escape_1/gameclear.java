package jnu_escape_1;

import java.io.Serializable;

public class gameclear implements Serializable{
	private boolean isGameCleared;
	private static final long serialVersionUID = 1L;
	
	/**
     * 게임 클리어 정보를 저장해주는 기능이다.
     */
    public gameclear(boolean isGameCleared) {
        this.isGameCleared = isGameCleared;
    }
    /**
     * 게임이 클리어된 적 있는지 확인하고 그에 따라 새로운 아이템과 상호작용 할 수 있다.
     */
    public boolean isGameCleared() {
        return isGameCleared;
    }
}

