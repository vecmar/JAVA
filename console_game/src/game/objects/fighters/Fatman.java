package game.objects.fighters;

import game.objects.weapons.BasseballBat;

public class Fatman extends Fighter{
    public Fatman(String playerName) {
        super(playerName);
        super.lifePoints = 2000;
        super.stamina = super.maxStamina = 2;
        super.speed = 1;
        super.strength = 200;
        super.weapon = new BasseballBat();
    }
}
