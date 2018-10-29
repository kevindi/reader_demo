package com.example.kdi.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SocialReaderFragmentV2 extends Fragment {

    private int articleContentRes;
    private String articleTitleStr;
    private int articlePos;

    @NonNull
    public static SocialReaderFragmentV2 newInstance(@NonNull Bundle bundle) {
        SocialReaderFragmentV2 fragment = new SocialReaderFragmentV2();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            articleContentRes = bundle.getInt(RelatedArticleAdapterV2.ARTICLE_CONTENT_RES);
            articleTitleStr = bundle.getString(RelatedArticleAdapterV2.ARTICLE_TITLE);
            articlePos = bundle.getInt(RelatedArticleAdapterV2.ARTICLE_POS);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.social_reader_fragment_v2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView articleContent = view.findViewById(R.id.article_content);
        TextView articleTitle = view.findViewById(R.id.article_title);

        articleTitle.setText(articleTitleStr);
        articleContent.setText(getResources().getString(articleContentRes));

        ImageView poster = view.findViewById(R.id.poster);
        poster.setImageResource(TestData.getPoster(articlePos));
    }
}
