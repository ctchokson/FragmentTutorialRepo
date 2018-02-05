package com.example.owner.fragmentlayoutrepo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Owner on 2/4/2018.
 */

public class FragmentImage extends Fragment
{
    int[] drawables={R.drawable.apple,R.drawable.cherry,R.drawable.lemon,R.drawable.orange,R.drawable.pear,R.drawable.strawberry};
    int currentPosition=-1;
    ImageView view;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        view=(ImageView)inflater.inflate(R.layout.imageviewer,container,false);
        return view;
    }

    @Override
    public void onStart() {
        //My onstart method.
        super.onStart();
        Bundle argument=getArguments();
        if(argument!=null)
        {
            updateImage(argument.getInt("position"));
        }
        else if(currentPosition!=-1)
        {
            updateImage(currentPosition);
        }
    }

    public void updateImage(int position)
    {
        if(view!=null)
        {
            view.setImageResource(drawables[position]);
            //update currentposition
            currentPosition=position;
        }
    }

}
