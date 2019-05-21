package sg.edu.rp.c346.p05_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    private ArrayList<Song> song;
    private Context context;
    private TextView tvYear , tvTitle , tvSinger ;
    private ImageView iv1, iv2, iv3, iv4, iv5, ivSong;





    public SongAdapter(Context context, int resource, ArrayList<Song> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        song = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvYear =         rowView.findViewById(R.id.tvYear);
        // Get the ImageView object
        tvTitle =             rowView.findViewById(R.id.tvTitle);

        tvSinger = rowView.findViewById(R.id.tvSingers);

        ivSong = rowView.findViewById(R.id.ivSong);

        iv5 = rowView.findViewById(R.id.imageView5Star);
        iv4 = rowView.findViewById(R.id.imageView4Star);
        iv3 = rowView.findViewById(R.id.imageView3Star);
        iv2 = rowView.findViewById(R.id.imageView2Star);
        iv1 = rowView.findViewById(R.id.imageView1Star);



        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Song currentSong = song.get(position);
        // Set the TextView to show the food

        tvYear.setText(currentSong.getYear()+ "");
        tvTitle.setText(currentSong.getTitle());
        tvSinger.setText(currentSong.getSingers());
        int stars = currentSong.getStars();
        //Check if the property for starts >= 5, if so, "light" up the stars
        if (stars >= 5) {
            iv5.setImageResource(android.R.drawable.btn_star_big_on);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (stars >= 4) {
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (stars >= 3) {
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }else if(stars >=2){
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }else{
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }

        ivSong.setImageResource(R.drawable.ic_library_music);
        // Set the image to star or nostar accordingly

        // Return the nicely done up View to the ListView
        return rowView;
    }


}
