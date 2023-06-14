package br.edu.ifsuldeminas.mch.listadecompra;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListActivity extends AppCompatActivity {
    private List<String> shoppingItems;
    private LinearLayout shoppingItemsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        shoppingItemsLayout = findViewById(R.id.shoppingItemsLayout);

        shoppingItems = new ArrayList<>();

        // Exemplo de itens de compra
        shoppingItems.add("Maçã");
        shoppingItems.add("Banana");
        shoppingItems.add("Leite");

        for (String item : shoppingItems) {
            addShoppingItem(item);
        }
    }

    private void addShoppingItem(String item) {
        TextView itemTextView = new TextView(this);
        itemTextView.setText(item);
        shoppingItemsLayout.addView(itemTextView);
    }
}
