public class MeleeWeapon extends Item {
    private final String name;
    private final int damage;
    public MeleeWeapon(String name, String description, int damage) {
        super(name, description);
        this.name = name;
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "\n" + "Weapon: " +
                name + ", " +
                "Damage: " + damage;
    }
}
