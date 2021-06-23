add_test( HelloTest.BasicAssertions /cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/cmake-build-debug/Algorithms.exe [==[--gtest_filter=HelloTest.BasicAssertions]==] --gtest_also_run_disabled_tests)
set_tests_properties( HelloTest.BasicAssertions PROPERTIES WORKING_DIRECTORY /cygdrive/c/Users/atremblay/Documents/GitHub/interview-prep/Algorithms/cmake-build-debug SKIP_REGULAR_EXPRESSION [==[\[  SKIPPED \]]==])
set( Algorithms_TESTS HelloTest.BasicAssertions)
