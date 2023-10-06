import java.util.ArrayList;

public class Adventure {

    Map map = new Map();
    private Player player = new Player(map.getInitialRoom());


    public Adventure() {
        map.setMap();
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public void goNorth() {
        player.goNorth();
    }

    public void goSouth() {
        player.goSouth();
    }

    public void goEast() {
        player.goEast();
    }

    public void goWest() {
        player.goWest();
    }

    public boolean takeItem(String argument) {
        return player.takeItem(argument);
    }

    public void dropItem(Item itemToDrop) {
        player.dropItem(itemToDrop);
    }

    public ArrayList<Item> getInventory() {
        return player.getInventory();
    }

    public void showHealth() {
        player.showHealth();
    }

    public boolean eat(String argument) {
        return player.eat(argument);
    }
}