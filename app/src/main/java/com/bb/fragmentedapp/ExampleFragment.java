package com.bb.fragmentedapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ExampleFragment extends Fragment {

    ExampleFragmentDelegate delegate;
    Button clickButton;

    public interface ExampleFragmentDelegate {

        void communicateToSecond(String message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_example_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        clickButton = view.findViewById(R.id.button);

        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sendMessage();

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        delegate = (MainActivity)context;
    }

    public void sendMessage() {
        delegate.communicateToSecond("Hello, from first..");
//        ((ExampleFragmentDelegate)getContext()).communicateToSecond("");
    }



}
