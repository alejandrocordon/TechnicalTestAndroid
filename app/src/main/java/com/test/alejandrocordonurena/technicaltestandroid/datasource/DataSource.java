package com.test.alejandrocordonurena.technicaltestandroid.datasource;

import android.content.Intent;
import android.util.Log;

import com.test.alejandrocordonurena.technicaltestandroid.ListAccountActivity;
import com.test.alejandrocordonurena.technicaltestandroid.SplashActivity;
import com.test.alejandrocordonurena.technicaltestandroid.model.Account;
import com.test.alejandrocordonurena.technicaltestandroid.sqlite.DatabaseHandlerAccounts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by alejandrocordonurena on 11/11/2017.
 */


public  class DataSource {



    private String TAG = getClass().getCanonicalName();


    public StringBuilder datasource = new StringBuilder();



    public DataSource() {

        datasource = new StringBuilder();
        datasource.append("{");
        datasource.append("    accounts = (");
        datasource.append("        {");
        datasource.append("               accountBalanceInCents = 985000;");
        datasource.append("               accountCurrency = EUR;");
        datasource.append("               accountId = 748757694;");
        datasource.append("               accountName = 'Hr P L G N StellingTD';");
        datasource.append("               accountNumber = 748757694;");
        datasource.append("               accountType = PAYMENT;");
        datasource.append("               alias = '';");
        datasource.append("               isVisible = true;");
        datasource.append("               iban = NL23INGB0748757694;");
        datasource.append("           },");
        datasource.append("           {");
        datasource.append("               accountBalanceInCents = 1000000;");
        datasource.append("               accountCurrency = EUR;");
        datasource.append("               accountId = 700000027559;");
        datasource.append("               accountName = ',';");
        datasource.append("               accountNumber = 748757732;");
        datasource.append("               accountType = PAYMENT;");
        datasource.append("               alias = '';");
        datasource.append("               isVisible = false;");
        datasource.append("               iban = NL88INGB0748757732;");
        datasource.append("           },");
        datasource.append("           {");
        datasource.append("               accountBalanceInCents = 15000;");
        datasource.append("               accountCurrency = EUR;");
        datasource.append("               accountId = 700000027559;");
        datasource.append("               accountName = '';");
        datasource.append("               accountNumber = 'H 177-27066';");
        datasource.append("               accountType = SAVING;");
        datasource.append("               alias = 'G\\UfffdLSAVINGSdiacrits';");
        datasource.append("               iban = '';");
        datasource.append("               isVisible = true;");
        datasource.append("               linkedAccountId = 748757694;");
        datasource.append("               productName = 'Oranje Spaarrekening';");
        datasource.append("               productType = 1000;");
        datasource.append("               savingsTargetReached = 1;");
        datasource.append("               targetAmountInCents = 2000;");
        datasource.append("         }");
        datasource.append("    );");
        datasource.append("    failedAccountTypes = 'CREDITCARDS';");
        datasource.append("    returnCode = OK;");
        datasource.append("}");

    }


    /**
     * This method transforms the original datasource in a normalized string JSON styled
     * This method transforms all the parameters in Strings.
     * TODO: In the future this method should transform each value in its correct type
     *
      * @param ds
     * @return the normalized JSON string
     */
    public  String normalizeToJSON(String ds) {


        try {

            String data = ds;


            data = data.replaceAll("“","\"");
            data = data.replaceAll("\\(","[");
            data = data.replaceAll("\\)","]");
            data = data.replaceAll("\\\\","-");
            data = data.replaceAll("\",\"","\"\"");

            data = data.replaceAll("\\{","{\"");
            data = data.replaceAll("=\"","=");
            data = data.replaceAll("=\\(","*");
            data = data.replaceAll("=","\":\"");
            data = data.replaceAll("\\*","=\\(");
            data = data.replaceAll("\";",";");
            data = data.replaceAll(";" ,"\",\"");

            data = data.replaceAll(" ","");

            data = data.replaceAll("\"\\[","\\[");
            data = data.replaceAll("]\"","]");

            data = data.replace("\",\"}","\"}");

            data = data.replaceAll("\"'","\"");
            data = data.replaceAll("'\"","\"");


            Log.e(TAG + "DEBUG", data);


            return data;

        }
        catch(Exception e){
            Log.e(TAG + "ERROR", "Error : " + e.getMessage());
            return null;
        }


    }


    public  JSONObject dataSourceToJSONObject(String ds) {


        try {

            JSONObject obj = new JSONObject(ds);

            Log.e(TAG + "DEBUG", obj.toString());

            return obj;

        } catch (Exception t) {
            Log.e(TAG + "ERROR", "Malformed JSON: \"" + ds + "\" " + t.getMessage());
            return null;
        }

    }



    public ArrayList<Account> JSONObjectToArrayList(JSONObject json) {


        try {

                JSONArray json_Items = new JSONArray(json.getString("accounts").toString());

                ArrayList<Account> accounts = new ArrayList<Account>();

                for (int i = 0; i < json_Items.length() ; i++) {


                    JSONObject account_json = new JSONObject(json_Items.get(i).toString());

                    Account account = new Account();

                    account.setAccountBalanceInCents  (account_json.getString("accountBalanceInCents"));
                    account.setAccountCurrency        (account_json.getString("accountCurrency"));
                    account.setAccountId              (account_json.getString("accountId"));
                    account.setAccountName            (account_json.getString("accountName"));
                    account.setAccountNumber          (account_json.getString("accountNumber"));
                    account.setAccountType            (account_json.getString("accountType"));
                    account.setAlias                  (account_json.getString("alias"));
                    account.setIban                   (account_json.getString("iban"));
                    account.setIsVisible              (account_json.getString("isVisible"));

                    if(account_json.has("linkedAccountId")){
                        account.setLinkedAccountId        (account_json.getString("linkedAccountId"));
                        account.setProductName            (account_json.getString("productName"));
                        account.setProductType            (account_json.getString("productType"));
                        account.setSavingsTargetReached   (account_json.getString("savingsTargetReached"));
                        account.setTargetAmountInCents    (account_json.getString("targetAmountInCents"));
                    }


                    accounts.add(account);




                }

                return accounts;

        } catch (Exception t) {
            Log.e(TAG + "ERROR", "JSONObjectToArrayList Error: " + t.getMessage());
            return null;
        }

    }

}