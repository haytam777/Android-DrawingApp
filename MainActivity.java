package gl2.kasri.younes.paintapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public final static int SHOW_NUMBER_REQUEST = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = findViewById(R.id.playButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowNumberActivity.class);
                startActivityForResult(intent, MainActivity.SHOW_NUMBER_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if ( requestCode == MainActivity.SHOW_NUMBER_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                Intent intent = new Intent(MainActivity.this, GameOverActivity.class);
                intent.putExtra("wonTheGame", true);
                startActivity(intent);
            } else if (resultCode == RESULT_CANCELED ){
                // TODO Make sure les niveaux sont remis à 0
            }
        }
    }

}

