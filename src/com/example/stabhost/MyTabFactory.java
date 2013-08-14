package com.example.stabhost;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

public class MyTabFactory implements TabContentFactory {

    private final Context mContext;

    public MyTabFactory(Context context) {
		System.out.println(this.getClass().getSimpleName());
        mContext = context;
    }

    public View createTabContent(String tag) {
        View v = new View(mContext);
        v.setMinimumWidth(0);
        v.setMinimumHeight(0);
        return v;
    }
}