package com.hackathon.vinci.hackathonvinci;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.TextView;
import java.io.InputStream;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.order();
    }

    public void order() {

         try

        {
            AssetManager am=getAssets();
            InputStream is=am.open("users.xls");

            Workbook wb=Workbook.getWorkbook(is);
            Sheet s=wb.getSheet(0);
            int row=s.getRows();
            int col=s.getColumns();

            String xx="";

            spinner = (Spinner) findViewById(R.id.spinner);
            List<String> list = new ArrayList<String>();

            for (int i=1;i<row;i++)
            {

                for(int c=0;c<col;c++)
                {
                    Cell z=s.getCell(c,i);
                    if (c==1) {
                        list.add(z.getContents());
                    }
                    xx=xx+z.getContents();

                }

                xx=xx+"\n";
            }

           // display(xx);

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(dataAdapter);

        }

        catch (Exception e){}
    }


}
