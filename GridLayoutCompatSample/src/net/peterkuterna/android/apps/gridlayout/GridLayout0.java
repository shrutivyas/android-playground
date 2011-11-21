/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.peterkuterna.android.apps.gridlayout;

import static net.peterkuterna.android.apps.gridlayout.GridLayout.spec;
import net.peterkuterna.android.apps.gridlayout.GridLayout.LayoutParams;
import net.peterkuterna.android.apps.gridlayout.GridLayout.Spec;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple form, showing use of the GridLayout API.
 */
public class GridLayout0 extends Activity {

	public static View create(Context context) {
		GridLayout p = new GridLayout(context);
		p.setUseDefaultMargins(true);
		p.setAlignmentMode(GridLayout.ALIGN_BOUNDS);
		p.setRowOrderPreserved(false);

		Spec row1 = spec(0);
		Spec row2 = spec(1);
		Spec row3 = spec(2, GridLayout.BASELINE);
		Spec row4 = spec(3, GridLayout.BASELINE);
		Spec row5 = spec(2, 3, GridLayout.FILL); // allow the last two rows to
												 // overlap the middle two
		Spec row6 = spec(5);
		Spec row7 = spec(6);

		Spec col1a = spec(0, 4, GridLayout.CENTER);
		Spec col1b = spec(0, 4, GridLayout.LEFT);
		Spec col1c = spec(0, GridLayout.RIGHT);
		Spec col2 = spec(1, GridLayout.LEFT);
		Spec col3 = spec(2, GridLayout.FILL);
		Spec col4a = spec(3);
		Spec col4b = spec(3, GridLayout.FILL);

		{
			TextView c = new TextView(context);
			c.setTextSize(32);
			c.setText("Email setup");
			p.addView(c, new LayoutParams(row1, col1a));
		}
		{
			TextView c = new TextView(context);
			c.setTextSize(16);
			c.setText("You can configure email in just a few steps:");
			p.addView(c, new LayoutParams(row2, col1b));
		}
		{
			TextView c = new TextView(context);
			c.setText("Email address:");
			p.addView(c, new LayoutParams(row3, col1c));
		}
		{
			EditText c = new EditText(context);
			c.setEms(10);
			c.setInputType(EditorInfo.TYPE_CLASS_TEXT
					| EditorInfo.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
			p.addView(c, new LayoutParams(row3, col2));
		}
		{
			TextView c = new TextView(context);
			c.setText("Password:");
			p.addView(c, new LayoutParams(row4, col1c));
		}
		{
			TextView c = new EditText(context);
			c.setEms(8);
			c.setInputType(EditorInfo.TYPE_CLASS_TEXT
					| EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
			p.addView(c, new LayoutParams(row4, col2));
		}
		{
			Space c = new Space(context);
			p.addView(c, new LayoutParams(row5, col3));
		}
		{
			Button c = new Button(context);
			c.setText("Manual setup");
			p.addView(c, new LayoutParams(row6, col4a));
		}
		{
			Button c = new Button(context);
			c.setText("Next");
			p.addView(c, new LayoutParams(row7, col4b));
		}

		return p;
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(create(this));
	}

}