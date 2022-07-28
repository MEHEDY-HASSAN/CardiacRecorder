package com.example.cardiacmonitor;


import static android.service.autofill.Validators.not;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

import android.os.SystemClock;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
//import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HomeActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void test4checkappname(){
        onView(withText("Cardiac Monitor")).check(matches(isDisplayed()));
    }

    @Test
    public void test2addmeasurement(){
        SystemClock.sleep(2000);

        Espresso.onView(withId(R.id.home_add_record)).perform(click());

        Espresso.onView(withId(R.id.Add_Enter_Systolic_pressure)).perform(ViewActions.typeText("120"));
        Espresso.onView(withId(R.id.Add_Enter_Diastolic_pressure)).perform(ViewActions.typeText("80"));
        Espresso.onView(withId(R.id.Add_Enter_Heart_Rate)).perform(ViewActions.typeText("80"));
        Espresso.onView(withId(R.id.ADD_Enter_Measure_Time)).perform(ViewActions.typeText("9:51"));
        Espresso.pressBack(); //Back button
        Espresso.onView(withId(R.id.ADD_Enter_Measure_Date)).perform(ViewActions.typeText("22/07/2022"));
        Espresso.pressBack(); //Back button
        Espresso. onView(withId(R.id.ADD_Enter_Comment)).perform(ViewActions.typeText("Good"));
        Espresso.pressBack(); //Back button
        Espresso.onView(withId(R.id.ADD_ADDButton)).perform(click());

        SystemClock.sleep(2000);

    }



    @Test
    public void test3updatemeasurement(){
        SystemClock.sleep(5000);
        Espresso.onView(withId(R.id.record_recycler_view)).perform(click());
        SystemClock.sleep(1000);

        Espresso.onView(withId(R.id.Update_Enter_Systolic_pressure)).perform(clearText()).perform(ViewActions.typeText("140"));
        Espresso.onView(withId(R.id.Update_Enter_Diastolic_pressure)).perform(clearText()).perform(ViewActions.typeText("100"));
        Espresso.onView(withId(R.id.Update_Enter_Heart_Rate)).perform(clearText()).perform(ViewActions.typeText("80"));

        Espresso.onView(withId(R.id.Update_Enter_Measure_Time)).perform(clearText()).perform(ViewActions.typeText("11:52"));
        Espresso.onView(withId(R.id.Update_Enter_Measure_Date)).perform(clearText()).perform(ViewActions.typeText("31/11/2022"));

        Espresso.pressBack(); //Back button
        Espresso.onView(withId(R.id.Update_Enter_Comment)).perform(clearText()).perform(ViewActions.typeText("Sick"));
        Espresso.pressBack(); //Back button
        SystemClock.sleep(2000);
        onView(withId(R.id.Update_UpdateButton)).perform(click());
        SystemClock.sleep(5000);
    }

    @Test
    public void test4deletemeasurement(){
        SystemClock.sleep(5000);
        Espresso.onView(withId(R.id.record_recycler_view)).perform(click());
        SystemClock.sleep(1000);

        onView(withId(R.id.Update_DeleteButton)).perform(click());

        SystemClock.sleep(5000);
    }


}