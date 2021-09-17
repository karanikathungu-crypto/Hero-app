package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/",(request, response)->{
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        },new HandlebarsTemplateEngine());

        get("/hero_form",  (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "hero_form.hbs");
        }, new HandlebarsTemplateEngine());
        get("/hero_list", (request, response)->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getAllInstances();
            model.put("hero", hero);
            return new ModelAndView(model, "hero_list.hbs");
        }, new HandlebarsTemplateEngine());

//        get("/new/:id",(req, res) ->{
//            Map<String, Object> model = new HashMap<>();
//            String idOfHero = (req.params(":id"));//gave me error in parsing int changed it to string
//            Hero foundHero = Hero.findById(idOfHero);
//            model.put("hero",foundHero);
//            return new ModelAndView(model, "hero_detailed.hbs");
//        }, new HandlebarsTemplateEngine());

        get("/squad_form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad_form.hbs");
        }, new HandlebarsTemplateEngine());
        get("/squad_list",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("squads",squads);
            ArrayList<Hero> members = Hero.getAllInstances();
            model.put("members",members);
//            ArrayList<Hero> testMember = new Squad().getSquadMembers();

//            model.put("newSquadMember", testMember);
            return new ModelAndView(model, "squad_list.hbs");
        }, new HandlebarsTemplateEngine());

        post("/new/squad_list",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String squadName = req.queryParams("squad-name");
            String size =(req.queryParams("squad-size"));//changed to string
            String cause = req.queryParams("squad-cause");
            Squad userSquad = new Squad(squadName,size,cause,Hero.getAllInstances());
            req.session().attribute("userSquad",squadName);
            model.put("userSquad",req.session().attribute("userSquad"));
            return new ModelAndView(model,"squad_list.hbs");
        }, new HandlebarsTemplateEngine());


//        get("/hero_list", (request, response)->{
//            Map<String, Object> model = new HashMap<String, Object>();
//            int idHero = Integer.parseInt(request.params(":id"));
//            Hero heroFound = Hero.findById(idHero);
//            model.put("hero", heroFound);
//            return new ModelAndView(model, "hero_list.hbs");
//        }, new HandlebarsTemplateEngine());
        post("/new/hero_list", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("hero-name");
            int age = Integer.parseInt(request.queryParams("hero-age"));//changed it to parse int because of error
            String power = request.queryParams("hero-power");
            String weakness = request.queryParams("hero-weakness");
            Hero userHero = new Hero(name, age, power, weakness);
            request.session().attribute("item", userHero);
            model.put("item", request.session().attribute("item"));
            model.put("userHero", userHero);
            return new ModelAndView(model, "hero_list.hbs");
        }, new HandlebarsTemplateEngine());

//        get("/squad/new/:id",(req,res)->{
//            Map<String, Object> model = new HashMap<>();
//            String id= (req.params(":id"));//changed to string
//            Hero newMember = Hero.findById(id);
//            model.put("newMember", newMember.getName());
////            ArrayList<Squad> members = Squad.setUpNewSquad().getSquadMembers();
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//        get("/hero_list", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            String name = request.queryParams("Heroname");
//            request.session().attribute("Heroname");
//
//            int age = Integer.parseInt(request.queryParams("Heroage"));
//            request.session().attribute("Heroname");
//
//            String power = request.queryParams("Heropower");
//            request.session().attribute("Heropower");
//
//            String weakness = request.queryParams("Heroweakness");
//            request.session().attribute("Heroweakness");
//
//            Hero userHero = new Hero(name, age, power, weakness);
//            model.put("userHero", userHero);
//            return new ModelAndView(model, "hero_list.hbs");
//        }, new HandlebarsTemplateEngine());

//        post("/hero_list", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//
//            String name = request.queryParams("Heroname");
//            request.session().attribute("Heroname", name);
//
//            int age = Integer.parseInt(request.queryParams("Heroage"));
//            request.session().attribute("Heroname", name);
//
//            String power = request.queryParams("Heropower");
//            request.session().attribute("Heropower", power);
//
//            String weakness = request.queryParams("Heroweakness");
//            request.session().attribute("Heroweakness", weakness);
//
//            Hero userHero = new Hero(name, age, power, weakness);
//
//            model.put("userHero", userHero);
//            return new ModelAndView(model, "hero_form.hbs");
//         }, new HandleBarsTemplateEngine());


    }

}
