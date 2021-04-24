package com.epam.testng;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

public class RunnerTestNGTests {

    public static void main(String[] args) {
        /*TestNG testNG = new TestNG();
        testNG.addListener(new TestListeners());

        XmlSuite suite = new XmlSuite();
        suite.setSuiteFiles(Arrays.asList("./src/test/resources/testing.xml"));

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);

        testNG.setXmlSuites(suites);
        testNG.run();*/

        TestNG tng = new TestNG();
        XmlSuite suite = new XmlSuite();

        suite.setName("TmpSuite");
        List<String> files = new ArrayList<>();
        files.addAll(new ArrayList<String>() {{
            add("./src/test/resources/testng.xml");
            }});
        suite.setSuiteFiles(files);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        tng.setXmlSuites(suites);
        tng.run();

    }
}
