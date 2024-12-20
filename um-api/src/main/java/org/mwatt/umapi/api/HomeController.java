package org.mwatt.umapi.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/")
    public RedirectView greeting() {
        return new RedirectView("http://localhost/login");
    }
}
