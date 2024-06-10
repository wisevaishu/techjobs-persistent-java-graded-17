package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired //automatic dependency injection
    private SkillRepository skillRepository;

   @GetMapping("/")
    public String index(Model model){
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                         Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:/skills/";
    }

//    @GetMapping("view/{skillId}") // live page
//    public String displayViewEmployer(Model model, @PathVariable int skillId) {
//
//        Optional<Skill> optSkill = skillRepository.findById(skillId);
//        if (optSkill.isPresent()) {
//            Skill skill = (Skill) optSkill.get();
//            model.addAttribute("skill", skill);
//            return "skills/view";
//        } else {
//            return "redirect:../";
//        }
//
//    }

    @GetMapping("view/{skillId}") // live page
    public String displayViewSkill(Model model, @PathVariable int skillId) {
        Optional<Skill> optSkill = skillRepository.findById(skillId);
        if (optSkill.isPresent()) {
            Skill skill = optSkill.get();
            model.addAttribute("skill", skill);
            return "skills/view"; // Assuming "skills/view" is the correct view name
        } else {
            return "redirect:/skills"; // Redirect to the skills index if the skill is not found
        }
    }
}
