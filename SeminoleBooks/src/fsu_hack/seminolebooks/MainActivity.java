package fsu_hack.seminolebooks;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// setup action bar for tabs
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        Tab pantryTab = actionBar.newTab().setText("Tab 1").setTabListener(new TabListener<BuyFragment>(this, "Buy", BuyFragment.class));
        actionBar.addTab(pantryTab);

        Tab shoppingListTab = actionBar.newTab().setText("Tab 2").setTabListener(new TabListener<SellFragment>(this, "Sell", SellFragment.class));
        actionBar.addTab(shoppingListTab);
        actionBar.setSelectedNavigationItem(1);
        actionBar.setSelectedNavigationItem(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
