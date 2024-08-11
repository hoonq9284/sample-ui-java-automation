package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherPage extends BasePage {

    @FindBy(xpath = "//*[@href='https://weather.naver.com/']")
    private WebElement weatherLinkText;

    @FindBy(xpath = "//*[@class='logo_area']")
    private WebElement weatherLogo;

    @FindBy(xpath = "//*[text()='예보비교']")
    private WebElement compareForecastsText;

    @FindBy(xpath = "//*[text()='미세먼지']")
    private WebElement findDustText;

    @FindBy(xpath = "//*[@class='menu' and contains(text(),'지도')]")
    private WebElement mapText;

    @FindBy(xpath = "//*[@class='menu' and contains(text(),'영상')]")
    private WebElement videoText;

    @FindBy(xpath = "//*[text()='기상특보']")
    private WebElement weatherReports;

    public WeatherPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // PageFactory 초기화
    }

    public void clickWeatherLinkText() {
        clickElement(weatherLinkText);
        switchToWindow(1);
        isDisplayed(weatherLogo);
    }

    public void checkWeatherMainTaps() {
        isDisplayed(compareForecastsText);
        isDisplayed(findDustText);
        isDisplayed(mapText);
        isDisplayed(videoText);
        isDisplayed(weatherReports);
    }
}