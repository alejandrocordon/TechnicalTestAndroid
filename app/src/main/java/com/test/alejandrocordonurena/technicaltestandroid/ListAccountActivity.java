package com.test.alejandrocordonurena.technicaltestandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.test.alejandrocordonurena.technicaltestandroid.lists.adapter.ListView_accounts_adapter;
import com.test.alejandrocordonurena.technicaltestandroid.model.Account;
import com.test.alejandrocordonurena.technicaltestandroid.sqlite.DatabaseHandlerAccounts;

import java.util.ArrayList;

public class ListAccountActivity extends AppCompatActivity {


    private ListAdapter mAdapter_all;
    private ListAdapter mAdapter_visible;


    private ListView listView;
    private DatabaseHandlerAccounts db;
    private ArrayList<Account> accounts;
    private ArrayList<Account> visible_accounts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_account);



        listView = (ListView) findViewById(R.id.listView);

        db = new DatabaseHandlerAccounts(ListAccountActivity.this);

        //accounts = db.Get_All_accounts();
        visible_accounts = db.Get_visible_account();


        //mAdapter_all = new ListView_accounts_adapter(ListAccountActivity.this, accounts);
        mAdapter_visible = new ListView_accounts_adapter(ListAccountActivity.this, visible_accounts);


        listView.setAdapter(mAdapter_visible);



        final Button buttonShow = (Button) findViewById(R.id.buttonShow);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(listView.getAdapter().equals(mAdapter_all)){
                    visible_accounts = db.Get_visible_account();
                    mAdapter_visible = new ListView_accounts_adapter(ListAccountActivity.this, visible_accounts);
                    listView.setAdapter(mAdapter_visible);
                    buttonShow.setText("Show All");
                }else{
                    accounts = db.Get_All_accounts();
                    mAdapter_all = new ListView_accounts_adapter(ListAccountActivity.this, accounts);
                    listView.setAdapter(mAdapter_all);
                    buttonShow.setText("Show Visible");
                }
            }
        });

        Button buttonReload = (Button) findViewById(R.id.buttonReload);
        buttonReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(listView.getAdapter().equals(mAdapter_all)){
                    accounts = db.Get_All_accounts();
                    mAdapter_all = new ListView_accounts_adapter(ListAccountActivity.this, accounts);
                    listView.setAdapter(mAdapter_all);
                    buttonShow.setText("Show Visible");
                }else{
                    visible_accounts = db.Get_visible_account();
                    mAdapter_visible = new ListView_accounts_adapter(ListAccountActivity.this, visible_accounts);
                    listView.setAdapter(mAdapter_visible);
                    buttonShow.setText("Show All");

                }

            }
        });





    }
}
