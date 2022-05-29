package Model;

import java.io.Serializable;

public class UserModel implements Serializable {
    private int id;
    private String email;
    private String password;
    private String confirmpass;
    private String name;
    private String phone;
    private int role;
    public UserModel(String email, String password,String name,String phone,int role ,int id ){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone=phone;
        this.role = role;
        this.id = id;
    }

    public UserModel(String email, String password, String confirmpass, String name, String phone) {
        this.email = email;
        this.password = password;
        this.confirmpass = confirmpass;
        this.name = name;
        this.phone = phone;
    }

    public UserModel(int id, String email, String password, String confirmpass, String name, String phone, int role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.confirmpass = confirmpass;
        this.name = name;
        this.phone = phone;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getUsername() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
