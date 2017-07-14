package com.stelloux.launchanotherapplication;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchApplication(View view) {
        final String packageName = "com.google.android.apps.maps";
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        } else {
            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Impossible de lancer l'application", Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
            snackbar.show();
        }
    }

}