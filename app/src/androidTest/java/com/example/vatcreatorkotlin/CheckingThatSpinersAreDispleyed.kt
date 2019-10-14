package com.example.vatcreatorkotlin

import android.support.test.espresso.Espresso.onView
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
class CheckingThatSpinersAreDispleyed {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest2() {


        onView(withId(R.id.vat_spinner)).check(matches(isDisplayed()))

        onView(withId(R.id.incomeSpinner)).check(matches(isDisplayed()))

        onView(withId(R.id.vat_spinner)).check(matches(withSpinnerText(containsString("23%"))))
        onView(withId(R.id.incomeSpinner)).check(matches(withSpinnerText(containsString("18"))))


/*
        val appCompatSpinner = onView(
            allOf(
                withId(R.id.incomeSpinner),
                isDisplayed()
            )
        )
        appCompatSpinner.perform(click())

        val appCompatTextView = onData(anything())
            .inAdapterView(
                childAtPosition(
                    withClassName(`is`("android.widget.PopupWindow\$PopupBackgroundView")),
                    0
                )
            )
            .atPosition(2)
        appCompatTextView.perform(click())

        val appCompatButton = onView(
            allOf(
                withId(R.id.nextActivity), withText("Calculate "),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.resetButton), withText("RESET"),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        val editText = onView(
            allOf(
                withId(R.id.price_et),
                isDisplayed()
            )
        )
        editText.check(matches(withText("")))
        onView(withId(R.id.vat_spinner)).check(matches(withSpinnerText(containsString("23%"))))
        onView(withId(R.id.incomeSpinner)).check(matches(withSpinnerText(containsString("18"))))

        val switch_3 = onView(
            allOf(
                withId(R.id.switchVat),
                isDisplayed()
            )
        )
        switch_3.check(matches(isDisplayed()))

        val switch_4 = onView(
            allOf(
                withId(R.id.switchCar),
                isDisplayed()
            )
        )
        switch_4.check(matches(isDisplayed()))

        val button = onView(
            allOf(
                withId(R.id.nextActivity),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val button2 = onView(
            allOf(
                withId(R.id.nextActivity),
                isDisplayed()
            )
        )
        button2.check(matches(isDisplayed()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }

 */
    }
}