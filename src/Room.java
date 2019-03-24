import org.json.JSONObject;

public class Room  {
    private int serialNum;
    private int price;
    private String nameofOwner;

    public Room(int price,int serialNum, String nameofOwner){
        this.price=price;
        this.serialNum = serialNum;
        this.nameofOwner = nameofOwner;
    }

    public Room(JSONObject jsonObject){
        this.price = jsonObject.getInt("price");
        this.serialNum = jsonObject.getInt("Room");
        this.nameofOwner = jsonObject.getString("Inhabitant");
    }

    public int getPrice() {
        return price;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public String getNameofOwner() {
        return nameofOwner;
    }

    @Override
    public String toString() {
        return "SerialNum: " + getSerialNum() + " Inhabitant: "+ getNameofOwner() +" Price: " + getPrice();
    }
}
