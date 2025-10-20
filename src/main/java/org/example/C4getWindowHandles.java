package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

import static java.lang.Thread.sleep;

public class C4getWindowHandles {

    public static WebDriver driver = null;
    static Set<String> allWinodws = null;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com");
        String idMainWin = driver.getWindowHandle();

        String title = driver.getTitle();
        System.out.println("THE TITLE OF CURRENT WINDOWS:" + title);

        //open pop up window
        driver.findElement(By.linkText("Open a popup window")).click();

        //open tab window
        driver.findElement(By.linkText("Blogger")).click();


        sleep(5000);
        //change focus from main window to pop-up or other window, so you can click on it
        //we get the ids of all open windows and navigate to whom we want
        // now we have main windows, pop-up and new tab(Blogger site)
        allWinodws = driver.getWindowHandles();

        Iterator<String> itr = allWinodws.iterator();
        int count = 0;
        while (itr.hasNext()) {
            String currentWindowHandle = itr.next();
            driver.switchTo().window(currentWindowHandle);
            count++;

            String a= "[a-z]+";
            String b= "string2";
            String c= "string3";

            if (driver.getTitle().equals("New Window")) {
                System.out.println(driver.getCurrentUrl());
                String popupText = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
                System.out.println("This is the text from of pop-up: " + popupText);
                System.out.println("This is the title of pop-up window: " + driver.getTitle());
                System.out.println("This is the count of pop-up: " + count);
                //driver.close();
            } else if (driver.getCurrentUrl().equals("https://www.blogger.com/about/?bpli=1")) {
                System.out.println(driver.getCurrentUrl());
                System.out.println("This is the title of Blogger window: " + driver.getTitle());
                //driver.findElement(By.xpath("//span[text()='Sign in']")).click();
                System.out.println("This is the count of pop-up windows: " + count);
                //driver.close();
            } else if (driver.getCurrentUrl().equals("https://omayo.blogspot.com/")) {
                System.out.println(driver.getCurrentUrl());
                String mainPageText = driver.findElement(By.xpath("//*[@id='pah']")).getText();
                System.out.println("This is the main page, bcoz we found here element: " + mainPageText);
                System.out.println("This is the count of main windows: " + count);
            }
        }

        driver.switchTo().window(idMainWin);
        //driver.switchTo().defaultContent();
        System.out.println("Current windows: " + driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id='ta1']")).sendKeys("Oliver Zmarandache");
        sleep(2);

        switchToTheRequiredWindow("New Window");
        String popupText = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
        System.out.println("This is the text from of pop-up: " + popupText);

        //we can use also other ways to open a new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://tutorialsninja.com/demo");

        //this will be a tab but in the first window with the rest of the sites
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://tutorialsninja.com/demo");

        //driver.switchTo().newWindow("this doesn't exist and throw exception");

        sleep(3000);
        driver.quit();
    }

    //or we could move the switch mechanism into a method like, only thate we need to make Webdriver driver and Set<String> allWindows static
    public static void switchToTheRequiredWindow(String title) {
        Iterator<String> itr = allWinodws.iterator();
        while (itr.hasNext()) {
            String currentWindowHandle = itr.next();
            driver.switchTo().window(currentWindowHandle);

            if (driver.getTitle().equals(title)) {
                System.out.println("Current windows according to the method switchToTheRequiredWindow: " + driver.getCurrentUrl());
                break;
            }
        }
    }
}