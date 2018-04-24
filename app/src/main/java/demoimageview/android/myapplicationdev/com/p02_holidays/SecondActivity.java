package demoimageview.android.myapplicationdev.com.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvYear;
    ArrayAdapter aa;
    ArrayList<Holidays> holidays ;
    ArrayList<Holidays> religion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvYear = (TextView)findViewById(R.id.tvCat);
        lv = (ListView)findViewById(R.id.lvHolidays);

        Intent iReceived = getIntent();
        String holidayTitle = iReceived.getStringExtra("title");
        tvYear.setText(holidayTitle);

        holidays = new ArrayList<Holidays>();

        if(holidayTitle.equals("Secular")){
            holidays.add(new Holidays("New Year's Day","1 Jan 2017"));
            holidays.add(new Holidays("Labour Day","1 May 2017"));
        }
        else{
            holidays.add(new Holidays("Chinese New Year","28-29 Jan 2017"));
            holidays.add(new Holidays(" Good Friday","14 April 2017"));
        }
        aa = new HolidaysAdapter(this,R.layout.row,holidays);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holidays selectedDetail = holidays.get(position);


                Toast.makeText(SecondActivity.this, selectedDetail.getHolidays()+ " Date: " + selectedDetail.getDate(),
                        Toast.LENGTH_LONG).show();

            }
        });

    }

}