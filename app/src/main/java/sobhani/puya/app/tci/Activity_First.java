package sobhani.puya.app.tci;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.Array;

import sobhani.puya.app.tci.R;

/* loaded from: classes.dex */
public class Activity_First extends Activity {
    public TextView PlayerOne;
    public TextView PlayerTwo;
    public TextView txt_PlayerOne;
    public TextView txt_PlayerTwo;
    public TextView txt_title;
    public Typeface typeface;
    public ImageView[] images = new ImageView[9];
    public byte[][] cells = (byte[][]) Array.newInstance(Byte.TYPE, 3, 3);
    public boolean IsPlayerOne = true;
    public int Playerone = 0;
    public int Playertwo = 0;



    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.images[0] = findViewById(R.id.img1);
        this.images[1] = findViewById(R.id.img2);
        this.images[2] = findViewById(R.id.img3);
        this.images[3] = findViewById(R.id.img4);
        this.images[4] = findViewById(R.id.img5);
        this.images[5] = findViewById(R.id.img6);
        this.images[6] = findViewById(R.id.img7);
        this.images[7] = findViewById(R.id.img8);
        this.images[8] = findViewById(R.id.img9);
        ImageView img_reset = findViewById(R.id.img_reset);
        ImageView img_reset_number = findViewById(R.id.img_reset_number);
        // from class: sobhani.puya.app.tci.Activity_First.1
// android.view.View.OnClickListener
        img_reset.setOnClickListener(arg0 -> {
            Activity_First.this.IsPlayerOne = true;
            Activity_First.this.ResetGame();
        });
        // from class: sobhani.puya.app.tci.Activity_First.2
// android.view.View.OnClickListener
        img_reset_number.setOnClickListener(arg0 -> {
            Activity_First.this.Playerone = 0;
            Activity_First.this.Playertwo = 0;
            Activity_First.this.txt_PlayerOne.setText(String.valueOf(Activity_First.this.Playerone));
            Activity_First.this.txt_PlayerTwo.setText(String.valueOf(Activity_First.this.Playertwo));
        });
        this.txt_PlayerOne = findViewById(R.id.txt_PlayerOne);
        this.txt_PlayerTwo = findViewById(R.id.txt_PlayerTwo);
        this.PlayerOne = findViewById(R.id.txt_One);
        this.PlayerTwo = findViewById(R.id.txt_Two);
        this.txt_title = findViewById(R.id.txt_title);
        this.typeface = Typeface.createFromAsset(getAssets(), "kodak.ttf");
        this.txt_PlayerOne.setTypeface(this.typeface);
        this.txt_PlayerTwo.setTypeface(this.typeface);
        this.PlayerOne.setTypeface(this.typeface);
        this.PlayerTwo.setTypeface(this.typeface);
        this.txt_title.setTypeface(this.typeface);
        // from class: sobhani.puya.app.tci.Activity_First.3
// android.view.View.OnClickListener
        View.OnClickListener clickListener = view -> {
            ImageView img = (ImageView) view;
            int tag = (Integer) img.getTag();
            int row = (int) Math.floor(tag / 3);
            int col = tag % 3;
            Log.i("LOG", "cells : " + row + " , " + col);
            if (Activity_First.this.cells[row][col] > 0) {
                Toast.makeText(Activity_First.this, "please tre another cell", Toast.LENGTH_SHORT).show();
                return;
            }
            if (Activity_First.this.IsPlayerOne) {
                img.setImageResource(R.drawable.playero);
                Activity_First.this.cells[row][col] = 1;
            } else {
                img.setImageResource(R.drawable.playerx);
                Activity_First.this.cells[row][col] = 2;
            }
            Activity_First.this.IsPlayerOne = !Activity_First.this.IsPlayerOne;
            Activity_First.this.ChangePlayer();
            Activity_First.this.CheckWin();
        };
        for (int i = 0; i < 9; i++) {
            this.images[i].setTag(i);
            this.images[i].setOnClickListener(clickListener);
        }
        ResetGame();
    }

    public void CheckWin() {
        for (int i = 0; i < 3; i++) {
            if (this.cells[i][0] != 0 && this.cells[i][0] == this.cells[i][1] && this.cells[i][1] == this.cells[i][2]) {
                ChangeWins(this.cells[i][0]);
                ResetGame();
                return;
            } else if (this.cells[0][i] != 0 && this.cells[0][i] == this.cells[1][i] && this.cells[1][i] == this.cells[2][i]) {
                ChangeWins(this.cells[0][i]);
                ResetGame();
                return;
            }
        }
        if (this.cells[0][0] != 0 && this.cells[0][0] == this.cells[1][1] && this.cells[1][1] == this.cells[2][2]) {
            ChangeWins(this.cells[0][0]);
            ResetGame();
        } else if (this.cells[0][2] != 0 && this.cells[0][2] == this.cells[1][1] && this.cells[1][1] == this.cells[2][0]) {
            ChangeWins(this.cells[0][2]);
            ResetGame();
        }
    }

    public void ResetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.cells[i][j] = 0;
            }
        }
        for (int i2 = 0; i2 < 9; i2++) {
            this.images[i2].setImageResource(0);
        }
        ChangePlayer();
    }

    public void ChangeWins(int WinnerId) {
        if (WinnerId == 1) {
            this.Playerone++;
            this.txt_PlayerOne.setText(String.valueOf(this.Playerone));
            return;
        }
        this.Playertwo++;
        this.txt_PlayerTwo.setText(String.valueOf(this.Playertwo));
    }

    public void ChangePlayer() {
        if (this.IsPlayerOne) {
            this.PlayerOne.setTextColor(Color.parseColor("#f4394f"));
            this.PlayerTwo.setTextColor(Color.parseColor("#FFFFFF"));
            return;
        }
        this.PlayerTwo.setTextColor(Color.parseColor("#f4394f"));
        this.PlayerOne.setTextColor(Color.parseColor("#FFFFFF"));
    }
}
