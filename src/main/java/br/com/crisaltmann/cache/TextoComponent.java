package br.com.crisaltmann.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@CacheConfig(cacheNames = "general")
public class TextoComponent {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestExample.class);
	
	private Integer cont = 0;
	
	@Cacheable(key = "#texto")
	public String getTextoCache(String texto) {
		LOGGER.error("metodo");
		return cont++ + texto;
	}
	
	@CacheEvict
	public void remove(String texto) {
		LOGGER.error("remove");
	}
	
	@CacheEvict(allEntries = true)
	public void removeAll() {
		LOGGER.error("remove");
	}
}
