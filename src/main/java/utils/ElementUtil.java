package utils;

import factory.ThreadLocalDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Pattern;


public class ElementUtil {

    private final int timeOut = 60;
    protected WebDriverWait wait;
    protected AndroidDriver<MobileElement> driver = ThreadLocalDriver.getTLDriver();

    public ElementUtil() {
        wait = new WebDriverWait(driver, timeOut);
    }

    public MobileElement getMobileElement(By locator) {

        return driver.findElement(locator);

    }

    public List<MobileElement> getMobileElements(By locator) {

        return driver.findElements(locator);
    }

    public List<MobileElement> getChildMobileElements(By parentsLocator, By childLocator) {

        return getMobileElement(parentsLocator).findElements(childLocator);
    }

    public void back() {
        driver.navigate().back();
    }

    public boolean isElementSelected(MobileElement element) {
        try {
            return element.isSelected();
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isElementPresent(By locator) {
        try {
            wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            wait = new WebDriverWait(driver, timeOut);
            return true;
        } catch (Throwable e) {
            wait = new WebDriverWait(driver, timeOut);
            return false;
        }
    }


    public List<WebElement> waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitUntilClickable(MobileElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public MobileElement waitUntilNestedObjectBy(By parent, By child) {
        return (MobileElement) wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, child));
    }

    public List<WebElement> waitUntilNestedObjectsBy(By parent, By child) {
        return wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(parent, child));
    }

    public boolean isNestedElementPresent(By parent, By child) {
        try {
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, child));
            wait = new WebDriverWait(driver, timeOut);
            return true;
        } catch (Throwable e) {
            wait = new WebDriverWait(driver, timeOut);
            return false;
        }
    }


    public MobileElement waitUntilClickableBy(By locator) {
        return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public MobileElement waitUntilVisibleBy(By locator) {
        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Boolean isTextMatchesInElement(By locator, String p) {
        return wait.until(ExpectedConditions.textMatches(locator, Pattern.compile(p)));
    }

    public List<WebElement> waitUntilVisibleBys(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public boolean waitUntilInVisible(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        return true;
    }

    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }


    public void actionClick(By locator) {
        MobileElement element = getMobileElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void actionClick(MobileElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void doubleClick(By locator) {
        MobileElement element = getMobileElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.doubleClick(element).perform();
    }

    public String getText(By locator) {
        MobileElement element = getMobileElement(locator);
        return element.getText();
    }

    public void clearText(WebDriver driver, By locator) {
        MobileElement element = getMobileElement(locator);
        element.clear();
    }

    public boolean checkElementIsDisplayed(By locator) {
        try {
            return getMobileElement(locator).isDisplayed();
        } catch (Exception t) {
            return false;
        }
    }

    public void waitUntilPresenceElements(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

    }

}
