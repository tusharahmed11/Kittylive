package com.kkdev.kittylive.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.kkdev.kittylive.R;
import com.kkdev.kittylive.model.DashboardItem;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<DashboardItem> dashboardItemList(){
        List<DashboardItem> dashboardItemList = new ArrayList<>();
        dashboardItemList.add(new DashboardItem(R.drawable.fire,"Supreme",R.drawable.user,"MessyGirl","Welcome",268,0));
        dashboardItemList.add(new DashboardItem(R.drawable.fire,"Supreme",R.drawable.user,"MessyGirl","Welcome",268,0));
        dashboardItemList.add(new DashboardItem(R.drawable.crown,"Hourly",R.drawable.user2,"MessyGirl2","I am Waiting",168,1));
        dashboardItemList.add(new DashboardItem(R.drawable.crown,"Hourly",R.drawable.user2,"MessyGirl2","I am Waiting",168,1));
        dashboardItemList.add(new DashboardItem(R.drawable.fire,"Supreme",R.drawable.user,"MessyGirl","Welcome",268,0));
        dashboardItemList.add(new DashboardItem(R.drawable.crown,"Hourly",R.drawable.user2,"MessyGirl2","I am Waiting",168,1));

/*
        dashboardItemList.add(new DashboardItem(R.drawable.salarygrey300,"SALARY",9));
*/
        return dashboardItemList;
    }

    public static List<DashboardItem> dashboardItemList2(){
        List<DashboardItem> dashboardItemList = new ArrayList<>();
        dashboardItemList.add(new DashboardItem(R.drawable.fire,"Supreme",R.drawable.user,"MessyGirl","Welcome",268,0));
        dashboardItemList.add(new DashboardItem(R.drawable.fire,"Supreme",R.drawable.user,"MessyGirl","Welcome",268,0));
        dashboardItemList.add(new DashboardItem(R.drawable.crown,"Hourly",R.drawable.user2,"MessyGirl2","I am Waiting",168,1));
        dashboardItemList.add(new DashboardItem(R.drawable.crown,"Hourly",R.drawable.user2,"MessyGirl2","I am Waiting",168,1));

/*
        dashboardItemList.add(new DashboardItem(R.drawable.salarygrey300,"SALARY",9));
*/
        return dashboardItemList;
    }
    public static int typeIcon(int typeId){
        if (typeId == 0){
            return R.drawable.fire;
        }else {
            return R.drawable.crown;
        }
    }
    public static String followers(int followers){
        return String.valueOf(followers);
    }

    @BindingAdapter({"loadImage"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}
