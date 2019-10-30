package myapplication.example.com.atv2crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class InserirActivity extends AppCompatActivity {

    EditText marca;
    EditText modelo;
    EditText placa;
    EditText ano;


    Button btnInserir;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);

        db = openOrCreateDatabase("carro", Context.MODE_PRIVATE, null);

        // Cria a tabela se não existir, senão carrega a tabela para uso
        db.execSQL("CREATE TABLE IF NOT EXISTS carros(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "marca VARCHAR NOT NULL, " +
                "modelo VARCHAR NOT NULL, " +
                "placa VARCHAR NOT NULL, " +
                "ano VARCHAR NOT NULL);");

        marca = findViewById(R.id.marcaPt);
        modelo = findViewById(R.id.modeloPt);
        placa = findViewById(R.id.placaPt);
        ano = findViewById(R.id.anoPt);


        btnInserir = findViewById(R.id.inserirBtn);
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Carro carro = new Carro(
                        placa.getText().toString(),
                        marca.getText().toString(),
                        modelo.getText().toString(),
                        ano.getText().toString()
                );
                ContentValues values = new ContentValues();
                values.put("marca", marca.getText().toString());
                values.put("modelo", modelo.getText().toString());
                values.put("placa",  placa.getText().toString());
                values.put("ano", ano.getText().toString());

                //Log.d("xx::", values.toString());

                db.insert("carros", null, values);

//                Message message = new Message(Insert.this);
//                message.show(
//                        "Dados incluídos com sucesso!",
//                        aluno.getDados(),
//                        R.drawable.ic_add);
//
//                // Limpa os campos de entrada
                clearText();
            }
        });

    }

    public void clearText() {
        marca.setText("");
        modelo.setText("");
        placa.setText("");
        ano.setText("");
    }
}
