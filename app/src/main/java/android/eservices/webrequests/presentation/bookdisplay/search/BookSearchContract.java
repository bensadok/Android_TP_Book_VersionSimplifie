package android.eservices.webrequests.presentation.bookdisplay.search;

import android.eservices.webrequests.presentation.bookdisplay.search.adapter.BookItemViewModel;

import java.util.List;

public interface BookSearchContract {

    interface View {
        void displayBooks(List<BookItemViewModel> bookItemViewModelList);

        void onBookAddedToFavorites();

        void onBookRemovedFromFavorites();
    }

    interface Presenter {
        void searchBooks(String keywords);

        void attachView(View view);

        void cancelSubscription();

        void addBookToFavorite(String bookId);

        void removeBookFromFavorites(String bookId);

        void detachView();
    }
}
