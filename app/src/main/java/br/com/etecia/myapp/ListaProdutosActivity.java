package br.com.etecia.myapp;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListaProdutosActivity extends AppCompatActivity {

    RecyclerView idListaProdutos;
    List<Produtos> lstProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.lista_produtos_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //criando um array que vai carregar a lista de produtos
        lstProdutos = new ArrayList<>();
        lstProdutos.add(new Produtos("Mouse",R.drawable.mousejogo));
        lstProdutos.add(new Produtos("Teclado",R.drawable.teclado));
        lstProdutos.add(new Produtos("VolanteAcessorio",R.drawable.volanteacessorio));
        lstProdutos.add(new Produtos("Videogame",R.drawable.videogame));
        lstProdutos.add(new Produtos("Suporte",R.drawable.suportepara));
        lstProdutos.add(new Produtos("Fone",R.drawable.fone));
        lstProdutos.add(new Produtos("Jogo",R.drawable.jogo));
        lstProdutos.add(new Produtos("Carregador",R.drawable.carregador));
        lstProdutos.add(new Produtos("Console",R.drawable.console));
        lstProdutos.add(new Produtos("Controle",R.drawable.controle_videogame));

        idListaProdutos = findViewById(R.id.ListaProdutos);

        //Criando layout
        idListaProdutos.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        //Instânciar o adaptador
        AdaptadorProdutos adapter = new AdaptadorProdutos(getApplicationContext(),lstProdutos);

        idListaProdutos.setAdapter(adapter);

    }
}