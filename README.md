# TechnicalTestAndroid

Technical test Android / iOS

### Instructions

Please send us back the project inside a zip file within the next 2 days indicating the starting/finish date and how many hours
you spent on it.
If you have any questions please make assumptions and proceed.
We want to see you implement it in a way that you see best fit. There is no right or wrong answer.
If you can’t continue please feel free to send a message.

### Requirements

 1. Create a universal Android/iOS App that shows a list of accounts.
 2. There are two versions of this list that is displayed: complete list and the list of only visible accounts. How you choose to
display/switch between these two versions is entirely your own. You can build a list where the account name, the iban and the
balance is displayed as inspiration.
 3. You also want to be able to show this list in a different target like Watch / Widget.
Do not spend time building a nice interface, we are not interested in that.
Use the data from the datasource below:

```
{
  accounts = (
      {
      accountBalanceInCents = 985000;
      accountCurrency = EUR;
      accountId = 748757694;
      accountName = "Hr P L G N StellingTD";
      accountNumber = 748757694;
      accountType = PAYMENT;
      alias = “”;

      isVisible = true;
      iban = NL23INGB0748757694;
      },
      {
      accountBalanceInCents = 1000000;
      accountCurrency = EUR;
      accountId = 700000027559;
      accountName = ",";
      accountNumber = 748757732;
      accountType = PAYMENT;
      alias = “";

      isVisible = false;
      iban = NL88INGB0748757732;
      },
      {
      accountBalanceInCents = 15000;
      accountCurrency = EUR;
      accountId = 700000027559;
      accountName = "";
      accountNumber = "H 177-27066";
      accountType = SAVING;
      alias = "G\UfffdLSAVINGSdiacrits";
      iban = “";

      isVisible = true;
      linkedAccountId = 748757694;
      productName = "Oranje Spaarrekening";
      productType = 1000;
      savingsTargetReached = 1;
      targetAmountInCents = 2000;
      }
  );
  failedAccountTypes = “CREDITCARDS";
  returnCode = OK;
}
```
