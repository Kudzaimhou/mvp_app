package za.co.jhb.dvt.mvp_app;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements Observer, OnClickListener {

    private Model mModel;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mModel = new Model();
        mModel.addObserver(this);

        mButton1 = (Button) findViewById(R.id.button4);
        mButton2 = (Button) findViewById(R.id.button5);
        mButton3 = (Button) findViewById(R.id.button6);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        mButton1.setText("" + mModel.getValueIndex(0));
        mButton2.setText("" + mModel.getValueIndex(1));
        mButton3.setText("" + mModel.getValueIndex(2));
    }

    @Override
    public void onClick(View view) {
     switch (view.getId()){
         case R.id.button4:
             mModel.setValueAtIndex(0);
             break;
         case R.id.button5:
             mModel.setValueAtIndex(1);
             break;
         case R.id.button6:
             mModel.setValueAtIndex(2);
             break;
     }
    }
}
