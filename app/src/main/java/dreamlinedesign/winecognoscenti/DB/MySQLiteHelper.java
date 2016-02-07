package dreamlinedesign.winecognoscenti.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "MySQLiteHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "wineswithFood";

    // Table Names
    private static final String TABLE_WINES = "wines";
    private static final String TABLE_WINE_TYPE = "wine_type";
    private static final String TABLE_PAIRING = "pairings";
    private static final String TABLE_FOOD_TYPES = "food_types";
    private static final String TABLE_INGREDIENTS = "ingredients";

    // Common column names
    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_WINE_TYPE = "wine_type";
    private static final String KEY_FOOD_TYPE = "food_type";

    // Table Create Statements
    // wines table create statement
    private static final String CREATE_TABLES_WINES = "CREATE TABLE "
            + TABLE_WINES + "(" + KEY_ID + " INTEGER PRIMARY KEY autoincrement," + KEY_NAME
            + " TEXT," + KEY_WINE_TYPE + " TEXT "  + ")";

    // wine types table create statement
    private static final String CREATE_TABLES_WINES_TYPE = "CREATE TABLE " + TABLE_WINE_TYPE
            + "(" + KEY_ID + " INTEGER PRIMARY KEY autoincrement," + KEY_WINE_TYPE + " TEXT "
             + ")";

    // pairings table create statement
    private static final String CREATE_TABLE_PAIRING = "CREATE TABLE "
            + TABLE_PAIRING + "(" + KEY_WINE_TYPE + " TEXT, " + KEY_FOOD_TYPE + " TEXT, "
            + "pairing" + " INTEGER, " + " perfect" + " INTEGER," + "PRIMARY KEY (" + KEY_WINE_TYPE + ", " +
            KEY_FOOD_TYPE + "))";

    // food types table create statement
    private static final String CREATE_TABLE_FOOD_TYPES = "CREATE TABLE "
            + TABLE_FOOD_TYPES + "(" + KEY_ID + " INTEGER PRIMARY KEY autoincrement," + KEY_FOOD_TYPE +
            " TEXT " + ")";

    // food types table create statement
    private static final String CREATE_TABLE_INGERDIENTS = "CREATE TABLE "
            + TABLE_INGREDIENTS + "(" + KEY_ID + " INTEGER PRIMARY KEY autoincrement," + KEY_NAME +
            " TEXT " + KEY_FOOD_TYPE + " TEXT" +")";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLES_WINES);
        db.execSQL(CREATE_TABLES_WINES_TYPE);
        db.execSQL(CREATE_TABLE_PAIRING);
        db.execSQL(CREATE_TABLE_FOOD_TYPES);
        db.execSQL(CREATE_TABLE_INGERDIENTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WINES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WINE_TYPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD_TYPES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INGREDIENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAIRING);

        // create new tables
        onCreate(db);
    }
}