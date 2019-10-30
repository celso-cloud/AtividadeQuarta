package myapplication.example.com.atv2crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PesquisarActivity extends AppCompatActivity {

    EditText pesquisar;
    Button btnPesquisar;

    SQLiteDatabase db;

    Carro carro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);

        pesquisar = findViewById(R.id.pesquisarPt);
        btnPesquisar = findViewById(R.id.pesquisarBtn);

        db = openOrCreateDatabase("carro", Context.MODE_PRIVATE, null);


        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String busca = pesquisar.getText().toString();

                Cursor c = db.rawQuery("SELECT * FROM carros WHERE modelo = ? COLLATE NOCASE", new String[] { busca });
                while (c.moveToNext()) {
                     carro = new Carro(
                            c.getInt(0),
                            c.getString(1),
                            c.getString(2),
                            c.getString(3),
                            c.getString(4));
                }
                if(carro != null) {
                    Intent intent = new Intent(getApplicationContext(), DetalheActivity.class);
                    intent.putExtra("objetoCarro", carro);
                    startActivity(intent);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "Carro não encontrado.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });
    }
}
