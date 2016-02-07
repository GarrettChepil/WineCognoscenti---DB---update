package dreamlinedesign.winecognoscenti.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by GeEEE on 2016-02-03.
 */
public class IngredientsDB {

    private SQLiteDatabase db;
    private MySQLiteHelper dbHelper;

    public IngredientsDB(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long createIngredient(Ingredients in) {
        open();

        ContentValues values = new ContentValues();
        values.put("name", in.getName());
        values.put("food_type", in.getFood_type());

        // insert row
        long wine_id = db.insert("ingredients", null, values);



        return wine_id;
    }

    public long createIngredient(String in, String ft) {
        open();

        ContentValues values = new ContentValues();
        values.put("name", in);
        values.put("food_type", ft);

        // insert row
        long wine_id = db.insert("ingredients", null, values);



        return wine_id;
    }
}
