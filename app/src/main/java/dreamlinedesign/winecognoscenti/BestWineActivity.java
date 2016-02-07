package dreamlinedesign.winecognoscenti;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import dreamlinedesign.winecognoscenti.adapters.WineListAdapter;

public class BestWineActivity extends AppCompatActivity {

    FindBest best;
    Map<Integer, Integer> topSelection;
    Map <Integer, Integer> Second;
    TextView besttxt, txtBest2, txtBest3;
    TextView secondtxt;
    ListView best1,best2,best3;
    WineListAdapter arrbest1;
    List<String[]> wineslist;
    List<String> bestwine;
    String sharetxt;
    ShareActionProvider myShareActionProvider;
    private ShareActionProvider mShareActionProvider;

    String[] wines0 = {"Malbec", "Syah/Shiraz", "Mourvedre", "Pinotage", "Petite Sirah", "Touriga Nacional",
            "Cabernet Sauvignon", "Bordeaux Blend", "Meritage"};
    String[] wines1 = {"Merlot", "Sangiovese", "Zinfandel", "Cabernet Franc", "Tempranillo",
            "Nebbiolo", "Barbera", "Cotes du Rhona Blend"};
    String[] wines2 = {"Pinot Noir", "Grenache", "Gamay", "St. Laurent", "Carignan", "Counoise"};
    String[] wines3 = {"Provencia Rose", "White Zinfandel", "Loire Valley Rose", "Pinot Noir Rose",
            "Syrah Rose", "Garnacha Rosado", "Bandol Rose", "Tempranillo Rose", "Saignee Method Rose"};
    String[] wines4 = {"Chardonnay", "Samillon", "Viognier", "Marsanne", "Roussanne"};
    String[] wines5 = {"Sauvignon Blanc", "Albarino", "Pinot Blanc", "Vermentino", "Melon de Bourgogne",
            "Gargenega", "Trebbiano", "pinot Gris / Pinot Grigio"};
    String[] wines6 = {"Champagne", "Prosecco", "Cremant", "Cava", "Metodo Classico", "Sparkling Wine", "Sparkling Rose"};
    String[] wines7 = {"Moscato", "Riesling", "Chenin Blanc", "Gewurtraminer", "Late Harvest Whites", "Aisacian Pinot Gris"};
    String[] wines8 = {"Port", "Sherry", "Madeira", "Vin Santo", "Muscat", "Pedro Ximenez" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_wine);
        BuildToolBar();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        besttxt = (TextView) findViewById(R.id.txtBest);
        txtBest2 = (TextView) findViewById(R.id.txtBest2);
        txtBest3 = (TextView) findViewById(R.id.txtBest3);
        secondtxt=(TextView) findViewById(R.id.txtSeond);
        best1 = (ListView) findViewById(R.id.lstBest1);
        best2 = (ListView) findViewById(R.id.lstBest2);
        best3 = (ListView) findViewById(R.id.LstBest3);

        wineslist = new ArrayList<>();

        bestwine = new ArrayList<>();

        best = ((BestWineSelection) this.getApplication()).getBest();

        topSelection = best.getTopSelection();


        int highest = (Collections.max(topSelection.values()));
        String second = "";
        sharetxt = "";
        for (Map.Entry<Integer, Integer> entry : topSelection.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==highest) {
                bestwine.add(best.getWineName(entry.getKey()));
                wineslist.add(returnListwin(entry.getKey()));
                sharetxt += best.getWineName(entry.getKey()) + ", ";
            }
            else
                second += best.getWineName(entry.getKey()) + ", ";
        }
        System.out.println(highest + "\n k  " + bestwine.size());

        if (sharetxt.length() > 3) {
            String fixedsec = sharetxt.substring(0, sharetxt.length() - 2);
            sharetxt = fixedsec;
        }
        if (second.length() > 3) {
            String fixedsec = second.substring(0, second.length() - 2);
            secondtxt.setText(fixedsec);
        }

        System.out.println(wineslist.size());
        if(wineslist.size() == 1) {
            besttxt.setText(bestwine.get(0));
            txtBest2.setText("");
            txtBest3.setText("");

            best1.setVisibility(View.VISIBLE);
            best2.setVisibility(View.INVISIBLE);
            best3.setVisibility(View.INVISIBLE);

            best1.setFooterDividersEnabled(false);
            best1.setAdapter(new WineListAdapter(this, R.layout.winlist, wineslist.get(0)));
        }
        else if (wineslist.size() == 2) {
            besttxt.setText("");
            txtBest2.setText(bestwine.get(0));
            txtBest3.setText(bestwine.get(1));

            best1.setVisibility(View.INVISIBLE);
            best2.setVisibility(View.VISIBLE);
            best3.setVisibility(View.VISIBLE);


            best2.setAdapter(new WineListAdapter(this, R.layout.winlist, wineslist.get(0)));
            best3.setAdapter(new WineListAdapter(this, R.layout.winlist, wineslist.get(1)));

        }
        else {


            besttxt.setText(bestwine.get(1));
            txtBest2.setText(bestwine.get(0));
            txtBest3.setText(bestwine.get(2));
            besttxt.setTextSize(20);
            txtBest2.setTextSize(20);
            txtBest3.setTextSize(20);

            best1.setVisibility(View.VISIBLE);
            best2.setVisibility(View.VISIBLE);
            best3.setVisibility(View.VISIBLE);

            best2.setPadding(-150, 0, 0, 0);
            best3.setPadding(0,0,-150,0);

            best1.setMinimumWidth(140);
            best2.setMinimumWidth(140);
            best3.setMinimumWidth(140);

            best1.setAdapter(new WineListAdapter(this, R.layout.winlist, wineslist.get(1)));
            best2.setAdapter(new WineListAdapter(this, R.layout.winlist, wineslist.get(0)));
            best3.setAdapter(new WineListAdapter(this, R.layout.winlist, wineslist.get(2)));


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        MenuItem shareItem = menu.findItem(R.id.action_share);

        // Fetch and store ShareActionProvider
         myShareActionProvider =
                (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

        Intent myShareIntent = new Intent(Intent.ACTION_SEND);
        myShareIntent.setType("text/plain");
        myShareIntent.putExtra(Intent.EXTRA_TEXT, "Best Wine Choice is " + sharetxt);
        myShareActionProvider.setShareIntent(myShareIntent);
        menu.getItem(0).setVisible(false);
        return true;
    }

    // Call to update the share intent
    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                mShareActionProvider.setShareIntent(shareIntent);
            }
        }
    }




    public  void BuildToolBar() {
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.menu);
        setSupportActionBar(toolbar);



        //Title and subtitle


        //Menu
        toolbar.inflateMenu(R.menu.toolbar_menu);



        toolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.action_share:


                        return true;

                    case R.id.action_refresh:
                        return true;
                }
                return false;
            }
        });
    }

    private String[] returnListwin(int i) {
        switch(i) {
            case 0:
                return wines0;
            case 1:
                return wines1;
            case 2:
                return wines2;
            case 3:
                return wines3;
            case 4:
                return wines4;
            case 5:
                return wines5;
            case 6:
                return wines6;
            case 7:
                return wines7;
            default:
                return wines8;
        }
    }
}
