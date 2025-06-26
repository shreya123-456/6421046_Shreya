package com.example.JuintDemo;

public class MyService {
	private ExternalAPI api;
	public MyService(ExternalAPI api) {
		this.api=api;
	}
	public String fetchData() {
		return api.getData();
	}
}
