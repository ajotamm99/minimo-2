package dsa.eetac.upc.edu.examen2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/** login **/
public class LoginActivity extends AppCompatActivity {

    private Button logIn;
    private EditText inputUserName;

    private Intent i;
    SharedPreferences mySharedPreferences;
    String user2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logIn = (Button) findViewById(R.id.btn_login);
        inputUserName = (EditText) findViewById(R.id.input_username);

        /** = getSharedPreferences("mySharedPreferences", MODE_PRIVATE);

        if(mySharedPreferences.getAll().size()!=0){
            user2 = (String)mySharedPreferences.getAll().get("Username");
            Toast.makeText(getApplicationContext(), "Ready for more stalking  " + user2 + "?", Toast.LENGTH_SHORT).show();
            Intent mainActivity = new Intent(this, MainActivity.class);
            startActivity(mainActivity);
        }**/
    }

    public void getUser(View view){

        /**SharedPreferences.Editor editor = getSharedPreferences("mySharedPreferences", MODE_PRIVATE).edit();
        editor.putString("Username", inputUserName.getText().toString());
        editor.apply();**/

        i = new Intent(LoginActivity.this, MainActivity.class);
        i.putExtra("STRINGKEY", inputUserName.getText().toString());
        startActivity(i);
    }

}

