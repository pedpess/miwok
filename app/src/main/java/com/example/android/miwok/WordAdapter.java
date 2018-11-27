package com.example.android.miwok;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    private int backgroundColorResource;

    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundColorResource) {
        super(context, 0, words);
        this.backgroundColorResource = backgroundColorResource;
    }
    
    ;


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word wordAdapter = getItem(position);

        TextView miwokTranslationTextView = (TextView) listItemView.findViewById(R.id.text_item);
        miwokTranslationTextView.setText(wordAdapter.getMiwokTranslation());

        TextView defaultTranslationTextView = (TextView) listItemView.findViewById(R.id.text_sub_item);
        defaultTranslationTextView.setText(wordAdapter.getDefaultTranslation());

        ImageView imageResource = (ImageView) listItemView.findViewById(R.id.image);

        if (wordAdapter.hasImage()) {
            imageResource.setImageResource(wordAdapter.getImageResourceId());
            imageResource.setVisibility(View.VISIBLE)       ;
        } else {
            imageResource.setVisibility(View.GONE);
        }

        // Setting background color custom
        View textContainer  = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), backgroundColorResource);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
