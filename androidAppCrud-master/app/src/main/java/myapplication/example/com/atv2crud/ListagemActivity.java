package myapplication.example.com.atv2crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListagemActivity extends AppCompatActivity {

    List<Carro> carros = new ArrayList();
    ArrayAdapter adapter;
    ListView listViewCarros;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        db = openOrCreateDatabase("carro", Context.MODE_PRIVATE, null);

        listViewCarros = findViewById(R.id.lista);

        Cursor c = db.rawQuery("SELECT * FROM carros ORDER BY ano DESC", null);
        while (c.moveToNext()) {
            carros.add(new Carro(
                    c.getInt(0),        // id
                    c.getString(1),     // marca
                    c.getString(2),     // modelo
                    c.getString(3),     // placa
                    c.getString(4)));   // anao
        }

        adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                carros);

        adapter.notifyDataSetChanged();

        listViewCarros.setAdapter(adapter);

        listViewCarros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Carro carro = (Carro) listViewCarros.getItemAtPosition(position);


                Context context = getApplicationContext();
                CharSequence text = carro.retornaDados();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                Intent intent = new Intent(getApplicationContext(), DetalheActivity.class);
                intent.putExtra("objetoCarro", carro);
                startActivity(intent);
            }
        });

    }
}
