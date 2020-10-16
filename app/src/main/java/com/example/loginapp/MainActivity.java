package com.example.loginapp;

        import androidx.appcompat.app.AppCompatActivity;
        import android.content.Context;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;



public class MainActivity extends AppCompatActivity{
    private EditText input;
    private EditText input2;
    private TextView output;
    private TextView output2;
    private Button tombol;

    private SharedPreferences preferences;

    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input =findViewById(R.id.username);
        input2 =findViewById(R.id.password);
        output =findViewById (R.id.user);
        output2 =findViewById (R.id.pass);
        tombol =findViewById(R.id.btn);
        preferences = getSharedPreferences("sapporo_SharedPreferences" , Context.MODE_PRIVATE);

        tombol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                getuser();
                Toast.makeText(getApplicationContext(),"Berhasil Daftar",
                        Toast.LENGTH_SHORT).show();
                getpass();
                Toast.makeText(getApplicationContext(),"Berhasil Daftar",
                        Toast.LENGTH_SHORT).show();

            }
        } );
    }
    private void getuser(){
        String getKonten = input.getText().toString();
        editor = preferences.edit();
        editor.putString("data_saya", getKonten);
        editor.apply();
        output.setText("Output Username : "+preferences.getString("data_saya", null));

    }
    private void getpass(){
        String getKonten = input2.getText().toString();
        editor = preferences.edit();
        editor.putString("data_pass", getKonten);
        editor.apply();
        output2.setText("Output password : "+preferences.getString("data_pass", null));

    }

}

