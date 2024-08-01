
public class User {
    String userName;
    private String userID;
    private int pin;

    public User(String name, String id, int pin) {
        this.userName = name;
        this.userID = id;
        this.pin = pin;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserID() {
        return userID;
    }

    public int getPin() {
        return pin;
    }
}
