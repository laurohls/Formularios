package org.camunda.bpm.formulario.Resource;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RenderFormController {

    @RequestMapping(value = "/form/{name}", method = RequestMethod.GET)
    public String RenderForm(@PathVariable(value = "name") String name) {
       
        return "server 8080";
    }
}