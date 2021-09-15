package melih.hrms.api.controllers;

import melih.hrms.business.abstracts.UserService;
import melih.hrms.core.utilities.results.DataResult;
import melih.hrms.core.utilities.results.ErrorDataResult;
import melih.hrms.core.utilities.results.Result;
import melih.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService){
        super();
        this.userService=userService;
    }

    @PostMapping(value="/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user) {

        return ResponseEntity.ok(this.userService.add(user)) ;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getUserByEmail")
    public DataResult<User> getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }

}