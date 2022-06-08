package Lesson15;

public class Main {
    public static void main(String[] args) {
        Man man = new Man("Taras", "Shevchenko", 35, true, "Ukraine", true);
        Woman woman = new Woman("Kate", "Midlton", 61, true, "UK", true);

        System.out.println(woman.isRetired());
        System.out.println(man.isRetired());
        System.out.println(woman.registerPartnership());
        System.out.println(man.registerPartnership());
        System.out.println(woman.deregisterPartnership());
        System.out.println(man.deregisterPartnership());
        System.out.println(woman.motherland());
        System.out.println(man.motherland());
    }
}
