package com.denbar.FreeduinoControl;

import com.denbar.FreeduinoControl.BaseActivity;
import com.denbar.FreeduinoControl.OutputController;

public class FreeduinoControlTablet extends BaseActivity {
	private OutputController mOutputController;

	protected void hideControls() {
		super.hideControls();
		mOutputController = null;
	}

	protected void showControls() {
		super.showControls();
		mOutputController = new OutputController(this, true);
		mOutputController.accessoryAttached();
	}
}
