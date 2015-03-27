package com.jacksierkstra.booksapp.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jacksierkstra.booksapp.R;
import com.jacksierkstra.booksapp.models.Book;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BookOverviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookOverviewFragment extends Fragment {


    private OnFragmentInteractionListener mListener;


    ListView booksList;
    List<Book> books;
    ArrayAdapter<Book> booksAdapter;

    public static BookOverviewFragment newInstance() {
        BookOverviewFragment fragment = new BookOverviewFragment();
        return fragment;
    }

    public BookOverviewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book_overview, container, false);

        booksList = (ListView) view.findViewById(R.id.booksListView);
        books = Book.listAll(Book.class);
        booksAdapter = new ArrayAdapter<Book>(getActivity(), android.R.layout.simple_list_item_1, books);
        booksList.setAdapter(booksAdapter);

        // Inflate the layout for this fragment
        return view;
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
