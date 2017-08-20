package com.tatlicilar.downtoup;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomePage extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private Button chatBtn;
    private Button egitimBtn;
    private Button profilBtn;
    private FirebaseAuth mFirebaseAuth;
    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    Intent intent, intent2, intent3, intent20;
    private ProgressDialog mProgressDialog;
    private FirebaseDatabase mFirebaseDatabase; // access database
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        chatBtn = (Button)findViewById(R.id.chatBtn);
        egitimBtn = (Button)findViewById(R.id.egitimBtn);
        profilBtn= (Button)findViewById(R.id.profilBtn);
        chatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                intent = new Intent(HomePage.this, ChatActivity.class);
//                startActivity(intent);
            }

        });

        egitimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                intent2 = new Intent(HomePage.this, EgitimActivity.class);
//                startActivity(intent2);
            }

        });

        profilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                intent3 = new Intent(HomePage.this, Profil.class);
//                startActivity(intent3);
            }

        });
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        //FirebaseAuth sınıfının referans olduğu nesneleri kullanabilmek için getIns
        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!= null){
                    //user is signed in
//                    Toast.makeText(Login.this,"Senin adın" + user.getEmail().toString(), Toast.LENGTH_SHORT).show();
                    //onSignedInInitialize(user.getDisplayName());
                }
                else{
                    //user is signed out
                    //  onSignedOutCleanup();
//                    startActivityForResult(
//                            AuthUI.getInstance()
//                                    .createSignInIntentBuilder()
//                                    .setIsSmartLockEnabled(false)
//                                    .setProviders(
//                                            AuthUI.EMAIL_PROVIDER,
//                                            AuthUI.GOOGLE_PROVIDER
////                                            AuthUI.FACEBOOK_PROVIDER
//                                    )
//                                    .build(),
//                            RC_SIGN_IN);
                }
            }
        };
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(HomePage.this, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action1) {
            Toast.makeText(this, "action1",
                    Toast.LENGTH_SHORT).show();
            signOut();

            return true;
        }else     if (id == R.id.action2) {
            Toast.makeText(this, "action2",
                    Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void signOut() {
        //Firebase sign out
        Toast.makeText(this, "Sign out tayım",
                Toast.LENGTH_SHORT).show();
        mFirebaseAuth.signOut();

        //  Google sign out
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                        updateUI(null);
                    }
                });


    }
    private void updateUI(FirebaseUser user) {
        hideProgressDialog();
        if (user != null) {
            Toast.makeText(this, "User null değil!",
                    Toast.LENGTH_SHORT).show();

//            status.setText(getString(R.string.google_status_fmt, user.getEmail()));
//            detail.setText(getString(R.string.firebase_status_fmt, user.getUid()));

        } else {
            Toast.makeText(this, "Çıkış yaptınız!",
                    Toast.LENGTH_SHORT).show();
            intent20 = new Intent(HomePage.this, Login.class);
            startActivity(intent20);

        }
    }
    public void showPressDialog(){
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }
    public void hideProgressDialog(){
        if(mProgressDialog != null && mProgressDialog.isShowing()){
            mProgressDialog.hide();
        }
    }

    public void onDestroy(){
        super.onDestroy();
        hideProgressDialog();
    }
    @Override
    public void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        //Log.d(TAG, "onConnectionFailed:" + connectionResult);
        Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show();
    }
}
