package com.example.abhyaz;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    @PostMapping("/save")
    public ResponseEntity<?> saveFeedback(@RequestBody FeedbackDto feedbackDto){
        return new ResponseEntity<>(feedbackService.saveFeedback(feedbackDto), HttpStatus.OK);
    }
}
