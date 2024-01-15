package harish.projects.moodtracker;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quote extends AppCompatActivity {
    private List<Integer> listQuotes = new ArrayList<>();
    private int quoteNumber = 0;
    private String mainText = "";
    private TextView tv_text;
    private Button fab_newQuote;

    private ClipData.Item nav_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        tv_text = findViewById(R.id.tv_text);
        fab_newQuote = findViewById(R.id.fab_newQuote);
        quoteOnAppLoaded();
        clickNewQuote();
    }

    private void clickNewQuote() {
        fab_newQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab_newQuote.setEnabled(false);
                if (quoteNumber == listQuotes.size()) {
                    quoteOnAppLoaded();
                } else {
                    typeText(getString(listQuotes.get(quoteNumber)));
                    ++quoteNumber;
                }
            }
        });
    }

    private void quoteOnAppLoaded() {
        fab_newQuote.setEnabled(false);
        quoteNumber = 0;
        Collections.shuffle(listQuotes);
        typeText(getString(listQuotes.get(quoteNumber)));
        ++quoteNumber;
    }

    private void typeText(String text) {
        mainText = "";
        final long textDelay = 50L;
        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                String updatedText = "";
                for (int i = 0; i < text.length(); i++) {
                    mainText = sb.append(updatedText + text.charAt(i)).toString();
                    try {
                        Thread.sleep(textDelay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Handler handler = new Handler();
        Log.d("Main", "Handler started");
        Runnable runnable = new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                tv_text.setText(mainText + "|");
                handler.postDelayed(this, 10);
                if (text.equals(mainText)) {
                    handler.removeCallbacks(this);
                    tv_text.setText(mainText);
                    fab_newQuote.setEnabled(true);
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }

   // @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.nav_share){
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, mainText);
            startActivity(Intent.createChooser(shareIntent, "Share this quote!"));
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }


}


