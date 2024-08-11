package org.example.pages;

import org.example.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@class='search_input']")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@class='btn_search']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@aria-label='로그인 정보']")
    private WebElement loginSection;

    @FindBy(xpath = "//*[@class='service_icon type_map']")
    private WebElement mapIcon;

    @FindBy(xpath = "//*[@class='logo_box']")
    private WebElement mapPageLogo;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // PageFactory 초기화
    }

    public void checkLoginSection() {
        isDisplayed(loginSection);
    }

    public void moveToMapPage() {
        clickElement(mapIcon);
        switchToWindow(1);
        isDisplayed(mapPageLogo);
    }

    public void searchAndValidation(String keyword, String expectedTitle) {
        inputElement(searchBox, keyword);
        clickElement(searchButton);
        String title = getTitle();
        assertText(expectedTitle, title);
    }
}