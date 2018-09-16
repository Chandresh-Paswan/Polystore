package com.example.android.polystore;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;


import util.AlertDialogManager;
import util.ConnectionDetector;
import util.Utils;



public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {



    AutoCompleteTextView mStoreName, mRegisterDate, mUserName, mEmail, mNewPassword, mConfirmPassword, mFirstName, mLastName, mDateBirth,
            mMobileNumber, mArea, mLandMark, mAddress, mCountry, mState, mCity;

    RadioButton mConsumer, mProducer;

    TextInputLayout mStoreRegName, mRegDate;

    Button registration_submit;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private int mYear, mMonth, mDay;


    // flag for Internet connection status
    Boolean isInternetPresent = false;

    // Connection detector class
    ConnectionDetector cd;

    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    String email, password, store_name, register_date, user_name, confirm_password,
     first_name, last_name ,date_birth, mobile_number,area ,landmark ,address ,country,
     state, city,store_reg_name,store_reg_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        cd = new ConnectionDetector(getApplicationContext());

        // Check if Internet present
        isInternetPresent = cd.isConnectingToInternet();
        if (!isInternetPresent) {
            // Internet Connection is not present
            alert.showAlertDialog(RegisterActivity.this, "Internet Connection Error",
                    "Please connect to working Internet connection", false);
            // stop executing code by return
            return;
        }

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        // Pass on the activity and color resourse
        Utils.darkenStatusBar(this, R.color.colorPrimaryDark);

        mConsumer = (RadioButton) findViewById(R.id.radiobutton_consumer);
        mProducer = (RadioButton) findViewById(R.id.radiobutton_producer);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mStoreRegName = (TextInputLayout) findViewById(R.id.registration_store_layout);
        mRegDate = (TextInputLayout) findViewById(R.id.registration_date_layout);

        mStoreName = (AutoCompleteTextView) findViewById(R.id.registration_store_name);
        mRegisterDate = (AutoCompleteTextView) findViewById(R.id.registration_date);
        mUserName = (AutoCompleteTextView) findViewById(R.id.registration_username);
        mEmail = (AutoCompleteTextView) findViewById(R.id.registration_emailid);
        mNewPassword = (AutoCompleteTextView) findViewById(R.id.registration_new_password);
        mConfirmPassword = (AutoCompleteTextView) findViewById(R.id.registration_confirm_password);
        mFirstName = (AutoCompleteTextView) findViewById(R.id.registration_first_name);
        mLastName = (AutoCompleteTextView) findViewById(R.id.registration_last_name);
        mDateBirth = (AutoCompleteTextView) findViewById(R.id.registration_date_birth);
        mMobileNumber = (AutoCompleteTextView) findViewById(R.id.registration_mobile_number);
        mArea = (AutoCompleteTextView) findViewById(R.id.registration_area);
        mLandMark = (AutoCompleteTextView) findViewById(R.id.registration_landmark);
        mAddress = (AutoCompleteTextView) findViewById(R.id.registration_address);
        mCountry = (AutoCompleteTextView) findViewById(R.id.registration_country);
        mState = (AutoCompleteTextView) findViewById(R.id.registration_state);
        mCity = (AutoCompleteTextView) findViewById(R.id.registration_city);

        registration_submit = (Button) findViewById(R.id.submit);

        mDateBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateSetupMethod();
            }
        });
        mRegisterDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateSetupMethod1();
            }
        });

        mConsumer.setOnClickListener(this);
        mProducer.setOnClickListener(this);

        registration_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = mEmail.getText().toString().trim();
                password = mNewPassword.getText().toString().trim();
                user_name = mUserName.getText().toString().trim();
                confirm_password = mConfirmPassword.getText().toString().trim();
                first_name = mFirstName.getText().toString().trim();
                last_name = mLastName.getText().toString().trim();
                date_birth = mDateBirth.getText().toString().trim();
                mobile_number = mMobileNumber.getText().toString().trim();
                area = mArea.getText().toString().trim();
                landmark = mLandMark.getText().toString().trim();
                address = mAddress.getText().toString().trim();
                country = mCountry.getText().toString().trim();
                state = mState.getText().toString().trim();
                city = mCity.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(user_name)) {
                    Toast.makeText(getApplicationContext(), "Enter User Name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(confirm_password)) {
                    Toast.makeText(getApplicationContext(), "Enter Confirm Password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(first_name)) {
                    Toast.makeText(getApplicationContext(), "Enter First Name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(last_name)) {
                    Toast.makeText(getApplicationContext(), "Enter Last Name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(date_birth)) {
                    Toast.makeText(getApplicationContext(), "Enter Date of Birth!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(mobile_number)) {
                    Toast.makeText(getApplicationContext(), "Enter Mobile Number!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(area)) {
                    Toast.makeText(getApplicationContext(), "Enter Area!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(landmark)) {
                    Toast.makeText(getApplicationContext(), "Enter Landmark!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(address)) {
                    Toast.makeText(getApplicationContext(), "Enter address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(country)) {
                    Toast.makeText(getApplicationContext(), "Enter Country!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(state)) {
                    Toast.makeText(getApplicationContext(), "Enter State!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(city)) {
                    Toast.makeText(getApplicationContext(), "Enter City!", Toast.LENGTH_SHORT).show();
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);
                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(RegisterActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);

                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(RegisterActivity.this, NavigationHome.class));
                                    finish();
                                }
                            }
                        });
            }
        });

    }

    public void dateSetupMethod() {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {


                        mDateBirth.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }

    public void dateSetupMethod1() {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {


                        mRegisterDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.radiobutton_consumer:
                mStoreRegName.setVisibility(View.GONE);
                mRegDate.setVisibility(View.GONE);
                mDateBirth.setVisibility(View.VISIBLE);
                String consumer="role_consumer";
                break;

            case R.id.radiobutton_producer:
                mStoreRegName.setVisibility(View.VISIBLE);
                mRegDate.setVisibility(View.VISIBLE);
                mDateBirth.setVisibility(View.GONE);

                String producer="role_producer";

                store_name = mStoreName.getText().toString().trim();
                register_date = mRegisterDate.getText().toString().trim();

                if (TextUtils.isEmpty(store_name)) {
                    Toast.makeText(getApplicationContext(), "Enter Store Name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(register_date)) {
                    Toast.makeText(getApplicationContext(), "Enter Registration Date!", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;

        }

    }


    @Override
    public void onResume() {
        super.onResume();

         progressBar.setVisibility(View.GONE);

    }

   /* public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.radiobutton_consumer:
                if (checked){


                }
                break;

            case R.id.radiobutton_producer:
                if (checked){



                    if (TextUtils.isEmpty(store_reg_name)) {
                        Toast.makeText(getApplicationContext(), "Enter Store Registration Name!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (TextUtils.isEmpty(store_reg_date)) {
                        Toast.makeText(getApplicationContext(), "Enter Store Registration Date!", Toast.LENGTH_SHORT).show();
                        return;
                    }


                }

                break;

        }
    }*/

}

