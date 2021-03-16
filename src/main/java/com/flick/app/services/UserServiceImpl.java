package com.flick.app.services;

import com.flick.app.models.User;
import com.flick.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    private static final String SECRET = "sup3rS#cre7";
    //    private static final SignatureAlgorithm  SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Map<String, String> login(String userEmail, String password) throws Exception {
        Map<String, String> tokenMap = new HashMap<>();
        if (this.userRepository.existsById(userEmail)) {
            User user = this.userRepository.findByEmailAndPassword(userEmail, password);
            if (user.getEmail().equals(userEmail) && user.getPassword().equals(password)) {
                String token = getToken(user);
                tokenMap.put("access_token", token);
            } else {
                throw new Exception("UserId and password did not match");
            }
        } else {
            throw new Exception("User does not exists");
        }
        return tokenMap;
    }

    @Override
    public Map<String, Boolean> register(User user) throws Exception {
        Map<String, Boolean> map = new HashMap<>();
        if (!userRepository.existsById(user.getEmail())) {
            user.setIsActive(Boolean.TRUE);
            user.setAddedOn(LocalDate.now());
            userRepository.save(user);
            map.put("status", Boolean.TRUE);
        } else {
            throw new Exception("User already registered!");
        }
        return map;
    }

    /**
     * Method to validate the JWT token
     * TODO: Jwts maven dependency has some issue needs to fix!
     * @param token
     * @throws Exception
     */
    @Override
    public void validateToken(String token) throws Exception {
//        try {
//            Jwts.parserBuilder()
//                    .setSigningKey(SECRET)
//                    .build()
//                    .parseClaimsJws(token);
//        } catch (JwtException ex) {
//            throw new Exception("Invalid token");
//        }
        if (!token.equals("test")) {
            throw new Exception("Invalid token");
        }
    }

    private String getToken(User user) {
//        System.out.println(Jwts);
//        return Jwts.builder().setSubject(user.getFirstName())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
//                .signWith(SIGNATURE_ALGORITHM, SECRET).compact();
        return "test";
    }
}
