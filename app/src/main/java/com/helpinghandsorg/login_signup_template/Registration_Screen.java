package com.helpinghandsorg.login_signup_template;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;

import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Registration_Screen extends Fragment {
    private TextView welcome_text, welcome_des;
    private TextInputLayout fullname, password;
    private Button login, signup;

    public Registration_Screen() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        login = view.findViewById(R.id.login_btn);
        welcome_text = view.findViewById(R.id.textView);
        welcome_des = view.findViewById(R.id.textView2);
        fullname = view.findViewById(R.id.full_name);
        password = view.findViewById(R.id.confirm_password);
        signup = view.findViewById(R.id.signup_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                        .addSharedElement(signup, ViewCompat.getTransitionName(signup))
                        .addSharedElement(login, ViewCompat.getTransitionName(login))
                        .addSharedElement(welcome_text, ViewCompat.getTransitionName(welcome_text))
                        .addSharedElement(welcome_des, ViewCompat.getTransitionName(welcome_des))
                        .addSharedElement(fullname, ViewCompat.getTransitionName(fullname))
                        .addSharedElement(password, ViewCompat.getTransitionName(password)).build();
                NavHostFragment.findNavController(Registration_Screen.this).navigate(R.id.action_registration_Screen_to_login_Screen, null ,null, extras);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration__screen, container, false);
    }
}
