package dreamlinedesign.winecognoscenti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by GeEEE on 2016-02-06.
 */
public class BestPairing {
    private ArrayList<Boolean[]> selected;
    //public  Boolean [] checkmeat, checkCheese, checkProduce, checkHerbSpice,checkStarch, checkSweet, checkPrep;
    private int[] best;
    private int highest = 0;
    private int secondhighest=0;

    private Map<Integer,Integer> topSelection;
    private Map<Integer, Integer> Second;




    //getters setter



    public int[] getBest() {
        return best;
    }


    public int getHighest() {
        return highest;
    }


    public int getSecondhighest() {
        return secondhighest;
    }


    public Map<Integer, Integer> getTopSelection() {
        return topSelection;
    }


    public Map<Integer, Integer> getSecond() {
        return Second;
    }



    //constructor

    public BestPairing(ArrayList<Boolean[]> selected) {
        this.selected = selected;
        this.best = new int[9];
        topSelection = new HashMap<>();
        Second = new HashMap<>();
        GetPairing();

    }

    private void GetPairing() {


        if(selected.get(0)[0]){
            best[0] += 1;
            best[1] += 1;
        }
        if(selected.get(0)[1]){
            best[0] += 1;
            best[1] += 1;
            best[2] += 1;
            best[3] += 1;
            best[6] += 1;
            best[7] += 1;
            best[8] += 1;
        }
        if(selected.get(0)[2]) {
            best[0] += 1;
            best[1] += 1;
            best[3] += 1;
            best[6] += 1;
        }
        if(selected.get(0)[3]) {
            best[1] += 1;
            best[2] += 1;
            best[3] += 1;
            best[4] += 1;
            best[5] += 1;
            best[6] += 1;
        }
        if(selected.get(0)[4]) {
            best[5] += 1;
            best[6] += 1;
        }
        if(selected.get(0)[5]) {
            best[4] += 1;
            best[5] += 1;
            best[6] += 1;
        }
        if(selected.get(0)[6]) {
            best[3] += 1;
            best[4] += 1;
            best[5] += 1;
            best[7] += 1;
        }
        if(selected.get(1)[0]) {
            best[1] += 1;
            best[2] += 1;
            best[3] += 1;
            best[4] += 1;
            best[5] += 1;
            best[6] += 1;
            best[7] += 1;
            best[8] += 1;
        }
        if(selected.get(1)[1]) {
            best[0] += 1;
            best[1] += 1;
            best[3] += 1;
            best[5] += 1;
            best[6] += 1;
            best[7] += 1;
            best[8] += 1;
        }
        if(selected.get(1)[2]) {
            best[0] += 1;
            best[1] += 1;
            best[3] += 1;
            best[4] += 1;
            best[6] += 1;
        }
        if(selected.get(2)[0]) {
            best[0] += 1;
            best[1] += 1;
            best[2] += 1;
            best[3] += 1;
            best[4] += 1;
            best[5] += 1;
            best[6] += 1;
            best[7] += 1;
        }
        if(selected.get(2)[1]) {
            best[5] += 1;
            best[6] += 1;
        }
        if(selected.get(2)[2]) {
            best[3] += 1;
            best[4] += 1;
            best[7] += 1;
        }
        if(selected.get(2)[3]) {
            best[0] += 1;
            best[1] += 1;
            best[3] += 1;
            best[7] += 1;
        }
        if(selected.get(2)[4]) {
            best[0] += 1;
            best[1] += 1;
            best[2] += 1;
            best[4] += 1;
        }
        if(selected.get(2)[5]) {
            best[2] += 1;
            best[3] += 1;
            best[4] += 1;
            best[5] += 1;
            best[6] += 1;
            best[7] += 1;
        }
        if(selected.get(2)[6]) {
            best[1] += 1;
            best[3] += 1;
            best[5] += 1;
            best[6] += 1;
        }
        if(selected.get(3)[0]) {
            best[0] += 1;
            best[1] += 1;
        }
        if(selected.get(3)[1]) {
            best[0] += 1;
            best[1] += 1;
            best[3] += 1;
            best[5] += 1;
            best[6] += 1;
            best[7] += 1;
        }
        if(selected.get(3)[2]) {
            best[5] += 1;
            best[6] += 1;
            best[7] += 1;
        }
        if(selected.get(3)[3]) {
            best[1] += 1;
            best[2] += 1;
            best[3] += 1;
            best[4] += 1;
            best[5] += 1;
        }
        if(selected.get(3)[4]) {
            best[1] += 1;
            best[3] += 1;
            best[7] += 1;
            best[8] += 1;
        }
        if(selected.get(3)[5]) {
            best[1] += 1;
            best[2] += 1;
            best[3] += 1;
            best[6] += 1;
            best[7] += 1;
        }
        if(selected.get(4)[0]) {
            best[0] += 1;
            best[1] += 1;
            best[2] += 1;
            best[3] += 1;
            best[4] += 1;
            best[5] += 1;
            best[6] += 1;
            best[7] += 1;
            best[8] += 1;
        }
        if(selected.get(4)[1]) {
            best[2] += 1;
            best[3] += 1;
            best[4] += 1;
            best[7] += 1;
        }
        if(selected.get(4)[2]) {
            best[3] += 1;
            best[7] += 1;
        }
        if(selected.get(4)[3]) {
            best[0] += 1;
            best[1] += 1;
            best[2] += 1;
            best[3] += 1;
            best[4] += 1;
            best[5] += 1;
            best[6] += 1;
            best[7] += 1;
        }
        if(selected.get(5)[0]) {
            best[6] += 1;
            best[7] += 1;
            best[8] += 1;
        }
        if(selected.get(5)[1]) {
            best[7] += 1;
            best[8] += 1;
        }
        if(selected.get(5)[2]) {
            best[8] += 1;

        }
        if(selected.get(6)[0]) {
            best[0] += 1;
            best[1] += 1;
            best[2] += 1;
            best[6] += 1;
            best[7] += 1;
        }
        if(selected.get(6)[1]) {
            best[2] += 1;
            best[3] += 1;
            best[4] += 1;
            best[5] += 1;
            best[6] += 1;
        }
        if(selected.get(6)[2]) {
            best[0] += 1;
            best[1] += 1;
            best[2] += 1;
            best[3] += 1;
            best[6] += 1;
            best[8] += 1;
        }
        if(selected.get(6)[3]) {
            best[0] += 1;
            best[1] += 1;
            best[2] += 1;
            best[3] += 1;
            best[7] += 1;
        }
        if(selected.get(6)[4]) {
            best[4] += 1;
            best[5] += 1;
            best[6] += 1;
            best[7] += 1;
        }

        getHIGH();









    }

