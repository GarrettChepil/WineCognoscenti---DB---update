package dreamlinedesign.winecognoscenti.DB;

/**
 * Created by GeEEE on 2016-02-04.
 */
public class Pairing {

    private String food_type;
    private String wine_type;
    private int  pairing;
    private int  perfect;

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public String getWine_type() {
        return wine_type;
    }

    public void setWine_type(String wine_type) {
        this.wine_type = wine_type;
    }

    public int getPairing() {
        return pairing;
    }

    public void setPairing(int pairing) {
        this.pairing = pairing;
    }

    public int getPerfect() {
        return perfect;
    }

    public void setPerfect(int perfect) {
        this.perfect = perfect;
    }

    public Pairing(String food_type, String wine_type, int pairing, int perfect) {
        this.food_type = food_type;
        this.wine_type = wine_type;
        this.pairing = pairing;
        this.perfect = perfect;
    }


}
