package br.com.crisaltmann.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class RestExample {

	@Autowired
	private TextoComponent comp;
	
	@GetMapping(value = "/{param}")
	public ResponseEntity<String> getTexto(@PathVariable("param") String param) {
		return ResponseEntity.ok("r: " + comp.getTextoCache(param));
	}
	
}
