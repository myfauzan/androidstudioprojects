package com.example.latihan;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String URL = "http://192.168.43.232/CRUDVolley/select.php";
    List<Data> itemlist = new ArrayList<Data>();
    SwipeRefreshLayout swipe;
    ListView list;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        list = (ListView) findViewById(R.id.list);

        adapter = new Adapter(MainActivity.this, itemlist);
        list.setAdapter(adapter);

        swipe.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);

        swipe.post(new Runnable() {
                       @Override
                       public void run() {
                           swipe.setRefreshing(true);
                           itemlist.clear();
                           adapter.notifyDataSetChanged();
                           callVolley();
                       }
                   }
        );
    }

    public void onRefresh() {
        itemlist.clear();
        adapter.notifyDataSetChanged();
        callVolley();
    }

    private void callVolley() {
        itemlist.clear();
        adapter.notifyDataSetChanged();
        swipe.setRefreshing(true);
        refresh(1000);

        //membuat request JSON
        JsonArrayRequest jArr = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //Parsing json
                for (int i = 0; i < response.length();
                     i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                            Data item = new Data();

                            item.setId(obj.getString("id"));
                            item.setTemperature(obj.getInt("data_temperature"));
                            item.setHumidity(obj.getInt("data_humidity"));
                            item.setTimestamp(obj.getString("timestamp"));

                            //menambah item ke array
                            itemlist.add(item);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    //notifikasi adanya perubahan data pada adapter
                    adapter.notifyDataSetChanged();
                    swipe.setRefreshing(false);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                    swipe.setRefreshing(false);
                }
            });

            // menambah request ke request queue
            RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
            mRequestQueue.add(jArr);

        }

        private void refresh(int milisecond) {

            final Handler handler = new Handler();

            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    callVolley();
                }
            };

            handler.postDelayed(runnable, milisecond);

        }
    }