package org.shop.mobile;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.shop.mobile.adapter.ProducersListItemAdapter;
import org.shop.mobile.adapter.ProductsListItemAdapter;
import org.shop.mobile.manager.ProducerManager;
import org.shop.mobile.manager.ProductManager;
import org.shop.mobile.model.Product;
import org.shop.mobile.resource.ProducerResource;

import java.util.List;

public class ProductsActivity extends ListActivity {

    private List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new ProductsActivity.ProductsTask().execute();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(ProductsActivity.this, ProductActivity.class);
        intent.putExtra(ProductActivity.EXTRA_PRODUCT_ID, id);
        startActivity(intent);
    }

    private class ProductsTask extends AsyncTask<Void, Void, List<Product>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Product> doInBackground(Void... voids) {
            return ProductManager.getList();
        }

        @Override
        protected void onPostExecute(List<Product> products) {
            if(products == null || products.isEmpty()) {
                Toast.makeText(ProductsActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
            else {
                ProductsActivity.this.products = products;

                ProductsListItemAdapter adapter = new ProductsListItemAdapter(ProductsActivity.this, products);

                ListView listView = getListView();
                listView.setAdapter(adapter);
            }
            ListView listView = getListView();
        }
    }
}
