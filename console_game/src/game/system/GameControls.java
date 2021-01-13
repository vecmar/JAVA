package game.system;

import java.util.Scanner;

public class GameControls implements GameInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String login() {
        System.out.println("Enter password: ");
        return scanner.nextLine();
    }

    @Override
    public String chooseFighter() {
        System.out.println("Choose your fighter (1 - Fatman / 2 - Ninja) ");
        return scanner.nextLine();
    }

    @Override
    public String playerStep() {
        System.out.println("put A for attack / D for defense");
        return scanner.nextLine();
    }

    @Override
    public void gameResult(String winner) {
        scanner.close();
        System.out.println(winner + " is winner \nCongratulations");
    }
}
