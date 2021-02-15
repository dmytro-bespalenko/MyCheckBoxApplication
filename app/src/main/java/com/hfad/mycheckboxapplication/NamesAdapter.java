package com.hfad.mycheckboxapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.ViewHolder> {

    public final List<CheckNames> myNames;
    private final OnItemClickListener myListener;

    public NamesAdapter(List<CheckNames> names, OnItemClickListener listener) {
        myNames = names;
        myListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("Adapter", "onCreateViewHolder");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("Adapter", "onBindViewHolder " + position);
        holder.bind(myNames.get(position), myListener);
    }

    @Override
    public int getItemCount() {

        return myNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView countTextView;
        public CheckBox checkBox;

        public ViewHolder(View v) {
            super(v);
            nameTextView = itemView.findViewById(R.id.name);
            countTextView = itemView.findViewById(R.id.count);
            checkBox = itemView.findViewById(R.id.mCheckBox);
        }

        public void bind(final CheckNames item, final OnItemClickListener listener) {
            nameTextView.setText(item.getName());
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Log.d("TAG", "onCheckedChanged(CompoundButton buttonView, boolean isChecked)");
                    listener.onItemClicked(myNames.indexOf(item), isChecked);
                }
            });
            countTextView.setText(String.valueOf(item.getCount()));
            checkBox.setChecked(item.isChecked());
        }


    }
}
