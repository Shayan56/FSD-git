package com.example.layouts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckBox pizza, waffle, pancakes, icecream, biryani, burger;
    Button btnTotalPrice;
    TextView textTotalPrice, textFinalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect all checkboxes to the XML layout
        pizza = findViewById(R.id.checkBoxPizza);
        waffle = findViewById(R.id.checkBoxWaffle);
        pancakes = findViewById(R.id.checkBoxPancakes);
        icecream = findViewById(R.id.checkBoxIcecream);
        biryani = findViewById(R.id.checkBoxBiryani);
        burger = findViewById(R.id.checkBoxBurger);

        // Connect the button and TextViews to their XML
        btnTotalPrice = findViewById(R.id.btnTotalPrice);
        textTotalPrice = findViewById(R.id.textTotalPrice);
        textFinalAmount = findViewById(R.id.textFinalAmount);

        // Set an onClickListener to handle the total price calculation
        btnTotalPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double totalPrice = 0;

                // Check each item and add their price if selected
                if (pizza.isChecked()) totalPrice += 100;
                if (waffle.isChecked()) totalPrice += 50;
                if (pancakes.isChecked()) totalPrice += 75;
                if (icecream.isChecked()) totalPrice += 60;
                if (biryani.isChecked()) totalPrice += 150;
                if (burger.isChecked()) totalPrice += 90;

                // Display total price
                textTotalPrice.setText("Rs. " + totalPrice);

                // Apply 15% discount
                double discount = totalPrice * 0.15;
                double finalAmount = totalPrice - discount;

                // Display final amount after discount
                textFinalAmount.setText("Final Amount: Rs. " + finalAmount);
            }
        });
    }
}
