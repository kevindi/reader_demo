package com.example.kdi.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RelatedArticlesReaderFragmentV2 extends Fragment {

    private int[] articles;

    public static RelatedArticlesReaderFragmentV2 newInstance(@NonNull Bundle bundle) {
        RelatedArticlesReaderFragmentV2 fragment =  new RelatedArticlesReaderFragmentV2();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();

        if (bundle != null) {
            articles = bundle.getIntArray(MainActivity.ARTICLE_RES_LIST);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.related_articles_reader_fragment_v2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager viewPager = view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new RelatedArticleAdapterV2(getFragmentManager(), articles));

        final TextView viewpagerIndicator = view.findViewById(R.id.view_pager_indicator);
        final TextView readerTitle = view.findViewById(R.id.reader_title);

        viewpagerIndicator.setText("page 1");
        readerTitle.setText(TestData.getArticleTitle(0));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewpagerIndicator.setText("page " + (position + 1));
                readerTitle.setText(TestData.getArticleTitle(position));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
