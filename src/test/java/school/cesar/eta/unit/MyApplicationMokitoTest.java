package school.cesar.eta.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MyApplicationMokitoTest {
    Message msg;

    @InjectMocks
    MyApplication app;

    @Mock
    MessageService service;

    @BeforeEach
    public void setup(){
        msg = new Message();
    }

    @Test
    public void processMessage_withNoMessage_false(){
        when(service.send(null)).thenReturn(false);
        boolean result = app.processMessage(null);
        Assertions.assertFalse(result);
    }

    @Test
    public void processMessage_anyMessage_true(){
        when(service.send(msg)).thenReturn(true);
        boolean result = app.processMessage(msg);
        Assertions.assertTrue(result);
    }

//    @Test
//    public void processMessage_someMessage_sameMessageIsSent(){
//        app.processMessage(msg);
//        verify(service, times(1)).send(msg);
//    }

//    @Test
//    public void processMessage_someMessage_sameMessageIsSent_stub(){
//        app.processMessage(this.msg);
//        Assertions.assertSame(this.msg, message[0]);
//    }
}
