package model.FlatOwner;

/**
 * Created by Эдуард on 29.07.15.
 */
public class Person {

    private Integer userID=0;
    private String name;
    private String firstName;
    private String lastName;
    private String phone;
    private String Email;
    private Login login =new Login();


    @Override
public String toString(){
    return name+"  "+firstName+"  "+lastName+"  "+phone+"  "+Email+"  "  ;}
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
