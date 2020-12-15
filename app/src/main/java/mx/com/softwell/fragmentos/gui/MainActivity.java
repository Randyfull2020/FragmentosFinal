package mx.com.softwell.fragmentos.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import mx.com.softwell.fragmentos.R;
import mx.com.softwell.fragmentos.core.FragmentosApplication;
import mx.com.softwell.fragmentos.gui.components.NavigationHost;

//Proyecto 3er Parcial Randy Flores García

public class MainActivity extends AppCompatActivity implements NavigationHost {

    public static HashMap<String, Object> GLOBALS = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configContext();
        configGlobals();
        configFragmentManager(savedInstanceState);
    }

    private void configContext() {
        FragmentosApplication.setAppContext(getApplicationContext());
    }

    private void configGlobals() {
        GLOBALS.put("app", this);
    }

    private void configFragmentManager(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentPanel, new LoginFragment())
                    .commit();
        }
    }

    public void nuevoold(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentPanel, new ViejaEscuela())
                .commit();
    }

    public void nuevotop(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentPanel, new TopJuegos())
                .commit();
    }

    public void nuevofree(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentPanel, new FreeToPlay())
                .commit();
    }

    public void nuevoranked(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contentPanel, new TopRanked())
                .commit();
    }

    @Override
    public void navigateTo(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right, R.animator.slide_in_right, R.animator.slide_out_left)
                        .replace(R.id.contentPanel, fragment);
        if (addToBackStack)
            transaction.addToBackStack(null);
        transaction.commit();
    }
}