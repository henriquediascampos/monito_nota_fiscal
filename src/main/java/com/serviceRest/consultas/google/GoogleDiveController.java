package com.serviceRest.consultas.google;

import org.springframework.stereotype.Controller;

@Controller
public class GoogleDiveController {
    // private static Logger log = LoggerFactory.getLogger(GoogleDiveController.class);

    // private String url = "https://www.googleapis.com/auth/drive.appfolder";
    // private String urlgit = "https://api.github.com/users/henriquediascampos";

    // @GetMapping(path = "/auth")
    // public @ResponseBody String getAuth() {
    //     RestTemplate restTemplate = new RestTemplate();
    //     HashMap<String, String> quote = restTemplate.getForObject(urlgit, HashMap.class);
    //     String jsonStr = "";
    //     try {
    //         ObjectMapper Obj = new ObjectMapper();
    //         jsonStr = Obj.writeValueAsString(quote);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }

    //     log.info(quote.toString());
    //     return jsonStr;
    // }
}