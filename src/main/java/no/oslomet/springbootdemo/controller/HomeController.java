package no.oslomet.springbootdemo.controller;

import no.oslomet.springbootdemo.model.Building;
import no.oslomet.springbootdemo.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BuildingRepository buildingRepository;


    @GetMapping({"/", "/list"})
    public String list(Model model ){
        List<Building> buildings = buildingRepository.findAll();
        model.addAttribute("buildings", buildings);
        Building building = new Building();
        model.addAttribute("building", building);
        return "index";
    }

    @PostMapping("/saveBuilding")
    public String save(@ModelAttribute("building") Building building ){
        buildingRepository.save(building);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id,Model model ){
        Building building  =this.buildingRepository.findById(Long.parseLong(id)).get();
        List<Building> buildings = buildingRepository.findAll();
        model.addAttribute("building", building );
        model.addAttribute("buildings", buildings );

        return "index";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id,Model model ){
        this.buildingRepository.deleteById(Long.parseLong(id));
        return "redirect:/list";
    }

}

