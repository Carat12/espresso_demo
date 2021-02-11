package com.example.espressodemo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest{

    lateinit var mainActivity: ActivityScenario<MainActivity>

    @Before
    fun setup(){
        mainActivity = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun test_mainActivity_display(){
        onView(withId(R.id.text_view_login)).check(matches(withText("Login")))
        onView(withId(R.id.edit_text_email)).check(matches(isDisplayed()))
        onView(withId(R.id.edit_text_pw)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_login)).check(matches(isDisplayed()))
    }

    @Test
    fun test_mainActivity_valid_email_pw(){
        onView(withId(R.id.edit_text_email)).perform(typeText("sc@gmail.com"), closeSoftKeyboard())
        onView(withId(R.id.edit_text_pw)).perform(typeText("123"), closeSoftKeyboard())
        onView(withId(R.id.btn_login)).perform(click())
        //
        onView(withId(R.id.text_view_home)).check(matches(withText("Welcome")))
    }

    @Test
    fun test_mainActivity_invalid_email(){
        onView(withId(R.id.edit_text_email)).perform(typeText("sfd"), closeSoftKeyboard())
        onView(withId(R.id.edit_text_pw)).perform(typeText("123"), closeSoftKeyboard())
        onView(withId(R.id.btn_login)).perform(click())

        onView(withId(R.id.text_view_home)).check(doesNotExist())
    }

    @Test
    fun test_mainActivity_invalid_pw(){
        onView(withId(R.id.edit_text_email)).perform(typeText("sc@gmail.com"), closeSoftKeyboard())
        onView(withId(R.id.edit_text_pw)).perform(typeText("1234325"), closeSoftKeyboard())
        onView(withId(R.id.btn_login)).perform(click())

        onView(withId(R.id.text_view_home)).check(doesNotExist())
    }

    @After
    fun teardown(){
        mainActivity.close()
    }
}