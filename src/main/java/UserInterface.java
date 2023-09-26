import java.util.Scanner;

public class UserInterface {
    Scanner keyboard = new Scanner(System.in);
    Adventure adventure = new Adventure();

    public void startGame() {
        System.out.println("TEST " + adventure.getCurrentRoom().getDescription());
        processCommand();
    }


    public void processCommand() {

        boolean programRunning = true;

        do {
            System.out.print(">");
            String userChoice = keyboard.nextLine();
            System.out.println(userChoice);
            switch (userChoice) {
                case "go north" -> System.out.println("Gone North");
                case "go south" -> {
                    System.out.println("Gone South");
                    adventure.goSouth();
                    System.out.println(adventure.getCurrentRoom().getDescription());
                }
                case "go east" -> adventure.goEast();
                case "go west" -> adventure.goWest();
                case "look" -> System.out.println("Looking around");
                case "exit" -> programRunning = false;
                default -> adventure.notValidWay();
            }
        } while (programRunning);
    }
}
