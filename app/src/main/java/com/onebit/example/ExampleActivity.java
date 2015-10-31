package com.onebit.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.onebit.spinner2.Spinner2;

public class ExampleActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvLabel;
    private Spinner2 spinner;
    private Button btnThreeNoAction, btnFive, btnNine, btnNineNoAction;
    private CheckBox cbReloadAdapter;
    private String[] spinnerArr = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        tvLabel = (TextView) findViewById(R.id.tv_label);
        spinner = (Spinner2) findViewById(R.id.spinner);
        btnThreeNoAction = (Button) findViewById(R.id.btn_select_three_no_action);
        btnFive = (Button) findViewById(R.id.btn_select_five);
        btnNine = (Button) findViewById(R.id.btn_select_nine);
        btnNineNoAction = (Button) findViewById(R.id.btn_select_nine_no_action);
        cbReloadAdapter = (CheckBox) findViewById(R.id.cb_reload_adapter);

        btnThreeNoAction.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnNineNoAction.setOnClickListener(this);
        cbReloadAdapter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setAdapter(isChecked);
            }
        });

        spinner.setOnItemSelectedSpinner2Listener(onItemSelectedSpinner2Listener);

        setAdapter(false);
    }

    private void setAdapter(boolean withAction) {
        adapter = new ArrayAdapter<>(ExampleActivity.this, android.R.layout.simple_spinner_dropdown_item, spinnerArr);
        spinner.setAdapter(adapter, withAction);
    }

    private void setLabel(String text) {
        tvLabel.setText("Selected: " + text);
    }

    private Spinner2.OnItemSelectedSpinner2Listener onItemSelectedSpinner2Listener = new Spinner2.OnItemSelectedSpinner2Listener() {
        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
            setLabel(spinnerArr[position]);
        }
    };

    private void setSelection(boolean withAction, int pos) {
        spinner.setSelection(withAction, pos);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_select_three_no_action: {
                setSelection(false, 2);
                break;
            }
            case R.id.btn_select_five: {
                setSelection(true, 4);
                break;
            }
            case R.id.btn_select_nine: {
                setSelection(true, 8);
                break;
            }
            case R.id.btn_select_nine_no_action: {
                setSelection(false, 8);
                break;
            }
        }
    }


}
