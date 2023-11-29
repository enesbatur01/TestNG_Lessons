package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AmazonPage {
    public AmazonPage() {
        /*
        Bu kod bu classtaki ögeleri driver ile iliskilendirir
        Bu sayede classtaki webelementlere erisebilmek icin @FindBy gibi PageFactory ye yardimci olan
        notasyonlari kullanilabilir hale getirir
         */
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "twotabsearchtextbox")
    public WebElement searcBox;




}