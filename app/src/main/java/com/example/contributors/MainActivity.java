package com.example.contributors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private TextView mTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        mTextView2 = (TextView) findViewById(R.id.textView2);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.INVISIBLE);


    }

    public void onClick(View view) {
        mProgressBar.setVisibility(View.VISIBLE);

        GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
        final Call<List<Contributor>> call =
                gitHubService.repoContributors("square", "picasso");
        GitHubService2 gitHubService2 = GitHubService2.retrofit.create(GitHubService2.class);
        final Call<List<Contributions>> call2 =
                gitHubService2.repoContributors("square", "picasso");


        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                String s = response.body().toString().replace("[", " ");
                s = s.replace("]", "");
                s = s.replace(",", "");

                mTextView.setText(s);
                mProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable throwable) {

                mTextView.setText("Что-то пошло не так: " + throwable.getMessage());
            }

        });

        call2.enqueue(new Callback<List<Contributions>>() {
            @Override
            public void onResponse(Call<List<Contributions>> call, Response<List<Contributions>> response) {
                String s = response.body().toString().replace("[", " ");
                s = s.replace("]", "");
                s = s.replace(",", "");

                mTextView2.setText(s);
                mProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<Contributions>> call, Throwable throwable) {

                mTextView2.setText("Что-то пошло не так: " + throwable.getMessage());
            }

        });
    }
}