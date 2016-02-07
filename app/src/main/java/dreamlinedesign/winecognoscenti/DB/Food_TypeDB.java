package dreamlinedesign.winecognoscenti.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by GeEEE on 2016-02-03.
 */
public  class Food_TypeDB {

    private  SQLiteDatabase db;
    private  MySQLiteHelper dbHelper;

    public  Food_TypeDB(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public  void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long createFoodType(Food_Type ft) {
        open();
        ContentValues values = new ContentValues();
        values.put("food_type", ft.getFood_type());

        // insert row
        long wine_id = db.insert("food_types", null, values);


        close();
        return wine_id;
    }

    public long createFoodType(String ft) {
        open();

        ContentValues values = new ContentValues();
        values.put("food_type", ft);

        // insert row
        long wine_id = db.insert("food_types", null, values);


        close();
        return wine_id;
    }
}
