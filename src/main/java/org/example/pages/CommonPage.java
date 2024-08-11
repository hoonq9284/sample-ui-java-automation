package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.base.BasePage;
import org.example.config.Config;

public class CommonPage {

    private static WebDriver driver;

    // setUp() : 각 테스트 케이스 시작 전 실행되는 백그라운드 로직
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // 브라우저를 최대화 모드로 시작

        driver = new ChromeDriver(options);
        BasePage basePage = new BasePage(driver);
        basePage.openBrowser(Config.getUrl());
    }

    // tearDown() : 각 테스트 케이스 종료 후 실행되는 로직
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // getDriver() : WebDriver 인스턴스를 반환
    public static WebDriver getDriver() {
        return driver;
    }
}