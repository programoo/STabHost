package com.example.stabhost;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class MainActivity extends FragmentActivity implements OnTabChangeListener,OnPageChangeListener {	
	
	private ViewPager mViewPager;
	private TabHost mTabHost;
	private MyPageAdapter pageAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println(this.getClass().getSimpleName());
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        // Tab Initialization
        initialiseTabHost();

        List<Fragment> fragments = getFragments();
        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(pageAdapter);
        mViewPager.setOnPageChangeListener(MainActivity.this);
        
	}

	private List<Fragment> getFragments(){
        List<Fragment> fList = new ArrayList<Fragment>();

        // TODO Put here your Fragments
        MySampleFragment f1 = MySampleFragment.newInstance("Sample Fragment 1");
        MySampleFragment f2 = MySampleFragment.newInstance("Sample Fragment 2");
        MySampleFragment f3 = MySampleFragment.newInstance("Sample Fragment 3");
        fList.add(f1);
        fList.add(f2);
        fList.add(f3);

        return fList;
    }
	
	private static void AddTab(MainActivity activity, TabHost tabHost, TabHost.TabSpec tabSpec) {
        tabSpec.setContent(new MyTabFactory(activity));
        tabHost.addTab(tabSpec);
    }
	
	private void initialiseTabHost() {
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();

        MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab1").setIndicator("Tab1"));
        MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab2").setIndicator("Tab2"));
        MainActivity.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab3").setIndicator("Tab3"));

        mTabHost.setOnTabChangedListener(this);
    }
	
	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
