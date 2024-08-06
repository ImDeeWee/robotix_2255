import org.example.Model.Utilisateur;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class UtilisateurTest {

    @Test
    public void testAddFollower() {
        Utilisateur utilisateur = new Utilisateur("test@example.com", "test", "password", "12345", "Test", "User", "Test Company", new ArrayList<>());
        String follower = "follower@example.com";
        utilisateur.addFollower(follower);
        assertTrue(utilisateur.getFollowers().contains(follower));
    }

    @Test
    public void testRemoveFollower() {
        Utilisateur utilisateur = new Utilisateur("test@example.com", "test", "password", "12345", "Test", "User", "Test Company", new ArrayList<>());
        String follower = "follower@example.com";
        utilisateur.addFollower(follower);
        utilisateur.removeFollower(follower);
        assertFalse(utilisateur.getFollowers().contains(follower));
    }

    @Test
    public void testAddFollowing() {
        Utilisateur utilisateur = new Utilisateur("test@example.com", "test", "password", "12345", "Test", "User", "Test Company", new ArrayList<>());
        String following = "following@example.com";
        utilisateur.addFollowing(following);
        assertTrue(utilisateur.getFollowing().contains(following));
    }

    @Test
    public void testRemoveFollowing() {
        Utilisateur utilisateur = new Utilisateur("test@example.com", "test", "password", "12345", "Test", "User", "Test Company", new ArrayList<>());
        String following = "following@example.com";
        utilisateur.addFollowing(following);
        utilisateur.removeFollowing(following);
        assertFalse(utilisateur.getFollowing().contains(following));
    }
}
