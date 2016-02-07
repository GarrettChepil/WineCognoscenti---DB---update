package dreamlinedesign.winecognoscenti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import dreamlinedesign.winecognoscenti.DB.Food_TypeDB;
import dreamlinedesign.winecognoscenti.DB.MySQLiteHelper;

public class Splash extends Activity {
    MySQLiteHelper db;
    String Ingredients[];
    Food_TypeDB ftdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        db = new MySQLiteHelper(getApplicationContext());
        ftdb = new Food_TypeDB(getApplicationContext());

        Ingredients = getResources().getStringArray(R.array.Ingredients);
        for (int i = 1; i < Ingredients.length; i++) {
            ftdb.createFoodType(Ingredients[i]);
        }

        Thread splashTimer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }

        };
        splashTimer.start();

    }
}
