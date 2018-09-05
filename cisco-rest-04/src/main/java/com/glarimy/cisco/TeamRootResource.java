package com.glarimy.cisco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/team")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamRootResource {
	static private Map<String, Team> teams = new HashMap<>();

	
	@GET
	@Path("/{name}")
	public Response findTeam(@PathParam("name") String teamName) {
		System.out.println("teamName: " + teamName);
		Team team = teams.get(teamName);
		return Response.ok().entity(team).build();
	}

	@GET
	@Path("/")
	public Response listTeams(@QueryParam("managerName") String managerName) {
		System.out.println("managerName: " + managerName);
		List<Team> results = new ArrayList<>();
		if (managerName != null && managerName.trim().length() > 0) {
			for (Team team : teams.values()) {
				if (team.getManager().equals(managerName)) {
					results.add(team);
				}
			}
		} else {
			results = new ArrayList<>(teams.values());
		}
		Teams teams = new Teams();
		teams.setTeams(results);
		return Response.ok().entity(teams).build();
	}

	@GET
	@Path("/{name}/member")
	public Response listMembers(@PathParam("name") String teamName) {
		System.out.println("teamName for list: " + teamName);
		Team team = teams.get(teamName);
		return Response.ok().entity(team.getMembers()).build();
	}

	@POST
	@Path("/")
	public Response addTeam(Team team) {
		System.out.println("team: " + team);
		teams.put(team.getName(), team);
		return Response.ok().build();
	}
}
