package br.com.crisaltmann.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value = "/remove")
	public ResponseEntity<String> removeCache(@RequestParam(value = "key", required = false) String vl) {
		if (vl != null) {
			comp.remove(vl);
		}
		return ResponseEntity.ok("r: " + comp.getTextoCache(vl));
	}
	
	@GetMapping(value = "/removeAll")
	public ResponseEntity<String> removeCacheAll() {
		comp.removeAll();
		return ResponseEntity.ok("remove all");
	}
	
}
