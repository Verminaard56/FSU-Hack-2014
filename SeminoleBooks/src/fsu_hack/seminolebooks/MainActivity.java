package fsu_hack.seminolebooks;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

public class MainActivity extends Activity implements OnClickListener {
	
	Facebook fb;
	ImageView fb_button,e_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String app_id = getString(R.string.app_id);
		fb = new Facebook(app_id);
		fb_button = (ImageView)findViewById(R.id.login);
		fb_button.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public void onClick(View v) {
		if (!fb.isSessionValid()){
			// log into Facebook
			fb.authorize(MainActivity.this, new DialogListener() {
				
				@Override
				public void onFacebookError(FacebookError e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onError(DialogError e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onComplete(Bundle values) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onCancel() {
					// TODO Auto-generated method stub
					
				}
			
				
			});
			
		}
	}
	
	

}
