import java.util.Scanner;

public class UserInterface {
    Scanner keyboard = new Scanner(System.in);
    Map map = new Map();
    Player player = new Player();


    public void startGame() {
        System.out.println(map.getCurrentRoom().getName() + ": " + map.getCurrentRoom().getDescription());
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
                case "north", "n" -> map.goNorth();
                case "south", "s" -> map.goSouth();
                case "east", "e" -> map.goEast();
                case "west", "w" -> map.goWest();
                case "look" -> System.out.println(map.getCurrentRoom().getName() + ": " + map.getCurrentRoom().getDescription());
                case "take" -> {
                    Item itemToTake = findItemInCurrentRoom(argument);
                    if (itemToTake != null) {
                        player.takeItem(itemToTake);
                        map.getCurrentRoom().removeItem(itemToTake);
                    } else {
                        System.out.println("No such item in this room.");
                    }
                }
                case "drop" -> {
                    Item itemToDrop = findItemInPlayerInventory(argument);
                    if (itemToDrop != null) {
                        player.dropItem(itemToDrop);
                        map.getCurrentRoom().addItem(itemToDrop.getName(), itemToDrop.getDescription());
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
        for (Item item : map.getCurrentRoom().getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    private Item findItemInPlayerInventory(String itemName) {
        for (Item item : player.getInventory()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
}