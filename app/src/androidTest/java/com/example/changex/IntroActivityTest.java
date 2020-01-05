package com.example.changex;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import com.example.changex.fragments.exchange_fragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class IntroActivityTest {
    @Rule
    public ActivityTestRule<IntroActivity> introActivityActivityTestRule = new ActivityTestRule<IntroActivity>(IntroActivity.class);

    private IntroActivity iActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(exchange_fragment.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        iActivity = introActivityActivityTestRule.getActivity();
    }
    @Test
    public void testLaunchMainActivityClick(){
        assertNotNull(iActivity.findViewById(R.id.introButton));
        onView(withId(R.id.introButton)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,10000);
        assertNotNull(secondActivity);
        secondActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
        iActivity = null;
    }

}