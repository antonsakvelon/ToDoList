package com.akvelon.todolist.ui.screens.details

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.runner.AndroidJUnit4
import com.akvelon.todolist.R
import com.microsoft.appcenter.espresso.Factory
import com.microsoft.appcenter.espresso.ReportHelper
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailsActivityTest {
    @After
    fun tearDown() {
        reportHelper.label("Stopping App")
    }

    @Rule
    var reportHelper: ReportHelper = Factory.getReportHelper()

    @get:Rule
    var activityRule: ActivityScenarioRule<DetailsActivity> =
        ActivityScenarioRule(DetailsActivity::class.java)

    @Test
    fun testCancelButton() {
        assertEquals(Lifecycle.State.RESUMED, activityRule.scenario.state)
        onView(withId(R.id.buttonCancel)).check(matches(isDisplayed())).perform(click())
        assertEquals(Lifecycle.State.DESTROYED, activityRule.scenario.state)
    }
}