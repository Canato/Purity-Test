package com.can_apps.home

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.can_apps.home.app.HomeFragment
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class HomeFragmentTest {

    private lateinit var scenario: FragmentScenario<HomeFragment>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer<HomeFragment>()
    }

    @After
    fun tearDown() {
        scenario.moveToState(Lifecycle.State.DESTROYED)
    }

    @Test
    fun givenHomeScreen_whenQuestionButtonClicked_thenNavigateToQuestionsFragment() {
        // Given
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )
        navController.setGraph(R.navigation.nav_graph_home)

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
    fun givenHomeScreen_whenLoginButtonClicked_thenNavigateToLoginFragment() {
        // Given
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )
        navController.setGraph(R.navigation.nav_graph_home)

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
