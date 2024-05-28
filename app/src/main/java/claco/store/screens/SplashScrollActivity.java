package claco.store.screens;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.claco.store.LoginWebView;
import com.claco.store.R;
import com.claco.store.RegisterWebView;
import com.claco.store.WebViewTempActivity;

import java.util.Timer;
import java.util.TimerTask;

import claco.store.adapters.SplashViewPage;

public class SplashScrollActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Timer timer;
    LinearLayout linearLayoutindicator;
    Button  loginbtn, registerbtn;
    TextView skipbtn;

    SplashViewPage splashadapter;

    private int dotsCount;
    private ImageView[] dots;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_scroll);

        loginbtn = findViewById(R.id.loginbtn);
        registerbtn = findViewById(R.id.register);
        skipbtn = findViewById(R.id.skip_btn);
        viewPager = findViewById(R.id.slide);
        linearLayoutindicator = findViewById(R.id.indicator);

        splashadapter = new SplashViewPage(this);
        viewPager.setAdapter(splashadapter);


        timer = new Timer();
        // Modify your TimerTask to update dots when page changes
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int nextPage = viewPager.getCurrentItem() + 1;
                        if (nextPage == splashadapter.getCount()) {
                            viewPager.setCurrentItem(0); // Go back to the first page
                            addDotsIndicator(0);
                        } else {
                            viewPager.setCurrentItem(nextPage);
                            addDotsIndicator(nextPage);
                        }
                    }
                });
            }
        }, 500, 2000); // Delay 0.5s, repeat every 2s
        // Add this to initialize dots
        dotsCount = splashadapter.getCount();
        dots = new ImageView[dotsCount];
        addDotsIndicator(0); // Initially at position 0


        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent i = new Intent(SplashScrollActivity.this, WebViewTempActivity.class);
                startActivity(i);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashScrollActivity.this, LoginWebView.class);
                startActivity(i);
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashScrollActivity.this, RegisterWebView.class);
                startActivity(i);
            }
        });
    }

    private void addDotsIndicator(int position) {
        linearLayoutindicator.removeAllViews(); // Clear previous dots

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            if (i == position) {
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.activee_dot)); // Active dot drawable
            } else {
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.inactive_dot)); // Inactive dot drawable
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(8, 0, 8, 0); // Adjust margin as needed
            params.gravity = Gravity.CENTER;
            linearLayoutindicator.addView(dots[i], params);
        }
    }
}