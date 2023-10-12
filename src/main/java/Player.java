import java.util.ArrayList;

public class Player {
    private int health;
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private Item FoodToBeRemoved = null;
    private Item RangedWeaponToBeRemoved = null;
    private Item MeleeWeaponToBeRemoved = null;
    private boolean isRangedEquipped;
    private boolean isMeleeEquipped;
    private ArrayList<Item> equippedItems;


    public Player(Room currentRoom) {
        inventory = new ArrayList<>(2);
        equippedItems = new ArrayList<>(0);
        this.currentRoom = currentRoom;
        this.health = 100;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void playerDead() {
        if (health <= 0) {
            System.out.println("You died");
            System.exit(0);
        }
    }

    public boolean takeItem(String itemName) {
        for (Item item : currentRoom.getItems()) {
            if (item.getName().toLowerCase().equals(itemName) && inventory.size() < 3) {
                inventory.add(item);
                currentRoom.getItems().remove(item);
                return true;
            } else if (item.getName().toLowerCase().equals(itemName) && inventory.size() == 3)
                System.out.println("Your inventory is full.");
        }
        return false;
    }

    public void dropItem(Item item) {
        inventory.remove(item);
        currentRoom.addItem(item);
        System.out.println("You dropped the " + item.getName() + ".");
    }

    public ArrayList<Item> getInventory() {
        return inventory;
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
        for (Item item : inventory) {
            if (item instanceof Food food)
                if (item.getName().toLowerCase().equals(itemName)) {
                    this.FoodToBeRemoved = item;
                    health = health + food.getHealthPoints();
                    System.out.println("Your new current health: " + health);
                }
        }
        if (health <= 0) {
            System.out.println("You died");
            System.exit(0);
        }

        if (FoodToBeRemoved != null)
            inventory.remove(FoodToBeRemoved);
        else System.out.println("You can't eat that item.");

        return false;
    }

    public void equip(String itemName) {
        for (Item item : inventory) {
            if (item instanceof RangedWeapon rangedWeapon)
                if (item.getName().toLowerCase().equals(itemName) && equippedItems.isEmpty()) {
                    this.RangedWeaponToBeRemoved = item;
                    System.out.println("You equipped " + itemName);
                    equippedItems.add(item);
                }
        }
        if (RangedWeaponToBeRemoved != null) {
            inventory.remove(RangedWeaponToBeRemoved);
            this.isRangedEquipped = true;
        } else System.out.println("You can't equip that item.");

        for (Item item : inventory) {
            if (item instanceof MeleeWeapon meleeWeapon)
                if (item.getName().toLowerCase().equals(itemName) && equippedItems.isEmpty()) {
                    this.MeleeWeaponToBeRemoved = item;
                    System.out.println("You equipped " + itemName);
                    equippedItems.add(item);
                }
        }
        if (MeleeWeaponToBeRemoved != null) {
            inventory.remove(MeleeWeaponToBeRemoved);
            this.isMeleeEquipped = true;
        } else System.out.println("You can't equip that item.");
    }

    public void attackRanged() {
        if (equippedItems.isEmpty())
            System.out.println("You don't have any items equipped.");
        for (Item item : equippedItems) {
            if (item instanceof RangedWeapon rangedWeapon) {
                if (isRangedEquipped) {
                    rangedWeapon.setAmmo(rangedWeapon.getAmmo() - 1);
                    System.out.println("You attacked! Your ammo: " + rangedWeapon.getAmmo());
                } else System.out.println("You didn't attack.");
            }
        }
    }

    public void attackMelee() {
        for (Item item : equippedItems)
            if (item instanceof MeleeWeapon meleeWeapon)
                if (isMeleeEquipped) {
                    System.out.println("You attacked!");
                } else System.out.println("You didn't attack.");
    }
}


