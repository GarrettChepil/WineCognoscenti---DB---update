package dreamlinedesign.winecognoscenti.DB;

/**
 * Created by GeEEE on 2016-02-04.
 */
public class Wine {
    private int id;
    private String name;
    private String wine_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWine_type() {
        return wine_type;
    }

    public void setWine_type(String wine_type) {
        this.wine_type = wine_type;
    }


    public Wine(String name, String wine_type) {
        this.name = name;
        this.wine_type = wine_type;
    }

    @Override
    public String toString() {
        return name;
    }
}
