package org.shop.mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.shop.mobile.R;
import org.shop.mobile.resource.ProducerResource;
import org.shop.mobile.task.ImageTask;

import java.util.List;

public class ProducersListItemAdapter extends BaseAdapter {

    private Context context;

    private List<ProducerResource> producers;

    public ProducersListItemAdapter(Context context, List<ProducerResource> producers) {
        this.context = context;
        this.producers = producers;
    }

    @Override
    public int getCount() {
        return producers.size();
    }

    @Override
    public Object getItem(int i) {
        return producers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = (View) inflater.inflate(
                    R.layout.producers_list_item, null);
        }

        TextView name = (TextView) convertView.findViewById(R.id.producers_list_item_name);
        ImageView image = (ImageView) convertView.findViewById(R.id.producers_list_item_image);
        TextView info = (TextView) convertView.findViewById(R.id.producers_list_item_info);

        ProducerResource producerResource = producers.get(position);
        name.setText(producerResource.getName());
        info.setText(producerResource.getInfo());
        new ImageTask(image).execute(producerResource.getImageUri());

        return convertView;
    }
}
