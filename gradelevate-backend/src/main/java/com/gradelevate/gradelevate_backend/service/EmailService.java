package com.gradelevate.gradelevate_backend.service;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${app.frontend.url}")
    private String frontendUrl;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendPasswordResetEmail(String toEmail,
                                       String token,
                                       String userName) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(
                    message, true, "UTF-8");

            helper.setFrom(fromEmail);
            helper.setTo(toEmail);
            helper.setSubject("Reset your GradElevate password");

            String resetLink = frontendUrl
                    + "/reset-password?token=" + token;

            String html = """
                <div style="font-family: Arial, sans-serif;
                     max-width: 600px; margin: 0 auto;
                     padding: 20px;">

                  <div style="background: linear-gradient(
                       135deg, #4f46e5, #7c3aed);
                       padding: 30px; border-radius: 12px;
                       text-align: center; margin-bottom: 30px;">
                    <h1 style="color: white; margin: 0;
                         font-size: 28px;">GradElevate</h1>
                    <p style="color: #c7d2fe; margin: 8px 0 0;">
                      Career Guidance Platform</p>
                  </div>

                  <h2 style="color: #1f2937;">
                    Hi %s, reset your password</h2>
                  <p style="color: #6b7280; line-height: 1.6;">
                    We received a request to reset your password.
                    Click the button below to create a new one.
                    This link expires in <strong>30 minutes</strong>.
                  </p>

                  <div style="text-align: center;
                       margin: 32px 0;">
                    <a href="%s"
                       style="background: #4f46e5; color: white;
                              padding: 14px 32px;
                              border-radius: 8px;
                              text-decoration: none;
                              font-weight: bold;
                              font-size: 16px;">
                      Reset Password
                    </a>
                  </div>

                  <p style="color: #9ca3af; font-size: 14px;">
                    If you didn't request this, you can safely
                    ignore this email. Your password won't change.
                  </p>

                  <div style="border-top: 1px solid #e5e7eb;
                       margin-top: 30px; padding-top: 20px;
                       text-align: center;">
                    <p style="color: #9ca3af; font-size: 12px;
                         margin: 0;">
                      GradElevate — Elevate your career
                    </p>
                  </div>
                </div>
                """.formatted(userName, resetLink);

            helper.setText(html, true);
            mailSender.send(message);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to send email: " + e.getMessage());
        }
    }
}