package com.example.wordcounter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private Spinner countTypeSpinner;
    private Button countButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        countTypeSpinner = findViewById(R.id.countTypeSpinner);
        countButton = findViewById(R.id.countButton);
        resultText = findViewById(R.id.resultText);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.count_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countTypeSpinner.setAdapter(adapter);

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputText.getText().toString();

                if (text.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Input field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                String countType = countTypeSpinner.getSelectedItem().toString();

                TextCounter counter = new TextCounter();

                int result;
                if (countType.equals("Words")) {
                    result = counter.getWordsCount(text);
                } else {
                    result = counter.getCharacterCount(text);
                }

                resultText.setText("Result: " + result);
            }
        });
    }
}

