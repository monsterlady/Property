import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Administrator {
    private ArrayList<Property> properties = new ArrayList<>();

    public void addStudentHouse(String address) {
        Studenthouse studenthouse = new Studenthouse(address);
        properties.add(studenthouse);
    }

    public Studenthouse findStudentHouseByaddress(String address) throws propertyException {
        for (Property property : properties) {
            if (property instanceof Studenthouse && property.getAddress().equals(address)) {
                return (Studenthouse) property;
            }
        }
        throw new propertyException("No property found !");

    }

    public void addRoomtoStudenthouse(int price, int serialnum, String name, String address) throws propertyException {
        Room room = new Room(price, serialnum, name);
        findStudentHouseByaddress(address).addRoom(room);
    }

    public void addRoomtoStudenthouse(JSONObject jsonObject, String address) throws propertyException {
        Room room = new Room(jsonObject);
        findStudentHouseByaddress(address).addRoom(room);
    }

    public void printAllProperties() {
        for (Property property : properties) {
            System.out.println(property.toString());
        }

    }

    public int gethighprice(ArrayList<Integer> arrayList) throws propertyException {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            int highest = arrayList.get(arrayList.size() - 1);
            return highest;
        } else {
            throw new propertyException("There is no room!");
        }
    }

    public int getlowestprice(ArrayList<Integer> arrayList) throws propertyException {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            return arrayList.get(0);
        } else {
            throw new propertyException("There is no room!");
        }

    }

    public Studenthouse getStudenthousebyAdress(String str) {
        for (Property property : properties) {
            if (property.getAddress().equals(str)) {
                return (Studenthouse) property;
            }
        }
        return null;
    }

    public void checkoverview(Property property) throws propertyException {
        if (property instanceof Studenthouse) {
            ArrayList<Integer> price = new ArrayList<>();
            for (Room room : ((Studenthouse) property).getRooms()) {
                price.add(room.getPrice());
            }
            System.out.println("The lowest price is :" + getlowestprice(price));
            System.out.println("The highest price is:" + gethighprice(price));
        }
    }

    public void getAveragePrice(Property property) {
        int sum = 0;
        int averagePrice;
        if (property instanceof Studenthouse) {
            for (Room room : ((Studenthouse) property).getRooms()) {
                sum += room.getPrice();
            }
            averagePrice = sum / ((Studenthouse) property).getRooms().size();
            System.out.println("The average price of " + property.getAddress() + " is " + averagePrice);
        }
    }

    public void readJSONfile(String filename, String address) throws propertyException {
     try {
    String jsonString = new String(Files.readAllBytes(Paths.get(filename)));
    JSONArray jsonArray = new JSONArray(jsonString);
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        addRoomtoStudenthouse(jsonObject, address);
    }
    } catch (IOException E){
    throw new propertyException("No file found!");
    }

    }
}

