package school.cesar.eta.unit;

public class MessageServiceMock extends MessageService{
    @Override
    public boolean send(Message msg) {
        return false;
    }
}
