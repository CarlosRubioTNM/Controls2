package edu.itch2.ej225h8.controls2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DescriptionAdapter extends RecyclerView.Adapter<DescriptionAdapter.DescViewHolder>{

    ArrayList<Description> list;

    public DescriptionAdapter(ArrayList<Description> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DescViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.desc_pager_layout, parent,false);

        DescriptionAdapter.DescViewHolder viewHolder = new DescriptionAdapter.DescViewHolder(layoutView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull DescViewHolder holder, int position) {
        Description currentItem = list.get(position);

        TextView descriptionTextView = holder.lblPagerDescription;
        descriptionTextView.setText(currentItem.getDesc());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    class DescViewHolder extends RecyclerView.ViewHolder {
        public TextView lblPagerDescription;

        public DescViewHolder(@NonNull View itemView) {
            super(itemView);
            lblPagerDescription = itemView.findViewById(R.id.lblPagerDescription);
        }
    }
}
