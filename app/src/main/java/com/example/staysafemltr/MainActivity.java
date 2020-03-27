package com.example.staysafemltr;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nm,phne1,adrs,itms;
    Button submit;
    Spinner ward;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
       // myRef = database.getReference("message1");
        // myRef1 = database.getReference("message2");
        // myRef2 = database.getReference("message3");
        // myRef3 = database.getReference("message4");
        // myRef4 = database.getReference("message5");
        final DatabaseReference message1 = database.getReference("message1");

        nm = findViewById(R.id.editText);
        phne1 = findViewById(R.id.editText3);
        adrs = findViewById(R.id.editText6);
        itms = findViewById(R.id.editText5);
        submit = findViewById(R.id.button2);
        ward = findViewById(R.id.spinner);


        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");
        arrayList.add("11");
        arrayList.add("12");
        arrayList.add("13");
        arrayList.add("14");
        arrayList.add("15");
        arrayList.add("16");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ward.setAdapter(arrayAdapter);
        ward.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String wards;
                wards = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("സന്നദ്ധ പ്രവർത്തകർ ഉടൻ തന്നെ താങ്കളുമായി ബന്ധപ്പെടുന്നതാണ്..")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
        final AlertDialog alert = builder.create();

        final AlertDialog.Builder phoner = new AlertDialog.Builder(this);
        phoner.setMessage("ദയവായി കൃത്യമായ ഫോൺ നമ്പർ നൽകുക")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
        final AlertDialog alert1 = phoner.create();



        final AlertDialog.Builder texter = new AlertDialog.Builder(this);
        texter.setMessage("ദയവായി വിവരങ്ങൾ പൂർണമായി രേഖപ്പെടുത്തുക")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
        final AlertDialog alert2 = texter.create();



        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(nm.length()<2||adrs.length()<2||itms.length()<2) {

                   alert2.show();
                }
                else if(phne1.length()!=10)
                {
                    alert1.show();
                }
                else {
                    String wards = String.valueOf(ward.getSelectedItem());
                    String name = String.valueOf(nm.getText());
                    String phone = String.valueOf(phne1.getText());
                    String address = String.valueOf(adrs.getText());
                    String Items = String.valueOf(itms.getText());
                    //myRef.push().setValue(name);
                    //myRef1.push().setValue(phone);
                    //myRef2.push().setValue(phone2);
                    //myRef3.push().setValue(address);
                    //myRef4.push().setValue(Items);
                    //DatabaseReference childref = ward .push();
                    DatabaseReference childref = message1.push();
                    childref.push().setValue(wards);
                    childref.push().setValue(name);
                    //DatabaseReference childref1 = message1.push();
                    childref.push().setValue(phone);
                    //DatabaseReference childref2 = message1.push();
                    //DatabaseReference childref3 = message1.push();
                    childref.push().setValue(address);
                    //DatabaseReference childref4 = message1.push();
                    childref.push().setValue(Items);
                    alert.show();

                    itms.getText().clear();
                    adrs.getText().clear();
                    phne1.getText().clear();
                    nm.getText().clear();
                }
            }


        });
    }

}