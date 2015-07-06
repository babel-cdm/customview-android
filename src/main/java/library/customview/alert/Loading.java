package library.customview.alert;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import library.customview.R;
import library.customview.progress_bar.ProgressBarCircularIndeterminate;

public class Loading {

    private final Context mContext;
    private Dialog mDialog;
    private int mColor;
    private boolean mTransparent;

    public Loading (Context context, int color) {
        this.mContext = context;
        this.mColor = color;
        this.mTransparent = false;
    }

    public Loading(Context context, int color, boolean transparent) {
        this.mContext = context;
        this.mColor = color;
        this.mTransparent = transparent;
    }

    public void show() {

        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }

        if (mTransparent) {
            mDialog = new Dialog(mContext, R.style.Theme_Dialog_Transparent);
        } else {
            mDialog = new Dialog(mContext, R.style.Theme_Dialog_Translucent);
        }

        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mDialog.setCancelable(false);

        mDialog.setContentView(R.layout.loading_layout);

        ProgressBarCircularIndeterminate progress = (ProgressBarCircularIndeterminate) mDialog.findViewById(R.id.progress);
        progress.setBackgroundColor(mColor);
        mDialog.show();
    }

    public void dismiss() {
        if (mDialog != null) mDialog.dismiss();
    }

}
