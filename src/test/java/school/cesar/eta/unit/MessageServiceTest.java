package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageServiceTest {
    @Test
    public void send_noMessage_throwsAnException(){
        MessageService service = new MessageService();

        Exception result = Assertions.assertThrows(UnsupportedOperationException.class,() -> service.send(null) );
        Assertions.assertEquals("Testing...", result.getMessage());
    }
}
