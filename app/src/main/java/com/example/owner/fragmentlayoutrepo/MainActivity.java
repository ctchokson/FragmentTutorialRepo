package com.example.owner.fragmentlayoutrepo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentList.ActivityListener {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.container)!=null)
        {
            if(savedInstanceState!=null) return;

            FragmentList newFragmentList= new FragmentList();
            getSupportFragmentManager().beginTransaction().replace(R.id.container,newFragmentList).commit();

        }
    }

    @Override
    public void OnListClick(int position)
    {
        if(findViewById(R.id.container)!=null)
        {
            FragmentImage imageFragment=new FragmentImage();
            Bundle argument=new Bundle();
            argument.putInt("position",position);
            imageFragment.setArguments(argument);
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container,imageFragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }
        else
        {
            FragmentImage fragmentImage=(FragmentImage) getSupportFragmentManager().findFragmentById(R.id.fragmentimage);
            fragmentImage.updateImage(position);
        }

    }
}
