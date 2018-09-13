package ca.cours5b5.fredericengland.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MyApp",getClass().getSimpleName() + "::onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MyApp",getClass().getSimpleName() + "::onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MyApp",getClass().getSimpleName() + "::onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("MyApp",getClass().getSimpleName() + "::onSaveInstanceState");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MyApp",getClass().getSimpleName() + "::onDestroy");
    }
}
