package com.example.studente_portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class GetStarted extends AppCompatActivity {
    private SlideAdapter myadapter;
    private ViewPager viewPager;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.get_started_layout);
        this.viewPager = (ViewPager) findViewById(R.id.viewpager);
        SlideAdapter slideAdapter = new SlideAdapter(this);
        this.myadapter = slideAdapter;
        this.viewPager.setAdapter(slideAdapter);
        final Button btnstart = (Button) findViewById(R.id.getstartbtn);
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 3) {
                    btnstart.setVisibility(0);
                    btnstart.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            GetStarted.this.startActivity(new Intent(GetStarted.this, LoginActivity.class));
                            GetStarted.this.finish();
                        }
                    });
                    return;
                }
                btnstart.setVisibility(4);
            }

            public void onPageSelected(int position) {
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
