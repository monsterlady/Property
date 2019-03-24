public class propertyException extends Exception {
    public propertyException(String errormessage){
        super("An error has occurred !" + errormessage);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
