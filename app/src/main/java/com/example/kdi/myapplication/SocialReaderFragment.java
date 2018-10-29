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

public class SocialReaderFragment extends Fragment {

    private int articleContentRes;

    @NonNull
    public static SocialReaderFragment newInstance(@NonNull Bundle bundle) {
        SocialReaderFragment fragment = new SocialReaderFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            articleContentRes = bundle.getInt(RelatedArticleAdapter.ARTICLE_CONTENT_RES);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.social_reader_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView articleContent = view.findViewById(R.id.article_content);
        articleContent.setText(getResources().getString(articleContentRes));

        ImageView poster = view.findViewById(R.id.poster);
        poster.setImageResource(TestData.getPoster());
    }
}
