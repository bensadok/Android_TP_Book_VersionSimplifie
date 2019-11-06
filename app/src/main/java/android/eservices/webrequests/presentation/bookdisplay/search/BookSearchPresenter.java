package android.eservices.webrequests.presentation.bookdisplay.search;

import android.eservices.webrequests.data.api.model.BookSearchResponse;
import android.eservices.webrequests.data.bookdisplay.BookDisplayService;
import android.eservices.webrequests.data.di.FakeDependencyInjection;
import android.eservices.webrequests.presentation.bookdisplay.search.mapper.BookToViewModelMapper;
import android.view.View;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static android.eservices.webrequests.BookApplication.API_KEY;

public class BookSearchPresenter implements BookSearchContract.Presenter {

    //private BookDisplayRepository bookDisplayRepository;
    private BookDisplayService bookDisplayService;
    private BookSearchContract.View view;
    private Single single;
    private BookToViewModelMapper bookToViewModelMapper;

    public BookSearchPresenter(BookToViewModelMapper bookToViewModelMapper) {//BookDisplayRepository bookDisplayRepository,  en param et enlever le bookdisplayservice
        //this.bookDisplayRepository = bookDisplayRepository;

        this.bookToViewModelMapper = bookToViewModelMapper;
    }

    @Override
    public void searchBooks(String keywords) {
        SingleObserver single = FakeDependencyInjection.getBookDisplayService().getBook(keywords,API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<BookSearchResponse>() {

                    @Override
                    public void onSuccess(BookSearchResponse bookSearchResponse) {
                        // work with the resulting todos
                        view.displayBooks(bookToViewModelMapper.map(bookSearchResponse.getBookList()));
                    }

                    @Override
                    public void onError(Throwable e) {
                        // handle the error case
                        System.out.println(e.toString());
                    }
                });

    }

    @Override
    public void attachView(BookSearchContract.View view) {
        this.view = view;
    }

    @Override
    public void cancelSubscription() {

    }

    @Override
    public void addBookToFavorite(String bookId) {

    }

    @Override
    public void removeBookFromFavorites(String bookId) {

    }

    @Override
    public void detachView() {

    }


}
