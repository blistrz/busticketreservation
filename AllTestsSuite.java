import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Specify the runner for the test suite
@RunWith(Suite.class)

// Specify the classes to include in the test suite
@Suite.SuiteClasses({
    LoginDetailTest.class,
    LoginTest.class,
   
})
public class AllTestsSuite {
    // This class remains empty and serves as a holder for the above annotations.
}
