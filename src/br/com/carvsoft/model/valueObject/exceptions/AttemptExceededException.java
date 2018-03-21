package br.com.carvsoft.model.valueObject.exceptions;

/**
 *
 * @author Carlos Rafael
 */
public class AttemptExceededException extends Exception {

    public AttemptExceededException() {
        super("Número máximo de tentativas excedida!");
    }

    public AttemptExceededException(String msg) {
        super(msg);
    }

}
