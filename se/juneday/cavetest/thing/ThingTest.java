package se.juneday.cavetest.thing;

import se.itu.game.cave.Thing;

import static se.juneday.cavetest.TestHelp.log;
import static se.juneday.cavetest.TestHelp.logn;

public class ThingTest {

  private final static String DUMMY_NAME = "dummy";
  
  /*
   * Not really a runtime test.
   * This is more a compilation test :)
   */
  public void checkThing() {
    logn("Checking Thing constructor: ");
    Thing t = new Thing(DUMMY_NAME);
    log(" OK");
  }

  /*
   * Check name method
   */
  public void checkName() {
    logn("Checking method name: ");
    Thing t = new Thing(DUMMY_NAME);
    assert(t.name().equals(DUMMY_NAME));
    log(" OK");
  }

  /*
   * Check toString method
   */
  public void checkToString() {
    logn("Checking method toString: ");
    Thing t = new Thing(DUMMY_NAME);
    assert(t.toString().equals(DUMMY_NAME));
    log(" OK");
  }


  /*
   * Check equals method
   */
  public void checkEquals() {
    log("Checking method equals");
    logn(" * equal objects: ");
    Thing t = new Thing(DUMMY_NAME);
    Thing o = new Thing(DUMMY_NAME);
    assert(t.equals(o));
    log(" OK");

    logn(" * not equals objects: ");
    Thing different = new Thing("different name");
    assert(!t.equals(different));
    log(" OK");
}


  
  public static void main(String []args) {
    ThingTest tt = new ThingTest();
    tt.checkThing();
    tt.checkName();
    tt.checkToString();
    tt.checkEquals();
  }
  
}
