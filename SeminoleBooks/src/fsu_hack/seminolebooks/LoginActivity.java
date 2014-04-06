package fsu_hack.seminolebooks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

public class LoginActivity extends Activity implements OnClickListener {
	
	Facebook fb;
	Button fb_button,e_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		String app_id = getString(R.string.app_id);
		fb = new Facebook(app_id);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public void fb_click(View v) {
		if (!fb.isSessionValid()){
			// log into Facebook
			fb.authorize(LoginActivity.this, new DialogListener() {
				
				@Override
				public void onFacebookError(FacebookError e) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "onFacebookError", Toast.LENGTH_LONG).show();
					
				}
				
				@Override
				public void onError(DialogError e) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "onError", Toast.LENGTH_LONG).show();
					
				}
				
				@Override
				public void onComplete(Bundle values) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "onComplete", Toast.LENGTH_LONG).show();


					
				}
				
				@Override
				public void onCancel() {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "onCancel", Toast.LENGTH_LONG).show();
				}
			
				
			});
			
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			
		}
	}
	
	// 'Sign up with Email' button is clicked.
	public void e_click(View v){
		Intent intent = new Intent(this, RegisterActivity.class);
		startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	

}
