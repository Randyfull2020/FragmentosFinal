package mx.com.softwell.fragmentos.gui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import java.util.List;
import mx.com.softwell.fragmentos.R;
import mx.com.softwell.fragmentos.core.TopJuegoController;
import mx.com.softwell.fragmentos.core.MiscController;
import mx.com.softwell.fragmentos.databinding.FragmentTopJuegosBinding;
import mx.com.softwell.fragmentos.gui.components.JuegosAdapter;
import mx.com.softwell.fragmentos.gui.components.NavigationHost;
import mx.com.softwell.fragmentos.gui.components.NavigationIconClickListener;
import mx.com.softwell.fragmentos.model.Juego;

public class TopJuegos extends Fragment {
    private MiscController miscController = MiscController.Instance();
    private TopJuegoController topJuegoController = TopJuegoController.Instance();
    private FragmentTopJuegosBinding binding;
    private View view;
    private Context context;
    private static String TAG = "TopJuegos";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        configGlobals();
        configView(inflater, container);
        configToolbar();
        configUI();
        configRecycler();
        actualizar();

        binding.fabCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((NavigationHost) getActivity()).navigateTo(new AddFragment(), true);
            }
        });
        return view;
    }

    private void configGlobals() {
        MainActivity.GLOBALS.put("topJuegosFragment", this);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentTopJuegosBinding.inflate(inflater, container, false);
        view = binding.getRoot();
        context = container.getContext();
    }

    private void configToolbar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(binding.appBar);
        }
        binding.appBar.setNavigationOnClickListener(new NavigationIconClickListener(
                context,
                view.findViewById(R.id.gridTopGames),
                new AccelerateDecelerateInterpolator(),
                context.getDrawable(R.drawable.menu),
                context.getDrawable(R.drawable.menu_open)
        ));
    }

    private void configUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.findViewById(R.id.gridTopGames).setBackground(getContext().getDrawable(R.drawable.product_grid_background_shape));
        }
    }

    private void configRecycler() {
        binding.rclvTopJuegos.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        binding.rclvTopJuegos.setLayoutManager(layoutManager);
    }

    private void actualizar() {
        miscController.ShowWait(context, "Consultando juegos...");
        topJuegoController.getAll();
    }

    public void actualizar(List<Juego> juegos) {
        binding.rclvTopJuegos.setAdapter(new JuegosAdapter(juegos));
        miscController.CloseWait();
    }
}