package app.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import app.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final String[] MING_GU_GONG[] = new String[][]{new String[]{
            "07:00", "07:15", "07:30", "07:45", "08:15", "08:45", "09:15",
            "10:15", "11:15", "12:15", "13:15", "14:15", "15:15", "16:15",
            "17:15", "18:15", "19:15"
    }, new String[]{
            "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00",
            "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"
    }, new String[]{
            "07:00", "07:15", "07:30", "07:45", "08:15", "08:45", "09:15",
            "10:15", "11:15", "12:15", "13:15", "14:15", "15:15", "16:15",
            "17:15", "18:15", "19:15"
    }, new String[]{
            "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00",
            "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"
    }};

    private final String[] SHENG_TAI_LU[] = new String[][]{new String[]{
            "12:00", "15:40"
    }, new String[]{
            "09:00", "13:00"
    }, new String[]{
            "12:00", "15:40"
    }, new String[]{
            "09:00", "13:00"
    }};

    private final String[] MA_QUN[] = new String[][]{new String[]{
            "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "11:00",
            "13:00", "15:00", "17:00", "17:30", "18:00", "19:00", "20:00"
    }, new String[]{
            "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "11:30",
            "13:30", "15:30", "17:30", "18:00", "18:30", "19:30", "20:30"
    }, new String[]{
            "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "11:00",
            "13:00", "15:00", "17:00", "17:30", "18:00", "19:00", "20:00"
    }, new String[]{
            "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "11:30",
            "13:30", "15:30", "17:30", "18:00", "18:30", "19:30", "20:30"
    }};

    private final String[] MAI_GAO_QIAO[] = new String[][]{new String[]{
            "12:30", "17:00"
    }, new String[]{
            "09:00", "14:00"
    }, new String[]{
            "12:30", "17:00"
    }, new String[]{
            "09:00", "14:00"
    }};

    private final String[] MU_XU_YUAN[] = new String[][]{new String[]{
            "12:30", "17:00"
    }, new String[]{
            "9:00", "14:00"
    }, new String[]{
            "12:30", "17:00"
    }, new String[]{
            "9:00", "14:00"
    }};

    private final String[] JING_TIAN_LU[] = new String[][]{new String[]{
            "10:00", "11:00", "12:00", "15:00", "16:00", "17:00"
    }, new String[]{
            "09:00", "10:00", "11:00", "14:00", "15:00", "16:00"
    }, new String[]{
            "10:00", "11:00", "12:00", "15:00", "16:00", "17:00"
    }, new String[]{
            "09:00", "10:00", "11:00", "14:00", "15:00", "16:00"
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_minggugong);
        navigationView.getMenu().performIdentifierAction(R.id.nav_minggugong, 0);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setTitle(menuItem.getTitle());

        Fragment fragment;
        switch (menuItem.getItemId()) {
            case R.id.nav_minggugong:
                toolbar.setSubtitle("明故宫北门停车场");
                fragment = StationFragment.newInstance(MING_GU_GONG);
                break;
            case R.id.nav_shengtailu:
                toolbar.setSubtitle("双龙大道同曦明城苏宁电器门口");
                fragment = StationFragment.newInstance(SHENG_TAI_LU);
                break;
            case R.id.nav_maqun:
                toolbar.setSubtitle("马群大转盘钟山学院公交站");
                fragment = StationFragment.newInstance(MA_QUN);
                break;
            case R.id.nav_maigaoqiao:
                toolbar.setSubtitle("加油站对面");
                fragment = StationFragment.newInstance(MAI_GAO_QIAO);
                break;
            case R.id.nav_muxuyuan:
                toolbar.setSubtitle("南京银行门口");
                fragment = StationFragment.newInstance(MU_XU_YUAN);
                break;
            case R.id.nav_jingtianlu:
                toolbar.setSubtitle("经天路地铁口1号线出口");
                fragment = StationFragment.newInstance(JING_TIAN_LU);
                break;
            case R.id.nav_checkin_tips:
            default:
                toolbar.setSubtitle(null);
                fragment = CheckinTipsFragment.newInstance();
                break;
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
