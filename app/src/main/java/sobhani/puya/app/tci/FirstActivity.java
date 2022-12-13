package sobhani.puya.app.tci;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;

import sobhani.puya.app.tci.R;

/* loaded from: classes.dex */
public class FirstActivity extends Activity {
    public Typeface typeface;

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        Button btn_next_activity = findViewById(R.id.btn_next_activity);
        this.typeface = Typeface.createFromAsset(getAssets(), "kodak.ttf");
        // from class: kazemi.saeid.app.tic_tac_toa.FirstActivity.1
// android.view.View.OnClickListener
        btn_next_activity.setOnClickListener(view -> {
            Intent intent = new Intent(FirstActivity.this, Activity_First.class);
            FirstActivity.this.startActivity(intent);
            FirstActivity.this.finish();
        });
        btn_next_activity.setTypeface(this.typeface);
    }
}
