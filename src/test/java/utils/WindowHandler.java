package utils;

import org.openqa.selenium.WebDriver;

public class WindowHandler {
    static String mainWindow;
    static WebDriver driver;

    public static void switchToChildWindow(){
        driver = Driver.getDriver();
        mainWindow = driver.getWindowHandle();
        for(String windowId : driver.getWindowHandles()){
            if(!windowId.equals(mainWindow)){
                driver.switchTo().window(windowId);
                break;
            }
        }
    }

    public static void switchBackToParentWindow(){
        driver.switchTo().window(mainWindow);
    }
}
