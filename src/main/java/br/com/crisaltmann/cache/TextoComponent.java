package br.com.crisaltmann.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class TextoComponent {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestExample.class);
	
	private Integer cont = 0;
	
	@Cacheable(cacheNames = "general", key = "#texto")
	public String getTextoCache(String texto) {
		LOGGER.error("metodo");
		return cont++ + texto;
	}
	
}
