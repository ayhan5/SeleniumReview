package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
public abstract class TestBase { //nesne uretilmeyecegi ve sadece miras alinacagi icin abtract yapiliyor ayrica abstract olmadan da TestBase acabiliriz boylece class inde degisiklik izin vermemis oluyoruz
    // private, ayni class icinde gorulebilir sadece
    // default, access modifier olmadiginda ve yani ayni package icinde gorulebilir
    // protected, ayni paketlerde ve ek olarak baska paketlerde miras olarak alirsak  gorulebilir
    // public tum paketlerde goulur dolayisiyle degiskenimiz (nstant variable)
    protected WebDriver driver; //instant variable
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}
