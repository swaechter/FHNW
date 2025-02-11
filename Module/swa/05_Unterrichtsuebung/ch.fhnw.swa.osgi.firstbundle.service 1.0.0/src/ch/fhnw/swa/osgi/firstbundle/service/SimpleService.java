package ch.fhnw.swa.osgi.firstbundle.service;

import ch.fhnw.swa.osgi.firstbundle.service.internal.ServiceIdHolder;

public class SimpleService {

	private final ServiceIdHolder serviceidholder;

	public SimpleService() {
		this.serviceidholder = new ServiceIdHolder();
	}

	public void writeString(String message) {
		System.out.println(message + ": " + serviceidholder.getServiceId());
	}
}
