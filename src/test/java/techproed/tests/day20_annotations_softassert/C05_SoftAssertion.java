package techproed.tests.day20_annotations_softassert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C05_SoftAssertion {
    @Test
    public void softAssertionTest() {

        //Oncelikle SoftAssert classindan bir object olusturmaliyiz
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(2,2,"2 esittir 2 ye bu kontrol basarili");

        softAssert.assertTrue(2>3," 2, 3 ten buyuk olmaliydi Bu kontrol basarisiz ");

        softAssert.assertFalse(3>2,"3, 2 den buyuk olmamaliydi bu kontrol basariz ");

        softAssert.assertNotEquals("java","java"," iki string farkli olmaliydi, bu kontrol basarisiz olacak");

        //assertAll methodu kendisinden once yapilan tum soft assertion lari deegerlendirir,
        // eger herhangi bir method fali olduysa test basarisiz olur, ve classin kalan kismi calistirilmaz
        // bu method cagrilmazsa soft assertion basarisiz olup olmadigi anlasilamaz
        softAssert.assertAll();

        System.out.println("Bu kodu consolda görebilir miyim");

    }

    @Test
    public void hardAssertion() {

        System.out.println("bu kod hard assertion dan once ");

        Assert.assertTrue(false);

        System.out.println("bu kod hard assertion dan sonra ");


    }
}
