package com.example.action;

import com.example.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class RedirectAction {

    @RequestMapping("/redirectcase05")
    public String redirectcase05(RedirectAttributes model) {

        Person p = new Person("yzl", 29);
        model.addFlashAttribute("p", p);
        model.addAttribute("name", "yzl");
        String location = "/receiveCase05";
        return "redirect:/receiveCase05";
        //return new ModelAndView(new RedirectView(location));
    }

    @RequestMapping("/receiveCase05")
    @ResponseBody
    public String receiveCase05(@ModelAttribute("name") String name, @ModelAttribute("p") Person p) {

        System.out.println(name);
        System.out.println(p.toString());

        return "hello world";
    }

    @RequestMapping("/redirectcase04")
    public ModelAndView redirectcase04() {
        String location = "/receiveCase04?name=test";
        return new ModelAndView(new RedirectView(location));
    }

    @RequestMapping("/receiveCase04")
    @ResponseBody
    public String receiveCase04(String name) {
        return name;
    }

    @RequestMapping("/redirectcase03")
    public void redirectcase03(HttpServletResponse response) {
        try{
            response.sendRedirect("https://www.baidu.com");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 这里不生效的原因是因为这个类被标注了@RestController,里面还有一个@ResponseBody
     * @return
     */
    @RequestMapping("/redirectcase02")
    public String redirectcase02() {
        return "redirect:https://www.baidu.com";
    }

    @RequestMapping("/redirectcase01")
    public ModelAndView redirectcase01() {
        return new ModelAndView(new RedirectView("https://www.baidu.com"));
    }
}
