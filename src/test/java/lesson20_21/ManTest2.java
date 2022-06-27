package lesson20_21;

import Lesson15.Man;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ManTest2 {
    Man man = new Man("Taras", "Shevchenko", 30, true, "Ukraine", true);

    @DataProvider(name = "data")
    public Object[][] getTestData() {
        return new Object[][]{
                {5},
                {10},
                {17}
        };
        }

    @Test(groups = "group2", dataProvider = "data")
    public void isNotChild(int childAgeBoundary){
        boolean child = false;
        if (man.getAge() <= childAgeBoundary) {
            child = true;
        }
        assert child == false;
    }
}
