import java.util.ArrayList;

public class Room {

    private ArrayList<Food> food;
    private ArrayList<Item> items;
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;


    public Room(String name, String description){
        this.name = name;
        this.description = description;
        this.north = null;
        this.south = null;
        this.east = null;
        this.west = null;
        this.items = new ArrayList<>();
        this.food = new ArrayList<>();

    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }


    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
