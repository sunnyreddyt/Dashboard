package sunny.android.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import sunny.android.dashboard.adapter.GridAdapter;
import sunny.android.dashboard.adapter.VPagerAdapter;
import sunny.android.dashboard.utils.AutoScrollViewPager;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecyclerView;
    AutoScrollViewPager autoScrollViewPager;
    LinearLayout sector_llDots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        categoryRecyclerView = (RecyclerView) findViewById(R.id.categoryRecyclerView);
        autoScrollViewPager = (AutoScrollViewPager) findViewById(R.id.imagesViewPager);
        sector_llDots = (LinearLayout) findViewById(R.id.sector_llDots);


        categoryRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        GridAdapter gridAdapter = new GridAdapter(MainActivity.this);
        categoryRecyclerView.setAdapter(gridAdapter);

        viewpager();


    }


    public void viewpager() {
        sector_llDots.removeAllViews();
        final VPagerAdapter vPagerAdapter = new VPagerAdapter(MainActivity.this);
        autoScrollViewPager.setAdapter(vPagerAdapter);
        autoScrollViewPager.startAutoScroll();
        autoScrollViewPager.getInterval();

        for (int in = 0; in < vPagerAdapter.getCount(); in++) {

            ImageButton imgDot = new ImageButton(MainActivity.this);
            imgDot.setTag(in);
            imgDot.setImageResource(R.drawable.dot_selector);
            imgDot.setBackgroundResource(0);
            imgDot.setPadding(6, 2, 6, 2);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 18);
            imgDot.setLayoutParams(params);
            if (in == 0)
                imgDot.setSelected(true);

            sector_llDots.addView(imgDot);

        }
        autoScrollViewPager.requestFocus();
        autoScrollViewPager.setFocusable(true);

        autoScrollViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int pos) {
                Log.e("", "Page Selected is ===> " + pos);
                for (int i = 0; i < vPagerAdapter.getCount(); i++) {
                    if (i != pos) {
                        ((ImageView) sector_llDots.findViewWithTag(i)).setSelected(false);
                    }
                }
                ((ImageView) sector_llDots.findViewWithTag(pos)).setSelected(true);

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);
    }
}
