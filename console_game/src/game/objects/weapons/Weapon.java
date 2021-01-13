package game.objects.weapons;

public abstract class Weapon {
    protected int damage;
    protected int speed;

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }
}
