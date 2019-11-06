package android.eservices.webrequests.presentation.bookdisplay.favorite;

import android.eservices.webrequests.presentation.bookdisplay.favorite.adapter.BookDetailViewModel;

import java.util.List;

public interface BookFavoriteContract {

    interface View {
        void displayFavorites(List<BookDetailViewModel> bookDetailViewModelList);

        void onBookRemoved();
    }

    interface Presenter {
        void attachView(View view);

        void getFavorites();

        void removeBookFromFavorites(String bookId);

        void detachView();
    }
}
