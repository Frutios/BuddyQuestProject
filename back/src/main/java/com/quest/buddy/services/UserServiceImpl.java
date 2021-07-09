package com.quest.buddy.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.quest.buddy.dtos.UserDto;
import com.quest.buddy.models.User;
import com.quest.buddy.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ErrorServiceImp errorService;

    @Autowired
    private Validator validator;

    public Set<ConstraintViolation<User>> violations;

    @Override
    public void create(UserDto userDto) {
        User user = userDto.toSource();
        violations = validator.validate(user);
        if (violations.isEmpty()) {
            userRepository.save(user);
        }
    }

    @Override
    public void remove(Long id) {
        if (exist(id)) {
            try {
                userRepository.deleteById(id);
            } catch (Exception e) {
                errorService.AddError("UserRemove", "Error deleting user with id " + id);
            }
        } else {
            errorService.AddError("UserNoExist", "No user with id " + id + " to remove");
        }
    }

    @Override
    public void update(UserDto userDto) {
        User user = findById(userDto.getId()).toSource();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        user.setPseudonym(userDto.getPseudonym());
        user.setDescription(userDto.getDescription());
        try {
            userRepository.save(user);
        } catch (Exception e) {
            errorService.AddError("UserUpdate", "Error updating " + user.getFullName());
        }
    }

    @Override
    public Iterable<UserDto> getAll() {
        Iterable<User> users = null;
        try {
            users = userRepository.findAll();
        } catch (Exception e) {
            errorService.AddError("UserAll", "Error getting users");
        }
        return toListDto(users);
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).get();

        return user.toDto();
    }

    public User findByUserId(Long id) {
        User user = userRepository.findById(id).orElse(null);

        return user;
    }

    public HashMap<String, String> getErrors() {
        return errorService.getErrors();
    }

    public boolean exist(Long id) {

        Optional<User> userExist = null;
        try {
            userExist = userRepository.findById(id);
        } catch (Exception e) {
            errorService.AddError("UserById", "Error while finding user with id " + id);
        }
        if (userExist == null) {
            return false;
        }
        return userExist.isPresent();

    }

    public static Iterable<UserDto> toListDto(Iterable<User> users) {
        List<UserDto> usersDto = StreamSupport.stream(users.spliterator(), false).map(user -> user.toDto())
                .collect(Collectors.toList());

        return usersDto;
    }

}