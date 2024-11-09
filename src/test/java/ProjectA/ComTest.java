package ProjectA;
import ProjectA.ListCommands;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ComTest {
    @Test
    public void StartTest() {
        ListCommands listCommands = new ListCommands();
        String message = listCommands.findCommand("/start");
        assertEquals(message, "It is Car_Selector_Bot. Send him /help, if you want to know his commands");
    }
    @Test
    public void HelpTest() {
        ListCommands commandsList = new ListCommands();
        String message = commandsList.findCommand("/help");
        assertTrue(message.contains("/start"));
        assertTrue(message.contains("/information"));
        assertTrue(message.contains("/help"));
        assertTrue(message.contains("/creators"));
    }
}

