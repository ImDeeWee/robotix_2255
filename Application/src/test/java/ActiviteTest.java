
import org.example.Model.Activite;
import org.example.Model.Tache;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ActiviteTest {

    @Test
    public void testAddTache() {
        Activite activite = new Activite("Test Activity", 10, LocalDate.now(), LocalDate.now().plusDays(1));
        Tache tache = new Tache();
        activite.addTache(tache);
        assertTrue(activite.getTaches().contains(tache));
    }

    @Test
    public void testRemoveTache() {
        Activite activite = new Activite("Test Activity", 10, LocalDate.now(), LocalDate.now().plusDays(1));
        Tache tache = new Tache();
        activite.addTache(tache);
        activite.removeTache(tache);
        assertFalse(activite.getTaches().contains(tache));
    }

    @Test
    public void testAddInteret() {
        Activite activite = new Activite("Test Activity", 10, LocalDate.now(), LocalDate.now().plusDays(1));
        String interet = "Test Interest";
        activite.addInteret(interet);
        assertTrue(activite.getInterets().contains(interet));
    }

    @Test
    public void testRemoveInteret() {
        Activite activite = new Activite("Test Activity", 10, LocalDate.now(), LocalDate.now().plusDays(1));
        String interet = "Test Interest";
        activite.addInteret(interet);
        activite.removeInteret(interet);
        assertFalse(activite.getInterets().contains(interet));
    }

}
