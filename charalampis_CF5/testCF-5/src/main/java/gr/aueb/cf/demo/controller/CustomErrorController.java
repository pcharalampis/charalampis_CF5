package gr.aueb.cf.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Controller to handle custom error pages for different HTTP error statuses.
 */
@Controller
public class CustomErrorController implements ErrorController {

    /**
     * Handles errors based on the HTTP status code and redirects to corresponding error pages.
     * @param request the HTTP servlet request containing error attributes
     * @return the view name for the error page based on the status code
     */
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == HttpStatus.FORBIDDEN.value()) {
                return "public/errorforbidden";
            }
        }
        return "public/errorpage";
    }

    /**
     * Returns the path for which this controller handles errors.
     * @return the error path
     */
    public String getErrorPath() {
        return "/error";
    }
}
