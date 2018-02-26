package com.malo.androiddev.LiseusePager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Malo on 26/02/2018.
 */

public class LiseusePagerAdapter extends FragmentStatePagerAdapter {
    // Constructeur
    public LiseusePagerAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position)
    {
        return new PageFragment();
    }
    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0:
                return "libellé 1";
            default:
                return "libellé 2";
        }
    }
    @Override
    public int getCount()
    {
        return 3;
    }

}
