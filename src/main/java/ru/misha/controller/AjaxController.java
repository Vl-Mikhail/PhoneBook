package ru.misha.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.misha.store.StreetImplCRUD;
import ru.misha.store.StreetStorage;

@Controller
public class AjaxController {

    StreetImplCRUD streetCRUD = new StreetStorage();

    @RequestMapping(value = "/streets", method = RequestMethod.GET)
    @ResponseBody
    public String getStreets(@RequestParam(value = "id") Integer id, ModelMap modelMap) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(streetCRUD.findByCity(id));
    }


}
