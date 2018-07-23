package com.example.sankeerthiv.firstapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

public class ExpandablesListAdaptar extends BaseExpandableListAdapter {
    public List<String> getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(List<String> totalItems) {
        this.totalItems = totalItems;
    }

    public List<List<String>> getTotalChildItems() {
        return totalChildItems;
    }

    public void setTotalChildItems(List<List<String>> totalChildItems) {
        this.totalChildItems = totalChildItems;
    }
    private Context context;
    private List<String> totalItems;
    private List<List<String>> totalChildItems;
    @Override
    public int getGroupCount() {
        return totalItems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        Log.v("CHILD",totalChildItems.size()+"");
        return totalChildItems.size();

    }

    @Override
    public Object getGroup(int groupPosition) {
        return totalItems.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
            Log.v("CHILDITEM",totalChildItems.get(groupPosition).get(childPosition));
        return totalChildItems.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        context = parent.getContext();
        String title = (String)getGroup(groupPosition);
        View view = LayoutInflater.from(context).inflate(R.layout.expandables_list_items,parent,false);
        TextView listItems =(TextView)view.findViewById(R.id.tv_expandables_list_item);
        listItems.setText(title);
        return view;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child = (String)getChild(groupPosition,childPosition);
        View view = LayoutInflater.from(context).inflate(R.layout.expandable_child_items,parent,false);
        TextView childItems = (TextView)view.findViewById(R.id.tv_expandables_list_item_child);
        childItems.setText(child);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
