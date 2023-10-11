public class Enemy {

    private String name;
    private int health;
    private String description;


    public Enemy(String name, int health, String description){
        this.name = name;
        this.health = health;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Enemy in this room: " + name + '\'' +
                ", Health: " + health +
                ", description='" + description;
    }
}
