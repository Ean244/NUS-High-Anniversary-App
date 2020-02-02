package edu.sg.nushigh.h1930006.anniversary.ui.gallery;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.squareup.picasso.Picasso;

import edu.sg.nushigh.h1930006.anniversary.R;

public class GalleryAdapter extends BaseAdapter {
    private final Activity activity;

    public GalleryAdapter(Activity activity) {
        this.activity = activity;
    }

    public static final int[][] SUBGALLERY = {
            new int[]{R.string.gallery_orientation, R.drawable.orientation_main},
            new int[]{R.string.gallery_cca, R.drawable.cca_main},
            new int[]{R.string.gallery_sli, R.drawable.sli_main},
            new int[]{R.string.gallery_ssef, R.drawable.ssef_main}
    };

    private class ViewHolder {
        public TextView text;
        public ImageView image;
    }

    @Override
    public int getCount() {
        return SUBGALLERY.length;
    }

    @Override
    public Object getItem(int position) {
        return SUBGALLERY[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.fragment_gallery_element, parent, false);

            TextView text = convertView.findViewById(R.id.text_gallery_element);
            ImageView image = convertView.findViewById(R.id.image_gallery_element);

            holder = new ViewHolder();
            holder.image = image;
            holder.text = text;
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String category = parent.getContext().getString(SUBGALLERY[position][0]);
        holder.text.setText(category);
        Picasso.get().load(SUBGALLERY[position][1]).fit().into(holder.image);

        convertView.setOnClickListener(e -> {
            Intent intent = new Intent(activity, GalleryActivity.class);
            intent.putExtra("category", category);
            activity.startActivity(intent);
        });
        return convertView;
    }
}
