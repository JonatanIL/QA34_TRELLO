package manage;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHepler extends HelperBase{
    public UserHepler(WebDriver wd) {
        super(wd);
    }
    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillInLoginForm(User user) throws InterruptedException {
        type(By.cssSelector("#user"), user.getEmail());
        click(By.cssSelector("#login"));
        Thread.sleep(2000);
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void submitLogin() {
        click(By.cssSelector("#login-submit"));
    }

    public void logOut() {
        click(By.cssSelector("[data-test-id = 'header-member-menu-button']"));
        click(By.cssSelector("[data-test-id = 'header-member-menu-logout']"));
        click(By.cssSelector("[data-testid='logout-button']"));
    }

    public boolean isLogged() {
        return wd.findElements(By.cssSelector("[data-test-id = 'header-member-menu-button']")).size() > 0;
    }
    public void login(String email, String password){
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"), email);
        click(By.cssSelector("#login"));
        pause(5000);
        type(By.name("password"), password);
        click(By.id("login-submit"));


    }

}