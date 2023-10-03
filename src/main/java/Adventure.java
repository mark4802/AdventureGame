import java.util.ArrayList;

public class Adventure {

    Map map = new Map();
    private  Player player = new Player(map.getCurrentRoom());


    public Adventure() {
        map.setMap();
    }

    public Room getCurrentRoom() {
        return map.getCurrentRoom();
    }

    public void goNorth() {
        map.goNorth();
    }

    public void goSouth() {
        map.goSouth();
    }

    public void goEast() {
        map.goEast();
    }

    public void goWest() {
        map.goWest();
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
}