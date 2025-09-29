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
import com.example.grocerymobileapp.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etItemName, etQuantity, etPrice;
    ListView lvOrderedItems;
    TextView tvTotalPrice;
    List<Item> orderedItems;
    ArrayAdapter<Item> itemAdapter;

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
        assignIDs();

        // Init orderedItems as ArrayList
        orderedItems = new ArrayList<>();

        // Init lvOrderedItems (can also be used to update when btnAddOnClick)
        setListAdapter();

        // Set onClick event listeners
        setOnClickListeners();
    }

    public void assignIDs() {
        etItemName = (EditText) findViewById(R.id.etItemName);
        etQuantity = (EditText) findViewById(R.id.etQuantity);
        etPrice = (EditText) findViewById(R.id.etPrice);
        lvOrderedItems = (ListView) findViewById(R.id.lvOrderedItems);
        tvTotalPrice = (TextView) findViewById(R.id.tvTotalPrice);
    }

    public void clearInputFields() {
        etItemName.setText("");
        etQuantity.setText("");
        etPrice.setText("");
    }

    public void setOnClickListeners() {
        // btnAddOnClick
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(view -> {
            // Get value from name, quantity and price
            String itemName = etItemName.getText().toString();
            int quantity = Integer.parseInt(etQuantity.getText().toString());
            double price = Double.parseDouble(etPrice.getText().toString());

            // Turn input values into Item object
            Item newItem = new Item(itemName, quantity, price);

            // Add newItem to orderedItems
            orderedItems.add(newItem);

            // Update lvOrderedItems
            setListAdapter();

            // Clear input
            clearInputFields();
        });

        // btnComputeOnClick
        Button btnCompute = (Button) findViewById(R.id.btnCompute);
        btnCompute.setOnClickListener(view -> {
            double totalPrice = 0.0;

            // Iterate orderedItems to get totalPrice
            for (Item currentItem : orderedItems) {
                // Get price and quantity for each item
                int quantity = currentItem.getQuantity();
                double price = currentItem.getPrice();

                // Compute to get itemTotalPrice
                double itemTotalPrice = quantity * price;

                // Append to totalPrice
                totalPrice += itemTotalPrice;
            }

            // Display in tvTotalPrice
            tvTotalPrice.setText(String.valueOf(totalPrice));
        });

        // btnClearOnClick
        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(view -> {
            // Clear orderedItems
            orderedItems.clear();

            // Clear lvOrderedItems
            setListAdapter();

            // Clear totalPrice
            tvTotalPrice.setText("0.0");
        });
    }

    public void setListAdapter() {
        itemAdapter = new ItemAdapter(this, R.layout.item_row, (ArrayList<Item>) orderedItems);
        lvOrderedItems.setAdapter(itemAdapter);
    }
}