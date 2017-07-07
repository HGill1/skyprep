package com.gill.cucumberPrac;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features ={"src/stories"}, monochrome=true,
tags = "@ssePricing")
public class TestRunner {

}
