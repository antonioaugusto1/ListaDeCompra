package br.edu.ifsuldeminas.mch.listadecompra;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditListActivity extends AppCompatActivity {

    private EditText itemEditText;
    private EditText itemsAddedEditText;
    private Button addButton;
    private Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);

        itemEditText = findViewById(R.id.itemEditText);
        itemsAddedEditText = findViewById(R.id.itemsAddedEditText);
        addButton = findViewById(R.id.addButton);
        finishButton = findViewById(R.id.finishButton);

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
                }
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String finalItems = itemsAddedEditText.getText().toString();
                // TODO: Pass the finalItems data to the next activity or perform any desired action
            }
        });
    }
}
