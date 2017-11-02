package com.recycler.movieinfo.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.recycler.movieinfo.R;

/**
 * Created by Manu on 10/31/2017.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {
    public final TextView titleTV;
    public final TextView popularityTV;
    public final TextView releaseDateTV;
    public final SimpleDraweeView simpleDraweeView;
    public final LinearLayout itemLayout;

    public MovieViewHolder(View view) {
        super(view);
        titleTV = (TextView) view.findViewById(R.id.titleTV);
        popularityTV = (TextView) view.findViewById(R.id.popularityTV);
        releaseDateTV = (TextView) view.findViewById(R.id.releaseDateTV);
        simpleDraweeView = (SimpleDraweeView)view.findViewById(R.id.my_image_view);
        itemLayout = (LinearLayout)view.findViewById(R.id.movielistItemLayout);
    }
}