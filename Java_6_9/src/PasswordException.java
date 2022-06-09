/**
 * 自定义的异常类（密码异常）
 */
public class PasswordException extends RuntimeException{

    public PasswordException() {
    }

    public PasswordException(String message) {
        super(message);
    }
}
