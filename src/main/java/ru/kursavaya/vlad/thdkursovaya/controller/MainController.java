package ru.kursavaya.vlad.thdkursovaya.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kursavaya.vlad.thdkursovaya.model.*;
import ru.kursavaya.vlad.thdkursovaya.service.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class MainController {
    private final BelongTeachDepService belongTeachDepService;
    private final BelongDisSpecService belongDisSpecService;
    private final DepartamentsService departamentsService;
    private final DisciplineService disciplineService;
    private final LeadsService leadsService;
    private final LiteratureService literatureService;
    private final PlanOfWorkService planOfWorkService;
    private final PublishService publishService;
    private final SpecialityService specialityService;
    private final TeachersService teachersService;

    public MainController(BelongTeachDepService belongTeachDepService, BelongDisSpecService belongDisSpecService, DepartamentsService departamentsService, DisciplineService disciplineService, LeadsService leadsService, LiteratureService literatureService, PlanOfWorkService planOfWorkService, PublishService publishService, SpecialityService specialityService, TeachersService teachersService) {
        this.belongTeachDepService = belongTeachDepService;
        this.belongDisSpecService = belongDisSpecService;
        this.departamentsService = departamentsService;
        this.disciplineService = disciplineService;
        this.leadsService = leadsService;
        this.literatureService = literatureService;
        this.planOfWorkService = planOfWorkService;
        this.publishService = publishService;
        this.specialityService = specialityService;
        this.teachersService = teachersService;
    }

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/teachers")
    public String teacherTable(Model model) {
        model.addAttribute("listTeachers", teachersService.getAll());
        return "Teachers";
    }

    @GetMapping("/speciality")
    public String specialityTable(Model model) {
        model.addAttribute("listSpeciality", specialityService.getAll());
        return "Speciality";
    }

    @GetMapping("/planOfWork")
    public String planOfWorkTable(Model model) {
        model.addAttribute("listPlanOfWork", planOfWorkService.getAll());
        return "PlanOfWork";
    }

    @GetMapping("/literature")
    public String literatureTable(Model model) {
        model.addAttribute("listLiterature", literatureService.getAll());
        return "Literature";
    }

    @GetMapping("/discipline")
    public String disciplineTable(Model model) {
        model.addAttribute("listDiscipline", disciplineService.getAll());
        return "Discipline";
    }

    @GetMapping("/departaments")
    public String departamentTable(Model model) {
        model.addAttribute("listDepartaments", departamentsService.getAll());
        return "Departaments";
    }

    @PostMapping("/createTeachers")
    public String createTeachers(@ModelAttribute Teachers teachers,
                                 @RequestParam(value = "departmentIds", required = false) List<Integer> departmentIds,
                                 @RequestParam(value = "disciplineIds", required = false) List<Integer> disciplineIds) {
        // Если указаны кафедры, обработайте их и сохраните в объекте преподавателя
        if (departmentIds != null && !departmentIds.isEmpty()) {
            Set<Departaments> departaments = new HashSet<>();
            for (Integer departmentId : departmentIds) {
                Departaments department = departamentsService.getDepartaments(departmentId);
                departaments.add(department);
            }
            teachers.setDepartaments(departaments);
        }

        // Если указаны дисциплины, обработайте их и сохраните в объекте преподавателя
        if (disciplineIds != null && !disciplineIds.isEmpty()) {
            Set<Discipline> disciplines = new HashSet<>();
            for (Integer disciplineId : disciplineIds) {
                Discipline discipline = disciplineService.getDiscipline(disciplineId);
                disciplines.add(discipline);
            }
            teachers.setDiscipline(disciplines);
        }

        teachersService.create(teachers);
        return "redirect:/teachers";
    }


    @PostMapping("/createSpeciality")
    public String createSpeciality(@ModelAttribute Speciality speciality, @RequestParam(value = "disciplineIds", required = false) List<Integer> disciplineIds) {
        // Если указаны дисциплины, обработайте их и сохраните в объекте специальности
        if (disciplineIds != null && !disciplineIds.isEmpty()) {
            Set<Discipline> disciplines = new HashSet<>();
            for (Integer disciplineId : disciplineIds) {
                Discipline discipline = disciplineService.getDiscipline(disciplineId);
                disciplines.add(discipline);
            }
            speciality.setDiscipline(disciplines);
        }

        specialityService.create(speciality);
        return "redirect:/speciality";
    }



    @PostMapping("/createPlanOfWork")
    public String createPlanOfWork(@ModelAttribute PlanOfWork planOfWork) {
        planOfWorkService.create(planOfWork);
        return "redirect:/planOfWork";
    }

    @PostMapping("/createLiterature")
    public String createLiterature(@ModelAttribute Literature literature) {
        literatureService.create(literature);
        return "redirect:/literature";
    }

    @PostMapping("/createDiscipline")
    public String createDiscipline(@ModelAttribute Discipline discipline) {
        disciplineService.create(discipline);
        return "redirect:/discipline";
    }

    @PostMapping("/createDepartaments")
    public String createDepartaments(@ModelAttribute Departaments departaments) {
        departamentsService.create(departaments);
        return "redirect:/departaments";
    }

    @PostMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable int id) {
        teachersService.deleteTeachers(id);
        return "redirect:/teachers";
    }

    @PostMapping("/speciality/delete/{id}")
    public String deleteSpeciality(@PathVariable int id) {
        specialityService.deleteSpeciality(id);
        return "redirect:/speciality";
    }

    @PostMapping("/planOfWork/delete/{id}")
    public String deletePlanOfWork(@PathVariable int id) {
        planOfWorkService.deletePlanOfWork(id);
        return "redirect:/planOfWork";
    }

    @PostMapping("/literature/delete/{id}")
    public String deleteLiterature(@PathVariable int id) {
        literatureService.deleteLiterature(id);
        return "redirect:/literature";
    }

    @PostMapping("/discipline/delete/{id}")
    public String deleteDiscipline(@PathVariable int id) {
        disciplineService.deleteDiscipline(id);
        return "redirect:/discipline";
    }

    @PostMapping("/departament/delete/{id}")
    public String deleteDepatament(@PathVariable int id) {
        departamentsService.deleteDepartaments(id);
        return "redirect:/departaments";
    }







}
