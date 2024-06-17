package nubankTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountRegistrationNubankPage {
    private WebDriver driver;

    public AccountRegistrationNubankPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCPF(String cpf) {
        driver.findElement(By.id("field-cpf")).sendKeys(cpf);
    }

    public void clickContinue() {
        driver.findElement(By.id("test")).click();
    }

    public String getTitle() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[2]/form/div/div[1]/div/h3")).getText();
    }

    public void enterName(String name) {
        driver.findElement(By.id("field-name")).sendKeys(name);
    }

    public void enterPhone(String phone) {
        driver.findElement(By.id("field-phone")).sendKeys(phone);
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("field-email")).sendKeys(email);
    }

    public void enterEmailConfirmation(String emailConfirmation) {
        driver.findElement(By.id("field-emailConfirmation")).sendKeys(emailConfirmation);
    }

    public void acceptTerms() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[2]/form/div/div[2]/div/div[7]/label/span[1]")).click();
    }

    public void submitForm() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div[2]/form/div/div[2]/div/button")).click();
    }

    public WebElement getErrorMessage(String id) {
        return driver.findElement(By.id(id));
    }
}
