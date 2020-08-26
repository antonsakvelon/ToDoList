package com.akvelon.todolist.ui.screens.details

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.runner.AndroidJUnit4
import com.akvelon.todolist.R
import com.microsoft.appcenter.espresso.Factory
import com.microsoft.appcenter.espresso.ReportHelper
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailsActivityTest {
    @After
    fun tearDown() {
        reportHelper.label("Stopping App")
    }

    @get:Rule
    var reportHelper: ReportHelper = Factory.getReportHelper()

    @get:Rule
    var activityRule: ActivityScenarioRule<DetailsActivity> =
        ActivityScenarioRule(DetailsActivity::class.java)

    @Test
    fun testCancelButton() {
        assertTrue(activityRule.scenario.state.isAtLeast(Lifecycle.State.RESUMED))
        onView(withId(R.id.buttonCancel)).check(matches(isDisplayed()))
            .perform(click())
        assertTrue(activityRule.scenario.state.isAtLeast(Lifecycle.State.DESTROYED))
    }

    @Test
    fun testSaveButtonWithoutNameText() {
        assertTrue(activityRule.scenario.state.isAtLeast(Lifecycle.State.RESUMED))
        onView(withId(R.id.buttonSave)).check(matches(isDisplayed()))
            .perform(click())
        assertTrue(activityRule.scenario.state.isAtLeast(Lifecycle.State.RESUMED))
    }

    @Test
    fun testSaveButtonWithNameText() {
        assertTrue(activityRule.scenario.state.isAtLeast(Lifecycle.State.RESUMED))
        onView(withId(R.id.editName)).check(matches(isDisplayed()))
            .perform(typeText("Feed the cat"))
            .perform(closeSoftKeyboard())
        onView(withId(R.id.buttonSave)).check(matches(isDisplayed()))
            .perform(click())
        assertTrue(activityRule.scenario.state.isAtLeast(Lifecycle.State.DESTROYED))
    }
}