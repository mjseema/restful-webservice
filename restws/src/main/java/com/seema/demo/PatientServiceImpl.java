package com.seema.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.seema.demo.exception.PatientBusinessException;
import com.seema.demo.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	Map<Long, Patient> patients = new HashMap<>();
	long currentId = 123;

	public PatientServiceImpl() {
		init();
	}

	void init() {

		Patient patient = new Patient();
		patient.setId(currentId);
		patient.setName("John");
		patients.put(patient.getId(), patient);
	}

	@Override
	public List<Patient> getPatients() {
		Collection<Patient> result = patients.values();
		ArrayList<Patient> response = new ArrayList<>(result);
		return response;
	}

	@Override
	public Patient getPatient(long id) {

		if (patients.get(id) == null) {
			// throw new WebApplicationException(Response.Status.NOT_FOUND);
			throw new NotFoundException();
		}
		return patients.get(id);

	}

	@Override
	public Response addPatient(Patient patient) {
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response updatePatient(Patient patient) {

		Patient currentPatient = patients.get(patient.getId());
		Response response;

		if (currentPatient != null) {
			patients.put(patient.getId(), patient);
			response = Response.ok().build();
		} else {
			throw new PatientBusinessException();
		}
		return response;

	}

	@Override
	public Response deletePatient(long id) {

		Patient patient = patients.get(id);
		Response response;

		if (patient != null) {
			patients.remove(patient.getId());
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();

		}

		return response;
	}

}
