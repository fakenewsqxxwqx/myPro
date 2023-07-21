package com.example.mypro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mypro.bean.user;
import com.example.mypro.dto.request.changePasswordRequest;
import com.example.mypro.dto.request.forgetPasswordRequest;
import com.example.mypro.dto.response.ResponseResult;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.mypro.service.mailService;
import java.util.Date;
import com.example.mypro.mapper.userMapper;
@Service
public class mailServiceImpl implements mailService{
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Autowired
    private userMapper userMapper;

    @Value("${spring.mail.username}")
    private String sendMailer;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private void checkMail(String to,String subject,String text){
        if (to == null || to.isEmpty()) {
            throw new RuntimeException("收件人不能为空");
        }
        if (subject == null || subject.isEmpty()) {
            throw new RuntimeException("主题不能为空");
        }
        if (text == null || text.isEmpty()) {
            throw new RuntimeException("内容不能为空");
        }
    }

    //生成6位随机数
    private String getCheckCode(){
        String checkCode = "";
        for (int i = 0; i < 6; i++) {
            int random = (int)(Math.random()*10);
            checkCode += random;
        }
        return checkCode;
    }



    private void sendTextMailMessage(String to,String text){
        String subject="验证码发送";
        checkMail(to,subject,text);

        try {
            //true 代表支持复杂的类型
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(javaMailSender.createMimeMessage(),true);
            //邮件发信人
            mimeMessageHelper.setFrom(sendMailer);
            //邮件收信人  1或多个
            mimeMessageHelper.setTo(to.split(","));
            //邮件主题
            mimeMessageHelper.setSubject(subject);
            //邮件内容
            mimeMessageHelper.setText(text);
            //邮件发送时间
            mimeMessageHelper.setSentDate(new Date());

            //发送邮件
            javaMailSender.send(mimeMessageHelper.getMimeMessage());
            System.out.println("发送邮件成功："+sendMailer+"->"+to);

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("发送邮件失败："+e.getMessage());
        }
    }


    @Override
    public ResponseResult<?> forgetPassword(forgetPasswordRequest forgetPasswordRequest, HttpSession session) {
        String email = forgetPasswordRequest.getMail();
        String checkCode = getCheckCode();
        String text = "您的验证码为："+checkCode;
        sendTextMailMessage(email,text);
        session.setAttribute("checkCode",checkCode);
        return new ResponseResult<>("验证码发送成功",null);
    }

    @Override
    public ResponseResult<?> changePassword(changePasswordRequest changePasswordRequest, HttpSession session) {
        String checkCode = (String) session.getAttribute("checkCode");
        String email = changePasswordRequest.getMail();
        String newPassword = changePasswordRequest.getPassword();
        String checkCode2 = changePasswordRequest.getCode();
        if(checkCode.equals(checkCode2)){
            //修改密码
            QueryWrapper<user> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("mail",email);

            String uid=userMapper.selectOne(queryWrapper).getId();
            userMapper.updatePassword(uid,passwordEncoder.encode(newPassword));

            return new ResponseResult<>("修改密码成功",null);
        }else{
            return new ResponseResult<>("验证码错误",null);
        }
    }
}
