package lesson20_21;

import Lesson15.Man;
import org.testng.annotations.Test;

public class ManTest1 {
    Man man = new Man("Taras", "Shevchenko", 35, true, "Ukraine", true);

    @Test(groups = "group2")
    public void defineCountryOfBirth() {
        boolean motherlandUkraine = false;
        if (man.getCountry()=="Ukraine") {
            motherlandUkraine = true;
        }
        assert motherlandUkraine==true;
    }
}
