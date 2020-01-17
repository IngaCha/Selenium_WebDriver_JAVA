package com.trainings.maven.JUnit;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.trainings.maven.JUnit.JUnit1stTestPOM;
import com.trainings.maven.JUnit.JUnit2ndTestPOM;
import com.trainings.maven.JUnit.FastRunningTests;

//@RunWith(Suite.class)
@RunWith(Categories.class)
//@IncludeCategory(FastRunningTests.class)
@ExcludeCategory(FastRunningTests.class)
@SuiteClasses({ JUnit1stTestPOM.class, JUnit2ndTestPOM.class })

public class AllJUnitTestsPOM {

}
