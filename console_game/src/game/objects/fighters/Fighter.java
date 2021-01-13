package game.objects.fighters;

import game.objects.weapons.Weapon;

import java.util.Random;

public abstract class Fighter {
    Random random = new Random();

    private String playerName;
    protected int lifePoints;
    protected int strength;
    protected int stamina;
    protected int maxStamina;
    protected int speed;
    protected Weapon weapon;
    private boolean attackable;

    public String getPlayerName() {
        return playerName;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    private int attack(){
         double singleAttack = (this.strength + weapon.getDamage()) * (random.nextDouble() * 0.3 + 0.7);
         return (int) singleAttack;
    }

    public void attackStrike(Fighter target){
        int strike = this.speed * weapon.getSpeed();
        if (stamina>0) {
            this.attackable = true;
            if (target.attackable) {
                for (int i = 0; i < strike; i++) {
                    int hit = attack();
                    target.lifePoints = target.lifePoints - hit;
                    System.out.println(target.playerName + " hitted -" + hit + "HP");
                }
            }else {
                System.out.println(target.playerName + " blocked attack of " + this.playerName);
            }
            stamina--;
        }else {
            System.out.println(this.playerName + " dont have stamina, you must defend");
            defend();
        }
    }

    public void defend(){
        this.attackable = false;
        if (stamina<maxStamina){
            stamina++;
        }
    }

    public Fighter(String player) {
        this.playerName = player;
    }
}
