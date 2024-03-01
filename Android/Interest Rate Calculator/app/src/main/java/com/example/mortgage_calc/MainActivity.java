package com.example.mortgage_calc;

import android.os.Bundle; // for saving state information
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.util.Log;
import android.widget.EditText; // for bill amount input
import android.widget.SeekBar; // for changing the tip percentage
import android.widget.SeekBar.OnSeekBarChangeListener; // SeekBar listener
import android.widget.TextView; // for displaying text

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.text.NumberFormat; // for currency formatting

// MainActivity class for the Mortgage Calculator app
public class MainActivity extends AppCompatActivity {

    // currency formatter objects
    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();

    private double purchaseAmount = 0.0; // stores purchase payment
    private double downPaymentAmount = 0.0; // stores down payment
    private double interestRate = 1.0; // stores yearly interest rate
    private double value = 0.0; // stores EditText value
    private int duration = 1; // stores seek bar progress

    private TextView durationTextView; // shows duration of seek bar
    private TextView paymentTextView; // shows payment from seek bar
    private TextView tenMonthTextView; // shows 10 month payment
    private TextView twentyMonthTextView; // shows 20 month payment
    private TextView thirtyMonthTextView; // shows 30 month payment

    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.activity_main); // inflate the GUI

        // get references to programmatically manipulated TextViews
        paymentTextView = (TextView) findViewById(R.id.paymentTextView);
        durationTextView = (TextView) findViewById(R.id.durationTextView);
        tenMonthTextView = (TextView) findViewById(R.id.tenMonthTextView);
        twentyMonthTextView = (TextView) findViewById(R.id.twentyMonthTextView);
        thirtyMonthTextView = (TextView) findViewById(R.id.thirtyMonthTextView);

        // set values for TextViews
        paymentTextView.setText(currencyFormat.format(0));
        tenMonthTextView.setText(currencyFormat.format(0));
        twentyMonthTextView.setText(currencyFormat.format(0));
        thirtyMonthTextView.setText(currencyFormat.format(0));
        durationTextView.setText("- Years");

        // set EditText's TextWatchers
        EditText purchaseEditText = (EditText) findViewById(R.id.purchaseEditText);
        purchaseEditText.addTextChangedListener(this.getTextWatcher("PP"));

        EditText downEditText = (EditText) findViewById(R.id.downEditText);
        downEditText.addTextChangedListener(this.getTextWatcher("DP"));

        EditText interestEditText = (EditText) findViewById(R.id.interestEditText);
        interestEditText.addTextChangedListener(this.getTextWatcher("IR"));

        // set seek bars OnSeekBarChangeListener
        SeekBar loanSeekBar =
                (SeekBar) findViewById(R.id.loanSeekBar);
        loanSeekBar.setOnSeekBarChangeListener(seekBarListener);
    }

    // calculate monthly payment amount
    private void calculate(int loanMonths, TextView paymentView) {
        double loanAmount = purchaseAmount - downPaymentAmount;

        double monthlyInterestRate = interestRate / 12.0;

        // Calculate the monthly mortgage payment
        double monthlyPayment = loanAmount * (monthlyInterestRate
                * Math.pow(1 + monthlyInterestRate, loanMonths))
                / (Math.pow(1 + monthlyInterestRate, loanMonths) - 1);

        // display tip and total formatted as currency
        paymentView.setText(currencyFormat.format(monthlyPayment));
    }

    // listener object for the SeekBar's progress changed events
    private final OnSeekBarChangeListener seekBarListener = new OnSeekBarChangeListener() {
                // update duration, then call calculate
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    duration = progress; // set duration to progress of seek bar
                    // display duration
                    durationTextView.setText(String.valueOf(duration) + " Years");
                    // calculate and display monthly payment
                    calculate(duration * 12, paymentTextView);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) { }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) { }
            };

    // listener object for the EditText's text-changed events
    public TextWatcher getTextWatcher(final String type) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    value = Double.parseDouble(s.toString());
                    if (type.equals("PP")) { // payment purchase amount
                        purchaseAmount = value;
                    } else if (type.equals("DP")) { // down payment amount
                        downPaymentAmount = value;
                    } else if (type.equals("IR")) { // interest rate amount
                        interestRate = value / 100.0;
                    }
                } catch (Exception e) {
                    Log.d("editWatchError", "onTextChanged: Error with EditTextWatcher");
                }

                // if there is a purchase and down payment amount, determine 10,20,
                // and 30 month payment
                if (purchaseAmount != 0.0 && downPaymentAmount != 0.0) {
                    calculate(10, tenMonthTextView);
                    calculate(20, twentyMonthTextView);
                    calculate(30, thirtyMonthTextView);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }
}