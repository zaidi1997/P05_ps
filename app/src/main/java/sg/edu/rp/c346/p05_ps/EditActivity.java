package sg.edu.rp.c346.p05_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EditActivity extends AppCompatActivity {

    Button btnCancel, btnDelete, btnUpdate;
    EditText etID, etTitle, etSinger, etYear;
    RadioGroup radGroup;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnCancel = findViewById(R.id.btnCancel);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        etID = findViewById(R.id.etID);
        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        radGroup = findViewById(R.id.radGroup);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");
        etID.setText(data.getId());
        etYear.setText(data.getYear());
        etTitle.setText(data.getTitle());
        etSinger.setText(data.getSingers());
        int id = radGroup.getCheckedRadioButtonId();
        RadioButton radButt = findViewById(id);
        int star = Integer.parseInt(radButt.getText().toString());
        radGroup.check(star);

        btnCancel.setOnClickListener((v)->{
            Intent o = new Intent();
            setResult(RESULT_OK, i);
            finish();
        });

        btnDelete.setOnClickListener((v)->{
            DBHelper dbh = new DBHelper(EditActivity.this);
            dbh.deleteSong(data.getId());
            dbh.close();
        });

        btnUpdate.setOnClickListener((v)->{
            DBHelper db = new DBHelper(EditActivity.this);

            data.setSingers(etSinger.getText().toString());
            data.setTitle(etTitle.getText().toString());
            data.setYear(Integer.parseInt(etYear.getText().toString()));

            int selectedID = radGroup.getCheckedRadioButtonId();
            RadioButton radBut = findViewById(selectedID);
            int stars = Integer.parseInt(radBut.getText().toString());
            data.setStars(stars);

            db.updateSong(data);
            db.close();

            Intent o = new Intent();
            setResult(RESULT_OK, o);
            finish();
        });

    }
}
