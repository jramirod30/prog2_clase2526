package pilas.excepciones;

@SuppressWarnings("serial")
public class FullStackException extends Exception {
	public FullStackException(){}
	public FullStackException (String msg){
		super(msg);
	}
}
