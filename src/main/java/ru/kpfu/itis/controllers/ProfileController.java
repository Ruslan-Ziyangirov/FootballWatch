package ru.kpfu.itis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dto.FavouriteTeamDto;
import ru.kpfu.itis.entities.FavouriteTeam;
import ru.kpfu.itis.entities.User;
import ru.kpfu.itis.repositories.UserRepository;
import ru.kpfu.itis.security.authectication.CookieAuthentication;
import ru.kpfu.itis.services.UsersService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

@Controller
public class ProfileController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String DEFAULT_PATH_IMAGE = "/resources/image/default.png";
    private Logger logger = Logger.getLogger(ProfileController.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersService usersService;

    @Value("${custom.absolute.file.storage}")
    private String absoluteFilePath;

    @Value("${custom.file.storage}")
    private String filePath;

    private String namePhoto;

    @GetMapping(value = "/profile")
    public ModelAndView getProfilePage(CookieAuthentication authentication) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) authentication.getPrincipal();
        modelAndView.addObject("favouriteTeams", usersService.getFavouriteTeams(user.getId_user()));
        modelAndView.addObject("path", user.getUrl_photo());
        modelAndView.addObject("user", user);
        modelAndView.addObject("oldTeam", usersService.getOldestTeam());
        logger.info(user.toString());
        modelAndView.setViewName("profile");
        logger.info("Profile Page");
        return modelAndView;
    }

    @PostMapping(value = "/uploadFile")
    public ModelAndView uploadFile(@RequestParam MultipartFile file,CookieAuthentication authentication) {
        User user = (User) authentication.getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        namePhoto = file.getOriginalFilename();
        usersService.updatePhoto(namePhoto, user.getId_user());
        try {
            file.transferTo(new File(absoluteFilePath + namePhoto));
            logger.info("Фотография обновилась!");
        } catch (IOException e) {
        }
        modelAndView.setViewName("redirect:/profile");
        return modelAndView;
    }

    @GetMapping("/photo/{filename:.+}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        File file = new File(absoluteFilePath + filename);
        try {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(file.length())
                    .body(resource);
        } catch (FileNotFoundException e) {
            logger.info("BadRequest - фото не удалость получить");
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/profileMatch")
    public ModelAndView addMatch(FavouriteTeamDto favouriteTeamDto){
        System.out.println(favouriteTeamDto);
        ModelAndView modelAndView = new ModelAndView();
        FavouriteTeam favouriteTeam = usersService.addMatch(favouriteTeamDto);
        logger.info(favouriteTeam.toString());
        modelAndView.setViewName("redirect:/profile");
        return modelAndView;

    }

}
