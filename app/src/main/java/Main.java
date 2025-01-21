import jp.ac.uryukyu.ie.e245705.Blackjack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Blackjack game = new Blackjack();
        Scanner scanner = new Scanner(System.in);

        game.startGame();

        while (true) {
            System.out.print("カードを引きますか？ (y/n): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                game.playerDraw();
                if (game.isPlayerBust()) {
                    System.out.println("バーストしました！ゲーム終了。");
                    return;
                }
            } else {
                break;
            }
        }

        game.dealerDraw();
        game.determineWinner();
        scanner.close();
    }
}
