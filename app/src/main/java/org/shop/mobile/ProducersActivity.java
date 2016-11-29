package org.shop.mobile;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.shop.mobile.adapter.ProducersListItemAdapter;
import org.shop.mobile.manager.ProducerManager;
import org.shop.mobile.resource.ProducerResource;

import java.util.List;

public class ProducersActivity extends ListActivity {

    protected List<ProducerResource> producers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new ProducersTask().execute();
    }

    private class ProducersTask extends AsyncTask<Void, Void, List<ProducerResource>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<ProducerResource> doInBackground(Void... voids) {
            return ProducerManager.getList();
        }

        @Override
        protected void onPostExecute(List<ProducerResource> producers) {
            if(producers == null || producers.isEmpty()) {
                Toast.makeText(ProducersActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
            else {
                ProducersActivity.this.producers = producers;

                ProducersListItemAdapter adapter = new ProducersListItemAdapter(ProducersActivity.this, producers);

                ListView listView = getListView();
                listView.setAdapter(adapter);
            }
            ListView listView = getListView();
        }
    }
}
