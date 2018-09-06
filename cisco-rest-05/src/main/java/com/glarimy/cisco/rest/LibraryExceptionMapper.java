package com.glarimy.cisco.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.glarimy.cisco.api.exception.BookNotFoundException;
import com.glarimy.cisco.api.exception.DuplicateBookException;
import com.glarimy.cisco.api.exception.InvalidBookException;

@Provider
public class LibraryExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		if (exception instanceof InvalidBookException) {
			return Response.status(400).build();
		} else if (exception instanceof DuplicateBookException) {
			return Response.status(401).build();
		} else if (exception instanceof BookNotFoundException) {
			return Response.status(404).build();
		} else {
			return Response.status(500).build();
		}
	}

}
