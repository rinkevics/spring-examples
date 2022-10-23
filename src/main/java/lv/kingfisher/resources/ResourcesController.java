package lv.kingfisher.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
@RequestMapping("resources")
public class ResourcesController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping
    public String get(Model model) {
        var resource = resourceLoader.getResource("classpath:/classpathTest.txt");
        var classpathFile = getContent(resource);

        resource = resourceLoader.getResource("file:C:\\work\\spring-examples\\src\\main\\resources\\filesystemTest.txt");
        var filesystemFile = getContent(resource);
        model.addAttribute("attr", "classpath file: " + classpathFile + "<br/> filesystem file: " + filesystemFile);
        return "test";
    }

    private String getContent(Resource resource) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String read;
            StringBuilder sb = new StringBuilder();

            while ((read=br.readLine()) != null) {
                sb.append(read);
            }
            br.close();
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
