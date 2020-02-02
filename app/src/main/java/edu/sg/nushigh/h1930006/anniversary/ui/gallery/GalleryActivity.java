package edu.sg.nushigh.h1930006.anniversary.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import edu.sg.nushigh.h1930006.anniversary.R;

import static edu.sg.nushigh.h1930006.anniversary.ui.gallery.GalleryAdapter.SUBGALLERY;

public class GalleryActivity extends AppCompatActivity {

    public static final int[] ORIENTATION_DRAWABLES = new int[]{
            R.drawable.orientation_1, R.drawable.orientation_2, R.drawable.orientation_3,
            R.drawable.orientation_4, R.drawable.orientation_5, R.drawable.orientation_6,
            R.drawable.orientation_7, R.drawable.orientation_8, R.drawable.orientation_9
    };

    public static final int[] CCA_FAIR_DRAWABLES = new int[]{
            R.drawable.cca_1, R.drawable.cca_2, R.drawable.cca_3,
            R.drawable.cca_4,  R.drawable.cca_5,
            R.drawable.cca_6, R.drawable.cca_7
    };

    public static final int[] SLI_DRAWABLES = new int[]{
            R.drawable.sli_1, R.drawable.sli_2, R.drawable.sli_3,
            R.drawable.sli_4, R.drawable.sli_5
    };

    public static final int[] SSEF_DRAWABLES = new int[]{
            R.drawable.ssef_1, R.drawable.ssef_2, R.drawable.ssef_3,
            R.drawable.ssef_4, R.drawable.ssef_5, R.drawable.ssef_6,
            R.drawable.ssef_7, R.drawable.ssef_8, R.drawable.ssef_9
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);


        String category = getIntent().getStringExtra("category");
        setTitle(category);

        RecyclerView recyclerView = findViewById(R.id.recycler_subgallery);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(new RecyclerView.Adapter<ViewHolder>() {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                ImageView view = (ImageView) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_subgallery_element, parent, false);
                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                if (category.equals(getString(SUBGALLERY[0][0]))) {
                    holder.view.setImageDrawable(getDrawable(ORIENTATION_DRAWABLES[position]));
                } else if (category.equals(getString(SUBGALLERY[1][0]))) {
                    holder.view.setImageDrawable(getDrawable(CCA_FAIR_DRAWABLES[position]));
                } else if (category.equals(getString(SUBGALLERY[2][0]))) {
                    holder.view.setImageDrawable(getDrawable(SLI_DRAWABLES[position]));
                } else if (category.equals(getString(SUBGALLERY[3][0]))) {
                    holder.view.setImageDrawable(getDrawable(SSEF_DRAWABLES[position]));
                }
            }

            @Override
            public int getItemCount() {
                if (category.equals(getString(SUBGALLERY[0][0]))) {
                    return ORIENTATION_DRAWABLES.length;
                } else if (category.equals(getString(SUBGALLERY[1][0]))) {
                    return CCA_FAIR_DRAWABLES.length;
                } else if (category.equals(getString(SUBGALLERY[2][0]))) {
                    return SLI_DRAWABLES.length;
                } else if (category.equals(getString(SUBGALLERY[3][0]))) {
                    return SSEF_DRAWABLES.length;
                }
                return 0;
            }
        });
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView view;

        ViewHolder(@NonNull ImageView itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
}
