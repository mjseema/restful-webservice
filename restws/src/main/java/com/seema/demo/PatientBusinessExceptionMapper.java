package com.seema.demo;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.seema.demo.exception.PatientBusinessException;

@Provider
public class PatientBusinessExceptionMapper implements ExceptionMapper<PatientBusinessException> {

	@Override
	public Response toResponse(PatientBusinessException exception) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"Status \": \"Error\"");
		sb.append(",");
		sb.append("\"Message \": \"Resource not found\"");
		sb.append("}");
		
		return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
	}

}
