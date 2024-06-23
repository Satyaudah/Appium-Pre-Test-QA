package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidMobileCommandHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.input.model.TouchPoint;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.format.DecimalStyle;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void Login_1_1(){
        DesiredCapabilities descap = new DesiredCapabilities();
        descap.setCapability("appium:deviceName", "emulator-5554");
        descap.setCapability("appium:platformName", "Android");
        descap.setCapability("appium:platformVersion", "11.0");
        descap.setCapability("appium:appPackage", "com.eraspace.app");
        descap.setCapability("appium:appActivity", "com.eraspace.home.presentation.HomeActivity");
        descap.setCapability("appium:automationName", "UiAutomator2");
        descap.setCapability("appium:fullReset", false);
        descap.setCapability("appium:noReset",true);
        AndroidDriver driver;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), descap);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(AppiumBy.id("com.eraspace.app.home:id/btnLogin")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(AppiumBy.id("com.eraspace.app.membership:id/edtPhoneOrEmail")).sendKeys("087788171913");
        driver.findElement(AppiumBy.id("com.eraspace.app.membership:id/edtPassword")).sendKeys("Password1@1");
        driver.findElement(AppiumBy.id("com.eraspace.app.membership:id/btnLogin")).click();
        driver.findElement(AppiumBy.id("com.eraspace.app.membership:id/tvError")).isDisplayed();

        try {
            Runtime.getRuntime().exec("adb shell am force-stop " + "com.eraspace.app");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Login_1_2(){
        DesiredCapabilities descap2 = new DesiredCapabilities();
        descap2.setCapability("appium:deviceName", "emulator-5554");
        descap2.setCapability("appium:platformName", "Android");
        descap2.setCapability("appium:platformVersion", "11.0");
        descap2.setCapability("appium:appPackage", "com.eraspace.app");
        descap2.setCapability("appium:appActivity", "com.eraspace.home.presentation.HomeActivity");
        descap2.setCapability("appium:automationName", "UiAutomator2");
        descap2.setCapability("appium:fullReset", false);
        descap2.setCapability("appium:noReset",true);
        AndroidDriver driver2;
        try {
            driver2 = new AndroidDriver(new URL("http://127.0.0.1:4723"), descap2);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver2.findElement(AppiumBy.id("com.eraspace.app.home:id/btnLogin")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver2.findElement(AppiumBy.id("com.eraspace.app.membership:id/edtPhoneOrEmail")).sendKeys("087788171913");
        driver2.findElement(AppiumBy.id("com.eraspace.app.membership:id/edtPassword")).sendKeys("Password1@");
        driver2.findElement(AppiumBy.id("com.eraspace.app.membership:id/btnLogin")).click();
        driver2.findElement(AppiumBy.id("com.eraspace.app:id/btnClose")).click();
        driver2.findElement(AppiumBy.id("com.eraspace.app.home:id/tvPoint")).isDisplayed();
        driver2.findElement(AppiumBy.id("com.eraspace.app.home:id/imgQrCode")).isDisplayed();
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Appium Pre Test QA");
        System.out.println("TC Login With Invalid Data");
        Login_1_1();
        System.out.println("TC Login With Invalid Data Success");
        System.out.println("TC Login With Valid Data");
        Login_1_2();
        System.out.println("TC Login With Invalid Data Success");
    }
}