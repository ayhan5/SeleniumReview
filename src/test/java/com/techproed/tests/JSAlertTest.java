package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void test01() {
        //mesaji ekranda gorebilemk icin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button.click();
        String text=driver.switchTo().alert().getText();
        System.out.println(text);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //cikan kutu alert ine mesaj yazmak icin bundan once biraz bekletmek gerekiyor ekran yazisinin cikmasi icin
        driver.switchTo().alert().sendKeys("selamlar");
        //driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss(); //dismiss olmasi icin accept() olmaz ya accpet ya da dismiss cikan penceyi kabul ya vazgec cikan mesaj ise null olur yukrda selamlar cikar







    }

}
