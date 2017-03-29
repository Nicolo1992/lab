package courserob;
import org.junit.Test;
import static org.junit.Assert.*;
public class CMOTest {
    public CMOTest() {
    }
    @Test
    public void testSomeMethot() {
    }
    @Test
    public void testService() {
    CMO test1 = new CMO();
    assertEquals(1.445, test1.Service(0.667, 2.167), 0.000389);
    System.out.println("Тест пройден  1.1");
    assertEquals(1.445389, test1.Service(0.667, 2.167), 1e-15);
    System.out.println("Тест пройден  1.2");
  }
    
    @Test
    public void testprobability_e() {
        CMO test1 = new CMO();
        assertEquals(0.250, test1.probability_e(3, 1.445), 0.0006);
        System.out.println("Тест пройден  2.1");
        assertEquals(0.2505, test1.probability_e(3, 1.445), 0.00001);
        System.out.println("Тест пройден  2.2");    
    }
    
    @Test
    public void testprobability_ot() {
        CMO test1 = new CMO();
        assertEquals(0.126, test1.probability_ot(3, 1.445, 0.250), 0.006);
        System.out.println("Тест пройден  3.1");
        assertEquals(0.125, test1.probability_ot(3, 1.445, 0.250), 0.01);
        System.out.println("Тест пройден 3.2");    
    }
    @Test
    public void testprobability_ob() {
        CMO test1 = new CMO ();
        assertEquals(0.874, test1.probability_ob(0.126), 0.01);
        System.out.println("Тест пройден 4.1");
        assertEquals(0.873, test1.probability_ob(0.126), 0.01);
        System.out.println("Тест пройден 4.2");    
    }

}