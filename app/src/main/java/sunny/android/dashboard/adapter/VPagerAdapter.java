package sunny.android.dashboard.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import sunny.android.dashboard.R;

/**
 * Created by ctel-cpu-84 on 4/11/2017.
 */
public class VPagerAdapter extends android.support.v4.view.PagerAdapter {

    // Declare Variables
    static Context context;
    LayoutInflater inflater;
    String[] colors = {"CD5C5C", "F08080", "FA8072", "E9967A", "FFA07A", "008080"};
    int categoryIcons[] = {R.drawable.food_icon, R.drawable.grocery, R.drawable.fashion, R.drawable.fashion, R.drawable.pulse, R.drawable.mobile, R.drawable.mobile, R.drawable.study, R.drawable.jewellery, R.drawable.footwear};


    public VPagerAdapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    public float getPageWidth(int position) {
        return 1f;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        View itemView = null;
        try {

            ImageView imgflag;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.viewpager_item, container, false);

            // Locate the ImageView in viewpager_item.xml
            imgflag = (ImageView) itemView.findViewById(R.id.flag);


            //  imgflag.setImageResource(categoryIcons[position]);

            imgflag.setBackgroundColor(Color.parseColor("#" + colors[position]));

          /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                imgflag.setImageTintList(ColorStateList.valueOf(Color.parseColor("#" + colors[position])));
            }*/


            // Add viewpager_item.xml to ViewPager
            ((ViewPager) container).addView(itemView);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);
    }


}