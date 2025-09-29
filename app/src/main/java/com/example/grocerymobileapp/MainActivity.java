package com.example.grocerymobileapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.grocerymobileapp.Item;
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

        // Init lvOrderedItems

        // btnAddOnClick, get value from name, quantity and price
            // Turn input values into Item object

            // Add newItem to orderedItems

            // Update lvOrderedItems

        // btnComputeOnClick, iterate orderedItems to get totalPrice
            // Display in tvTotalPrice

        // btnClearOnClick, clear orderedItems
            // Clear lvOrderedItems
    }
}