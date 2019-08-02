package c346.rp.edu.sg.demodynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner numType, number;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;
    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numType = findViewById(R.id.spinner);
        number = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.btnUpdate);
        alNumbers = new ArrayList<>();
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alNumbers);

        number.setAdapter(aaNumbers);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = numType.getSelectedItemPosition();
                alNumbers.clear();
                if(pos == 0){
                    strNumbers = getResources().getStringArray(R.array.even_numbers);
                }
                else {
                    strNumbers = getResources().getStringArray(R.array.odd_numbers);
                }
            }
        });

        numType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        strNumbers = getResources().getStringArray(R.array.even_numbers);
                        break;
                    case 1:
                        strNumbers = getResources().getStringArray(R.array.odd_numbers);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        alNumbers.addAll(Arrays.asList(strNumbers));

    }
}
