/**
 * Copyright 2012 Pune-GDG (http://meetup.com/pune-gdg)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.punegdg.kinosense.actions;

import java.util.Map;

import android.content.Context;

/**
 * Action which can change the Brightness of the device. <code>
 * 		AbstractAction action = new BrightnessAction();
 * 		Map data = new HashMap();
 * 		data.put("Brightness","HIGH");
 * 	 	action.perform(data);
 * </code>
 * 
 * @author "Sandeep Mane"<sandeepsmane@ymail.com>
 */

public class BrightnessAction implements AbstractAction {
    /**
     * Android Application Context
     */

    private Context context = null;

    public void onCreate(final Context context) {
        this.context = context;
    }

    public void perform(final Map<String, Object> brightnessData) {
        int action = (Integer) brightnessData.get(ActionIdConstants.ACTION_ID);
        boolean state = (Boolean) brightnessData.get(ActionIdConstants.DISABLEACTION);
        if ((ActionIdConstants.BRIGHTNESS_HIGH == action) && state) {
            android.provider.Settings.System.putInt(this.context.getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS, 100);
            /**
             * Brightness Set to 100 as High
             */
        } else if ((ActionIdConstants.BRIGHTNESS_LOW == action) && state) {
            android.provider.Settings.System.putInt(this.context.getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS, 10);
            /**
             * Brightness Set to 10 as low
             */
        }
    }

    public void onDestroy() {
    }
}