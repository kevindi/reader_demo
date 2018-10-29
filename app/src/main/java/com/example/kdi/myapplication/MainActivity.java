package com.example.kdi.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    public static final String ARTICLE_RES_LIST = "article_res_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final Bundle bundle = new Bundle();
        bundle.putIntArray(ARTICLE_RES_LIST, TestData.getArticleContents());

        findViewById(R.id.version1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(android.R.id.content, RelatedArticlesReaderFragment.newInstance(bundle), "RelatedArticlesFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        findViewById(R.id.version2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(android.R.id.content, RelatedArticlesReaderFragmentV2.newInstance(bundle), "RelatedArticlesFragmentV2")
                        .addToBackStack(null)
                        .commit();
            }
        });


    }
}
