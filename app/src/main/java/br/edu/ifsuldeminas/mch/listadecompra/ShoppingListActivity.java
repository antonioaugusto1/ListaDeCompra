package br.edu.ifsuldeminas.mch.listadecompra;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShoppingListActivity extends AppCompatActivity {

    private LinearLayout itemsLayout;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        itemsLayout = findViewById(R.id.itemsLayout);
        backButton = findViewById(R.id.backButton);

        // Obter a lista de itens da atividade anterior
        String items = getIntent().getStringExtra("items");

        // Verificar se existem itens
        if (items != null && !items.isEmpty()) {
            String[] itemList = items.split("\n");

            // Adicionar os itens ao layout
            for (String item : itemList) {
                addItemToLayout(item);
            }
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Voltar para a tela EditListActivity
                Intent intent = new Intent(ShoppingListActivity.this, EditListActivity.class);
                startActivity(intent);
                finish(); // Opcional: Finalizar a atividade atual se não for mais necessária
            }
        });
    }

    private void addItemToLayout(String item) {
        TextView textView = new TextView(this);
        textView.setText(item);
        textView.setTextSize(16);
        textView.setPadding(0, 8, 0, 8);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView clickedTextView = (TextView) v;
                // Alterar o estilo do texto quando clicado (marcar como concluído)
                if ((clickedTextView.getPaintFlags() & Paint.STRIKE_THRU_TEXT_FLAG) > 0) {
                    clickedTextView.setPaintFlags(clickedTextView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                } else {
                    clickedTextView.setPaintFlags(clickedTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
            }
        });
        itemsLayout.addView(textView);
    }
}
