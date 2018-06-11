package com.example.sain.notes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText editText;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editText = findViewById(R.id.editText);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", -1);
        if (position != -1) {
            editText.setText(MainActivity.arrayList.get(position));
        } else {
            finish();
        }

        editText.setSelection(editText.getText().length());
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }
    }

    @Override
    public void onBackPressed() {
        MainActivity.arrayList.set(position, editText.getText().toString());
        super.onBackPressed();
    }
}
