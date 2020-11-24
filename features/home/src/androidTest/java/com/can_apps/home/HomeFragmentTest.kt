package com.can_apps.home

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.can_apps.home.app.HomeFragment
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @Test
    fun givenHomeScreen_whenOnQuestionButtonClicked_thenNavigateToQuestionsFragment() {
        //Given
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )
        navController.setGraph(R.navigation.nav_graph_home)

        val titleScenario = launchFragmentInContainer<HomeFragment>()

        titleScenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        //When
        onView(ViewMatchers.withId(R.id.questionButton)).perform(ViewActions.click())

        //Then
        assertEquals(navController.currentDestination?.id, R.id.questionsFragment)
    }
}