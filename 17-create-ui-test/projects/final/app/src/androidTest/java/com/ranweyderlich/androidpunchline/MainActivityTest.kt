package com.ranweyderlich.androidpunchline

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.javafaker.Faker
import com.raywenderlich.android.punchline.Joke
import com.raywenderlich.android.punchline.MainActivity
import com.raywenderlich.android.punchline.R
import com.raywenderlich.android.punchline.Repository
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declareMock
import org.mockito.Mockito
import org.mockito.kotlin.whenever

@RunWith(AndroidJUnit4::class)
class MainActivityTest:KoinTest {

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }

    private val mockRepository: Repository by inject()
    private var faker = Faker()

    @Test
    fun onLaunchButtonIsDisplayed(){
        declareMock<Repository> {
            whenever(getJoke())
                .thenReturn(
                    Single.just(
                        Joke(
                    faker.idNumber().valid(),
                    faker.lorem().sentence())
                    ))
        }
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.buttonNewJoke))
            .check(matches(isDisplayed()))
    }
}