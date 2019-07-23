package br.com.digitalhouse.postapp.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.postapp.model.Post;
import io.reactivex.Observable;

public class PostRepository {

    public Observable<List<Post>> buscarListaPosts(){
        return Observable.create(emitter ->{
            List<Post> postList = new ArrayList<>();
            Post post1 = new Post();
            post1.setTitulo("Novos cursos no segundo semestre");
            post1.setDescricao("A Digital House já começou os cursos do segundo semestre.");
            postList.add(post1);

            Post post2 = new Post();
            post2.setTitulo("Digital Summit foi um sucesso");
            post2.setDescricao("Muitas Palestras no Digital House Summit 2019");
            postList.add(post2);

            Post post3 = new Post();
            post3.setTitulo("Mais mulheres na programação");
            post3.setDescricao("A Digital House disponibiliza 100 bolsas para mulheres nos cursos de programação");
            postList.add(post3);

            emitter.onNext(postList);
            emitter.onComplete();

        });
    }
}
