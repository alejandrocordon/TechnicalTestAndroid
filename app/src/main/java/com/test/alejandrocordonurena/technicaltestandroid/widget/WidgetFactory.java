package com.test.alejandrocordonurena.technicaltestandroid.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.test.alejandrocordonurena.technicaltestandroid.ListAccountActivity;
import com.test.alejandrocordonurena.technicaltestandroid.R;
import com.test.alejandrocordonurena.technicaltestandroid.lists.adapter.ListView_accounts_adapter;
import com.test.alejandrocordonurena.technicaltestandroid.model.Account;
import com.test.alejandrocordonurena.technicaltestandroid.sqlite.DatabaseHandlerAccounts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alejandrocordonurena on 12/11/2017.
 */

public class WidgetFactory implements RemoteViewsService.RemoteViewsFactory
{
    private Context context = null;
    private int appWidgetId;

    private ArrayList<Account> visible_accounts;
    private ArrayList<Account> accounts;

    private RemoteViews remoteView;

    private DatabaseHandlerAccounts db;



    public WidgetFactory(Context context, Intent intent)
    {
        this.context = context;
        appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        Log.d("AppWidgetId", String.valueOf(appWidgetId));
        db = new DatabaseHandlerAccounts(this.context);

        accounts = db.Get_All_accounts();


        intent.getAction();
    }

    private void updateWidgetListView()
    {

        db = new DatabaseHandlerAccounts(this.context);

        accounts = db.Get_All_accounts();

    }

    @Override
    public int getCount()
    {
        return accounts.size();
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public RemoteViews getLoadingView()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RemoteViews getViewAt(int position)
    {
        remoteView = new RemoteViews(context.getPackageName(),R.layout.row_layout_list_account);

        remoteView.setTextViewText(R.id.textViewName, accounts.get(position).getAccountName() + accounts.get(position).getAccountBalanceInCents());

        float balanceInUnits = (Float.parseFloat(accounts.get(position).getAccountBalanceInCents()) / 1000);

        remoteView.setTextViewText(R.id.textViewBalance, balanceInUnits + accounts.get(position).getAccountCurrency());
        remoteView.setTextViewText(R.id.textViewName, accounts.get(position).getAccountCurrency());


        return remoteView;
    }




    @Override
    public boolean hasStableIds()
    {
        // TODO Auto-generated method stub
        return false;
    }



    @Override
    public void onDataSetChanged()
    {
        // TODO Auto-generated method stub
        updateWidgetListView();
    }

    @Override
    public void onCreate()
    {
        // TODO Auto-generated method stub
        updateWidgetListView();
    }


    @Override
    public int getViewTypeCount()
    {
        // TODO Auto-generated method stub
        return 1;
    }


    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub
        accounts.clear();
        db.close();
    }



}

