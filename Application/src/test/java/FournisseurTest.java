
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.Model.Fournisseur;

public class FournisseurTest {

    @Test
    public void testSetCapaciteFabrication() {
        Fournisseur fournisseur = new Fournisseur("test@example.com", "test", "password", "12345", 100);
        fournisseur.setCapaciteFabrication(200);
        assertEquals(200, fournisseur.getCapaciteFabrication());
    }
}
