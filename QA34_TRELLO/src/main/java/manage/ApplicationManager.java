package manage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);
    WebDriver wd;

    UserHepler user;
    BoardHelper board;
    ListHelper list;
    CardHelper card;

    public void init() {
        wd = new ChromeDriver();
        logger.info("test starts---");
        wd.navigate().to("https://trello.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHepler(wd);
        board= new BoardHelper(wd);
        list = new ListHelper(wd);
        card = new CardHelper(wd);
        user.login("jonataneitan@gmail.com","JonatanEitan1986");
    }

    public void stop() {
        wd.close();
        wd.quit();
    }

    public UserHepler getUser() {
        return user;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public ListHelper getList() {
        return list;
    }

    public CardHelper getCard() {
        return card;
    }
}