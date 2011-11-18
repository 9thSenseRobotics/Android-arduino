package com.denbar.robotControl;

import android.view.ViewGroup;

import com.denbar.robotControl.AccessoryController;
import com.denbar.robotControl.ColorLEDController;
import com.denbar.robotControl.RobotControlActivity;
import com.denbar.robotControl.R;
import com.denbar.robotControl.RelayController;
import com.denbar.robotControl.ServoController;
import android.view.ViewGroup;

public class OutputController extends AccessoryController {

	private boolean mVertical;

	OutputController(RobotControlActivity hostActivity, boolean vertical) {
		super(hostActivity);
		mVertical = vertical;
	}

	protected void onAccesssoryAttached() {
		setupServoController(1, R.id.pan_Servo);
		setupServoController(2, R.id.tilt_Servo);

		setupLedController(1, R.id.leds1);
		setupLedController(2, R.id.leds2);
		setupLedController(3, R.id.leds3);
	}

	private void setupServoController(int servoIndex, int viewId) {
		ServoController sc = new ServoController(mHostActivity, servoIndex);
		sc.attachToView((ViewGroup) findViewById(viewId));
	}

	private void setupLedController(int index, int viewId) {
		ColorLEDController ledC = new ColorLEDController(mHostActivity, index,
				getResources(), mVertical);
		ledC.attachToView((ViewGroup) findViewById(viewId));
	}

	private void setupRelayController(int index, int viewId) {
		RelayController r = new RelayController(mHostActivity, index,
				getResources());
		r.attachToView((ViewGroup) findViewById(viewId));
	}

}
