package se.juneday.cavetest.classes;

import se.itu.game.cave.Thing;
import se.itu.game.cave.Room;
import static se.itu.game.cave.Room.Direction.NORTH;
import static se.itu.game.cave.Room.Direction.EAST;
import static se.itu.game.cave.Room.Direction.SOUTH;
import static se.itu.game.cave.Room.Direction.WEST;

import static se.juneday.cavetest.utils.Log.log;
import static se.juneday.cavetest.utils.Log.logn;

import java.util.List;
import java.util.ArrayList;

public class RoomTest {

  public static final String DUMMY_DESCR = "A room";
  public static final String DUMMY_THING_NAME = "thingie";
  public static final String DUMMY_N_DESCR = "North room";
  public static final String DUMMY_E_DESCR = "East room";
  public static final String DUMMY_S_DESCR = "South room";
  public static final String DUMMY_W_DESCR = "West room";

  Room north;
  Room east;
  Room south;
  Room west;
  public RoomTest() {
    /*
     * Prepare four rooms for later use
     */
    north = new Room(DUMMY_N_DESCR,
                          null,
                          null,
                          null,
                          null,
                          null);
    east = new Room(DUMMY_E_DESCR,
                          null,
                          null,
                          null,
                          null,
                          null);
    south = new Room(DUMMY_S_DESCR,
                          null,
                          null,
                          null,
                          null,
                          null);
    west = new Room(DUMMY_W_DESCR,
                          null,
                          null,
                          null,
                          null,
                          null);
  }
    
  
  /*
   * No test really, just to check that the constructor uses correct args
   */
  public void checkRoomConstructor() {
    logn("Checking Room constructor: ");    
    Room r = new Room(DUMMY_DESCR,
                      null,
                      null,
                      null,
                      null,
                      null);
    log(" OK");
  }

  /*
   * Test that the List of things passed to the constructor is
   * correctly set (and usable)
   */
  public void checkThings() {
    List<Thing> things = new ArrayList<Thing>();
    log("Checking method things");    

    /*
     * Start with an empty list
     */
    logn(" * with null list");    
    Room r = new Room(DUMMY_DESCR,
                      null,
                      null,
                      null,
                      null,
                      null);
    assert (r.things()==null);
    log(" OK");

    /*
     * Use a list with zero Things in it, check size == 0
     */
    logn(" * with empty list");    
    r = new Room(DUMMY_DESCR,
                      null,
                      null,
                      null,
                      null,
                      things);
    assert (r.things().size()==0);
    log(" OK");

    /*
     * Test that the List of things passed to the constructor is
     * correctly set (and usable)
     */
    logn(" * with one Thing");
    things.add(new Thing(DUMMY_THING_NAME));
    r = new Room(DUMMY_DESCR,
                      null,
                      null,
                      null,
                      null,
                      things);
    assert (r.things().size()==1);
    log(" OK");

    /*
     * Check that we get an exception when trying to modify the list
     * of Things.
     */
    logn(" * modifying thing");
    try {
      /* Adding should throw an exception - the list shall be
       * unmodifiable */
      r.things().add(new Thing(DUMMY_THING_NAME));
      /* If we get here, we did not get an exception... which means
       * that the list was modifiable and this is wrong */
      log(" FAIL");
    } catch (Exception e) {
      /* Getting an exception when trying to modify an unmodifiable
       * list should give an exception, so getting here is correct
       * :) */
      log(" OK ");
      return ;
    }
  }
    
  public void checkGetRoom() {
    log("Checking method getRoom");    

    /*
     * Check that we get null as room - if null was set in the constructor call
     */
    logn(" * with null rooms");    
    Room r = new Room(DUMMY_DESCR,
                      null,
                      null,
                      null,
                      null,
                      null);
    assert (r.getRoom(NORTH)==null);
    assert (r.getRoom(EAST)==null);
    assert (r.getRoom(SOUTH)==null);
    assert (r.getRoom(WEST)==null);
    log(" OK");


    /*
     * Make sure that we get valid rooms - as set in the constructor call
     */
    logn(" * with valid rooms");    
    r = new Room(DUMMY_DESCR,
                 north,
                 east,
                 south,
                 west,
                 null);
    assert (r.getRoom(NORTH)==north);
    assert (r.getRoom(EAST)==east);
    assert (r.getRoom(SOUTH)==south);
    assert (r.getRoom(WEST)==west);
    log(" OK");
  }

  public void checkSetConnectingRoom() {
    log("Checking method setConnectingRoom:");    

    /*
     * Make sure that we can set a Room to null
     */
    logn(" * with null rooms");    
    Room r = new Room(DUMMY_DESCR,
                      null,
                      null,
                      null,
                      null,
                      null);
    r.setConnectingRoom(NORTH, null);
    r.setConnectingRoom(EAST, null);
    r.setConnectingRoom(SOUTH, null);
    r.setConnectingRoom(WEST, null);
    assert (r.getRoom(NORTH)==null);
    assert (r.getRoom(EAST)==null);
    assert (r.getRoom(SOUTH)==null);
    assert (r.getRoom(WEST)==null);
    log(" OK");

    /*
     * Make sure that we can set rooms to a valid Room
     */
    logn(" * with valid rooms");    
    r = new Room(DUMMY_DESCR,
                      null,
                      null,
                      null,
                      null,
                      null);
    r.setConnectingRoom(NORTH, north);
    r.setConnectingRoom(EAST, east);
    r.setConnectingRoom(SOUTH, south);
    r.setConnectingRoom(WEST, west);
    assert (r.getRoom(NORTH)==north);
    assert (r.getRoom(EAST)==east);
    assert (r.getRoom(SOUTH)==south);
    assert (r.getRoom(WEST)==west);
    log(" OK");
  }


  public void checkRemoveThing() {
    List<Thing> things = new ArrayList<Thing>();
    Thing t = new Thing(DUMMY_THING_NAME);
    things.add(t);
    log("Checking method removeThing");    

    /*
     * Make sure that we get an exception when removing null (Thing)
     */
    logn(" * with null thing");    
    Room r = new Room(DUMMY_DESCR,
                      null,
                      null,
                      null,
                      null,
                      things);
    try {
      r.removeThing(null);
      log(" FAIL");
    } catch (Exception e) {
      log(" OK");
    }

    /*
     * Make sure that number of Things is 1 in the list
     */
    logn(" * size correct before removal");    
    assert(r.things().size()==1);
    log(" OK");

    /*
     * Remove Thing t from things - should not cause an exception.
     */
    logn(" * remove valid thing");    
    r.removeThing(t);
    log(" OK");

    /*
     * Make sure that number of Things is 0 in the list
     */
    logn(" * size correct after removal");    
    assert(r.things().size()==0);
    log(" OK");
  }
  
  public static void main(String []args) {
    RoomTest rt = new RoomTest();
    rt.checkRoomConstructor();
    rt.checkThings();
    rt.checkGetRoom();
    rt.checkSetConnectingRoom();
    rt.checkRemoveThing();
  }
  
}

