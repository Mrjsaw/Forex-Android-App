package com.example.changex;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mainActivityActivityTestRule.getActivity();
    }
    @Test
    public void testLaunch() {
        View v = mActivity.findViewById(R.id.main_content);
        assertNotNull(v);
    }


    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}