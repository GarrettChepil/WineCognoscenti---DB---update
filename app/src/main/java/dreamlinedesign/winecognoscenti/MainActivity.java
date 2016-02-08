package dreamlinedesign.winecognoscenti;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import dreamlinedesign.winecognoscenti.adapters.DropDownCheckBox;
import dreamlinedesign.winecognoscenti.adapters.SingleListAdapter;

public class MainActivity extends AppCompatActivity {


    Context cont;
    /*private String[] Ingredients = {"", "Red Meat", "Cured Meat", "Pork", "Poultry", "Mollusk", "Fish(Incl. Raw)",
            "Lobster & Shellfish", "Soft Cheese & Cream", "Pungent Cheese", "Hard Cheese", "Alliums",
            "Green Vegetables", "Root Vegetables & Squash", "Nightshades", "Funghi", "Nuts & Seeds",
            "Beans & Peas", "Black Pepper", "Red Pepper", "Hot & Spicy", "Herbs", "Baking Spices",
            "Exotic & Aromatic Spices", "White Starches", "Whole Weat Grains", "Sweet Starchy Vegetables",
            "Potato", "Fruit & Berries", "Vanilla & Caramel", "Chocolate & Coffee"};*/
    private String[] Ingredients;
    /*private String[] subtext = {"", "beef, lamb, venison", "salami, proscuitto, bresaola, bacon",
            "roast, tenderloin, pork chop", "chicken, duck, turkey", "oyster, mussel, clam",
            "tuna, cod, trout, bass", "prawn, crab, langoustine", "Brie, mascarpone, creme fraiche",
            "bleu, Gorgonzola, Stilton, Rouguefort", "cheddar, Pecorina, Manchego, Asiago, Parmesan",
            "onion, shallot, garlic, scallion", "green bean, kale, lettuce",
            "turnip, butternut, pumpkin, delicata, carrot", "tomato, eggplant, bell pepper",
            "crimini, maitake, chanterelle", "peanut, almond, pecan, sesame", "lentil, navy, pinto, chickpea",
            "", "ancho, aleppo, chipotle, chili", "hot sauce, habanero, sichuan", "thyme, oregano, basil, tarragon",
            "cinnamon, clove, allspice, mace", "anise, turmeric, saffron, fennel, ginger", "flour, white rice, pasta, " +
            "bread, tortillas", "quinoa, farro, brown rice", "sweet potato, yucca, taro", "",
            "strawberry, orange, apple, peach", "creme brulee, ice cream", ""};*/
    private BestPairing best;

    MainActivity mainActivity;
    private String[] subtext;
    TextView title, txtmeat, txtCheese, tvProduce, tvHerbSpice,tvStarch, tvSweet, tvPrep;;
    Button btnMeat, btnCheese, btnProduce, btnHerbSpice,btnStarch, btnSweet, btnPrep;;
    Set<String> results = new HashSet<>();
    //EditText search;
    private String[] sprep = {"", "Grilled or BBQ", "Sauteed or Fried", "Smoked", "Roasted", "Poached or Steamed"};
    ArrayAdapter dataAdapter = null;
    ListView lstSearch;
    Set searchPos;
    String [] searcharray;
    public static Boolean [] checkmeat, checkCheese, checkProduce, checkHerbSpice,checkStarch, checkSweet, checkPrep;
    private PopupWindow pw;
    public DropDownCheckBox checkBoxMeat, checkBoxCheese, cbProduce, cbHerbSpice,cbStarch, cbSweet, cbPrep;
    public View layout1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BuildToolBar();

        layout1 = (View) findViewById(R.id.layoutmeat);
        View layout2 = (View) findViewById(R.id.layoutCheese);
        View layoutProduce  = (View) findViewById(R.id.layoutProduce);
        View layoutherb = (View) findViewById(R.id.layoutherbspice);
        View layoutstarch = (View) findViewById(R.id.layoutstarch);
        View layoutsweet = (View) findViewById(R.id.layoutsweet);
        View layoutprep = (View) findViewById(R.id.layoutprep);
        mainActivity= this;


