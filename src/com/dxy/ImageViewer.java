package com.dxy;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImageViewer extends Activity {
    private WebView viewer;
    private WebSettings settings;

    private final String BASE_URL = "file:///android_asset/";
    private String template = "";
    private String imageUrl;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_viewer);

        viewer = (WebView) findViewById(R.id.viewer);
        settings = viewer.getSettings();

        imageUrl = getIntent().getStringExtra("imageUrl");
        if (imageUrl == null) {
            imageUrl = "";
        }

        initViewer();
        readTemplateString();

        if (imageUrl != null && imageUrl.length() > 1) {
            viewer.loadDataWithBaseURL(BASE_URL, String.format(template, imageUrl), "text/html", "utf-8", null);
        }
    }


    private void initViewer() {
        settings.setLoadsImagesAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLightTouchEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);

        viewer.setInitialScale(0);
        viewer.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        viewer.setHorizontalScrollBarEnabled(false);
        viewer.setVerticalScrollBarEnabled(false);
        viewer.setBackgroundColor(0x000000);
        viewer.clearCache(true);
        viewer.setFocusable(false);

        viewer.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {

            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
    }

    private void readTemplateString() {
        BufferedReader br = null;
        String tmp = "";
        InputStreamReader reader = new InputStreamReader(getResources().openRawResource(R.raw.image_viewer));
        try {
            br = new BufferedReader(reader);
            while ((tmp = br.readLine()) != null) {
                template += tmp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close(); // stop reading
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
