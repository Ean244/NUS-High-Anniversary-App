package edu.sg.nushigh.h1930006.anniversary.ui.suggestions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.FirebaseDatabase;

import edu.sg.nushigh.h1930006.anniversary.R;

public class SuggestionsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_suggestions, container, false);

        Button button = root.findViewById(R.id.button_submit_feedback);
        EditText input = root.findViewById(R.id.input_suggestions);
        RatingBar ratingBar = root.findViewById(R.id.rating_bar);

        button.setOnClickListener(e -> {
            if (ratingBar.getRating() == 0.0) {
                Snackbar.make(root, "Please provide a rating!", Snackbar.LENGTH_LONG).show();
                return;
            }
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            database.getReference("rating").push().setValue(ratingBar.getRating());

            if (!input.getText().toString().trim().equals("")) {
                database.getReference("suggestions").push().setValue(input.getText().toString().trim());
            }

            AlertDialog alertDialog = new AlertDialog.Builder(container.getContext()).setTitle("Success")
                    .setMessage("Your feedback has been recorded!")
                    .setIcon(R.drawable.ic_menu_feedback)
                    .setNeutralButton("OK", (dialog, which) -> {
                        ratingBar.setRating(0.0f);
                        input.getText().clear();
                        input.clearFocus();
                    }).create();
            alertDialog.show();
        });
        return root;
    }
}