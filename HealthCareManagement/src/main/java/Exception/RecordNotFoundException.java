package Exception;

public class RecordNotFoundException extends RuntimeException {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String exceptionDetail;
	    private Object fieldValue;
	    public RecordNotFoundException( String exceptionDetail, int id) {
	        super(exceptionDetail+" - "+id);
	        this.exceptionDetail = exceptionDetail;
	        this.fieldValue = id;
	    }
	    public String getExceptionDetail() {
	        return exceptionDetail;
	    }
	    public Object getFieldValue() {
	        return fieldValue;
	    }
}


