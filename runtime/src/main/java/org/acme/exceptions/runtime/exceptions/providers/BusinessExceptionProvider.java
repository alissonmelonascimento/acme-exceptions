package org.acme.exceptions.runtime.exceptions.providers;

import org.acme.exceptions.runtime.exceptions.Problem;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionProvider implements ExceptionMapper<org.acme.exceptions.runtime.exceptions.BusinessException>{

    @Override
    public Response toResponse(org.acme.exceptions.runtime.exceptions.BusinessException e) {
        Problem problem = new Problem(e);
        return Response.status(422).entity(problem).type(MediaType.APPLICATION_JSON).build();
    }
    
}
