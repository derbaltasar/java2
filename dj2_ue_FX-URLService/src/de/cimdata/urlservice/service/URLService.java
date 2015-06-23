package de.cimdata.urlservice.service;

import java.net.URL;
import java.util.Scanner;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class URLService extends Service<String> {

	private String urlString;

	
	public URLService() {
	}
	public URLService(String urlString) {
		this.urlString = urlString;
	}

	@Override
	protected Task<String> createTask() {
		Task<String> task = new Task<String>() {
			@Override
			protected String call() throws Exception {
				updateMessage("call...");
				int count=0;
				final int MAX =500;
				
				URL url = new URL(getUrlString());
				StringBuilder sb = new StringBuilder();
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNextLine()) {
					sb.append(sc.nextLine());
					updateProgress(count, MAX);
					count++;
				}
				updateProgress(MAX, MAX);
				updateMessage("finish...");
				sc.close();
				return sb.toString();
			}
		};
		return task;
	}

	public String getUrlString() {
		return urlString;
	}

	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}

}
