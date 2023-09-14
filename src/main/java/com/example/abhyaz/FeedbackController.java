package com.example.abhyaz;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/feedback")
@CrossOrigin(origins = "https://feedback-form-esrf.onrender.com")
public class FeedbackController {
    private final FeedbackService feedbackService;

    @PostMapping("/save")
    public ResponseEntity<?> saveFeedback(@RequestBody FeedbackDto feedbackDto){
        return new ResponseEntity<>(feedbackService.saveFeedback(feedbackDto), HttpStatus.OK);
    }
}
