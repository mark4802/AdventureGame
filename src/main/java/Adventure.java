
public class Adventure {

    private Room currentRoom;

    public Adventure() {
        setMap();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }


    public void setMap() {
        Room room1 = new Room("Room 1", "A dimly lit cave entrance, with mysterious echoes.");
        Room room2 = new Room("Room 2", "An underground chamber with ancient symbols on the walls.");
        Room room3 = new Room("Room 3", "A narrow passage filled with the scent of moss and dampness.");
        Room room4 = new Room("Room 4", "A long corridor, its end disappearing into darkness.");
        Room room5 = new Room("Room 5", "A hidden chamber with an ornate altar shrouded in mystery.");
        Room room6 = new Room("Room 6", "A treacherous path leading deeper into the unknown.");
        Room room7 = new Room("Room 7", "A mirrored hall reflecting endless possibilities.");
        Room room8 = new Room("Room 8", "A room of mechanical wonders, gears and levers abound.");
        Room room9 = new Room("Room 9", "A chamber filled with ancient relics and artifacts, hinting at untold secrets of the labyrinth.");


        room1.setEast(room2);
        room1.setSouth(room4);

        room2.setEast(room3);
        room2.setWest(room1);

        room3.setSouth(room6);
        room3.setWest(room2);

        room6.setSouth(room9);
        room6.setNorth(room3);

        room9.setWest(room8);
        room9.setNorth(room6);

        room8.setEast(room9);
        room8.setNorth(room5);
        room8.setWest(room7);

        room5.setSouth(room8);

        room7.setEast(room8);
        room7.setNorth(room4);

        room4.setSouth(room7);
        room4.setNorth(room1);

        currentRoom = room1;

    }

    public void goNorth() {
        if (currentRoom != null)
            currentRoom = currentRoom.getNorth();
    }

    public void goSouth() {
        if (currentRoom != null)
            currentRoom = currentRoom.getSouth();
    }

    public void goWest() {
        if (currentRoom != null)
            currentRoom = currentRoom.getWest();


    }

    public void goEast() {
        if (currentRoom != null)
            currentRoom = currentRoom.getEast();

    }

    public void notValidWay() {
        if (currentRoom == null) {
        }
        System.out.println("You can't go that way");
    }

}



