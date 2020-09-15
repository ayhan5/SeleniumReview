package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iframeTest {
    //scinerio....1.safyadaki iframi bulun
    //2.iframe icindeki"p" tag ile tagName e bakin
    //3.icersine "selamlar iframe" yazacagiz
    //4.iframde ckisi yapip sayfaya donun (defaultContent)
    //5/"Elelmnetal selenium " linkini bulup tiklayin
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/iframe");
       //IFRAME e gecis
        //1.index ile
        //driver.switchTo().frame(0);

        //2.id or name attribute degeri ile
        //driver.switchTo().frame("mce_0_ifr");

        //3.webelement ile
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        WebElement yaziBolumu=driver.findElement(By.tagName("p"));
        yaziBolumu.clear(); //halihazirdaki yaziyi silmek icin
        yaziBolumu.sendKeys("selamlarr");

        //anasayfaya donus icin
        driver.switchTo().defaultContent();

        //.. //<a target="blank" href="http://elementalselenium.com/">Elemental Selenium</a>
        // tagName,linkText.partialLinkText,xpath,cssselector ile bulabiliriz yukardaki webelemete gore

        WebElement link=driver.findElement(By.partialLinkText("Elemental Selenium"));
        link.click();

    }
}











