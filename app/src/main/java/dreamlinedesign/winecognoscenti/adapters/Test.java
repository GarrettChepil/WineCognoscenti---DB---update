package dreamlinedesign.winecognoscenti.adapters;

/**
 * Created by GeEEE on 2016-02-01.
 */

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import dreamlinedesign.winecognoscenti.R;


// Creating an Adapter Class
public class Test extends ArrayAdapter {
    String objects[];
    String subtext[];
    Context context;
    TextView text1,text2, customtext;
    View myView;

    public Test(Context context, int textViewResourceId,
                        String[] objects, String[] subtext) {
        super(context, textViewResourceId, objects);
        this.objects = objects;
        this.subtext = subtext;
        this.context =context;
    }

    public View getCustomView(int position, View convertView,
                              ViewGroup parent) {

// Inflating the layout for the custom Spinner

        myView = LayoutInflater.from(context).inflate(R.layout.single_custom_list, parent, false);



// Declaring and Typecasting the textview in the inflated layout
        customtext = (TextView) myView.findViewById(R.id.customText);

        customtext.setGravity(View.TEXT_ALIGNMENT_CENTER);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            customtext.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        }
// Setting the text using the array
        customtext.setText(objects[position]);


// Setting the color of the text
        customtext.setTextColor(Color.BLUE);
        customtext.setTextSize(20f);


// Declaring and Typecasting the imageView in the inflated layout
        //           ImageView img = (ImageView) layout.findViewById(R.id.imgLanguage);

// Setting an image using the id's in the array
//            img.setImageResource(images[position]);

// Setting Special atrributes for 1st element

        if ((position >=1) && (position <= 7)) {
            customtext.setTextColor(Color.parseColor("#C4F45555"));

        }
        else if ((position >=8) && (position <= 10) ) {
            customtext.setTextColor((Color.parseColor("#C8F0A44A")));

        }
        else if ((position >= 11)&& (position <= 17)) {
            customtext.setTextColor(Color.parseColor("#B47DBD49"));

        }
        else if ((position >= 18)&& (position <= 23)) {
            customtext.setTextColor(Color.parseColor("#C352AFFA"));

        }
        else if ((position >= 24) && (position <= 27)) {
            customtext.setTextColor(Color.parseColor("#D2FFB153"));

        }
        else if ((position >= 28) && (position <= 30)) {
            customtext.setTextColor(Color.parseColor("#C4F45555"));

        }
        return myView;
    }

    // It gets a View that displays in the drop down popup the data at the specified position
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        View myView = LayoutInflater.from(context).inflate(R.layout.double_custom_list, parent, false);
        // Declaring and Typecasting the textview in the inflated layout
        text1 = (TextView) myView.findViewById(R.id.text1);
        text2 = (TextView) myView.findViewById(R.id.text2);

        text1.setTextSize(20f);
        text2.setTextSize(12f);

        // Setting the text using the array
        text1.setText(objects[position]);
        text2.setText(subtext[position]);

        text1.setTextColor((Color.WHITE));
        text2.setTextColor((Color.WHITE));

        if ((position >=0) && (position <= 7)) {
            text1.setBackgroundColor(Color.parseColor("#C4F45555"));
            text2.setBackgroundColor(Color.parseColor("#C4F45555"));


        }
        else if ((position >=8) && (position <= 10) ) {
            text1.setBackgroundColor(Color.parseColor("#C8F0A44A"));
            text2.setBackgroundColor(Color.parseColor("#C8F0A44A"));

        }
        else if ((position >= 11)&& (position <= 17)) {
            text1.setBackgroundColor(Color.parseColor("#B47DBD49"));
            text2.setBackgroundColor(Color.parseColor("#B47DBD49"));

        }
        else if ((position >= 18)&& (position <= 23)) {
            text1.setBackgroundColor(Color.parseColor("#C352AFFA"));
            text2.setBackgroundColor(Color.parseColor("#C352AFFA"));


        }
        else if ((position >= 24) && (position <= 27)) {
            text1.setBackgroundColor(Color.parseColor("#D2FFB153"));
            text2.setBackgroundColor(Color.parseColor("#D2FFB153"));

        }
        else if ((position >= 28) && (position <= 30)) {
            text1.setBackgroundColor(Color.parseColor("#C4F45555"));
            text2.setBackgroundColor(Color.parseColor("#C4F45555"));


        }

        else  {
            text1.setBackgroundColor(Color.WHITE);
            text2.setBackgroundColor(Color.WHITE);


        }





// Declaring and Typecasting the imageView in the inflated layout
        //           ImageView img = (ImageView) layout.findViewById(R.id.imgLanguage);

// Setting an image using the id's in the array
//            img.setImageResource(images[position]);

// Setting Special atrributes for 1st element
        if (position == 0) {
// Removing the image view
            //               img.setVisibility(View.GONE);
// Setting the size of the text
            text1.setTextSize(20f);
            text2.setTextSize(10f);
// Setting the text Color



        }

        return myView;
    }

    // It gets a View that displays the data at the specified position
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
}

