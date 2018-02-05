package com.example.owner.fragmentlayoutrepo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Owner on 2/4/2018.
 */

public class FragmentList extends ListFragment
{
    public interface ActivityListener
    {
        void OnListClick(int position);
    }

    ActivityListener myListener;
    String[] strDrawables={"Apple","Cherry","Lemon","Orange","Pear","Strawberry"};

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,strDrawables));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try
        {
            myListener=(ActivityListener)context;
        }
        catch (ClassCastException e){}
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        myListener.OnListClick(position);
    }
}
