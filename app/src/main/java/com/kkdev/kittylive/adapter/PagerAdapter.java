package com.kkdev.kittylive.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.kkdev.kittylive.ui.fragment.FollowFragment;
import com.kkdev.kittylive.ui.fragment.GameFragment;
import com.kkdev.kittylive.ui.fragment.HotFragment;
import com.kkdev.kittylive.ui.fragment.NewFragment;

public class PagerAdapter extends FragmentStateAdapter {

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FollowFragment();
            case 1:
                return new HotFragment();
            case 2:
                return new NewFragment();
            default:
                return new GameFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
