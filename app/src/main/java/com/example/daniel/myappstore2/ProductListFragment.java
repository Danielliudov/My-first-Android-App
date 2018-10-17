package com.example.daniel.myappstore2;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment implements AdapterView.OnItemClickListener, SearchView.OnQueryTextListener{

    private ListView mProductsList;
    private ArrayAdapter<String> mProductsAdapter;
    private SearchView searchView;
    private String[] values = {"Apple", "Samsung", "Blackberry", "Oppo", "Oneplus"};
    public ProductListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);



        mProductsList = view.findViewById(R.id.lv_products);
        searchView = view.findViewById(R.id.searchView);

        mProductsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, values);

        mProductsList.setAdapter(mProductsAdapter);

        mProductsList.setOnItemClickListener(this);
        searchView.setOnQueryTextListener(this);
        return view;
    }
    @Override
    public void onItemClick (AdapterView < ? > adapterView, View view,int i, long l){
        Toast.makeText(getContext(), mProductsAdapter.getItem(i), Toast.LENGTH_SHORT).show();
    }
    public static ProductListFragment newInstance () {
        return new ProductListFragment();
    }
    @Override
    public boolean onQueryTextSubmit (String query){
        return false;
    }

    @Override
    public boolean onQueryTextChange (String newText){
        String text = newText;
        mProductsAdapter.getFilter().filter(text);
        return false;
    }

    public static class newInstance extends ProductListFragment {

    }
}
