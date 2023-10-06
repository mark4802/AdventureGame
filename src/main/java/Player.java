import java.util.ArrayList;

public class Player {
    private int health = 100;
    private Room currentRoom;

    private ArrayList<Item> inventory;


    public Player(Room currentRoom) {
        inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean takeItem(String itemName) {
        for (Item item : currentRoom.getItems()) {
            if (item.getName().toLowerCase().equals(itemName)) {
                inventory.add(item);
                currentRoom.getItems().remove(item);
                return true;
            }
        }
        return false;
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

    public void goSouth() {
        if (currentRoom.getSouth() == null)
            System.out.println("You can't go that way");
        else {
            currentRoom = currentRoom.getSouth();
            System.out.println(getCurrentRoom().getName() + ": " + getCurrentRoom().getDescription());
            System.out.println(getCurrentRoom().getItems());
            if (currentRoom.getItems().isEmpty())
                System.out.println("There are no items in this room.");
        }
    }

    public void goWest() {
        if (currentRoom.getWest() == null)
            System.out.println("You can't go that way");
        else {
            currentRoom = currentRoom.getWest();
            System.out.println(getCurrentRoom().getName() + ": " + getCurrentRoom().getDescription());
            System.out.println(getCurrentRoom().getItems());
            if (currentRoom.getItems().isEmpty())
                System.out.println("There are no items in this room.");
        }
    }

    public void goEast() {
        if (currentRoom.getEast() == null)
            System.out.println("You can't go that way");
        else {
            currentRoom = currentRoom.getEast();
            System.out.println(getCurrentRoom().getName() + ": " + getCurrentRoom().getDescription());
            System.out.println(getCurrentRoom().getItems());
            if (currentRoom.getItems().isEmpty())
                System.out.println("There are no items in this room.");
        }
    }

    public void goNorth() {
        if (currentRoom.getNorth() == null)
            System.out.println("You can't go that way");
        else {
            currentRoom = currentRoom.getNorth();
            System.out.println(getCurrentRoom().getName() + ": " + getCurrentRoom().getDescription());
            System.out.println(getCurrentRoom().getItems());
            if (currentRoom.getItems().isEmpty())
                System.out.println("There are no items in this room.");
        }
    }

    public boolean eat(String itemName) {
        for (Item item : inventory)
            if (item.getName().toLowerCase().equals(itemName)) {
                inventory.remove(item);
                //health = health + item.getHealthPoints;
                System.out.println(health);
            } return false;
    }
}