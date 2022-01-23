import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.assertEquals;

/** 
* Manejador Tester. 
* 
* @author Jose Andres Auyon
* @since <pre>Jan 22, 2022</pre> 
* @version 1.0 
*/ 
public class ManejadorTest {
    Manejador manejador = null;

@Before
public void before() throws Exception {
    manejador = new Manejador();
} 

@After
public void after() throws Exception {
    manejador = null;
} 

/** 
* 
* Method: val_menu_entry(String x) 
* 
*/ 
@Test
public void testVal_menu_entry() throws Exception { 

    assertEquals(true, manejador.val_menu_entry("1"));
    assertEquals(true, manejador.val_menu_entry("6"));
    assertEquals(false, manejador.val_menu_entry("0"));
    assertEquals(false, manejador.val_menu_entry("9"));
    assertEquals(false, manejador.val_menu_entry("no numero"));
}


} 
