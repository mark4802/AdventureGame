import java.util.Scanner;

public class UserInterface {
    Scanner keyboard = new Scanner(System.in);

    Adventure adventure = new Adventure();


    public void startGame() {
        System.out.println("Welcome to the Adventure Game! You're currently in Room 1");
        System.out.println();
        System.out.println("Type (help) to see commands");
        System.out.println();
        System.out.println(adventure.getCurrentRoom().getItems());
        processCommand();
    }


    public void processCommand() {
        boolean programRunning = true;

        do {
            String userInput = keyboard.nextLine().toLowerCase();
            String[] userCommands = userInput.split(" ");
            String command = userCommands[0].trim();
            String argument = userCommands.length > 1 ? userCommands[1].trim() : "";

            switch (command) {
                case "north", "n" -> adventure.goNorth();
                case "south", "s" -> adventure.goSouth();
                case "east", "e" -> adventure.goEast();
                case "west", "w" -> adventure.goWest();
                case "look" ->
                        System.out.println(adventure.getCurrentRoom().getName() + ": " + adventure.getCurrentRoom().getDescription() + adventure.getCurrentRoom().getItems());
                case "take" -> {
                    boolean itemToTake = adventure.takeItem(argument);
                    if (itemToTake) {
                        System.out.println("You took " + argument);
                    } else {
                        System.out.println("No such item in this room.");
                    }
                }
                case "eat" -> adventure.eat(argument);

                case "drop" -> {
                    Item itemToDrop = findItemInPlayerInventory(argument);
                    if (itemToDrop != null) {
                        adventure.dropItem(itemToDrop);
                    } else {
                        System.out.println("You don't have that item.");
                    }
                }
                case "inventory", "inv" -> System.out.println("Inventory: " + adventure.getInventory());
                case "health" -> adventure.showHealth();
                case "exit" -> programRunning = false;
                case "help" -> System.out.println("""
                        Type North, South, East or West (n, s, e, w) to go in either direction.
                        Type "Take" in order to pick up items from a certain room.
                        Type "Drop" in order to drop an item from your inventory.
                        Type "Inventory" or "Inv" to view your inventory.
                        Type "Eat" in order to eat a food item from your inventory.
                        Type "Look" to see which room you're currently in, along with a description.
                        Type "Health" to see your current health.
                        Type "Exit" to close the game.
                        """);
                default -> System.out.println("Invalid command");
            }
        } while (programRunning);
    }

    private Item findItemInPlayerInventory(String itemName) {
        for (Item item : adventure.getInventory()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
}