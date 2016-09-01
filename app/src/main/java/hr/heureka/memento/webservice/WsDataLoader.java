package hr.heureka.memento.webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import hr.heureka.memento.entities.WsNewsItem;
import hr.heureka.memento.tab.fragments.NewsFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ivan on 11.7.2016..
 */
public class WsDataLoader {

    private String BASE_URL = "http://www.posluzitelj.domena/";
    private WsResponse result;

    public void loadDataFromWebService(final NewsFragment callerFragment){
        result = new WsResponse();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm") // format u JSON odgovoru
                .create();

        // kreiranje Retrofit objekta i povezivanje sa GSONom
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // kreiranje i poziv web servisa
        WsCaller serviceCaller = retrofit.create(WsCaller.class);
        Call<WsResponse> call = serviceCaller.getAllNews();
        // definiranje događanja nakon dolaska podataka
        call.enqueue(new Callback<WsResponse>() {
            @Override
            public void onResponse(Call<WsResponse> call, Response<WsResponse> response) {
                if (response.isSuccessful()) {
                    result = response.body();
                    callerFragment.showLoadedData(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<WsResponse> call, Throwable t) {
                System.out.println("Something went wrong!");
            }
        });

    }

    // metoda koja vraća trenutno dohvaćene podatke
    public ArrayList<WsNewsItem> getFetchedNewsArray(){
        if(result != null) {
            return result.getResults();
        }
        else{
            return null;
        }
    }
}

