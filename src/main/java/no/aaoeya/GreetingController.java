package no.aaoeya;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final Max6675 max6675 = new Max6675();

    public GreetingController() throws IOException {
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Åøya") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/max6675")
    public Greeting max6675() throws IOException {
        return new Greeting(counter.incrementAndGet(), max6675.getTemperature());
    }

    @RequestMapping("/temp")
    public String temp() throws IOException {
        return pageTemplate
                .replaceFirst("@refresh@", String.valueOf(1))
                .replaceFirst("@count@", String.valueOf(counter.incrementAndGet()))
                .replaceFirst("@temp@", max6675.getTemperature());
    }

    private final String pageTemplate = "<!DOCTYPE html>\n" +
            "<html lang=\"en\"><head><meta charset=\"UTF-8\"/><meta http-equiv=\"refresh\" content=\"@refresh@\" ><title>Temp</title></head><body>" +
            "<table><tbody><tr><th>Temp @count@</th><th>@temp@</th></tr></tbody></table>" +
            "</body></html>";
}
