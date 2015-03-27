
package com.jacksierkstra.booksapp.activities;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.jacksierkstra.booksapp.R;
import com.jacksierkstra.booksapp.fragments.BookAddFragment;
import com.jacksierkstra.booksapp.fragments.BookOverviewFragment;
import com.jacksierkstra.booksapp.fragments.FragmentConstants;
import com.jacksierkstra.booksapp.fragments.OnFragmentInteractionListener;
import com.jacksierkstra.booksapp.fragments.drawer.MenuContent;


public class MainActivity extends ActionBarActivity implements OnFragmentInteractionListener
{

    Toolbar mToolbar;
    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        setSupportActionBar(mToolbar);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        if(savedInstanceState == null) {
            onMenuItemSelected(FragmentConstants.ID_FRAGMENT_BOOK_OVERVIEW);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(Gravity.START|Gravity.LEFT)) {
            mDrawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onMenuItemSelected(int id) {

        android.support.v4.app.FragmentTransaction transaction;

        switch(id) {
            case MenuContent.VIEW_BOOKS :
                BookOverviewFragment bookOverviewFrag = (BookOverviewFragment)getSupportFragmentManager().findFragmentByTag(FragmentConstants.TAG_FRAGMENT_BOOK_OVERVIEW);
                transaction = getSupportFragmentManager().beginTransaction();
                if(bookOverviewFrag == null) {
                    BookOverviewFragment newFragment = new BookOverviewFragment();
                    transaction.replace(R.id.main_fragment_container, newFragment, FragmentConstants.TAG_FRAGMENT_BOOK_OVERVIEW);
                } else {
                    transaction.replace(R.id.main_fragment_container, bookOverviewFrag, FragmentConstants.TAG_FRAGMENT_BOOK_OVERVIEW);
                }
                mDrawerLayout.closeDrawers();
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case MenuContent.ADD_BOOK:
                BookAddFragment bookAddFrag = (BookAddFragment)getSupportFragmentManager().findFragmentByTag(FragmentConstants.TAG_FRAGMENT_BOOK_ADD);
                transaction = getSupportFragmentManager().beginTransaction();
                if(bookAddFrag == null) {
                    BookAddFragment newFragment = new BookAddFragment();
                    transaction.replace(R.id.main_fragment_container, newFragment, FragmentConstants.TAG_FRAGMENT_BOOK_ADD);
                } else {
                    transaction.replace(R.id.main_fragment_container, bookAddFrag, FragmentConstants.TAG_FRAGMENT_BOOK_ADD);
                }
                mDrawerLayout.closeDrawers();
                transaction.addToBackStack(null);
                transaction.commit();
                break;
        }

    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
