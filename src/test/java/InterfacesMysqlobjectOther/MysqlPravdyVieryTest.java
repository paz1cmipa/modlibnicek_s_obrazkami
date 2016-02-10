
package InterfacesMysqlobjectOther;

import Entity.PravdyViery;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.jdbc.core.JdbcTemplate;


public class MysqlPravdyVieryTest {
    

    
    private PravdyViery pravda = new PravdyViery();
      MysqlPravdyViery instance = new MysqlPravdyViery();
    
    public MysqlPravdyVieryTest() {
           pravda.setNazov("aa");
        pravda.setObsah("aaa");
     
   
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testPridat() {
        System.out.println("pridat");
             
     
       
       List<PravdyViery> velkostPred = instance.dajVsetky();
      
        instance.pridat(pravda);
        
        List<PravdyViery> velkostPo = instance.dajVsetky();
        assertEquals(velkostPred.size()+1, velkostPo.size());
        
        instance.odstranit(pravda);
        
    }

    
    @Test
    public void testOdstranit() {
        System.out.println("odstranit");
      
       instance.pridat(pravda);
      
       List<PravdyViery> velkostPred = instance.dajVsetky();
        
        instance.odstranit(pravda);
        
        List<PravdyViery> velkostPo = instance.dajVsetky();
        
        assertEquals(velkostPred.size()-1, velkostPo.size());
    }

 @Test
    public void testDajVsetky() {
        System.out.println("dajVsetky");
        List<PravdyViery> result = instance.dajVsetky();
        assertEquals(2, result.size()); 
    }
  
   
    
}
