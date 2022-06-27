package Lesson15;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private boolean partner;
    private String country;
    private boolean divorce;

    public Person(String firstName, String  lastName, int age, boolean partner, String country, boolean divorce){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.partner = partner;
        this.country = country;
        this.divorce = divorce;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isPartner() {
        return partner;
    }

    public String getCountry() {
        return country;
    }

    public boolean isDivorce() {
        return divorce;
    }
}
