package hr.heureka.memento.webservice;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by ivan on 11.7.2016..
*/
public interface WsCaller {
    @POST("/heureka/src/json.php")
    Call<WsResponse> getAllNews();
}

