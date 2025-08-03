package vlad.bartolomei.package_burst;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/control")
public class FileController {

    @Autowired
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/receive")
    public ResponseEntity<String> receive(@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(
                fileService.saveFileToDownloads(file),
                HttpStatus.OK
        );
    }
}
