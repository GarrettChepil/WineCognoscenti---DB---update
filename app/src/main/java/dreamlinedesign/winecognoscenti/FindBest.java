package dreamlinedesign.winecognoscenti;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by GeEEE on 2016-02-01.
 */
public class FindBest  {

    public static Boolean [] checkmeat, checkCheese, checkProduce, checkHerbSpice,checkStarch, checkSweet, checkPrep;

    private int ingt1;
    private int ingt2;
    private int ingt3;
    private int ingt4;
    private int prep;
    private int[] best;
    private int highest = 0;
    private int secondhighest=0;
    private int selected[];
    private Map<Integer,Integer> topSelection;
    private Map<Integer, Integer> Second;

    public Map<Integer, Integer> getTopSelection() {
        return topSelection;
    }

    public void setTopSelection(Map<Integer, Integer> topSelection) {
        this.topSelection = topSelection;
    }

    public Map<Integer, Integer> getSecond() {
        return Second;
    }

    public void setSecond(Map<Integer, Integer> second) {
        Second = second;
    }

    public int[] getBest() {
        return best;
    }

    public void setBest(int[] best) {
        this.best = best;
    }


    public int getIngt1() {
        return ingt1;
    }

    public void setIngt1(int ingt1) {
        this.ingt1 = ingt1;
    }

    public int getIngt2() {
        return ingt2;
    }

    public void setIngt2(int ingt2) {
        this.ingt2 = ingt2;
    }

    public int getIngt3() {
        return ingt3;
    }

    public void setIngt3(int ingt3) {
        this.ingt3 = ingt3;
    }

    public int getIngt4() {
        return ingt4;
    }

    public void setIngt4(int ingt4) {
        this.ingt4 = ingt4;
    }

    public int getPrep() {
        return prep;
    }

    public void setPrep(int prep) {
        this.prep = prep;
    }

    public FindBest() {
        this.ingt1 = 0;
        this.ingt2 = 0;
        this.ingt3 = 0;
        this.ingt4 = 0;
        this.prep = 0;
        this.best = new int[9];
        topSelection = new HashMap<>();
        Second = new HashMap<>();
    }

    public FindBest(int ingt1, int ingt2, int ingt3, int ingt4, int prep) {
        this.ingt1 = ingt1;
        this.ingt2 = ingt2;
        this.ingt3 = ingt3;
        this.ingt4 = ingt4;
        this.prep = prep;
        this.best = new int[9];
        topSelection = new HashMap<>();
        Second = new HashMap<>();
    }

    public int[] changetoArray() {
        int[] selected = new int[4];
        selected[0] = getIngt1();
        selected[1] = getIngt2();
        selected[2] = getIngt3();
        selected[3] = getIngt4();
        return selected;
    }

    public void resetBest() {
        for(int i = 0; i < 9; i++) {
            best[i] = 0;
        }
        topSelection.clear();
        Second.clear();

    }

