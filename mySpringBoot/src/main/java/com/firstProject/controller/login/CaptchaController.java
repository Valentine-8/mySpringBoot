package com.firstProject.controller.login;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Properties;
import static com.google.code.kaptcha.Constants.*;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {
    @Resource(name = "captchaProducer")
    private Producer captchaProducer;
 @GetMapping("/captchaImage")
    public ModelAndView getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletOutputStream out = null;
         HttpSession session = request.getSession();
         response.setDateHeader("Expires", 0);
         response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
         response.addHeader("Cache-Control", "post-check=0, pre-check=0");
         response.setHeader("Pragma", "no-cache");
         response.setContentType("image/jpeg");

         String type = request.getParameter("type");
         String capStr = null;
         String code = null;
         BufferedImage bi = null;
         capStr = code = captchaProducer.createText();
         bi = captchaProducer.createImage(capStr);
         session.setAttribute(Constants.KAPTCHA_SESSION_KEY, code);
         out = response.getOutputStream();
         ImageIO.write(bi, "jpg", out);
         out.flush();
        System.out.println(">>>>???");
        return null;
    }


}
