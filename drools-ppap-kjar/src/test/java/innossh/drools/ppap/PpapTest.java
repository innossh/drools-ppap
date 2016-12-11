package innossh.drools.ppap;

import innossh.drools.ppap.model.Apple;
import innossh.drools.ppap.model.Pen;
import innossh.drools.ppap.model.Pineapple;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import static org.junit.Assert.assertEquals;


public class PpapTest {

    @Test
    public void testPpap() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("PpapKBase.session");

        Pen pen = new Pen();
        Apple apple = new Apple();
        Pineapple pineapple = new Pineapple();
        kieSession.insert(pen);
        kieSession.insert(apple);
        kieSession.insert(pineapple);

        int rules = kieSession.fireAllRules();
        assertEquals(3, rules);
    }

}
