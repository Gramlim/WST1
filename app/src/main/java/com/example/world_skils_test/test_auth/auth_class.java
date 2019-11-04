package com.example.world_skils_test.test_auth;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.example.world_skils_test.R;
import com.example.world_skils_test.main_class;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.yandex.runtime.Runtime.getApplicationContext;

public class auth_class extends DialogFragment{

    View view;
    EditText edUser;
    EditText edPswrd;
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        this.view = inflater.inflate(R.layout.auth, null);

        builder.setView(view);
        this.edUser = this.view.findViewById(R.id.log_ad);
        this.edPswrd = this.view.findViewById(R.id.pswrd_ad);
        Button log = view.findViewById(R.id.Login);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginService loginService =
                        ServGen.createService(LoginService.class, String.valueOf(edUser.getText()),
                                String.valueOf(edPswrd.getText()));
                Call<User> call = loginService.basicLogin();
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            Intent intent = new Intent(getActivity(), main_class.class);
                            startActivity(intent);
                        } else {

                        }
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d("Error", t.getMessage());
                    }
                });
            }
        });
        Button logout = view.findViewById(R.id.exit);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return builder.create();

    }
}