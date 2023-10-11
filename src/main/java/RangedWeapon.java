public class RangedWeapon extends Item {
    private final String name;
    private final int damage;
    private int ammo;

    public RangedWeapon(String name, String description, int damage, int ammo) {
        super(name, description);
        this.name = name;
        this.damage = damage;
        this.ammo = ammo;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public int getAmmo() {
        return ammo;
    }

    @Override
    public String toString() {
        return "\n" + "Weapons: " +
                name + ", " +
                "Damage: " + damage + " " +
                "Ammo: " + ammo;
    }

    public void setAmmo(int i) {
        this.ammo = i;
    }
}