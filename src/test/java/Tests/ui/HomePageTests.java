package Tests.ui;

import Base.BaseTests;
import Pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTests {
    HomePage homePage = new HomePage();

    @Test
    public void verifyActionsOnHomePage(){
        homePage.launchPage();
    }

    @Test
    public void verifyElements(){
        homePage.element();
    }
}
