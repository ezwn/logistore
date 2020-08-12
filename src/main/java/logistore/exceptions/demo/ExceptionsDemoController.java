package logistore.exceptions.demo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/exceptions-demo", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExceptionsDemoController {

	@GetMapping("/1")
	public void demo1() {
		throw new RuntimeException();
	}
	
}
