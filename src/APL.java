public class APL {
    public static void main(String [] args){
        Administrator administrator = new Administrator();
        try{
        administrator.addStudentHouse("he");
        administrator.addStudentHouse("90");
        administrator.readJSONfile("6587.json","he");
        administrator.addRoomtoStudenthouse(2600,7,"Kang","90");
        administrator.addRoomtoStudenthouse(3600,8,"wang","90");

        administrator.printAllProperties();
        administrator.checkoverview(administrator.getStudenthousebyAdress("he"));
        administrator.getAveragePrice(administrator.getStudenthousebyAdress("he"));
        administrator.checkoverview(administrator.getStudenthousebyAdress("90"));
        administrator.getAveragePrice(administrator.getStudenthousebyAdress("90"));
    } catch (propertyException p){
            System.out.println(p.getMessage());
        }
    }


}
