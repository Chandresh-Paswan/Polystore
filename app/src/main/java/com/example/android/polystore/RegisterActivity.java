package com.example.android.polystore;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
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
    private ProgressBar progressBar;
    private int mYear, mMonth, mDay;
    Boolean isInternetPresent = false;
    ConnectionDetector cd;
    AlertDialogManager alert = new AlertDialogManager();
    RequestQueue requestQueue;

    String email, password, store_name, register_date, user_name, confirm_password,
     first_name, last_name ,date_birth, mobile_number,area ,landmark ,address ,country,
     state, city,store_reg_name,store_reg_date;
    String role="ROLE_CONSUMER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        cd = new ConnectionDetector(getApplicationContext());
        requestQueue = Volley.newRequestQueue(this);


        isInternetPresent = cd.isConnectingToInternet();
        if (!isInternetPresent) {
            // Internet Connection is not present
            alert.showAlertDialog(RegisterActivity.this, "Internet Connection Error",
                    "Please connect to working Internet connection", false);
            // stop executing code by return
            return;
        }


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

                //startActivity(new Intent(RegisterActivity.this, NavigationHome.class));
                //finish();


             /*   //building retrofit object
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                //Defining retrofit api service
                ApiInterface service = retrofit.create(ApiInterface.class);

                //Defining the user object as we need to pass it with the call
                RegistrationPojo registrationPojo = new RegistrationPojo( email, password, store_name, register_date, user_name, confirm_password,
                        first_name, last_name ,date_birth, mobile_number,area ,landmark ,address ,country,
                        state, city,store_reg_name,store_reg_date);

                //defining the call
                Call<Result> call = service.createUser(
                        registrationPojo.getEmail(),
                        registrationPojo.getPassword(),
                        registrationPojo.getStore_name(),
                        registrationPojo.getRegister_date(),
                        registrationPojo.getUser_name(),
                        registrationPojo.getConfirm_password(),
                        registrationPojo.getFirst_name(),
                        registrationPojo.getLast_name(),
                        registrationPojo.getDate_birth(),
                        registrationPojo.getMobile_number(),
                        registrationPojo.getArea(),
                        registrationPojo.getLandmark(),
                        registrationPojo.getAddress(),
                        registrationPojo.getCountry(),
                        registrationPojo.getState(),
                        registrationPojo.getCity(),
                        registrationPojo.getStore_reg_name(),
                        registrationPojo.getStore_reg_date()


                );

                //calling the api
                call.enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {


                        //displaying the message from the response as toast
                        //Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {

                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });*/


                String URL = "http://3.17.57.170:8080/polystore-server/api/register";

                JSONObject jsonBody = new JSONObject();


                try {

                    jsonBody.put("login", email);
                    jsonBody.put("firstName", first_name);
                    jsonBody.put("lastName", last_name);
                    jsonBody.put("email", email);
                    jsonBody.put("password", password);
                    jsonBody.put("area", area);
                    jsonBody.put("landmark", landmark);
                    jsonBody.put("address", address);
                    jsonBody.put("dateOfBirth", "1990-06-26");
                    jsonBody.put("cityCode", 241);
                    jsonBody.put("stateCode", 34);
                    jsonBody.put("phoneNo",Long.parseLong(mobile_number));
                    jsonBody.put("stateName", state);
                    jsonBody.put("cityName", city);
                    jsonBody.put("country", "IN");
                    jsonBody.put("imageUrl", null);
                    jsonBody.put("activated", true);
                    jsonBody.put("langKey", "en");
                    jsonBody.put("role", role);

                    if(role.equalsIgnoreCase("ROLE_PRODUCER")){
                        jsonBody.put("storeName",store_name);
                        jsonBody.put("registerDate",register_date);
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
                final String requestBody = jsonBody.toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }) {
                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8";
                    }

                    @Override
                    public byte[] getBody() throws AuthFailureError {
                        try {
                            return requestBody == null ? null : requestBody.getBytes("utf-8");
                        } catch (UnsupportedEncodingException uee) {
                            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                            return null;
                        }
                    }

                    @Override
                    protected Response<String> parseNetworkResponse(NetworkResponse response) {
                        String responseString = "";
                        if (response != null) {
                            responseString = String.valueOf(response.statusCode);
                            // can get more details such as response.headers
                        }
                        return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                    }
                };

                Log.d("conversionerror", "posted");
                requestQueue.add(stringRequest);

                progressBar.setVisibility(View.VISIBLE);

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
                role="ROLE_CONSUMER";
                break;

            case R.id.radiobutton_producer:
                mStoreRegName.setVisibility(View.VISIBLE);
                mRegDate.setVisibility(View.VISIBLE);
                mDateBirth.setVisibility(View.GONE);
                role="ROLE_PRODUCER";
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

}

