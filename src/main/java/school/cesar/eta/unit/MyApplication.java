package school.cesar.eta.unit;

public class MyApplication {
    private MessageService service = new MessageService();

    public void setService(MessageService service) {
        this.service = service;
    }

    public boolean processMessage(Message msg){
        return service.send(msg);
    }
}
