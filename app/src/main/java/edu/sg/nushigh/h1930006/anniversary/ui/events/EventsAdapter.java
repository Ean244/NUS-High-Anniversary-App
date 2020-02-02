package edu.sg.nushigh.h1930006.anniversary.ui.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.sg.nushigh.h1930006.anniversary.R;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {
    private final int[][] EVENTS = new int[][]{
            new int[]{R.drawable.logo_formation, R.string.logo_formation, R.string.logo_formation_desc, R.string.logo_formation_date},
            new int[]{R.drawable.alumni_gathering, R.string.alumni_gathering, R.string.alumni_gathering_desc, R.string.alumni_gathering_date},
            new int[]{R.drawable.open_house, R.string.open_house, R.string.open_house_desc, R.string.open_house_date},
            new int[]{R.drawable.nanosat, R.string.nanosat, R.string.nanosat_desc, R.string.nanosat_date},
    };

    private Context context;

    public EventsAdapter(Context context) {
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title;
        public TextView description;
        public TextView date;

        public ViewHolder(@NonNull View itemView, ImageView image, TextView title, TextView description, TextView date) {
            super(itemView);
            this.image = image;
            this.title = title;
            this.description = description;
            this.date = date;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_events_element, parent, false);
        return new ViewHolder(view, view.findViewById(R.id.image_event), view.findViewById(R.id.text_event_title),
                view.findViewById(R.id.text_event_desc), view.findViewById(R.id.text_event_date));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageDrawable(context.getDrawable(EVENTS[position][0]));
        holder.title.setText(context.getString(EVENTS[position][1]));
        holder.description.setText(context.getString(EVENTS[position][2]));
        holder.date.setText(context.getString(EVENTS[position][3]));
    }

    @Override
    public int getItemCount() {
        return EVENTS.length;
    }
}
