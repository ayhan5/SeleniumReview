package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends TestBase {
    @Test
    public void sagTiklama() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions = new Actions(driver);
        // <span class="context-menu-one btn btn-neutral">right click me</span>
        // linkText : HAYIR (çünkü link değil - "a" tagName'i yok)
        // className: HAYIR (çünkü class değerinin içerisinde BOŞLUK var)
        // tagName, xpath, cssSelector
        // By.xpath("//*[.='right click me']") -> içerdiği yazı "right click me" olan webelement
        WebElement rightClickMe = driver.findElement(By.xpath("//*[.='right click me']"));
        actions.contextClick(rightClickMe).perform();
    }

    @Test
    public void ciftTiklama() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions = new Actions(driver);
        //<button ondblclick="myFunction()">Double-Click Me To See Alert</button>
        WebElement doubleClick = driver.findElement(By.tagName("button"));
        actions.doubleClick(doubleClick).perform();
    }

    @Test
    public void hoverOver() { // mouse'u bir webelementin üzerine götürme
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        // <a href="" class="nav-a nav-a-2" data-nav-ref="nav_ya_signin"
        // data-nav-role="signin" data-ux-jq-mouseenter="true"
        // id="nav-link-accountList" tabindex="0">

        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountList).perform();
    }

    @Test
    public void asagiYukariGitme() {
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        //Web sayfasinin en altina gitmek icin
        actions.sendKeys(Keys.END).perform();

        //web sayfasinda yukari cikmak icin
        //1.yol
        actions.sendKeys(Keys.PAGE_UP).perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //2.yol ard arda 2 kere up 3 saniye ara vererek ciktigini gorebilemk icn
        actions.sendKeys(Keys.ARROW_UP).perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.ARROW_UP).perform();
    }

    @Test
    public void keyUpKeyDown() {
        //Merhaba nasilsiniz?
        //shifte basili tutarak merhaba---------->MERHABA
        //shiften elimize kaldiracagiz merhaba -->nasilsiniz
        driver.get("http://google.com");
        Actions actions = new Actions(driver);

        WebElement aramaKutusu = driver.findElement(By.name("q"));
        //aramaKUtusu sendKeys("merhaba nasilsiniz?");

        actions.moveToElement(aramaKutusu)
                .click()
                .sendKeys("merhaba nasilsiniz?")
                .perform();
    }

    @Test
    public void KeyUpKeyDown() {
        driver.get("http://google.com");
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);
        actions.moveToElement(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("merhaba") //burda shifte bastigimiz icin buyuk harfle yazar(MERHABA)
                .keyUp(Keys.SHIFT)   // burdan sonra da shifti realese etmis olgumuz icin kucuk harfle nasilsiniz/ yazar
                .sendKeys("nasilsiniz?")
                .perform();
   
    }
}











