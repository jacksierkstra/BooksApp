package com.jacksierkstra.booksapp.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jacksierkstra.booksapp.R;
import com.jacksierkstra.booksapp.models.Book;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BookAddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookAddFragment extends Fragment {



    private OnFragmentInteractionListener mListener;

    EditText titleTextField;
    EditText isbnTextField;
    Button   submitBtn;
    Button resetBtn;

    public static BookAddFragment newInstance() {
        BookAddFragment fragment = new BookAddFragment();
        return fragment;
    }

    public BookAddFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book_add, container, false);

        titleTextField = (EditText) view.findViewById(R.id.titleTxt);
        isbnTextField = (EditText) view.findViewById(R.id.isbnTxt);
        submitBtn = (Button) view.findViewById(R.id.submitBtn);
        resetBtn = (Button)view.findViewById(R.id.resetBtn);

        submitBtn.setOnClickListener((View v) -> {
            addBook(titleTextField.getText().toString(), isbnTextField.getText().toString());
        });

        resetBtn.setOnClickListener((View v) -> {
            resetFields((ViewGroup)view);
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void resetFields(ViewGroup container) {
        View firstEdit = null;
        for(int i = 0, count = container.getChildCount(); i < count; i++) {
            View v  = container.getChildAt(i);
            if(v instanceof EditText) {
                if(firstEdit == null)
                    firstEdit = v;
                ((EditText) v).setText("");
            }
            Toast.makeText(getActivity().getBaseContext(), "Shit has been cleared yo!", Toast.LENGTH_SHORT).show();
        }
        if(firstEdit instanceof EditText) {
            firstEdit.requestFocus();
        }
    }

    private void addBook(String title, String isbn) {

        if(title.trim().isEmpty() || isbn.trim().isEmpty()) {
            Toast.makeText(getActivity().getBaseContext(), "Please fill in both fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Book book = new Book(title, isbn);
        book.save();

        titleTextField.setText("");
        isbnTextField.setText("");

        Toast.makeText(getActivity().getBaseContext(), String.format("Book with title: %s and ISBN: %s has been added to the list!", title, isbn), Toast.LENGTH_SHORT).show();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
