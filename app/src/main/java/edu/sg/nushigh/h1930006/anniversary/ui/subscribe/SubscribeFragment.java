package edu.sg.nushigh.h1930006.anniversary.ui.subscribe;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.FirebaseDatabase;

import edu.sg.nushigh.h1930006.anniversary.R;

public class SubscribeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_subscribe, container, false);

        EditText emailField = root.findViewById(R.id.input_email);
        Button subscribeButton = root.findViewById(R.id.button_subscribe);

        subscribeButton.setOnClickListener(e -> {
            String input = emailField.getText().toString();
            if (!Patterns.EMAIL_ADDRESS.matcher(input).matches()) {
                emailField.setError("Invalid Email Format");
                return;
            }

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            database.getReference("newsletter").push().setValue(input);


            AlertDialog alertDialog = new AlertDialog.Builder(container.getContext()).setTitle("Success")
                    .setMessage("You are now registered to our newsletter!")
                    .setIcon(R.drawable.ic_menu_subscribe)
                    .setNeutralButton("OK", (dialog, which) -> {
                        emailField.getText().clear();
                        emailField.clearFocus();
                    }).create();
            alertDialog.show();
        });
        return root;
    }
}