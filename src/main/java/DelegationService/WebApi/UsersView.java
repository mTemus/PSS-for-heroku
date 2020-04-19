package DelegationService.WebApi;

import DelegationService.Model.User;
import DelegationService.Service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@CssImport("./shared-styles.css")
@Route(value="users", layout = MainView.class)
@PageTitle("Users | DIET APP")
public class UsersView extends VerticalLayout {
    @Autowired
    UserService userService;

    private final UserForm form;
    private User user;
    private Label userID=new Label();
    private Label userName = new Label();
    private Label userLastName = new Label();
    private Label userEmail = new Label();
    private Label userCompanyName = new Label();
    private Label userCompanyAddress = new Label();
    private Label userCompanyNIP = new Label();
    private Button modifyUser = new Button("Modify user");

    public UsersView(UserService userService){
        this.userService = userService;
        addClassName("userData-view");
        setSizeFull();

        user = userService.finndUserByEmail(currentUser());
        initializeFields();

        form = new UserForm();
        form.setVisible(false);
        form.addListener(UserForm.ModifyEvent.class, this::modifyUser);
        form.addListener(UserForm.CloseEvent.class, e -> closeEditor());
        modifyUser.addClickListener(actionEvent -> form.setVisible(true));
        Div content = new Div(new VerticalLayout(userID, userName, userLastName, userEmail, userCompanyName, userCompanyAddress, userCompanyNIP, modifyUser), form);
        add(content);
    }

    private void initializeFields() {
        userID.setText("ID: " + user.getIduser());
        userName.setText("Name: " + user.getName());
        userLastName.setText("Last Name: " + user.getLastName());
        userEmail.setText("Email: " + user.getEmail());
        userCompanyName.setText("Company Name: " + user.getCompanyName());
        userCompanyAddress.setText("Company Address: " + user.getCompanyAddress());
        userCompanyNIP.setText("Company Nip: " + user.getCompanyNip());
    }

    private void modifyUser(UserForm.ModifyEvent usr){
        userService.registerUser(usr.getUser());
    }

    private void closeEditor() {
        form.setUser(null);
        form.setVisible(false);
        removeClassName("editing");
    }

    public String currentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentName = authentication.getName();
        return currentName;
    }

}
