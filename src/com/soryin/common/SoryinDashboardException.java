package com.soryin.common;

public class SoryinDashboardException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -532842896409337220L;

	public SoryinDashboardException(String msg){
		
		super("<<--【"+msg+"】-->>\n");
	}
	
	public SoryinDashboardException(Exception cause){
		super(cause);
	}
	
	public SoryinDashboardException(String msg,Exception cause){
		super("<<--【"+msg+"】-->>\n",cause);
	}
	private Throwable nested;
	
    public String getMessage()
    {
        if(nested == null){
            return super.getMessage();
        }
        else
            return String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(super.getMessage())))).append("\n嵌套异常: \n\t").append(nested.toString())));
    }
}
