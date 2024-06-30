package gr.aueb.cf.demo.service;

import gr.aueb.cf.demo.model.User;
import gr.aueb.cf.demo.web.dto.UserRegistrationDTO;

public interface UserService {

	User save(UserRegistrationDTO registrationDTO);
}
