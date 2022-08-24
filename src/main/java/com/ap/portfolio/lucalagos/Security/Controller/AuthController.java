package com.ap.portfolio.lucalagos.Security.Controller;

import com.ap.portfolio.lucalagos.Security.DTO.JwtDTO;
import com.ap.portfolio.lucalagos.Security.DTO.UserLogin;
import com.ap.portfolio.lucalagos.Security.DTO.UserRegister;
import com.ap.portfolio.lucalagos.Security.Entity.Role;
import com.ap.portfolio.lucalagos.Security.Entity.UserCommon;
import com.ap.portfolio.lucalagos.Security.Enums.RoleName;
import com.ap.portfolio.lucalagos.Security.Jwt.JwtProvider;
import com.ap.portfolio.lucalagos.Security.Service.RoleService;
import com.ap.portfolio.lucalagos.Security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://frontend-port-ap-luca-lagos.web.app")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<?> Register(@Valid @RequestBody UserRegister userRegister, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Message("Campos erróneos o email inválido"), HttpStatus.BAD_REQUEST);
        }
        if(userService.ExistsByUserName(userRegister.getUser_name())){
            return new ResponseEntity(new Message("El nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(userService.ExistsByEmail(userRegister.getEmail())){
            return new ResponseEntity(new Message("El email ya existe"), HttpStatus.BAD_REQUEST);
        }

        UserCommon userCommon = new UserCommon(userRegister.getName(), userRegister.getUser_name(), userRegister.getEmail(), passwordEncoder.encode(userRegister.getPassword()));

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.GetByRoleName(RoleName.ROLE_USER).get());

        if(userRegister.getRoles().contains("admin")){
            roles.add(roleService.GetByRoleName(RoleName.ROLE_ADMIN).get());
        }

        userCommon.setRoles(roles);
        userService.SaveUser(userCommon);
        return new ResponseEntity(new Message("Usuario registrado con éxito"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> Login(@Valid @RequestBody UserLogin userLogin, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Message("Campos erróneos"), HttpStatus.BAD_REQUEST);
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getEmail(), userLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String Jwt = jwtProvider.GenerateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDTO jwtDTO = new JwtDTO(Jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    }
}
