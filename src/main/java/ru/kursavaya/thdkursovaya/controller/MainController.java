package ru.kursavaya.thdkursovaya.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.kursavaya.thdkursovaya.service.*;

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
}
