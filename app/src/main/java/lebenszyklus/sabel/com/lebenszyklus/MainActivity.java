package lebenszyklus.sabel.com.lebenszyklus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;


    private static final String TAG = MainActivity.class.getSimpleName();

    public void log(String text) {
        Log.i(TAG, text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log("onCeate");     // erste Methode   (Activity Running)
                                // zurück von gekillter App
        listView = findViewById(R.id.listview);
        arrayList = new ArrayList<>(Arrays.asList("Philipp", "Schweiger", "Blubb"));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, arrayList.get(position));
                Toast.makeText(MainActivity.this, "Hallo" + arrayList.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        log("onStart");     // zweite Methode   (Activity Running)
                                 // zurück von onRestart()
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume");   // dritte Methode   (Activity Running)
                                // zurück von onPause()
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        log("onRestart");   // zurück von onStop()
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("onPause");     // 1. Activity geht in den Hintergrund  (Activity wird herunter gefahren)
                                // kann gekillt werden --> onCreate()
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("onStop");      // 2. Activity geht in den Hintergrund  (Activity wird herunter gefahren)
                                // kann gekillt werden --> onCreate()
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy");   // 3. Activitey geht in den Hintergrund  (Activity wird herunter gefahren)
                                // sauberes herunterfahren
    }


}
