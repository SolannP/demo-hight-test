# Demo

![demo as gif](https://github.com/SolannP/demo-hight-test/blob/master/demo_test.gif)

# Additional note

Code have been made in a way that it can be used for others quiz.
Any automation test would be faster to writte because it would be using barely the same code.

To keep test code more lisible, parametrized test haven't been added on the `master` branch. 
However, a parametrized version of this test, great to test boundary, is avalable at branch `parametrized-test` ([link](https://github.com/SolannP/demo-hight-test/blob/parametrized-test/src/test/java/hightest/QuizTests.java))

# Developement setup used

Utterly based on the [Java selenium tutorial][1] using the Page Object Model design pattern

 - OS : Windows
 - Chrome brower v105.0.5195.52
 - [InteliJ Community][2]
 - [ChromeDriver win32][3] (v105.0.5195.52), other version can be find [there][4]
 - [Oracle Open JKD 14.0.2][5] or later

# Possible further improvements

Run in parallel.

Using runner for ci/cd.

Different screen size.

Different navigator.

Better repport (Cucumber?).

> Don't hesitate to provide any feedback

[1]: https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/ "Selenium tutorial by Test Automation University"
[2]: https://www.jetbrains.com/idea/download/ "IntilJ Download page"
[3]: https://chromedriver.storage.googleapis.com/index.html?path=105.0.5195.52/
[4]: https://chromedriver.chromium.org/downloads
[5]: https://jdk.java.net/archive/