        txtmeat = (TextView) layout1.findViewById(R.id.SelectBox);
        txtCheese = (TextView) layout2.findViewById(R.id.SelectBox);
        tvProduce = (TextView) layoutProduce.findViewById(R.id.SelectBox);
        tvHerbSpice = (TextView) layoutherb.findViewById(R.id.SelectBox);
        tvPrep = (TextView) layoutprep.findViewById(R.id.SelectBox);
        tvStarch = (TextView) layoutstarch.findViewById(R.id.SelectBox);
        tvSweet = (TextView) layoutsweet.findViewById(R.id.SelectBox);
        cont = this;

        btnMeat = (Button) layout1.findViewById(R.id.create);
        btnCheese = (Button) layout2.findViewById(R.id.create);
        btnProduce = (Button) layoutProduce.findViewById(R.id.create);
        btnHerbSpice = (Button) layoutherb.findViewById(R.id.create);
        btnStarch = (Button) layoutstarch.findViewById(R.id.create);
        btnSweet = (Button) layoutsweet.findViewById(R.id.create);
        btnPrep = (Button) layoutprep.findViewById(R.id.create);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Boolean[]> selected = new ArrayList<Boolean[]>();
                checkmeat = checkBoxMeat.getCheckSelected();
                checkCheese = checkBoxCheese.getCheckSelected();
                checkProduce = cbProduce.getCheckSelected();
                checkHerbSpice = cbHerbSpice.getCheckSelected();
                checkStarch = cbStarch.getCheckSelected();
                checkSweet = cbSweet.getCheckSelected();
                checkPrep = cbPrep.getCheckSelected();
                selected.add(checkmeat);
                selected.add(checkCheese);
                selected.add(checkProduce);
                selected.add(checkHerbSpice);
                selected.add(checkStarch);
                selected.add(checkSweet);
                selected.add(checkPrep);

                best = new BestPairing(selected);

