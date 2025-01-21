package jp.ac.uryukyu.ie.e245705;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BlackjackTest {

    @Test
    public void testCalculateHand() {
        Blackjack game = new Blackjack();
        ArrayList<String> hand = new ArrayList<>();
        hand.add("ハート6");
        hand.add("ダイヤJ");
        assertEquals(16, game.calculateHand(hand), "手札が6とJのとき合計は16");
    }
}