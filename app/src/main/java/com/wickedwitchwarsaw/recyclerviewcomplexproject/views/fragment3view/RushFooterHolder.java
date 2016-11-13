package com.wickedwitchwarsaw.recyclerviewcomplexproject.views.fragment3view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZuZ on 2016-10-17.
 */
public class RushFooterHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.footer_rush_fragment_twitter)
    protected ImageView twitterImage;
    @BindView(R.id.footer_rush_fragment_faceBook)
    protected ImageView facebookImage;
    @BindView(R.id.footer_rush_fragment_Instagram)
    protected ImageView insgtagramImage;
    @BindView(R.id.footer_rush_fragment_snapChat)
    protected ImageView snapchatImage;


    public RushFooterHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);


        facebookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facebookIntent;
                //checks if user has facebook app installed on device -->
                try {
                    view.getContext().getPackageManager().getPackageInfo("com.facebook.katana", 0);
                    facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/1416816258610572"));
                    facebookIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    //if not installed - opens facebook through web browser
                    facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/akademiakodu/?fref=ts"));
                }
                view.getContext().startActivity(facebookIntent);
            }
        });

        twitterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent twitterIntent;
                try {
                    view.getContext().getPackageManager().getPackageInfo("com.twitter.android", 0);
                    twitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id" + "28454994"));
                    twitterIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    twitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/iamspecialized"));
                }
                view.getContext().startActivity(twitterIntent);
            }
        });

        snapchatImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent snapchatIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://snapchat.com/add/" + "djkhaled"));
                view.getContext().startActivity(snapchatIntent);
            }
        });

        insgtagramImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instagramIntent;
                try {
                    view.getContext().getPackageManager().getPackageInfo("com.instagram.android", 0);
                    instagramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_u/monsterenergy"));
                    instagramIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    instagramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/monsterenergy/?hl=en"));
                }
                view.getContext().startActivity(instagramIntent);
            }
        });
    }

    public void populate(Context context){
        Picasso.with(context).load(R.drawable.halloweensmily1)
                .into(facebookImage);

        Picasso.with(context).load(R.drawable.halloweensmily2)
                .into(twitterImage);

        Picasso.with(context).load(R.drawable.halloweensmily3)
                .into(snapchatImage);

        Picasso.with(context).load(R.drawable.halloweensmily4)
                .into(insgtagramImage);
    }
}
