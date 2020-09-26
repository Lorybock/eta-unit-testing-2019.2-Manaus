package school.cesar.eta.unit;

public class MessageServiceSpy extends MessageServiceMock {
    public Message msg;

    @Override
    public boolean send(Message msg) {
        this.msg = msg;
        return super.send(msg);
    }
}
