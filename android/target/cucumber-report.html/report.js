$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Local.feature");
formatter.feature({
  "line": 1,
  "name": "BrowserStack Local Testing",
  "description": "",
  "id": "browserstack-local-testing",
  "keyword": "Feature"
});
formatter.before({
  "duration": 24267479458,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "BStack Local Test - Can check tunnel working",
  "description": "",
  "id": "browserstack-local-testing;bstack-local-test---can-check-tunnel-working",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I start test on the Local Sample App",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "I should see \u0027Up and running\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoTest.I_start_test_on_the_local_sample_app()"
});
formatter.result({
  "duration": 1313184459,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Up and running",
      "offset": 14
    }
  ],
  "location": "DemoTest.I_should_see(String)"
});
formatter.result({
  "duration": 202820625,
  "status": "passed"
});
formatter.after({
  "duration": 1952153958,
  "status": "passed"
});
});