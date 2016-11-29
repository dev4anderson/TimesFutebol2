package com.example.andersonmacedo.timesfutebol.adapter;

import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.andersonmacedo.timesfutebol.R;
import com.example.andersonmacedo.timesfutebol.fragments.TimesFragment;

/**
 * Created by andersonmacedo on 27/11/16.
 */

public class TabsAdapter extends FragmentStatePagerAdapter {

    public static final int TOTAL_TABS = 1;

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    //Nesse método definimos qual fragment deverá ser exibido no ViewPager
    @Override
    public Fragment getItem(int position) {

        Bundle args = new Bundle();


        args.putString("tipo", "57c49ba10f00007111b50c00");


        Fragment f = new TimesFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public int getCount() {
        return TOTAL_TABS;
    }
}
