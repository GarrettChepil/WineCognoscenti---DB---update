package dreamlinedesign.winecognoscenti.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by GeEEE on 2016-02-03.
 */
public class Wine_TypeDB {

    private SQLiteDatabase db;
    private MySQLiteHelper dbHelper;

    public Wine_TypeDB(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long createwinetype(WineType wine) {
        open();

        ContentValues values = new ContentValues();
        values.put("wine_type", wine.getWine_type());

        // insert row
        long wine_id = db.insert("wine_type", null, values);


        close();
        return wine_id;
    }
    public long createwinetype(String type) {
        open();

        ContentValues values = new ContentValues();
        values.put("wine_type", type);

        // insert row
        long wine_id = db.insert("wine_type", null, values);


        close();
        return wine_id;
    }
}
