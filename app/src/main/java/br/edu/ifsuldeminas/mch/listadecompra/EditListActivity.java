package br.edu.ifsuldeminas.mch.listadecompra;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class EditListActivity extends AppCompatActivity {

    private EditText itemEditText;
    private EditText itemsAddedEditText;
    private Button addButton;
    private Button deleteButton;
    private Button finishButton;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);

        itemEditText = findViewById(R.id.addItemText);
        itemsAddedEditText = findViewById(R.id.itemsAdded);
        addButton = findViewById(R.id.addButton);
        deleteButton = findViewById(R.id.deleteButton);
        finishButton = findViewById(R.id.finishButton);
        backButton = findViewById(R.id.ic_back); // Adicionado

        backButton.setOnClickListener(new View.OnClickListener() { // Adicionado
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditListActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Opcional: Finalizar a atividade atual se não for mais necessária
            }

        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = itemEditText.getText().toString();
                String currentItems = itemsAddedEditText.getText().toString();

                if (!newItem.isEmpty()) {
                    if (!currentItems.isEmpty()) {
                        currentItems += "\n";
                    }
                    currentItems += newItem;
                    itemsAddedEditText.setText(currentItems);
                    itemEditText.setText("");
                } else {
                    Toast.makeText(EditListActivity.this, "Escreva o nome do item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentItems = itemsAddedEditText.getText().toString();

                if (!currentItems.isEmpty()) {
                    // Remove the last item
                    int lastItemIndex = currentItems.lastIndexOf('\n');
                    if (lastItemIndex >= 0) {
                        currentItems = currentItems.substring(0, lastItemIndex);
                    } else {
                        currentItems = "";
                    }
                    itemsAddedEditText.setText(currentItems);
                } else {
                    Toast.makeText(EditListActivity.this, "Não há itens para serem excluídos", Toast.LENGTH_SHORT).show();
                }
            }
        });


        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String finalItems = itemsAddedEditText.getText().toString();

                if (finalItems.isEmpty()) {
                    Toast.makeText(EditListActivity.this, "Não há itens na lista", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(EditListActivity.this, ShoppingListActivity.class);
                    intent.putExtra("items", finalItems);
                    startActivity(intent);
                }
            }
        });
    }
}
