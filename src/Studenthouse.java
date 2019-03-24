import java.util.ArrayList;

public class Studenthouse extends Property {
    private ArrayList<Room> rooms  = new ArrayList<>();

    public Studenthouse(String address){
        super(address);
    }

    public void addRoom(Room room){
        this.rooms.add(room);
    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if(!rooms.isEmpty()){
            for(Room room : rooms){
                str.append("\n").append(room.toString());
            }
        }
        return super.toString() + str;
    }
}
