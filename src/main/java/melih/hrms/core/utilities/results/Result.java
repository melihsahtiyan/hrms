package melih.hrms.core.utilities.results;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Result {
    private boolean success;
    private String message;

    public Result(boolean success){
        this.success=success;
    }

    public Result(boolean success, String message){
        this.success=success;
        this.message=message;
    }
}