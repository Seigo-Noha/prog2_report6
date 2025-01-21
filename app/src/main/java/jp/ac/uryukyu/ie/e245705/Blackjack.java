package jp.ac.uryukyu.ie.e245705;

import java.util.*;

public class Blackjack {
    private List<String> deck;
    private List<String> playerHand;
    private List<String> dealerHand;

    // コンストラクタ。ゲームの初期設定を行う。
    public Blackjack() {
        deck = createDeck();
        Collections.shuffle(deck);
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
    }

    public boolean isPlayerBust() {
        return calculateHand(playerHand) > 21;
    }

    /**
     * デッキを作成するメソッド。
     * 
     * @return 52枚のカードを含むリスト。
     */
    private List<String> createDeck() {
        String[] suits = { "ハート", "ダイヤ", "クラブ", "スペード" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        List<String> deck = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(suit + rank);
            }
        }
        return deck;
    }

}
