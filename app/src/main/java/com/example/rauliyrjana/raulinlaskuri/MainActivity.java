package com.example.rauliyrjana.raulinlaskuri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Data data;
    private TextView textViewLogi;
    String msg = "Laskuri: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(msg, "Ohjelma kÃ¤ynnistyy");
        setContentView(R.layout.activity_main);
        data = new Data();
        textViewLogi = findViewById(R.id.textViewLogi);
        data.lueTiedostosta(this);
    }

    /**
     * kun kÃ¤yttÃ¤jÃ¤ painaa jotain Laske -napeista, niin...
     */
    public void onClick(View a) {
        String TAG = "ANTURA: ";
        MainActivity.class.getSimpleName();

        if (a.getId() == R.id.Badd) { // jos nappi on + -rivillä
            System.out.println("lasketaan plussaa");
            EditText a1 = (EditText) findViewById(R.id.number1);
            EditText a2 = (EditText) findViewById(R.id.number2);

            double num1, num2;
            num1 = Integer.parseInt(a1.getText().toString());
            num2 = Integer.parseInt(a2.getText().toString());

            double ans = num1 + num2; // lasketaan num1 ja num2 yhteen

            TextView t = (TextView) findViewById((R.id.result)); //viedään resultti -nappiin
            t.setText("" + ans); // jossa asetetaan teksti ans

            String lause = num1 + "+" + num2 + "=" + ans;
            String tmp = data.getData() + "\n" + lause;// lisÃ¤tÃ¤Ã¤n dataan uusi rivi
            data.setData(tmp);
            textViewLogi.setText(data.getData());

            Log.d(TAG, "PLUSSAA");
        }
        if (a.getId() == R.id.Bsub) {
            EditText a1 = (EditText) findViewById(R.id.number3);
            EditText a2 = (EditText) findViewById(R.id.number4);

            double num1, num2;
            num1 = Double.parseDouble(a1.getText().toString());
            num2 = Double.parseDouble(a2.getText().toString());

            double ans = num1 - num2;

            TextView t = (TextView) findViewById((R.id.result2));
            t.setText("" + ans);
            String lause = num1 + "-" + num2 + "=" + ans;
            String tmp = data.getData() + "\n" + lause;
            data.setData(tmp);
            textViewLogi.setText(data.getData());

            Log.d(TAG, "MIINUSTAA");

        }
        if (a.getId() == R.id.Bmul) {
            EditText a1 = (EditText) findViewById(R.id.number5);
            EditText a2 = (EditText) findViewById(R.id.number6);

            double num1, num2;
            num1 = Double.parseDouble(a1.getText().toString());
            num2 = Double.parseDouble(a2.getText().toString());

            double ans = num1 * num2;

            TextView t = (TextView) findViewById((R.id.result3));
            t.setText("" + ans);
            String lause = num1 + "*" + num2 + "=" + ans;
            String tmp = data.getData() + "\n" + lause;
            data.setData(tmp);
            textViewLogi.setText(data.getData());
            Log.d(TAG, "KERTOO");
        }
        if (a.getId() == R.id.Bdiv) {
            EditText a1 = (EditText) findViewById(R.id.number7);
            EditText a2 = (EditText) findViewById(R.id.number8);

            double num1, num2;
            num1 = Double.parseDouble(a1.getText().toString());
            num2 = Double.parseDouble(a2.getText().toString());

            double ans = num1 / num2;

            TextView t = (TextView) findViewById((R.id.result4));
            t.setText("" + ans);
            String lause = num1 + "/" + num2 + "=" + ans;
            String tmp = data.getData() + "\n" + lause;
            data.setData(tmp);
            textViewLogi.setText(data.getData());
            Log.d(TAG, "JAKAA");
        }
        if (a.getId() == R.id.ClearAll) {
            EditText a1 = (EditText) findViewById(R.id.number1);
            EditText a2 = (EditText) findViewById(R.id.number2);
            EditText a3 = (EditText) findViewById(R.id.number3);
            EditText a4 = (EditText) findViewById(R.id.number4);
            EditText a5 = (EditText) findViewById(R.id.number5);
            EditText a6 = (EditText) findViewById(R.id.number6);
            EditText a7 = (EditText) findViewById(R.id.number7);
            EditText a8 = (EditText) findViewById(R.id.number8);
            a1.setText("");
            a2.setText("");
            a3.setText("");
            a4.setText("");
            a5.setText("");
            a6.setText("");
            a7.setText("");
            a8.setText("");

            TextView t1 = (TextView) findViewById((R.id.result));
            TextView t2 = (TextView) findViewById((R.id.result2));
            TextView t3 = (TextView) findViewById((R.id.result3));
            TextView t4 = (TextView) findViewById((R.id.result4));
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        }
        if (a.getId() == R.id.NaytaLogi) {
            textViewLogi.setText(data.getData());
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println();
        data.kirjoitaTiedostoon(this);
    }
}



