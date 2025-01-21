package jp.ac.uryukyu.ie.e245705;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BlackjackTest {

    @Test
    public void testCalculateHand() {
        Blackjack game = new Blackjack();
        ArrayList<String> hand = new ArrayList<>();
        hand.add("ハートA");
        hand.add("ダイヤ10");
        assertEquals(21, game.calculateHand(hand), "手札がAと10のとき合計は21");
    }
}