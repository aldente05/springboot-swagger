package aldente.springboot.swagger.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Modified by f.putra on 03/01/18.
 */

public class BaseController implements ErrorController {
    /**
     * Converting entity object to json value with specific format
     *
     * @param data
     * @param status
     * @return
     */
    public ResponseEntity<?> getCallBack(Exception data, HttpStatus status) {
        data.printStackTrace();
        Map<String, Object> model = new HashMap<>();
        model.put("data", data.getMessage());
        model.put("status", status);
        return new ResponseEntity<>(model, status);
    }

    public ResponseEntity<?> getCallBack(Object data, HttpStatus status) {
        Map<String, Object> model = new HashMap<>();
        model.put("data", data);
        model.put("status", status);
        return new ResponseEntity<>(model, status);
    }

    public Map<String, Object> getCallBack(Object data, Object rows, Object status) {
        Map<String, Object> model = new HashMap<>();
        model.put("data", data);
        model.put("rows", rows);
        model.put("status", status);
        return model;
    }

    /**
     * @param data
     * @return
     */
    public Map<String, Object> getCallBack(Object data) {
        Map<String, Object> model = new HashMap<>();
        model.put("data", data);
        return model;
    }

    /**
     * Converting entity object to json value with specific format
     *
     * @param status
     * @return
     */
    public Map<String, Object> getCallBack(String status) {
        Map<String, Object> model = new HashMap<>();
        model.put("status", status);
        return model;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