    private void getHIGH() {
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
                topSelection.put(i,perfectPairing(i));
            }
            else if ((best[i] == secondhighest)&& (secondhighest == highest-1)) {
                Second.put(i, perfectPairing(i));
            }
        }
    }

    private int perfectPairing(int wineNumber) {
        int pairing = 0;
            if (wineNumber == 0) {
                if(selected.get(0)[0])
                    pairing++;
                if(selected.get(1)[2])
                    pairing++;
                if(selected.get(3)[0])
                    pairing++;
                if(selected.get(6)[0])
                    pairing++;
                if(selected.get(6)[3])
                    pairing++;
            }

            else if (wineNumber == 1){
                if(selected.get(0)[2])
                    pairing++;
                if(selected.get(1)[1])
                    pairing++;
                if(selected.get(2)[1])
                    pairing++;
                if(selected.get(2)[0])
                    pairing++;
                if(selected.get(2)[3])
                    pairing++;
                if(selected.get(2)[4])
                    pairing++;
                if(selected.get(3)[1])
                    pairing++;
                if(selected.get(3)[5])
                    pairing++;
                if(selected.get(6)[2])
                    pairing++;
            }
            else if (wineNumber == 2){
                if(selected.get(0)[1])
                    pairing++;
                if(selected.get(0)[3])
                    pairing++;
                if(selected.get(1)[0])
                    pairing++;
                if(selected.get(2)[4])
                    pairing++;
                if(selected.get(6)[1])
                    pairing++;

            }
            else if (wineNumber == 3) {
                if(selected.get(2)[2])
                    pairing++;
            }

            else if (wineNumber == 4) {
                if(selected.get(0)[3])
                    pairing++;
                if(selected.get(0)[6])
                    pairing++;
                if(selected.get(1)[0])
                    pairing++;
                if(selected.get(2)[4])
                    pairing++;


            }
            else if (wineNumber == 5) {
                if(selected.get(0)[5])
                    pairing++;
                if(selected.get(2)[1])
                    pairing++;
                if(selected.get(2)[6])
                    pairing++;
                if(selected.get(3)[3])
                    pairing++;
                if(selected.get(6)[4])
                    pairing++;
            }
            else if (wineNumber == 6) {
                if(selected.get(0)[4])
                    pairing++;

            }
            else if (wineNumber == 7) {
                if(selected.get(0)[1])
                    pairing++;
                if(selected.get(2)[5])
                    pairing++;
                if(selected.get(3)[2])
                    pairing++;
                if(selected.get(3)[5])
                    pairing++;
                if(selected.get(4)[1])
                    pairing++;
                if(selected.get(4)[2])
                    pairing++;
                if(selected.get(5)[0])
                    pairing++;
            }

            else if (wineNumber == 8){
                if(selected.get(1)[1])
                    pairing++;
                if(selected.get(3)[4])
                    pairing++;
                if(selected.get(5)[2])
                    pairing++;
            }
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



