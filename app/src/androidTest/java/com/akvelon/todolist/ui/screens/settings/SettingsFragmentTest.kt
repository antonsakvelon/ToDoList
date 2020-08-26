package com.akvelon.todolist.ui.screens.settings

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import com.akvelon.todolist.R
import com.microsoft.appcenter.espresso.Factory
import com.microsoft.appcenter.espresso.ReportHelper
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SettingsFragmentTest {
    @After
    fun tearDown() {
        reportHelper.label("Stopping App")
    }

    @get:Rule
    var reportHelper: ReportHelper = Factory.getReportHelper()

    @Test
    fun testShowDoneToDosSwitch() {
        launchFragmentInContainer<SettingsFragment>()
        onView(withId(R.id.showSwitch)).check(matches(isDisplayed()))
        try {
            onView(withId(R.id.showSwitch)).check(matches(isChecked()))
            onView(withId(R.id.showSwitch)).perform(click()).check(matches(isNotChecked()))
        } catch (e: AssertionError) {
            onView(withId(R.id.showSwitch)).perform(click()).check(matches(isChecked()))
        }
    }
}
