package com.app.globalexception;

/**
 * Custom exception class for handling resource not found scenarios.
 * Extends the Exception class to represent an exceptional condition that a method can encounter.
 */
@SuppressWarnings("serial")
public class NotFoundException extends Exception
{
	/**
     * Constructor for NotFoundException that takes a message as input.
     *
     * @param msg The detail message for the exception.
     */
	public NotFoundException(String msg)
	{
		super(msg);
	}
}
