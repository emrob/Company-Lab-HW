package controllers;

import db.DBHelper;
import models.Department;
import models.Engineer;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class DepartmentController {

    public DepartmentController(){
        this.setupEndpoints();
    }

    private void setupEndpoints() {
        get("/departments", (req, res) -> {
            Map<String, Object> model = new HashMap();
            List<Department> departments = DBHelper.getAll(Department.class);
            model.put("template", "templates/departments/index.vtl");
            model.put("departments", departments);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

//        get("/departments/new", (req, res)-> {
//            Map<String, Object> model = new HashMap<>();
//            List<Department> departments = DBHelper.getAll(Department.class);
//            model.put("template", "templates/engineers/create.vtl");
//            model.put("departments", departments);
//            return new ModelAndView(model, "templates/layout.vtl");
//        }, new VelocityTemplateEngine());
//
//        post("/engineers", (req, res)-> {
//            int departmentId = Integer.parseInt(req.queryParams("department"));
//            Department department = DBHelper.find(departmentId, Department.class);
//            String firstName = req.queryParams("firstName");
//            String lastName = req.queryParams("lastName");
//            int salary = Integer.parseInt(req.queryParams("salary"));
//            Engineer engineer = new Engineer(firstName, lastName, salary, department);
//            DBHelper.save(engineer);
//            res.redirect("/engineers");
//            return null;
//        }, new VelocityTemplateEngine());

    }
}

