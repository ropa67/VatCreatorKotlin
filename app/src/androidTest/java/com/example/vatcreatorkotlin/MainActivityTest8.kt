package com.example.vatcreatorkotlin


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest8 {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest8() {


        onView(withId(R.id.switchVat)).perform(click())

        onView(withId(R.id.vat_spinner)).check(matches(withSpinnerText(Matchers.containsString("0%"))))
        onView(withId(R.id.incomeSpinner)).check(matches(withSpinnerText(Matchers.containsString("18"))))

        onView(withId(R.id.switchVat)).perform(click())

        onView(withId(R.id.switchCar)).perform(click())

        onView(withId(R.id.switchVat)).perform(click())

        onView(withId(R.id.price_et)).check(matches(withText("")))

        onView(withId(R.id.switchVat)).check(matches(isDisplayed()))

        onView(withId(R.id.switchCar)).check(matches(isDisplayed()))

        onView(withId(R.id.nextActivity)).check(matches(isDisplayed())).perform(click())

    }
}
