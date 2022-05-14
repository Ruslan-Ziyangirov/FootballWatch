package ru.kpfu.itis.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import ru.kpfu.itis.dto.LoginDto;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UserRepository;
import ru.kpfu.itis.security.authectication.CookieAuthentication;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Controller
public class ProfileController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String DEFAULT_PATH_IMAGE = "/resources/image/default.png";

    @Autowired
    private UserRepository userRepository;

    @Value("${custom.absolute.file.storage}")
    private String absoluteFilePath;

    @Value("D:/projectimages/")
    private String filePath;

    private String namePhoto;

    @GetMapping(value = "/profile")
    public ModelAndView getProfilePage(CookieAuthentication authentication) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) authentication.getPrincipal();
        System.out.println(user);
        File directory = new File(absoluteFilePath);
        modelAndView.addObject("path", DEFAULT_PATH_IMAGE);
        File[] files = directory.listFiles();
        System.out.println("МАССИВ ФОТОК!!!!!"+ Arrays.toString(files));
        if(files != null) {
            for(File file: files) {
                System.out.println(file.getName());
                System.out.println(namePhoto);
                if (file.getName().equals(namePhoto)) {
                    System.out.println("ПУТЬ К МОЕЙ ФОТКЕ" + file.getPath());
                    modelAndView.addObject("path", absoluteFilePath+file.getName());
                }
            }
        }
        modelAndView.addObject("user", user);
        modelAndView.setViewName("profile");
        return modelAndView;
    }

    @PostMapping(value = "/uploadFile")
    public ModelAndView uploadFile(@RequestParam MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView();
        namePhoto = file.getOriginalFilename();
        System.out.println(absoluteFilePath+namePhoto);
        try {
            file.transferTo(new File(absoluteFilePath + namePhoto));
        } catch (IOException e) {
        }
        modelAndView.setViewName("redirect:/profile");
        return modelAndView;
    }

//    @GetMapping("/recources/image/{filename:.+}")
//    public ResponseEntity<?> getFile(@PathVariable String filename) {
//        File file = new File(filePath + filename);
//        try {
//            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
//                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                    .contentLength(file.length())
//                    .body(resource);
//        } catch (FileNotFoundException e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }
}
