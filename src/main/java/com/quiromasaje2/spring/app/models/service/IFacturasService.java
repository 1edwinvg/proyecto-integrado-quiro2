package com.quiromasaje2.spring.app.models.service;

import java.io.File;
import java.io.InputStream;
import java.util.Locale;

public interface IFacturasService {

	public File getPdfFacturas(Locale locale, Long id) throws Exception;
	
}
