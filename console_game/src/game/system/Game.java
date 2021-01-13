package game.system;

import game.objects.fighters.Fatman;
import game.objects.fighters.Fighter;
import game.objects.fighters.Ninja;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game{

    public void game(){
        GameControls gameControls = new GameControls();
        String winner;

        accessVerification(gameControls);

        Fighter player1 = chossingFighter(gameControls, "player1");
        Fighter player2 = chossingFighter(gameControls, "player2");

        while(player1.getLifePoints() > 0 && player2.getLifePoints() > 0) {
            System.out.println("--------------------------------------------");
            System.out.println("p1:   " + player1.getLifePoints());
            System.out.println("p2:   " + player2.getLifePoints());
            chossePlayerMove(gameControls, player1, player2);
            if (player2.getLifePoints() <= 0){
                break;
            }
            chossePlayerMove(gameControls, player2, player1);
        }
        if (player1.getLifePoints()>0){
            winner = player1.getPlayerName();
        }else {
            winner = player2.getPlayerName();
        }
        gameControls.gameResult(winner);
    }

    private void accessVerification(GameControls gameControls){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{5,12}$");
        Matcher matcher;

        do{
            matcher = pattern.matcher(gameControls.login());
            if (matcher.matches()){
                System.out.println("access allowed");
                break;
            }else {
                System.out.println("access denied");
            }
        }while(true);
    }

    private Fighter chossingFighter(GameControls gameControls, String playername){
        Pattern pattern = Pattern.compile("^[0-9]$");
        Matcher matcher;
        do{
            System.out.println(playername);
            matcher = pattern.matcher(gameControls.chooseFighter());
            if(matcher.matches()){
                String input = matcher.group();
                if (input.equals("1")) {
                    System.out.println(playername + " chosed Fatman");
                    System.out.println("--------------------------------------------");
                    return new Fatman(playername);
                } else if (input.equals("2")) {
                    System.out.println(playername + " chosed Ninja");
                    System.out.println("--------------------------------------------");
                    return new Ninja(playername);
                } else {
                    System.err.println("bad input");
                }
            }else {
                System.err.println("put single numeric character");
            }
        }while (true);

    }

    private void chossePlayerMove(GameControls gameControls, Fighter attacker, Fighter target){
        Pattern pattern = Pattern.compile("^[a-zA-Z]$");
        Matcher matcher;
        do{
            System.out.println(attacker.getPlayerName());
            matcher = pattern.matcher(gameControls.playerStep());
            if(matcher.matches()){
                String input = matcher.group();
                System.out.println(input);
                if (input.toUpperCase().equals("A")) {
                    attacker.attackStrike(target);
                    break;
                } else if (input.toUpperCase().equals("D")) {
                    attacker.defend();
                    break;
                } else {
                    System.out.println("bad input");
                }
            }else {
                System.out.println("put single alphabetic character");
            }
        }while (true);
    }
}
