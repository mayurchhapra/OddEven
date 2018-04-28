package generator.oddeven;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity {
	
	Button _check;
	TextView label,reset,result;
	int flg=0;
	float odd=0,even=0,avg_odd=0,avg_even=0;
	
	public void vib(){
		Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		vibe.vibrate(50);
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        _check = (Button) findViewById(R.id.button1);
        label = (TextView)findViewById(R.id.textView1);
        reset = (TextView) findViewById(R.id.textView2);
        result = (TextView) findViewById(R.id.textView3);
          
         
        
        _check.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				vib();
				flg++;
				Random r = new Random();
				int i1 = r.nextInt(100);
				
				String decision = null;
				if(i1%2 == 0){
					even++;
					decision = "Even";
				}
				else{
					odd++;
					decision = "Odd";
				}
				if(flg>4){
					avg_odd = (odd/flg)*100;
					avg_even = (even/flg)*100;
					result.setText("ODD = "+String.format("%.2f", avg_odd)+"% "+"\t EVEN = "+String.format("%.2f",avg_even)+"%");
					flg=0;
					odd=0;
					even=0;
				}
			
				label.animate().alpha(2).setDuration(500);
				label.setText(decision);
			}
		});
        
        reset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				vib();
				avg_odd = (odd/flg)*100;
				avg_even = (even/flg)*100;
				result.setText("");
				flg=0;
				odd=0;
				even=0;
				label.setText("Click to Start");
			}
		});
        
    }
}
