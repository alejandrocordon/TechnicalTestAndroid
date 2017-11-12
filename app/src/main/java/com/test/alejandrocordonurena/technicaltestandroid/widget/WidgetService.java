package com.test.alejandrocordonurena.technicaltestandroid.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by alejandrocordonurena on 12/11/2017.
 */

public class WidgetService extends RemoteViewsService
{

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent)
    {
        return (new WidgetFactory(this.getApplicationContext(), intent));
    }

}