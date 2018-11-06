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
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Tests for the notes screen, the main screen which contains a grid of all notes.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ActivityRecipeListTest {

    public static final String SEARCH_QUERY = "Chicken";
    public static final String EMPTY_QUERY = "";
    @Rule
    public ActivityTestRule<ActivityRecipeList> mRecipeListActivityTestRule = new ActivityTestRule<>(ActivityRecipeList.class);


    @Test
    public void test_list_is_Displayed() {
        onView(withId(R.id.rv_recipes)).check(matches(isDisplayed()));
    }


    @Test
    public void test_when_SearchQuery_Available_SearchEnabled() {
        onView(allOf(withParent(withId(R.id.searchViewContent)), withId(R.id.et_search_query))).check(matches(isDisplayed()));

        onView(allOf(withParent(withId(R.id.searchViewContent)), withId(R.id.et_search_query))).perform(typeText(SEARCH_QUERY));

        onView(withId(R.id.btn_search)).check(matches(isEnabled()));

    }

    @Test
    public void test_when_SearchQuery_Not_Available_SearchDisabled() {
        onView(allOf(withParent(withId(R.id.searchViewContent)), withId(R.id.et_search_query))).check(matches(isDisplayed()));

        onView(allOf(withParent(withId(R.id.searchViewContent)), withId(R.id.et_search_query))).perform(typeText(EMPTY_QUERY));

        onView(withId(R.id.btn_search)).check(matches(not(isEnabled())));
    }

    @Test
    public void test_when_Search_is_performed_Clear_input() {
        onView(allOf(withParent(withId(R.id.searchViewContent)), withId(R.id.et_search_query))).perform(typeText(SEARCH_QUERY));

        onView(withId(R.id.btn_search)).perform(click());

        onView(withId(R.id.et_search_query)).check(matches(withText(EMPTY_QUERY)));
        onView(withId(R.id.et_search_query)).check(matches(not(hasFocus())));
    }


    @Test
    public void test_when_Search_Success_RecipesAreDisplayed() {
        onView(withId(R.id.rv_recipes)).check(matches(not(isDisplayed())));

        onView(allOf(withParent(withId(R.id.searchViewContent)), withId(R.id.et_search_query))).perform(typeText(SEARCH_QUERY));
        onView(withId(R.id.btn_search)).perform(click());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        onView(withId(R.id.rv_recipes)).check(matches(isDisplayed()));
    }

}