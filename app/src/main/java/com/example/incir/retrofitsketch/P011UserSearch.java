package com.example.incir.retrofitsketch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class P011UserSearch extends Activity {
    EditText editTextUserNameP011;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p011usersearch);
        editTextUserNameP011= (EditText)findViewById(R.id.editTextUserNameP011);
    }
    public void onClickP011(View view) {
        String userName=editTextUserNameP011.getText().toString();
        if(userName.isEmpty())
        {
            userName="githubmet";
        }
        Intent intent =new Intent(this,P011GetUserInfo.class);
        intent.putExtra("userName",userName);
        startActivity(intent);
    }
}
