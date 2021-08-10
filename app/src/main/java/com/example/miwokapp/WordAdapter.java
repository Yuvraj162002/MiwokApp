package com.example.miwokapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
private int mColorResoursesId;

    public WordAdapter(Activity  context,  ArrayList<Word> wordArrayList,int colorid) {
        super(context, 0, wordArrayList);
        mColorResoursesId=colorid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listview = convertView;
        if (listview==null){
            listview = LayoutInflater.from(getContext()).inflate(R.layout.list,parent,false);
        }
        Word currentword = getItem(position);

        TextView mivokTextview = (TextView)listview.findViewById(R.id.miwok_text_view);
        mivokTextview.setText(currentword.getMivokTranslation());


        TextView mDefaultTextView = (TextView)listview.findViewById(R.id.default_text_view);
        mDefaultTextView.setText(currentword.getDefaultTranslation());


        ImageView mImageView = (ImageView)listview.findViewById(R.id.imageview);
        if (currentword.hasImage()) {
            mImageView.setImageResource(currentword.getImage());

            mImageView.setVisibility(View.VISIBLE);
        }
        else{
            mImageView.setVisibility(View.GONE);
            }

        View textcolor = (View)listview.findViewById(R.id.textcolor);
        int color = ContextCompat.getColor(getContext(),mColorResoursesId);
        textcolor.setBackgroundColor(color);
        return listview;

    }
}
