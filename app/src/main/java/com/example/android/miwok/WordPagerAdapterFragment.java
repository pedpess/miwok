package com.example.android.miwok;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class WordPagerAdapterFragment extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 4;
    private Context context;


    public WordPagerAdapterFragment(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NumbersFragment();
            case 1:
                return new FamilyMembersFragment();
            case 2:
                return new ColorsFragment();
            case 3:
                return new PhrasesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.category_numbers);
            case 1:
                return context.getString(R.string.category_family);
            case 2:
                return context.getString(R.string.category_colors);
            case 3:
                return context.getString(R.string.category_phrases);
            default:
                return null;
        }
    }
}
