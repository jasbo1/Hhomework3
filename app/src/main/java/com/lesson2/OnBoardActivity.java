package com.lesson2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class OnBoardActivity extends AppCompatActivity {
    ViewPager viewPager;
 TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        viewPager=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tab_layout);
        SectionPagerAdapter adapter= new SectionPagerAdapter(getSupportFragmentManager());
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.setAdapter(adapter);


    }
        public  class SectionPagerAdapter extends FragmentStatePagerAdapter{


            public SectionPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int position) {
                BoardFragment fragment=new BoardFragment();
                Bundle bundle =new Bundle();
                bundle.putInt("pos",position);
                fragment.setArguments(bundle);
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;

            }


        }
}
