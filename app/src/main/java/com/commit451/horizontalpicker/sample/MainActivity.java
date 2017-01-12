/*
 * Copyright 2014 Blaž Šolar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.commit451.horizontalpicker.sample;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.commit451.horizontalpicker.HorizontalPicker;

public class MainActivity extends AppCompatActivity implements HorizontalPicker.OnItemSelectedListener, HorizontalPicker.OnItemClickListener {

    ViewGroup root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root = (ViewGroup) findViewById(R.id.root);

        final HorizontalPicker picker = (HorizontalPicker) findViewById(R.id.picker);
        picker.setOnItemClickedListener(this);
        picker.setOnItemSelectedListener(this);

        findViewById(R.id.button_current_value).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(root, "Current value: " + picker.getSelectedItemPosition(), Snackbar.LENGTH_SHORT)
                        .show();
            }
        });
        final Button buttonFont = (Button) findViewById(R.id.button_font);
        buttonFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
                picker.setTypeface(typeface);
                buttonFont.setVisibility(View.GONE);
            }
        });

        HorizontalPicker otherPicker = (HorizontalPicker) findViewById(R.id.other_picker);
        otherPicker.setValues(Fruit.getFruits());
    }

    @Override
    public void onItemSelected(int index)    {
        Snackbar.make(root, "Item " + index + " selected", Snackbar.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onItemClicked(int index) {
        Snackbar.make(root, "Item " + index + " clicked", Snackbar.LENGTH_SHORT)
                .show();
    }
}
