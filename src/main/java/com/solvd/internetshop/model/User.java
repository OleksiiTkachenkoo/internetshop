package com.solvd.internetshop.model;


import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


import java.util.Objects;



@XmlRootElement
@XmlType(name = "user", propOrder = {
        "id",
        "firstName",
        "lastName",
        "phone",
        "password",
        "email",
        "age",
        "address"
})
public class User {


    private int id;


    private String firstName;


    private String lastName;


    private String phone;


    private String password;


    private String email;

    private int age;

//    private Address address;

    public User(){}

//    public User(int id, String firstName, String lastName,
//                String phone, String password, String email, int age, Address address) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phone = phone;
//        this.password = password;
//        this.email = email;
//        this.age = age;
//        this.address = address;
//    }

//     public User(int id, String firstName, String lastName,
//                String phone, String password, String email, int age) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phone = phone;
//        this.password = password;
//        this.email = email;
//        this.age = age;
//    }
//
//    public User(String firstName, String lastName,
//                String phone, String password, String email, int age) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phone = phone;
//        this.password = password;
//        this.email = email;
//        this.age = age;
//    }

     private User(UserBuilder userBuilder) {
        this.id = userBuilder.getId();
        this.firstName = userBuilder.getFirstName();
        this.lastName = userBuilder.getLastName();
        this.phone = userBuilder.getPhone();
        this.password = userBuilder.getPassword();
        this.email = userBuilder.getEmail();
        this.age = userBuilder.getAge();
    }

    public static class UserBuilder {

        private int id;
        private String firstName;
        private String lastName;
        private String phone;
        private String password;
        private String email;
        private int age;


        public UserBuilder id(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder firstName(String fName) {
            this.firstName = fName;
            return this;
        }

        public UserBuilder lastName(String lName) {
            this.lastName = lName;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        private int getId() {
            return id;
        }

        private String getFirstName() {
            return firstName;
        }

        private String getLastName() {
            return lastName;
        }

        private String getPhone() {
            return phone;
        }

        private String getPassword() {
            return password;
        }

        private String getEmail() {
            return email;
        }

        private int getAge() {
            return age;
        }

        public User build() {
            return new User(this);
        }
    }


//    public Address getAddress() {
//        return address;
//    }
//
//    @XmlElement(required = true)
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phone, password, email, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    @XmlElement(required = true)
    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @XmlElement(required = true)
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement(required = true)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement(required = true)
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    @XmlElement(required = true)
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement(required = true)
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement(required = true)
    public void setEmail(String email) {
        this.email = email;
    }

}
