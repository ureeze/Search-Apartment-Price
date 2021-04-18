package com.example.corona.PBJ.controller;

import com.example.corona.PBJ.VO.Apartment;
import com.example.corona.PBJ.VO.Option;
import com.example.corona.PBJ.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/apart")
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    BoardService boardService;

    @GetMapping("/refresh")
    public String getRefresh(Model model) {
        List<Apartment> apartlist = boardService.dbRefreshService();
        model.addAttribute("apartlist", apartlist);
        model.addAttribute("option", new Option());
        return "main";
    }

    @GetMapping("/list")
    public String getApartList(Model model) {
        List<Apartment> apartlist = boardService.dbLoadService();

        model.addAttribute("apartlist", apartlist);
        model.addAttribute("option", new Option());
        return "main";
    }

    @PostMapping("/time")
    public String postTime(@ModelAttribute("option") @Valid Option option, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "main";
        }

        List<Apartment> apartlist = boardService.optionService(option);
        model.addAttribute("apartlist", apartlist);
        return "main";
    }
}
