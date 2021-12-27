package com.example.smdlab._6_FileHandlingExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smdlab.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHandlingExampleMainActivity extends AppCompatActivity {
    String Filename = "MyFile";
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_handling_example_main);

        editText = findViewById(R.id.edtWriteFile);
        textView = findViewById(R.id.txtReadFile);


    }

    public void SaveToFile(View view)
    {
        String readData = editText.getText().toString();
        try {
            FileOutputStream outputStream = openFileOutput(Filename, Context.MODE_PRIVATE);
            outputStream.write(readData.getBytes());
            outputStream.close();
            editText.setText("");
            Snackbar.make(view, "Data Saved", Snackbar.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void ReadFromFile(View view)
    {
        String ReadFileData = "";
        try {
            FileInputStream inputStream = openFileInput(Filename);
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String currentData = bufferedReader.readLine();
            if (currentData == null) {
                Snackbar.make(view, "File is Empty", Snackbar.LENGTH_LONG).show();
            }
            else {
                while (currentData != null) {
                    ReadFileData = ReadFileData + currentData;
                    currentData = bufferedReader.readLine();
                }
                bufferedReader.close();
                streamReader.close();
                inputStream.close();
            }
            textView.setText(ReadFileData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}