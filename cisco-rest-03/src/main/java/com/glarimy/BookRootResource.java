package com.glarimy;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/library")
public class BookRootResource {
	@POST
	@Path("/tech//book")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBook(Book book) {
		System.out.println("Added book: " + book);
		return Response.ok().entity(book).build();
	}

	@GET
	@Path("/tech/book")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBook(@QueryParam("isbn") int isbn) {
		Book book = new Book();
		book.setIsbn(isbn);
		book.setTitle("Title: " + isbn);
		return Response.ok().entity(book).build();
	}
}
