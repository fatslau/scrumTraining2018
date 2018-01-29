package org.Bowling;

import java.util.HashMap;
import java.util.stream.IntStream;

public class BowlingGame {
    private int score, numSpare, numStrike;
    private int[] numericScore,spare,strike;
    private static final int ROUND = 12;
    private static final String SPARE = "/", STRIKE = "X";

    public BowlingGame(String game){
        score = stupidCal(game);
//        parser(game);
//        getSpareStrike(game);
//        score = calculateScore(game);
//        score = calculateScore2(game);
    }

    private int countChar(String str ,String c){
        return str.length() - str.replace(c,"").length();
    }

    private int[] getSpareStrikeList(String game, int size, String symbol) {
        int[] result = new int[size];
        for (int char_index = -1, i = 0; char_index < game.length() && i < result.length; ) {
            char_index = game.indexOf(symbol, (char_index==-1?0:char_index)+(char_index==-1?0:1));
            result[i++] = char_index;
        }
        return result;
    }

    private void getSpareStrike(String game) {
        numSpare = countChar(game,SPARE);
        numStrike = countChar(game,STRIKE);
        spare = getSpareStrikeList(game,numSpare,SPARE);
        strike = getSpareStrikeList(game,numStrike, STRIKE);
//        numSpare = StringUtils.countMatches("a.b.c.d", ".");
    }

    private void parser(String game){
        char[] c_arr = game.toCharArray();
        numericScore = new int[c_arr.length];
        for(int i=0; i< c_arr.length; i++){
            int pinHit = Character.getNumericValue(c_arr[i]);
            numericScore[i] = (pinHit<0?0:(pinHit>9?0:pinHit));
        }
    }

    private int calculateScore(String result){
        score = IntStream.of(numericScore).sum();
        calSpare();
        calStrike();
        return score;
    }

    private int getScore(char result){
        if(result == 'X')return 10;
        if(result == '-')return 0;
        if(result == '/')return -1;
        return Character.getNumericValue(result);
    }

    public int fnForStrike(){
        return 0;
    }

//    private final HashMap<Character,Integer> function = new HashMap<Character, Integer>(){{
//        put('X',this.fnForStrike);
//    }};
/*

    private final HashMap<Character,RollType> function = new HashMap<Character, RollType>(){{
        put('X', new RollType() {
            @Override
            public int score(char nextRoll, char next2Roll) {
                // 1/ or 22,XX,-- after X
                return 10 + (getScore(next2Roll) == -1 ? 10 : getScore(nextRoll) + getScore(next2Roll));
                i++;
                pin++;
            }
        });
        put('/', new RollType() {
            @Override
            public int score(char nextRoll, char next2Roll) {
                return 0;
            }
        });
    }};
*/

//    Map<String, ProcessingMethod> methodMap = new HashMap<String, ProcessingMethod>();
//methodMap.put("abc", new ProcessingMethod() {
//        String method() { return "xyz" }
//    });
//        methodMap.put("def", new ProcessingMethod() {
//        String method() { return "uvw" }
//    });
//
//        methodMap.get("abc").method();


    private int stupidCal(String result) {
        char[] c_result = result.toCharArray();
        score = 0;

        for (int i = 0, pin = 0; i < c_result.length && pin < 10; ) {
            if (c_result[i] == 'X') {
                // 1/ or 22,XX,-- after X
                score += 10 + (getScore(c_result[i + 2]) == -1 ? 10 : getScore(c_result[i + 1]) + getScore(c_result[i + 2]));
                i++;
                pin++;
            } else {
                if (c_result[i + 1] == '/')
                    score += 10 + getScore(c_result[i + 2]);
                else
                    score += getScore(c_result[i]) + getScore(c_result[i + 1]);

                i += 2;
                pin++;
            }
        }
        return score;
    }

//        for(int i=0,pin=0;i<numericScore.length && pin <=10;){
//            if(numericScore[i]==0){
//                if(Arrays.asList(strike).contains(i)){
//                    // X case
//                    int doubleCountedScore1 = numericScore[i+ 1];
//                    int doubleCountedScore2 = numericScore[i+ 2];
//                    score += 10 + (doubleCountedScore1==0?10:doubleCountedScore1)+(doubleCountedScore2==0?10:doubleCountedScore2);
//                    i++;
//                }else{
//                    //-5 case
//                    score +=numericScore[i]+numericScore[i+1];
//                    i +=2;
//                }
//            }else if(numericScore[i+1]==0){
//                if(Arrays.asList(spare).contains(i+1)){
//                    int doubleCountedScore = numericScore[spare[i] + 1];
//                    // case: X after /
//                    score += 10 + (doubleCountedScore==0?10:doubleCountedScore);
//                }else{
//                    // 5- case
//                    score +=numericScore[i]+numericScore[i+1];
//                }
//                i+=2;
//            }else{
//                // 54 case
//                score +=numericScore[i]+numericScore[i+1];
//                i+=2;
//            }
//        }

    private int calculateScore2(String result){
        int pinCount = spare.length + strike.length;
        int posCount = spare.length * 2 + strike.length;
        pinCount = pinCount>10?10:pinCount;
        int countTill = (pinCount < 10)?posCount + (10-pinCount)*2:posCount;
        for(int i=0,score = 0;i<countTill;i++){
            score+=numericScore[i];
        }

        score = IntStream.of(numericScore).sum();
        calSpare();
        calStrike();
        return score;
    }

    private void calSpare () {
        //spare
        for (int i = 0; i < spare.length; i++) {
            score -= numericScore[spare[i] - 1];
            int doubleCountedScore = numericScore[spare[i] + 1];
            // case: X after /
            score += 10 + (doubleCountedScore==0?10:doubleCountedScore);
        }
    }

    private void calStrike() {
        //strike
        for (int i = 0; i < strike.length && strike[i]<numericScore.length-1; i++) {
            int doubleCountedScore1 = numericScore[strike[i] + 1];
            int doubleCountedScore2 = numericScore[strike[i] + 2];
            score += 10 + (doubleCountedScore1==0?10:doubleCountedScore1)+(doubleCountedScore2==0?10:doubleCountedScore2);
        }
    }

    public int getScore(){return score;}

    public int getNumSpare() {return numSpare;}

    public int getNumStrike() {return numStrike;}

    public int[] getSpare() {return spare;}

    public int[] getStrike() {return strike;}
}


interface RollType {
    int score(char nextRoll, char next2Roll);
}