package com.example.rauliyrjana.raulinlaskuri;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import static android.content.ContentValues.TAG;

public class Data {
    private String data;
    public Data(){
        data="";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Dataa pukkaa: "+data;
    }

    public void kirjoitaTiedostoon(Context ctx) {
        String filename = "myfile";
        FileOutputStream outputStream;
        try {
            outputStream = ctx.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(data.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "Kirjoitus ei onnistunut");
        }
    }
    public void lueTiedostosta(Context ctx) {

        String filename = "myfile";
        FileInputStream fis;
        StringBuilder sb=new StringBuilder("Laskentalogi:");
        try {
            fis=ctx.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            sb = new StringBuilder();
            String line;
            while((line=bufferedReader.readLine())!=null)
            {
                sb.append(line+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "Luku ei onnistunut");
        }
        data=sb.toString();
    }
}
