package org.Calculator;

import org.junit.Test;
import org.Bowling.*;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.assertEquals;

public class testScoreCalculator {

//    // count 10 pins
//    BowlingGame game = new BowlingGame("XXXXXXXXXXXX");           10+2
//    BowlingGame game = new BowlingGame("12345123451234512345");   10+10
//    BowlingGame game = new BowlingGame("9-9-9-9-9-9-9-9-9-9-");   10+10
//    BowlingGame game = new BowlingGame("5/5/5/5/5/5/5/5/5/5/5");  10+11
//    BowlingGame game = new BowlingGame("5/5/5/5/5/5/5/5/5/X5/");  10+11
//    BowlingGame game = new BowlingGame("5/5/5/5/5/5/5/5/X5/5");   10+10

    /*
     * given: a simple game without any spare,strike & miss
     * when: end game
     * then: calculate the score
     * */

    @Test
    public void getScoreWithoutSpareAndStrike() {
        BowlingGame game = new BowlingGame("12345123451234512345");
        assertEquals(60,game.getScore());
    }

    /*
     * given: a simple game with one NO PIN
     * when: end game
     * then: calculate the score
     * */

    @Test
    public void getScoreWithOneNoPin() {
        BowlingGame game = new BowlingGame("1-345123451234512345");
        assertEquals(58,game.getScore());
    }

    /*
     * given: a simple game with multiple NO PIN
     * when: end game
     * then: calculate the score
     * */

    @Test
    public void getScoreWithMutipleNoPin() {
        BowlingGame game = new BowlingGame("1-34512345-2345-2345");
        assertEquals(56,game.getScore());
    }

    /*
     * given: game with one SPARE
     * when: end game
     * then: calculate the score
     * */
    @Test
    public void getScoreWithOneSpare() {
        BowlingGame game = new BowlingGame("1/345123451234512345");
        assertEquals(70,game.getScore());
    }

    /*
     * given: game with two SPARE
     * when: end game
     * then: calculate the score
     * */
    @Test
    public void getScoreWithTwoSpare() {
        BowlingGame game = new BowlingGame("1/3/5123451234512345");
        assertEquals(78,game.getScore());
    }

    /*
     * given: game with STRIKE AFTER SPARE
     * when: end game
     * then: calculate the score
     * */

    @Test
    public void getScoreWithStrikeAfterSpare() {
        BowlingGame game = new BowlingGame("1/X51");
        assertEquals(42,game.getScore());
    }

    /*
     * given: game with multiple SPARES
     * when: end game
     * then: calculate the score
     * */
    @Test
    public void getScoreWithMultipleSpare() {
        BowlingGame game = new BowlingGame("5/8/6/7/7/9/5/8/9/9/X");
        assertEquals(178,game.getScore());
    }

    /*
     * given: game with one STRIKE
     * when: end game
     * then: calculate the score
     * */
    @Test
    public void getScoreOfOneStrike() {
//        BowlingGame game = new BowlingGame("X34");
        BowlingGame game = new BowlingGame("X345123451234512345");
        assertEquals(74,game.getScore());

    }

    /*
     * given: game with a MISS after STRIKE
     * when: end game
     * then: calculate the score
     * */

    @Test
    public void getScoreAMissAfterStrike() {
        BowlingGame game = new BowlingGame("X-4");
        assertEquals(18,game.getScore());
    }

    /*
     * given: game with two MISSes after STRIKE
     * when: end game
     * then: calculate the score
     * */

    @Test
    public void getScoreTwoMissesAfterStrike() {
        BowlingGame game = new BowlingGame("X--");
        assertEquals(10,game.getScore());
    }

    /*
     * given: game with two CONSECUTIVE STRIKES
     * when: end game
     * then: calculate the score
     * */

    @Test
    public void getScoreTwoSpare() {
        BowlingGame game = new BowlingGame("XX45");
        assertEquals(52,game.getScore());
    }

    /*
     * given: Perfect game (full strike)
     * when: end game
     * then: calculate the score
     * */
    @Test
    public void getScoreOfPerfectGame() {
        BowlingGame game = new BowlingGame("XXXXXXXXXXXX");
        assertEquals(300,game.getScore());
    }

    /*
     * given: Heartbreak game (a miss every pin)
     * when: end game
     * then: calculate the score
     * */
    @Test
    public void getScoreOfHeartbreakGame() {
        BowlingGame game = new BowlingGame("9-9-9-9-9-9-9-9-9-9-");
        assertEquals(90,game.getScore());
    }

    /*
     * given: game with spare every pin
     * when: end game
     * then: calculate the score
     * */
    @Test
    public void getScoreOfSpareEveryRound() {
        BowlingGame game = new BowlingGame("5/5/5/5/5/5/5/5/5/5/5");
        assertEquals(150,game.getScore());
    }

//    // get One Spare
//    @Test
//    public void getOneSpare() {
//        BowlingGame game = new BowlingGame("1/345123451234512345");
//        assertEquals(1,game.getNumSpare());
//        assertEquals(0,game.getNumStrike());
//    }

//    // get One Spare position
//    @Test
//    public void getOneSparePosition() {
//        BowlingGame game = new BowlingGame("1/345123451234512345");
//        assertEquals(1,game.getSpare()[0]);
//    }
//    // get One Strike Position
//    @Test
//    public void getOneStrikePosition() {
//        BowlingGame game = new BowlingGame("X345123451234512345");
//        assertEquals(0,game.getStrike()[0]);
//
//    }

}
