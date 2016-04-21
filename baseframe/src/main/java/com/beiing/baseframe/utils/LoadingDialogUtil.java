package com.beiing.baseframe.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.beiing.baseframe.R;
import com.beiing.baseframe.widgets.titanicloading.Titanic;
import com.beiing.baseframe.widgets.titanicloading.TitanicTextView;

/**
 * Created by chenliu on 2016/4/20.
 * 描述：加载等待框
 */
public class LoadingDialogUtil {

    private static Dialog mDialog;

    public static void showDialog(Context context){
        if(context instanceof Activity){
            mDialog = new Dialog(context, R.style.loadingdialog);
            View dialog = LayoutInflater.from(context).inflate(R.layout.loading_dialog, null);
            TitanicTextView tv = (TitanicTextView) dialog.findViewById(R.id.my_text_view);
            tv.setTypeface(Typefaces.get(context, "Satisfy-Regular.ttf"));
            new Titanic().start(tv);
            mDialog.setContentView(dialog);
            mDialog.setCancelable(true);
            Window window = mDialog.getWindow();
            window.setBackgroundDrawableResource(R.drawable.bg_loading_dialog);
            WindowManager.LayoutParams lp = window.getAttributes();
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            lp.height = (int) (80 * dm.density);
            lp.width = (int) (160 * dm.density);
            window.setAttributes(lp);
            mDialog.show();
        }
    }

    public static void dismissDialog(){
        if(mDialog != null && mDialog.isShowing()){
            mDialog.dismiss();
        }
    }

}



