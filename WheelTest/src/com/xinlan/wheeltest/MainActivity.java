package com.xinlan.wheeltest;

import com.xinlan.wheel.view.WheelView;
import com.xinlan.wheel.view.adapter.ArrayWheelAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends Activity
{
    private WheelView wheel;
    public static String months[] = new String[] {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wheel = (WheelView)findViewById(R.id.wheel);
        
        wheel.setViewAdapter(new DateArrayAdapter(this, months, 0));
        wheel.setCurrentItem(0);
    }
    
    
    /**
     * Adapter for string based wheel. Highlights the current value.
     */
    private class DateArrayAdapter extends ArrayWheelAdapter<String> {
        // Index of current item
        int currentItem;
        // Index of item to be highlighted
        int currentValue;
        
        /**
         * Constructor
         */
        public DateArrayAdapter(Context context, String[] items, int current) {
            super(context, items);
            this.currentValue = current;
            setTextSize(16);
        }
        
        @Override
        protected void configureTextView(TextView view) {
            super.configureTextView(view);
            view.setTypeface(Typeface.SANS_SERIF);
        }
        
        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            currentItem = index;
            return super.getItem(index, cachedView, parent);
        }
    }
}//end class
