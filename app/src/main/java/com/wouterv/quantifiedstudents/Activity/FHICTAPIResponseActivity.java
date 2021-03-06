package com.wouterv.quantifiedstudents.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.wouterv.quantifiedstudents.MainActivity;
import com.wouterv.quantifiedstudents.canvasmodels.Config;

import android.os.Handler;

import com.wouterv.quantifiedstudents.R;

public class FHICTAPIResponseActivity extends AppCompatActivity {

    Config config = Config.getInstance();
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fhictapiresponse);

        String access_token = getAccesTokenFromString(getIntent().getData().toString());
        Log.d("access_token",access_token);
        Config.getInstance().setAccess_token(access_token);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
//        IResultJsonArray resultCallback = new IResultJsonArray() {
//            @Override
//            public void notifySuccess(String requestType, JSONArray response) {
//                List<Course> courseList = new ArrayList<>();
//                for(int i = 0; i<response.length();i++){
//                    try {
//                        courseList.add(new Course(response.getJSONObject(i),getApplicationContext()));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//                Config.getInstance().setCourses(courseList);
//            }
//
//            @Override
//            public void notifyError(String requestType, VolleyError error) {
//                Log.d("aaa","fuuuuuuck2");
//                error.printStackTrace();
//            }
//        };
//        new VolleyServiceJsonArray(resultCallback,getApplicationContext()).getDataVolley(getString(R.string.course_list), null);
//
//        Runnable timerRunnable = new Runnable() {
//
//            @Override
//            public void run() {
//                if(config.hasCompletedLoading()) {
//                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                    finish();
//                    return;
//                }
//                handler.postDelayed(this, 100);
//            }
//        };
//        handler.postDelayed(timerRunnable, 1000);
    }

    public static String getAccesTokenFromString(String link) {
        link = link.replace("fhictnyx://nyxcallback/#access_token=", "");
        int bb = link.indexOf('&');
        Log.d("bb", "" + bb);
        return link.substring(0, link.indexOf('&'));
    }

}
