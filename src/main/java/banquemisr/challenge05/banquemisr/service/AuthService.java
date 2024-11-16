package banquemisr.challenge05.banquemisr.service;


import banquemisr.challenge05.banquemisr.dto.LoginDto;
import banquemisr.challenge05.banquemisr.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
