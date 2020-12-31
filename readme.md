<h1>Coding School | Test Automation</h1>

Practical example of a Test Automation Project

<h4>CONFIGURATION</h4>

<b>Properties</b>

- protocol (default value: http)
- host (default value: localhost)
- port (default value: 7001)

To override default values of above properties just use the arguments properly with the maven command. An indicative example is displayed below:
displayed below 

	-Dport=7002

<h4>EXECUTION</h4>

To execute the tests, run below command via CMD or BASH: 

    mvn clean install

<h4>REPORTING</h4>

<b>Cucumber Report only for the UI Tests</b>
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HTML Report named <b>"overview-features.html"</b> is generated in path <b>/target/cucumber/cucumber-html-reports</b> 

<b>JUnit Report for UI and WS Tests</b>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;To generate a report, after the execution, run in sequence below commands via CMD or BASH:

    mvn surefire-report:report -DskipTests
    mvn site -DgenerateReports=false
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HTML Report named <b>"surefire-report.html"</b> is generated in path <b>/target/site</b> 

<b>JMeter Report</b>

After execution, a JMeter Dashboard is generated under target/jmeter/reports/demo-perf-tests/index.html