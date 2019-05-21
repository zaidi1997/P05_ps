package sg.edu.rp.c346.p05_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class showsong extends AppCompatActivity {
    Button btnShow5Stars;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Song> song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showsong);

        setTitle("P05-NDPSongs ~ Show Song");
        btnShow5Stars = findViewById(R.id.btnShow5Stars);
        lv = findViewById(R.id.lv);

        // Create a few food objects in Food array
        song = new ArrayList<>();
        song.add(new Song(1, "Home","Home",1998,5));
        song.add(new Song(2,"Our Singapore","JJ Lin / Dick Lee",2015,5));
        song.add(new Song(3,"Future in my dreams","SAF Music and Drama Company",1997,4));


        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        aa = new SongAdapter(this, R.layout.row, song);
        lv.setAdapter(aa);

        btnShow5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i =0; i<song.size(); i++){
                    if(song.get(i).getStars() != 5){
                        song.remove(i);
                        aa = new SongAdapter(showsong.this, R.layout.row, song);
                        lv.setAdapter(aa);

                    }
                }

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Intent i = new Intent(showsong.this,
                        EditActivity.class);
                Song data = song.get(position);

                Song target = new Song(data.getTitle(), data.getSingers(), data.getYear(), data.getStars());
                i.putExtra("data", target);
                startActivityForResult(i, 9);
            }
        });
    }
}