    public void AddSelections() {
        resetBest();
        selected = changetoArray();
        int prep = getPrep();
        for(int i = 0; i < 4; i++) {
            switch (selected[i]) {
                case 1:
                    best[0] += 1;
                    best[1] += 1;
                    break;
                case 2:
                    best[0] += 1;
                    best[1] += 1;
                    best[2] += 1;
                    best[3] += 1;
                    best[6] += 1;
                    best[7] += 1;
                    best[8] += 1;
                    break;
                case 3:
                    best[0] += 1;
                    best[1] += 1;
                    best[3] += 1;
                    best[6] += 1;
                    break;
                case 4:
                    best[1] += 1;
                    best[2] += 1;
                    best[3] += 1;
                    best[4] += 1;
                    best[5] += 1;
                    best[6] += 1;
                    break;
                case 5:
                    best[5] += 1;
                    best[6] += 1;
                    break;
                case 6:
                    best[4] += 1;
                    best[5] += 1;
                    best[6] += 1;
                    break;
                case 7:
                    best[3] += 1;
                    best[4] += 1;
                    best[5] += 1;
                    best[7] += 1;
                    break;
                case 8:
                    best[1] += 1;
                    best[2] += 1;
                    best[3] += 1;
                    best[4] += 1;
                    best[5] += 1;
                    best[6] += 1;
                    best[7] += 1;
                    best[8] += 1;
                    break;
                case 9:
                    best[0] += 1;
                    best[1] += 1;
                    best[3] += 1;
                    best[5] += 1;
                    best[6] += 1;
                    best[7] += 1;
                    best[8] += 1;
                    break;
                case 10:
                    best[0] += 1;
                    best[1] += 1;
                    best[3] += 1;
                    best[4] += 1;
                    best[6] += 1;
                    break;
                case 11:
                    best[0] += 1;
                    best[1] += 1;
                    best[2] += 1;
                    best[3] += 1;
                    best[4] += 1;
                    best[5] += 1;
                    best[6] += 1;
                    best[7] += 1;
                    break;
                case 12:
                    best[5] += 1;
                    best[6] += 1;
                    break;
                case 13:
                    best[3] += 1;
                    best[4] += 1;
                    best[7] += 1;
                    break;
                case 14:
                    best[0] += 1;
                    best[1] += 1;
                    best[3] += 1;
                    best[7] += 1;
                    break;
                case 15:
                    best[0] += 1;
                    best[1] += 1;
                    best[2] += 1;
                    best[4] += 1;
                    break;
                case 16:
                    best[2] += 1;
                    best[3] += 1;
                    best[4] += 1;
                    best[5] += 1;
                    best[6] += 1;
                    best[7] += 1;
                    break;
                case 17:
                    best[1] += 1;
                    best[3] += 1;
                    best[5] += 1;
                    best[6] += 1;
                    break;
                case 18:
                    best[0] += 1;
                    best[1] += 1;
                    break;
                case 19:
                    best[0] += 1;
                    best[1] += 1;
                    best[3] += 1;
                    best[5] += 1;
                    best[6] += 1;
                    best[7] += 1;
                    break;
                case 20:
                    best[5] += 1;
                    best[6] += 1;
                    best[7] += 1;
                    break;
                case 21:
                    best[1] += 1;
                    best[2] += 1;
                    best[3] += 1;
                    best[4] += 1;
                    best[5] += 1;
                    break;
                case 22:
                    best[1] += 1;
                    best[3] += 1;
                    best[7] += 1;
                    best[8] += 1;
                    break;
                case 23:
                    best[1] += 1;
                    best[2] += 1;
                    best[3] += 1;
                    best[6] += 1;
                    best[7] += 1;
                    break;
                case 24:
                    best[0] += 1;
                    best[1] += 1;
                    best[2] += 1;
                    best[3] += 1;
                    best[4] += 1;
                    best[5] += 1;
                    best[6] += 1;
                    best[7] += 1;
                    best[8] += 1;
                    break;
                case 25:
                    best[2] += 1;
                    best[3] += 1;
                    best[4] += 1;
                    best[7] += 1;
                    break;
                case 26:
                    best[3] += 1;
                    best[7] += 1;
                    break;
                case 27:
                    best[0] += 1;
                    best[1] += 1;
                    best[2] += 1;
                    best[3] += 1;
                    best[4] += 1;
                    best[5] += 1;
                    best[6] += 1;
                    best[7] += 1;
                    break;
                case 28:
                    best[6] += 1;
                    best[7] += 1;
                    best[8] += 1;
                    break;
                case 29:
                    best[7] += 1;
                    best[8] += 1;
                    break;
                case 30:
                    best[8] += 1;
                    break;
                default:
                    break;
            }
        }
        switch (prep) {
            case 1:
                best[0] += 1;
                best[1] += 1;
                best[2] += 1;
                best[6] += 1;
                best[7] += 1;
                break;
            case 2:
                best[2] += 1;
                best[3] += 1;
                best[4] += 1;
                best[5] += 1;
                best[6] += 1;
                break;
            case 3:
                best[0] += 1;
                best[1] += 1;
                best[2] += 1;
                best[3] += 1;
                best[6] += 1;
                best[8] += 1;
                break;
            case 4:
                best[4] += 1;
                best[5] += 1;
                best[6] += 1;
                best[7] += 1;
                break;
            default:
                break;
        }

        getHighest();
    }

    private void getHighest() {
        highest = 0;
        secondhighest = 0;

        for (int i = 0; i < best.length; i++) {
            if (best[i] > highest) {
                secondhighest = highest;
                highest = best[i];

            } else if ((best[i] != highest) && (best[i] > secondhighest))
                secondhighest = best[i];
        }
        System.out.println(highest + " " + secondhighest);
        FindTop2();
    }

    private void FindTop2() {
        for (int i = 0;i < best.length; i++) {
            if(best[i] == highest){
                topSelection.put(i,highest + perfectPairing(i));
            }
            else if ((best[i] == secondhighest)&& (secondhighest == highest-1)) {
                Second.put(i, secondhighest + perfectPairing(i));
            }
        }
    }

    private int perfectPairing(int wineNumber) {
        int pairing = 0;
        for(int i = 0; i < selected.length; i++) {
            if (wineNumber == 0 && (Arrays.asList(1, 10, 18).contains(selected[i])))
                pairing ++;
            else if (wineNumber == 1 && (Arrays.asList(3, 9, 11, 14, 15,19, 23).contains(selected[i])))
                pairing ++;
            else if (wineNumber == 2&& (Arrays.asList(2, 4, 8 , 15).contains(selected[i])))
                pairing ++;
            else if (wineNumber == 3 && (selected[i] == 13))
                pairing ++;
            else if (wineNumber == 4 && (Arrays.asList(4,7, 8, 15 ).contains(selected[i])))
                pairing ++;
            else if (wineNumber == 5 && (Arrays.asList(6, 12, 17, 21).contains(selected[i])))
                pairing ++;
            else if (wineNumber == 6 && (selected[i] == 5))
                pairing ++;
            else if (wineNumber == 7 && (Arrays.asList(2, 16, 20, 23, 26, 25, 28).contains(selected[i])))
                pairing ++;
            else if (wineNumber == 8 && (Arrays.asList(9, 22, 30).contains(selected[i])))
                pairing ++;


        }
        if(wineNumber == 0 && (Arrays.asList(1, 4).contains(prep)))
            pairing++;
        else if(wineNumber == 1 && (prep == 3))
            pairing++;
        else if(wineNumber == 2 && (prep == 2))
            pairing++;
        else if(wineNumber == 5 && (prep == 5))
            pairing++;

        return pairing;
    }

    public String getWineName(int i) {
        switch(i){
            case 0:
                return "Bold Red";
            case 1:
                return "Medium Red";
            case 2:
                return "Light Red";
            case 3:
                return "Rose";
            case 4:
                return "Rich White";
            case 5:
                return "Light White";
            case 6:
                return "Sparkling";
            case 7:
                return "Sweet White";
            case 8:
                return "Desert";
        }

        return null;
    }
}


