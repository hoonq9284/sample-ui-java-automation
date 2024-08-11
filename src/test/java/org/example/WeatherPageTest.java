package org.example;

import io.qameta.allure.Description;
import org.example.pages.CommonPage;
import org.example.pages.WeatherPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WeatherPageTest {

    private WeatherPage weatherPage;

    @BeforeMethod
    public void setUp() {
        CommonPage.setUp();  // CommonPage의 setUp() 메서드 호출
        weatherPage = new WeatherPage(CommonPage.getDriver());  // CommonPage의 WebDriver 인스턴스를 사용
    }

    @Test(priority=1)
    @Description("날씨 페이지로 이동하기")
    public void moveToWeatherPageTest() {
        weatherPage.clickWeatherLinkText();
    }

    @Test(priority=2)
    @Description("날씨 네비게이션 메뉴 구성 확인하기")
    public void checkWeatherTapsTest() {
        weatherPage.clickWeatherLinkText();
        weatherPage.checkWeatherMainTaps();
    }

    @AfterMethod
    public void tearDown() {
        CommonPage.tearDown();  // CommonPage의 tearDown() 메서드 호출
    }
}