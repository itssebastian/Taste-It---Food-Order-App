package com.sebastian.tasteit.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.app.SharedElementCallback;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;
import com.sebastian.tasteit.R;

import java.util.ArrayList;
import java.util.HashMap;

public class registration extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText fname, lname, localadd, emaill, pass, cmpass, Mobileno;
    Button register, Email, Phone;
    FirebaseAuth FAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    String email;
    String password;
    String firstname;
    String lastname;
    String Localaddress;
    String confirmpass;
    String mobileno;
    CountryCodePicker Cpp;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

            fname = (EditText) findViewById(R.id.u_name);
            localadd = (EditText) findViewById(R.id.Localaddress);
            emaill = (EditText) findViewById(R.id.Emailid);
            pass = (EditText) findViewById(R.id.Password);
            cmpass = (EditText) findViewById(R.id.confirmpass);
            register = (Button) findViewById(R.id.button);
            Mobileno = (EditText) findViewById(R.id.Mobilenumber);
            Cpp = (CountryCodePicker) findViewById(R.id.CountryCode);
            Email = (Button) findViewById(R.id.emaill);
            Phone = (Button) findViewById(R.id.phone);



        sharedPreferences = getApplicationContext().getSharedPreferences("Reg", 0);
        editor = sharedPreferences.edit();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fname.getText().toString();
                String email = emaill.getText().toString();
                String pwd = pass.getText().toString();
                String adrs = localadd.getText().toString();
                String mobile=Mobileno.getText().toString();

                isAllFieldsChecked = CheckAllFields();

                if (isAllFieldsChecked) {
                    Intent ob = new Intent(registration.this, MainActivity.class);
                    startActivity(ob);
                    editor.putString("Name", name);
                    editor.putString("Email",email);
                    editor.putString("txtPassword",pwd);
                    editor.putString("adrs",adrs);
                    editor.putString("mobile",mobile);
                    editor.commit();}   // commit the values

                    // after saving the value open next activity

                }
        });





       /* register.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v) {
                String name = fname.getText().toString();
                String email = emaill.getText().toString();
                String pwd = pass.getText().toString();
                String adrs = localadd.getText().toString();
                String mobile=Mobileno.getText().toString();

                if(fname.getText().length()== 0){
                    Toast.makeText(registration.this, "Enter name", Toast.LENGTH_SHORT).show();
                }
                else if( emaill.getText().length() == 0){
                    Toast.makeText(registration.this, "Enter email", Toast.LENGTH_SHORT).show();
                }
                else if( pass.getText().length() == 0){
                    Toast.makeText(registration.this, "Enter password", Toast.LENGTH_SHORT).show();
                }
                else{

                    // as now we have information in string. Lets stored them with the help of editor
                    editor.putString("Name", name);
                    editor.putString("Email",email);
                    editor.putString("txtPassword",pwd);
                    editor.putString("adrs",adrs);
                    editor.putString("mobile",mobile);
                    editor.commit();}   // commit the values

                    // after saving the value open next activity
                    Intent ob = new Intent(registration.this, MainActivity.class);
                    startActivity(ob);

            }
        });*/

        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(registration.this, login_mail.class);
                startActivity(i);
                finish();
            }
        });


        Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent e = new Intent(registration.this, login_phone.class);
                startActivity(e);
                finish();
            }
        });

        }
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    private boolean CheckAllFields() {
        if (fname.length() == 0) {
            fname.setError("This field is required");
            return false;
        }


        if (emaill.length() == 0 ) {
            emaill.setError("Email is required");
            return false;
        }

        if (Mobileno.length() < 0){
            Mobileno.setError("Enter valid number");
            return false;
        }

        if (pass.length() == 0) {
            pass.setError("Password is required");
            return false;
        } else if (pass.length() < 8) {
            pass.setError("Password must be minimum 8 characters");
            return false;
        }

        // after all validation return true.
        return true;
    }
}