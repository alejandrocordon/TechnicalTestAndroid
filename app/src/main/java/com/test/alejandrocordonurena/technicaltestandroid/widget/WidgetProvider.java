package com.test.alejandrocordonurena.technicaltestandroid.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.test.alejandrocordonurena.technicaltestandroid.R;


/**
 * Created by alejandrocordonurena on 12/11/2017.
 */

public class WidgetProvider extends AppWidgetProvider
{


    private static final String SHOW_CLICKED    = "ShowClick";
    private static final String RELOAD_CLICKED    = "RealoadClick";


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        for(int i=0;i<appWidgetIds.length;i++)
        {
            RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget);

            Intent intent = new Intent(context, WidgetService.class);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);

            rv.setOnClickPendingIntent(R.id.buttonShowWidget, getPendingSelfIntent(context, SHOW_CLICKED));
            rv.setOnClickPendingIntent(R.id.buttonReloadWidget, getPendingSelfIntent(context, RELOAD_CLICKED));
            rv.setRemoteAdapter(R.id.listView, intent);

            appWidgetManager.updateAppWidget(appWidgetIds[i], rv);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }


    protected PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }


    @Override
    public void onReceive(Context context, Intent intent) {

        super.onReceive(context, intent);


        if (SHOW_CLICKED.equals(intent.getAction())) {


            Toast.makeText(context, "onReceive SHOW_CLICKED", Toast.LENGTH_SHORT).show();

          //TODO: change view

        }


        if (RELOAD_CLICKED.equals(intent.getAction())) {


            Toast.makeText(context, "onReceive REALOAD_CLICKED", Toast.LENGTH_SHORT).show();

            //TODO :  refresh data

        }


    }
}