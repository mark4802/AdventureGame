import java.util.ArrayList;

public class Player {
    private int health = 100;
    private Room currentRoom;

    private ArrayList<Item> inventory;


    public Player(Room currentRoom) {
        inventory = new ArrayList<>();
    }

    public boolean takeItem(String itemName) {
        for (Item item : currentRoom.getItems()) {
            if (item.getName().toLowerCase().equals(itemName)) {
                inventory.add(item);
                currentRoom.removeItem(item);
            } return true;
        }
        return  false;
    }

    public void dropFood(Food food) {
        inventory.remove(food);
        System.out.println("You dropped the " + food.getName() + ".");
    }
    public void takeFood(Food food) {
        inventory.add(food);
        System.out.println("You took the " + food.getName() + ".");
    }

    public void dropItem(Item item) {
        inventory.remove(item);
        System.out.println("You dropped the " + item.getName() + ".");
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getHealth() {
        return health;
    }

    public void showHealth() {
        System.out.println("Your health is: " + health);
        if (health >= 50) {
            System.out.println("You are in good health!");
        } else if (health < 50) {
            System.out.println("Your health is low, take care!");
        }
    }
}