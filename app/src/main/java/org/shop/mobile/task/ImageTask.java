package org.shop.mobile.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import org.shop.mobile.Constants;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageTask extends AsyncTask<String, Void, Bitmap> {

    protected ImageView image;

    public ImageTask(ImageView image) {
        this.image = image;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {

        try {
            URL url = new URL(Constants.SERVICE_URI + urls[0]);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return bmp;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bmp) {
        if(bmp != null) {
            image.setImageBitmap(bmp);
        }
    }
}
