package br.com.digitalhouse.postapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AdicionarProdutoActivity extends AppCompatActivity {

    private FloatingActionButton voltarActionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_produto);

        voltarActionButton = findViewById(R.id.floating_voltar_cantina_button);
        voltarActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaCantina();
            }
        });
    }

    private void irParaCantina() {
        Intent intent = new Intent(this,CantinaActivity.class);
        startActivity(intent);
    }
}
