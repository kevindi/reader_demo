package com.example.kdi.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class RelatedArticleAdapter extends FragmentStatePagerAdapter {

    public static final String ARTICLE_CONTENT_RES = "article_content_res";
    @NonNull private int[] articles;

    public RelatedArticleAdapter(@NonNull FragmentManager fragmentManager,
                                 @NonNull int[] articles) {
        super(fragmentManager);
        this.articles = articles;
    }

    @Override
    public int getCount() {
        return articles.length;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(ARTICLE_CONTENT_RES, articles[position]);
        return SocialReaderFragment.newInstance(bundle);
    }
}
