package br.edu.ifsuldeminas.mch.listadecompra;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EditListActivity extends AppCompatActivity {
    private EditText itemEditText;
    private List<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);

        itemEditText = findViewById(R.id.itemEditText);
        Button addButton = findViewById(R.id.addButton);

        itemList = new ArrayList<>();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = itemEditText.getText().toString();
                if (!item.isEmpty()) {
                    addItemToList(item);
                    itemEditText.setText("");
                }
            }
        });
    }

    private void addItemToList(String item) {
        itemList.add(item);
    }
}


