package com.library.steps;

import com.library.pages.BookPage;
import io.cucumber.java.en.*;

public class us07_stepDefs {

    BookPage bookPage = new BookPage();

    @When("the user clicks Borrow Book")
    public void the_user_clicks_borrow_book() {
        bookPage.borrowBook()
    }
    @Then("verify that book is shown in {string} page")
    public void verify_that_book_is_shown_in_page(String string) {

    }
    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {

    }


}
