package com.example.vatcreatorkotlin


import android.support.test.espresso.Espresso.onView

import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CheckSwitches {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkSwitches() {





        onView(withId(R.id.switchVat)).check(matches(isDisplayed()))
        onView(withId(R.id.switchCar)).check(matches(isDisplayed()))

        onView(withId(R.id.switchVat)).perform(click())
        onView(withId(R.id.switchVat)).check(matches(isChecked()))
        onView(withId(R.id.vat_spinner)).check(matches(withSpinnerText(containsString("0%"))))


        onView(withId(R.id.switchCar)).perform(click())
        onView(withId(R.id.switchCar)).check(matches(isChecked()))





    }

}
