package AT.hw_5.business_objects;

public class User {

    String accountName;
    String password;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }
}
