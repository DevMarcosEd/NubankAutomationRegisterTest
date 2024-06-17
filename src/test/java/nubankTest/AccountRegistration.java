package nubankTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AccountRegistration {

    WebDriver driver;
    AccountRegistrationNubankPage accountRegistrationNubankPage;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
        driver = new FirefoxDriver();
        accountRegistrationNubankPage = new AccountRegistrationNubankPage(driver);
        driver.get("https://nubank.com.br");
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void AccountValidation() {
    	accountRegistrationNubankPage.enterCPF("17517801040");
    	accountRegistrationNubankPage.clickContinue();
        
        String title = accountRegistrationNubankPage.getTitle();
        assertEquals("Complete os campos ao lado para pedir sua Conta e Cartão de crédito", title);
        
        accountRegistrationNubankPage.enterName("Lívia Francisca Maria Rezende");
        accountRegistrationNubankPage.enterPhone("47991575943");
        accountRegistrationNubankPage.enterEmail("livia.francisca.rezende@scuderiagwr.com.br");
        accountRegistrationNubankPage.enterEmailConfirmation("livia.francisca.rezende@scuderiagwr.com.br");
        accountRegistrationNubankPage.acceptTerms();
        accountRegistrationNubankPage.submitForm();
    }

    @Test
    public void testInvalidCPF() {
    	accountRegistrationNubankPage.enterCPF("00000000000");
    	accountRegistrationNubankPage.clickContinue();
        
        WebElement errorMessage = accountRegistrationNubankPage.getErrorMessage("error-cpf");
        assertTrue(errorMessage.isDisplayed());
        assertEquals("Precisamos de um CPF válido.", errorMessage.getText());
    }

    @Test
    public void testMismatchedEmail() {
    	accountRegistrationNubankPage.enterCPF("17517801040");
    	accountRegistrationNubankPage.clickContinue();
        
    	accountRegistrationNubankPage.enterName("Lívia Francisca Maria Rezende");
        accountRegistrationNubankPage.enterPhone("47991575943");
        accountRegistrationNubankPage.enterEmail("livia.francisca.rezende@scuderiagwr.com.br");
        accountRegistrationNubankPage.enterEmailConfirmation("livia.errado@scuderiagwr.com.br");
        accountRegistrationNubankPage.acceptTerms();
        
        WebElement errorMessage = accountRegistrationNubankPage.getErrorMessage("error-emailConfirmation");
        assertTrue(errorMessage.isDisplayed());
        assertEquals("Ops. Está diferente do campo anterior.", errorMessage.getText());
    }
}


