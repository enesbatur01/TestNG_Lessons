package techproed.tests.day24_dataprovider_xmlfiles;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProvider {


    @DataProvider
    public static Object[][] names() {
        return new Object[][]{
                {"Enes"},
                {"Büşra"},
                {"NurBurak"},
                {"BATUR"}

        };
    }




    @Test(dataProvider = "names" )
    public void test01(String data) {
        System.out.println(data);


    }

    @DataProvider
    public static Object[][] namesandsurname() {
        return new Object[][]{
                {"enes","batur"},
                {"büşra","batur"},
                {"bircanali","batur"},

        };
    }


    @Test(dataProvider = "namesandsurname")
    public void test02(String name, String surName) {
        System.out.println(name+" "+surName);
    }

}
