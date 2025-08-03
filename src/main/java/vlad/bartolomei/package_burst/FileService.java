package vlad.bartolomei.package_burst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import vlad.bartolomei.package_burst.utils.HttpUtil;
import vlad.bartolomei.package_burst.utils.OSUtil;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {

    private static final Logger log = LoggerFactory.getLogger(FileService.class);

    public String saveFileToDownloads(MultipartFile file) throws IOException {
        String fileAbsolutePath = OSUtil.getDownloadsPath() + OSUtil.OSSpecificSlash() + file.getOriginalFilename();
        log.info("Saving file to downloads {}", fileAbsolutePath);
        file.transferTo(
                new File(fileAbsolutePath)
        );

        return "Transfer cu succes";
    }

    public String sendFileOverInternet(File file, String destinationIpAddress) {
        RestTemplate restTemplate = new RestTemplate();

        FileSystemResource fileResource = new FileSystemResource(file);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", fileResource);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                HttpUtil.urlSendBuilder(destinationIpAddress),
                requestEntity,
                String.class
        );

        return response.getBody();
    }

}
