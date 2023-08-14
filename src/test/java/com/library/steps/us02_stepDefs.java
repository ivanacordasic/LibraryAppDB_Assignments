package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.apache.velocity.runtime.directive.Parse;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


public class us02_stepDefs {

    DashBoardPage dashBoardPage = new DashBoardPage();
    String  actualBookNumber;


    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {
        BrowserUtil.waitForVisibility(dashBoardPage.borrowedBooksNumber, 3);
        actualBookNumber = dashBoardPage.borrowedBooksNumber.getText();
    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        String query = "select count(*) from book_borrow where is_returned = 0";
        DB_Util.runQuery(query);
        String expectedBookNumber = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(expectedBookNumber, actualBookNumber);
    }



}
