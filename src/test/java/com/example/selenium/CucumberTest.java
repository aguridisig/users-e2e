package com.example.selenium;

import static io.cucumber.junit.platform.engine.Constants.*;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines( "cucumber" )
@SelectClasspathResource( "features" )
@ConfigurationParameter( key = GLUE_PROPERTY_NAME, value = "com.example.selenium" )
public class CucumberTest
{
}

