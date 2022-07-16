package tests;

import models.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {


    @Test
    public void boardCreation1() {

        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        Board board = Board.builder().title("testQa34").build();
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().pause(2000);
        app.getBoard().fillboardCreationForm(board);
        app.getBoard().pause(2000);
        //   app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

        int boardCountAfterCreation = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }

    @Test
    public void boardCreation2() {
        Board board = Board.builder().title("test Qa34").build();
        logger.info("Test boadr creation" + board.getTitle());
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().pause(2000);
        app.getBoard().fillboardCreationForm(board);
     //   app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().isCreated();
        logger.info("Board is created---");

        Assert.assertTrue(app.getBoard().isCreated());


    }
}