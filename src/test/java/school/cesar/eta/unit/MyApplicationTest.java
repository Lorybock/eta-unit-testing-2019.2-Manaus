package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyApplicationTest {
    Message msg;
    MyApplication app;

    @BeforeEach
    public void setup(){
        msg = new Message();
        app = new MyApplication();
    }

    @Test
    public void processMessage_withNoMessage_false(){
        app.setService(new MessageServiceMock());
        boolean result = app.processMessage(msg);
        Assertions.assertFalse(result);
    }

    @Test
    public void processMessage_anyMessage_true(){
        MessageService service = new MessageService() {
            @Override
            public boolean send(Message msg) {
                return true;
            }
        };

        app.setService(service);
        boolean result = app.processMessage(msg);
        Assertions.assertTrue(result);
    }

    @Test
    public void processMessage_someMessage_sameMessageIsSent(){
        MessageServiceSpy service = new MessageServiceSpy();
        app.setService(service);
        app.processMessage(msg);
        Assertions.assertSame(msg, service.msg);
    }

    @Test
    public void processMessage_someMessage_sameMessageIsSent_stub(){
        final Message[] message = new Message[1];

        MessageService service = new MessageService() {

            @Override
            public boolean send(Message msg) {
                message[0] = msg;
                return true;
            }
        };
        app.setService(service);
        app.processMessage(this.msg);
        Assertions.assertSame(this.msg, message[0]);
    }
}
