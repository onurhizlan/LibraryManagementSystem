
package librarymanagementsystem;


public class Users {
 
        private String name;
        private String surname;
        private String username;
        private String email;
        private String date_of_membership;
        private String phone;
        private String address;
        private int id;

    
    public Users(String name, String surname, String username, String email, String date_of_membership, String phone, String address, int id) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.date_of_membership = date_of_membership;
        this.phone =  phone;
        this.address = address;
        this.id = id;
    }
        

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getdate_of_membership() {
        return date_of_membership;
    }

    public void setdate_of_membership(String date) {
        this.date_of_membership = date_of_membership;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
       
 
    
}
