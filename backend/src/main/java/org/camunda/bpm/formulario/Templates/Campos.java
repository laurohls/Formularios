package org.camunda.bpm.formulario.Templates;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Campos {
    
    

    public String Input(String id,String label, String nome, String tipo, Map<String, String> attr){
        String extrasAttr = "";

        for (Map.Entry<String, String> entry : attr.entrySet()) {
            extrasAttr += " "+entry.getKey() + "='" + entry.getValue()+"' ";
        }
        
        return ""+
        "<div class=\"form-group\">"+
        "   <label for=\""+id+"\">"+label+"</label>"+
        "   <input type=\"text\" class=\"form-control\" id=\""+id+"\""+
        extrasAttr+" />"+
        "</div>";
    }
}