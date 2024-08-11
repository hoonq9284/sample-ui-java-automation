package org.example;

import io.qameta.allure.Description;
import org.example.pages.CommonPage;
import org.example.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest {  // 이름을 MainPageTest로 변경

    private MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        CommonPage.setUp();  // CommonPage의 setUp() 메서드 호출
        mainPage = new MainPage(CommonPage.getDriver());  // CommonPage의 WebDriver 인스턴스를 사용
    }

    @Test(priority=1)
    @Description("로그인 섹션 확인하기")
    public void loginSectionTest() {
        mainPage.checkLoginSection();
    }

    @Test(priority=2)
    @Description("네이버 지도 페이지로 이동하기")
    public void moveToMapTest() {
        mainPage.moveToMapPage();
    }

    @Test(priority=3)
    @Description("검색 창에 Selenium 검색하기")
    public void searchTheSeleniumTest() {
        mainPage.searchAndValidation("selenium", "selenium : 네이버 검색");
    }

    @AfterMethod
    public void tearDown() {
        CommonPage.tearDown();  // CommonPage의 tearDown() 메서드 호출
    }
}