import models.Squad;
import org.junit.Test;

import static org.junit.Assert.*;


public class SquadTest {
    @Test
    public void getall_returnsAllInstancesofSquad_true() {
        Squad firstSquad = new Squad(10, "Wakuu", "Racism");
        Squad secondSquad = new Squad(5, "Defenders", "Poverty");
        assertTrue(Squad.getInstances().contains(firstSquad));
        assertTrue(Squad.getInstances().contains(secondSquad));
    }

}
