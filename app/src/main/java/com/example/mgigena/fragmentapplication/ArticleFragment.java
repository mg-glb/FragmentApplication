package com.example.mgigena.fragmentapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by m.gigena on 10/16/2017.
 */

public class ArticleFragment extends Fragment {
    static String ARG_POSITION ="position";
    int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null){
            mCurrentPosition= savedInstanceState.getInt(ARG_POSITION);
        }
        return inflater.inflate(R.layout.article_view,container,false);
    }

    @Override
    public void onStart(){
        super.onStart();
        Bundle args = getArguments();
        if (args != null){
            updateArticleView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1){
            updateArticleView(mCurrentPosition);
        }
    }

    public void updateArticleView(int position) {
        TextView article = (TextView) getActivity().findViewById(R.id.article);
        article.setText(Ipsum.Articles[position]);
        mCurrentPosition =position;
    }

    @Override
    public void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION,mCurrentPosition);
    }
}
