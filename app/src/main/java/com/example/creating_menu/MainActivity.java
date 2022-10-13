package com.example.creating_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {



    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        if(menu.getClass().getSimpleName().equals("MenuBuilder")){
            try{
                Method m = menu.getClass().getDeclaredMethod ("setOptionalIconsVisible", Boolean.TYPE);
                m.setAccessible(true);
                m.invoke(menu, true);
            }
            catch(NoSuchMethodException e){
                System.err.println("onCreateOptionsMenu");
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        String msg = "";
        switch (item.getItemId()) {

            case R.id.photo:
                item.setChecked(true);
                msg = "camera checked";
                break;

            case R.id.price:
                item.setChecked(true);
                msg = "price clicked";
                break;
            case R.id.add:
                item.setChecked(true);
                msg = "add clicked";
                break;
            case R.id.copy:
                item.setChecked(true);
                msg = "copy clicked";
                break;
            case R.id.mail:
                item.setChecked(true);
                msg = "mail clicked";
                break;
            case R.id.help:
                item.setChecked(true);
                msg = "help clicked";
                break;
            case R.id.telephone:
                item.setChecked(true);
                msg = "Call clicked";
                break;
            case R.id.toolbar:
                item.setChecked(true);
                msg = "toolbar clicked";
                break;
            case R.id.camera:
                item.setChecked(true);
                msg = "vidio checked";
                break;
            default:
                super.onOptionsItemSelected(item);
        }
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        return true;
    }

}