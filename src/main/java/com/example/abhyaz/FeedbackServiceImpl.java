package com.example.abhyaz;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements FeedbackService{
    private final FeedbackRepository feedbackRepository;

    @Override
    public String saveFeedback(FeedbackDto feedbackDto) {
        feedbackRepository.save(Feedback
                        .builder()
                        .name(feedbackDto.getName())
                        .emailAddress(feedbackDto.getEmailAddress())
                        .subject(feedbackDto.getSubject())
                        .message(feedbackDto.getMessage())
                        .build());
        return "Successful";
    }
}
