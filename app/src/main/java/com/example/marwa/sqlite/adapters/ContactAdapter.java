package com.example.marwa.sqlite.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.marwa.sqlite.R;
import com.example.marwa.sqlite.model.Contact;

import java.util.List;

/**
 * Created by Marwa on 6/9/2016.
 */
public class ContactAdapter extends BaseAdapter {
    Context context ;
    List<Contact> contactList;
    public ContactAdapter(Context context , List<Contact> contactList){
        this.contactList = contactList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Contact getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.contact_row, parent, false);
            convertView.setTag(holder);
            holder = new ViewHolder(convertView);

        }else{

            holder = (ViewHolder) convertView.getTag();
        }

        Contact item = getItem(position);
        holder.nameView.setText(item.getName());
        holder.phoneView.setText(item.getPhone());

        return convertView;
    }


    class ViewHolder{
        TextView nameView;
        TextView phoneView;

        ViewHolder(View v){
            nameView = (TextView) v.findViewById(R.id.textView);
            phoneView = (TextView) v.findViewById(R.id.textView2);

        }
    }
}
