package by.rabkov.anderson.servlet;

import by.rabkov.anderson.entity.Person;
import by.rabkov.anderson.entity.Quality;
import by.rabkov.anderson.service.PersonService;
import by.rabkov.anderson.service.impl.PersonServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PersonService personService;

    @Override
    public void init() throws ServletException {
        personService = new PersonServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            String action = req.getServletPath();
            switch (action) {
                case "/new":
                    showNewFormForPerson(req, resp);
                    break;
                case "/update":
                    updatePeson(req, resp);
                    break;
                case "/delete":
                    deletePerson(req, resp);
                    break;
                case "/insert":
                    insertPerson(req, resp);
                    break;
                case "/edit":
                    showEditFormForPerson(req, resp);
                    break;
                default:
                    showAllPersons(req, resp);
                    break;
            }
        }catch (SQLException | IOException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void showNewFormForPerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("personForm.jsp");
        requestDispatcher.forward(request, response);
    }

    private void updatePeson (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Person person = personService.findPersonById(id);

        String addedQuality = request.getParameter("addedQuality");
        Quality qualityToAdd = new Quality();
        qualityToAdd.setName(addedQuality);

        String deletedQuality = request.getParameter("deletedQuality");
        Quality qualityToDelete = new Quality();
        qualityToDelete.setName(deletedQuality);

        List<Quality> qualityList = person.getQualityList();
        qualityList.add(qualityToAdd);
        qualityList.remove(qualityToDelete);
        person.setQualityList(qualityList);
        personService.updatePersonById(id);
        response.sendRedirect("personList.jsp");
    }

    private void deletePerson(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        personService.deletePersonById(id);
        response.sendRedirect("personList.jsp");
    }

    private void insertPerson(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String quality = request.getParameter("quality");

        Quality qualityToAdd = new Quality();
        qualityToAdd.setName(quality);
        List<Quality> qualityList = new ArrayList<>();
        qualityList.add(qualityToAdd);

        Person personToAdd = new Person();
        personToAdd.setName(name);
        personToAdd.setQualityList(qualityList);

        personService.addPerson(personToAdd);
        response.sendRedirect("personList.jsp");
    }

    private void showEditFormForPerson(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Person realPerson = personService.findPersonById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editPersonForm.jsp");
        request.setAttribute("person", realPerson);
        requestDispatcher.forward(request, response);
    }

    private void showAllPersons(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Person> personList = personService.findAllPerson();
        request.setAttribute("personList", personList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("personForm.jsp");
        requestDispatcher.forward(request, response);

    }

}
