package dreamlinedesign.winecognoscenti.DB;

/**
 * Created by GeEEE on 2016-02-04.
 */
public class Ingredients {

    private String name;
    private String food_type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public Ingredients(String name, String food_type) {
        this.name = name;
        this.food_type = food_type;
    }

    @Override
    public String toString() {
        return name;
    }
}
