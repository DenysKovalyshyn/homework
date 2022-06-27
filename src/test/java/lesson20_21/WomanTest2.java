package lesson20_21;

import Lesson15.Woman;
import org.testng.annotations.Test;

public class WomanTest2 {
    Woman woman = new Woman("Kate", "Midlton", 65, true, "UK", true);

    @Test(groups = "group1")
    public void isWomanMarried() {
        String newLastName="not defined";
        if(woman.isPartner()==true){
            newLastName = woman.getPartnerLastName();
        }
        assert newLastName.equals(woman.getPartnerLastName());
    }
}
