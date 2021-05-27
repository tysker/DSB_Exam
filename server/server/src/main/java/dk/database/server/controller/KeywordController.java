package dk.database.server.controller;

import dk.database.server.entities.Keyword;
import dk.database.server.entities.Stock;
import dk.database.server.entities.User;
import dk.database.server.service.KeywordServiceImpl;
import dk.database.server.service.StockServiceImpl;
import dk.database.server.service.interfaces.KeywordService;
import dk.database.server.service.interfaces.StockService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Map;

@Path("/keywords")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KeywordController {

    KeywordService service = new KeywordServiceImpl();

    @Path("/")
    @GET
    public Response getAllUsers() throws SQLException, ClassNotFoundException {
        Map<Integer, Keyword> users = service.getAllKeywords();
        return Response.status(Response.Status.OK)
                .entity(users)
                .build();
    }
}
