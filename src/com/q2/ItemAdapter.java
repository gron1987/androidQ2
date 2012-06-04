package com.q2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gron
 * Date: 6/4/12
 * Time: 3:57 PM
 */
public class ItemAdapter extends BaseAdapter {
    private Context mContext;
    private List<ListItem> mItems;

    public ItemAdapter(Context context, List<ListItem> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_layout, null);
        }
        TextView tv1 = (TextView) convertView.findViewById(R.id.text1);
        TextView tv2 = (TextView) convertView.findViewById(R.id.text2);
        tv1.setText(mItems.get(position).getText1());
        tv2.setText(mItems.get(position).getText2());
        return convertView;
    }
}
