import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory;

    public Player() {
        inventory = new ArrayList<>();
    }

    public void takeItem(Item item) {
        inventory.add(item);
        System.out.println("You took the " + item.getName() + ".");
    }

    public void dropItem(Item item) {
        inventory.remove(item);
        System.out.println("You dropped the " + item.getName() + ".");
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

//    public void showInventory() {
//        ArrayList<Item> playerInventory = getInventory();
//        if (!playerInventory.isEmpty()) {
//            System.out.println("Your inventory:");
//            for (Item item : playerInventory) {
//                System.out.println(item.getItemName() + " ");
//            }
//        } else {
//            System.out.println("Your inventory is empty.");
//        }
//    }
}
