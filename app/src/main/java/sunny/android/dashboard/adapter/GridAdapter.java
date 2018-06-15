package sunny.android.dashboard.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sunny.android.dashboard.R;


/**
 * Created by ctel-cpu-84 on 2/8/2018.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder> {

    private Context mContext;
    String[] categories = {"FOOD", "HOME NEEDS", "FASHION", "LIFE STYLE", "HEALTH", "MOBILES", "SALOON", "STUDY", "JEWELLERY", "FOOTWEAR"};
    int categoryIcons[] = {R.drawable.food_icon, R.drawable.grocery, R.drawable.fashion, R.drawable.fashion, R.drawable.pulse, R.drawable.mobile, R.drawable.mobile, R.drawable.study, R.drawable.jewellery, R.drawable.footwear};
    String[] colors = {"23535b", "8B0000", "C71585", "663399", "4B0082", "808000", "8B4513", "2F4F4F", "8B795E", "8B4C39", "AA00FF", "1A237E", "1A237E", "4B0082", "8B795E"};


    public GridAdapter(Context mContext) {

        this.mContext = mContext;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView categoryOneTextView;
        ImageView categoryImageView;
        LinearLayout gridLayout;

        public MyViewHolder(View view) {
            super(view);
            categoryOneTextView = (TextView) itemView.findViewById(R.id.categoryOneTextView);
            categoryImageView = (ImageView) itemView.findViewById(R.id.categoryImageView);
            gridLayout = (LinearLayout) itemView.findViewById(R.id.gridLayout);
        }
    }


    @Override
    public GridAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_list_item, parent, false);

        return new GridAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final GridAdapter.MyViewHolder holder, final int position) {

        try {


            holder.categoryOneTextView.setText(categories[position]);
            holder.categoryImageView.setImageResource(categoryIcons[position]);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.categoryImageView.setImageTintList(ColorStateList.valueOf(Color.parseColor("#" + colors[position])));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return categories.length;
    }

}