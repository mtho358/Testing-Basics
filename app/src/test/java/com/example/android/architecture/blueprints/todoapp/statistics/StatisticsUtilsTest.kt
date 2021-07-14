@file:Suppress("DEPRECATION")

package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StatisticsUtilsTest{

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros(){

        //Create an active task
        val tasks = listOf<Task>()

        //Call your function
        val result = getActiveAndCompletedStats(tasks)

        //Check the result - JUnit
        assertEquals(result.activeTasksPercent, 0f)
        assertEquals(result.completedTasksPercent, 0f)
    }

    @Test
    fun getActiveAndCompleted_noActive_returnsZeroHundred(){
        //Create an active task
        val tasks = listOf(
            Task("title", "desc", isCompleted = true)
        )

        //Call your function
        val result = getActiveAndCompletedStats(tasks)

        //Check the result
        //Homcrest assertion test that makes the documentation of the
        //test understandable by putting it in readable human format.
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }


    @Test
    fun getActiveAndCompletedStats_error_returnsZeros(){

        //Call your function
        val result = getActiveAndCompletedStats(null)

        //Check the result - JUnit
        assertEquals(result.activeTasksPercent, 0f)
        assertEquals(result.completedTasksPercent, 0f)
    }

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        //Create an active task
        val tasks = listOf(
            Task("title", "desc", isCompleted = false)
        )

        //Call your function
        val result = getActiveAndCompletedStats(tasks)

        //Check the result
        //JUnit assertion tests
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 100f)

        //Homcrest assertion test that makes the documentation of the
        //test understandable by putting it in readable human format.
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedTasks_both_returnsFortySixty(){
        //Create active tasks
        val tasks = listOf(
            Task("Test1", "desc", isCompleted = true),
            Task("Test2", "desc", isCompleted = true),
            Task("Test3", "desc", isCompleted = false),
            Task("Test4", "desc", isCompleted = false),
            Task("Test5", "desc", isCompleted = false)
        )

        //Call your function
        val result = getActiveAndCompletedStats(tasks)

        //Check the result - HomCrest
        assertThat(result.activeTasksPercent, `is`(60F))
        assertThat(result.completedTasksPercent, `is`(40f))
    }

}