package dreamlinedesign.winecognoscenti.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by GeEEE on 2016-02-03.
 */
public class WinesDB {

    private SQLiteDatabase db;
    private MySQLiteHelper dbHelper;

    public WinesDB(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long createWine(Wine wine) {
        open();

        ContentValues values = new ContentValues();
        values.put("name", wine.getName());
        values.put("wine_type", wine.getWine_type());

        // insert row
        long wine_id = db.insert("wines", null, values);



        return wine_id;
    }
    public long createWine(String wine, String type) {
        open();

        ContentValues values = new ContentValues();
        values.put("name", wine);
        values.put("wine_type", type);

        // insert row
        long wine_id = db.insert("wines", null, values);



        return wine_id;
    }
}
