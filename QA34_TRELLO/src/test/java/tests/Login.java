package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod
    public void preConditions(){
        if(app.getUser().isLogged()){
            app.getUser().logOut();
        }
    }


    @Test
    public  void loginPositive() throws InterruptedException {
        User user = User.builder().email("jonataneitan@gmail.com").password("JonatanEitan1986").build();
        logger.info("Test login Positive"+user.getEmail()+" "+user.getPassword());
        app.getUser().initLogin();
        app.getUser().pause(500);
        app.getUser().fillInLoginForm(user);
        app.getUser().submitLogin();
        logger.info(" logged----");
        Assert.assertTrue(app.getUser().isLogged());
    }


}