package com.task.transport.controllers;

import com.task.transport.models.Transport;
import com.task.transport.services.TransportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final TransportService transportService;

    public MainController(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping("/")
    public String transports(@RequestParam(name="mark", required = false) String mark,
                             @RequestParam(name="model", required = false) String model,
                             @RequestParam(name="category", required = false) String category,
                             @RequestParam(name="number", required = false) String number,
                             @RequestParam(name="year", required = false) Integer year,
                             Model modelM) {

        if(mark != null && mark.equals("")){
            mark = null;
        }
        if(model != null && model.equals("")){
            model = null;
        }
        if(category != null && category.equals("")){
            category = null;
        }
        if(number != null && number.equals("")){
            number = null;
        }

        modelM.addAttribute("transports", transportService.listTransports(mark, model, category, number, year));
        return "main";
    }

    @GetMapping ("/add")
    public String add(Model model){
        return "add";
    }

    @RequestMapping(value = "/add/create", method = RequestMethod.POST, params = "submit")
    public String submit(Transport transport, Model model) {
        if(!transportService.createTransport(transport))
        {
            model.addAttribute("error", "Такой государственный номер уже существует");
            return "add";
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/add/create", method = RequestMethod.POST, params = "cancel")
    public String cancel() {
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("transport", transportService.getTransportById(id));
        return "edit";
    }

    @RequestMapping(value = "/edit/update", method = RequestMethod.POST, params = "submit")
    public String submit(Transport transport) {
        transportService.changeTransport(transport);
        return "redirect:/";

    }

    @RequestMapping(value = "/edit/update", method = RequestMethod.POST, params = "cancel")
    public String cancelEdit() {
        return "redirect:/";
    }

}
