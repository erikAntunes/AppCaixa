package br.com.digitalhouse.postapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import br.com.digitalhouse.postapp.R;
import br.com.digitalhouse.postapp.model.Produto;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder>{

    private List<Produto> produtoList = new ArrayList<>();

    public void updatePostList(List<Produto> produtoList){
        this.produtoList = produtoList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.produto_item_celula,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produto produto = produtoList.get(position);
        holder.bind(produto);

    }

    @Override
    public int getItemCount() {

        return produtoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView tituloTextView;
        private TextView precoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tituloTextView = itemView.findViewById(R.id.nome_produto_text_view_id);
            precoTextView = itemView.findViewById(R.id.preco_produto_text_view_id);
        }

        public void bind(Produto produto) {
            tituloTextView.setText(produto.getNome());
            precoTextView.setText("Preço: R$" + produto.getPreco());
        }
    }
}
