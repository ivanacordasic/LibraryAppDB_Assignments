package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import io.cucumber.java.eo.Se;
import io.cucumber.java.zh_tw.並且;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;


public class us06_stepDefs {

    BookPage bookPage = new BookPage();


    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {
        bookPage.addBook.click();
    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName) {
        bookPage.bookName.sendKeys(bookName);
    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String isbn) {
        bookPage.isbn.sendKeys(isbn);
    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {
        bookPage.year.sendKeys(year);
    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {
        bookPage.author.sendKeys(author);
    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String bookCategory) {
        Select dropdown = new Select(bookPage.categoryDropdown);
        dropdown.selectByVisibleText(bookCategory);
    }
    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {
        bookPage.saveChanges.click();
    }
    @Then("verify {string} message is displayed")
    public void verify_message_is_displayed(String toastMessage) {
        Assert.assertTrue(bookPage.toastMessage.isDisplayed());
    }

    @And("verify {string} and {string} information must match with DB")
    public void verifyAndInformationMustMatchWithDB(String actualBookName, String actualAuthor) {
        String query = "select b.name, isbn, author, bc.name from books b join book_categories bc on book_category_id = bc.id where b.name = '"+actualBookName+"' and author='"+actualAuthor+"'";
        DB_Util.runQuery(query);

        Map<String, String> expectedData = DB_Util.getRowMap(1);
        System.out.println("expectedData = " + expectedData);


    }
}
