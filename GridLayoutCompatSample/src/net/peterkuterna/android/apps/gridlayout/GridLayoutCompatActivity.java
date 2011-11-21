package net.peterkuterna.android.apps.gridlayout;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GridLayoutCompatActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, new String[] {
						"0. Simple Form (Java)", "1. Simple Form (XML)" }));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		if (position == 0) {
			startActivity(new Intent(this, GridLayout0.class));
		} else if (position == 1) {
			startActivity(new Intent(this, GridLayout1.class));
		}
	}

}