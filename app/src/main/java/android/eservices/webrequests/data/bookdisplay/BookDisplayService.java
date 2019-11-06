package android.eservices.webrequests.data.bookdisplay;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public  interface BookDisplayService {
    //@GET("volumes?q=search+{name}&key={key}")
    //Single<BookSearchResponse> getBook(@Path("name") String name,@Path("key") String key);
    @GET("volumes")
    Single<BookSearchResponse> getBook(@Query("q") String name,@Query("key") String key);
}
