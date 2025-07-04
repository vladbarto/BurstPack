package vlad.bartolomei.package_burst;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/control")
public class Controller {

    @PostMapping("/receive")
    public ResponseEntity<String> receive(@RequestParam("file") MultipartFile file) throws IOException {
        file.transferTo(new File("/Users/<computer_username>/Downloads/" + file.getName()) );

        return ResponseEntity.ok("Fisier primit de destinatar cu succes!");
    }
}
