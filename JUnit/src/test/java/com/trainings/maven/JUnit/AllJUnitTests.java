package com.trainings.maven.JUnit;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.trainings.maven.JUnit.JUnit1stTest;
import com.trainings.maven.JUnit.JUnit2ndTest;
import com.trainings.maven.JUnit.FastRunningTests;;

@Suite.SuiteClasses({ JUnit1stTest.class, JUnit2ndTest.class })

//@RunWith(Suite.class)
@RunWith(Categories.class)
//@IncludeCategory(FastRunningTests.class)
@ExcludeCategory(FastRunningTests.class)

public class AllJUnitTests {

}
