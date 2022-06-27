package Lesson15;

public class Man extends Person {

    public Man(String firstName, String  lastName, int age, boolean partner, String country, boolean divorce){
        super(firstName, lastName, age, partner, country, divorce);
    }

    public String isRetired(){
        if (getAge() >= 65){
            return String.format(getFirstName() + " " + getLastName() + " is on retirement");
        }
        return String.format(getFirstName() + " " + getLastName() + " is NOT on retirement");
    }

    public String registerPartnership(){
        if(isPartner() == true){
            return String.format("After marriage, wife of " + getFirstName() + " " + getLastName() + " took his last name and became Anna "+ getLastName());
        }
        return String.format(getFirstName() + " " + getLastName() + " is single");
    }

    public String deregisterPartnership(){
        if(isDivorce() == true){
            return String.format("Anna "+ getLastName() + " after divorce with "+ getFirstName() + " " + getLastName() + " took back her last name and became Anna Franko");
        }
        return String.format(getFirstName() + " " + getLastName() +" is still married with Anna " + getLastName());
    }

    public String motherland() {
        return String.format("The motherland of " + getFirstName() + " " + getLastName() + " is " + getCountry());
    }
}
