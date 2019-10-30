package myapplication.example.com.atv2crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    Button btnListar;
    Button btnPesquisar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListar = findViewById(R.id.listarBtn);

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insert = new Intent(getApplicationContext(), ListagemActivity.class);
                startActivity(insert);
            }
        });

        btnInsert = findViewById(R.id.inserirBtn);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insert = new Intent(getApplicationContext(), InserirActivity.class);
                startActivity(insert);
            }
        });

        btnPesquisar = findViewById(R.id.pesquisarBtn);
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent insert = new Intent(getApplicationContext(), PesquisarActivity.class);
                startActivity(insert);
            }
        });


//        btExit = findViewById(R.id.btMainExit);
//        btExit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Finaliza a aplicação e remove da pilha
//                finishAffinity();
//            }
//        });
    }
}
