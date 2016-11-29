package org.shop.mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.shop.mobile.R;
import org.shop.mobile.model.Product;
import org.shop.mobile.task.ImageTask;

import java.util.List;

public class ProductsListItemAdapter extends BaseAdapter {

    private Context context;

    private List<Product> products;

    public ProductsListItemAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }


    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
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
                    R.layout.products_list_item, null);
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.products_list_item_image);
        TextView productTypeName = (TextView) convertView.findViewById(R.id.products_list_item_product_type_name);
        TextView categoryName = (TextView) convertView.findViewById(R.id.products_list_item_category_name);
        TextView producerName = (TextView) convertView.findViewById(R.id.products_list_item_producer_name);
        TextView cost = (TextView) convertView.findViewById(R.id.products_list_item_cost);

        Product product = products.get(position);
        productTypeName.setText(product.getProductTypeName());
        categoryName.setText(product.getCategoryName());
        producerName.setText(product.getProducerName());
        cost.setText(product.getCost().toString());
        new ImageTask(image).execute(product.getImageUri());

        return convertView;
    }
}
