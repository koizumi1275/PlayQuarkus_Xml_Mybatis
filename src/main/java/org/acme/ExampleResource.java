package org.acme;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fmm.mapper.UserMapper;
import com.fmm.vo.UserVo;

@Path("/mybatis")
public class ExampleResource {

//	@Inject
//	UserDao userDao;
	
	@Inject
	UserMapper userMapper;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasyxxxx";
    }
    
    @Path("/user/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserVo getUser(@PathParam("id") Integer id) {
        return userMapper.getUser(id);
    }

    @Path("/user")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Integer createUser(@FormParam("id") Integer id, @FormParam("name") String name) {
        return userMapper.createUser(id, name);
    }
}