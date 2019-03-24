import org.json.JSONObject;
import org.json.*;
public abstract class Property  {
    private String address;


    public Property(String address){
        this.address = address;

    }



    public String getAddress() {
        return address;
    }


    @Override
    public String toString() {
        return "Address: " + getAddress();
    }
}
