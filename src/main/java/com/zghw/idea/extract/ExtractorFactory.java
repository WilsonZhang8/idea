package com.zghw.idea.extract;

public class ExtractorFactory {

	public static Extractor create() {
		return new DefaultExtractor();
	}
}
