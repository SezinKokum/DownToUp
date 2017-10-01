package com.tatlicilar.downtoup;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Created by sezinkokum on 1.10.2017.
 */

public class Widget extends AppWidgetProvider {

    private static final String SYNC_CLICKED = "WidgetImageClick";
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
        super.onUpdate(context,appWidgetManager, appWidgetIds);

        RemoteViews remoteViews;
        ComponentName componentName;

        remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
        componentName = new ComponentName(context, Widget.class);

//        remoteViews.setImageViewResource(R.id.widget, setImage());
        remoteViews.setOnClickPendingIntent(R.id.widget, getPendingSelfIntent(context, SYNC_CLICKED));
        appWidgetManager.updateAppWidget(componentName, remoteViews);
    }

    @Override
    public void onReceive(Context context, Intent intent){
        super.onReceive(context,intent);
        if (SYNC_CLICKED.equals(intent.getAction())){
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            RemoteViews remoteViews;
            ComponentName componentName;
            remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
            componentName = new ComponentName(context, Widget.class);
//            remoteViews.setImageViewResource(R.id.widget, setImage());
            appWidgetManager.updateAppWidget(componentName, remoteViews);

            Toast.makeText(context, "Acil Durum Sayfamız Yapım Aşamasındadır.",
                    Toast.LENGTH_SHORT).show();

//            AlertDialog.Builder builder=new AlertDialog.Builder(context);
//            builder.setMessage("Acil Durum Sayfamız Yapım Aşamasındadır.");
//            builder.setCancelable(true);
//            builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                }
//            });
//            AlertDialog alert=builder.create();
//            alert.show();
    }
    }
    protected PendingIntent getPendingSelfIntent(Context context, String action){
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);

    }

//    public int setImage(){
//        int image = R.drawable.acil;
//        return image;
//    }
}
