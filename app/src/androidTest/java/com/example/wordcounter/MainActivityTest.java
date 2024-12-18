package com.example.wordcounter;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testCountWords() {
        onView(withId(R.id.inputText)).perform(typeText("Hello world!"));

        onView(withId(R.id.countTypeSpinner)).perform(click());
        onView(withText("Words")).perform(click());

        onView(withId(R.id.countButton)).perform(click());

        onView(withId(R.id.resultText)).check(matches(withText("Result: 2")));
    }

    @Test
    public void testCountCharacters() {
        onView(withId(R.id.inputText)).perform(typeText("Hello world!"));

        onView(withId(R.id.countTypeSpinner)).perform(click());
        onView(withText("Characters")).perform(click());


        onView(withId(R.id.countButton)).perform(click());

        onView(withId(R.id.resultText)).check(matches(withText("Result: 12")));
    }

    @Test
    public void testEmptyInput() {
        onView(withId(R.id.inputText)).perform(typeText(""));


        onView(withId(R.id.countButton)).perform(click());

        onView(withText("Input field cannot be empty")).check(matches(withText("Input field cannot be empty")));
    }
}