package com.firstProject.controller.login;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Properties;
import static com.google.code.kaptcha.Constants.*;

@RestController
public class CaptchaController {
    @Resource(name = "captchaProducer")
    private Producer captchaProducer;
    @GetMapping("/captchaImage")
    public AjaxResult getCode
}
