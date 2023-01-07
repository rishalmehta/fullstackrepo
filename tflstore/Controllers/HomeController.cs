using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using tflstore.Models;
using System.Collections.Generic;
using Employeedata;
using System.IO;
using System.Text.Json;
using System.Text.Json.Serialization;


namespace tflstore.Controllers;

public class HomeController : Controller
{
    public static List<Employee> emplist = new List<Employee>();
    private readonly ILogger<HomeController> _logger;

    public HomeController(ILogger<HomeController> logger)
    {
        Console.WriteLine("Home Controller instance initialized......");
        _logger = logger;
    }

    //Action Methods

    public IActionResult Index()
    {
        Console.WriteLine("Invoking Home Controller index method.. ");
        return View();
    }

    public IActionResult Privacy()
    {
        Console.WriteLine("Invoking Home Controller Privacy method. ");
        return View();
    }

    public IActionResult Login(int empid,string ename)
    {
        Console.WriteLine("Invoking Home Controller Login method. ");
        return View();
    }

       //return Redirect("/Validate");

    public IActionResult Validate(int empid,string ename)

    {

        Console.WriteLine("Validating User credentials.... ");
        Employee tempemp = new Employee(empid);
            Console.WriteLine("outside try body");

        try
        {
            Console.WriteLine("inside try body");
            string fileName = @"E:\rishal\dotnet\Day8\ECommerce\tflstore\Models\storagedata.json";

            //Deserialize from JSON file
            string jsonString = System.IO.File.ReadAllText(fileName);
            emplist = JsonSerializer.Deserialize<List<Employee>>(jsonString);
            Console.WriteLine("\n JSON :Deserializing data from json file\n \n");

            foreach (Employee emp in emplist)
            {
                if (emp.Empid.Equals(tempemp.Empid))
                {
                    return Redirect("/home/Welcome");
                }
                Console.WriteLine("empid = "+emp.Empid+" tempempid = "+tempemp.Empid);
            }

        }
        catch (Exception exp)
        {

        }
        return Redirect("/home");
    }


    public IActionResult Welcome()
    {
        Console.WriteLine("Invoking Home Controller Welcome  method. ");

        return View();
    }

    public IActionResult Register(int empid, string ename, double esal, string deptname)
    {

        // int empid,string ename,double esal,string deptname

        try
        {
            // Employee emp=new Employee(Convert.ToInt32( frm["Empid"]),frm["ename"],Convert.ToDouble((frm["esal"])),frm["Deptname"]);
            // int tempempid=Convert.ToInt32(frm["empid"].ToString());
            // string tempname=frm["ename"].ToString();
            // double tempsal=Convert.ToDouble(frm["esal"].ToString());
            // string deptname=frm["deptname"].ToString();

            Employee emp = new Employee(empid, ename, esal, deptname);
            Console.WriteLine(emp);
            emplist.Add(emp);
            // dynamic data type variable
            var options = new JsonSerializerOptions { IncludeFields = true };
            var employeejson = JsonSerializer.Serialize<List<Employee>>(emplist, options);
            string fileName = @"E:\rishal\dotnet\Day8\ECommerce\tflstore\Models\storagedata.json";

            System.IO.File.WriteAllText(fileName, employeejson);
            Console.WriteLine("added to json file!");
            //Serialize all Flowers into json file

            // File.WriteAllText(fileName,produtsJson);
            // //Deserialize from JSON file
            // string jsonString = File.ReadAllText(fileName);
            // List<Product> jsonFlowers = JsonSerializer.Deserialize<List<Product>>(jsonString);
            // Console.WriteLine("\n JSON :Deserializing data from json file\n \n");
            // foreach( Product flower in jsonFlowers)
            // {
            //     Console.WriteLine($"{flower.Title} : {flower.Description}");   
            // }   
        }
        catch (Exception exp)
        {
            //return View();
        }
        return View();
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
