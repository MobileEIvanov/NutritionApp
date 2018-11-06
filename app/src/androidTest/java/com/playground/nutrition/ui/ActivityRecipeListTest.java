package com.playground.nutrition.ui;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.playground.nutrition.R;
import com.playground.nutrition.ui.recipes.ActivityRecipeList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Tests for the notes screen, the main screen which contains a grid of all notes.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ActivityRecipeListTest {


    @Rule
    public ActivityTestRule<ActivityRecipeList> mRecipeListActivityTestRule = new ActivityTestRule<>(ActivityRecipeList.class);


    @Test
    public void test_list_is_Displayed() {
        onView(withId(R.id.rv_recipes)).check(matches(isDisplayed()));
    }




}