package Lesson15;

import Lesson15.Person;

public class Woman extends Person {
    private final String partnerLastName = "Windsor";
    public Woman(String firstName, String  lastName, int age, boolean partner, String country, boolean divorce){
        super(firstName, lastName, age, partner, country, divorce);
    }

    public String isRetired(){
        if (getAge() >= 60){
            return String.format(getFirstName() + " " + getLastName() + " is on retirement");
        }
        return String.format(getFirstName() + " " + getLastName() + " is NOT on retirement");

    }

    public String registerPartnership(){
        if(isPartner() == true){
            return String.format(getFirstName() + " " + getLastName() + " after marriage changed last name to " + partnerLastName);
        }
        return String.format(getFirstName() + " " + getLastName() + " is single");
    }

    public String deregisterPartnership(){
        if(isDivorce() == true){
            return String.format(getFirstName() + " " + partnerLastName + " after divorce changed last name back to " + getLastName());
        }
        return String.format(getFirstName() + " " + partnerLastName + " is still married");
    }

    public String motherland() {
        return String.format("The motherland of " + getFirstName() + " " + partnerLastName + " is " + getCountry());
    }
}
