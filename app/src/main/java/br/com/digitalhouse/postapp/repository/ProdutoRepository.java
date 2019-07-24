package br.com.digitalhouse.postapp.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.postapp.model.Produto;
import io.reactivex.Observable;

public class ProdutoRepository {

    public Observable<List<Produto>> buscarListaPosts(){
        return Observable.create(emitter ->{
            List<Produto> produtoList = new ArrayList<>();
            Produto produto1 = new Produto();
            produto1.setNome("Café pequeno");
            produto1.setPreco(4);
            produtoList.add(produto1);

            Produto produto2 = new Produto();
            produto2.setNome("Café médio");
            produto2.setPreco(6);
            produtoList.add(produto2);

            Produto produto3 = new Produto();
            produto3.setNome("Café grande");
            produto3.setPreco(7);
            produtoList.add(produto3);

            emitter.onNext(produtoList);
            emitter.onComplete();

        });
    }
}
