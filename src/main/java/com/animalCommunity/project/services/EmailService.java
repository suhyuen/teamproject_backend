package com.animalCommunity.project.services;

import com.animalCommunity.project.dtos.EmailDto;
import com.animalCommunity.project.mappers.EmailMapper;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class EmailService {
    Map<String, String> verificationCodes = new ConcurrentHashMap<>();
    private final JavaMailSender javaMailSender;
    private final EmailMapper emailMapper;
    private final PasswordEncoder passwordEncoder;

    public EmailService(JavaMailSender javaMailSender, EmailMapper emailMapper, PasswordEncoder passwordEncoder) {
        this.javaMailSender = javaMailSender;
        this.emailMapper = emailMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Async
    public boolean sendMail(EmailDto emailDto){  // 이메일 보내기
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        int certificationNum = ThreadLocalRandom.current().nextInt(100000, 1000000);
        verificationCodes.put("certification", Integer.toString(certificationNum));

        simpleMailMessage.setTo(emailDto.getEmail());
        simpleMailMessage.setSubject("animal 커뮤니티 비밀번호 재설정 메일입니다.");
        simpleMailMessage.setFrom("jaewoomailserver@gmail.com");
        simpleMailMessage.setText("인증메일 : " + verificationCodes.get("certification"));

        try {
            boolean userCheck = emailMapper.userCheck(emailDto);
            if(userCheck == true){
                javaMailSender.send(simpleMailMessage);
                return true;
            }else{
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return false; // 메일 전송이 실패한 경우 false 반환
        }
    }
    public boolean rePassword (EmailDto emailDto){  // 이메일 재설정
        String code = verificationCodes.get("certification");

        if(Objects.equals(code, emailDto.getCode())){
                emailDto.setNewPassword(passwordEncoder.encode(emailDto.getNewPassword()));
                emailMapper.rePassword(emailDto);
                verificationCodes.put("certification", "");
                return true;
        }else{
            return false;
        }
    }
}
