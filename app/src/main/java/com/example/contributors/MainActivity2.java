package com.example.contributors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private TextView mTextView;
    private Button mButton;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        mEditText = findViewById(R.id.editTextText);
        mEditText.setVisibility(View.INVISIBLE);
        mButton = (Button) findViewById(R.id.button);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.INVISIBLE);
        mProgressBar.setVisibility(View.VISIBLE);
        mButton.setVisibility(View.INVISIBLE);

        mProgressBar.setVisibility(View.VISIBLE);

            GitHubService3 gitHubService = GitHubService.retrofit.create(GitHubService3.class);
            final Call<User> call =
                    gitHubService.getUser("alexanderklimov");

            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    // response.isSuccessfull() is true if the response code is 2xx
                    if (response.isSuccessful()) {
                        User user = response.body();

                        // Получаем json из github-сервера и конвертируем его в удобный вид
                        mTextView.setText("Аккаунт Github: " + user.getName() +
                                "\nСайт: " + user.getBlog() +
                                "\nКомпания: " + user.getCompany());

                        mProgressBar.setVisibility(View.INVISIBLE);
                    } else {
                        int statusCode = response.code();

                        // handle request errors yourself
                        ResponseBody errorBody = response.errorBody();
                        try {
                            mTextView.setText(errorBody.string());
                            mProgressBar.setVisibility(View.INVISIBLE);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable throwable) {
                    mTextView.setText("Что-то пошло не так: " + throwable.getMessage());
                }
            });
        }
    }



