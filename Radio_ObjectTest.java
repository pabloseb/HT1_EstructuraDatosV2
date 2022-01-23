import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;

/** 
* Radio_Object Tester. 
* 
* @author Jose Andres Auyon
* @since <pre>Jan 22, 2022</pre> 
* @version 1.0 
*/ 
public class Radio_ObjectTest {
    Radio_Object radio = null;

@Before
public void before() throws Exception {
    radio = new Radio_Object();
} 

@After
public void after() throws Exception {
    radio = null;
} 

/** 
* 
* Method: isOn() 
* 
*/ 
@Test
public void testIsOn() throws Exception { 
    assertEquals(false, radio.isOn());
} 

/** 
* 
* Method: turnOnOff() 
* 
*/ 
@Test
public void testTurnOnOff() throws Exception { 
    radio.turnOnOff();
    assertEquals(true, radio.isOn());
} 

/** 
* 
* Method: nextStation(boolean frequency) 
* 
*/ 
@Test
public void testNextStation() throws Exception { 
    radio.nextStation(true);
    assertEquals(540, radio.getStation(), 0);
} 

/** 
* 
* Method: prevStation(boolean frequency) 
* 
*/ 
@Test
public void testPrevStation() throws Exception { 
    radio.prevStation(true);
    assertEquals(1610, radio.getStation(), 0);
} 

/** 
* 
* Method: getStation() 
* 
*/ 
@Test
public void testGetStation() throws Exception { 
    assertEquals(530, radio.getStation(), 0);
} 


/** 
* 
* Method: getFrequency() 
* 
*/ 
@Test
public void testGetFrequency() throws Exception { 
    assertEquals(true, radio.getFrequency());
} 

/** 
* 
* Method: switchAMFM() 
* 
*/ 
@Test
public void testSwitchAMFM() throws Exception {
    radio.switchAMFM();
    assertEquals(false, radio.getFrequency());
} 


} 
