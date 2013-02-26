package de.cketti.holocolorpicker.demo;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import android.os.Bundle;


public class MainActivity extends SherlockFragmentActivity {
    private static final String STATE_SELECTED_TAB = "selected_tab";

    private static final String FRAGMENT_TAG_SIMPLE = "simple";
    private static final String FRAGMENT_TAG_ADVANCED = "advanced";
    private static final String FRAGMENT_TAG_CUSTOMIZED = "customized";
    private static final String FRAGMENT_TAG_ABOUT = "about";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        Tab tab = actionBar.newTab()
                .setText(getString(R.string.tab_simple))
                .setTabListener(new TabListener<SimpleColorPickerFragment>(
                        this, FRAGMENT_TAG_SIMPLE, SimpleColorPickerFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText(getString(R.string.tab_advanced))
                .setTabListener(new TabListener<AdvancedColorPickerFragment>(
                        this, FRAGMENT_TAG_ADVANCED, AdvancedColorPickerFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText(getString(R.string.tab_customized))
                .setTabListener(new TabListener<CustomizedColorPickerFragment>(
                        this, FRAGMENT_TAG_CUSTOMIZED, CustomizedColorPickerFragment.class));
        actionBar.addTab(tab);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(STATE_SELECTED_TAB, getSupportActionBar().getSelectedNavigationIndex());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        int selectedTab = savedInstanceState.getInt(STATE_SELECTED_TAB);
        getSupportActionBar().setSelectedNavigationItem(selectedTab);

        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about: {
                new AboutDialogFragment().show(getSupportFragmentManager(), FRAGMENT_TAG_ABOUT);
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }
}
