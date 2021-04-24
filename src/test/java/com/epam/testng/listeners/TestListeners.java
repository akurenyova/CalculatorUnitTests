package com.epam.testng.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("On Test Start: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("On Test Success: " + result.getName());
    }
}
