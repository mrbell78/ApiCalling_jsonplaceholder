package com.nurhossen.restwithretrofit;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    TextView tv_id,userid,title,body;

    RecyclerView recyclerView;
    List<Post>datalist;

    static final String baseurl="https://jsonplaceholder.typicode.com/";
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recylerview_main);


         retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         getPost();
         getcomments();

    }

    private void getcomments() {

        Apijson_interface apicallingjson = retrofit.create(Apijson_interface.class);
        Call<List<Comment>> callcoment= apicallingjson.getComent();

        callcoment.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                if(!response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }

    private void getPost(){

        Apijson_interface apioveridemethod = retrofit.create(Apijson_interface.class);

        Call<List<Post>> call_anyting = apioveridemethod.getPost();

        call_anyting.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    tv_id.setText("code "+ response.code());
                    return;
                }
                List<Post> posts = response.body();
                datalist=new ArrayList<>();
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                for(Post post : posts){
                    datalist.add(new Post(post.getId(),post.getUserId(),post.getTitle(),post.getText()));


                }

                Adapter adapter = new Adapter(datalist,MainActivity.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}
