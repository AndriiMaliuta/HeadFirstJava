package Game;

import java.util.*;

public class DotComBust {

    private GameHelper gameHelper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your aim is to drawn 3 sites");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to drawn them in minimal number of moves");

        for (DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = gameHelper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying() {
        while(!dotComsList.isEmpty()) {
            String userGuess = gameHelper.getUserInput("Make your move");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    public void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Missed";
        for (DotCom dotComToTest : dotComsList) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Missed")) {
                break;
            }
            if (result.equals("Drawn")) {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All sites are at the abyss");
        if (numOfGuesses <= 18) {
            System.out.println("It took you only " + numOfGuesses + "attempts");
            System.out.println("You got out before your actions got drowned");
        } else {
            System.out.println("It took you rather much time");
            System.out.println("Fish is dancing around your actions");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();

    }

}