package jp.ac.uryukyu.ie.e245705;

import java.util.*;

public class Blackjack {
    private ArrayList<String> deck;
    private ArrayList<String> playerHand;
    private ArrayList<String> dealerHand;

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
     * 手札の合計を計算するメソッド。
     * 
     * @param hand 計算対象の手札。
     * @return 手札の合計値。
     */
    public int calculateHand(ArrayList<String> hand) {
        int total = 0;
        int aceCount = 0;
        for (String card : hand) {
            String rank = card.substring(card.length() - 1);
            if ("JQK".contains(rank)) {
                total += 10;
            } else if ("A".equals(rank)) {
                total += 11;
                aceCount++;
            } else {
                total += Integer.parseInt(rank);
            }
        }
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }
        return total;
    }

    /**
     * デッキを作成するメソッド。
     * 
     * @return 52枚のカードを含むリスト。
     */
    private ArrayList<String> createDeck() {
        String[] suits = { "ハート", "ダイヤ", "クラブ", "スペード" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        ArrayList<String> deck = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(suit + rank);
            }
        }
        return deck;
    }

    // ゲームの状態を表示するメソッド。
    public void startGame() {
        playerHand.add(deck.remove(0));
        playerHand.add(deck.remove(0));
        dealerHand.add(deck.remove(0));
        dealerHand.add(deck.remove(0));

        System.out.println("あなたの手札: " + playerHand);
        System.out.println("ディーラーの公開カード: " + dealerHand.get(0));
    }

    // プレイヤーがカードを引くメソッド。
    public void playerDraw() {
        playerHand.add(deck.remove(0));
        System.out.println("あなたの手札: " + playerHand);
    }

    // ディーラーがカードを引くメソッド。
    public void dealerDraw() {
        while (calculateHand(dealerHand) < 17) {
            dealerHand.add(deck.remove(0));
        }
        System.out.println("ディーラーの手札: " + dealerHand);
    }

    // 勝敗を判定するメソッド。
    public void determineWinner() {
        int playerTotal = calculateHand(playerHand);
        int dealerTotal = calculateHand(dealerHand);

        System.out.println("あなたの合計: " + playerTotal);
        System.out.println("ディーラーの合計: " + dealerTotal);

        if (playerTotal > dealerTotal) {
            System.out.println("あなたの勝ちです");
        } else {
            System.out.println("ディーラーの勝ちです");
        }

    }
}