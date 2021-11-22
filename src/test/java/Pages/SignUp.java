package Pages;

import Utility.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {

    private final RemoteWebDriver driver;

    public SignUp(RemoteWebDriver _driver) {

        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    @FindBy(css = "input#root_firstName")
    WebElement txtName;

    @FindBy(css = "input#root_lastName")
    WebElement txtLastName;

    @FindBy(css = "input#root_email")
    WebElement txtEmail;

    @FindBy(css = "input#root_dateOfBirth")
    WebElement txtDOB;

    @FindBy(css = "input#root_mobileNumber")
    WebElement txtTelePhone;

    @FindBy(css = "input#root_postalCode")
    WebElement txtZipCode;

    @FindBy(css = "input#root_optins_unileverEmailConsent")
    WebElement chkAgeConfirm;

    @FindBy(css = "button.btn.btn-info.pull-right")
    WebElement btnToSend;

    @FindBy(xpath = "//div[@id='contentWrapperSection']//a[@class='cmp-button']//span")
    WebElement btnConfirm;

    @FindBy(xpath = "//li[normalize-space()='Por favor digite seu nome']")
    WebElement errName;

    @FindBy(xpath = "//li[normalize-space()='Por favor insira seu sobrenome']")
    WebElement errLastName;

    @FindBy(xpath = "//li[normalize-space()='Por favor digite seu endereço de email']")
    WebElement errEmail;

    @FindBy(xpath = "//li[normalize-space()='Por favor insira sua data de nascimento']")
    WebElement errDOB;

    @FindBy(xpath = "//li[normalize-space()='Por favor insira o seu CEP']")
    WebElement errZipCode;

    public Boolean isConfirmOkDisplay(){
        Helper.WaitForPageLoad(driver,60);
        return btnConfirm.isDisplayed();
    }

    public void clickOkBtn(){
        Helper.scrollAndClick(driver,btnConfirm);

    }

    public Boolean ValidationForNameDisplay(){
        return errName.isDisplayed();
    }

    public Boolean ValidationForLastNameDisplay(){
        return errLastName.isDisplayed();
    }

    public Boolean ValidationForEmailDisplay(){
        return errEmail.isDisplayed();
    }

    public Boolean ValidationForDOBDisplay(){
        return errDOB.isDisplayed();
    }

    public Boolean ValidationForZipCodeDisplay(){
        return errZipCode.isDisplayed();
    }

    public void SignUpWithDetails(String firstName, String lastName, String email, String DOB, String telephone,
                                  String ZipCode, Boolean IsAgree) {
        Helper.scrollAndClick(driver, txtName);
        txtName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtEmail.sendKeys(email);
        txtDOB.sendKeys(DOB);
        txtZipCode.sendKeys(ZipCode);
        if (IsAgree) {
            if (chkAgeConfirm.isSelected()) {
                return;
            }
            chkAgeConfirm.click();
        }
        btnToSend.click();

    }
}