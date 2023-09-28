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
            String userChoice = userInput.replace("go", "").replace("around", "").replace("item", "").trim();
            switch (userChoice) {
                case "north" -> map.goNorth();
                case "south" -> map.goSouth();
                case "east" -> map.goEast();
                case "west" -> map.goWest();
                case "look" -> System.out.println(map.getCurrentRoom().getName() + ": " + map.getCurrentRoom().getDescription());
                case "take" -> player.takeItem();
                case "exit" -> programRunning = false;
                default -> System.out.println("Invalid command");
            }
        } while (programRunning);
    }
}
