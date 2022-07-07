package lesson20_21;

import Lesson15.Woman;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WomanTest1 {
    Woman woman = new Woman("Kate", "Midlton", 62, true, "UK", true);

    @DataProvider (name = "data")
    public Object[][] getTestData() {
     return new Object[][] {
             {65, "Japan"},
             {60, "France"},
             {55, "Sweden"}
     };
    }

    @Test(groups = "group1", dataProvider = "data")
    public void isWomanOnRetirement(int retirementAge, String country) {
        boolean retirement = false;
        if (woman.getAge() >= retirementAge){
            retirement = true;
        }
        assert retirement == true;
    }
}
