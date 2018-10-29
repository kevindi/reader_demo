package com.example.kdi.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class RelatedArticleAdapterV2 extends FragmentStatePagerAdapter {

    public static final String ARTICLE_CONTENT_RES = "article_content_res";
    public static final String ARTICLE_TITLE = "article_title";
    public static final String ARTICLE_POS = "article_pos";
    @NonNull private int[] articles;

    public RelatedArticleAdapterV2(@NonNull FragmentManager fragmentManager,
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
        bundle.putString(ARTICLE_TITLE, TestData.getArticleTitle(position));
        bundle.putInt(ARTICLE_POS, position);
        return SocialReaderFragmentV2.newInstance(bundle);
    }
}
