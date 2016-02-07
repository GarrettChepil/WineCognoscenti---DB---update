package dreamlinedesign.winecognoscenti.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by GeEEE on 2016-02-03.
 */
public class PairingDB {

    private SQLiteDatabase db;
    private MySQLiteHelper dbHelper;

    public PairingDB(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long createwinetype(Pairing wine) {
        open();

        ContentValues values = new ContentValues();
        values.put("wine_type", wine.getWine_type());
        values.put("food_type", wine.getWine_type());
        values.put("pairing", wine.getPairing());
        values.put("perfect", wine.getPerfect());


        // insert row
        long wine_id = db.insert("Pairing", null, values);


        close();
        return wine_id;
    }

    public long createwinetype(String wtype, String ftype, int pairing, int perfect) {
        open();

        ContentValues values = new ContentValues();
        values.put("wine_type", wtype);
        values.put("food_type", ftype);
        values.put("pairing", pairing);
        values.put("perfect", perfect);


        // insert row
        long wine_id = db.insert("Pairing", null, values);


        close();
        return wine_id;
    }
}
