package myapplication.example.com.atv2crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetalheActivity extends AppCompatActivity {

    EditText id;
    EditText marca;
    EditText modelo;
    EditText placa;
    EditText ano;
    Carro carro;

    Button btnSalvar;
    Button btnExcluir;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);



        Intent intent = getIntent();
        carro = (Carro) intent.getExtras().getSerializable("objetoCarro");


        db = openOrCreateDatabase("carro", Context.MODE_PRIVATE, null);


        id = findViewById(R.id.idPt);
        marca = findViewById(R.id.marcaPt);
        modelo = findViewById(R.id.modeloPt);
        placa = findViewById(R.id.placaPt);
        ano = findViewById(R.id.anoPt);

        id.setText(String.valueOf(carro.getId()));
        marca.setText(carro.getMarca());
        modelo.setText(carro.getModelo());
        placa.setText(carro.getPlaca());
        ano.setText(carro.getAno());

        btnExcluir = findViewById(R.id.excluirBtn);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(carro != null) {

                    Context context = getApplicationContext();
                    CharSequence text = "Carro " + carro.toString() + " deletado com sucesso!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    db.delete("carros", "id=?", new String[]{String.valueOf(carro.getId())});
                    finish();
                }

            }
        });

        btnSalvar = findViewById(R.id.salvarBtn);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(carro != null) {

                    ContentValues values = new ContentValues();
                    values.put("marca", carro.getMarca());
                    values.put("modelo", carro.getModelo());
                    values.put("placa", carro.getPlaca());
                    values.put("ano", carro.getAno());


                    Context context = getApplicationContext();
                    CharSequence text = "Carro atualizado com sucesso!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    db.update("carros", values, "id=?" , new String[]{String.valueOf(carro.getId())});
                    finish();
                }

            }
        });

    }
}
