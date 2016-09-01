package hr.heureka.memento;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.tabs)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewPager;

    private int[] imageResIds = {
            R.mipmap.ic_assigments,
            R.mipmap.ic_assigments_done,
            R.mipmap.ic_news
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // aktivacija ButterKnife biblioteke
        ButterKnife.bind(this);
        // dohvatiti viewPager (primjer: bez korištenja ButterKnife biblioteke)
        setupViewPager(viewPager);
        // uvijek učitaj 3 taba
        viewPager.setOffscreenPageLimit(3);
        // postavi straničenje
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(imageResIds[0]);
        tabLayout.getTabAt(1).setIcon(imageResIds[1]);
        tabLayout.getTabAt(2).setIcon(imageResIds[2]);
    }

    private void setupViewPager(final ViewPager viewPager) {
    }
}
