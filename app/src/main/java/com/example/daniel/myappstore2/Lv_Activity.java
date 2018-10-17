package com.example.daniel.myappstore2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;



public class Lv_Activity extends AppCompatActivity {
    private ProductListFragment mProductListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_);

        mProductListFragment = new ProductListFragment.newInstance();
        getFragmentManager().beginTransaction().replace(R.id.content,mProductListFragment).commit();
    }
}
