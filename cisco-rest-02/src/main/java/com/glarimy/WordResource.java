package com.glarimy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/")
public class WordResource {
	@GET
	@Path("/capitalize")
	public Response toUpper(@QueryParam("word") String word) {
		if (word != null && word.trim().length() > 0) {
			String result = word.toUpperCase();
			return Response.ok().entity(result).build();
		} else {
			return Response.status(400).build();
		}

	}
}
