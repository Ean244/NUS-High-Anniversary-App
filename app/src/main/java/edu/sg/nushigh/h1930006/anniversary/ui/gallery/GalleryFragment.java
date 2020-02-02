package edu.sg.nushigh.h1930006.anniversary.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import edu.sg.nushigh.h1930006.anniversary.R;

public class GalleryFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        ListView gallery = root.findViewById(R.id.list_gallery);
        gallery.setAdapter(new GalleryAdapter(getActivity()));
        return root;
    }

}