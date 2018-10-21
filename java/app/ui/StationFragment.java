package app.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.R;

public class StationFragment extends Fragment {
    private static final String KEY_TIMES = "times";

    private static final String[] TITLES = new String[]{
            "去程(工作日)", "回程(工作日)", "去程(休息日)", "回程(休息日)"
    };

    private String[][] times;

    public StationFragment() {
    }

    public static StationFragment newInstance(String[][] times) {
        StationFragment fragment = new StationFragment();
        Bundle args = new Bundle();
        args.putSerializable(KEY_TIMES, times);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            times = (String[][]) getArguments().getSerializable(KEY_TIMES);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_station, container, false);

        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return TimesFragment.newInstance(times[position]);
            }

            @Override
            public int getCount() {
                return TITLES.length;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return TITLES[position];
            }
        });
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
