package exceptions;

public class ListException extends Exception {
    
    private final String msg;
    
    public ListException(String msg) {
        super(msg);
        this.msg = msg;
    }
    
    @Override
    public String getMessage(){
        return this.msg;
    }
}
