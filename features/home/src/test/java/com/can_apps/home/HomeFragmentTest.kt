package com.can_apps.home

import android.os.Build
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.can_apps.home.app.HomeFragment
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.LOLLIPOP])
@RunWith(AndroidJUnit4::class)
internal class HomeFragmentTest {

    private lateinit var scenario: FragmentScenario<HomeFragment>
    private lateinit var navController: NavController

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer<HomeFragment>()
        navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )
        navController.setGraph(R.navigation.nav_graph_home)
    }

    @After
    fun tearDown() {
        scenario.moveToState(Lifecycle.State.DESTROYED)
    }

    @Test
    fun `GIVEN home screen, WHEN question button clicked, THEN navigate to questions fragment`() {
        // Given
        val expectedFragment = R.id.questionsFragment
        val viewMatcher = ViewMatchers.withId(R.id.questionButton)
        val performAction = ViewActions.click()

        scenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        // When
        onView(viewMatcher).perform(performAction)

        // Then
        assertEquals(expectedFragment, navController.currentDestination?.id)
    }

    @Test
    fun `GIVEN home screen, WHEN login button clicked, THEN navigate to login fragment`() {
        // Given
        val expectedFragment = R.id.loginFragment
        val viewMatcher = ViewMatchers.withId(R.id.loginButton)
        val performAction = ViewActions.click()

        scenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        // When
        onView(viewMatcher).perform(performAction)

        // Then
        assertEquals(expectedFragment, navController.currentDestination?.id)
    }
}
