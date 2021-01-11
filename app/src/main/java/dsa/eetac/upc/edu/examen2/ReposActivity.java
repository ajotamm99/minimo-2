package dsa.eetac.upc.edu.examen2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReposActivity extends AppCompatActivity {
    String usname;
    TextView userNameTV;
    RecyclerView myRecyclerView;
    List<Repos> Data = new ArrayList<>();
    RecyclerView.Adapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);

        Bundle extras = getIntent().getExtras();
        usname = extras.getString("username");

        userNameTV =  findViewById(R.id.userNameTV);

        userNameTV.setText("User: " + usname);

        myRecyclerView=  findViewById(R.id.repos_recycler_view);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new RecyclerAdap(Data, R.layout.item_recycler,
                getApplicationContext());

        myRecyclerView.setAdapter(myAdapter);

        loadRepositories();

    }

    public void loadRepositories(){
        ReposAPI apiService =
                APIClient.getClient().create(ReposAPI.class);

        Call<List<Repos>> call = apiService.getRepos(usname);
        call.enqueue(new Callback<List<Repos>>() {
            @Override
            public void onResponse(Call<List<Repos>> call, Response<List<Repos>> response) {

                Data.clear();
                Data.addAll(response.body());
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Repos>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "There aren't repos", Toast.LENGTH_SHORT).show();

            }

        });
    }


}
