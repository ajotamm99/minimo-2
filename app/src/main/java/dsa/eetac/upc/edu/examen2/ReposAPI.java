package dsa.eetac.upc.edu.examen2;

import java.util.List;
import dsa.eetac.upc.edu.examen2.Repos;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReposAPI {

        @GET("/users/{user}/repos")
        Call<List<Repos>> getRepos(@Path("user") String name);
}
