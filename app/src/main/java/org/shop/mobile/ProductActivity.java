package org.shop.mobile;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.shop.mobile.adapter.ProductsListItemAdapter;
import org.shop.mobile.manager.ProductManager;
import org.shop.mobile.model.Product;
import org.shop.mobile.task.ImageTask;

import java.util.List;

public class ProductActivity extends AppCompatActivity {

    public static final String EXTRA_PRODUCT_ID = "PRODUCT_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Intent intent = getIntent();
        Long id = intent.getLongExtra(EXTRA_PRODUCT_ID, 0);

        new ProductTask().execute(id);
    }

    private class ProductTask extends AsyncTask<Long, Void, Product> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Product doInBackground(Long... params) {
            return ProductManager.getById(params[0]);
        }

        @Override
        protected void onPostExecute(Product product) {
            if(product == null) {
                Toast.makeText(ProductActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
            else {
                ImageView image = (ImageView) findViewById(R.id.product_image);
                TextView productTypeName = (TextView) findViewById(R.id.product_type_name);
                TextView categoryName = (TextView) findViewById(R.id.product_category_name);
                TextView producerName = (TextView) findViewById(R.id.product_producer_name);
                TextView cost = (TextView) findViewById(R.id.product_cost);
                TextView info = (TextView) findViewById(R.id.product_info);

                productTypeName.setText("Тип: " + product.getProductTypeName());
                categoryName.setText(("Категорія: " + product.getCategoryName()));
                producerName.setText("Виробник: " + product.getProducerName());
                cost.setText("Ціна: " + product.getCost() + " грн");
                info.setText(product.getInfo());
                new ImageTask(image).execute(product.getImageUri());
            }
        }
    }
}
