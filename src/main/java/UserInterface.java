import java.util.Scanner;

public class UserInterface {
    Scanner keyboard = new Scanner(System.in);
    Adventure adventure = new Adventure();

    public void startGame() {
        System.out.println(adventure.getCurrentRoom().getName() + ": " + adventure.getCurrentRoom().getDescription());
        processCommand();
    }


    public void processCommand() {

        boolean programRunning = true;

        do {
            String userInput = keyboard.nextLine().toLowerCase();
            String userChoice = userInput.replace("go", "").replace("around", "").trim();
            switch (userChoice) {
                case "north" -> adventure.goNorth();
                case "south" -> adventure.goSouth();
                case "east" -> adventure.goEast();
                case "west" -> adventure.goWest();
                case "look" -> System.out.println(adventure.getCurrentRoom().getName() + ": " + adventure.getCurrentRoom().getDescription());
                case "exit" -> programRunning = false;
                default -> System.out.println("Invalid command");
            }
        } while (programRunning);
    }
}
