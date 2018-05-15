package repositoryservicesfacades;
/**
 * @author Mohammad Shinawi
 *
 */
public class SysException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public SysException() {
		
		super();
		
	}
	
	public SysException(String message) {
		
		super(message);

	}
	
	public SysException(Throwable cause) {
		
		super(cause);

	}
	
	public SysException(String message, Throwable cause) {
		
		super(message, cause);

	}

}
