package com.library.steps;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.ResultSet;
import java.util.List;

public class us03_stepDefs {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();
    List<String > actualBookCategories;

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String userType) {
        loginPage.login(userType);
    }
    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String pageName) {
        bookPage.navigateModule(pageName);
    }
    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {
        actualBookCategories = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        actualBookCategories.remove(0);
        System.out.println("actualBookCategories = " + actualBookCategories);
    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
        DB_Util.runQuery("select name from book_categories");

        List<String> expectedBookCategories = DB_Util.getColumnDataAsList(1);

        Assert.assertEquals(expectedBookCategories, actualBookCategories);
    }



}
