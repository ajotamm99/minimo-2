package dsa.eetac.upc.edu.examen2;

import retrofit2.Call;
import dsa.eetac.upc.edu.examen2.User;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserAPI {
    @GET("/users/{user}")

    Call<User> getUser(@Path("user") String user);
}
