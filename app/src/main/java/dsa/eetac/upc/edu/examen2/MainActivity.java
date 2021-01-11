package dsa.eetac.upc.edu.examen2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ImageView avatar;
    TextView user;
    TextView followers;
    TextView following;
    TextView login;
    Button repos;

    Bundle extras;
    String newString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avatar = (ImageView) findViewById(R.id.avatar);
        user = (TextView) findViewById(R.id.username);
        followers = (TextView) findViewById(R.id.followers);
        following = (TextView) findViewById(R.id.following);
        login = (TextView) findViewById(R.id.logIn);
        repos = (Button) findViewById(R.id.ownedReposBtn);

        extras = getIntent().getExtras();
        newString = extras.getString("STRINGKEY");

        loadData();
    }

    public void loadRepos(View view){

        Intent intent = new Intent(this,ReposActivity.class);
        intent.putExtra("username", newString);
        startActivity(intent);
    }



    public void loadData() {
        final UserAPI apiService =
                APIClient.getClient().create(UserAPI.class);

        Call<User> call = apiService.getUser(newString);
        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User>
                    response) {


                if(response.body().getName() == null){
                    user.setText("Error");
                } else {
                    user.setText("Username: " + response.body().getName());
                }

                followers.setText("Followers: " + response.body().getFollowers());
                following.setText("Following: " + response.body().getFollowing());
                login.setText("LogIn: " + response.body().getLogin());


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
