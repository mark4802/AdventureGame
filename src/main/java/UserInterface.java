import java.util.Scanner;

public class UserInterface {
    Scanner keyboard = new Scanner(System.in);
    //Map map = new Map();
    //Player player = new Player(map.getCurrentRoom());
    Adventure adventure = new Adventure();


    public void startGame() {
        System.out.println(adventure.getCurrentRoom().getName() + ": " + adventure.getCurrentRoom().getDescription());
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
                        System.out.println("You can take that item");
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
                case "inventory" -> System.out.println("Inventory: " + player.getInventory());
                case "exit" -> programRunning = false;
                default -> System.out.println("Invalid command");
            }
        } while (programRunning);
    }

    private Item findItemInCurrentRoom(String itemName) {
        for (Item item : adventure.getCurrentRoom().getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
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