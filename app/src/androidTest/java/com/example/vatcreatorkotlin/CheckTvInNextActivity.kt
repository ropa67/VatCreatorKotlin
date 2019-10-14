package com.example.vatcreatorkotlin


import android.inputmethodservice.Keyboard
import android.support.test.espresso.DataInteraction
import android.support.test.espresso.ViewInteraction
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.*
import android.support.test.espresso.matcher.ViewMatchers.*

import com.example.vatcreatorkotlin.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class CheckTvInNextActivity {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest9() {


        onView(withId(R.id.price_et)).check(matches(isDisplayed())).perform(click())

        onView(withId(R.id.price_et)).perform(replaceText("00000000000"))
        Espresso.closeSoftKeyboard()

        Thread.sleep(4000)
        onView(withId(R.id.nextActivity)).perform(click())
        Thread.sleep(4000)

        onView(withId(R.id.howMuch_tv)).check(matches(isDisplayed())).check(matches(withText("0.00 zł")))

        onView(withId(R.id.priceAddeded_tv)).check(matches(isDisplayed())).check(matches(withText("0.00 zł")))

        onView(withId(R.id.savedOn_vat)).check(matches(isDisplayed())).check(matches(withText("0.00 zł")))

        onView(withId(R.id.toCalcuIncome)).check(matches(isDisplayed())).check(matches(withText("0.00 zł")))

        onView(withId(R.id.savedOnIncome)).check(matches(isDisplayed())).check(matches(withText("0.00 zł")))

        onView(withId(R.id.realPriceProduct)).check(matches(isDisplayed())).check(matches(withText("0.00 zł")))

        onView(withId(R.id.realPriceProduct)).check(matches(isDisplayed())).check(matches(withText("0.00 zł")))

    }
    }
