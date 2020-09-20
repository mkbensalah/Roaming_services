package com.example.user.servicett;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<Pays> paysList = null;
    private ArrayList<Pays> arraylist;

    public ListViewAdapter(Context context, List<Pays> animalNamesList) {
        mContext = context;
        this.paysList = paysList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Pays>();
        this.arraylist.addAll(paysList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return paysList.size();
    }

    @Override
    public Pays getItem(int position) {
        return paysList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_view_items, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(paysList.get(position).getPays());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        paysList.clear();
        if (charText.length() == 0) {
            paysList.addAll(arraylist);
        } else {
            for (Pays wp : arraylist) {
                if (wp.getPays().toLowerCase(Locale.getDefault()).contains(charText)) {
                    paysList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}