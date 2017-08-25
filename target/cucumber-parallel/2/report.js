$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/devl/workspace/VijayGanji/ecashAutomation/src/test/resources/features/login2.feature");
formatter.feature({
  "line": 1,
  "name": "",
  "description": "",
  "id": "",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "My First scenario",
  "description": "",
  "id": ";my-first-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@run"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I open nationwide",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "get a Quote for 08873",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepdefs.java:17"
});
formatter.result({
  "duration": 2793165601,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "08873",
      "offset": 16
    }
  ],
  "location": "LoginStepdefs.java:25"
});
formatter.result({
  "duration": 262783730,
  "status": "passed"
});
});