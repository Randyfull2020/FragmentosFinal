package mx.com.softwell.fragmentos.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.irozon.alertview.AlertActionStyle;
import com.irozon.alertview.AlertStyle;
import com.irozon.alertview.AlertView;
import com.irozon.alertview.interfaces.AlertActionListener;
import com.irozon.alertview.objects.AlertAction;
import org.jetbrains.annotations.NotNull;
import dmax.dialog.SpotsDialog;
import mx.com.softwell.fragmentos.R;
import mx.com.softwell.fragmentos.gui.MainActivity;

public class MiscController {
    private static MiscController instance = null;
    public String actualFragment;
    private ProgressDialog progressDialog;
    private AlertDialog alertDialog;
    private AlertView alertView;
    private LayoutInflater inflater;
    private View layout;
    private TextView text;
    private Toast toast;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private MiscController() {
    }

    public static MiscController Instance() {
        if (instance == null)
            instance = new MiscController();
        return instance;
    }

    public void MessageBox(View view, String mensaje, int length) {
        Snackbar.make(view, mensaje, length).show();
    }

    public void MessageBox(AppCompatActivity activity, String title, String message, AlertStyle style) {
        alertView = new AlertView(title, message, style);
        alertView.addAction(new AlertAction("Ok", AlertActionStyle.DEFAULT, new AlertActionListener() {
            @Override
            public void onActionClick(@NotNull AlertAction action) {
            }
        }));
        alertView.show(activity);
    }

    public void MessageBox(AppCompatActivity activity, String title, String message, AlertAction action, AlertStyle style) {
        alertView = new AlertView(title, message, style);
        alertView.addAction(action);
        alertView.show(activity);
    }

    public void MessageBox(AppCompatActivity activity, String title, String message, AlertAction action, AlertAction action2, AlertStyle style) {
        alertView = new AlertView(title, message, style);
        alertView.addAction(action);
        alertView.addAction(action2);
        alertView.show(activity);
    }

    public void ShowWait(Context context, String message) {
        alertDialog = new SpotsDialog(context, message, R.style.CustomProgressBar);
        alertDialog.show();
    }

    public void CloseWait() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
        if (alertDialog != null && alertDialog.isShowing())
            alertDialog.dismiss();
    }

    public void hideKeyboardFrom(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        View f = activity.getCurrentFocus();
        if (null != f && null != f.getWindowToken() && EditText.class.isAssignableFrom(f.getClass()))
            imm.hideSoftInputFromWindow(f.getWindowToken(), 0);
        else
            activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void Toast(String message) {
        inflater = ((MainActivity) MainActivity.GLOBALS.get("app")).getLayoutInflater();
        layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) ((MainActivity) MainActivity.GLOBALS.get("app")).findViewById(R.id.custom_toast_container));

        text = layout.findViewById(R.id.text);
        text.setText(message);

        toast = new Toast(FragmentosApplication.getAppContext());
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 80);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
