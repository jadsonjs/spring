/*
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 *
 * spring-security
 * br.com.jadson.springsecurity.controller
 * ContaController
 * 27/05/21
 */
package br.com.jadson.springsecurity.controller;

import br.com.jadson.springsecurity.model.Conta;
import br.com.jadson.springsecurity.model.Papel;
import br.com.jadson.springsecurity.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * Jadson Santos - jadsonjs@gmail.com
 */
@Controller
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaRepository contaRepository;

    /**
     * List All Conta
     * @param model
     * @param ra
     * @param session
     * @param request
     * @return
     */
    @GetMapping(value= {"/all"})
    public ModelAndView listAll(Model model, RedirectAttributes ra, HttpSession session, HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView("/conta/list");

        List<Conta> contas = contaRepository.findAll();
        modelAndView.addObject("contas", contas);

        return modelAndView;  /// forward para pagina /conta/list.html
    }

    /**
     * acessar a url localhost:8080/conta/pre-create
     * @return
     */
    @GetMapping("/pre-create")
    public String register() {
        return "/conta/create";   /// forward para pagina /conta/create.html
    }

    @PreAuthorize("hasRole('GERENTE')")
    @PostMapping(value= {"/save"})
    public ModelAndView save(Conta conta, BindingResult br, HttpSession session, HttpServletRequest request, RedirectAttributes ra){


        if (request.isUserInRole(Papel.GERENTE.toString())) {
            System.out.println("GERENTE");
        }

        System.out.println("$$SALDO:"+conta.getSaldo());
        System.out.println("$$NUMERO:"+conta.getNumero());
        System.out.println("NOME:"+conta.getNome());

        // redirect para end point /conta/all
        ModelAndView modelAndView = new ModelAndView( new RedirectView("all", true) );

        try {
            conta = contaRepository.save(conta);
            modelAndView.addObject("conta", conta);

        } catch (Exception ne) {
            modelAndView = new ModelAndView(new RedirectView("/error", true));

        }

        return modelAndView;
    }

}
