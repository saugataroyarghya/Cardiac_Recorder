package com.example.cardiac_recorder;

import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.*;

import android.view.View;
import android.widget.AbsListView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import java.util.Objects;

@RunWith(AndroidJUnit4.class)
@LargeTest

/**
 * ALl CRUD operations
 */
public class CRUDTest {


    @Rule
    public ActivityScenarioRule<CRUD> activityScenarioRule = new ActivityScenarioRule<CRUD>(CRUD.class);

    /**
     * UI test Create all the function for create Delete and update function.
     */
    @Test
    public void testAll() {

        addData();
        editData();
        testDelete();

    }

    /***
     * Add data method . where add the health info data
     */
    @Test
    public void addData(){


        onView(withId(R.id.insert)).perform(click());

        onView(withId(R.id.date)).perform(click());
        onView(ViewMatchers.withText("OK")).perform(click());

        onView(withId(R.id.time)).perform(click());
        onView(ViewMatchers.withText("OK")).perform(click());

        onView(withId(R.id.dp)).perform(ViewActions.typeText("80"));
        onView(withId(R.id.sp)).perform(ViewActions.typeText("120"));
        onView(withId(R.id.hr)).perform(ViewActions.typeText("100"));


        Espresso.pressBack(); //hide keyboard

        int prevCount = getTotalItem();
        System.out.println(prevCount);

        onView(withId(R.id.button_insert)).perform(click());
        Espresso.pressBack();

        try {
            Thread.sleep(3000); // Delay in milliseconds (e.g., 3000 ms = 3 seconds)
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        int curCount = getTotalItem();
        System.out.println(curCount);


        assertEquals(prevCount,curCount-1);
    }

    /**
     * Edit data method . where update a specific health info data
     */
    @Test
    public void editData() {
        try {
            Thread.sleep(3000); // Delay in milliseconds (e.g., 3000 ms = 3 seconds)
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        ///baki hay mera dost

        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, longClick()));


        onView(ViewMatchers.withText("UPDATE")).perform(click());


        onView(withId(R.id.udp)).perform(clearText());
        onView(withId(R.id.udp)).perform(ViewActions.typeText("70"));

        onView(withId(R.id.usp)).perform(clearText());
        onView(withId(R.id.usp)).perform(ViewActions.typeText("110"));


        onView(withId(R.id.uhr)).perform(clearText());
        onView(withId(R.id.uhr)).perform(ViewActions.typeText("90"));

        Espresso.pressBack(); //hide keyboard


        int prevCount = getTotalItem();

        onView(withId(R.id.button_update)).perform(click());

        try {
            Thread.sleep(1000); // Delay in milliseconds (e.g., 3000 ms = 3 seconds)
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        int curCount = getTotalItem();

        assertEquals(prevCount, curCount);
    }
    /***
     * Delete  data method . where Delete a health info data from database
     */
        @Test
    public void testDelete(){
        try {
            Thread.sleep(3000); // Delay in milliseconds (e.g., 3000 ms = 3 seconds)
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        //onView(withId(R.id.add_btn)).perform(click());

        int prevCount = getTotalItem();
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0,longClick()));
        onView(ViewMatchers.withText("DELETE")).perform(click());

        try {
            Thread.sleep(2000); // Delay in milliseconds (e.g., 3000 ms = 3 seconds)
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        int curCount = getTotalItem();

        assertEquals(prevCount-1,curCount);

        onView(withId(R.id.recyclerView)).perform();
    }

    /**
     * here count the number of element exist in the recycle view
     * @return the number of element in the recycle view
     */
    private int getTotalItem(){
        final int[] initialItemCount = new int[1];
        activityScenarioRule.getScenario().onActivity(activity -> {
            if( ((RecyclerView)activity.findViewById(R.id.recyclerView)).getAdapter() != null ) {
                initialItemCount[0] = Objects.requireNonNull(((RecyclerView) activity.findViewById(R.id.recyclerView)).getAdapter()).getItemCount();
            }
        });
        return initialItemCount[0];
    }

    /**
     * here mainly work with the recycle view
     */
    public static class MyViewAction {

        public static ViewAction clickChildViewWithId(final int id) {
            return new ViewAction() {
                @Override
                public Matcher<View> getConstraints() {
                    return ViewMatchers.isAssignableFrom(RecyclerView.class);
                }

                @Override
                public String getDescription() {
                    return "Click on a child view with specified id.";
                }

                @Override
                public void perform(UiController uiController, View view) {
                    View v = view.findViewById(id);
                    v.performClick();
                }
            };
        }

        //onView(withText("SBP")).check(matches(isDisplayed()));
    }

}