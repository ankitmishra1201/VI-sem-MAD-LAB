package com.example.l10q1;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadService extends IntentService {

    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String url = intent.getStringExtra("url");
        String fileName = intent.getStringExtra("fileName");

        try {
            URL downloadUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) downloadUrl.openConnection();
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(
                    Environment.getExternalStorageDirectory() + "/" + fileName);

            byte[] buffer = new byte[1024];
            int byteCount;
            while ((byteCount = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, byteCount);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();

            // Broadcast message to notify activity
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction("DOWNLOAD_COMPLETE");
            sendBroadcast(broadcastIntent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
