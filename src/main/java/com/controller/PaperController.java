package com.controller;

import com.pojo.Paper;
import com.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private PaperService paperService;

    @RequestMapping("/allPaper")
    public String list(Model model){
        List<Paper> list = paperService.queryAllPaper();
        model.addAttribute("list", list);
        return "allPaper";  //跳转到allpaper页面
    }

    @RequestMapping("/toAddPaper")
    public String toAddPaper(){
        return "addPaper";
    }
    @RequestMapping("/addPaper")
    public String addPaper(Paper paper) {
        paperService.addPaper(paper);
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("/del/{paperId}")
    public String deletePaper(@PathVariable("paperId") Long id) {
        paperService.deletePaper(id);
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("/toUpdatePaper")
    public String toUpdatePaper(Model model, Long id) {
        model.addAttribute("paper", paperService.queryById(id));
        return "updatePaper";
    }

    @RequestMapping("/updatePaper")
    public String updatePaper(Model model, Paper paper) {
        paperService.updatePaper(paper);
        paper = paperService.queryById(paper.getPaperId());
        model.addAttribute("paper", paper);
        return "redirect:/paper/allPaper";
    }

    @RequestMapping(value = "/phone/addPaper",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String phoneaddPaper(@RequestBody String a){
        String header1=request.getHeader("Connection");
        System.out.println(header1);
        System.out.println(a);
        return a;
    }

}
