package dreamlinedesign.winecognoscenti.DB;

/**
 * Created by GeEEE on 2016-02-04.
 */
public class Food_Type {

    String food_type;

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public Food_Type(String food_type) {
        this.food_type = food_type;
    }

    @Override
    public String toString() {
        return food_type;
    }
}
