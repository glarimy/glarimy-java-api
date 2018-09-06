package com.glarimy.cisco.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.glarimy.cisco.api.Library;
import com.glarimy.cisco.api.exception.LibraryException;
import com.glarimy.cisco.api.model.Book;
import com.glarimy.cisco.service.LibraryService;

@Path("/book")
public class BookRootResource {
	private Library library = new LibraryService();

	@POST
	@Path("/")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response add(Book book) {
		library.add(book);
		try {
			return Response.created(new URI("/" + book.getIsbn())).build();
		} catch (URISyntaxException e) {
			throw new LibraryException();
		}
	}

	@GET
	@Path("/{isbn}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response add(@PathParam("isbn") int isbn) {
		Book book = library.find(isbn);
		return Response.ok().entity(book).build();
	}
}
