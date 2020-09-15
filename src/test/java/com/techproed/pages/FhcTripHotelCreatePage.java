package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FhcTripHotelCreatePage {
    WebDriver driver; //TestBase icinde olusturdugumuz driver
    public FhcTripHotelCreatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //constructor icinde pagefactory class ni kullaniyoruz
    }
    //eger liste seklinde almamzi gerekirse
//    @FindBy ( tagName= "div")
//    public List<WebElement> list; //import java.util.List; import etmemiz gerekir

    @FindBy ( id = "Code")
    public WebElement codeKutusu;
    @FindBy ( id = "Name")
    public WebElement nameKutusu;
    @FindBy ( id = "Address")
    public WebElement adressKutusu;
    @FindBy ( id = "Phone")
    public WebElement phoneKutusu;
    @FindBy ( id = "Email")
    public WebElement emailKutusu;
    @FindBy ( id = "IDGroup")
    public WebElement idGroupDropDown;
    @FindBy ( id = "btnSubmit")
    public WebElement saveButonu;
    @FindBy ( className = "bootbox-body")
    public WebElement basariliYazisi;

}

//@FindBy (xpath = "//input[@id='Name']"  )
//public WebElement name;
//@FindBy (xpath = "//input[@id='Address']"  )
//public WebElement address;
//@FindBy (xpath = "//input[@id='Phone']"  )
//public WebElement phone;
//@FindBy (xpath = "//input[@id='Email']"  )
//public WebElement email;
//@FindBy (xpath = "//input[@id='IDGroup']"  )
//public WebElement iDGroup;