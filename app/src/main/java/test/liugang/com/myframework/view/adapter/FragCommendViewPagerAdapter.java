package test.liugang.com.myframework.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description:
 * @ Date:2017/7/22
 * @ Author:刘刚
 */

public class FragCommendViewPagerAdapter extends FragmentPagerAdapter {

    private List<String>slist=new ArrayList<>();
    private List<Fragment>flist=new ArrayList<>();

    public FragCommendViewPagerAdapter(FragmentManager fm, List<Fragment> flist, List<String> slist) {
        super(fm);
        this.flist = flist;
        this.slist = slist;
    }
    public FragCommendViewPagerAdapter(FragmentManager fm, List<String> slist) {
        super(fm);
        this.slist = slist;
    }


    @Override
    public Fragment getItem(int i) {

       Fragment commend = flist.get(i);
        //FragCommend_focus commend = new FragCommend_focus();

        return commend;
    }

    @Override
    public int getCount() {
        return slist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return slist.get(position);
    }
}