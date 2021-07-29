package com.andreas.filippatos.dreamclassbackend.controllers;

import com.andreas.filippatos.dreamclassbackend.entities.PublicHoliday;
import com.andreas.filippatos.dreamclassbackend.services.PublicHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/publicHolidays")
@Validated
public class PublicHolidayController {

    @Autowired
    private PublicHolidayService publicHolidayService;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public Map<String, String> handleValidationExceptions(Exception ex) {
        Map<String, String> errors = new HashMap<>();
        if (ex instanceof MethodArgumentNotValidException) {
            ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
        }
        if (ex instanceof ConstraintViolationException) {
            ((ConstraintViolationException) ex).getConstraintViolations().forEach((error) ->
                errors.put(error.getRootBean().getClass().getName(), error.getMessage())
            );
        }
        return errors;
    }

    @GetMapping()
    public List<PublicHoliday> getAllPublicHolidays() {
        return publicHolidayService.getAllPublicHolidays();
    }

    @PutMapping()
    public PublicHoliday save(@Valid @RequestBody PublicHoliday publicHoliday) {
        return publicHolidayService.save(publicHoliday);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Min(1) Long id) {
        publicHolidayService.delete(id);
    }

    @PostMapping("/deleteAllById")
    public void deleteAllById(@RequestBody List<Long> ids) {
        publicHolidayService.deleteAllById(ids);
    }
}
