package com.playground.nutrition.ui;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.playground.nutrition.R;

/**
 * Helpful resources
 * http://www.vogella.com/tutorials/AndroidCustomViews/article.html
 */
public class SearchView extends ConstraintLayout {


    public SearchView(Context context) {
        super(context);
        initLayout(context);
    }

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    private void initLayout(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_search_view, this, true);
    }


}
