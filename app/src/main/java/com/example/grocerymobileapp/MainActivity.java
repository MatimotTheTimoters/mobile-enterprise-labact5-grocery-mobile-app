package com.example.grocerymobileapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.grocerymobileapp.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etItemName, etQuantity, etPrice;
    ListView lvOrderedItems;
    TextView tvTotalPrice;
    List<Item> orderedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get IDs
        etItemName = (EditText) findViewById(R.id.etItemName);
        etQuantity = (EditText) findViewById(R.id.etQuantity);
        etPrice = (EditText) findViewById(R.id.etPrice);
        lvOrderedItems = (ListView) findViewById(R.id.lvOrderedItems);
        tvTotalPrice = (TextView) findViewById(R.id.tvTotalPrice);

        // Init orderedItems as ArrayList
        orderedItems = new ArrayList<>();

        // Init lvOrderedItems (can also be used to update when btnAddOnClick)
        ArrayAdapter<Item> itemAdapter;
        itemAdapter = new ArrayAdapter<Item>(this, R.layout.item_row, orderedItems);
        lvOrderedItems.setAdapter(itemAdapter);

        // btnAddOnClick
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(view -> {
            // Get value from name, quantity and price

            // Turn input values into Item object

            // Add newItem to orderedItems

            // Update lvOrderedItems

        });

        // btnComputeOnClick
        Button btnCompute = (Button) findViewById(R.id.btnCompute);
        btnCompute.setOnClickListener(view -> {
            // Iterate orderedItems to get totalPrice

            // Display in tvTotalPrice
        });

        // btnClearOnClick
        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(view -> {
            // Clear orderedItems

            // Clear lvOrderedItems
        });
    }
}