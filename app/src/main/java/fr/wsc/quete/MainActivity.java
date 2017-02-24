package fr.wsc.quete;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import static android.R.attr.duration;


public class MainActivity extends Activity {
    TextView textView;
    CheckBox checkBox;
    EditText editText2;
    EditText editText;
    Button button;
    EditText editText3;
    TextView felic;
    Context context;
    Toast toast;
    int toastDuration;
    InputMethodManager inputManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        inputManager = (InputMethodManager) getSystemService(Context. INPUT_METHOD_SERVICE);
        editText3 = (EditText) findViewById(R.id.editText3);
        felic = (TextView) findViewById(R.id.felic);
        context = getApplicationContext();
        toast = Toast.makeText(context, getString(R.string.toast), toastDuration);
        toastDuration = Toast.LENGTH_SHORT;
        button.setEnabled(false);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                editText.setEnabled(checkBox.isChecked());
                editText3.setEnabled(checkBox.isChecked());
                button.setEnabled(checkBox.isChecked());
                    if (!(checkBox.isChecked())){
                    felic.setVisibility(View.INVISIBLE);
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.getText().toString();
                editText3.getText().toString();

                if (editText.length() != 0 && editText3.length() != 0){
                    felic.setText(getString(R.string.ok)+ " " + editText.getText() + " " + editText3.getText() );
                    felic.setVisibility(View.VISIBLE);
                    //inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(). 0);
                    //inputManager.hideSoftInputFromWindow(context.getWindowToken(), 0);
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = getString(R.string.toast);
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }
            }

        });


    }

}
