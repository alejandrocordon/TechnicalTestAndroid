package com.test.alejandrocordonurena.technicaltestandroid.lists.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.BitmapFactory.Options;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.test.alejandrocordonurena.technicaltestandroid.R;
import com.test.alejandrocordonurena.technicaltestandroid.model.Account;

import java.util.ArrayList;


public class ListView_accounts_adapter implements ListAdapter {

    private String TAG = getClass().getSimpleName();

    private ArrayList<Account> accounts;

    private Activity actividad;
    private static LayoutInflater inflater=null;
    private Options options;


    public ListView_accounts_adapter(Activity a, ArrayList<Account> mAccounts) {

    	options = new Options();
		actividad = a;

		accounts = mAccounts;

        inflater = (LayoutInflater)actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


	@Override
	public void registerDataSetObserver(DataSetObserver dataSetObserver) {

	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

	}

	public int getCount() {
        return accounts.size();
    }

	@Override
	public Object getItem(int i) {
		return null;
	}

	@Override
	public long getItemId(int i) {
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}


	// create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {

    	View view = convertView;

		   	 if(convertView==null){
		   	 	view = inflater.inflate(R.layout.row_layout_list_account, null);
		     }


		   	 RelativeLayout vista_juego = (RelativeLayout) view.findViewById(R.id.RelativeLayoutAccount);
		   	 vista_juego.setVisibility(View.VISIBLE);

			 TextView Name     = (TextView) view.findViewById(R.id.textViewName);
			 TextView Balance     = (TextView) view.findViewById(R.id.textViewBalance);
			 TextView Currency      = (TextView) view.findViewById(R.id.textViewCurrency);


			  if (accounts == null) {

					Name.setText("No Accounts readed.");

			  } else {
		        	if (accounts.size() == 0){
                              Name.setText("No available flights.");
					} else {

						if ( accounts.get(position)!=null && (!accounts.get(position).toString().equals(""))) {

                              try{

                                  Name.setText(accounts.get(position).getAccountName());

                                  float balanceInUnits = (Float.parseFloat(accounts.get(position).getAccountBalanceInCents()) / 1000);
                                  Balance.setText(balanceInUnits + accounts.get(position).getAccountCurrency());
								  Currency.setText(accounts.get(position).getAccountCurrency());

                              }catch(Exception e){

                              }

						}
		        	}
			  }

           return view;

    }

	@Override
	public int getItemViewType(int i) {
		return 0;
	}

	@Override
	public int getViewTypeCount() {
		return 1;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean areAllItemsEnabled() {
		return false;
	}

	@Override
	public boolean isEnabled(int i) {
		return false;
	}
}







