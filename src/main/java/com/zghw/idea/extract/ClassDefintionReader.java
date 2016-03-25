package com.zghw.idea.extract;

import java.io.IOException;

public interface ClassDefintionReader {
	public int loadClassDefinition(ReaderContext readerContext)
			throws IOException;
}
