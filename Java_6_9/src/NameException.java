/**
 * 自定义的异常类（用户名异常）
 */
public class NameException extends RuntimeException{

    public NameException() {
    }

    public NameException(String message) {
        super(message);
    }
}
