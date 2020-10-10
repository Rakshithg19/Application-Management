package raksh.app.project.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PageResolver {
	public PageResolver() {
		log.info("created /t" + this.getClass().getSimpleName());
	}

	@RequestMapping("/")
	public static String indexPage() {
		log.info("invoking indexpage()");
		return "index";
	}
}

