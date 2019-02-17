package ch.fhnw.webfr.flashcard.controller;

import ch.fhnw.webfr.flashcard.domain.Questionnaire;
import ch.fhnw.webfr.flashcard.persistence.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/questionnaires")
public class QuestionnaireController {

    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireController(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    @GetMapping()
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("questionnaires", questionnaireRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showQuestionnaire(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("questionnaire", questionnaireRepository.findById(id).get());
        return modelAndView;
    }

    @GetMapping(params = "form")
    public ModelAndView showCreateQuestionnairForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("questionnaire", new Questionnaire());
        return modelAndView;
    }

    @PostMapping()
    public ModelAndView createQuestionnaire(@Valid Questionnaire questionnaire, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            questionnaireRepository.save(questionnaire);
            return new ModelAndView("redirect:/questionnaires");
        } else {
            return new ModelAndView("create");
        }
    }
}
