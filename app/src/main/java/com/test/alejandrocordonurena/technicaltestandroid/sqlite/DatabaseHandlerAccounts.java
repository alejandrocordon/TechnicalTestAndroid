package com.test.alejandrocordonurena.technicaltestandroid.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.test.alejandrocordonurena.technicaltestandroid.model.Account;

import java.util.ArrayList;


/**
 * Created by alejandrocordonurena on 11/11/2017.
 */
public class DatabaseHandlerAccounts extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "bank";

    // account table name
    private static final String TABLE_accountS = "accounts";

    // account Table Columns names
    private static final String KEY_ID = "id";

    private static final String KEY_accountBalanceInCents    = "accountBalanceInCents";
    private static final String KEY_accountCurrency          = "accountCurrency";
    private static final String KEY_accountId                = "accountId";
    private static final String KEY_accountName              = "accountName";
    private static final String KEY_accountNumber            = "accountNumber";
    private static final String KEY_accountType              = "accountType";
    private static final String KEY_alias                    = "alias";
    private static final String KEY_iban                     = "iban";
    private static final String KEY_isVisible                = "isVisible";
    private static final String KEY_linkedAccountId          = "linkedAccountId";
    private static final String KEY_productName              = "productName";
    private static final String KEY_productType              = "productType";
    private static final String KEY_savingsTargetReached     = "savingsTargetReached";
    private static final String KEY_targetAmountInCents      = "targetAmountInCents";


    private final ArrayList<Account> account_list = new ArrayList<Account>();



    public DatabaseHandlerAccounts(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_accountS_TABLE = "CREATE TABLE " + TABLE_accountS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_accountBalanceInCents + " TEXT,"
                + KEY_accountCurrency + " TEXT," + KEY_accountId + " TEXT,"
                + KEY_accountName + " TEXT," + KEY_accountNumber + " TEXT,"
                + KEY_accountType + " TEXT," + KEY_alias + " TEXT,"
                + KEY_iban + " TEXT,"
                + KEY_isVisible + " TEXT,"
                + KEY_linkedAccountId + " TEXT," + KEY_productName + " TEXT,"
                + KEY_productType + " TEXT," + KEY_savingsTargetReached + " TEXT,"
                + KEY_targetAmountInCents + " TEXT"  + ")";

        db.execSQL(CREATE_accountS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_accountS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new account
    public void Add_account(Account account) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

//        values.put(KEY_ID,                      account.getId());

        values.put(KEY_accountBalanceInCents,   account.getAccountBalanceInCents());
        values.put(KEY_accountCurrency      ,   account.getAccountCurrency());
        values.put(KEY_accountId            ,   account.getAccountId());
        values.put(KEY_accountName          ,   account.getAccountName());
        values.put(KEY_accountNumber        ,   account.getAccountNumber());
        values.put(KEY_accountType          ,   account.getAccountType());
        values.put(KEY_alias                ,   account.getAlias());
        values.put(KEY_iban                 ,   account.getIban());
        values.put(KEY_isVisible            ,   account.getIsVisible());
        values.put(KEY_linkedAccountId      ,   account.getLinkedAccountId());
        values.put(KEY_productName          ,   account.getProductName());
        values.put(KEY_productType          ,   account.getProductType());
        values.put(KEY_savingsTargetReached ,   account.getSavingsTargetReached());
        values.put(KEY_targetAmountInCents  ,   account.getTargetAmountInCents());


        // Inserting Row
        db.insert(TABLE_accountS, null, values);
        db.close(); // Closing database connection
    }

    // Getting sinble account
    public Account Get_account(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_accountS, new String[] {
                        KEY_ID,
                        KEY_accountBalanceInCents,
                        KEY_accountCurrency      ,
                        KEY_accountId            ,
                        KEY_accountName          ,
                        KEY_accountNumber        ,
                        KEY_accountType          ,
                        KEY_alias                ,
                        KEY_iban                 ,

                        KEY_isVisible            ,
                        KEY_linkedAccountId      ,
                        KEY_productName          ,
                        KEY_productType          ,
                        KEY_savingsTargetReached ,
                        KEY_targetAmountInCents  }, KEY_ID + "=?",

                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Account account = new Account();
        account.setId(Integer.parseInt(cursor.getString(0)));
        account.setAccountBalanceInCents(cursor.getString(1));
        account.setAccountCurrency      (cursor.getString(2));
        account.setAccountId            (cursor.getString(3));
        account.setAccountName          (cursor.getString(4));
        account.setAccountNumber        (cursor.getString(5));
        account.setAccountType          (cursor.getString(6));
        account.setAlias                (cursor.getString(7));
        account.setIban                 (cursor.getString(8));
        account.setIsVisible            (cursor.getString(9));
        account.setLinkedAccountId      (cursor.getString(10));
        account.setProductName          (cursor.getString(11));
        account.setProductType          (cursor.getString(12));
        account.setSavingsTargetReached (cursor.getString(13));
        account.setTargetAmountInCents  (cursor.getString(14));

        // return account
        cursor.close();
        db.close();

        return account;
    }

    // Getting All accounts
    public ArrayList<Account> Get_All_accounts() {
        try {
            account_list.clear();

            // Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_accountS;
            Log.e("DataBaseHelper", "Get_accounts_Where_destiny = " + selectQuery);

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {

                    Account account = new Account();
                    account.setId(Integer.parseInt(cursor.getString(0)));
                    account.setAccountBalanceInCents(cursor.getString(1));
                    account.setAccountCurrency      (cursor.getString(2));
                    account.setAccountId            (cursor.getString(3));
                    account.setAccountName          (cursor.getString(4));
                    account.setAccountNumber        (cursor.getString(5));
                    account.setAccountType          (cursor.getString(6));
                    account.setAlias                (cursor.getString(7));
                    account.setIban                 (cursor.getString(8));
                    account.setIsVisible            (cursor.getString(9));
                    account.setLinkedAccountId      (cursor.getString(10));
                    account.setProductName          (cursor.getString(11));
                    account.setProductType          (cursor.getString(12));
                    account.setSavingsTargetReached (cursor.getString(13));
                    account.setTargetAmountInCents  (cursor.getString(14));


                    // Adding account to list
                    account_list.add(account);
                } while (cursor.moveToNext());
            }

            // return account list
            cursor.close();
            db.close();
            return account_list;
        } catch (Exception e) {
            // TODO: handle exception
            Log.e("all_account", "" + e);
        }

        return account_list;
    }


    // Getting All accounts
    public ArrayList<Account> Get_visible_account() {
        try {
            account_list.clear();

            // Select All Query
            String selectQuery = "SELECT * FROM " + TABLE_accountS + " WHERE " + KEY_isVisible + " = 'true' " ;
            Log.e("DataBaseHelper", "Get_accounts_Where_destiny = " + selectQuery);

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {


                    Account account = new Account();
                    account.setId(Integer.parseInt(cursor.getString(0)));
                    account.setAccountBalanceInCents(cursor.getString(1));
                    account.setAccountCurrency      (cursor.getString(2));
                    account.setAccountId            (cursor.getString(3));
                    account.setAccountName          (cursor.getString(4));
                    account.setAccountNumber        (cursor.getString(5));
                    account.setAccountType          (cursor.getString(6));
                    account.setAlias                (cursor.getString(7));
                    account.setIban                 (cursor.getString(8));
                    account.setIsVisible            (cursor.getString(9));
                    account.setLinkedAccountId      (cursor.getString(10));
                    account.setProductName          (cursor.getString(11));
                    account.setProductType          (cursor.getString(12));
                    account.setSavingsTargetReached (cursor.getString(13));
                    account.setTargetAmountInCents  (cursor.getString(14));


                    // Adding account to list
                    account_list.add(account);
                } while (cursor.moveToNext());
            }

            // return account list
            cursor.close();
            db.close();
            return account_list;
        } catch (Exception e) {
            // TODO: handle exception
            Log.e("all_account", "" + e);
        }

        return account_list;
    }



    // Deleting single account
    public void Delete_account(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_accountS, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

    // Deleting single account
    public void Delete_All_accounts() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_accountS, null, null);
        db.close();
    }


    // Getting accounts Count
    public int Get_Total_accounts() {
        String countQuery = "SELECT  * FROM " + TABLE_accountS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}

