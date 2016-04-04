package ru.misha.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.misha.model.City;
import ru.misha.model.Client;
import ru.misha.model.Street;
import ru.misha.store.*;

import java.io.IOException;

@Controller
public class ClientController {

    ClientImplCRUD crud = new ClientStorage();
    CityImplCRUD cityCRUD = new CityStorage();
    StreetImplCRUD streetCRUD = new StreetStorage();

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String show(ModelMap model) {
        model.addAttribute("clients", crud.getAll());
        return "index";
    }

    /*
    Добавление данных пользователю
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@ModelAttribute Client client, ModelMap model) {
        model.addAttribute("cities", cityCRUD.getAll());
        model.addAttribute("streets", streetCRUD.getAll());

        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Client client) {
        client.setCity(new City(client.getCityId()));
        client.setStreet(new Street(client.getStreetId()));
        crud.create(client);
        return "redirect:home";
    }

    /*
    Удаление данных
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String eleteClient(@RequestParam(value = "id") Integer id) {
        crud.delete(id);
        return "redirect:home";

    }

    /*
   Редактирование данных
    */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editClient(@RequestParam(value = "id") Integer id, ModelMap model){
        model.addAttribute("client", crud.getById(id));
        model.addAttribute("cities", cityCRUD.getAll());
        model.addAttribute("streets", streetCRUD.getAll());
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editClient(@ModelAttribute Client client, ModelMap modelMap) {
        client.setCity(new City(client.getCityId()));
        client.setStreet(new Street(client.getStreetId()));
        crud.update(client);
        return "redirect:home";
    }

}
