package com.example.tayamorinvilleassignment2

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
public class UIAutomatorTest {

    private lateinit var device: UiDevice

    @Test
    fun assignment5Test() {
        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Start from the home screen
        device.pressHome()

        // Launch app
        val appLauncher =
            UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).launcherPackageName
        device.wait(Until.hasObject(By.pkg(appLauncher)), 5000L)
        val context = InstrumentationRegistry.getInstrumentation().context
        val intent =
            context.packageManager.getLaunchIntentForPackage("com.example.tayamorinvilleassignment2")
        intent?.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)

        // Wait for app to launch
        device.wait(
            Until.hasObject(By.pkg("com.example.tayamorinvilleassignment2").depth(0)),
            5000L
        )

        // Click on start activity explicitly button
        val startActivityExplicitlyButton: UiObject2 = device.findObject(
            By.text("Start Activity Explicitly")
        )
        startActivityExplicitlyButton.click()

        // Ensure second activity has one of the 5 challenges of mobile software engineering
        Thread.sleep(2000) // Sleep to allow time for the second activity to load

        val textSelector =
            UiSelector().className("android.widget.TextView")//.textContains("Challenges")

        val uiObj: UiObject = device.findObject(textSelector)

        val containsAtLeastOneChallenge = uiObj.text.contains("Device and OS Fragmentation") ||
                uiObj.text.contains("Unstable and Dynamic Environment") ||
                uiObj.text.contains("Rapid Changes") ||
                uiObj.text.contains("Tool Support") ||
                uiObj.text.contains("Low Tolerance")

        assertTrue(containsAtLeastOneChallenge)
    }
}