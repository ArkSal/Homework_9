package widgets;

import models.TestBase;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class ModalDialogTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(ModalDialogTest.class);

    @BeforeEach
    void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/modal-dialog.php");
        logger.info("Site window opened");
    }

    @Test
    void modalDialogTest() {
        User newUser = new User("Arek Darek", "mail@temporary.net", "trudnEHaslo");
        createUserInWebsite(newUser);
        List<WebElement> newUserData = driver.findElements(By.cssSelector("tbody tr:last-of-type td"));
        User userGotFromWebsite = new User(newUserData.get(0).getText(), newUserData.get(1).getText(), newUserData.get(2).getText());
        assertThat(userGotFromWebsite, samePropertyValuesAs(newUser));
        logger.info("Test completed");
    }

    private void createUserInWebsite(User user) {
        driver.findElement(By.id("create-user")).click();
        WebElement nameTextField = driver.findElement(By.id("name"));
        nameTextField.clear();
        nameTextField.sendKeys(user.getName());
        WebElement emailTextField = driver.findElement(By.id("email"));
        emailTextField.clear();
        emailTextField.sendKeys(user.getEmail());
        WebElement passwordTextField = driver.findElement(By.id("password"));
        passwordTextField.clear();
        passwordTextField.sendKeys(user.getPassword());
        driver.findElement(By.cssSelector(".ui-dialog-buttonset button")).click();
        logger.info("User created in website");
    }
}
