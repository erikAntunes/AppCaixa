package br.com.digitalhouse.postapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.digitalhouse.postapp.adapter.ProdutoAdapter;
import br.com.digitalhouse.postapp.viewmodel.ProdutoViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CantinaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProdutoAdapter produtoAdapter = new ProdutoAdapter();
    private ProdutoViewModel produtoViewModel;
    private FloatingActionButton floatingActionAdicionarButton;
    private FloatingActionButton floatingActionCarrinhoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantina);

        recyclerView = findViewById(R.id.posts_recycler_view);

        recyclerView.setAdapter(produtoAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        floatingActionAdicionarButton = findViewById(R.id.floating_adicionar_produto_button);
        floatingActionAdicionarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaAdicionarProduto();
            }
        });


        floatingActionCarrinhoButton = findViewById(R.id.floating_carrinho_button);
        floatingActionCarrinhoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaCarrinho();
            }
        });



        produtoViewModel = ViewModelProviders.of(this).get(ProdutoViewModel.class);

        produtoViewModel.atualizarPosts();

        produtoViewModel.getPostLiveData()
                .observe(this,postList -> {
                    produtoAdapter.updatePostList(postList);
                });



    }
    public void irParaAdicionarProduto(){
        Intent intent = new Intent(this, AdicionarProdutoActivity.class);
        startActivity(intent);
    }

    public void irParaCarrinho(){
        Intent intent = new Intent(this,CarrinhoActivity.class);
        startActivity(intent);
    }


}
