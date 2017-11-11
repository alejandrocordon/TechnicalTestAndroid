package com.test.alejandrocordonurena.technicaltestandroid;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.test.alejandrocordonurena.technicaltestandroid.datasource.DataSource;
import com.test.alejandrocordonurena.technicaltestandroid.model.Account;
import com.test.alejandrocordonurena.technicaltestandroid.sqlite.DatabaseHandlerAccounts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Animation set
        ScaleAnimation scale = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        AlphaAnimation alpha = new AlphaAnimation(0.1f, 0.9f);

        final AnimationSet set = new AnimationSet(true);
        set.addAnimation(scale);
        set.addAnimation(alpha);
        set.setDuration(2000);

        final ImageView dragon = (ImageView) findViewById(R.id.imageView);
        dragon.startAnimation(set);


        // Runnable to start the SplashActivity
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {


                /***
                 * First of all we are goint to normalize the data source to convert it to a JSON.
                 * TODO: Process the datasource in a asynctask
                 */
                DataSource dataSource = new DataSource();
                String data = dataSource.datasource.toString();
                String normalizedDataSource = dataSource.normalizeToJSON(data);

                /***
                 * The datasource string converts to standard JSON
                 */
                JSONObject jsonObject = dataSource.dataSourceToJSONObject(normalizedDataSource);

                /***
                 * Store all the data in a DataBase
                 */
                ArrayList<Account> accounts = dataSource.JSONObjectToArrayList(jsonObject);

                /***
                 *  Creating the DB
                  */
                DatabaseHandlerAccounts db = new DatabaseHandlerAccounts(SplashActivity.this);

                /***
                 * Delete all old accounts
                 */
                db.Delete_All_accounts();


                /***
                 * Storing the data into the database
                 */
                for (Account item : accounts) {
                    db.Add_account(item);
                }


                Intent mainIntent = new Intent(SplashActivity.this, ListAccountActivity.class);
                startActivity(mainIntent);
                finish();


            }}, 2500);






    }
}
