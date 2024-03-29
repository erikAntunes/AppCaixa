package br.com.digitalhouse.postapp.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import br.com.digitalhouse.postapp.model.Produto;
import br.com.digitalhouse.postapp.repository.ProdutoRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ProdutoViewModel extends AndroidViewModel {

    private MutableLiveData<List<Produto>> postsLiveData = new MutableLiveData<>();

    private ProdutoRepository repository = new ProdutoRepository();
    private CompositeDisposable disposable = new CompositeDisposable();

    public ProdutoViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Produto>> getPostLiveData() {
        return postsLiveData;
    }

    public void atualizarPosts() {
        disposable.add(
                repository.buscarListaPosts()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(postList -> postsLiveData.setValue(postList))
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
