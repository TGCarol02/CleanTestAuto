package previoussessions.testngdemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class Asserts {

    @Test
    public void hardAssertExample(){

        String expectedResult = "hard assert";
        String actualResult = "hard assert";

        Assert.assertEquals(expectedResult,actualResult);

        System.out.println("This should not be executed");

    }

    @Test
    public void softAssertExample(){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(1,2,"los numero no son iguales");
        softAssert.assertEquals(1,3,"los numero no son iguales 2");
        softAssert.assertEquals(1,5,"los numero no son iguales 3");
        softAssert.assertEquals(5,5,"los numero no son iguales 3");

        System.out.println("This should be executed before assert all");
        softAssert.assertAll();
    }

}
