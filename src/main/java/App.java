import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class App {
    public static void main(String[] args) {


        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/home.vtl" );
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squadform", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/squadform.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String squadname = request.queryParams("squadname");
            String squadcause = request.queryParams("squadcause");
            String membernumber = request.queryParams("membernumber");
            model.put("squadname", squadname);
            model.put("squadcause", squadcause);
            model.put("membernumber", membernumber);
            model.put("template", "templates/squadteam.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/heroform", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/heroform.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String squadname = request.queryParams("squadname");
            String squadcause = request.queryParams("squadcause");
            String membernumber = request.queryParams("membernumber");
            model.put("squadname", squadname);
            model.put("squadcause", squadcause);
            model.put("membernumber", membernumber);
            model.put("template", "templates/squadteam.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}