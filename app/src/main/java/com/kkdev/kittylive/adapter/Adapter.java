package com.kkdev.kittylive.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kkdev.kittylive.BR;
import com.kkdev.kittylive.databinding.ItemListBinding;
import com.kkdev.kittylive.model.DashboardItem;
import com.kkdev.kittylive.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private List<DashboardItem> itemList;

    public Adapter(Context context, List<DashboardItem> dashboardItems){
        this.context = context;
        this.itemList = dashboardItems;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.item_list,parent,false);

        ItemListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_list,parent,false
        );

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       DashboardItem item = itemList.get(position);
       holder.bind(item);
      /* holder.itemImage.setImageResource(item.getImage());
       holder.typeIcon.setImageResource(item.getTypeIconId());
       holder.typeTitle.setText(item.getTypeTitle());
       holder.name.setText(item.getName());
       holder.followers.setText(String.valueOf(item.getFollowers()));
       holder.title.setText(item.getTitle());

       if (item.getType() == 0){
           holder.typeLayout.setBackgroundResource(R.drawable.gradient2);
       }else {
           holder.typeLayout.setBackgroundResource(R.drawable.gradient);
       }
*/
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ItemListBinding itemListBinding;
        /*private ImageView itemImage;
        private TextView typeTitle;
        private ImageView typeIcon;
        private TextView name;
        private TextView followers;
        private TextView title;
        private LinearLayout typeLayout;*/

        public ViewHolder(ItemListBinding itemListBinding) {
            super(itemListBinding.getRoot());
            this.itemListBinding = itemListBinding;
           /* itemImage = itemView.findViewById(R.id.itemImage);
            typeTitle = itemView.findViewById(R.id.typeText);
            typeIcon = itemView.findViewById(R.id.typeIcon);
            name = itemView.findViewById(R.id.name);
            followers = itemView.findViewById(R.id.followers);
            title = itemView.findViewById(R.id.title);
            typeLayout = itemView.findViewById(R.id.typeLayout);*/
        }
        void bind(DashboardItem item){
            itemListBinding.setItem(item);
            itemListBinding.executePendingBindings();
        }
    }


}
