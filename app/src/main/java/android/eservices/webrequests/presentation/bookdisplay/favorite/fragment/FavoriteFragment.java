package android.eservices.webrequests.presentation.bookdisplay.favorite.fragment;

import android.eservices.webrequests.R;
import android.eservices.webrequests.presentation.bookdisplay.favorite.adapter.BookDetailActionInterface;
import android.eservices.webrequests.presentation.bookdisplay.favorite.adapter.BookDetailAdapter;
import android.eservices.webrequests.presentation.bookdisplay.favorite.adapter.BookDetailViewModel;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoriteFragment extends Fragment implements BookDetailActionInterface {

    public static final String TAB_NAME = "Favorites";
    private View rootView;
    private RecyclerView recyclerView;
    private BookDetailAdapter bookAdapter;

    private FavoriteFragment() {
    }

    public static FavoriteFragment newInstance() {
        return new FavoriteFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(R.layout.fragment_favorites, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupRecyclerView();

    }

    private void setupRecyclerView() {
        recyclerView = rootView.findViewById(R.id.recycler_view);
        bookAdapter = new BookDetailAdapter(this);
        recyclerView.setAdapter(bookAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    //TODO
    //@Override
    public void displayFavorites(List<BookDetailViewModel> bookDetailViewModelList) {
        bookAdapter.bindViewModels(bookDetailViewModelList);

    }

    @Override
    public void onRemoveFavorite(String bookId) {
        //TODO : bookFavoritePresenter.removeBookFromFavorites(bookId);
        System.out.println("Remove book " + bookId);
    }

    //TODO
    //@Override
    public void onBookRemoved() {
        //Do nothing yet
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //TODO : bookFavoritePresenter.detachView();
    }
}
