package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.Map;

public class us4_stepDefs {

    BookPage bookPage = new BookPage();
    String bookName;

    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {
        bookPage.search.sendKeys(bookName);
        this.bookName = bookName;
    }
    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {
        bookPage.editBook(bookName).click();
    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        Map<String, String> actualEditBookInfo = bookPage.editBookInfo();
        String query = "select * from books where name like '"+bookName+"'";
        DB_Util.runQuery(query);
        Map<String, String> expectedEditBookInfo = DB_Util.getRowMap(1);

        Assert.assertTrue(expectedEditBookInfo.entrySet().containsAll(actualEditBookInfo.entrySet()));

    }





}
