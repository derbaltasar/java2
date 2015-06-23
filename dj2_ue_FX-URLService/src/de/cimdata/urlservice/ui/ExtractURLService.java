package de.cimdata.urlservice.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ExtractURLService extends Service<List<String>> {
	
	private String sourcecode; 
	private final String URL_PATTERN ="((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
	

	public ExtractURLService(String sourcecode) {
	
		this.sourcecode = sourcecode;
	}

	@Override
	protected Task<List<String>> createTask() {
		Task<List<String>> task = new Task<List<String>>() {
			@Override
			protected List<String> call() throws Exception {
				return extractUrls(sourcecode);
			}
		};
		
		return task;
	}
	
	private List<String> extractUrls(String value) {
		List<String> result = new ArrayList<String>();
		Pattern p = Pattern.compile(URL_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(value);
		while (m.find()) {
			result.add(value.substring(m.start(0), m.end(0)));
		}
		return result;
	}


	public String getSourcecode() {
		return sourcecode;
	}


	public void setSourcecode(String sourcecode) {
		this.sourcecode = sourcecode;
	}

}
