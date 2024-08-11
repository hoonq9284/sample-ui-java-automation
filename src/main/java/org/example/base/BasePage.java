package org.example.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final long waitTime;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitTime = 10000L;  // 예시로 고정된 대기 시간을 사용, 필요에 따라 변경
        this.wait = new WebDriverWait(driver, Duration.ofMillis(waitTime));
    }

    public void openBrowser(String url) {
        driver.get(url);
    }

    public String getTitle() {
        try {
            return driver.getTitle();
        } catch (Exception error) {
            System.out.println("DOM Page Title 가져오기 에러: " + error.getMessage());
            throw error;
        }
    }

    public void waitForElementToBeVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception error) {
            if (error instanceof org.openqa.selenium.TimeoutException) {
                System.out.println("TimeoutException 발생: 엘리먼트를 최대 " + waitTime / 1000 + "초 만큼 기다렸지만 찾을 수 없습니다.");
            } else {
                throw error;
            }
        }
    }

    public void switchToWindow(int number) {
        try {
            Set<String> windowHandles = driver.getWindowHandles();
            List<String> windows = new ArrayList<>(windowHandles);
            driver.switchTo().window(windows.get(number));
        } catch (Exception error) {
            System.out.println("윈도우 전환 에러: " + error.getMessage());
            throw error;
        }
    }

    public void highlight(WebElement element, int effectTime, String color, int border) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String originalStyle = element.getAttribute("style");
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, "style", "border: " + border + "px solid " + color + ";");
        try {
            Thread.sleep(effectTime);
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt();
        }
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, "style", originalStyle);
    }

    public void isDisplayed(WebElement element) {
        try {
            waitForElementToBeVisible(element);
            highlight(element, 100, "#FF0000", 5); // highlight 호출
            element.isDisplayed();
        } catch (Exception error) {
            System.out.println("Display Error 발생: " + error.getMessage());
            throw error;
        }
    }

    public void clickElement(WebElement element) {
        try {
            waitForElementToBeVisible(element);
            highlight(element, 100, "#FF0000", 5); // highlight 호출
            element.click();
        } catch (Exception error) {
            System.out.println("Click Error 발생: " + error.getMessage());
            throw error;
        }
    }

    public void inputElement(WebElement element, String text) {
        try {
            waitForElementToBeVisible(element);
            highlight(element, 100, "#FF0000", 5); // highlight 호출
            element.sendKeys(text);
        } catch (Exception error) {
            System.out.println("Input Error 발생: " + error.getMessage());
            throw error;
        }
    }

    public String getElementText(WebElement element) {
        try {
            waitForElementToBeVisible(element);
            return element.getText();
        } catch (Exception error) {
            System.out.println("Text Error 발생: " + error.getMessage());
            throw error;
        }
    }

    public static void assertText(String expected, String result) {
        if (!result.equals(expected)) {
            throw new AssertionError("예상 텍스트(Expected): " + expected + "\n 실제 텍스트(result): " + result);
        }
    }
}