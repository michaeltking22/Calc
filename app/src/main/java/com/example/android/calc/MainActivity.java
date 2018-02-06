package com.example.android.calc;

import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Total;
    private TextView Tip;
    private EditText inputAmount;
    private EditText inputDinners;
    private SeekBar Bar;
    private CheckBox Split;
    private Button Calculate;
    private TextView Prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Total = findViewById(R.id.outputView);
        Tip = findViewById(R.id.outputView2);
        inputAmount = findViewById(R.id.inputView);
        inputDinners = findViewById(R.id.inputView2);
        Bar = findViewById(R.id.seekBar);
        Split = findViewById(R.id.split);
        Calculate = findViewById(R.id.calculate);
        Prog = findViewById(R.id.Prog);
      Bar.setOnSeekBarChangeListener(
              new SeekBar.OnSeekBarChangeListener() {
                  @Override
                  public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                      int progress = Bar.getProgress();
                      Prog.setText(progress+"%");
                  }

                  @Override
                  public void onStartTrackingTouch(SeekBar seekBar) {

                  }

                  @Override
                  public void onStopTrackingTouch(SeekBar seekBar) {

                  }
              }
      );
    }



    public void calculate(View v){
        String input1 = inputAmount.getText().toString();
        String input2 = inputDinners.getText().toString();
        int progress = Bar.getProgress();
        double percent = progress/100.0;
        double bill = Double.parseDouble(input1);
        int people = Integer.parseInt(input2);
        if(Split.isChecked()){
            bill = bill/people;
            double out = bill*percent;
            bill+=out;
            Tip.setText("Tip Amount: $" +String.format("%.2f", out));
            Total.setText("You owe: $"+String.format("%.2f", bill));
        }
        else{
            double out = bill*percent;
            bill+=out;
            Tip.setText("Tip Amount: $" +String.format("%.2f", out));
            Total.setText("You owe: $"+String.format("%.2f", bill));


        }





    }
}

