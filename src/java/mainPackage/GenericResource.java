package mainPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    public GenericResource() {
    }

    @GET
    @Path("/{length}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("length") int arrayLength) {
        ArrayList<Integer> array = new ArrayList();
        Random random = new Random();
        
        for(int i=0; i< arrayLength; i++){
            array.add(random.nextInt(4));
        }

        return array.toString();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postJson(String jsonString) {
        Random random = new Random();
        ArrayList<Integer> array = new ArrayList();
        
        String replace = jsonString.replace("[","");
        replace = replace.replace("]","");
        replace = replace.replace(" ","");
        String[] myList = replace.split(",");
        for(int i =0; i<myList.length; i++){
            array.add(Integer.parseInt(myList[i]));
        }
        
        array.add(random.nextInt(4));
        
        return array.toString();
    }
   
}
