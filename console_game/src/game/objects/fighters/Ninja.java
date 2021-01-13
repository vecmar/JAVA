package game.objects.fighters;

import game.objects.weapons.Knife;

public class Ninja extends Fighter{
    public Ninja(String playerName) {
        super(playerName);
        super.lifePoints = 1500;
        super.stamina = super.maxStamina = 3;
        super.speed = 1;
        super.strength = 60;
        super.weapon = new Knife();
    }
}
