package com.test.alejandrocordonurena.technicaltestandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.test.alejandrocordonurena.technicaltestandroid.lists.adapter.ListView_accounts_adapter;
import com.test.alejandrocordonurena.technicaltestandroid.model.Account;
import com.test.alejandrocordonurena.technicaltestandroid.sqlite.DatabaseHandlerAccounts;

import java.util.ArrayList;

public class ListAccountActivity extends AppCompatActivity {


    private ListAdapter mAdapter_all;
    private ListAdapter mAdapter_visible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_account);


        ListView listView = (ListView) findViewById(R.id.listView);

        DatabaseHandlerAccounts db = new DatabaseHandlerAccounts(ListAccountActivity.this);

        ArrayList<Account> accounts = db.Get_All_accounts();
        ArrayList<Account> visible_accounts = db.Get_visible_account();


        mAdapter_all = new ListView_accounts_adapter(ListAccountActivity.this, accounts);
        mAdapter_visible = new ListView_accounts_adapter(ListAccountActivity.this, accounts);


        listView.setAdapter(mAdapter_all);


    }
}