                ((BestWineSelection) mainActivity.getApplication()).setBest(best);
                Intent intBestWine = new Intent();
                intBestWine.setClass(getApplicationContext(), BestWineActivity.class);
                startActivity(intBestWine);

            }
        });

        searchPos = new HashSet<>();

        Ingredients = getResources().getStringArray(R.array.Ingredients);
        subtext = getResources().getStringArray(R.array.Subtext);

        final ArrayList<String> meat = new ArrayList<String>();
        final ArrayList<String> cheese = new ArrayList<>();
        final ArrayList<String> produce = new ArrayList<>();
        final ArrayList<String> herbspice = new ArrayList<>();
        final ArrayList<String> starch = new ArrayList<>();
        final ArrayList<String> sweet = new ArrayList<>();
        final ArrayList<String> prep = new ArrayList<>();

        final ArrayList<String> meatsub = new ArrayList<String>();
        final ArrayList<String> cheesesub = new ArrayList<>();
        final ArrayList<String> producesub = new ArrayList<>();
        final ArrayList<String> herbspicesub = new ArrayList<>();
        final ArrayList<String> starchsub = new ArrayList<>();
        final ArrayList<String> sweetsub = new ArrayList<>();
        final ArrayList<String> prepsub = new ArrayList<>();

        for (int i = 1; i < Ingredients.length; i++) {
            if(i < 8) {
                meat.add(Ingredients[i]);
                meatsub.add(subtext[i]);
            }
            else if(i <= 10){
                cheese.add(Ingredients[i]);
                cheesesub.add(subtext[i]);
            }
            else if(i <=17) {
                produce.add(Ingredients[i]);
                producesub.add(subtext[i]);
            }
            else if (i <= 23) {
                herbspice.add(Ingredients[i]);
                herbspicesub.add(subtext[i]);
            }
            else if (i <= 27) {
                starch.add(Ingredients[i]);
                starchsub.add(subtext[i]);
            }
            else{
                sweet.add(Ingredients[i]);
                sweetsub.add(subtext[i]);
            }
        }
        for (int i = 1; i < sprep.length; i++) {
            prep.add(sprep[i]);
            prepsub.add("");
        }

        checkmeat = new Boolean[meat.size()];
        checkCheese = new Boolean[cheese.size()];
        checkProduce = new Boolean[produce.size()];
        checkHerbSpice = new Boolean[herbspice.size()];
        checkStarch = new Boolean[starch.size()];
        checkSweet = new Boolean[sweet.size()];
        checkPrep = new Boolean[prep.size()];

        for(int i = 0; i < checkmeat.length; i++)
            checkmeat[i] = false;

        for(int i = 0; i < checkCheese.length; i++)
            checkCheese[i] = false;

        for(int i = 0; i < checkProduce.length; i++)
            checkProduce[i] = false;

        for(int i = 0; i < checkHerbSpice.length; i++)
            checkHerbSpice[i] = false;
        for(int i = 0; i < checkStarch.length; i++)
            checkStarch[i] = false;

        for(int i = 0; i < checkSweet.length; i++)
            checkSweet[i] = false;
        for(int i = 0; i < checkPrep.length; i++)
            checkPrep[i] = false;

        txtmeat.setText(R.string.txtMeatName);
        txtCheese.setText(R.string.txtcheesename);
        tvProduce.setText(R.string.txtVegetableName);
        tvHerbSpice.setText(R.string.txtherbSpiceName);
        tvStarch.setText(R.string.txtStarchName);
        tvSweet.setText(R.string.txtSweetsName);
        tvPrep.setText(R.string.txtPrepName);

        //title = (TextView) findViewById(R.id.txttitle);



        /*LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout popup = (LinearLayout) inflater.inflate(R.layout.pop_up_window, (ViewGroup) findViewById(R.id.PopUpView));

        Button createButton = (Button) findViewById(R.id.create);*/

        //final ListView list = (ListView) popup.findViewById(R.id.dropDownList);
        checkBoxMeat = new DropDownCheckBox(cont,meat,meatsub,layout1,this);
        checkBoxCheese = new DropDownCheckBox(cont,cheese,cheesesub,layout2,this);
        cbProduce = new DropDownCheckBox(cont,produce,producesub,layoutProduce,this);
        cbHerbSpice = new DropDownCheckBox(cont,herbspice, herbspicesub,layoutherb,this);
        cbStarch = new DropDownCheckBox(cont,starch,starchsub,layoutstarch,this);
        cbSweet = new DropDownCheckBox(cont,sweet,sweetsub,layoutsweet,this);
        cbPrep = new DropDownCheckBox(cont,prep,prepsub,layoutprep,this);

        txtmeat.setOnClickListener(checkBoxMeat.returnTVOnclick());


        txtCheese.setOnClickListener(checkBoxCheese.returnTVOnclick());
        btnMeat.setOnClickListener(checkBoxMeat.returnbtnclik());
        btnCheese.setOnClickListener(checkBoxCheese.returnbtnclik());
        tvProduce.setOnClickListener(cbProduce.returnTVOnclick());
        btnProduce.setOnClickListener(cbProduce.returnbtnclik());
        tvHerbSpice.setOnClickListener(cbHerbSpice.returnTVOnclick());
        btnHerbSpice.setOnClickListener(cbHerbSpice.returnbtnclik());
        tvStarch.setOnClickListener(cbStarch.returnTVOnclick());
        btnStarch.setOnClickListener(cbStarch.returnbtnclik());
        tvSweet.setOnClickListener(cbSweet.returnTVOnclick());
        btnSweet.setOnClickListener(cbSweet.returnbtnclik());
        tvPrep.setOnClickListener(cbPrep.returnTVOnclick());
        btnPrep.setOnClickListener(cbPrep.returnbtnclik());



    }







        /*tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!expanded){
                    //display all selected values
                    String selected = "";
                    int flag = 0;
                    for (int i = 0; i < meat.size(); i++) {
                        if (checkSelected[i] == true) {
                            selected += meat.get(i);
                            selected += ", ";
                            flag = 1;
                        }
                    }
                    if(flag==1) {
                        tv.setText(selected);
                        expanded = true;
                    }
                }
                else{
                    //display shortened representation of selected values
                    tv.setText(DropDownListAdapter.getSelected());
                    expanded = false;
                }
            }
        });



            //btnSearch = (Button) findViewById(R.id.btnSearch);



    
    //onClickListener to initiate the dropDown list
    Button createButton = (Button)findViewById(R.id.create);
    createButton.setOnClickListener(new OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub

            View layout1 = (View)findViewById(R.id.layoutmeat);

            initiatePopUp(meat,tv, layout1);
        }


    });
}*/

    private void initiatePopUp(DropDownCheckBox ddcb) {
        LayoutInflater inflater = (LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //get the pop-up window i.e.  drop-down layout
        LinearLayout layout = ddcb.getPopup();

        //get the view to which drop-down layout is to be anchored
        pw = new PopupWindow(layout, ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        //Pop-up window background cannot be null if we want the pop-up to listen touch events outside its window
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.setTouchable(true);

        //let pop-up be informed about touch events outside its window. This  should be done before setting the content of pop-up
        pw.setOutsideTouchable(true);
        pw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        //dismiss the pop-up i.e. drop-down when touched anywhere outside the pop-up
        pw.setTouchInterceptor(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    pw.dismiss();
                    return true;
                }
                return false;
            }
        });

        //provide the source layout for drop-down
        pw.setContentView(layout);

        //anchor the drop-down to bottom-left corner of 'layout1'
        pw.showAsDropDown(ddcb.getLayout());
        final ListView list = ddcb.getList();
        //populate the drop-down list
        //ddcb.setAdapter(new DropDownListAdapter(this, ddcb.getItems(), ddcb.getTv(), ddcb.getCheckSelected()));
        list.setAdapter(ddcb.getAdapter());
    }




    public void reset(View v) {


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        MenuItem shareItem = menu.findItem(R.id.action_share);
        shareItem.setVisible(false);
        return true;
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
                        Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.action_search:
                        LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        View popupView = layoutInflater.inflate(R.layout.popup, null);
                        final PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT);

                        lstSearch = (ListView) popupView.findViewById(R.id.lstSearch);

                        final EditText search = (EditText) popupView.findViewById(R.id.edTxtSearch);
                        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                            @Override
                            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                                    String s = search.getText().toString();
                                    performSearch(s);
                                    // Assign adapter to ListView
                                    lstSearch.setAdapter(dataAdapter);
                                    return true;
                                }
                                return false;
                            }
                            private void performSearch(String search) {
                                results.clear();
                                for(int i = 0; i < Ingredients.length;i++) {
                                    if(Ingredients[i].toLowerCase().contains(search.toLowerCase())) {
                                        results.add(Ingredients[i]);
                                        System.out.println("ing" + i + " " + Ingredients[i]);

                                    }
                                    if(subtext[i].toLowerCase().contains(search.toLowerCase())){
                                        results.add(Ingredients[i]);
                                        System.out.println("sub" + i + " " + subtext[i]);

                                    }

                                }
                                searcharray = results.toArray(new String[results.size()]);
                                dataAdapter = new SingleListAdapter(cont, R.layout.double_custom_list, searcharray);



                            }

                        });

                        lstSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                int pos = 0;
                                String selected = lstSearch.getItemAtPosition(position).toString();
                                for(int i = 0; i < Ingredients.length; i++) {
                                    if(Ingredients[i].equals(selected)){
                                        pos = i;
                                        break;
                                    }
                                }

                                popupWindow.dismiss();
                            }
                        });

                        Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
                        btnDismiss.setOnClickListener(new Button.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                popupWindow.dismiss();
                            }
                        });

                        popupWindow.showAsDropDown(title, 150, 0);
                        popupWindow.setFocusable(true);
                        popupWindow.update();
                        return true;
                    case R.id.action_refresh:
                        return true;
                }



                return false;
            }
        });


    }

}
