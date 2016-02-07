package dreamlinedesign.winecognoscenti.DB;

/**
 * Created by GeEEE on 2016-02-04.
 */
public class WineType {

    private String wine_type;

    public String getWine_type() {
        return wine_type;
    }

    public void setWine_type(String wine_type) {
        this.wine_type = wine_type;
    }




    public WineType(String wine_type) {
        this.wine_type = wine_type;
    }

    @Override
    public String toString() {
        return wine_type;
    }
}
