package mobileapps.agame.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests extends TestSuite
{
  public static Test suite()
  {
    TestSuite mySuite = new TestSuite( "Meine Test-Suite" );
    mySuite.addTestSuite( mobileapps.agame.test.AssertActivityTest.class );
    mySuite.addTestSuite( mobileapps.agame.test.HelpTest.class );
    mySuite.addTestSuite( mobileapps.agame.test.LevelTest.class );
    mySuite.addTestSuite( mobileapps.agame.test.MainTest.class );
    mySuite.addTestSuite( mobileapps.agame.test.PlayTest.class );
    // ... weitere Testklassen hinzufügen
    return mySuite;
  }
}
