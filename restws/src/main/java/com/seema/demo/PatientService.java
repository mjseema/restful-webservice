package com.seema.demo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.seema.demo.model.Patient;

@Path("/patientservice")
@Consumes("application/xml , application/json")
@Produces("application/xml , application/json")
public interface PatientService {
	
	@Path("/patients")
	@GET
	List<Patient> getPatients();
	
	@Path("/patients/{id}")
	@GET
	Patient getPatient(@PathParam(value = "id") long id);
	
	@Path("/patients")
	@POST
	Response addPatient(Patient patient);
	
	@Path("/patients")
	@PUT
	Response updatePatient(Patient patient);
	
	@Path("/patients/{id}")
	@DELETE
	Response deletePatient(@PathParam(value = "id") long id);
	
}
