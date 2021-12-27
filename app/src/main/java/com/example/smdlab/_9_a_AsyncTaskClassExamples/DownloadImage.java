package com.example.smdlab._9_a_AsyncTaskClassExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.smdlab.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class DownloadImage extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_image);

        imageView = findViewById(R.id.asyncImgView);

    }

//    FUNCTION - Here AsyncTask is extended and its parameters are link, progress, result
//    Here we will download the image IN BACKGROUND whose url is passed as parameter from below function LoadImage()
    class ImageDownload extends AsyncTask<String, Void, Bitmap>{
    @Override
//    parameter is String Array
//    return type is Result which is a Bitmap Image
    protected Bitmap doInBackground(String... strings) {
        URL url = null;
        try {
//            for first index i.e URL of image we sent in below function LoadImage()
            url = new URL(strings[0]);
//            now we catch image from url from net
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

//            Put data in inputStream from web
            InputStream inputStream = connection.getInputStream();
//            no need for inputStreamReader because we are getting image/bitmap
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

    public void LoadImage(View view) {
//        Create object of ImageDownload() class which we created above
        ImageDownload imageDownload = new ImageDownload();
        try {
//            https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg
//            here execute() will run AsyncTask functions
//            return type is Bitmap because we will return image
            Bitmap bitmap = imageDownload.execute("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg").get();
//            set returned image in imageView
            imageView.setImageBitmap(bitmap);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}